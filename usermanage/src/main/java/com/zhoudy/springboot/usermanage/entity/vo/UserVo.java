package com.zhoudy.springboot.usermanage.entity.vo;


import lombok.Data;

/***
 * 用户信息展示层
 */
@Data
public class UserVo {
    public String name;
    public String sex;
    public String age;
    public String phone;
}
