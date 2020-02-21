package com.zhoudy.springboot.usermanage.support.mq;

import lombok.Data;

@Data
public class DemoMessage {

    public static final String TOPIC = "demo";
    /**
     * 编号
     */
    private Integer id;

    /**
     * 内容
     */
    private String content;
}
