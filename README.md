> 作业内容

> 1、熟练掌握单例模式的常见写法。

> 2、总结每种单例写法的优、缺点。
 #### 清单1、饿汉式(静态常量、静态代码块)
优点：绝对的线程安全，还没有调用就初始化，效率高。<br/>
缺点：内存资源浪费，不管用不用都实例化
```java
public class Singleton{
    private static final Singleton INSTANCE=new Singleton();
    private Singleton(){}
    
    public static Singleton getInstance(){
        return INSTANCE;
    }
}
```
```java
public class Singleton{
    private static final Singleton INSTANCE;
    private Singleton(){}
    static{
        INSTANCE=new Singleton();
    }
    public static Singleton getInstance(){
        return INSTANCE;
    }
}
```
 #### 清单2、懒汉式(线程不安全)[不可用]
优点：起到了懒加载的效果<br/>
缺点：但是只能局限在单线程下使用，如果在多线程下，一个线程进入singleton==null后，还未往下执行，另一个线程也进来了，
此时就会产生多个实例，所以在多线程环境下不可以使用此方式。
```java
public class Singleton{
    private static Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if(singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }
}
```
 #### 清单3、懒汉式(线程安全：同步方法；同步代码块)[不推荐用]
优点：解决了 清单2中的线程不安全问题，做个线程同步，对getInstance()方法进行线程同步<br/>
缺点：方法进行同步，效率太低，每个线程想要获得类的实例的时候，执行getInstance()方法都要进行同步。
>因为：这个方法其实就只执行一次实例化代码就够了，后面的想要获得该实例，直接return就行了。

总结：改进同步方法方式，改为同步代码块。but,这种同步代码块并不能起到线程同步的作用。也会遇到出现多个实例，这与同步方法相似。



同步方法
```java
public class Singleton{
    private static Singleton singleton;
    private Singleton(){}
    public static synchronized Singleton getInstance(){
        if(singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }
}
```

同步代码块
```java
public class Singleton{
    private static Singleton singleton;
    private Singleton(){}
    public static  Singleton getInstance(){
        if(singleton==null){
            synchronized(Singleton.class){
                  singleton=new Singleton();
            }
        }
        return singleton;
    }
}
```
 #### 清单4、双重检查(线程安全)[推荐用]
优点：线程安全；延迟加载；效率较高<br/>
缺点：依旧是使用synchronized 同步锁，当出现大量的线程时，可能会出现阻塞
```java
public class Singleton{
    private static volatile Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if(singleton==null){
            synchronized(Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
```
#### 清单5、静态内部类[推荐用]
> 这种方式兼顾了饿汉式的内存浪费，也兼顾了synchronized性能问题(线程阻塞)。

优点：避免了线程不安全，延迟加载，效率高。

```java
public class Singleton{
    private Singleton(){}
    private static class SingletonInstance{
        private static final Singleton INSTANCE=new Singleton();
    }
    
    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
```



>3、思考破坏单例模式的方式有哪些？并且归纳总结。

>4、梳理内部类的执行逻辑，并画出时序图。
