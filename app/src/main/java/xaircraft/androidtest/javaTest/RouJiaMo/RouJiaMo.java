package xaircraft.androidtest.javaTest.RouJiaMo;

/**
 * Created by chenyulong on 16/7/15.
 */
public abstract class RouJiaMo {
    protected String name;

    public void prepare() {
        System.out.println(name + ":" + "准备工作");
    }

    public void pack(){
        System.out.println("包装肉夹馍");
    }

    public void fire(){
        System.out.println("开始烘烤");
    }
}
