package com.space.myblog.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.space.myblog.Mapper.MenuMapper;
import com.space.myblog.Mapper.RoleMapper;
import com.space.myblog.Mapper.UserMapper;
import com.space.myblog.pojo.Menu;
import com.space.myblog.pojo.Role;
import com.space.myblog.pojo.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 获取用户相关信息
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查找用户
        UserEntity user = userMapper.getUserByUsername(username);
        if (user != null) {
            //根据用户id获取用户角色
            List<Role> roles = roleMapper.getUserRoleByUserId(user.getId());
            // 填充权限
            Collection<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            //填充权限菜单
            List<Menu> menus=menuMapper.getRoleMenuByRoles(roles);
            return new UserEntity(username,user.getPassword(),authorities,menus);
        } else {
            System.out.println(username +" not found");
            throw new UsernameNotFoundException(username +" not found");
        }
    }
}