package com.hyperchain.springbootmabatis2.application.mapper;

import com.hyperchain.springbootmabatis2.application.entity.RoleEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper//通过该注解实现不用写mapper.xml文件
@Repository //spring用于标记数据库操作组件，类似@Service和@Controller
public interface RoleMapper {

    @Insert("insert into t_rbac_role(role_name,role_bz,bz) values(#{roleName},#{roleBz},#{bz})")
    @Options(useGeneratedKeys = true,keyProperty = "roleId",keyColumn = "role_id")
    Long addRole(RoleEntity roleEntity);

    @Select("select * from t_rbac_role where role_id = (#{roleId})")
    RoleEntity getRoleByRoleId(Long roleId);

    @Update("update t_rbac_role set role_name = (#{roleName}),role_bz = (#{roleBz}),bz = (#{bz}) where role_id = (#{roleId}))")
    @Options()
    Long updateRoleByRoleId(RoleEntity roleEntity);
}
