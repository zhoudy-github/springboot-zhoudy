package com.zhoudy.springboot.usermanage.support.mq;

public class ShunxuMsg {

    public static final String TOPIC = "shunxu";

    /**
     * 编号
     */
    private Integer id;

    public ShunxuMsg setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ShunxuMsg{" +
                "id=" + id +
                '}';
    }
}
