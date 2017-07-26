package com.example.demo.config.shiroConfig;

import com.example.demo.domain.UserDO;
import com.example.demo.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author niewenlong-work
 * Description:身份校验核心类
 */

public class MyShiroRealm extends AuthorizingRealm {


    @Autowired
    UserService userService;

    /**
     * 认证信息.(身份验证)
     * Authentication 是用来验证用户身份
     * 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)  throws AuthenticationException {
        String username = (String) token.getPrincipal();
        //判断输入的用户是否存在
        UserDO userDO = userService.findByName(username);
        if (userDO != null) {
            //shiro自动判断 用户名和密码是否匹配
            return new SimpleAuthenticationInfo(userDO.getName(), userDO.getPassword(), getName());
        }
        return null;
    }

    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     * Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userName = (String) principals.getPrimaryPrincipal();
        UserDO userDO = userService.findByName(userName);
        if (userDO != null) {
            //设置哪些角色可以访问
            authorizationInfo.addRole(String.valueOf(userDO.getRoleId()));
            //设置拥有哪些权限可以访问
            authorizationInfo.addStringPermission(String.valueOf(userDO.getRoleId()));
            return authorizationInfo;
        }
        return null;
    }

}
