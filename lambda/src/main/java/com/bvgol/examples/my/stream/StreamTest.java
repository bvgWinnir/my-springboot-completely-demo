package com.bvgol.examples.my.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class StreamTest {

    private Integer id;

    private Integer age;

    private String name;



    public StreamTest(Integer id, Integer age, String name) {

        this.id = id;

        this.age = age;

        this.name = name;

    }

    public static void main(String[] args) {

        List<StreamTest> list = new ArrayList<>();

        StreamTest object0 = new StreamTest(1, 25, "尚佳鹏");

        StreamTest object1 = new StreamTest(2, 24, "标哥");

        StreamTest object2 = new StreamTest(3, 25, "李鹏");

        StreamTest object3 = new StreamTest(4, 18, "姚孟");

        list.add(object0);

        list.add(object1);

        list.add(object2);

        list.add(object3);

        List<Integer> ids = list.stream().map(StreamTest::getId).collect(Collectors.toList());

        System.err.println("所有的id : " + ids);

        List<Integer> ages = list.stream().map(StreamTest::getAge).collect(Collectors.toList());

        System.out.println("未去重的年龄 : " + ages);

        List<Integer> agess = list.stream().map(StreamTest::getAge).distinct().collect(Collectors.toList());

        System.out.println("已去重的年龄 : " + agess);

        List<Integer> collect = list.stream().map(StreamTest::getId).filter(id -> id > 2).collect(Collectors.toList());
        collect.forEach(System.out::println);
        Integer reduce = list.stream().map(StreamTest::getId).reduce(0, (a, b) -> a + b);
        System.out.println("reduce = " + reduce);
        Optional<Integer> reduce1 = list.stream().map(StreamTest::getId).reduce(Integer::sum);
        Integer integer = reduce1.get();
        System.out.println("integer = " + integer);

        List<Integer> collect1 = list.stream().map(StreamTest::getId).flatMap(Stream::of).collect(Collectors.toList());
        collect1.forEach(System.out::println);

    }

}
