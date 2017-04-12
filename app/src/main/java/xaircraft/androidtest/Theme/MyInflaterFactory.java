package xaircraft.androidtest.Theme;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.lang.reflect.Method;

/**
 * Created by chenyulong on 16/7/27.
 */
public class MyInflaterFactory implements LayoutInflater.Factory {
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        Log.i("SkinFactory", "==============start==============");
        Log.i("attrs", "nameParam :" + name);
        int attrsSize = attrs.getAttributeCount();
        for (int i = 0; i < attrsSize; i++) {
            String attrName = attrs.getAttributeName(i);
            String attrValue = attrs.getAttributeValue(i);
            Log.i("attrs", "name : " + attrName + ", value: " + attrValue);
        }
        Log.i("SkinFactory", "==============end==============");

//        View view = null;
//        view = createView(name, context, attrs, "android.widget.");
//
//        final Resources temp = context.getResources();
//        String entryName = temp.getResourceEntryName(1);
//        String entryType = temp.getResourceTypeName(1);

        AssetManager assetManager = null;
        try {
            assetManager = AssetManager.class.newInstance();
            Method addAssetPath = assetManager.getClass().getDeclaredMethod("addAssetPath", String.class);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public View createView(String name, Context context, AttributeSet attrs, String prefix) {
        View view = null;
        try {
            view = LayoutInflater.from(context).createView(name, prefix, attrs);
        } catch (Exception e) {
        }
        return view;
    }
}
