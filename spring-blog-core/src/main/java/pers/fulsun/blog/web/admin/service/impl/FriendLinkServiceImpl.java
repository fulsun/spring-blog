package pers.fulsun.blog.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.fulsun.blog.common.exception.GlobalException;
import pers.fulsun.blog.web.admin.entities.FriendLink;
import pers.fulsun.blog.web.admin.mapper.FriendLinkMapper;
import pers.fulsun.blog.web.admin.service.FriendLinkService;
@Service
public class FriendLinkServiceImpl implements FriendLinkService {
    @Autowired
    private FriendLinkMapper friendLinkMapper;
    @Override
    public void saveFriendLink(FriendLink friendLink) throws GlobalException {
        friendLinkMapper.insertSelective(friendLink);
    }
}
