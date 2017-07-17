package com.example.demo;

import com.example.demo.domain.UserDO;
import com.example.demo.service.UserService;
import com.example.demo.web.ArticleRank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private JedisPool jedisPool;


	//<editor-fold desc="mybatis测试">
	@Test
	@Rollback
	public void testSelect(){
		UserDO user = new UserDO();
		user.setAge(24);
		user.setName("jinbaobao１");
		userService.insert(user);
	}
	//</editor-fold>
	//<editor-fold desc="redis测试">
	/**
	 * redis 测试
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		// 保存对象
		List<UserDO>  userDOList = userService.listAll();
		System.out.println(userDOList.size());
		UserDO userDO = new UserDO();
		userDO.setName("zhangkun");
		userDO.setAge(24);
		userService.insert(userDO);
		List<UserDO>  userDOList1 = userService.listAll();
		System.out.println(userDOList1.size());
	}
	//</editor-fold>
	//<editor-fold desc="jedis测试">
	/**
	 * jedis测试
	 */
	@Test
	public void jedisTest(){
		int i=1;

		try (Jedis jedis = jedisPool.getResource()) {
			jedis.set("aaa","111");
			System.out.println(jedis.get("aaa"));
		}
	}
	//</editor-fold>
	/**
	 * 文章排名
	 */
	@Test
	public void testArticleRank(){
		ArticleRank articleRank = new ArticleRank();
		articleRank.run(jedisPool.getResource());
	}


}
