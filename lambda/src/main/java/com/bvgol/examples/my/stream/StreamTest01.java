package com.bvgol.examples.my.stream;

import com.bvgol.examples.my.list.MyJson;
import com.bvgol.examples.my.list.MyList;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author guochen
 * @Title:
 * @Package
 * @Description:
 * @date 2020/6/2916:28
 */
public class StreamTest01 {

    public static void main(String[] args) {
        List<User> users = MyList.initUserList();

//        findJinName(users);

//        list2map(users);
        Map<String, Double> collect = users.stream().sorted((s1, s2) -> s1.getScore().compareTo(s2.getScore())).collect(Collectors.toMap(User::getName, User::getScore));

        sortByScore(users);
    }

    private static void sortByScore(List<User> users) {
        List<User> collect1 = users.stream().sorted((s1, s2) -> s1.getScore().compareTo(s2.getScore())).collect(Collectors.toList());
        MyJson.toJsonString(collect1);
    }

    /**
     * @param
     * @return
     * @throws
     * @Description: //以name 为key score为值 list转map
     * @author GUOCHEN
     * @date 2020/6/29 17:12
     */
    private static void list2map(List<User> users) {
        Map<String, Double> collect = users.stream().collect(Collectors.toMap(User::getName, User::getScore));
        System.out.println(collect);
    }

    /**
     * @param
     * @return
     * @throws
     * @Description: 找到list 中name 中有J 的user
     * @author GUOCHEN
     * @date 2020/6/29 17:01
     */
    private static void findJinName(List<User> users) {
        List<User> j = users.stream().filter(user -> user.getName().contains("J")).collect(Collectors.toList());
        j.forEach(System.out::println);
    }

    List<ClassA> aList = new ArrayList<>(Arrays.asList(
            new ClassA("1", "张三"),
            new ClassA("2", "李四"),
            new ClassA("3", "王五")
    ));
    List<ClassB> bList = new ArrayList<>(Arrays.asList(
            new ClassB("2", "李某"),
            new ClassB("3", "王某"),
            new ClassB("4", "赵某")
    ));

    public void xxx(){
//aList与bList的交集
        List<ClassA> intersectA = aList
                .stream() //获取第一个集合的Stream1
                .filter(  //取出Stream1中符合条件的元素组成新的Stream2，lambda表达式1返回值为true时为符合条件
                        a ->  //lambda表达式1，a为lambda表达式1的参数，是Stream1中的每个元素
                                bList.stream() //获取第二个集合的Stream3
                                        .map(ClassB::getId) //将第二个集合每个元素的id属性取出来，映射成新的一个Stream4
                                        .anyMatch( //返回值（boolean）：Stream4中是否至少有一个元素使lambda表达式2返回值为true
                                                id -> //lambda表达式2，id为lambda表达式2的参数，是Stream4中的每个元素
                                                        Objects.equals(a.getId(), id) //判断id的值是否相等
                                        )
                )
                .collect(Collectors.toList()); //将Stream2转换为List
        System.out.println(intersectA);

    }




}
