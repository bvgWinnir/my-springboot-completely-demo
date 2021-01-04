package com.atguigu.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: my-springboot-completely
 * @description: copyOnWrite 开头的类
 * concurrentHashMap
 * concurrentSkipListMap
 * ConcurrentSkipListSet
 * CopyOnWriteArrayList
 * CopyOnWriteArraySet
 * 当期望许多线程访问一个给定 collection 时,ConcurrentHashMap >HashMap
 * ConcurrentSkipListMap >TreeMap
 * 当期望的读数和遍历远远大于列表的更新数时,CopyOnWriteArrayList >ArrayList
 * @author: GUOCHEN
 * @create: 2021/01/04 22:36
 */
public class TestCopOnWriteXXX {
    public static void main(String[] args) {
//        concurrentModificationException();

//        unsupportedOperationException();

//        UnsupportedOperationExceptionBySyncchronizedList();

        for (int i = Hello.stringCopyOnWriteArrayList.size() - 1; i >= 0; i--) {
            Hello.stringCopyOnWriteArrayList.add("0000");
        }

        System.out.println("-----------------------------------------------------------------------------");

        CopyOnWrite h = new CopyOnWrite();
        for (int i = 0; i < 10; i++) {
            new Thread(h).start();
        }

    }

    private static void UnsupportedOperationExceptionBySyncchronizedList() {
        for (int i = Hello.synchronizedList.size() - 1; i >= 0; i--) {
            Hello.synchronizedList.add("----");
            //UnsupportedOperationException
        }
    }

    /**
     * 功能描述:  UnsupportedOperationException
     *
     * @param
     * @return: void
     * @author: 郭辰
     * @date: 2021/1/4 22:50
     */
    private static void unsupportedOperationException() {
        for (int i = Hello.list.size() - 1; i >= 0; i--) {

            Hello.list.add("CC");
        }
    }

    /**
     * 功能描述: java.util.ConcurrentModificationException
     *
     * @param
     * @return: void
     * @author: 郭辰
     * @date: 2021/1/4 22:46
     */
    private static void concurrentModificationException() {
        HelloThread h = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(h).start();
        }
    }
}

/**
 * 功能描述: 并发读写异常(多线程版)
 *
 * @return:
 * @author: 郭辰
 * @date: 2021/1/4 22:44
 */
class HelloThread implements Runnable {

    private static List<String> list = Collections.synchronizedList(new ArrayList<>());

    private static CopyOnWriteArrayList<String> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
        stringCopyOnWriteArrayList.add("AA");
        stringCopyOnWriteArrayList.add("BB");
        stringCopyOnWriteArrayList.add("CC");
    }

    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add("-----");
        }
    }
}

class CopyOnWrite implements Runnable {
    private static CopyOnWriteArrayList<String> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<>();

    static {
        stringCopyOnWriteArrayList.add("AA");
        stringCopyOnWriteArrayList.add("BB");
        stringCopyOnWriteArrayList.add("CC");
    }

    @Override
    public void run() {
        Iterator<String> iterator = stringCopyOnWriteArrayList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            stringCopyOnWriteArrayList.add("-----");
        }
    }
}

class Hello {
    public static List<String> list = Arrays.asList("AA", "BB");
    public static List<String> synchronizedList = Collections.synchronizedList(Arrays.asList("AA", "BB"));
    public static CopyOnWriteArrayList<String> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<>(Arrays.asList("AA", "BB"));
}
