package com.zhoudy.springboot.usermanage.service;

import com.zhoudy.springboot.usermanage.entity.po.UserPo;
import com.zhoudy.springboot.usermanage.entity.vo.UserVo;

import java.util.List;

public interface IUserService {
    List<UserVo> getUser();
    void saveUser(UserPo userPo);
//    void updateUser(String name,UserPo userPo);
    void deleteUser(Integer name);
}
