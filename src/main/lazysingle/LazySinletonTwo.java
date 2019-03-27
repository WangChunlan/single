package main.lazysingle;

/**
 * 懒汉式
 * 线程安全：
 * ---> 1、同步方法
 * ---> 2、同步代码块
 * 两者都不推荐用
 */
public class LazySinletonTwo {
    private static LazySinletonTwo lazySinletonTwo;

    private LazySinletonTwo() {
    }

    public static synchronized LazySinletonTwo getInstance() {
        if (lazySinletonTwo == null) {
            lazySinletonTwo = new LazySinletonTwo();
        }
        return lazySinletonTwo;
    }
}

// 同步代码块
class LazySinletonThree{
    private static LazySinletonThree lazySinletonThree;
    private LazySinletonThree(){}
    public static LazySinletonThree getInsatnce(){
        if(lazySinletonThree==null){
            synchronized (LazySinletonThree.class){
                lazySinletonThree=new LazySinletonThree();
            }
        }
        return lazySinletonThree;
    }
}