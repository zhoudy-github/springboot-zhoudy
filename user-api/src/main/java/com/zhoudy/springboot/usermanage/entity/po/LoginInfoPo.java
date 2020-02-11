package com.zhoudy.springboot.usermanage.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value="LoginInfoPo",description = "登录信息")
public class LoginInfoPo {
    @ApiModelProperty(name="username",value="用户名",required=true)
    @NotBlank(message = "名字不允许为空")
    public String username;
    @ApiModelProperty(name="password",value="密码",required=true)
    public String password;
}
