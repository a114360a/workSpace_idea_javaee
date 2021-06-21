/**
 * 解决线程安全两种方式
 * 一 同步代码块
 * synchronized(同步监视器--锁){
 *     //需要同步的代码，共享数据
 * }
 * 二 同步方法 方法声明synchronized
 * public synchronized void show(){}
 * @author aji
 * @create 2021-06-16 10:51
 */
public class SynchronizedTest {
    public static void main(String[] args) {
/*        SynchronizedThread syn1 = new SynchronizedThread();
        SynchronizedThread syn2 = new SynchronizedThread();
        SynchronizedThread syn3 = new SynchronizedThread();
        syn1.setName("线程1");
        syn2.setName("线程2");
        syn3.setName("线程3");
        syn1.start();
        syn2.start();
        syn3.start();*/
        System.out.println("-----------------------------------");
        SynchronizedRunnable sr1 = new SynchronizedRunnable();
        Thread th1 = new Thread(sr1);
        Thread th2 = new Thread(sr1);
        Thread th3 = new Thread(sr1);
        th1.setName("线程一");
        th2.setName("线程二");
        th3.setName("线程三");
        th1.start();
        th2.start();
        th3.start();
    }
}
class SynchronizedThread extends Thread{
    private static int ticket = 1000;
    private static Object obj = new Object();
    public void run() {
        while (true){
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(this.getName() + "票数:" + ticket);
                    ticket--;
                } else {
                    break;
                }

            }
        }
    }
}
class SynchronizedRunnable implements Runnable{
    private int ticket = 1000;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized(obj){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName()+"票数:"+ticket);
                    ticket--;
                }else{
                    break;
                }

            }
        }
    }
}