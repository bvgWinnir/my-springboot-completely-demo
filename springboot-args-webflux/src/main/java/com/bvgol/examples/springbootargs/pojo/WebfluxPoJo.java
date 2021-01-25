package com.bvgol.examples.springbootargs.pojo;/**
 * @Classname WebfluxPoJo
 * @Description TODO
 * @Date 2021/1/25 11:14
 * @Created by GUOCHEN
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2021/01/25 11:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebfluxPoJo {
    private Integer id;
    private String name;
    private Date birthday;
}
