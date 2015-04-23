package pl.wlabuda.fortranalpha;

import android.content.Context;

/**
 * Created by waclab1807 on 03.04.15.
 */
public class Global {
    public static Context mContext;

    public Global(Context context){

        mContext = context;
    }

    public Context getmContext() {
        return mContext;
    }

    public static void setImgRes(int imgRes) {
        Global.imgRes = imgRes;
    }

    private volatile static int imgRes=0;

    public static int getImgRes() {
        if(imgRes==0){


        }
        return imgRes;
    }
}
