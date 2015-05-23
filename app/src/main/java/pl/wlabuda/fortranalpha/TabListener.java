package pl.wlabuda.fortranalpha;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
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

    public TabListener(final LinearLayout buttons, final InputMethodManager imm,Button btn1, Button btn2, Button btn3, final ImageView imageView, final ScrollView data, final WebView webView){

        if(btn1!=null) {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data.setVisibility(View.GONE);
                    webView.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    buttons.setVisibility(View.GONE);
                    if(imm.isActive()) {
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //hide
                    }else{
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0); // show
                    }
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
                    buttons.setVisibility(View.VISIBLE);
                    if(imm.isActive()) {
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //hide
                    }else{
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0); // show
                    }
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
                    buttons.setVisibility(View.GONE);
                    if(imm.isActive()) {
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //hide
                    }else{
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0); // show
                    }
                }
            });
        }
    }
}
