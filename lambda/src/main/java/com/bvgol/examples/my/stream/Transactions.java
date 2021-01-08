package com.bvgol.examples.my.stream;/**
 * @Classname Trader
 * @Description TODO
 * @Date 2020/11/4 11:20
 * @Created by GUOCHEN
 */

import lombok.*;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/11/04 11:20
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Transactions {
    private Trader trader;
    private Integer year;
    private Double money;
}
