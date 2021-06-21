/**
 * 创建多线程的方式二：实现runnable接口
 * 一、创建类实现runnable接口
 * 二、重写run方法
 * 三、创建runnable实现类的对象
 * 四、创建Thread对象，构造器内填入runnable实现类的对象
 * 五、调用start方法
 * @author aji
 * @create 2021-06-16 9:30
 */
public class RunableTest {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread th = new Thread(myRunnable);

        th.start();

    }

}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}