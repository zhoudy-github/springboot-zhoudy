package com.zhoudy.springboot.usermanage.support.mq;

public class ShiwuMsg {

    public static final String TOPIC = "shiwu";

    /**
     * 编号
     */
    private Integer id;

    public ShiwuMsg setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ShiwuMsg{" +
                "id=" + id +
                '}';
    }
}
