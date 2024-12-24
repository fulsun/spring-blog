package pers.fulsun.blog.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.fulsun.blog.web.admin.entities.Post;
import pers.fulsun.blog.web.admin.mapper.PostMapper;
import pers.fulsun.blog.web.admin.service.PostService;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public void savePost(Post post) {
         postMapper.insertSelective(post);
    }
}
