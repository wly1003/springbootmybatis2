package com.hyperchain.springbootmabatis2.application.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "t_rbac_role")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Column(name = "role_id",type = MySqlTypeConstant.BIGINT,length = 11)
    @ApiModelProperty("角色id")//描述一个Model的信息（一般用在请求参数无法使用@ApiImplicitParam注解进行描述的时候）
    private Long roleId;

    @Column(name = "role_name",type = MySqlTypeConstant.VARCHAR,length = 32)
    @ApiModelProperty("角色名称")
    private String roleName;

    @Column(name = "role_bz",type = MySqlTypeConstant.VARCHAR,length = 256)
    @ApiModelProperty("角色备注")
    private String roleBz;

    @Column(name = "bz",type = MySqlTypeConstant.VARCHAR,length = 256)
    @ApiModelProperty("备注")
    private String bz;
}
