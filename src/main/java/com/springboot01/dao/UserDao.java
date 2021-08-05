package com.springboot01.dao;

import com.springboot01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,String > {

    User getAllByName(String Name);

    List<User> getAllBy();
    User getAllBynameAndPassWord(String name,String passWord);
}
