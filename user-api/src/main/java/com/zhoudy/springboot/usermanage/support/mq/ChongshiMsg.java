package com.zhoudy.springboot.usermanage.support.mq;

public class ChongshiMsg {

    public static final String TOPIC = "chongshi";
    /**
     * 编号
     */
    private Integer id;

    public ChongshiMsg setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ChongshiMsg{" +
                "id=" + id +
                '}';
    }


}
