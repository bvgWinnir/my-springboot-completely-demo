package com.bvgol.lambda.stream;/**
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
public class Trader {
    private String name;
    private String city;

//        private List<Trader> list;
//
//        public static  List<Trader> getList(){
//            List<Trader> list =
//            return list;
//        }
}
