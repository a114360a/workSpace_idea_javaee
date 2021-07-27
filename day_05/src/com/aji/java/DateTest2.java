package com.aji.java;

import com.aji.exec.Season;
import com.aji.exec.Season1;

/**
 * @author aji
 * @create 2021-06-24 9:45
 */
public class DateTest2{
    public static void main(String[] args) {
        System.out.println(Season.SPRING);

        System.out.println(Season1.values());
        System.out.println(Season1.valueOf("SPRING1"));
        System.out.println(Season1.SPRING.toString());
    }
}
