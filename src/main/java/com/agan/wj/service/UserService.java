package com.agan.wj.service;

import com.agan.wj.dao.UserDAO;
import com.agan.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        return null!=getByName(username);
    }
    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDAO.save(user);
    }

    public User getByUserName(String name){
        return userDAO.findByUsername(name);
    }

    public User findByUserName(String name){
        return userDAO.findByUsername(name);
    }
}
