package com.bvgol.examples.mockIto.service;

import com.bvgol.examples.mockIto.Dao.UserDao;
import com.bvgol.examples.mockIto.eneity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }
}
