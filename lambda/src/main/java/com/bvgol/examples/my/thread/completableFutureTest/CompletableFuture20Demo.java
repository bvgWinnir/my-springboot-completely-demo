package com.bvgol.examples.my.thread.completableFutureTest;/**
 * @Classname CompletableFuture20Demo
 * @Description TODO
 * @Date 2020/12/28 13:56
 * @Created by GUOCHEN
 */

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @program: my-springboot-completely
 * @description: 20个示例
 * @author: GUOCHEN
 * @create: 2020/12/28 13:56
 */
public class CompletableFuture20Demo {
    static void completedFutureExample() {
//    该getNow(null)如果完成的结果返回（这显然是这种情况），但否则返回NULL（参数）。
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        assertTrue(cf.isDone());
        assertEquals("message", cf.getNow(null));
    }

    //下一个示例是如何创建一个Runnable异步执行的阶段：
    //该示例的要点是两件事：
    // 1. 当方法通常以关键字结尾时，将异步执行CompletableFuture Async
    //2. 默认情况下（未Executor指定no时），异步执行使用通用ForkJoinPool实现，该通用实现使用守护程序线程执行Runnable任务。
    // 请注意，这特定于CompletableFuture。其他CompletionStage实现可以覆盖默认行为。
    static void runAsyncExample() {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            assertTrue(Thread.currentThread().isDaemon());
            randomSleep();
        });
        assertFalse(cf.isDone());
        sleepEnough();
        assertTrue(cf.isDone());
    }

    private static void sleepEnough() {

    }

    //下面的示例采用CompletableFuture示例＃1 的完成内容，其中包含结果字符串，"message" 并应用将其转换为大写字母的函数：
    static void thenApplyExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            assertFalse(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        assertEquals("MESSAGE", cf.getNow(null));
    }
    //注意以下行为关键字thenApply：
    //1. then，这意味着该阶段的操作在当前阶段正常完成时发生（无例外）。在这种情况下，当前阶段已经完成，值为“ message”。
    //2. Apply，这意味着返回的阶段将对Function上一个阶段的结果应用a 。
    //Functionwill 的执行将被阻塞，这意味着只有在完成大写操作后才能到达getNow（）。

    //4. Function在上一阶段异步应用a
    //  通过将Async后缀附加到上一个示例中的方法，链接的链CompletableFuture将异步执行（使用ForkJoinPool.commonPool()）。
    static void thenApplyAsyncExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            assertTrue(Thread.currentThread().isDaemon());
            randomSleep();
            return s.toUpperCase();
        });
        assertNull(cf.getNow(null));
        assertEquals("MESSAGE", cf.join());
    }

    //5.使用自定义执行器在上一阶段异步应用功能
    //异步方法的一个非常有用的功能是能够提供一个Executor使用它来执行所需的函数的能力CompletableFuture。此示例说明如何使用固定线程池应用大写转换Function：
    static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        int count = 1;

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "custom-executor-" + count++);
        }
    });

    static void thenApplyAsyncWithExecutorExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            assertTrue(Thread.currentThread().getName().startsWith("custom-executor-"));
            assertFalse(Thread.currentThread().isDaemon());
            randomSleep();
            return s.toUpperCase();
        }, executor);
        assertNull(cf.getNow(null));
        assertEquals("MESSAGE", cf.join());
    }

    private static void randomSleep() {
    }

    //6.消耗上一阶段的结果

    //如果下一阶段接受当前阶段的结果，但不需要在计算中返回值（即，其返回类型为void），则Function可以应用a ，而不是应用a Consumer，因此该方法为thenAccept：
    static void thenAcceptExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture("thenAccept message")
                .thenAccept(s -> result.append(s));
        assertTrue("Result was empty", result.length() > 0);
    }
    //在Consumer将同步执行，所以我们并不需要加入对返回CompletableFuture。

    //    7.异步消耗上一阶段的结果
