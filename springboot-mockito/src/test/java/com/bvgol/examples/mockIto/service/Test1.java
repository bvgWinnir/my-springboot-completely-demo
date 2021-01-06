package com.bvgol.examples.mockIto.service; /**
 * @Classname com.bvgol.examples.mockIto.service.Test1
 * @Description TODO
 * @Date 2021/1/6 13:46
 * @Created by GUOCHEN
 */

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.*;

/**
 * @program: my-springboot-completely
 * @description: 测试mock
 * @author: GUOCHEN
 * @create: 2021/01/06 13:46
 */
public class Test1 {
    @Test
    public void createMockObject() {
        //使用 mock 静态方法创建 Mock 对象.
        List mockList = Mockito.mock(List.class);
        //mockList instanceof  List 结果为true
        Assert.assertTrue(mockList instanceof List);

        //mock 方法不仅可以 Mock 接口类, 还可以 Mock 具体的类型.
        ArrayList mockedArrayList = Mockito.mock(ArrayList.class);
        //mockedArrayList instanceof List 结果为true
        //ArrayList实现了List接口，所以为true
        Assert.assertTrue(mockedArrayList instanceof List);
        //mockedArrayList instanceof ArrayList 结果为true
        Assert.assertTrue(mockedArrayList instanceof ArrayList);
    }

    /**
     * 配置Mock对象
     *
     * @author 悟纤「公众号SpringBoot」
     * @date 2020-11-29
     * @slogan 大道至简 悟在天成
     */
    @Test
    public void configMockObject() {
        //使用 mock 静态方法创建 Mock 对象.
        List mockList = Mockito.mock(List.class);

        //我们定制了当调用 mockedList.add("悟纤") 时, 返回 true
        Mockito.when(mockList.add("悟纤")).thenReturn(true);
        //当调用 mockedList.size() 时, 返回 1
        Mockito.when(mockList.size()).thenReturn(1);

        Assert.assertTrue(mockList.add("悟纤"));
        // 因为我们没有定制 add("师傅"), 因此返回默认值, 即 false.
        Assert.assertFalse(mockList.add("师傅"));
        Assert.assertEquals(mockList.size(), 1);

        Iterator i = Mockito.mock(Iterator.class);
        /**
         * 以下这句代码的意思就是：
         * 第一次调用 i.next() 时返回 "Hello,", 第二次调用 i.next() 时返回 "Mockito!".
         */
        Mockito.when(i.next()).thenReturn("Hello,").thenReturn("Mockito!");
        //result=Hello Mockito
        String result = i.next() + " " + i.next();
        //assert
        Assert.assertEquals("Hello, Mockito!", result);
    }

    /**
     * 指定一个抛出异常
     *
     * @author 悟纤「公众号SpringBoot」
     * @date 2020-11-29
     * @slogan 大道至简 悟在天成
     */
    @Test(expected = NoSuchElementException.class)
    public void testForIOException() throws Exception {
        Iterator iterator = Mockito.mock(Iterator.class);
        Mockito.when(iterator.next()).thenReturn("Hello,").thenReturn("Mockito!");
        String result = iterator.next() + " " + iterator.next();
        Assert.assertEquals("Hello, Mockito!", result);

        //写法一：
        //Mockito.when(iterator.next()).thenThrow(new NoSuchElementException());

        //写法二：
        Mockito.doThrow(new NoSuchElementException()).when(iterator).next();
        iterator.next();
    }

    /**
     * 校验 Mock 对象的方法调用
     *
     * @author 悟纤「公众号SpringBoot」
     * @date 2020-11-29
     * @slogan 大道至简 悟在天成
     * （1）第一句校验 mockedList.add("one") 至少被调用了 1 次(atLeastOnce)
     * （2）第二句校验 mockedList.add("two") 被调用了 1 次(times(1))
     * （3）第三句校验 mockedList.add("three times") 被调用了 3 次(times(3))
     * （4）第四句校验 mockedList.isEmpty() 从未被调用(never)
     */
    @Test
    public void testVerify() {
        List mockList = Mockito.mock(List.class);
        mockList.add("one");
        mockList.add("two");
        mockList.add("three");
        mockList.add("three");
        mockList.add("three");

        Mockito.when(mockList.size()).thenReturn(5);
        Assert.assertEquals(mockList.size(), 5);

        //校验 Mock 对象的方法调用
        Mockito.verify(mockList, Mockito.atLeastOnce()).add("one");
        Mockito.verify(mockList, Mockito.times(1)).add("two");
        Mockito.verify(mockList, Mockito.times(3)).add("three");
        Mockito.verify(mockList, Mockito.never()).isEmpty();
    }

    /**
     * 使用 spy() 部分模拟对象
     *
     * @author 悟纤「公众号SpringBoot」
     * @date 2020-11-29
     * @slogan 大道至简 悟在天成
     */
    @Test
    public void testSpy() {
        List list = new LinkedList();
        List spy = Mockito.spy(list);

        // 对 spy.size() 进行定制.
        Mockito.when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        // 因为我们没有对 get(0), get(1) 方法进行定制,
        // 因此这些调用其实是调用的真实对象的方法.
        Assert.assertEquals(spy.get(0), "one");
        Assert.assertEquals(spy.get(1), "two");

        Assert.assertEquals(spy.size(), 100);

//        这个例子中我们实例化了一个LinkedList 对象, 然后使用 spy() 方法对 list 对象进行部分模拟. 接着我们使用 when(...).thenReturn(...) 方法链来规定 spy.size()方法返回值是 100. 随后我们给 spy 添加了两个元素, 然后再 调用 spy.get(0) 获取第一个元素.
//        这里有意思的地方是: 因为我们没有定制 add("one"),add("two"), get(0), get(1), 因此通过 spy 调用这些方法时, 实际上是委派给 list 对象来调用的。
//        然而我们 定义了 spy.size() 的返回值, 因此当调用 spy.size() 时, 返回100。
    }

    /**
     * 参数捕获
     *
     * @author 悟纤「公众号SpringBoot」
     * @date 2020-11-29
     * @slogan 大道至简 悟在天成
     */
    @Test
    public void testCaptureArgument() {
        List<String> list = Arrays.asList("悟纤", "师傅");
        List mockList = Mockito.mock(List.class);

        //参数捕获器：clazz Type matching the parameter to be captured.
        ArgumentCaptor<List> argument = ArgumentCaptor.forClass(List.class);
        mockList.addAll(list);
        Mockito.verify(mockList).addAll(argument.capture());

        Assert.assertEquals(2, argument.getValue().size());
        Assert.assertEquals(list, argument.getValue());

        //  我们通过verify(mockedList).addAll(argument.capture()) 语句来获取mockedList.addAll 方法所传递的实参 list.
    }
}
