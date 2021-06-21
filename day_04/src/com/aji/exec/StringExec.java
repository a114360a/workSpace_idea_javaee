package com.aji.exec;

/**
 * @author aji
 * @create 2021-06-20 12:49
 */
public class StringExec {
    //模拟一个trim方法，去除字符串两端的空格。
    public String trim(String str){
        if (str != null){
            int start = 0;//用来记录第一个索引的位置
            int end = str.length()-1;//用来记录最后一个索引的位置
            //判断第一个start的位置，如果是' '，start就++，如果start不是' ',就结束
            while (start < end && str.charAt(start) == ' '){
                start++;
            }
            //判断最后一个end的位置，如果是' ',end就--
            while (start < end && str.charAt(end) == ' '){
                end--;
            }
            //有可能就只有一个' ',此时start和end相等，上述判断无效。
            if (str.charAt(start) == ' '){
                return "";
            }
            return str.substring(start,end+1);
        }
        return null;
    }
    //将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
    //转为”abfedcg”
    public String reverse(String str){
        if (str != null){
            char[] chars = str.toCharArray();
            for (int i = 0,j = chars.length-1; i < chars.length; i++,j--) {
                if(i < j){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
            return new String(chars);
        }
        return null;
    }
    //获取一个字符串在另一个字符串中出现的次数。
    //比如：获取“ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
    public int getCount(String str1,String str2){
        if(str1.length()>str2.length()){
            return 0;
        }
        //用来记录次数
        int count = 0;
        if (str1 != null && str2 != null){
            //如果str2的长度为10,str1的长度为2,那么需要判断10-2+1次。
            for (int i = 0; i < str2.length()-str1.length()+1; i++) {
                //创建一个新的字符串，取自str1。
                String str3 = str2.substring(i,i+str1.length());
                if(str1.equals(str3)){
                    count++;
                }
            }
            return count;
        }
        return Integer.parseInt(null);
    }
    //4.获取两个字符串中最大相同子串。比如：
    //str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
    //提示：将短的那个串进行长度依次递减的子串与较长的串比较。
    public String getSameSubstring(String str1,String str2){
        if (str1 != null && str2 != null){
            if (str1.length()>str2.length()){
                for (int i = 0; i < str2.length(); i++) {
                    String temp = str2.substring(i);
                    if(str1.indexOf(temp) != -1){
                        return temp;
                    }
                }
            }else {
                for (int i = 0; i < str1.length(); i++) {
                    String temp = str1.substring(i);
                    if(str2.indexOf(temp) != -1){
                        return temp;
                    }
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        StringExec exec = new StringExec();
        String s1 = "dsav aads";
        System.out.println(s1.length());
        System.out.println(exec.trim(s1));
        System.out.println(exec.reverse(s1));
        String s2 = "ava";
        String s3 = s1.substring(1,3);
        //System.out.println(s3);
        System.out.println(exec.getCount(s2, s1));
        String str1 = "abcwerthelloyuiodef",str2 = "cvhellobnm";
        System.out.println("-------------");
        System.out.println(exec.getSameSubstring(s1, s2));
        //System.out.println(s1.indexOf(s2));
        System.out.println("aa");
        System.out.println("bb");
        System.out.println("111222");
        System.out.println("hello hot-fix");
    }
}
