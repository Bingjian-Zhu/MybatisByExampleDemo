package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.example.demo.model.*;
import com.example.demo.service.UserService;
import com.example.demo.dto.*;
//import com.github.pagehelper.*;

@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;
    
	@ApiOperation(value = "获取所有用户信息" ,  notes = "返回所有用户信息")
	@RequestMapping(value = "/getUsers", method=RequestMethod.GET)
    public MyPageInfo<User> getUsers(String userName,Boolean deleted,@RequestParam(defaultValue="1") Integer pageNum, 
    @RequestParam(defaultValue = "10") Integer pageSize) {
		MyPageInfo<User> users=userService.getAllUsers(userName,deleted,pageNum,pageSize);
		return users;
	}
    
    @ApiOperation(value = "根据ID获取用户信息" ,  notes = "返回单个用户信息")
    @RequestMapping(value = "/getUser/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable("id") Integer id) {
    	User user=userService.getUserById(id);
        return user;
    }
    
    @ApiOperation(value = "新增用户" ,  notes = "注册")
    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public void save(@RequestBody User user) {
    	userService.addUser(user);
    }
    
    @ApiOperation(value = "更新用户信息" ,  notes = "更改用户信息")
    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public void update(@RequestBody User user) {
    	userService.updateUser(user);
    }
    
    @ApiOperation(value = "根据ID删除用户" ,  notes = "删除用户信息")
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
    	userService.deleteUserById(id);
    }
    
}