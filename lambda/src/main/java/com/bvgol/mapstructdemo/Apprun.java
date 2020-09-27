package com.bvgol.mapstructdemo;

import com.bvgol.list.MyJson;
import org.mapstruct.factory.Mappers;

/**
 * @Classname Apprun
 * @Description TODO
 * @Date 2020/9/4 14:46
 * @Created by GUOCHEN
 */
public class Apprun {
    public static void main(String[] args) {
        Apprun.entity2queryParam();
    }
    public static void entity2queryParam() {
        Order order = new Order();
        order.setId(12345L);
        order.setOrderSn("orderSn");
        order.setOrderType(0);
        order.setReceiverKeyword("keyword");
        order.setSourceType(1);
        order.setStatus(2);

        OrderMapper mapper = Mappers.getMapper(OrderMapper.class);
        OrderQueryParam orderQueryParam = mapper.entity2queryParam(order);
//        assertEquals(orderQueryParam.getOrderSn(), order.getOrderSn());
//        assertEquals(orderQueryParam.getOrderType(), order.getOrderType());
//        assertEquals(orderQueryParam.getReceiverKeyword(), order.getReceiverKeyword());
//        assertEquals(orderQueryParam.getSourceType(), order.getSourceType());
//        assertEquals(orderQueryParam.getStatus(), order.getStatus());
       MyJson.toJsonString(order);
       MyJson.toJsonString(orderQueryParam);

    }
}
