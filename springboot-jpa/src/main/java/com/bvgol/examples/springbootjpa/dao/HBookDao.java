package com.bvgol.examples.springbootjpa.dao;
import com.bvgol.examples.springbootjpa.pojo.Hbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 黄大娘
 * @company dogsun公司
 * @create 2019-11-13 20:18
 * 只要继承JpaRepository，通常所用的增删查改方法都有
 * 第一个参数：操作的实体类
 * 第二个参数：实体类对应数据表的主键
 */
public interface HBookDao extends JpaRepository<Hbook,Integer> {
    Page<Hbook> findHbooksBy(Pageable pageable);
}