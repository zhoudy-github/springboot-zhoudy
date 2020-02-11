package com.zhoudy.springboot.usermanage.dao;

import com.zhoudy.springboot.usermanage.entity.po.UserPo;
import com.zhoudy.springboot.usermanage.entity.vo.UserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    List<UserVo> getUser();
    void saveUser(UserPo userPo);
    //    void updateUser(String name,UserPo userPo);
    void deleteUser(Integer id);
}
