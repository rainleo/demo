/*
package com.example.demo.config.securityConfig;

import com.goule666.houseforrent.model.SecurityModelFactory;
import com.goule666.houseforrent.model.domain.RoleDO;
import com.goule666.houseforrent.model.domain.UserDO;
import com.goule666.houseforrent.service.RoleService;
import com.goule666.houseforrent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

*/
/**
 * 传入用户名，然后从数据库查询出userDO,然后封装到userDetails中
 * @author niewenlong
 * @date 2017-10-24 15:53:25
 *//*

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    */
/**
     * 获取 userDetail
     * @param username
     * @return
     * @throws UsernameNotFoundException
     *//*

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDO user = userService.findByName(username);
        RoleDO role = roleService.findById(user.getRoleId());

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return SecurityModelFactory.create(user,role.getAuth(),role.getRoleName());
        }
    }
}
*/
