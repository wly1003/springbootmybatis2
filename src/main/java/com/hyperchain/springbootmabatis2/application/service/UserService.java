package com.hyperchain.springbootmabatis2.application.service;

import com.hyperchain.springbootmabatis2.application.entity.UserEntity;

import java.util.List;

public interface UserService {
    /**
     * 列出所有用户信息
     */
    List<UserEntity> showAll();
    /**
     * 根据用户名称查询用户信息
     */
    List<UserEntity> selectByName(String userName);

    /**
     * 根据用户Id查询用户信息
     */
    UserEntity selectByID(String userId);
    /**
     * 增加用户信息
     */
    void addUser(UserEntity user);
    /**
     * 根据UserID更新用户信息
     */
    void updateByUserID(UserEntity user);
    /**
     * 根据UserID删除用户信息
     */
    void deleteByUserID(String userId);
}
