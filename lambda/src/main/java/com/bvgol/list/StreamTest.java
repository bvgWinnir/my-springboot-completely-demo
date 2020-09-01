package com.bvgol.list;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author guochen
 * @Title:
 * @Package
 * @Description:
 * @date 2020/6/2916:28
 */
public class StreamTest {

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
}
