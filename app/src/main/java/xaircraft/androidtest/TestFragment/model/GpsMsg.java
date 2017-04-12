package xaircraft.androidtest.TestFragment.model;

/**
 * Created by chenyulong on 15/11/17.
 */
public class GpsMsg {
    private String gpsName;
    private String id;

    public String getGpsName() {
        return gpsName;
    }

    public void setGpsName(String gpsName) {
        this.gpsName = gpsName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String str = "gps name is :" + getGpsName() + ";" + "gps id is : " + getId();
        return str;
    }
}
