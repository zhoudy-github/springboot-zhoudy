package com.zhoudy.springboot.usermanage.controller;

import com.zhoudy.springboot.usermanage.entity.po.UserPo;
import com.zhoudy.springboot.usermanage.entity.vo.UserVo;
import com.zhoudy.springboot.usermanage.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("用户信息相关接口")
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("getUserData")
    @ResponseBody
    @ApiOperation(value="获取用户信息",httpMethod = "GET")
    public List<UserVo> getUser(){
        List<UserVo> userList = userService.getUser();
        return userList;
    }

    @PostMapping("saveUser")
    @ResponseBody
    @ApiOperation(value="保存用户信息")
    public void saveUser(@ModelAttribute UserPo userPo){
        userService.saveUser(userPo);
    }

//    @GetMapping("saveUser")
//    @ResponseBody
//    @ApiOperation(value="修改用户信息")
//    public void updateUser(String name,UserPo userPo){
//        userService.updateUser(name,userPo);
//    }

    @GetMapping("deleteUser")
    @ApiOperation(value="删除用户")
    @ApiParam(name="name",value="姓名")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }

}
