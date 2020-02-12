package com.zhoudy.springboot.usermanage.controller;

import com.zhoudy.springboot.usermanage.annotation.ExecuteTime;
import com.zhoudy.springboot.usermanage.entity.po.LoginInfoPo;
import com.zhoudy.springboot.usermanage.entity.po.UserPo;
import com.zhoudy.springboot.usermanage.entity.vo.UserVo;
import com.zhoudy.springboot.usermanage.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*")
@Api(value="UserController",description="用户信息相关接口")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("loginData")
    @ResponseBody
    @ApiOperation(value="登录测试")
    @ExecuteTime()
    public Map<String ,Object> login(LoginInfoPo loginInfoPo){
        System.out.println("请求用户名是："+loginInfoPo.getUsername());
        System.out.println("请求密码是："+loginInfoPo.getPassword());
        Map rst = new HashMap();
        if("admin".equals(loginInfoPo.getUsername()) &&"1111111".equals(loginInfoPo.getPassword())){
            List<UserVo> userList = userService.getUser();
            rst.put("code","200");
            rst.put("msg","用户名密码ok");
            rst.put("data",userList);
        }else{
            rst.put("code","200");
            rst.put("msg","密码不正确");
        }
        return rst;
    }


    @GetMapping("getUserData")
    @ResponseBody
    @ApiOperation(value="获取用户信息",httpMethod = "GET")
    @ExecuteTime()
    public List<UserVo> getUser(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
    @ResponseBody
    public void deleteUser(@RequestParam Integer id){
        userService.deleteUser(id);
    }

}
