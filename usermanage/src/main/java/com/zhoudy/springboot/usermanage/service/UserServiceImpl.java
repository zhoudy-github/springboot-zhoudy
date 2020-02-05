package com.zhoudy.springboot.usermanage.service;

import com.zhoudy.springboot.usermanage.dao.UserMapper;
import com.zhoudy.springboot.usermanage.entity.po.UserPo;
import com.zhoudy.springboot.usermanage.entity.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserVo> getUser() {
        return userMapper.getUser();
    }


    @Override
    public void saveUser(UserPo userPo){
        userMapper.saveUser(userPo);
    }

//    @Override
//    public void updateUser(String name,UserPo userPo){
//
//    }

    @Override
    public void deleteUser(String name){
        userMapper.deleteUser(name);
    }
}
