package com.zhuyy.demo.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhuyy on 2017/2/15.
 */

public class Test1 {

    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        for (int i=0;i<15;i++) {
            MyTask myTask = new MyTask(i);
            threadPoolExecutor.execute(myTask);
            System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                    threadPoolExecutor.getQueue().size()+"，已执行玩别的任务数目："+threadPoolExecutor.getCompletedTaskCount());
        }
    }
}
class MyTask implements Runnable {

    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }
    @Override
    public void run() {
        System.out.println("正在执行task"+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task"+taskNum+"执行完毕");
    }
}
