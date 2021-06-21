package com.aji.exec;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 * 问题：该程序是否有安全问题，如果有，如何解决？
 * 【提示】 1，明确哪些代码是多线程运行代码，须写入run()方法
 * 2，明确什么是共享数据。
 * 3，明确多线程运行代码中哪些语句是操作共享数据的.
 * @author aji
 * @create 2021-06-17 11:01
 */
public class Account implements Runnable{
    private int balance;
    //private int count = 0;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        int count = 0;
        while (true){
            try {
                lock.lock();
                if (count < 3){
                    System.out.println(Thread.currentThread().getName()+"余额为："+balance);
                    balance += 1000;
                }else {
                    break;
                }
                count++;
            }finally {
                lock.unlock();
            }

        }
    }
}
