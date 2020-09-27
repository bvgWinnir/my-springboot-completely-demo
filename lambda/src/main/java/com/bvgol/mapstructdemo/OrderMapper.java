package com.bvgol.mapstructdemo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {

    OrderQueryParam entity2queryParam(Order order);

}