package pers.fulsun.blog.web.admin.service;

import pers.fulsun.blog.common.exception.GlobalException;
import pers.fulsun.blog.web.admin.entities.FriendLink;

public interface FriendLinkService {
    /**
     * 新增友链
     * @param friendLink
     * @throws GlobalException
     */
    void saveFriendLink(FriendLink friendLink) throws GlobalException;

}
