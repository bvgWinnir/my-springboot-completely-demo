package com.bvgol.examples.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bvgol.examples.springbootmybatisplus.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2020/5/6 9:11
 * @Created by guochen
 */
@Repository//为了Autowired
public interface UserMapper extends BaseMapper<User> {
    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * </p>
     *
     * @param page  分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param status 状态
     * @return 分页对象
     */
    IPage<User> selectPageVo(@Param("page") Page<?> page, @Param("status") Integer status);
}