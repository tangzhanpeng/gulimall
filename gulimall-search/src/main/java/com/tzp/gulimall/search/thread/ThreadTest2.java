package com.tzp.gulimall.search.thread;

import java.util.concurrent.*;

public class ThreadTest2 {
    public static final ExecutorService executor = new ThreadPoolExecutor(
            10,
            10,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main.....start.....");
//        CompletableFuture.runAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//        }, executor);
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 0;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor).whenComplete((res, e) -> {
//            System.out.println("异步任务成功完成了...结果是：" + res + ";异常是：" + e);
//        }).exceptionally(e -> 10);
        /**
         * 方法执行完成后的处理
         */
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor).handle((res, e) -> {
//            if (res != null) {
//                return res * 2;
//            }
//            if (e != null) {
//                return 0;
//            }
//            return 0;
//        });

        /**
         * 串行化
         * 1）.thenRunAsync(() -> {
         *             System.out.println("任务2启动了");
         *         }, executor);
         * 2)、能接收上一步的返回值
         * .thenAcceptAsync((res)->{
         *             System.out.println("任务2启动了"+res);
         *         }, executor)
         * 3)、能接收上一步返回值又可以有自己的返回值
         */
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor).thenApplyAsync(res -> {
//            System.out.println("任务2启动了" + res);
//            return 100;
//        }, executor);
//        Integer integer = future.get();

        /**
         * 两个都要完成
         */
//        CompletableFuture<Object> future01 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("任务1线程：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("任务2结果：" + i);
//            return i;
//        }, executor);
//
//        CompletableFuture<Object> future02 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("任务2线程：" + Thread.currentThread().getId());
//            String res = "hello";
//            System.out.println("任务2结果：" + res);
//            return res;
//        }, executor);

//        future01.runAfterBothAsync(future02, () -> {
//            System.out.println("任务3开始");
//        }, executor);

//        future01.thenAcceptBothAsync(future02, (res1, res2) -> {
//            System.out.println("任务3开始res1=" + res1 + ",res2=" + res2);
//        }, executor);

//        CompletableFuture<String> future3 = future01.thenCombineAsync(future02, (res1, res2) -> {
//            return res1 + ":" + res2;
//        }, executor);

        /**
         * 两个任务只要有一个执行完成就执行第三个任务
         */
//        future01.runAfterEitherAsync(future02, () -> {
//            System.out.println("任务3执行");
//        }, executor);

//        future01.acceptEitherAsync(future02, (res) -> {
//            System.out.println("任务3得到的结果" + res);
//        }, executor);

//        CompletableFuture<String> stringCompletableFuture = future01.applyToEitherAsync(future02, res -> {
//            System.out.println("任务3得到的结果" + res);
//            return "我是任务三的结果";
//        }, executor);

//        String s = stringCompletableFuture.get();

        /**
         * 多任务组合
         */
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("查询商品的图片信息");
            return "hello.jpg";
        }, executor);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("查询商品的属性");
            return "黑色";
        }, executor);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("查询商品的介绍");
            return "h华为";
        }, executor);

//        CompletableFuture<Void> all = CompletableFuture.allOf(future1, future2, future3);
//
//        all.get();

        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future1, future2, future3);

        anyOf.get();

        System.out.println("main....end....."+anyOf.get());
    }
}
