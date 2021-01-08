package com.bvgol.examples.my.list;

import com.bvgol.examples.my.stream.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author guochen
 * @Title:
 * @Package com.bvgol.examples.my.list
 * @Description:
 * @date 2020/6/2916:12
 */
public class MyList {

    /**
     * @param
     * @return user.list
     * @throws null
     * @Description: 初始化list
     * @author GUOCHEN
     * @date 2020/6/29 16:54
     */
    public static List<User> initUserList() {

        return Arrays.asList(new User("张三", new Date(), true, 100.00, 1),
                new User("王五", new Date(), false, 90.1, 2),
                new User("赵六", new Date(), true, 99.99, 3),
                new User("孙七", new Date(), false, 40.00, 4),
                new User("JAVA", new Date(), true, 50.00, 5),
                new User("JSON", new Date(), false, 60.00, 6),
                new User("JACKson", new Date(), true, 70.00, 7),
                new User("孙尚香", new Date(), false, 80.00, 8),
                new User("张麻子", new Date(), true, 90.00, 9),
                new User("王2", new Date(), false, 90.10, 10),
                new User("smith", new Date(), true, 98.01, 11),
                new User("哈哈", new Date(), true, 98.02, 12)
        );
    }

    public static List<User> initUserListSameEques() {

        return Arrays.asList(new User("张三", new Date(), true, 100.00, 1),
                new User("张三", new Date(), false, 90.1, 2),
                new User("张三", new Date(), true, 99.99, 3),
                new User("孙七", new Date(), false, 40.00, 4),
                new User("JAVA", new Date(), true, 50.00, 5),
                new User("JAVA", new Date(), false, 60.00, 6),
                new User("JAVA", new Date(), true, 70.00, 7),
                new User("孙尚香", new Date(), false, 80.00, 8),
                new User("张麻子", new Date(), true, 90.00, 9),
                new User("张麻子", new Date(), false, 90.10, 10),
                new User("smith", new Date(), true, 98.01, 11),
                new User("哈哈", new Date(), true, 98.02, 12)
        );
    }

}
