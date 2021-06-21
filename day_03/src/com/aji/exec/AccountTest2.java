package com.aji.exec;

/**
 * @author aji
 * @create 2021-06-17 11:52
 */
public class AccountTest2 {
    public static void main(String[] args) {
        Account1 acct = new Account1();
        Costumer c1 = new Costumer(acct);
        Costumer c2 = new Costumer(acct);
        c1.setName("一号");
        c2.setName("二号");
        c1.start();
        c2.start();
    }
}
class Account1{
    private int balance;
    public synchronized void deposit(double amt){
        if (amt > 0){
            balance+=amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存钱成功，余额为："+balance);
        }
    }
}

class Costumer extends Thread{
    private Account1 acct;

    public Costumer(Account1 acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            acct.deposit(1000);
        }
    }
}