package com.zhoudy.springboot.usermanage.support.mq;

public class DelayMsg {

    public static final String TOPIC = "delay";
    /**
     * 编号
     */
    private Integer id;

    public DelayMsg setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DelayMsg{" +
                "id=" + id +
                '}';
    }


}
