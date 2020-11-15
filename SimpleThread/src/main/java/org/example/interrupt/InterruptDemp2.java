package org.example.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemp2 implements Runnable {
    @Override
    public void run() {
        // Interrupted = false
        System.out.println(Thread.currentThread().isInterrupted());
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(200);
            } catch (InterruptedException e) { // 触发线程复位 -> false
                e.printStackTrace();
                // 可以不做处理
                // 继续中断 ->
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println("Process End");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new InterruptDemp2());
        t1.start();
        Thread.sleep(1000);
        t1.interrupt(); // 副作用
//        Thread.interrupted(); // 复位
    }
}
