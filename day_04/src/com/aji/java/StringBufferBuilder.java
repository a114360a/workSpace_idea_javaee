package com.aji.java;

import org.junit.Test;

/**
 * String不可变字符序列，底层char[]
 * StringBuffer可变字符序列，线程安全的，效率低，底层char
 * StringBuilder可变字符序列，线程不安全的，效率高，底层char
 * String常用方法
 * length长度
 * charAt返回指定索引的字符
 * isEmpty是否是空字符
 * toLowerCase变成小写
 * toUpperCase变成大写
 * trim出去前后空格
 * equals比较字符的内容是否相同
 * equalsIgnoreCase比较字符内容是否相同，并忽略大小写
 * concat等价于+
 * compareTo比较两个字符的大小
 * subString(int beginIndex)返回一个新的字符串，从指定索引处开始到末尾
 * subString(int beginIndex,int endIndex)返回一个新的字符串，从begin到end处，左闭右开区间
 * @author aji
 * @create 2021-06-20 11:46
 */
public class StringBufferBuilder {
    @Test
    public void Test1(){
        String str1 = "  aBC1 223 ";
        int str1Length = str1.length();
        System.out.println(str1Length);
        char c = str1.charAt(2);
        System.out.println(c);
        boolean empty = str1.isEmpty();
        System.out.println(empty);
        String str2 = str1.toLowerCase();
        System.out.println(str2);
        String str3 = str1.toUpperCase();
        System.out.println(str3);
        String trim = str1.trim();
        System.out.println(trim);
        boolean equals = str1.equals(str2);
        System.out.println(equals);
        boolean equalsIgnoreCase = str1.equalsIgnoreCase(str3);
        System.out.println(equalsIgnoreCase);
        String bbcc = str1.concat("bbcc");
        System.out.println(bbcc);
        String substring1 = str1.substring(3);
        System.out.println(substring1);
        String substring2 = str1.substring(2, 4);
        System.out.println(substring2);
        System.out.println(str1.endsWith(" "));
        System.out.println(str1.startsWith("ab"));
        System.out.println(str1.startsWith("aB",2));
        System.out.println(str1.contains("2"));
        System.out.println(str1.indexOf("a"));
        System.out.println(str1.indexOf("b",4));
       // System.out.println(str1.toLowerCase(str1.lastIndexOf("b")));
        System.out.println(str1.lastIndexOf("B",3));

    }
    @Test
    public void Test2(){
        //字符数组--》字符串
        String str = new String(new char[]{'2','a','d','5',' '});
        System.out.println(str);
        //字符串到--》字符数组
        //System.out.println(str.getChars(1,3,new char[2],1));
        System.out.println(str.toCharArray());

    }
    @Test
    public void Test3(){
        //字节数组--》字符串
        String str = new String(new byte[]{'2','c','4','5'});
        System.out.println(str);
        //字符串--》字节数组
        String str1 = new String("中国321");
        byte[] b = str1.getBytes();
        System.out.println(str1.getBytes());
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

}
