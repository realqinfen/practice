package com.practice.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/***
 * @Description Semaphore与CountDownLatch相似，不同的地方在于Semaphore的值被获取到后是可以释放的，
 * 并不像CountDownLatch那样一直减到底。它也被更多地用来限制流量，类似阀门的 功能。
 * 如果限定某些资源最多有N个线程可以访问，那么超过N个主不允许再有线程来访问，同时当现有线程结束后，
 * 就会释放，然后允许新的线程进来。有点类似于锁的lock与 unlock过程。相对来说他也有两个主要的方法：
 * 用于获取权限的acquire(),其底层实现与CountDownLatch.countdown()类似;
 * 用于释放权限的release()，其底层实现与acquire()是一个互逆的过程。
 * @Author fen.qin  0:07 2020/4/21
 **/
public class Semaphore4 {
    public static final int THREAD_COUNT = 20;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    if (semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)) {//尝试获取多个许可
                        test(threadNum);
                        semaphore.release();//释放一个许可
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        System.out.println("thread:" + threadNum);
        Thread.sleep(1000);
    }
}
