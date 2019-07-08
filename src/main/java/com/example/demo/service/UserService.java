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
        if(!StringUtils.isEmpty(userName))
        criteria.andUserNameLike("%" + userName + "%");
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
        if(!StringUtils.isEmpty(user.getCreateTime()))
        user.setCreateTime(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
        if(!StringUtils.isEmpty(user.getUpdateTime()))
        user.setUpdateTime(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
        return userMapper.insert(user);
    }

    public int updateUser(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    public int deleteUserById(Integer id){
        return userMapper.deleteByPrimaryKey(id);
    }
}