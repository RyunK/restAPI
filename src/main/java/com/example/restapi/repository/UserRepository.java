package com.example.restapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.restapi.domain.FindAllUserDTO;
import com.example.restapi.domain.User;
import com.example.restapi.domain.UserCreateDTO;

@Mapper
public interface UserRepository {

    @Select("select userid, email, createdAt from users order by createdAt desc")
    List<FindAllUserDTO> findAlluser();

    @Select("select * from users where userid = #{userid}")
    User findByUserid(String userid);

		int insertUser(UserCreateDTO user);

}