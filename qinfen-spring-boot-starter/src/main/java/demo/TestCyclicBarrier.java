package demo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < barrier.getParties(); i++) {
            new Thread(new MyThread(barrier), "player" + i).start();
        }
        System.out.println("game begin");
    }

    private static class MyThread implements Runnable {
        private CyclicBarrier barrier;

        private MyThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            for (int k = 0; k < 3; k++) {
                Random random = new Random();
                int i = random.nextInt((3000 - 1000) + 1) + 1000;
                try {
                    Thread.sleep(i);
                    System.out.println(Thread.currentThread().getName() + " get through " + i + " barrier,used time : " + (double) i / 1000 + "s");
                    this.barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
