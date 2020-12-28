package com.bvgol.nulltest;/**
 * @Classname OptionalTest
 * @Description TODO
 * @Date 2020/12/17 10:01
 * @Created by GUOCHEN
 */

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @program: my-springboot-completely
 * @description: optional测试
 * @author: GUOCHEN
 * @create: 2020/12/17 10:01
 */
public class OptionalTest {
    public static void main(String[] args) {
        OptionalTest o = new OptionalTest();
//        o.of();
//        o.ofNullable();
//        o.isPresent();
//        o.optionalGet();
//        o.ifPresent();
//        o.orElse();
//        o.orElseGet();
//        o.orElseThrow();
//        o.optionalMap();
//        o.flatMap();
        o.filter();

    }

    Optional<String> name = Optional.of("smith");
    Optional empty = Optional.ofNullable(null);

    public void of() {
        /* of */
        //为非null的值创建一个Optional。
        //of方法通过工厂方法创建Optional类。需要注意的是，创建对象时传入的参数不能为null。如果传入参数为null，则抛出NullPointerException
        //调用工厂方法穿点optional实例

        //传入参数为null,抛出nullPointerException
        Optional<String> ofnull = Optional.of(null); //这一行就会抛出空指针
        System.out.println(ofnull.get());
    }

    public void ofNullable() {
        //为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。
        empty.get();//这一行报错 java.util.NoSuchElementException: No value present
    }

    public void isPresent() {
        //如果值存在返回true，否则返回false
        if (name.isPresent()) {
            System.out.println(name.get());
        }
    }

    public void optionalGet() {//如果Optional有值则将其返回，否则抛出NoSuchElementException
        try {
            System.out.println(empty.get());
        } catch (
                NoSuchElementException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void ifPresent() {//如果Optional实例有值则为其调用consumer，否则不做处理
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });
    }

    public void orElse() {
        //如果有值则将其返回，否则返回指定的其它值。
        System.out.println(empty.orElse("There is no value present!"));
        System.out.println(name.orElse("There is some value!"));
    }

    public void orElseGet() {
        //orElseGet与orElse方法类似，区别在于得到的默认值。
        // orElse方法将传入的字符串作为默认值，
        // orElseGet方法可以接受Supplier接口的实现用来生成默认值
        System.out.println(empty.orElseGet(() -> "Default Value"));
        System.out.println(name.orElseGet(String::new));
    }

    public void orElseThrow() {
        //如果有值则将其返回，否则抛出supplier接口创建的异常。
        // 在orElseGet方法中，我们传入一个Supplier接口。然而，在orElseThrow中我们可以传入一个lambda表达式或方法，如果值不存在来抛出异常。
        try {
            empty.orElseThrow(IllegalArgumentException::new);
        } catch (Throwable ex) {
            System.out.println("error:" + ex.getMessage());
        }
    }

    public void optionalMap() {
        //如果有值，则对其执行调用mapping函数得到返回值。
        //  如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional。
        //map方法用来对Optional实例的值执行一系列操作。通过一组实现了Function接口的lambda表达式传入操作。
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));
    }

    public void flatMap() {
        //如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional。
        //flatMap方法与map方法类似，
        // 区别在于mapping函数的返回值不同。
        // map方法的mapping函数返回值可以是任何类型T，
        // 而flatMap方法的mapping函数必须是Optional。
        //参照map函数，使用flatMap重写的示例如下：
        Optional<String> upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.get());
    }

    public void filter() {
        //如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional。
        //这里可以传入一个lambda表达式。对于filter函数我们应该传入实现了Predicate接口的lambda表达式。
        List<String> names = Arrays.asList("YanWei", "YanTian");
        for (String s : names) {
            Optional<String> nameLenLessThan7 = Optional.of(s).filter((value) -> value.length() < 7);
            System.out.println(nameLenLessThan7.orElse("The name is more than 6 characters"));
        }
    }

}
