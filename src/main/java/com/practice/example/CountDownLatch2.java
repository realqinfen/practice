package com.practice.example;

import java.util.concurrent.*;

/***
 * @Description CountDownLatch是一个计数器闭锁，通过它可以完成类似于阻塞当前线程的功能，
 * 即：一个线程或多个线程一直等待，直到其他线程执行的操作完成。CountDownLatch用一个给定的计数器来初始化，
 * 该计数器的操作是原子操作，即同时只能有一个线程去操作该计数器。调用该类await方法的线程会一直处于阻塞状态，
 * 直到其他线程调用countDown方法使当前计数器的值变为零，每次调用countDown计数器的值减1。当计数器值减至零时，
 * 所有因调用await()方法而处于等待状态的线程就会继续往下执行。这种现象只会出现一次，因为计数器不能被重置，
 * 如果业务上需要一个可以重置计数次数的版本，可以考虑使用CycliBarrier。
 * 在某些业务场景中，程序执行需要等待某个条件完成后才能继续执行后续的操作；典型的应用如并行计算，
 * 当某个处理的运算量很大时，可以将该运算任务拆分成多个子任务，等待所有的子任务都完成之后，
 * 父任务再拿到所有子任务的运算结果进行汇总。
 * @Author fen.qin  0:16 2020/4/18
 **/
public class CountDownLatch2 {
    private static final int threadCount = 200;

    public static void main(String[] args) throws Exception {
        System.out.println("this is my first code on mac");
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(()->{
                try {
                    Thread.sleep(100);
                    System.out.println(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        System.out.println("finish");
        exec.shutdown();

    }
}
