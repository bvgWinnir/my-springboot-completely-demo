package com.bvgol.java7list;

import com.bvgol.list.MyJson;
import com.bvgol.list.MyList;
import com.bvgol.list.User;

import java.util.*;

public class listDemo {
    public static void main(String[] args) {

        List<User> users = MyList.initUserListSameEques();
        //需求是  把名字重复的合并为一条
        LinkedList<User> linkedList = new LinkedList<>();
        Map<String, User> map = new LinkedHashMap<>();
        int count = 0;
        for (User user : users) {
//            if (map.containsKey(user.getName())) {
//                map.put(user.getName(), count++);
//                count=0;
//            }else{
//                map.put(user.getName(), 1);
//            }
            map.put(user.getName(), user);

        }

        Collection<User> values = map.values();

        List<User> cartItems = new ArrayList<>(values);

        MyJson.toJsonString(cartItems);

    }

    public static List getSame(List<User> users) {
        List<User> repeatList = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (User s : users) {
            //1:map.containsKey()   检测key是否重复
            if (map.containsKey(s.getName())) {
                repeatList.add(s);//获取重复的学生名称

                Integer num = map.get(s.getName());
                map.put(s.getName(), num + 1);
            } else {
                map.put(s.getName(), 1);
            }
            //2: 这个key是不是存在对应的value(key是否在map中)
//			Integer count = map.get(s.getStuName());//这种写法也可以，异曲同工
//          if (count == null) {
//              map.put(s.getStuName(), 1);
//          } else {
//              map.put(s.getStuName(), (count + 1));
//          }
        }
        return repeatList;
    }

}
