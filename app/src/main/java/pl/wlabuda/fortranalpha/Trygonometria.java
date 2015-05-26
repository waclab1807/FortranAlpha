package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

/**
 * Created by waclab1807 on 31.03.15.
 */

public class Trygonometria extends Activity implements OnFocusChangeListener{

    private Button licz;
    private Button clear;
    private Button sqrtbtn;
    private Button powbtn;
    private Button btnReview;
    private Button btnData;
    private Button btnSolution;
    private EditText a_val;
    private EditText b_val;
    private EditText c_val;
    private EditText lastFocused;
    private String tekst;
    private WebView mWebView;
    private WebView mWebViewSinA;
    private WebView mWebViewCosA;
    private WebView mWebViewTgA;
    private WebView mWebViewCtgA;
    private WebView mWebViewSinB;
    private WebView mWebViewCosB;
    private WebView mWebViewTgB;
    private WebView mWebViewCtgB;
    private ImageView figura;
    private ScrollView scrollView;
    private LinearLayout buttons;

    String a;
    String b;
    String c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trygonometria);
        Global.mContext = this.getBaseContext();

        a_val = (EditText) findViewById(R.id.a);
        b_val = (EditText) findViewById(R.id.b);
        c_val = (EditText) findViewById(R.id.c);
        licz = (Button) findViewById(R.id.magic);
        clear = (Button) findViewById(R.id.clear);
        sqrtbtn = (Button) findViewById(R.id.sqrtbtn);
        powbtn = (Button) findViewById(R.id.powbtn);
        figura = (ImageView) findViewById(R.id.imageView);
        btnReview = (Button)findViewById(R.id.btnReview);
        btnData = (Button)findViewById(R.id.btnData);
        btnSolution = (Button)findViewById(R.id.btnSolution);
        scrollView = (ScrollView)findViewById(R.id.dwa);
        buttons = (LinearLayout) findViewById(R.id.buttons);

        if (btnData.getVisibility() == View.VISIBLE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        mWebView = (WebView) findViewById(R.id.webSolution);
        WebSettings webSettings = mWebView.getSettings();
        mWebView.setBackgroundColor(0xff0);
        webSettings.setJavaScriptEnabled(true);

        mWebViewSinA = (WebView) findViewById(R.id.websina);
        WebSettings webSettings1 = mWebViewSinA.getSettings();
        mWebViewSinA.setBackgroundColor(0xff0);
        webSettings1.setJavaScriptEnabled(true);

        mWebViewCosA = (WebView) findViewById(R.id.webcosa);
        WebSettings webSettings2 = mWebViewCosA.getSettings();
        mWebViewCosA.setBackgroundColor(0xff0);
        webSettings2.setJavaScriptEnabled(true);

        mWebViewTgA = (WebView) findViewById(R.id.webtga);
        WebSettings webSettings3 = mWebViewTgA.getSettings();
        mWebViewTgA.setBackgroundColor(0xff0);
        webSettings3.setJavaScriptEnabled(true);

        mWebViewCtgA = (WebView) findViewById(R.id.webctga);
        WebSettings webSettings4 = mWebViewCtgA.getSettings();
        mWebViewCtgA.setBackgroundColor(0xff0);
        webSettings4.setJavaScriptEnabled(true);

        mWebViewSinB = (WebView) findViewById(R.id.websinb);
        WebSettings webSettings5 = mWebViewSinB.getSettings();
        mWebViewSinB.setBackgroundColor(0xff0);
        webSettings5.setJavaScriptEnabled(true);

        mWebViewCosB = (WebView) findViewById(R.id.webcosb);
        WebSettings webSettings6 = mWebViewCosB.getSettings();
        mWebViewCosB.setBackgroundColor(0xff0);
        webSettings6.setJavaScriptEnabled(true);

        mWebViewTgB = (WebView) findViewById(R.id.webtgb);
        WebSettings webSettings7 = mWebViewTgB.getSettings();
        mWebViewTgB.setBackgroundColor(0xff0);
        webSettings7.setJavaScriptEnabled(true);

        mWebViewCtgB = (WebView) findViewById(R.id.webctgb);
        WebSettings webSettings8 = mWebViewCtgB.getSettings();
        mWebViewCtgB.setBackgroundColor(0xff0);
        webSettings8.setJavaScriptEnabled(true);

        a_val.setOnFocusChangeListener(this);
        b_val.setOnFocusChangeListener(this);
        c_val.setOnFocusChangeListener(this);

        Global.TouchListener(figura, R.drawable.kwadratpp, a_val);
        Global.TouchListener(figura, R.drawable.kwadrata, b_val);   //todo grafiki
        Global.TouchListener(figura,R.drawable.kwadratd,c_val);

        final InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        new TabListener(buttons,imm,btnReview,btnData,btnSolution,figura,scrollView,mWebView);

        figura.setImageResource(R.drawable.kwadrat);

        btnSolution.setEnabled(false);

        btnReview.setTypeface(null, Typeface.BOLD);
        btnReview.setTextSize(30);
        btnReview.setBackgroundColor(Color.TRANSPARENT);

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean sina = false;
                boolean cosa = false;
                boolean tga = false;
                boolean ctga = false;
                boolean sinb = false;
                boolean cosb = false;
                boolean tgb = false;
                boolean ctgb = false;

                a_val.setEnabled(false);
                b_val.setEnabled(false);
                c_val.setEnabled(false);

                tekst = "";
                licz.setTypeface(null, Typeface.NORMAL);
                clear.setTypeface(null, Typeface.BOLD);

                int x = 0; //koniec petli, wszystko policzone
                int y = 0; //za mało danych aby policzyć

                if(Wartosc.nawiasy(a_val.getText().toString()) &&
                        Wartosc.nawiasy(b_val.getText().toString()) &&
                        Wartosc.nawiasy(c_val.getText().toString())) {
                    try {
                        while (x == 0) {
                            //obliczanie a lub pp lub obwp
                            //czy jest a
                            if (!isEmpty(a_val) && !isEmpty(b_val) && !isEmpty(c_val)) {
                                System.out.println("^^^^^^^^1");
                                a = a_val.getText().toString();
                                b = b_val.getText().toString();
                                c = c_val.getText().toString();

                                JavaScript.showFormatted(policzSinA(a, c), mWebViewSinA);
                                JavaScript.showFormatted(policzCosA(b, c), mWebViewCosA);
                                JavaScript.showFormatted(policzTgA(a, b),mWebViewTgA);
                                JavaScript.showFormatted(policzCtgA(b, a),mWebViewCtgA);

                                JavaScript.showFormatted(policzSinB(b, c),mWebViewSinB);
                                JavaScript.showFormatted(policzCosB(a, c),mWebViewCosB);
                                JavaScript.showFormatted(policzTgB(b, a),mWebViewTgB);
                                JavaScript.showFormatted(policzCtgB(a, b),mWebViewCtgB);

                                sina = true;
                                cosa = true;
                                tga = true;
                                ctga = true;
                                sinb = true;
                                cosb = true;
                                tgb = true;
                                ctgb = true;

                                x = 1;
                                figura.setImageResource(R.drawable.kwadrat);
                                licz.setEnabled(false);
                                btnSolution.setEnabled(true);
                                imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);

                                Toast.makeText(Trygonometria.this, getString(R.string.premium),
                                        Toast.LENGTH_LONG).show();

                            } else if(!isEmpty(a_val) && !isEmpty(b_val)){
                                a = a_val.getText().toString();
                                b = b_val.getText().toString();

                                JavaScript.showFormatted(policzTgA(a, b),mWebViewTgA);
                                JavaScript.showFormatted(policzCtgA(b, a),mWebViewCtgA);

                                JavaScript.showFormatted(policzTgB(b, a),mWebViewTgB);
                                JavaScript.showFormatted(policzCtgB(a, b),mWebViewCtgB);

                                tga = true;
                                ctga = true;
                                tgb = true;
                                ctgb = true;

                            } else if(!isEmpty(a_val) && !isEmpty(c_val)){
                                a = a_val.getText().toString();
                                c = c_val.getText().toString();

                                JavaScript.showFormatted(policzSinA(a, c), mWebViewSinA);
                                JavaScript.showFormatted(policzCosB(a, c),mWebViewCosB);

                                sina = true;
                                cosb = true;

                            } else if(!isEmpty(b_val) && !isEmpty(c_val)){
                                b = b_val.getText().toString();
                                c = c_val.getText().toString();

                                JavaScript.showFormatted(policzCosA(b, c),mWebViewCosA);
                                JavaScript.showFormatted(policzSinB(b, c),mWebViewSinB);

                                cosa = true;
                                sinb = true;

                            } else{
                                a = a_val.getText().toString();
                                b = b_val.getText().toString();
                                c = c_val.getText().toString();
                                if(a.equals("")){
                                    a = "a";
                                }
                                if(b.equals("")){
                                    b = "b";
                                }
                                if(c.equals("")){
                                    c = "c";
                                }
                                if (!sina){
                                JavaScript.showFormatted(a+"/"+c, mWebViewSinA);}
                                if (!cosa){
                                JavaScript.showFormatted(b+"/"+c,mWebViewCosA);}
                                if (!tga){
                                JavaScript.showFormatted(a+"/"+b,mWebViewTgA);}
                                if (!ctga){
                                JavaScript.showFormatted(b+"/"+a,mWebViewCtgA);}

                                if (!sinb){
                                JavaScript.showFormatted(b+"/"+c,mWebViewSinB);}
                                if (!cosb){
                                JavaScript.showFormatted(a+"/"+c,mWebViewCosB);}
                                if (!tgb){
                                JavaScript.showFormatted(b+"/"+a,mWebViewTgB);}
                                if (!ctgb){
                                JavaScript.showFormatted(a+"/"+b,mWebViewCtgB);}

                                x = 1;
                                figura.setImageResource(R.drawable.kwadrat);
                                licz.setEnabled(false);
                                btnSolution.setEnabled(true);
                                imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);

                                Toast.makeText(Trygonometria.this, getString(R.string.premium),
                                        Toast.LENGTH_LONG).show();
                            } //za malo danych
                            if(isEmpty(a_val) && isEmpty(b_val) && isEmpty(c_val)){
                                Toast.makeText(Trygonometria.this, getString(R.string.notEnough),
                                        Toast.LENGTH_LONG).show();
                                x = 1;
                            }
                        }
                        new ProgressBar(view);
                    } catch (Exception e) {
                        System.out.println("emessage " + e.getMessage());
                        Toast.makeText(Trygonometria.this, getString(R.string.ups),
                                Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Trygonometria.this, getString(R.string.bracket),
                            Toast.LENGTH_LONG).show();
                }
                JavaScript JS = new JavaScript(tekst);
                mWebView.loadDataWithBaseURL("", "" + JS.getTekst(), "text/html", "UTF-8", "");

                TabListener refresh = new TabListener();
                if (btnData.getVisibility() == View.VISIBLE) {
                    refresh.refresh(figura, scrollView, mWebView);
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.setEmpty(a_val, b_val, c_val);
                tekst = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");
                licz.setEnabled(true);
                btnSolution.setEnabled(false);
                a_val.setEnabled(true);
                b_val.setEnabled(true);
                c_val.setEnabled(true);
                figura.setImageResource(R.drawable.kwadrat);
                clear.setTypeface(null, Typeface.NORMAL);
                licz.setTypeface(null, Typeface.BOLD);
                Toast.makeText(Trygonometria.this, getString(R.string.deleted),
                        Toast.LENGTH_SHORT).show();
            }
        });
        sqrtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastFocused.getText().insert(lastFocused.getSelectionStart(), "()\u221a()");
                int s = lastFocused.getSelectionStart();
                int a = s - 1;
                lastFocused.setSelection(a);
            }
        });
        powbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastFocused.getText().insert(lastFocused.getSelectionStart(),"()^()");
                int s = lastFocused.getSelectionStart();
                int a = s - 4;
                lastFocused.setSelection(a);
            }
        });
    }

    public Boolean isEmpty(EditText x){
        return x.getText().toString().equals("");
    }

    private String policzSinA(String a, String c) {
        String jeden = Wartosc.policz(a,a,"*");
        System.out.println("policzPp "+a);
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczPp)+"</b></center><br>" +
                "$$P={a^2}$$<br>" +
                "$$P={{"+Wartosc.formatuj(a)+"}^2}$$<br>" +
                "$$P={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzCosA(String b, String c) {
        String dwa = Wartosc.policz("()\u221a(2)",c,"*");
        String piec = Wartosc.policz(dwa,"2","/");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczAzD)+"</b></center><br>" +
                "$$d={a*√2}$$<br>" +
                "$$a={d/√2}$$<br>" +
                "$$a={{d*√2}/2}$$<br>" +
                "$$a={{{"+Wartosc.formatuj(c)+"}*√2}/2}$$<br>" +
                "$$a={{"+Wartosc.formatuj(dwa)+"}/2}$$<br>" +
                "$$a={"+Wartosc.formatuj(piec)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return piec;
    }

    private String policzTgA(String a, String b) {
        String jeden = Wartosc.policz(a,"()\u221a(2)","*");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczD)+"</b></center><br>" +
                "$$d={a*√2}$$<br>" +
                "$$d={{"+Wartosc.formatuj(a)+"}*√2}$$<br>" +
                "$$d={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzCtgA(String b, String a) {
        String jeden = Wartosc.policz("4",a,"*");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczObwp)+"</b></center><br>" +
                "$$ObwP={a*4}$$<br>" +
                "$$ObwP={{"+Wartosc.formatuj(a)+"}*4}$$<br>" +
                "$$ObwP={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzSinB(String b, String c) {
        String trzy = Wartosc.policz("()\u221a("+c+")","1","*");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczAzPp)+"</b></center><br>" +
                "$$P={a^2}$$<br>" +
                "$$a={√P}$$<br>" +
                "$$a={√{"+Wartosc.formatuj(c)+"}}$$<br>" +
                "$$a={"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return trzy;
    }

    private String policzCosB(String a, String c){
        String jeden = Wartosc.policz(a,"4","/");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczAzObwp)+"</b></center><br>" +
                "$$ObwP={4*a}$$<br>" +
                "$$a={{ObwP}/4}$$<br>" +
                "$$a={{"+Wartosc.formatuj(a)+"}/4}$$<br>" +
                "$$a={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzTgB(String b, String a) {
        String jeden = Wartosc.policz(a,"()\u221a(2)","*");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczD)+"</b></center><br>" +
                "$$d={a*√2}$$<br>" +
                "$$d={{"+Wartosc.formatuj(a)+"}*√2}$$<br>" +
                "$$d={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzCtgB(String a, String b) {
        String jeden = Wartosc.policz("4",a,"*");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczObwp)+"</b></center><br>" +
                "$$ObwP={a*4}$$<br>" +
                "$$ObwP={{"+Wartosc.formatuj(a)+"}*4}$$<br>" +
                "$$ObwP={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        new DotsMenu(item, this);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus)  {
        if(hasFocus){
            lastFocused = (EditText)v;
        }
    }
}
