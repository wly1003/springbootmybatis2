package com.hyperchain.springbootmabatis2.application.service.impl;

import com.hyperchain.springbootmabatis2.application.entity.RoleEntity;
import com.hyperchain.springbootmabatis2.application.mapper.RoleMapper;
import com.hyperchain.springbootmabatis2.application.service.RoleService;
import com.hyperchain.springbootmabatis2.application.vo.RoleVo;
import com.hyperchain.springbootmabatis2.business.constant.Code;
import com.hyperchain.springbootmabatis2.business.response.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

//    private RoleMapper roleMapper;
//    @Autowired(required = false)
//    public RoleServiceImpl(RoleMapper roleMapper){
//        this.roleMapper = roleMapper;
//    }

    @Override
    public BaseResult addRole(RoleVo roleVo) {
        BaseResult baseResult = new BaseResult();
        RoleEntity roleEntity = roleVo.createRoleEntity();
        Long roleId = roleMapper.addRole(roleEntity);
        baseResult.returnWithValue(Code.SUCCESS,roleId);
        return baseResult;
    }

    @Override
    public BaseResult getRoleByRoleId(Long roleId) {
        BaseResult baseResult = new BaseResult();
        RoleEntity roleEntity = roleMapper.getRoleByRoleId(roleId);
        baseResult.returnWithValue(Code.SUCCESS,roleEntity);
        return baseResult;
    }

    @Override
    public BaseResult updateRoleByRoleId(RoleEntity roleEntity) {
        BaseResult baseResult = new BaseResult();
        Long roleId = roleMapper.updateRoleByRoleId(roleEntity);
        baseResult.returnWithValue(Code.SUCCESS,roleId);
        return null;
    }
}
