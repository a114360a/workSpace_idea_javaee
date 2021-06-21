package com.aji.java;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * call方法有返回值，可以抛出异常
 *
 * 1.创建类实现Callable接口
 * 2.重写call方法
 * 3.创建该类的对象
 * 4.创建FutureTask对象，该类对象填入构造器内
 * 5.通过FutureTask的get方法获取call方法返回值
 * 6.创建Thread把FutureTask对象填入构造器内
 * 7.调用start方法启动线程
 *
 * @author aji
 * @create 2021-06-18 0:11
 */
//1
public class CallableTest implements Callable {
    //2
    @Override
    public Object call() throws Exception {
        int num = 0;
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                num += i;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        //3
        CallableTest callable = new CallableTest();
        //4
        FutureTask futureTask = new FutureTask(callable);
        //6和7
        new Thread(futureTask).start();
        try {
            //5
            Object num = futureTask.get();
            System.out.println(num.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
