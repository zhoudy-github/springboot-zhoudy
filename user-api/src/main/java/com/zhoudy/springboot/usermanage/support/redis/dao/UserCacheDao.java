package com.zhoudy.springboot.usermanage.support.redis.dao;

import com.zhoudy.springboot.usermanage.support.redis.object.UserCache;
import com.zhoudy.springboot.usermanage.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserCacheDao {
    private static final String KEY_PATTERN=""; // user:用户编号

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource(name="redisTemplate")
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ValueOperations<String,String> operations;

    private static String buildKey(Integer id) { // <3>
        return String.format(KEY_PATTERN, id);
    }

    public UserCache get(Integer id) {
        String key = buildKey(id);
        String value = operations.get(key);
        return JSONUtil.parseObject(value, UserCache.class);
    }

    public void set(Integer id, UserCache object) {
        String key = buildKey(id);
        String value = JSONUtil.toJSONString(object);
        operations.set(key, value);
    }
}
