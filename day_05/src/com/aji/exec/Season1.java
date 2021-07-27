package com.aji.exec;

/**
 * @author aji
 * @create 2021-06-25 14:24
 */
public enum Season1 {

    SPRING("春天","春焕花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","白雪皑皑");

    private final String SEASONNAME;
    private final String SEASONDESC;

    private Season1(String seasonname,String seasondesc){
        this.SEASONNAME = seasonname;
        this.SEASONDESC = seasondesc;
    }

}
