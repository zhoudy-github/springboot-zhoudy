package com.zhoudy.springboot.usermanage.support.mq;

/***
 * 广播消息
 */
public class GuangboMsg {
    public static final String TOPIC = "guangbo";

    /**
     * 编号
     */
    private Integer id;

    public GuangboMsg setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GuangboMsg{" +
                "id=" + id +
                '}';
    }
}
