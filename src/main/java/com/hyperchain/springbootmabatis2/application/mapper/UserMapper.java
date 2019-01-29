package com.hyperchain.springbootmabatis2.application.mapper;

import com.hyperchain.springbootmabatis2.application.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper//// 标志为 Mybatis 的 Mapper
public interface UserMapper {
    /**
     * 列出所有用户信息
     */
    @Select("SELECT * FROM t_rbac_user ORDER BY user_id")
    // 返回所有User信息
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "realName", column = "real_name")})
    List<UserEntity> showAll();

    /**
     * 根据UserName查询用户信息
     * @param name
     * @return
     */
    @Select("SELECT * FROM t_rbac_user WHERE user_name=#{name}")
    //根据UserName查询User信息
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "realName", column = "real_name")})
    List<UserEntity> selectByName(String name);

    /**
     * 根据UserID查询User信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM t_rbac_user WHERE user_id=#{id}")
    //根据UserID查询User信息
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "realName", column = "real_name")})
    UserEntity selectByID(String id);

    /**
     * 插入新User
     * @param user
     * @return
     */
    @SelectKey(keyProperty = "userId",keyColumn="user_id",resultType = String.class, before =true, statement = "select replace(uuid(), '-', '-')" )
    @Options(keyProperty = "userId", useGeneratedKeys = true)
    @Insert("INSERT INTO t_rbac_user(user_id,user_name,user_password,real_name)"
            + "VALUES(#{userId},#{userName},#{userPassword},#{realName})")
//    @Results({
//        @Result(property = "userId", column = "user_id"),
//        @Result(property = "userName", column = "user_name"),
//        @Result(property = "userPassword", column = "user_password"),
//        @Result(property = "realName", column = "real_name")})
    public void addUser(UserEntity user);

    /**
     * 根据用户ID更新用户信息（ID唯一标识）
     * @param user
     */

    @Update("UPDATE t_rbac_user SET user_name=#{userName},user_password=#{userPassword},real_name=#{realName} WHERE user_id=#{userId}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "realName", column = "real_name")})
    public void updateByUserID(UserEntity user);

    /**
     * 根据用户ID删除用户信息（ID唯一标识）
     * @param userId
     * @return
     */
    @Delete("DELETE FROM t_rbac_user WHERE user_id=#{userId}")
    public void deleteByUserID(String userId);

}
