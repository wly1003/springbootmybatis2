package com.hyperchain.springbootmabatis2.application.vo;

import com.hyperchain.springbootmabatis2.application.entity.RoleEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("创建角色")
public class RoleVo {

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色备注")
    private String roleBz;

    @ApiModelProperty("备注")
    private String bz;

    public RoleEntity createRoleEntity(){
        return RoleEntity.builder()
                .roleName(this.getRoleName())
                .roleBz(this.getRoleBz())
                .bz(this.getBz())
                .build();
    }
}
