1.无参,无返回值
 Runnable r2 =() -> System.out.println("hi 8");
2.有一个参数,无返回值
 Consumer<String > fun =  (args)->System.out.println(args);
3.有一个参数,无返回值,参数的小括号可以省略
 Consumer<String > fun =  args->System.out.println(args);
 Consumer<String > fun2 =  System.out::println;
4.两个参数,有返回值
  BinaryOperator<Long> bo = (x,y)->{
          System.out.println("模拟这里有一条语句,否则可以简化为 BinaryOperator<Long> bo = (x,y)->x+y    ");
          return x+y;
        };
5.两个参数,有返回值,只有一句时,return可以省略
BinaryOperator<Long> bo1 = (x,y) -> x+y;
6.两个参数,有返回值,只有一句时,参数类型可以省略
BinaryOperator<Long> bo1 = (Long x,Long y) -> x+y;


方法引用  ::
1.对象::实例方法名
2.类::静态方法名
3.类::实例方法名   (x,y)->x.equals(y) 第一个参数是调用者,第二个参数是调用者个参数时能用
   前提 !.lambda需要实现的方法的参数列表与返回值类型要与当前调用的方法的参数列表和返回值类型一致  才能用::
