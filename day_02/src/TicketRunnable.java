/**
 * @author aji
 * @create 2021-06-16 10:08
 */
public class TicketRunnable{
    public static void main(String[] args) {
        MyTicketRunnable my1 = new MyTicketRunnable();
        Thread th1 = new Thread(my1);
        Thread th2 = new Thread(my1);
        Thread th3 = new Thread(my1);
        th1.setName("线程1");
        th2.setName("线程2");
        th3.setName("线程3");
        th1.start();
        th2.start();
        th3.start();
    }
}

class MyTicketRunnable implements Runnable{
    private int ticketNum = 100;
    @Override
    public void run() {
        while (true){
            if(ticketNum > 0){
                System.out.println(Thread.currentThread().getName()+"票号："+ticketNum);
            }else{
                break;
            }
            ticketNum--;
        }
    }
}