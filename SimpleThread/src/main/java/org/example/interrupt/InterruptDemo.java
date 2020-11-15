package org.example.interrupt;

/**
 * 线程的终止
 */
public class InterruptDemo implements Runnable{

    private int i = 0;

    @Override
    public void run() {
        // 没有收到终止信号
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("TEST: " + i++);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
//        thread.stop();
        thread.interrupt();
    }
}
