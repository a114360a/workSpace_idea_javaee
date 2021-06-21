package com.aji.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/** 线程池创建多线程
 * 1.ExecutorServer实现Executors对象
 * 2.调用Executor方法 execute方法适用于Runnable，submit适用于Callable
 * 3.设置线程池的属性，需要向下转型为ThreadPoolExecutor类
 * @author aji
 * @create 2021-06-18 10:11
 */
class RunnableTest implements Runnable{

    @Override
    public void run() {
        System.out.println("线程启动了！");
    }
}
public class ThreadPoolTest {
    public static void main(String[] args) {
        //1
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor ThreadPool = (ThreadPoolExecutor) executorService;
        //2
        executorService.execute(new RunnableTest());

        System.out.println(ThreadPool.getPoolSize());
        ThreadPool.shutdown();

    }
}
