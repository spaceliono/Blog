package com.space.myblog.Mapper;

import com.space.myblog.pojo.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where userName = #{userName}")
    UserEntity getUserByUsername(String userName);
}
