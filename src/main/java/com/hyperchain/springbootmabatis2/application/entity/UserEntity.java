package com.hyperchain.springbootmabatis2.application.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonAutoDetect
@Table(name = "t_rbac_user")
public class UserEntity extends BaseModel {
    //用户id
    @Column(name = "user_id",type = MySqlTypeConstant.BIGINT,length = 11)
    private Long userId;
    //用户账号
    @Column(name = "user_name",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String userName;
    //用户密码
    @Column(name = "user_password",type = MySqlTypeConstant.VARCHAR)
    private String userPassword;
    //用户真实姓名
    @Column(name = "real_name",type = MySqlTypeConstant.VARCHAR)
    private String realName;
    //所属组织
    @Column(name = "group_id",type = MySqlTypeConstant.VARCHAR)
    private String groupId;
    //最后一次登录时间
    @Column(name = "last_login_time",type = MySqlTypeConstant.DATETIME)
    private Date lastLoginTime;
    //是否有效
    @Column(name = "is_valid",type = MySqlTypeConstant.CHAR,length = 1)
    private String isValid;
    //备注
    @Column(name = "bz",type = MySqlTypeConstant.VARCHAR,length = 512)
    private String bz;
}
