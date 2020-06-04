package com.bvgol.examples.springbootMybatisXmlMultiple.impl;

import java.util.List;

import com.bvgol.examples.springbootMybatisXmlMultiple.domain.User;
import com.bvgol.examples.springbootMybatisXmlMultiple.dynamicdatasource.DataSourceSelector;
import com.bvgol.examples.springbootMybatisXmlMultiple.dynamicdatasource.DynamicDataSourceEnum;
import com.bvgol.examples.springbootMybatisXmlMultiple.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author kevin
 * @date 2019-11-20 10:16
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    public List<User> listUser() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @DataSourceSelector(value = DynamicDataSourceEnum.MASTER)
    public int update() {
        User user = new User();
        user.setUserId(Long.parseLong("1196978513958141952"));
        user.setUserName("修改后的名字2");
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    public User find() {
        User user = new User();
        user.setUserId(Long.parseLong("1196978513958141952"));
        return userMapper.selectByPrimaryKey(user);
    }
}