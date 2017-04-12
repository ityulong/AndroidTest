package xaircraft.androidtest.javaTest.RouJiaMo;

/**
 * Created by chenyulong on 16/7/15.
 */
public class RouJiaMoStore {
    public final static int SUAN_TYPE = 1;
    public final static int TIAN_TYPE = 2;
    public final static int LA_TYPE = 3;

    public static RouJiaMo sellRouJiaMo(int type) {
        RouJiaMo rouJiaMo = null;
        switch (type) {
            case SUAN_TYPE:
                rouJiaMo = new SuanRouJiaMo();
                break;
            case TIAN_TYPE:
                rouJiaMo = new TianRouJiaMo();
                break;
            case LA_TYPE:
                rouJiaMo = new LaRouJiaMo();
                break;
        }
        assert rouJiaMo != null;
        rouJiaMo.prepare();
        rouJiaMo.pack();
        rouJiaMo.fire();
        return rouJiaMo;
    }

}
