package com.practice.example;

import java.util.concurrent.*;

public class CyclicBarrier1 {
    public static final CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println("thread:" + threadNum + " is ready");
        barrier.await();
        System.out.println("thread:" + threadNum + " continue");
    }
}
