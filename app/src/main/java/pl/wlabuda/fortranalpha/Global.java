package pl.wlabuda.fortranalpha;

import android.content.Context;
import android.widget.EditText;

/**
 * Created by waclab1807 on 03.04.15.
 */
public class Global {
    public static Context mContext;

    public Global(Context context){

        mContext = context;
    }

    public static void setEmpty(EditText ... editTexts){
        for(EditText t:editTexts){
            t.setText("");
        }
    }

}
