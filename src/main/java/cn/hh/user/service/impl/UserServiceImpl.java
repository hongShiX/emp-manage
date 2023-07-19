package cn.hh.user.service.impl;

import cn.hh.user.entity.User;
import cn.hh.user.mapper.UserMapper;
import cn.hh.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.getUser(user);
    }
}
