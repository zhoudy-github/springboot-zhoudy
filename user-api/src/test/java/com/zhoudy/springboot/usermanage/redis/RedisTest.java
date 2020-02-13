package com.zhoudy.springboot.usermanage.redis;

import com.zhoudy.springboot.usermanage.support.redis.object.UserCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void stringSetKey() {
        stringRedisTemplate.opsForValue().set("zhoudy","zhouodngyang");
    }

    @Test
    public void testStringSetKey02() {
        redisTemplate.opsForValue().set("zhoudy1", "zhouodngyang1");
    }

    @Test
    public void testStringSetKeyUserCache(){
        UserCache obj = new UserCache();
        obj.setId(1);
        obj.setName("周东阳");
        obj.setGender(1);
        String key = String.format("user:%d",obj.getId());
        redisTemplate.opsForValue().set(key,obj);
    }

    @Test
    public void testStringGetKeyUserCache(){
        String key = String.format("user:%d",1);
        Object value=redisTemplate.opsForValue().get(key);
        System.out.println(value);
    }


    @Test
    public void testStringSetKeyUserCache2(){
        UserCache obj = new UserCache();
        obj.setId(2);
        obj.setName("周东阳2");
        obj.setGender(2);
        String key = String.format("user:%d",obj.getId());
        redisTemplate.opsForValue().set(key,obj);
    }

    @Test
    public void testStringGetKeyUserCache2(){
        String key = String.format("user:%d",2);
        Object value=redisTemplate.opsForValue().get(key);
        System.out.println(value);
    }



    @Test
    public void testStringSetKeyUserCache3(){
        UserCache obj = new UserCache();
        obj.setId(3);
        obj.setName("周东阳3");
        obj.setGender(3);
        String key = String.format("user:%d",obj.getId());
        redisTemplate.opsForValue().set(key,obj);
    }

    @Test
    public void testStringGetKeyUserCache3(){
        String key = String.format("user:%d",3);
        Object value=redisTemplate.opsForValue().get(key);
        System.out.println(value);
    }


}
