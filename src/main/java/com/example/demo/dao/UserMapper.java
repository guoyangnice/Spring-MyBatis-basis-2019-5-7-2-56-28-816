package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface UserMapper {
    // 1. 实现查询所有用户
    @Select("select * from user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    List<User> findAll();

    // 2. 根据用户id查询用户
    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    User findUserById(long id);
    // 3. 添加新用户
    @Insert("Insert into user(id,name) values(#{id},#{name})")
    void insertUser(User user);
    // 4. 根据用户id删除用户
    @Delete("delete from user where id = #{id}")
    void delete(long id);
    // 5. 根据用户id更新用户
    @Update("update user set name=#{name} where id = #{id}")
    void updateUser(User user);
}
