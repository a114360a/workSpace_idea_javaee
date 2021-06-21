package com.aji.exec;

/**
 * @author aji
 * @create 2021-06-17 11:09
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account();
        Thread th1 = new Thread(acct);
        Thread th2 = new Thread(acct);
        Thread th3 = new Thread(acct);
        th1.setName("一号选手");
        th2.setName("二号选手");
        th3.setName("三号选手");
        th1.start();
        th2.start();
        th3.start();
    }
}
