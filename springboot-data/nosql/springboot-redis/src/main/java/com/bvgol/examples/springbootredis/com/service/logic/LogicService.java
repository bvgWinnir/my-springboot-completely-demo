package com.bvgol.examples.springbootredis.com.service.logic;/**
 * @Classname LogicService
 * @Description TODO
 * @Date 2021/1/4 14:05
 * @Created by GUOCHEN
 */

import com.bvgol.examples.springbootredis.com.entity.Book;

/**
 * @program: my-springboot-completely
 * @description: 模拟业务类
 * @author: GUOCHEN
 * @create: 2021/01/04 14:05
 */
public interface LogicService {
    /**
     * 功能描述: lua 脚本版
     * 此种实现完整描述(交互式)
     * 在生成这个数据对象的时候
     * 生成一个唯一标志，防止重复提交（响应到页面有一份，有一份保存到redis中）
     * 使用(提交/更新)时
     * 查询redis中有没有token信息, 有，则是第一次提交，放行并删除redis中的orderToken
     * 没有,不合规的数据`返回
     * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
     * ★★★★特别注意`这种方式 实现简单`但是需要结合业务上下文★★★★
     * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
     *
     * @date: 2021/1/4 15:09
     */
    Book logic(Integer token) throws Exception;
}
