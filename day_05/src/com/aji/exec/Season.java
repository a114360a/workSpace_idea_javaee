package com.aji.exec;

/**
 * 1. 私有化类的构造器，保证不能在类的外部创建其对象
 * 2. 在类的内部创建枚举类的实例。声明为：public static final
 * 3. 对象如果有实例变量，应该声明为private final，并在构造器中初始化
 * @author aji
 * @create 2021-06-25 11:33
 */
public class Season {
    //1.私有化变量
    private final String SEASONNAME;//字节的名称
    private final String SEASONDESC;//字节的描述

    //2.私有化构造器
    private Season(String seasonname, String seasondesc) {
        SEASONNAME = seasonname;
        SEASONDESC = seasondesc;
    }
    //3.创建对象
    public static final Season SPRING = new Season("春天","春焕花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","白雪皑皑");

    @Override
    public String toString() {
        return "Season{" +
                "SEASONNAME='" + SEASONNAME + '\'' +
                ", SEASONDESC='" + SEASONDESC + '\'' +
                '}';
    }
}
