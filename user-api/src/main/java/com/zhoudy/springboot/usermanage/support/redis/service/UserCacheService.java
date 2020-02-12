package com.zhoudy.springboot.usermanage.support.redis.service;

import com.zhoudy.springboot.usermanage.support.redis.dao.UserCacheDao;
import com.zhoudy.springboot.usermanage.support.redis.object.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserCacheService {

    @Autowired
    private UserCacheDao userCacheDao;

    public UserCache get(Integer id) {
        return userCacheDao.get(id);
    }

    public void set(Integer id, UserCache object) {
            userCacheDao.set(id, object);
        }

}
