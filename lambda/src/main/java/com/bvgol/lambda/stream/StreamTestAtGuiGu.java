package com.bvgol.lambda.stream;/**
 * @Classname StreamExp
 * @Description TODO
 * @Date 2020/11/4 11:28
 * @Created by GUOCHEN
 */

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/11/04 11:28
 */
public class StreamTestAtGuiGu {

    List<Transactions> transactions = null;
    List<Trader> traders;

    @Before
    public void before() {
        Trader raoul = Trader.builder().name("Raoul").city("Cambridge").build();
        Trader mario = Trader.builder().name("mario").city("Milan").build();
        Trader alan = Trader.builder().name("alan").city("Beijing").build();
        Trader brian = Trader.builder().name("brian").city("Cambridge").build();

        transactions = Arrays.asList(
                Transactions.builder().trader(brian).year(2011).money(300D).build(),
                Transactions.builder().trader(raoul).year(2011).money(1000D).build(),
                Transactions.builder().trader(raoul).year(2012).money(4100D).build(),
                Transactions.builder().trader(mario).year(2012).money(3200D).build(),
                Transactions.builder().trader(mario).year(2011).money(3100D).build(),
                Transactions.builder().trader(alan).year(2020).money(9000D).build()
        );

        traders = Arrays.asList(
                Trader.builder().name("1").city("qingdao").build(),
                Trader.builder().name("2").city("jinan").build(),
                Trader.builder().name("3").city("lon").build(),
                Trader.builder().name("4").city("a").build(),
                Trader.builder().name("5").city("a").build(),
                Trader.builder().name("6").city("a").build(),
                Trader.builder().name("7").city("shanghai").build(),
                Trader.builder().name("8").city("shanghai").build(),
                Trader.builder().name("9").city("ion").build()
        );

    }

    @Test
    public void test() {
    }

    @Test
    public void test1() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> collect2 = integerList.stream().map(i -> i * i).collect(Collectors.toList());
        collect2.forEach(System.out::println);
    }

    @Test
    public void test2() {
        long count = transactions.stream().count();
        System.out.println("count = " + count);
    }

    @Test
    public void test3() {
        //找出2011年发生的所有交易,并按交易额排序(从低到高)
        //默认从小到大 正序
        //-从大到小     倒序
        List<Transactions> collect = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((x, y) -> -Double.compare(x.getMoney(), y.getMoney()))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void test4() {
        //交易员都在哪些不用的城市工作过(有几个员工需要去重/城市有重复的需要去重吗)
        String collect = transactions.stream()
                .map(Transactions::getTrader).distinct()
                .map(Trader::getCity).distinct()
                .collect(Collectors.joining("-"));
        System.out.println("collect = " + collect);
    }

    @Test
    public void test41() {
        //交易员都在哪些不用的城市工作过(有几个员工需要去重/城市有重复的需要去重吗)
        String collect = transactions.stream()
                .map(t -> t.getTrader().getCity()).distinct()
                .collect(Collectors.joining("-"));
        System.out.println("collect = " + collect);
    }

    @Test
    public void test5() {
        //查找所有来自剑桥的交易员,并按姓名排序
        transactions.stream()
//                .map(t1->t1.getTrader()).distinct()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName()).distinct()
                .sorted((x, y) -> -x.compareTo(y))
                .forEach(System.out::println);
    }

    @Test
    public void test6() {
        //返回所有交易员的姓名字符串,按字母顺序排序
        String collect = transactions.stream()
                .map(t -> t.getTrader().getName()).distinct()
                .sorted((x, y) -> x.compareTo(y))//此处如果出现大小写,需要怎么比对?
                .collect(Collectors.joining("-"));
        System.out.println("collect = " + collect);
    }

    @Test
    public void test61() {
        //返回所有交易员的姓名字符串,按字母顺序排序
        String reduce = transactions.stream()
                .map(t -> t.getTrader().getName()).distinct()
                .sorted()
                .reduce("", String::concat);
        System.out.println("reduce = " + reduce);
    }

    @Test
    public void test7() {
//        有没有交易员是在米兰工作?
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Milan"))
                .map(t -> t.getTrader().getName()).distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test71() {
//        有没有交易员是在米兰工作?
        boolean milan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("milan = " + milan);

    }

    @Test
    public void test8() {
        //打印生活在剑桥的交易员的所有交易额
        Optional<Double> cambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transactions::getMoney)
                .reduce(Double::sum);
        System.out.println("cambridge = " + cambridge.get());
    }

    @Test
    public void test9() {
        //所有交易中,最高的交易额是多少
        Optional<Double> max = transactions.stream().map(Transactions::getMoney).max(Double::compare);
        System.out.println("max = " + max.get());

    }

    @Test
    public void test10() {
        //找到交易额最小的交易
        Optional<Double> min = transactions.stream().map(Transactions::getMoney).min(Double::compare);
        System.out.println("min = " + min.get());
    }

    @Test
    public void test11() {
        //按对象属性去重返回list

        List<String> collect = traders.stream().map(Trader::getCity).distinct().collect(Collectors.toList());

//        users = users.stream().collect(
//                collectingAndThen(
//                        toCollection(() -> new TreeSet<>(Comparator.comparing(UserInDeptDto::getUserId))), ArrayList::new)
//        );

        //

    }

    @Test
    public void test12() {
        //根据城市分组
        Map<String, List<Trader>> collect = traders.stream().collect(Collectors.groupingBy(Trader::getCity));
        collect.forEach((k, v) -> {
            System.out.println(k + "---" + v.size());
        });
    }

    @Test
    public void test13() {
    }

    @Test
    public void test14() {
    }

    @Test
    public void test15() {
    }

}
