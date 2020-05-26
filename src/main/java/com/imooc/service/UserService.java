package com.imooc.service;

import com.imooc.entity.User;

public interface UserService {
    User findUserByName(String userName);
}
