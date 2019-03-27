package main.lazysingle;

/**
 * 懒汉式
 * 线程不安全
 */
public class LazySingleton {
    private static LazySingleton singleton;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

}
