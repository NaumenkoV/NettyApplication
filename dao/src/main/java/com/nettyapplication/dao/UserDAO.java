package com.nettyapplication.dao;

import com.nettyapplication.entity.User;

import java.util.List;

/**
 * Created by Вадим on 16.08.2014.
 */
public interface UserDAO {

    User getUserByIp(String userIp);
    void putUser(User user);
    void removeUserByIp(String Id);
    void updateUser(User user);
    List<User> getAllUsers();
}
