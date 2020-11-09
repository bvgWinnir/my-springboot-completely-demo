package com.bvgol.examples.springbootjpa.controller;

import com.bvgol.examples.springbootjpa.dao.HBookDao;
import com.bvgol.examples.springbootjpa.pojo.Hbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @author 黄大娘
 * @company dogsun公司
 * @create 2019-11-13 20:24
 */
@RestController
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    private HBookDao hHBookDao;

    @RequestMapping("/add")
    public String add(Hbook hbook){
        hHBookDao.save(hbook);
        return "success";
    }

    @RequestMapping("/edit")
    public String edit(Hbook hbook){
        hHBookDao.save(hbook);
        return "success";
    }

    @RequestMapping("/del")
    public String del(Hbook hbook){
        hHBookDao.delete(hbook);
        return "success";
    }

    @RequestMapping("/getOne")
    public Hbook getOne(Integer bid){
//        会出现懒加载问题：org.hibernate.LazyInitializationException: could not initialize proxy - no Session
//        return hHBookDao.getOne(bid);
        return hHBookDao.findById(bid).get();
    }

    @RequestMapping("/getAll")
    public List<Hbook> getAll(){
        return hHBookDao.findAll();
    }
}