//    同样，使用的异步版本thenAccept，链式CompletableFuture将异步执行：
    static void thenAcceptAsyncExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture<Void> cf = CompletableFuture.completedFuture("thenAcceptAsync message")
                .thenAcceptAsync(s -> result.append(s));
        cf.join();
        assertTrue("Result was empty", result.length() > 0);
    }

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    //    8.异常完成计算
//    现在，让我们看看如何异常地显式完成异步操作，从而指示计算失败。为简单起见，该操作采用一个字符串并将其转换为大写，并且我们模拟了1秒的操作延迟。
//    为此，我们将使用该thenApplyAsync(Function, Executor)方法，其中第一个参数是大写函数，而执行程序是延迟的执行程序，在实际将操作提交给common之前，它会等待1秒钟ForkJoinPool。
    static void completeExceptionallyExample() throws InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message")
                .thenApplyAsync(String::toUpperCase, executorService);
        CompletableFuture<String> exceptionHandler = cf.handle((s, th) -> {
            return (th != null) ? "message upon cancel" : "";
        });
        cf.completeExceptionally(new RuntimeException("completed exceptionally"));
        assertTrue("Was not completed exceptionally", cf.isCompletedExceptionally());
        try {
            cf.join();
            fail("Should have thrown an exception");
        } catch (CompletionException ex) { // just for testing
            assertEquals("completed exceptionally", ex.getCause().getMessage());
        }
        assertEquals("message upon cancel", exceptionHandler.join());
    }
//       让我们详细研究这个示例：
//            · 首先，我们创建一个CompletableFuture已经使用value完成的"message"。接下来，我们调用thenApplyAsync，它返回一个new CompletableFuture。此方法在第一阶段完成时（已经完成，因此Function将立即执行）以异步方式应用大写转换。此示例还说明了使用该delayedExecutor(timeout, timeUnit)方法延迟异步任务的方法。
//            · 然后，我们创建一个单独的“ handler”阶段exceptionHandler，该阶段通过返回另一条消息来处理任何异常"message upon cancel"。
//            · 接下来，我们明确地完成了第二阶段，但有一个例外。这使得join()正在执行大写操作的舞台上的方法抛出a CompletionException（通常join()将等待1秒以获取大写字符串）。它还将触发处理程序阶段。

    //9.取消计算
    //非常接近完成，我们可以通过界面上的cancel(boolean mayInterruptIfRunning)方法取消计算Future。对于CompletableFuture，不使用boolean参数，因为实现不使用中断来进行取消。而是cancel()等效于completeExceptionally(new CancellationException())。
    static void cancelExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
