import java.util.concurrent.locks.ReentrantLock;

/**
 * @author aji
 * @create 2021-06-16 17:57
 */
public class LockTest {
    public static void main(String[] args) {
        MyTicketRunnable1 th1 = new MyTicketRunnable1();
        MyTicketRunnable1 th2 = new MyTicketRunnable1();
        MyTicketRunnable1 th3 = new MyTicketRunnable1();

        th1.setName("线程1");
        th2.setName("线程2");
        th3.setName("线程3");
        th1.start();
        th2.start();
        th3.start();
    }
}
class MyTicketRunnable1 extends Thread{
    private static int ticketNum = 1000;
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if(ticketNum > 0){
                    System.out.println(Thread.currentThread().getName()+"票号："+ticketNum);
                }else{
                    break;
                }
                ticketNum--;

            }finally {
                lock.unlock();
            }

        }
    }

}