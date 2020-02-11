package com.zhoudy.springboot.usermanage.dao;

import com.zhoudy.springboot.usermanage.entity.po.UserInfoPo;
import com.zhoudy.springboot.usermanage.entity.po.UserInfoPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoPoMapper {
    long countByExample(UserInfoPoExample example);

    int deleteByExample(UserInfoPoExample example);

    int insert(UserInfoPo record);

    int insertSelective(UserInfoPo record);

    List<UserInfoPo> selectByExample(UserInfoPoExample example);

    int updateByExampleSelective(@Param("record") UserInfoPo record, @Param("example") UserInfoPoExample example);

    int updateByExample(@Param("record") UserInfoPo record, @Param("example") UserInfoPoExample example);
}