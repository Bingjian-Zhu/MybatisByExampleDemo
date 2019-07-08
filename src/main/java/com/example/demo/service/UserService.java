package com.example.demo.service;

import javax.annotation.Resource;
import java.util.*;
import java.time.*;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.*;

import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Resource
    private UserMapper userMapper;

    public List<User> selectByExample(int pageNum,int pageSize){
        UserExample example = new UserExample();
        example.setOrderByClause("id asc");
        List<User> list = userMapper.selectByExample(example);
        return list;
    }

    public User selectByPrimaryKey(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    public int insert(User user){
        if(user.getCreateTime()==null)
        user.setCreateTime(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
        if(user.getUpdateTime() == null)
        user.setUpdateTime(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
        return userMapper.insert(user);
    }

    public int updateByPrimaryKey(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    public int deleteByPrimaryKey(int id){
        return userMapper.deleteByPrimaryKey(id);
    }
}