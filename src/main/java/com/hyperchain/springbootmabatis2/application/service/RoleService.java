package com.hyperchain.springbootmabatis2.application.service;

import com.hyperchain.springbootmabatis2.application.entity.RoleEntity;
import com.hyperchain.springbootmabatis2.application.vo.RoleVo;
import com.hyperchain.springbootmabatis2.business.response.BaseResult;

public interface RoleService {

    BaseResult addRole(RoleVo roleVo);

    BaseResult getRoleByRoleId(Long roleId);

    BaseResult updateRoleByRoleId(RoleEntity roleEntity);
}
