/**
 * 使用runnable实现三个线程卖票
 * @author aji
 * @create 2021-06-16 9:42
 */
public class TicketThread {
    public static void main(String[] args) {
        MyTicketThread my1 = new MyTicketThread();
        MyTicketThread my2 = new MyTicketThread();
        MyTicketThread my3 = new MyTicketThread();
        my1.start();
        my2.start();
        my3.start();
    }
}
class MyTicketThread extends Thread{
    private static int ticketNum = 100;
    @Override
    public void run() {
        while (true){
            if (ticketNum > 0){
                System.out.println(this.getName()+"票数:"+ticketNum);
            }else{
                break;
            }
            ticketNum--;
        }
    }
}
