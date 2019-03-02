package com.hyperchain.springbootmabatis2.application.controller;

import com.hyperchain.springbootmabatis2.application.entity.RoleEntity;
import com.hyperchain.springbootmabatis2.application.service.RoleService;
import com.hyperchain.springbootmabatis2.application.vo.RoleVo;
import com.hyperchain.springbootmabatis2.business.constant.Code;
import com.hyperchain.springbootmabatis2.business.response.BaseResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("role")
@Api("角色相关Controller")//swagger，用在类上，说明该类的作用。
public class RoleController {

    private RoleService roleService;

    @Autowired
    private RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @ApiOperation(value = "getRoleList",notes = "获取角色列表")//注解来给API增加方法说明
    @RequestMapping(value = "/rolelist",method = RequestMethod.GET)
    BaseResult getRoleList(){
        BaseResult baseResult = new BaseResult();
        baseResult.returnWithValue(Code.SUCCESS,"hhh");
        return baseResult;
    }

    @ApiOperation(value = "addRole",notes = "添加一条角色记录")
    @RequestMapping(value = "/addrole",method = RequestMethod.PUT)
    BaseResult addRole(
        @ApiParam(value = "角色实体",required = true)
        @RequestBody @Valid RoleVo roleVo
    ){
        return roleService.addRole(roleVo);
    }

    @ApiModelProperty(value = "getRoleByRoleId",notes = "根据角色id查询角色")//swagger
    //ApiImplicitParam用来注解来给方法入参增加说明。ApiImplicitParams用在方法上包含一组参数说明。
    @ApiImplicitParam(name = "roleId",value = "角色id",required = true,paramType = "path",dataType = "Long")//swagger
    @RequestMapping(value = "{roleId}",method = RequestMethod.GET)
    BaseResult getRoleByRoleId(
            @PathVariable Long roleId
    ){
        return roleService.getRoleByRoleId(roleId);
    }

    @ApiModelProperty(value = "updateRoleByRoleId",notes = "根据角色id修改角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId",value = "角色id",required = true,paramType = "query",dataType = "Long"),
            @ApiImplicitParam(name = "roleName",value = "角色名称",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "roleBz",value = "角色备注",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "bz",value = "备注",required = true,paramType = "query",dataType = "String")
    })
    @RequestMapping(value = "/updateRoleByRoleId",method = RequestMethod.POST)
    BaseResult updateRoleByRoleId(
            @RequestParam(value = "roleId") Long roleId,
            @RequestParam(value = "roleName") String roleName,
            @RequestParam(value = "roleBz") String roleBz,
            @RequestParam(value = "bz") String bz
    ){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(roleId);
        roleEntity.setRoleName(roleName);
        roleEntity.setRoleBz(roleBz);
        roleEntity.setBz(bz);
        return roleService.updateRoleByRoleId(roleEntity);
    }
}
