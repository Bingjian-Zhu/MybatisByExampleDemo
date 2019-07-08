package com.example.demo.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.example.demo.model.*;
import com.example.demo.service.UserService;
//import com.github.pagehelper.*;

@Api(description = "用户接口")
@RestController
public class UserController {
	
	@Autowired
    private UserService userService;
    
	@ApiOperation(value = "获取所有用户信息" ,  notes = "返回所有用户信息")
	@RequestMapping(value = "/getUsers/{pageNum}/{pageSize}", method=RequestMethod.GET)
	public List<User> getUsers(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
		List<User> users=userService.getAllUsers(pageNum,pageSize);
		return users;
	} 
    
    @ApiOperation(value = "根据ID获取用户信息" ,  notes = "返回单个用户信息")
    @RequestMapping(value = "/getUser", method=RequestMethod.GET)
    public User getUser(Integer id) {
    	User user=userService.getUserById(id);
        return user;
    }
    
    @ApiOperation(value = "新增用户" ,  notes = "注册")
    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public void save(User user) {
    	userService.addUser(user);
    }
    
    @ApiOperation(value = "更新用户信息" ,  notes = "更改用户信息")
    @RequestMapping(value = "update", method=RequestMethod.PUT)
    public void update(User user) {
    	userService.updateUser(user);
    }
    
    @ApiOperation(value = "根据ID删除用户" ,  notes = "删除用户信息")
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
    	userService.deleteUserById(id);
    }
    
}