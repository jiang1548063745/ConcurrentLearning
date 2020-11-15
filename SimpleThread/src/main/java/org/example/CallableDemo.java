package org.example;

import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {


    @Override
    public String call() throws Exception {
        System.out.println("come in");
        return "SUCCESS";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallableDemo callableDemo = new CallableDemo();
        Future<String> future = executorService.submit(callableDemo);

        String result = future.get(); // 阻塞的
        System.out.println(result);
        System.out.println(future.isDone());
        System.out.println(future.cancel(false));
    }
}
