package com.bvgol.examples.springbootjpa.dao;

import com.bvgol.examples.springbootjpa.pojo.Hbook;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import java.util.UUID;

@SpringBootTest
public class HBookDaoTest {
    @Autowired
    private HBookDao hBookDao;

    @Test
   public void findHbooksByBidOrderByBid() {
        Sort sort = JpaSort.by("price");
        Pageable pageable = PageRequest.of(1, 3, sort);
        Page<Hbook> hbooks = hBookDao.findHbooksBy(pageable);

    }

    @Test
    public void insert(){
        Hbook hb = null;
        for (int i = 0; i <23 ; i++) {
            hb = new Hbook();
            hb.setBid(0);
            hb.setBname(UUID.randomUUID().toString().substring(0,4));
            hb.setPrice((float) Math.random());
            hBookDao.save(hb);
        }
    }

//    @Test
//    public void selectSimplyByPage (){
//        PageRequest request = new PageRequest(0, 1, new Sort(Sort.Direction.DESC, "created"));
//
//        hBookDao.findHbooksBy(request);
//    }

}