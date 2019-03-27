package main.destroy.reflect;




import java.lang.reflect.Constructor;

/** 克服反射破坏单例模式的问题，可以使用枚举法或者在静态内部类中抛出异常
 * @author wangchunlan
 * @ClassName Demo.java
 * @Description
 * @createTime 2019年03月27日 14:00:00
 */
public class Demo {
    public static void main(String[] args) {
        /*Singleton instance1=Singleton.getInstance();
        Singleton instance2=null;

        try{
            Constructor[] constructors=Singleton.class.getDeclaredConstructors();
            for (Constructor constructor:constructors){
                constructor.setAccessible(true);
                instance2=(Singleton)constructor.newInstance();
                break;
            }
            System.out.println("instance1 ="+instance1.hashCode());
            System.out.println("instance2 ="+instance2.hashCode());
        }catch (Exception e){
            e.printStackTrace();
        }*/


        LazyFour instance1=LazyFour.getInstance();
        LazyFour instance2=null;

        try{
            Constructor[] constructors=LazyFour.class.getDeclaredConstructors();
            for (Constructor constructor:constructors){
                constructor.setAccessible(true);
                instance2=(LazyFour)constructor.newInstance();
                break;
            }
            System.out.println("instance1 ="+instance1.hashCode());
            System.out.println("instance2 ="+instance2.hashCode());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
