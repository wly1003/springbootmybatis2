package com.hyperchain.springbootmabatis2.application.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonAutoDetect
@Table(name = "t_rbac_user")
public class UserEntity extends BaseModel {

    @Column(name = "user_id",type = MySqlTypeConstant.BIGINT,length = 11)
    @ApiModelProperty("用户id")
    private Long userId;

    @Column(name = "user_name",type = MySqlTypeConstant.VARCHAR,length = 32)
    @ApiModelProperty("用户名")
    private String userName;

    @Column(name = "user_password",type = MySqlTypeConstant.VARCHAR)
    @ApiModelProperty("用户密码")
    private String userPassword;

    @Column(name = "real_name",type = MySqlTypeConstant.VARCHAR)
    @ApiModelProperty("用户真实姓名")
    private String realName;

    @Column(name = "group_id",type = MySqlTypeConstant.VARCHAR)
    @ApiModelProperty("所属组织")
    private String groupId;

    @Column(name = "last_login_time",type = MySqlTypeConstant.DATETIME)
    @ApiModelProperty("最后一次登录时间")
    private Date lastLoginTime;

    @Column(name = "is_valid",type = MySqlTypeConstant.CHAR,length = 1)
    @ApiModelProperty("是否有效")
    private String isValid;

    @Column(name = "bz",type = MySqlTypeConstant.VARCHAR,length = 512)
    @ApiModelProperty("备注")
    private String bz;
}
