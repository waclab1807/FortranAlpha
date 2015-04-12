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
}
