package pers.fulsun.blog.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.fulsun.blog.web.admin.entities.User;
import pers.fulsun.blog.web.admin.mapper.UserMapper;
import pers.fulsun.blog.web.admin.service.UserService;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int getUserNum() {
        Example example = new Example(User.class);
        return userMapper.selectCountByExample(example);
    }

    @Override
    public int saveUser(User user) {
        LocalDateTime now = LocalDateTime.now();
        return userMapper.insertSelective(user);
    }
}
