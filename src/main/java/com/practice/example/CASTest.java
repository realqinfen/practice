package com.practice.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class CASTest implements Runnable {
    private AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        CASTest cas = new CASTest();
        Thread t1 = new Thread(cas);
        Thread t2 = new Thread(cas);
        t1.start();
        t2.start();
    }

    /***
     * @Description compareAndSet(true, false)方法要拆开成compare(true)方法和Set(false)方法理解，是compare(true)是等于true后，
     * 就马上设置共享内存为false，这个时候，其它线程无论怎么走都无法走到只有得到共享内存为true时的程序隔离方法区。
     * @Author fen.qin  11:02 2020/4/16
     **/
    @Override
    public void run() {
        System.out.println("thread:" + Thread.currentThread().getName() + ";flag:" + flag.get());
        if (flag.compareAndSet(true, false)) {
            System.out.println(Thread.currentThread().getName() + ":" + flag.get());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag.set(true);
        } else {
            System.out.println("重试机制thread：" + Thread.currentThread().getName() + ":" + flag.get());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }
    }
}
