package pl.wlabuda.fortranalpha;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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

    public static void setEmptyWeb(WebView... webViews){
        for(WebView t:webViews){
            t.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");
        }
    }

    public static void EditTextHide(Boolean hide, EditText... editTexts){
        if (hide){
            for(EditText t:editTexts){
                t.setVisibility(View.GONE);
            }
        }else{
            for(EditText t:editTexts){
                t.setVisibility(View.VISIBLE);
            }
        }
    }

    public static void WebViewHide(Boolean hide, WebView... webViews){
        if (hide){
            for(WebView t:webViews){
                t.setVisibility(View.GONE);
            }
        }else{
            for(WebView t:webViews){
                t.setVisibility(View.VISIBLE);
            }
        }
    }

    public static void TouchListener(final ImageView imageView,final int obraz, EditText editText) {
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                imageView.setImageResource(obraz);
                return false;
            }
        });
    }

}
