package com.aji.java;

/**
 * @author aji
 * @create 2021-06-17 22:53
 */
public class Clerk {
    private int product = 20;
    private Object obj = new Object();


    public static void main(String[] args) {
        Clerk clerk = new Clerk();
/*        Productor p = new Productor(clerk);
        Customer c = new Customer(clerk);
        Thread th1 = new Thread(p);
        Thread th2 = new Thread(c);*/
        Thread th1 = new Thread(new Productor(clerk));
        Thread th2 = new Thread(new Customer(clerk));
        th1.setName("生产者");
        th2.setName("消费者");
        th1.start();
        th2.start();
    }

    public synchronized void addProduct() {
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            product++;
            System.out.println(Thread.currentThread().getName() + "现在共计:" + product);
            notifyAll();
        }
    }

    public synchronized void getProduct() {
        if (product <= 0) {
            try {
                wait();
                //Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {

            System.out.println(Thread.currentThread().getName() + "正在消费：" + product);
            product--;
            notifyAll();
        }
    }
}

class Productor implements Runnable {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始进行生产");
        while (true) {
            try {
                Thread.sleep(100);
                clerk.addProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Customer implements Runnable {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始进行消费");
        while (true) {
            try {
                Thread.sleep(50);
                clerk.getProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}