/**
 * @author aji
 * @create 2021-06-16 17:28
 */
public class SingletonSynchronized {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getSingleton();
        Singleton s2 = Singleton.getSingleton();
        System.out.println(s1 == s2);
    }
}

class Singleton {
    //1.私有化static变量创建对象
    private static Singleton singleton = null;

    //2.私有化构造器
    private Singleton() {

    }

    //3.方法创建变量，如果是null，生成对象
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
