package main.destroy.clone;

/**
 * @author wangchunlan
 * @ClassName SuperClass.java
 * @Description
 * @createTime 2019年03月27日 13:34:00
 */
public class SuperClass implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
