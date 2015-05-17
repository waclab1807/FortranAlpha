package pl.wlabuda.fortranalpha;

import android.content.Context;
import android.hardware.input.InputManager;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollView;

/**
 * Created by waclab1807 on 23.04.15.
 */
public class TabListener {


    public static void refresh(ImageView imageView, ScrollView data, WebView webView){
        data.setVisibility(View.VISIBLE);
        webView.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
    }
    public TabListener(){};

    public TabListener(Button btn1, Button btn2, Button btn3, final ImageView imageView, final ScrollView data, final WebView webView){

        if(btn1!=null) {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data.setVisibility(View.GONE);
                    webView.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                }
            });
        }
        if (btn2!=null) {
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView.setVisibility(View.GONE);
                    webView.setVisibility(View.GONE);
                    data.setVisibility(View.VISIBLE);
                }
            });
        }
        if (btn3!=null) {
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView.setVisibility(View.GONE);
                    data.setVisibility(View.GONE);
                    webView.setVisibility(View.VISIBLE);
                }
            });
        }
    }
}
