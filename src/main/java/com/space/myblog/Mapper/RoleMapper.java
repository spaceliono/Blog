package com.space.myblog.Mapper;

import com.space.myblog.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("select * from role where uid=#{uid}")
    List<Role> getUserRoleByUserId(long uid);
}
