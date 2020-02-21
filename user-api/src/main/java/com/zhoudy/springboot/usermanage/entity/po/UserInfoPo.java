package com.zhoudy.springboot.usermanage.entity.po;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoPo {
    private Integer id;

    private String name;

    private String sex;

    private String age;

    private String phone;

    private Integer start;

}