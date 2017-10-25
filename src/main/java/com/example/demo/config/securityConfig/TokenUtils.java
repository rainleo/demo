/*
package com.example.demo.config.securityConfig;

import com.goule666.houseforrent.model.UserDetailImpl;
import com.goule666.houseforrent.model.domain.UserDO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * @version V1.0.0
 * @Description token 操作类
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2017/10/3 0:41
 *//*

@Component
public class TokenUtils {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${token.secret}")
    private String secret;

    @Value("${token.expiration}")
    private Long expiration;

    */
/**
     * 根据 用户名和当前时间(未来可能会有更多值，所以写成一个类)生成 Token
     *
     * @param userDO
     * @return
     *//*

    public String generateToken(UserDO userDO) {
        Map<String, Object> claims = new HashMap();
        claims.put("sub", userDO.getName());
        claims.put("created", this.getCurrentDate());
        try {
            return Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(this.generateExpirationDate())
                    .signWith(SignatureAlgorithm.HS512, this.secret.getBytes("UTF-8"))
                    .compact();
        } catch (UnsupportedEncodingException ex) {
            logger.warn(ex.getMessage());
            return Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(this.generateExpirationDate())
                    .signWith(SignatureAlgorithm.HS512, this.secret)
                    .compact();
        }
    }

    */
/**
     * token 过期时间
     *
     * @return
     *//*

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + this.expiration * 1000);
    }

    */
/**
     * 获得当前时间
     *
     * @return
     *//*

    private Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    */
/**
     * 从 token 中拿到 username
     *
     * @param token
     * @return
     *//*

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    */
/**
     * 解析 token 的主体 Claims
     *
     * @param token
     * @return
     *//*

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(this.secret.getBytes("UTF-8"))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    */
/**
     * 检查 token 是否处于有效期内
     *
     * @param token
     * @param userDetails
     * @return
     *//*

    public Boolean validateToken(String token, UserDetails userDetails) {
        UserDetailImpl user = (UserDetailImpl) userDetails;
        final String username = this.getUsernameFromToken(token);
        final Date created = this.getCreatedDateFromToken(token);
        return (username.equals(user.getUsername()) && !(this.isTokenExpired(token)) && !(this.isCreatedBeforeLastPasswordReset(created, user.getLastPasswordReset())));
    }

    */
/**
     * 根据token获取创建时间
     *
     * @param token
     * @return
     *//*

    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            created = new Date((Long) claims.get("created"));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    */
/**
     * 根据token获取过期时间
     *
     * @param token
     * @return
     *//*

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    */
/**
     * 检查当前时间是否在封装在 token 中的过期时间之后，若是，则判定为 token 过期
     *
     * @param token
     * @return
     *//*

    private Boolean isTokenExpired(String token) {
        final Date expiration = this.getExpirationDateFromToken(token);
        return expiration.before(this.getCurrentDate());
    }

    */
/**
     * 检查 token 是否是在最后一次修改密码之前创建的（账号修改密码之后之前生成的 token 即使没过期也判断为无效）
     *
     * @param created
     * @param lastPasswordReset
     * @return
     *//*

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }
}
*/
