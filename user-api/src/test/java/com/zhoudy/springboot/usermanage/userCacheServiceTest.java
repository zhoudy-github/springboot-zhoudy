package com.zhoudy.springboot.usermanage;

import com.zhoudy.springboot.usermanage.support.redis.dao.UserCacheDao;
import com.zhoudy.springboot.usermanage.support.redis.object.UserCache;
import com.zhoudy.springboot.usermanage.support.redis.service.UserCacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UsermanageApplication.class)
public class userCacheServiceTest {

    @Autowired
    private UserCacheService userCacheService;

    @Test
    public void testSet() {
        UserCache object = new UserCache();
        object.setId(6);
        object.setName("浪迹天涯");
        object.setGender(1); // 男
        userCacheService.set(object.getId(), object);
    }

    @Test
    public void testGet() {
        System.out.println(userCacheService.get(6));
    }



}
