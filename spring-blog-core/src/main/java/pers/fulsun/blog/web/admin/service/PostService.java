package pers.fulsun.blog.web.admin.service;

import pers.fulsun.blog.web.admin.entities.Post;

public interface PostService {
    /**
     * 保存文章
     * @param post 文章
     */
    void savePost(Post post);
}
