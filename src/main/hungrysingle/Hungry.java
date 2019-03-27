package main.hungrysingle;

/**
 * 饿汉式单例
 *  方式一、静态常量
 */

public class Hungry {
    private static final Hungry hungry=new Hungry();
    private Hungry(){}
    public static Hungry getInstance(){
        return hungry;
    }
}

class HungrySingleton{
    private static final HungrySingleton HUNGRY_SINGLETON;
    static{
        HUNGRY_SINGLETON=new HungrySingleton();
    }
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return HUNGRY_SINGLETON;
    }
}
