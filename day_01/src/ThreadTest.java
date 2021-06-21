/**
 * 多线程
 * 1.创建一个自定义类继承Thread
 * 2.重写run方法
 * 3.新建对象
 * 4.执行start方法
 *  两个作用①启动线程②启动run方法
 * @author aji
 * @create 2021-06-15 16:27
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread1 mt1 = new MyThread1();
        MyThread1 mt2 = new MyThread1();
        mt1.start();
        mt2.start();
/*        for (int i = 0; i < 10000; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }*/

    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if(i % 2 == 0){
                System.out.println(currentThread().getName()+" [" +i +"]");
            }
        }
    }

}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if(i % 2 == 0){
                System.out.println(currentThread()+getName()+" [" +i +"]");
            }
        }
    }

}