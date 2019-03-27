package main.destroy.serializable;

import java.io.Serializable;

/**
 * @author wangchunlan
 * @ClassName Singleton.java
 * @Description
 * @createTime 2019年03月27日 13:50:00
 */
public class Singleton implements Serializable {
    private static Singleton instance=new Singleton();
    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
    /**
     * 克服序列化带来的破坏单例模式的问题
     * @description 实现readResolve()即可解决该问题。
     * @author wangchunlan
     * @updateTime 2019/3/27 13:56
     * @return
     **/
    protected Object readResolve(){
        return instance;
    }

}
