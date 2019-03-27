package main.destroy.reflect;

import main.destroy.clone.Hungry;

/**
 * @author wangchunlan
 * @ClassName Singleton.java
 * @Description
 * @createTime 2019年03月27日 13:59:00
 */
public class Singleton {
    private static final Singleton instance=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}
