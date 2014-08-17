package com.nettyapplication.dao.impl;

import com.nettyapplication.dao.UserDAO;
import com.nettyapplication.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 16.08.2014.
 */

public class UserDAOImpl implements UserDAO {

    private static UserDAO userDAO = new UserDAOImpl();

    public UserDAOImpl() {
    }

    public static UserDAO getUserDAO(){
        return userDAO;
    }


    List<User> usersList = new ArrayList<User>();


    @Override
    public User getUserByIp(String userIp) {
        for (User user : usersList){
            if (user.getUserIp().equals(userIp)) return user;
        }
        return null;
    }

    @Override
    public void putUser(User user) {
        usersList.add(user);
    }

    @Override
    public void removeUserByIp(String Ip) {
        for (int i = 0; i < usersList.size(); i++){
            if (usersList.get(i).getUserIp().equals(Ip)) usersList.remove(i);
        }
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i < usersList.size(); i++){
            if (usersList.get(i).getUserIp().equals(user.getUserIp())) usersList.set(i, user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return usersList;
    }
}
