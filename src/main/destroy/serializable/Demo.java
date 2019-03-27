package main.destroy.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author wangchunlan
 * @ClassName Demo.java
 * @Description
 * @createTime 2019年03月27日 13:51:00
 */
public class Demo {
    public static void main(String[] args) {
        try{
            Singleton instance1=Singleton.getInstance();
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("file.txt"));
            out.writeObject(instance1);
            out.close();

            ObjectInputStream in=new ObjectInputStream(new FileInputStream("file.txt"));
            Singleton instance2=(Singleton) in.readObject();
            in.close();
            System.out.println("instance1 :"+instance1);
            System.out.println("instance2 :"+instance2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
