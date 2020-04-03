package demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TestCountLatch {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < latch.getCount(); i++) {
            new Thread(new MyThread(latch), "player" + i).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("game start");
    }

    private static class MyThread implements Runnable {
        private CountDownLatch latch;

        private MyThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            Random random = new Random();
            int i = random.nextInt((3000 - 1000) + 1) + 1000;//1000到3000之间的随机数
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is ready,used time : " + (double) i / 1000 + "s");
            latch.countDown();
        }
    }

}
