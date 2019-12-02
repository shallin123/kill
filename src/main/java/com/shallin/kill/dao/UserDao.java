package com.shallin.kill.dao;

import com.shallin.kill.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    /**
     * 查找
     * */
    @Select("select * from User where id = #{id}")
    public User getById(@Param("id") int id);
}