//                .thenApplyAsync(String::toUpperCase, CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));
        CompletableFuture<String> cf2 = cf.exceptionally(throwable -> "canceled message");
        assertTrue("Was not canceled", cf.cancel(true));
        assertTrue("Was not completed exceptionally", cf.isCompletedExceptionally());
        assertEquals("canceled message", cf2.join());
    }

    //10.将函数应用于两个完成阶段之一的结果
    //下面的示例创建一个CompletableFuture将a应用于Function前两个阶段中任一阶段的结果（不保证将其中一个传递给Function）。有问题的两个阶段是：一个将大写转换应用于原始字符串，另一个将小写转换应用于：
    static void applyToEitherExample() {
        String original = "Message";
        CompletableFuture<String> cf1 = CompletableFuture.completedFuture(original)
                .thenApplyAsync(s -> delayedUpperCase(s));
        CompletableFuture<String> cf2 = cf1.applyToEither(
                CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
                s -> s + " from applyToEither");
        assertTrue(cf2.join().endsWith(" from applyToEither"));

    }

    private static String delayedLowerCase(String s) {
        return s.toLowerCase();
    }

    private static String delayedUpperCase(String s) {
        return s.toUpperCase();
    }

    //11.消费两个完成阶段中任何一个的结果
    //与上一个示例类似，但是使用a Consumer代替a Function（依赖项CompletableFuture的类型为void）：
    static void acceptEitherExample() {
        String original = "Message";
        StringBuffer result = new StringBuffer();
        CompletableFuture<Void> cf = CompletableFuture.completedFuture(original)
                .thenApplyAsync(s -> delayedUpperCase(s))
                .acceptEither(CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
                        s -> result.append(s).append("acceptEither"));
        cf.join();
        assertTrue("Result was empty", result.toString().endsWith("acceptEither"));
    }
    //  注意这里使用线程安全 StringBuffer 而不是 StringBuilder。

    // 12.在两个阶段完成时运行可运行文件
    // 此示例显示了两个阶段都完成时CompletableFuture执行Runnable触发器的依赖项。请注意，下面的所有阶段都是同步运行的，其中一个阶段首先将消息字符串转换为大写，然后第二阶段将相同消息字符串转换为小写。
    static void runAfterBothExample() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).runAfterBoth(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                () -> result.append("done"));
        assertTrue("Result was empty", result.length() > 0);
    }

    //13.在BiConsumer中接受两个阶段的结果
    // 如果需要Runnable，可以使用而不是在两个阶段均完成时执行BiConsumer：
    static void thenAcceptBothExample() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).thenAcceptBoth(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                (s1, s2) -> result.append(s1 + s2));
        assertEquals("MESSAGEmessage", result.toString());
    }

    //14.在两个阶段的结果上应用BiFunction
    // 如果依赖项CompletableFuture旨在通过对两个前一个CompletableFutures 的结果应用函数并返回结果来合并结果，则可以使用method thenCombine()。整个流水线是同步的，因此getNow()最后将检索最终结果，即大写和小写结果的串联。
    static void thenCombineExample() {
        String original = "Message";
        CompletableFuture<String> cf = CompletableFuture.completedFuture(original).thenApply(s -> delayedUpperCase(s))
                .thenCombine(CompletableFuture.completedFuture(original).thenApply(s -> delayedLowerCase(s)),
                        (s1, s2) -> s1 + s2);
        assertEquals("MESSAGEmessage", cf.getNow(null));
    }

    //15.在两个阶段的结果上异步应用BiFunction
    //与前面的示例相似，但是具有不同的行为：由于两个CompletableFuture依赖的两个阶段都异步运行，因此该thenCombine()方法即使没有Async后缀也异步执行。这在Javadocs类中得到了记录：“为非异步方法的相关完成提供的操作可以由完成当前CompletableFuture的线程或完成方法的任何其他调用者执行。” 因此，我们需要join()对合并CompletableFuture进行等待结果。
    static void thenCombineAsyncExample() {
        String original = "Message";
        CompletableFuture<String> cf = CompletableFuture.completedFuture(original)
                .thenApplyAsync(s -> delayedUpperCase(s))
                .thenCombine(CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
                        (s1, s2) -> s1 + s2);
        assertEquals("MESSAGEmessage", cf.join());
    }

    //16.组成CompletableFutures
    // 我们可以使用组合使用thenCompose()来完成与前两个示例相同的计算。此方法等待第一阶段（应用大写转换）完成。其结果传递到指定的结果，该结果Function返回a CompletableFuture，其结果将是返回的结果CompletableFuture。在这种情况下，函数采用大写字符串（upper），然后返回CompletableFuture将original字符串转换成小写形式的，然后将其附加到upper。
    static void thenComposeExample() {
        String original = "Message";
        CompletableFuture<String> cf = CompletableFuture.completedFuture(original).thenApply(s -> delayedUpperCase(s))
                .thenCompose(upper -> CompletableFuture.completedFuture(original).thenApply(s -> delayedLowerCase(s))
                        .thenApply(s -> upper + s));
        assertEquals("MESSAGEmessage", cf.join());
    }

    //17.创建一个可以在多个阶段中的任何一个完成时完成的阶段
    // 以下示例说明了如何创建一个CompletableFuture在多个CompletableFutures中的任何一个完成时都完成且结果相同的。首先创建几个阶段，每个阶段都将字符串从列表转换为大写。由于所有这些CompletableFuture都正在同步执行（使用thenApply()），因此CompletableFuture从返回的内容anyOf()将立即执行，因为到调用它时，所有阶段都已完成。然后whenComplete(BiConsumer<? super Object, ? super Throwable> action)，我们使用来处理结果（断言结果为大写）。
    static void anyOfExample() {
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> delayedUpperCase(s)))
                .collect(Collectors.toList());
        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res, th) -> {
            if (th == null) {
                assertTrue(isUpperCase((String) res));
                result.append(res);
            }
        });
        assertTrue("Result was empty", result.length() > 0);
    }

    private static boolean isUpperCase(String res) {
        return false;
    }

    //18.创建一个阶段，当所有阶段完成时完成
    //接下来的两个示例说明了如何分别以同步和异步的方式创建一个CompletableFuture同时完成多个CompletableFutures的完整的。该方案与前面的示例相同：提供了一个字符串列表，其中每个元素都转换为大写。
    static void allOfExample() {
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> delayedUpperCase(s)))
                .collect(Collectors.toList());
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((v, th) -> {
            futures.forEach(cf -> assertTrue(isUpperCase(cf.getNow(null))));
            result.append("done");
        });
        assertTrue("Result was empty", result.length() > 0);
    }

    //19.创建一个在所有阶段都完成时异步完成的阶段
    // 通过切换到thenApplyAsync()单个CompletableFutures，返回的阶段由allOf()完成阶段的公共池线程之一执行。因此，我们需要调用join()它以等待其完成。
    static void allOfAsyncExample() {
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(s -> delayedUpperCase(s)))
                .collect(Collectors.toList());
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .whenComplete((v, th) -> {
                    futures.forEach(cf -> assertTrue(isUpperCase(cf.getNow(null))));
                    result.append("done");
                });
        allOf.join();
        assertTrue("Result was empty", result.length() > 0);
    }

    //20.现实生活中的例子
    // 现在已经探究了CompletionStage和的功能CompletableFuture，下面的示例将它们应用于实际情况：
    // 1. 首先，Car通过调用cars()方法异步获取对象列表，该方法返回CompletionStage<List>。该cars()方法可能会在后台消耗远程REST端点。
    //2. 然后CompletionStage<List>，我们通过调用rating(manufacturerId)返回CompletionStage异步获取汽车额定值的方法（又可能会消耗REST端点）来组成另一个用于填充每个汽车额定值的方法。
    //3. 当所有Car对象都充满其评价时，我们以结束List<CompletionStage>，因此我们调用allOf()以获取最后一个阶段（存储在variable中done），该阶段在所有这些阶段完成时完成。
    //4. 使用whenComplete()在最后阶段，我们打印出Car他们的评级对象。
    private void demo() {
//        cars().thenCompose(cars ->
//        {
//            List<CompletionStage<Car>> updatedCars = cars.stream()
//                    .map(car -> rating(car.manufacturerId).thenApply(r -> {
//                        car.setRating(r);
//                        return car;
//                    })).collect(Collectors.toList());
//            CompletableFuture<Void> done = CompletableFuture
//                    .allOf(updatedCars.toArray(new CompletableFuture[updatedCars.size()]));
//            return done.thenApply(v -> updatedCars.stream().map(CompletionStage::toCompletableFuture)
//                    .map(CompletableFuture::join).collect(Collectors.toList()));
//        }).whenComplete((cars, th) -> {
//            if (th == null) {
//                cars.forEach(System.out::println);
//            } else {
//                throw new RuntimeException(th);
//            }
//        }).toCompletableFuture().join();
    }

    public CompletionStage<Car> cars() {
        return null;
    }

    //由于Car所有实例都是独立的，因此异步获取每个评级可以提高性能。此外，与使用allOf()手动线程等待（例如使用Thread#join()或CountDownLatch）相反，使用更自然的方法来等待所有汽车额定值被填满。
}

@Data
class Car {
    private Integer manufacturerId;
    private String rating;
}
