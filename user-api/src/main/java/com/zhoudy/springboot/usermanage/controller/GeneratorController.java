package com.zhoudy.springboot.usermanage.controller;

import com.zhoudy.springboot.usermanage.dao.PersonPoMapper;
import com.zhoudy.springboot.usermanage.entity.po.PersonPo;
import com.zhoudy.springboot.usermanage.entity.po.PersonPoExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="test")
@Api(value="GeneratorController",description="逆向工程测试相关接口")
public class GeneratorController {

    @Autowired
    private PersonPoMapper personPoMapper;

    @GetMapping(value="getPerson")
    @ApiOperation(value="获取person信息")
    public List<PersonPo> getPerson(){
        List<PersonPo> personPoData= personPoMapper.selectByExample(null);
        return personPoData;
    }

}
