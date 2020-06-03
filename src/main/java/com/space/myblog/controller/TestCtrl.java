package com.space.myblog.controller;

import com.space.myblog.Mapper.MenuMapper;
import com.space.myblog.Mapper.RoleMapper;
import com.space.myblog.Mapper.UserMapper;
import com.space.myblog.pojo.Article;
import com.space.myblog.pojo.Menu;
import com.space.myblog.pojo.Role;
import com.space.myblog.pojo.UserEntity;
import com.space.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class TestCtrl {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    ArticleService articleService;
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
    @RequestMapping("/test1")
    public String error(){
        int i =1/0;
        return "about";
    }
    @RequestMapping("/test2")
    public String error1(){
        return "errorPage";
    }
    @RequestMapping("/test/{id}")
    public String getArticle(@PathVariable("id") int id, ModelMap m,HttpServletRequest request) {

        Article article = articleService.get(id);
        if (article==null){
            request.setAttribute("javax.servlet.error.status_code",404);
            return "forword:/error";
        }else {
            m.addAttribute("article", article);
            return "article";
        }
    }
}
