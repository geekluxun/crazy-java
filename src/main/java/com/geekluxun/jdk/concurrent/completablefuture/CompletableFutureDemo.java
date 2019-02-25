package com.geekluxun.jdk.concurrent.completablefuture;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-02-25 12:31
 * @Description:
 * @Other:
 */
public class CompletableFutureDemo {

    public static void main(String[] argc) {
        CompletableFutureDemo demo = new CompletableFutureDemo();
        demo.demo1();
        demo.thenApplyExample();
        demo.thenApplyAsyncWithExecutorExample();
        demo.thenAcceptExample();
        demo.thenAcceptAsyncExample();
        demo.completeExceptionallyExample();
        demo.cancelExample();
        demo.applyToEitherExample();
    }

    private void demo1() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        Assert.isTrue(cf.isDone());
        Assert.isTrue("message".equals(cf.getNow(null)));
    }

    /**
     * 同步执行动作
     */
    private void thenApplyExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            Assert.isTrue(!Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        Assert.isTrue("MESSAGE".equals(cf.getNow(null)));
    }

    /**
     * 异步执行动作
     */
    private void thenApplyAsyncExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            Assert.isTrue(!Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        Assert.isTrue("MESSAGE".equals(cf.getNow(null)));
    }


    static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        int count = 1;

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "custom-executor-" + count++);
        }
    });

    /**
     * 通过线程池异步完成任务
     */
    private void thenApplyAsyncWithExecutorExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            Assert.isTrue(Thread.currentThread().getName().startsWith("custom-executor-"));
            Assert.isTrue(!Thread.currentThread().isDaemon());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s.toUpperCase();
        }, executor);

        Assert.isNull(cf.getNow(null));
        Assert.isTrue("MESSAGE".equals(cf.join()));
        Assert.isTrue(true);
    }


    static void thenAcceptExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture("thenAccept message")
                .thenAccept(s -> result.append(s));
        Assert.isTrue(result.length() > 0);
    }


    static void thenAcceptAsyncExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture<Void> cf = CompletableFuture.completedFuture("thenAcceptAsync message")
                .thenAcceptAsync(s -> result.append(s));
        cf.join();
        Assert.isTrue(result.length() > 0);
    }


    static void completeExceptionallyExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase,
                CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));

        CompletableFuture<String> exceptionHandler = cf.handle((s, th) -> {
            return (th != null) ? "message upon cancel" : "";
        });

        cf.completeExceptionally(new RuntimeException("completed exceptionally"));
        Assert.isTrue(cf.isCompletedExceptionally());

        try {
            cf.join();
            //fail("Should have thrown an exception");
        } catch (CompletionException ex) { // just for testing
            Assert.isTrue("completed exceptionally".equals(ex.getCause().getMessage()));
        }
        Assert.isTrue("message upon cancel".equals(exceptionHandler.join()));
    }

    /**
     * 取消计算任务
     */
    static void cancelExample() {
        // 延迟1秒计算
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase,
                CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));

        CompletableFuture cf2 = cf.exceptionally(throwable -> "canceled message");
        Assert.isTrue(cf.cancel(true));
        Assert.isTrue(cf.isCompletedExceptionally());
        Assert.isTrue("canceled message".equals(cf2.join()));
    }


    /**
     * 一个 CompletableFuture 接收两个异步计算的结果
     */
    static void applyToEitherExample() {
        String original = "Message";
        CompletableFuture cf1 = CompletableFuture.completedFuture(original)
                .thenApplyAsync(String::toUpperCase, CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));

        CompletableFuture cf2 = cf1.applyToEither(
                CompletableFuture.completedFuture(original).thenApplyAsync(String::toUpperCase, CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS)),
                s -> s + " from applyToEither");

        Assert.isTrue(((String) cf2.join()).endsWith(" from applyToEither"));
    }

    static void runAfterBothExample() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).runAfterBoth(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                () -> result.append("done"));
        Assert.isTrue(result.length() > 0);
    }

    static void thenAcceptBothExample() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).thenAcceptBoth(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                (s1, s2) -> result.append(s1 + s2));
        Assert.isTrue("MESSAGEmessage".equals(result.toString()));
    }

    static void thenCombineExample() {
        String original = "Message";
        CompletableFuture cf = CompletableFuture.completedFuture(original).thenApply(s -> delayedUpperCase(s))
                .thenCombine(CompletableFuture.completedFuture(original).thenApply(s -> delayedLowerCase(s)),
                        (s1, s2) -> s1 + s2);

        Assert.isTrue("MESSAGEmessage".equals(cf.getNow(null)));
    }


    static void thenCombineAsyncExample() {
        String original = "Message";
        CompletableFuture cf = CompletableFuture.completedFuture(original)
                .thenApplyAsync(s -> delayedUpperCase(s))
                .thenCombine(CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
                        (s1, s2) -> s1 + s2);
        Assert.isTrue("MESSAGEmessage".equals(cf.join()));
    }


    static void thenComposeExample() {
        String original = "Message";
        CompletableFuture cf = CompletableFuture.completedFuture(original).thenApply(s -> delayedUpperCase(s))
                .thenCompose(upper -> CompletableFuture.completedFuture(original).thenApply(s -> delayedLowerCase(s))
                        .thenApply(s -> upper + s));
        Assert.isTrue("MESSAGEmessage".equals(cf.join()));
    }


//    static void anyOfExample() {
//        StringBuilder result = new StringBuilder();
//        List messages = Arrays.asList("a", "b", "c");
//        List<CompletableFuture> futures = messages.stream()
//                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> delayedUpperCase(s)))
//                .collect(Collectors.toList());
//        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res, th) -> {
//            if(th == null) {
//                Assert.isTrue(isUpperCase((String) res));
//                result.append(res);
//            }
//        });
//        Assert.isTrue(result.length() > 0);
//    }

//    static void allOfExample() {
//        StringBuilder result = new StringBuilder();
//        List messages = Arrays.asList("a", "b", "c");
//        List<CompletableFuture> futures = messages.stream()
//                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> delayedUpperCase(s)))
//                .collect(Collectors.toList());
//        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((v, th) -> {
//            futures.forEach(cf -> Assert.isTrue(isUpperCase(cf.getNow(null))));
//            result.append("done");
//        });
//        Assert.isTrue(result.length() > 0);
//    }

//    static void allOfAsyncExample() {
//        StringBuilder result = new StringBuilder();
//        List messages = Arrays.asList("a", "b", "c");
//        List<CompletableFuture> futures = messages.stream()
//                .map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(s -> delayedUpperCase(s)))
//                .collect(Collectors.toList());
//        CompletableFuture allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
//                .whenComplete((v, th) -> {
//                    futures.forEach(cf -> Assert.isTrue(isUpperCase(cf.getNow(null))));
//                    result.append("done");
//                });
//        allOf.join();
//        Assert.isTrue(result.length() > 0);
//    }

    private static boolean isUpperCase(String s) {
        return StringUtils.isAllUpperCase(s);
    }

    private static List delayedUpperCase(Object s) {
        return new ArrayList();
    }

    private static String delayedLowerCase(String s) {
        return s.toLowerCase();
    }
}
