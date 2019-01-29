package com.hyperchain.springbootmabatis2.application.service.impl;

import com.hyperchain.springbootmabatis2.application.entity.UserEntity;
import com.hyperchain.springbootmabatis2.application.mapper.UserMapper;
import com.hyperchain.springbootmabatis2.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired(required = false)
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<UserEntity> showAll() {
        return userMapper.showAll();
    }

    public List<UserEntity> selectByName(String name){
        return userMapper.selectByName(name);
    }


    public UserEntity selectByID(String id) {

        UserEntity user=userMapper.selectByID(id);

        return user;
    }

    public void addUser(UserEntity user){
        userMapper.addUser(user);
    }

    public void updateByUserID(UserEntity user) {

        userMapper.updateByUserID(user);
    }

    public void deleteByUserID(String id) {

        userMapper.deleteByUserID(id);

    }

}
