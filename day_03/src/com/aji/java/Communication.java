package com.aji.java;

/**
 * 使用两个线程打印 1-100。线程1, 线程2 交替打印
 *需同步代码块中
 * wait,notify,notifyALl需同步代码块中的同步监视器调用
 * @author aji
 * @create 2021-06-17 22:07
 */
public class Communication implements Runnable{
    private int num = 1;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized(obj){
                obj.notify();
                try {
                    Thread.sleep(100);
                    if (num <= 100){
                        System.out.println(Thread.currentThread().getName()+"："+num);
                        num++;
                        obj.wait();
                    }else {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Communication com = new Communication();
        Thread th1 = new Thread(com);
        Thread th2 = new Thread(com);
        th1.setName("线程一");
        th2.setName("线程二");
        th1.start();
        th2.start();
    }
}
