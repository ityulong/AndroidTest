package xaircraft.androidtest.javaTest.RouJiaMo;

/**
 * Created by chenyulong on 16/7/15.
 */
public class RouJiaMoTest {
    public  final static void main(String [] args){
        RouJiaMo rouJiaMo = null;
        rouJiaMo = RouJiaMoStore.sellRouJiaMo(RouJiaMoStore.SUAN_TYPE);

        rouJiaMo = RouJiaMoStore.sellRouJiaMo(RouJiaMoStore.LA_TYPE);

        rouJiaMo = RouJiaMoStore.sellRouJiaMo(RouJiaMoStore.TIAN_TYPE);

        EasySingleton.INSTANCE.doSomething();

    }
}
