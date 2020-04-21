package com.practice.example;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * @Description CyclicBarrier也是一个同步辅助类，它允许一组线程相互等待，
 * 直到到达某个公共屏障点（common barrier point）。通过它可以完成多个线程之间相互等待，
 * 只有当每个线程都准备就绪后，才能各自继续往下执行后面的操作。类似于CountDownLatch，
 * 它也是通过计数器来实现的。当某个线程调用await方法时，该线程进入等待状态，且计数器加1，
 * 当计数器的值达到设置的初始值时，所有因调用await进入等待状态的线程被唤醒，继续执行后续操作。
 * 因为CycliBarrier在释放等待线程后可以重用，所以称为循环barrier。CycliBarrier支持一个可选的Runnable，
 * 在计数器的值到达设定值后（但在释放所有线程之前），该Runnable运行一次，注，Runnable在每个屏障点只运行一个
 * @Author fen.qin  0:06 2020/4/21
 **/
public class CyclicBarrier3 {
    public static final CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        System.out.println("callback is running");
    });

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
