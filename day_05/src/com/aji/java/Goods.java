package com.aji.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author aji
 * @create 2021-06-24 10:37
 */
public class Goods implements Comparable{
    private String name;
    private int price;
    @Override
    public int compareTo(Object o) {
        if (o != null){
            if (o instanceof Goods){
                Goods goods = (Goods)o;
                if (this.price > goods.price){
                    return 1;
                }else if(this.price < goods.price){
                    return -1;
                }else{
                    return 0;
                }
            }
            throw new RuntimeException("类型不一致");
        }
        throw new RuntimeException("对象为空");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Goods() {
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", price=" + price;
    }
}
class Test3{
    public static void main(String[] args) {
        Goods[] goods = new Goods[]{
                new Goods("红楼梦",33),
                new Goods("三国演义",31),
                new Goods("西游记",88),
                new Goods("水浒传",77)
        };
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}