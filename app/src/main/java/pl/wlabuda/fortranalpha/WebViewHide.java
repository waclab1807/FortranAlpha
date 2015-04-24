package pl.wlabuda.fortranalpha;

import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

/**
 * Created by waclab1807 on 23.04.15.
 */
public class WebViewHide {

    public WebViewHide(Boolean hide, WebView... webViews){
        for(WebView t:webViews){
            t.setVisibility((hide)? View.VISIBLE:View.GONE);
        }
    }
}
