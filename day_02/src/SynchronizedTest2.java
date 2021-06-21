/**
 * 同步方式二，方法上声明synchronized
 * @author aji
 * @create 2021-06-16 16:55
 */
public class SynchronizedTest2 {
    public static void main(String[] args) {
      /*  SynchronizedMethod1 sm1 = new SynchronizedMethod1();
        SynchronizedMethod1 sm2 = new SynchronizedMethod1();
        SynchronizedMethod1 sm3 = new SynchronizedMethod1();
        sm1.setName("线程1");
        sm2.setName("线程2");
        sm3.setName("线程3");
        sm1.start();
        sm2.start();
        sm3.start();*/

        SynchronizedMethod2 sm = new SynchronizedMethod2();
        Thread th1 = new Thread(sm);
        Thread th2 = new Thread(sm);
        Thread th3 = new Thread(sm);
        th1.setName("线程一");
        th2.setName("线程二");
        th3.setName("线程三");
        th1.start();
        th2.start();
        th3.start();
    }
}
class SynchronizedMethod1 extends Thread{
    private static int ticked = 100;
    @Override
    public void run() {
        show();
    }
    private static synchronized void show(){
        while (true){
            if (ticked > 0){
                System.out.println(Thread.currentThread().getName()+"票数："+ticked);
                ticked--;
            }else{
                break;
            }
        }
    }
}
class SynchronizedMethod2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        show();
    }
    private synchronized void show(){
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+"票数：："+ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}