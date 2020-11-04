package com.bvgol.lambda.stream;/**
 * @Classname StreamExp
 * @Description TODO
 * @Date 2020/11/4 11:28
 * @Created by GUOCHEN
 */

import org.junit.Before;

import java.util.Arrays;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/11/04 11:28
 */
public class StreamExp {
    @Before
    public void before() {
        Trader raoul = Trader.builder().name("Raoul").city("Cambridge").build();
        Trader mario = Trader.builder().name("mario").city("Milan").build();
        Trader alan = Trader.builder().name("alan").city("Beijing").build();
        Trader brian = Trader.builder().name("brian").city("Cambridge").build();

        Arrays.asList(
                Transactions.builder().trader(brian).year(2011).money(300D).build(),
                Transactions.builder().trader(raoul).year(2011).money(1000D).build(),
                Transactions.builder().trader(raoul).year(2012).money(4100D).build(),
                Transactions.builder().trader(mario).year(2012).money(3200D).build(),
                Transactions.builder().trader(mario).year(2011).money(3100D).build(),
                Transactions.builder().trader(alan).year(2020).money(9000D).build()
        );

    }
}
