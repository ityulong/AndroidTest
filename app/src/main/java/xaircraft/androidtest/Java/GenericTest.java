package xaircraft.androidtest.Java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyulong on 2016/10/12.
 */

class myObject{}

class Fruit extends myObject{}

class apple extends Fruit{}

class orange extends Fruit{}



public class GenericTest {
    public static void main(String args[]){
//        List<? extends Fruit> datas = new ArrayList<>();
        List<? super Fruit> datas = new ArrayList<>();
        datas.add(new Fruit());
        datas.add(new apple());
        datas.add(new orange());
        datas.add(null);

    }
}
