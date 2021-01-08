package com.bvgol.examples.my.stream;/**
 * @Classname Apple
 * @Description TODO
 * @Date 2020/11/28 15:46
 * @Created by GUOCHEN
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/11/28 15:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Apple {
    private int id;
    private String name;
    private BigDecimal weight;
    private int xx;
}
