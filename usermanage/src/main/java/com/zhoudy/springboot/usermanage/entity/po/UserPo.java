package com.zhoudy.springboot.usermanage.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/***
 * 用户信息持久化层
 */
//@Data
@Getter
@Setter
@ApiModel(value="UserPo",description = "用户信息")
public class UserPo {
    @ApiModelProperty(name="name",value="姓名",required=true)
    @NotBlank(message = "名字不允许为空")
    public String name;
    @ApiModelProperty(name="sex",value="性别",required=true)
    public String sex;
    @ApiModelProperty(name="age",value="年龄",required=true)
    public String age;
    @ApiModelProperty(name="phone",value="手机号",required=true)
    public String phone;
    @ApiModelProperty(name="start",value = "状态",notes = "默认为1",required=true)
    @NotBlank(message = "状态不允许为空")
    public Integer start;
}
