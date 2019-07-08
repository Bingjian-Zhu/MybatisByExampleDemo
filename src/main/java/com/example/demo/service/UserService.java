package com.example.demo.service;

import javax.annotation.Resource;
import java.util.*;
import java.time.*;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.*;
import com.github.pagehelper.*;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService{
    @Resource
    private UserMapper userMapper;

    public List<User> getAllUsers(String userName,Boolean deleted, Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(userName != null && !StringUtils.isEmpty(userName.trim()))
        criteria.andUserNameLike("%" + userName.trim() + "%");
        if(deleted != null)
        criteria.andDeletedEqualTo(deleted);
        example.setOrderByClause("id asc");
        List<User> list = userMapper.selectByExample(example);
        //long sum = userMapper.countByExample(example);//计算总数
        //PageInfo<User> pageInfo = new PageInfo<User>(list);
        //return pageInfo;
        return list;
    }

    public User getUserById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public int addUser(User user){
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.insert(user);
    }

    public int updateUser(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    public int deleteUserById(Integer id){
        return userMapper.deleteByPrimaryKey(id);
    }
}