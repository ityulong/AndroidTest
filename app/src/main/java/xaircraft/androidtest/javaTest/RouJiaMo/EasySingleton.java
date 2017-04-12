package xaircraft.androidtest.javaTest.RouJiaMo;

/**
 * Created by chenyulong on 16/7/15.
 */
public enum EasySingleton {
    INSTANCE;

    EasySingleton() {
        System.out.println("here construct");
        doSomething();
    }

    public void doSomething(){
        System.out.println("do something!");
    }
}
