package main.destroy.clone;

/**
 * @author wangchunlan
 * @ClassName Hungry.java
 * @Description
 * @createTime 2019年03月27日 13:33:00
 */
public class Hungry extends SuperClass {
    private static final Hungry instance=new Hungry();
    private Hungry(){}
    public static Hungry getInstance(){
        return instance;
    }

    /**
     * 克服克隆破坏单例模式的问题
     * @title clone
     * @description
     *              方式1：覆盖clone() 方法，并从克隆方法抛出异常，及即CloneNotSupportedException
     *              方式2：返回同样的实例
     * @author wangchunlan
     * @updateTime 2019/3/27 13:42
     * @return: java.lang.Object
     * @throws CloneNotSupportedException
     **/
    @Override
    protected Object clone() throws CloneNotSupportedException {
//        System.out.println("不能进行克隆，这样会破坏单例模式");
//        throw new CloneNotSupportedException();
        return instance;
    }
}
