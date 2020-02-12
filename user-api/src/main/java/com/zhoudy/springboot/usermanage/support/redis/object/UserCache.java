package com.zhoudy.springboot.usermanage.support.redis.object;

import lombok.Data;

/***
 * 用户缓存信息
 * @author zhoudy
 */
@Data
public class UserCache {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;

    @Override
    public String toString() {
        return "UserCache{" + "id=" + id + ", name='" + name  + '\''+ ", gender=" + gender +'}';
    }

}
