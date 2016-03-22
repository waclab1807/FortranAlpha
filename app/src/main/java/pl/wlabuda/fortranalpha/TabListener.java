package pl.wlabuda.fortranalpha;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import static android.provider.Settings.Global.getString;

/**
 * Created by waclab1807 on 23.04.15.
 */
public class TabListener {

    private int x = 0;

    public static void refresh(ImageView imageView, ScrollView data, WebView webView){
        data.setVisibility(View.VISIBLE);
        webView.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
    }
    public TabListener(){};

    public TabListener(final LinearLayout buttons, final InputMethodManager imm, final Button btn1, final Button btn2, final Button btn3, final ImageView imageView, final ScrollView data, final WebView webView){

        if(btn1!=null) {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data.setVisibility(View.GONE);
                    webView.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);

                    btn1.setTextSize(30);
                    btn2.setTextSize(22);
                    btn3.setTextSize(22);

                    btn1.setBackgroundColor(Color.TRANSPARENT);
                    btn2.setBackgroundColor(Color.rgb(0, 150, 136));
                    btn3.setBackgroundColor(Color.rgb(0,150,136));

                    btn1.setTypeface(null, Typeface.BOLD);
                    btn2.setTypeface(null, Typeface.NORMAL);
                    btn3.setTypeface(null, Typeface.NORMAL);

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

                    if(x == 0){
                        Toast.makeText(Global.mContext,
                                R.string.firstClick, Toast.LENGTH_LONG)
                                .show();
                    }

                    x = 1;

                    imageView.setVisibility(View.GONE);
                    webView.setVisibility(View.GONE);
                    data.setVisibility(View.VISIBLE);

                    btn1.setTextSize(22);
                    btn2.setTextSize(30);
                    btn3.setTextSize(22);

                    btn1.setBackgroundColor(Color.rgb(0, 150, 136));
                    btn2.setBackgroundColor(Color.TRANSPARENT);
                    btn3.setBackgroundColor(Color.rgb(0, 150, 136));

                    btn1.setTypeface(null, Typeface.NORMAL);
                    btn2.setTypeface(null, Typeface.BOLD);
                    btn3.setTypeface(null, Typeface.NORMAL);

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

                    btn1.setTextSize(22);
                    btn2.setTextSize(22);
                    btn3.setTextSize(30);

                    btn1.setBackgroundColor(Color.rgb(0, 150, 136));
                    btn2.setBackgroundColor(Color.rgb(0, 150, 136));
                    btn3.setBackgroundColor(Color.TRANSPARENT);

                    btn1.setTypeface(null, Typeface.NORMAL);
                    btn2.setTypeface(null, Typeface.NORMAL);
                    btn3.setTypeface(null, Typeface.BOLD);

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
