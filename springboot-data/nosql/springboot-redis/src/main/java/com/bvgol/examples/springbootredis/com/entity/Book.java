package com.bvgol.examples.springbootredis.com.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author JingQ at 2019-08-04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book implements Serializable {

    private String name;

    private Integer id;

    private String author;

    protected BigDecimal price;

    private Date publishDate;

}
