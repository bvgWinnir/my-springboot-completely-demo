package com.bvgol.examples.mockIto.Dao;

import com.bvgol.examples.mockIto.eneity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User findById(int id) {
        User user = new User();
        user.setId(1);
        user.setName("师傅");
        return user;
    }
}
