package com.zhoudy.springboot.usermanage.dao;

import com.zhoudy.springboot.usermanage.entity.po.PersonPo;
import com.zhoudy.springboot.usermanage.entity.po.PersonPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPoMapper {
    long countByExample(PersonPoExample example);

    int deleteByExample(PersonPoExample example);

    int insert(PersonPo record);

    int insertSelective(PersonPo record);

    List<PersonPo> selectByExample(PersonPoExample example);

    int updateByExampleSelective(@Param("record") PersonPo record, @Param("example") PersonPoExample example);

    int updateByExample(@Param("record") PersonPo record, @Param("example") PersonPoExample example);
}