package main.lazysingle;
// 静态内部类
public class LazyFour {
    private LazyFour(){
        if(null!=SingletonInstance.INSTANCE){
            try {
                throw new Exception("不允许创建多个实例");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private static class SingletonInstance{
        private static final LazyFour INSTANCE=new LazyFour();
    }

    public static LazyFour getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
