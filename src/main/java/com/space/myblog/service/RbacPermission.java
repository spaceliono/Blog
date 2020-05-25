package com.space.myblog.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.space.myblog.pojo.Menu;
import com.space.myblog.pojo.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

/**
 * RBAC数据模型控制权限
 */
@Component("rbacPermission")
public class RbacPermission{

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        if (principal instanceof UserEntity) {
            // 读取用户所拥有的权限菜单
            List<Menu> menus = ((UserEntity) principal).getRoleMenus();
            for (Menu menu : menus) {
                if (antPathMatcher.match(menu.getMenuUrl(), request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
