package com.springboot01.service;

import com.springboot01.dao.UserDao;
import com.springboot01.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    public void setUser(User user){userDao.save(user);}

    public User getUser(String name){ return (userDao.getAllByName(name));}

    public List<User> getAll(){return userDao.getAllBy();}
}
