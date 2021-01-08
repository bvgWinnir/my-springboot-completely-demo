package com.bvgol.examples.my.mapstructdemo;

import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    OrderQueryParam entity2queryParam(Order order);

}
