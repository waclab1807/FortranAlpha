package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.content.pm.ActivityInfo;
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
import android.widget.ScrollView;
import android.widget.Toast;

/**
 * Created by waclab1807 on 31.03.15.
 */

public class Kwadrat extends Activity implements OnFocusChangeListener{

    private Button licz;
    private Button clear;
    private Button sqrtbtn;
    private Button powbtn;
    private Button btnReview;
    private Button btnData;
    private Button btnSolution;
    private EditText pp_val;
    private EditText a_val;
    private EditText D_val;
    private EditText obwp_val;
    private EditText lastFocused;
    private String tekst;
    private WebView mWebView;
    private WebView mWebViewPp;
    private WebView mWebViewA;
    private WebView mWebViewD;
    private WebView mWebViewObw;
    private ImageView figura;
    private ScrollView scrollView;

    String a;
    String pp;
    String D;
    String obwp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kwadrat);
        Global.mContext = this.getBaseContext();

        pp_val = (EditText) findViewById(R.id.pp);
        a_val = (EditText) findViewById(R.id.a);
        D_val = (EditText) findViewById(R.id.d);
        obwp_val = (EditText) findViewById(R.id.obw);
        licz = (Button) findViewById(R.id.magic);
        clear = (Button) findViewById(R.id.clear);
        sqrtbtn = (Button) findViewById(R.id.sqrtbtn);
        powbtn = (Button) findViewById(R.id.powbtn);
        figura = (ImageView) findViewById(R.id.imageView);
        btnReview = (Button)findViewById(R.id.btnReview);
        btnData = (Button)findViewById(R.id.btnData);
        btnSolution = (Button)findViewById(R.id.btnSolution);
        scrollView = (ScrollView)findViewById(R.id.dwa);

        if (btnData.getVisibility() == View.VISIBLE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        mWebView = (WebView) findViewById(R.id.webSolution);
        WebSettings webSettings = mWebView.getSettings();
        mWebView.setBackgroundColor(0xff0);
        webSettings.setJavaScriptEnabled(true);

        mWebViewPp = (WebView) findViewById(R.id.webPp);
        WebSettings webSettings1 = mWebViewPp.getSettings();
        mWebViewPp.setBackgroundColor(0xff0);
        webSettings1.setJavaScriptEnabled(true);

        mWebViewA = (WebView) findViewById(R.id.weba);
        WebSettings webSettings2 = mWebViewA.getSettings();
        mWebViewA.setBackgroundColor(0xff0);
        webSettings2.setJavaScriptEnabled(true);

        mWebViewD = (WebView) findViewById(R.id.webd);
        WebSettings webSettings3 = mWebViewD.getSettings();
        mWebViewD.setBackgroundColor(0xff0);
        webSettings3.setJavaScriptEnabled(true);

        mWebViewObw = (WebView) findViewById(R.id.webObwp);
        WebSettings webSettings4 = mWebViewObw.getSettings();
        mWebViewObw.setBackgroundColor(0xff0);
        webSettings4.setJavaScriptEnabled(true);

        a_val.setOnFocusChangeListener(this);
        D_val.setOnFocusChangeListener(this);
        pp_val.setOnFocusChangeListener(this);
        obwp_val.setOnFocusChangeListener(this);

        new TouchListener(figura,R.drawable.kwadratpp,pp_val);
        new TouchListener(figura,R.drawable.kwadrata,a_val);
        new TouchListener(figura,R.drawable.kwadratd,D_val);
        new TouchListener(figura,R.drawable.kwadratobw,obwp_val);

        final InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        new TabListener(imm,btnReview,btnData,btnSolution,figura,scrollView,mWebView);

        figura.setImageResource(R.drawable.kwadrat);

        btnSolution.setEnabled(false);

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean bD = false;
                boolean bpp = false;
                boolean bobwp = false;

                tekst = "";

                int x = 0; //koniec petli, wszystko policzone
                int y = 0; //za mało danych aby policzyć

                if(Wartosc.nawiasy(a_val.getText().toString()) &&
                        Wartosc.nawiasy(pp_val.getText().toString()) &&
                        Wartosc.nawiasy(D_val.getText().toString()) &&
                        Wartosc.nawiasy(obwp_val.getText().toString())) {
                    try {
                        while (x == 0) {
                            //obliczanie a lub pp lub obwp
                            //czy jest a
                            if (!isEmpty(a_val)) {
                                System.out.println("^^^^^^^^1");
                                a = a_val.getText().toString();
                                if (isEmpty(pp_val) && !bpp) {
                                    System.out.println("^^^^^^^^1.1");
                                    String s = policzPp(a);
                                    pp_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewPp);
                                    bpp = true;
                                }
                                if (isEmpty(obwp_val) && !bobwp) {
                                    String s = policzObwp(a);
                                    obwp_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewObw);
                                    bobwp = true;
                                    System.out.println("^^^^^^^^1.2");
                                }
                                if (isEmpty(D_val) && !bD) {
                                    String s = policzD(a);
                                    D_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewD);
                                    bD = true;
                                    System.out.println("^^^^^^^^1.3");
                                }
                                JavaScript.showFormatted(a,mWebViewA);
                            } else {
                                if (!isEmpty(pp_val)) {
                                    System.out.println("^^^^^^^^2");
                                    pp = pp_val.getText().toString();
                                    JavaScript.showFormatted(pp,mWebViewPp);
                                    bpp = true;
                                    String s = policzAzPp(pp);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewA);
                                }
                                if (!isEmpty(D_val)) {
                                    System.out.println("^^^^^^^^7");
                                    D = D_val.getText().toString();
                                    JavaScript.showFormatted(D,mWebViewD);
                                    bD = true;
                                    String s = policzAzD(D);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewA);
                                }
                                if (!isEmpty(obwp_val)) {
                                    System.out.println("^^^^^^^^0");
                                    obwp = obwp_val.getText().toString();
                                    JavaScript.showFormatted(obwp,mWebViewObw);
                                    bobwp = true;
                                    String s = policzAzObwp(obwp);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewA);
                                }
                            }
                            //wszystko policzone, koniec petli
                            if (!a_val.getText().toString().equals("") &&
                                    !pp_val.getText().toString().equals("") &&
                                    !obwp_val.getText().toString().equals("") &&
                                    !D_val.getText().toString().equals("")
                                    ) {
                                x = 1;
                                figura.setImageResource(R.drawable.kwadrat);
                                licz.setEnabled(false);
                                btnSolution.setEnabled(true);
                                imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);

                                Toast.makeText(Kwadrat.this, getString(R.string.premium),
                                        Toast.LENGTH_LONG).show();
                            } //za malo danych
                            if(isEmpty(a_val) && isEmpty(pp_val) && isEmpty(obwp_val) && isEmpty(D_val)){
                                Toast.makeText(Kwadrat.this, getString(R.string.notEnough),
                                        Toast.LENGTH_LONG).show();
                                x = 1;
                                y = 1;
                            }
                        }
                        new ProgressBar(view);
                    } catch (Exception e) {
                        System.out.println("emessage " + e.getMessage());
                        Toast.makeText(Kwadrat.this, getString(R.string.ups),
                                Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Kwadrat.this, getString(R.string.bracket),
                            Toast.LENGTH_LONG).show();
                }
                JavaScript JS = new JavaScript(tekst);
                mWebView.loadDataWithBaseURL("", "" + JS.getTekst(), "text/html", "UTF-8", "");

                if(y == 0) {
                    new WebViewHide(false, mWebView, mWebViewA, mWebViewObw, mWebViewD, mWebViewPp);
                    new EditTextHide(true, pp_val, a_val, D_val, obwp_val);
                }
                TabListener refresh = new TabListener();
                if (btnData.getVisibility() == View.VISIBLE) {
                    refresh.refresh(figura, scrollView, mWebView);
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.setEmpty(a_val,D_val,pp_val,obwp_val);
                tekst = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");
                new EditTextHide(false,a_val,D_val,pp_val,obwp_val);
                new WebViewHide(true, mWebViewA,mWebViewD,mWebViewObw,mWebViewPp);
                licz.setEnabled(true);
                btnSolution.setEnabled(false);
                figura.setImageResource(R.drawable.kwadrat);
                Toast.makeText(Kwadrat.this, getString(R.string.deleted),
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

    private String policzPp(String a) {
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

    private String policzAzD(String D) {
        String dwa = Wartosc.policz("()\u221a(2)",D,"*");
        String piec = Wartosc.policz(dwa,"2","/");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczAzD)+"</b></center><br>" +
                "$$d={a*√2}$$<br>" +
                "$$a={d/√2}$$<br>" +
                "$$a={{d*√2}/2}$$<br>" +
                "$$a={{{"+Wartosc.formatuj(D)+"}*√2}/2}$$<br>" +
                "$$a={{"+Wartosc.formatuj(dwa)+"}/2}$$<br>" +
                "$$a={"+Wartosc.formatuj(piec)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return piec;
    }

    private String policzD(String a) {
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

    private String policzObwp(String a) {
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

    private String policzAzPp(String Pp) {
        String trzy = Wartosc.policz("()\u221a("+Pp+")","1","*");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczAzPp)+"</b></center><br>" +
                "$$P={a^2}$$<br>" +
                "$$a={√P}$$<br>" +
                "$$a={√{"+Wartosc.formatuj(Pp)+"}}$$<br>" +
                "$$a={"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return trzy;
    }

    private String policzAzObwp(String Obwp){
        String jeden = Wartosc.policz(Obwp,"4","/");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczAzObwp)+"</b></center><br>" +
                "$$ObwP={4*a}$$<br>" +
                "$$a={{ObwP}/4}$$<br>" +
                "$$a={{"+Wartosc.formatuj(Obwp)+"}/4}$$<br>" +
                "$$a={"+Wartosc.formatuj(jeden)+"}$$<br>" +
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
