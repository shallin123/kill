package com.shallin.kill.service;

import com.shallin.kill.dao.UserDao;
import com.shallin.kill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public User getById(int id){
        return userDao.getById(id);
    }
}
