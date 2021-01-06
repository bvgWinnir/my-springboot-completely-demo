package com.bvgol.examples.mockIto.Dao;

import com.bvgol.examples.mockIto.eneity.User;

public interface UserDao {
    User findById(int id);
}
