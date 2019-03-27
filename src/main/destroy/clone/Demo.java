package main.destroy.clone;

/**
 * @author wangchunlan
 * @ClassName Demo.java
 * @Description
 * @createTime 2019年03月27日 13:36:00
 */
public class Demo{
    public static void main(String[] args) throws CloneNotSupportedException {
        Hungry instance1=Hungry.getInstance();
        Hungry instance2=(Hungry) instance1.clone();

        System.out.println("instance 1:"+instance1.hashCode());
        System.out.println("instance 2:"+instance2.hashCode());


    }
}
