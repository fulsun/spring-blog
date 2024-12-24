package pers.fulsun.blog.web.admin.service;

import pers.fulsun.blog.web.admin.entities.User;

public interface UserService {
    int getUserNum()  ;

    int saveUser(User user);
}
