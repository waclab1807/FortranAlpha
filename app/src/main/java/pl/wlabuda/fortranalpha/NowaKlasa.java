package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

/**
 * Created by waclab1807 on 21.04.15.
 */
public class NowaKlasa extends Activity {
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public ScrollView data;
    public ImageView imageView;
    public WebView webView;
    public EditText pp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kwadrat);
/**
 * podpięcie tab'ów z małego layout'u
 * podpięcie widoków
 * ustawienie listenerów na taby
 */
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);

        data = (ScrollView)findViewById(R.id.dwa);
        imageView = (ImageView)findViewById(R.id.imageView);
        webView = (WebView)findViewById(R.id.webView);

        //new TabListener(btn1,btn2,btn3,imageView,data,webView);

        imageView.setImageResource(R.drawable.gran_prosty);
        webView.loadData("dupa",null,null);

        //imageView = (ImageView)findViewById(R.id.imageView);
        //imageView.setImageResource(R.drawable.starykwadrat);
    }
}
