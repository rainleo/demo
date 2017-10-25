/*
package com.example.demo.config.securityConfig;

import com.goule666.houseforrent.model.domain.UserDO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.Date;

*/
/**
 * @version V1.0.0
 * @Description 用于将 LoginUser 转换成 UserDetail对象
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2017年8月13日17:04:08
 *//*

public class SecurityModelFactory {

    public static UserDetailImpl create(UserDO user,String auth,String role) {
        Collection<? extends GrantedAuthority> authorities;
        try {
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(auth + "," + role);
        } catch (Exception e) {
            authorities = null;
        }

        Date lastPasswordReset = new Date();
        lastPasswordReset.setTime(user.getLastPasswordChange().getTime());
        return new UserDetailImpl(
                user.getId(),
                user.getName(),
                user.getPassword(),
                lastPasswordReset,
                authorities,
                user.getEnable()
        );
    }

}
*/
