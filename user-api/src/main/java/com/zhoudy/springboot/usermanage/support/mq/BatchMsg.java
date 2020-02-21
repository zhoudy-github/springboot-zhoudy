package com.zhoudy.springboot.usermanage.support.mq;


public class BatchMsg {

    public static final String TOPIC = "batch";

    /**
     * 编号
     */
    private Integer id;

    public BatchMsg setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BatchMsg{" +
                "id=" + id +
                '}';
    }

}
