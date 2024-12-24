package pers.fulsun.blog.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.fulsun.blog.web.admin.entities.UserExtend;
import pers.fulsun.blog.web.admin.mapper.UserExtendMapper;
import pers.fulsun.blog.web.admin.service.UserExtendService;

import java.time.LocalDateTime;

@Service
public class UserExtendServiceImpl implements UserExtendService {
    @Autowired
    private UserExtendMapper userExtendMapper;

    @Override
    public void saveUserExtend(Long uid, String desc) {
        LocalDateTime now = LocalDateTime.now();
        UserExtend userExtend = new UserExtend().setUid(uid).setDescr(desc).setCreateTime(now).setUpdateTime(now);
        userExtendMapper.save(userExtend);
    }
}
