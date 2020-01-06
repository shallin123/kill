package com.shallin.kill.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shallin.kill.entity.MiaoshaUser;

@Mapper
public interface MiaoshaUserDao {
	
	@Select("select * from miaosha_user where id = #{id}")
	public MiaoshaUser getById(@Param("id") long id);
}
