package com.space.myblog.controller;

import com.space.myblog.Mapper.MenuMapper;
import com.space.myblog.Mapper.RoleMapper;
import com.space.myblog.Mapper.UserMapper;
import com.space.myblog.pojo.Menu;
import com.space.myblog.pojo.Role;
import com.space.myblog.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Controller

public class TestCtrl {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        UserEntity user = userMapper.getUserByUsername("admin");
        System.out.println(user);
        //根据用户id获取用户角色
        List<Role> roles =  roleMapper.getUserRoleByUserId(user.getId());
        for (Role role : roles){
            System.out.println(role.getRoleName());
        }
        //填充权限菜单
        List<Menu> menus = menuMapper.getRoleMenuByRoles(roles);
        for (Menu m : menus){
            System.out.println(m.getMenuName());
        }
        return "menus";
    }
}
