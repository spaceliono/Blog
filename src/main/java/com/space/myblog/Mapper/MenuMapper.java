package com.space.myblog.Mapper;

import com.space.myblog.pojo.Menu;
import com.space.myblog.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {
    @Select("<script>"  +
            "select * from menu where rid in" +
            "<foreach item='item' index='index' collection='list' open='(' close=')' separator=','>" +
            "#{item.id}" +
            "</foreach> "+
            "</script>")
    List<Menu> getRoleMenuByRoles(List<Role> list);
}
