package com.zhoudy.springboot.usermanage.entity.po;

import lombok.Data;

import java.util.Date;
@Data
public class PersonPo {
    private Integer id;

    private String first;

    private String last;

    private Date dateofbirth;

    private String placeofbirth;
}