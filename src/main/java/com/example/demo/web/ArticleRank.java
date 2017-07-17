package com.example.demo.web;

/**
 * Created by niewenlong-work on 2017/5/31.
 */
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ZParams;

import java.util.*;

public class ArticleRank {
    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;//一周之后不可以投票
    private static final int VOTE_SCORE = 1;//投一次432分
    private static final int ARTICLES_PER_PAGE = 25;

    public void run(Jedis conn) {
        //String articleId = postArticle(conn, "jinwenjun", "A title", "http://www.google.com");//发布文章，并且保存分数，和时间，以及文章的投票人
        //System.out.println(articleId);
        String articleId = "1";
        //articleVote(conn, "niewenlong1", "article:" + articleId);//对当前发布的文章：id进行投票
        List<Map<String,String>> articles = getArticles(conn, 1);
        System.out.println(articles);
        addGroups(conn, articleId, new String[]{"programming"});//对文章进行分组
        articles = getGroupArticles(conn, "programming", 1);
        System.out.println(articles);
    }

    public String postArticle(Jedis conn, String user, String title, String link) {
        String articleId = String.valueOf(conn.incr("article:"));//通过原子计数器 每发布一篇新文章出现一个新的id
        String voted = "voted:" + articleId;
        conn.sadd(voted, user);//默认自己投自己一票
        conn.expire(voted, ONE_WEEK_IN_SECONDS);//设置过期时间
        long now = System.currentTimeMillis() / 1000;
        String article = "article:" + articleId;
        HashMap<String,String> articleData = new HashMap<>();
        articleData.put("title", title);
        articleData.put("link", link);
        articleData.put("user", user);
        articleData.put("now", String.valueOf(now));
        articleData.put("votes", "1");
        conn.hmset(article, articleData);
        conn.zadd("score:", VOTE_SCORE, article);
        conn.zadd("time:", now, article);
        return articleId;
    }

    public void articleVote(Jedis conn, String user, String article) {
        //超过七天不允许投票
        long cutoff = (System.currentTimeMillis() / 1000) - ONE_WEEK_IN_SECONDS;
        if (conn.zscore("time:", article) < cutoff){
            return;
        }
        String articleId = article.substring(article.indexOf(':') + 1);
        if (conn.sadd("voted:" + articleId, user) == 1) {
            conn.zincrby("score:", VOTE_SCORE, article);
            conn.hincrBy(article, "votes", 1L);//更新投票数量
        }
    }


    public List<Map<String,String>> getArticles(Jedis conn, int page) {
        return getArticles(conn, page, "score:");
    }

    public List<Map<String,String>> getArticles(Jedis conn, int page, String order) {
        int start = (page - 1) * ARTICLES_PER_PAGE;
        int end = start + ARTICLES_PER_PAGE - 1;
        Set<String> ids = conn.zrevrange(order, start, end);//获取第一页的文章id的集合
        List<Map<String,String>> articles = new ArrayList<>();
        for (String id : ids){
            Map<String,String> articleData = conn.hgetAll(id);//根据id获取hash散列
            articleData.put("id", id);
            articles.add(articleData);
        }
        return articles;
    }

    public void addGroups(Jedis conn, String articleId, String[] toAdd) {
        String article = "article:" + articleId;
        for (String group : toAdd) {
            conn.sadd("group:" + group, article);
        }
    }
    public List<Map<String,String>> getGroupArticles(Jedis conn, String group, int page) {
        return getGroupArticles(conn, group, page, "score:");
    }

    public List<Map<String,String>> getGroupArticles(Jedis conn, String group, int page, String order) {
        String key = order + group;
        if (! conn.exists(key) ) {
            ZParams params = new ZParams().aggregate(ZParams.Aggregate.MAX);
            conn.zinterstore(key, params, "group:" + group, order);
            conn.expire(key, 60);
        }
        return getArticles(conn, page, key);
    }

}
