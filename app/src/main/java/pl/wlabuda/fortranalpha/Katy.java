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

import pl.wlabuda.fortranalpha.R.drawable;
import pl.wlabuda.fortranalpha.R.id;
import pl.wlabuda.fortranalpha.R.layout;

public class Katy extends Activity implements OnFocusChangeListener {

    private Button licz;
    private Button clear;
    private Button sqrtbtn;
    private Button powbtn;
    private EditText a_val;
    private EditText b_val;
    private EditText c_val;
    private EditText d_val;
    private EditText e_val;
    private EditText f_val;
    private EditText g_val;
    private EditText h_val;
    private ImageView figura;
    private EditText lastFocused;
    private String tekst;
    private WebView mWebView;
    private ScrollView scrollView;
    private Button btnReview;
    private Button btnData;
    private Button btnSolution;
    private WebView mWebViewA;
    private WebView mWebViewB;
    private WebView mWebViewC;
    private WebView mWebViewD;
    private WebView mWebViewE;
    private WebView mWebViewF;
    private WebView mWebViewG;
    private WebView mWebViewH;

    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.katy);

        Global.mContext = this.getBaseContext();

        mWebView = (WebView) findViewById(id.webSolution);
        mWebView.setBackgroundColor(0xff0);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebViewA = (WebView) findViewById(id.webA);
        mWebViewA.setBackgroundColor(0xff0);
        WebSettings webSettingsA = mWebViewA.getSettings();
        webSettingsA.setJavaScriptEnabled(true);

        mWebViewB = (WebView) findViewById(id.webB);
        mWebViewB.setBackgroundColor(0xff0);
        WebSettings webSettingsB = mWebViewB.getSettings();
        webSettingsB.setJavaScriptEnabled(true);

        mWebViewC = (WebView) findViewById(id.webC);
        mWebViewC.setBackgroundColor(0xff0);
        WebSettings webSettingsC = mWebViewC.getSettings();
        webSettingsC.setJavaScriptEnabled(true);

        mWebViewD = (WebView) findViewById(id.webD);
        mWebViewD.setBackgroundColor(0xff0);
        WebSettings webSettingsD = mWebViewD.getSettings();
        webSettingsD.setJavaScriptEnabled(true);

        mWebViewE = (WebView) findViewById(id.webE);
        mWebViewE.setBackgroundColor(0xff0);
        WebSettings webSettingsE = mWebViewE.getSettings();
        webSettingsE.setJavaScriptEnabled(true);

        mWebViewF = (WebView) findViewById(id.webF);
        mWebViewF.setBackgroundColor(0xff0);
        WebSettings webSettingsF = mWebViewF.getSettings();
        webSettingsF.setJavaScriptEnabled(true);

        mWebViewG = (WebView) findViewById(id.webG);
        mWebViewG.setBackgroundColor(0xff0);
        WebSettings webSettingsG = mWebViewG.getSettings();
        webSettingsG.setJavaScriptEnabled(true);

        mWebViewH = (WebView) findViewById(id.webH);
        mWebViewH.setBackgroundColor(0xff0);
        WebSettings webSettingsH = mWebViewH.getSettings();
        webSettingsH.setJavaScriptEnabled(true);

        a_val = (EditText) findViewById(id.a);
        b_val = (EditText) findViewById(id.b);
        c_val = (EditText) findViewById(id.c);
        d_val = (EditText) findViewById(id.d);
        e_val = (EditText) findViewById(id.e);
        f_val = (EditText) findViewById(id.f);
        g_val = (EditText) findViewById(id.g);
        h_val = (EditText) findViewById(id.h);
        licz = (Button) findViewById(id.magic);
        clear = (Button) findViewById(id.clear);
        sqrtbtn = (Button) findViewById(id.sqrtbtn);
        powbtn = (Button) findViewById(id.powbtn);
        figura = (ImageView) findViewById(id.imageView);
        scrollView = (ScrollView) findViewById(id.dwa);
        btnReview = (Button)findViewById(R.id.btnReview);
        btnData = (Button)findViewById(R.id.btnData);
        btnSolution = (Button)findViewById(R.id.btnSolution);

        a_val.setOnFocusChangeListener(this);
        b_val.setOnFocusChangeListener(this);
        c_val.setOnFocusChangeListener(this);
        d_val.setOnFocusChangeListener(this);
        e_val.setOnFocusChangeListener(this);
        f_val.setOnFocusChangeListener(this);
        g_val.setOnFocusChangeListener(this);
        h_val.setOnFocusChangeListener(this);

        Global.TouchListener(figura, drawable.katya, a_val);
        Global.TouchListener(figura, drawable.katyb, b_val);
        Global.TouchListener(figura, drawable.katyc, c_val);
        Global.TouchListener(figura, drawable.katyd,d_val);
        Global.TouchListener(figura, drawable.katye,e_val);
        Global.TouchListener(figura, drawable.katyf,f_val);
        Global.TouchListener(figura, drawable.katyg,g_val);
        Global.TouchListener(figura, drawable.katyh,h_val);

        final InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        new TabListener(imm,btnReview,btnData,btnSolution,figura,scrollView,mWebView);

        figura.setImageResource(R.drawable.katy);

        btnSolution.setEnabled(false);

        if (btnData.getVisibility() == View.VISIBLE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tekst = "";
                figura.setImageResource(drawable.katy);

                int x = 0; //koniec petli, wszystko policzone
                int y = 0;
                int z = 0; //za malo danych
                a = a_val.getText().toString();
                d = d_val.getText().toString();
                e = e_val.getText().toString();
                h = h_val.getText().toString();
                b = b_val.getText().toString();
                c = c_val.getText().toString();
                f = f_val.getText().toString();
                g = g_val.getText().toString();

                boolean test = false;
                if(Wartosc.nawiasy(a_val.getText().toString()) &&
                        Wartosc.nawiasy(b_val.getText().toString()) &&
                        Wartosc.nawiasy(c_val.getText().toString()) &&
                        Wartosc.nawiasy(d_val.getText().toString()) &&
                        Wartosc.nawiasy(e_val.getText().toString()) &&
                        Wartosc.nawiasy(f_val.getText().toString()) &&
                        Wartosc.nawiasy(g_val.getText().toString()) &&
                        Wartosc.nawiasy(h_val.getText().toString())) {
                    try {
                        while (!test) {
                            if (!isEmpty(a_val) || !isEmpty(d_val) || !isEmpty(e_val) || !isEmpty(h_val)) {
                                System.out.println("&&&1 ");
                                if (isEmpty(a_val)) {
                                    if (isEmpty(d_val)) {
                                        if (isEmpty(e_val)) {
                                            System.out.println("&&&1.1 ");
                                            a = h;
                                            a_val.setText(h);
                                            d = h;
                                            d_val.setText(h);
                                            e = h;
                                            e_val.setText(h);
                                            policzJeden(a, d, e, h);
                                            JavaScript.showFormatted(h, mWebViewH);
                                            JavaScript.showFormatted(a, mWebViewA);
                                            JavaScript.showFormatted(d, mWebViewD);
                                            JavaScript.showFormatted(e, mWebViewE);
                                        } else {
                                            System.out.println("&&&1.2 ");
                                            a = e;
                                            a_val.setText(e);
                                            d = e;
                                            d_val.setText(e);
                                            h = e;
                                            h_val.setText(e);
                                            policzJeden(a, d, e, h);
                                            JavaScript.showFormatted(h, mWebViewH);
                                            JavaScript.showFormatted(a, mWebViewA);
                                            JavaScript.showFormatted(d, mWebViewD);
                                            JavaScript.showFormatted(e, mWebViewE);
                                        }
                                    } else {
                                        System.out.println("&&&1.3 ");
                                        a = d;
                                        a_val.setText(d);
                                        e = d;
                                        e_val.setText(d);
                                        h = d;
                                        h_val.setText(d);
                                        policzJeden(a, d, e, h);
                                        JavaScript.showFormatted(h, mWebViewH);
                                        JavaScript.showFormatted(a, mWebViewA);
                                        JavaScript.showFormatted(d, mWebViewD);
                                        JavaScript.showFormatted(e, mWebViewE);
                                    }
                                } else {
                                    System.out.println("&&&1.4 ");
                                    d = a;
                                    d_val.setText(a);
                                    e = a;
                                    e_val.setText(d);
                                    h = a;
                                    h_val.setText(a);
                                    policzJeden(a, d, e, h);
                                    JavaScript.showFormatted(h, mWebViewH);
                                    JavaScript.showFormatted(a, mWebViewA);
                                    JavaScript.showFormatted(d, mWebViewD);
                                    JavaScript.showFormatted(e, mWebViewE);
                                }
                                x = 1;
                            }
                            if (!isEmpty(b_val) || !isEmpty(c_val) || !isEmpty(f_val) || !isEmpty(g_val)) {
                                System.out.println("&&&2 ");
                                if (isEmpty(b_val)) {
                                    if (isEmpty(c_val)) {
                                        if (isEmpty(f_val)) {
                                            System.out.println("&&&2.1 ");
                                            b = g;
                                            b_val.setText(g);
                                            c = g;
                                            c_val.setText(g);
                                            f = g;
                                            f_val.setText(g);
                                            policzDwa(b, c, f, g);
                                            JavaScript.showFormatted(g, mWebViewG);
                                            JavaScript.showFormatted(b, mWebViewB);
                                            JavaScript.showFormatted(c, mWebViewC);
                                            JavaScript.showFormatted(f, mWebViewF);
                                        } else {
                                            System.out.println("&&&2.2 ");
                                            b = f;
                                            b_val.setText(f);
                                            c = f;
                                            c_val.setText(f);
                                            g = f;
                                            g_val.setText(f);
                                            policzDwa(b, c, f, g);
                                            JavaScript.showFormatted(g, mWebViewG);
                                            JavaScript.showFormatted(b, mWebViewB);
                                            JavaScript.showFormatted(c, mWebViewC);
                                            JavaScript.showFormatted(f, mWebViewF);
                                        }
                                    } else {
                                        System.out.println("&&&2.3 ");
                                        b = c;
                                        b_val.setText(c);
                                        f = c;
                                        f_val.setText(c);
                                        g = c;
                                        g_val.setText(c);
                                        policzDwa(b, c, f, g);
                                        JavaScript.showFormatted(g, mWebViewG);
                                        JavaScript.showFormatted(b, mWebViewB);
                                        JavaScript.showFormatted(c, mWebViewC);
                                        JavaScript.showFormatted(f, mWebViewF);
                                    }
                                } else {
                                    System.out.println("&&&2.4 ");
                                    c = b;
                                    c_val.setText(b);
                                    f = b;
                                    f_val.setText(b);
                                    g = b;
                                    g_val.setText(b);
                                    policzDwa(b, c, f, g);
                                    JavaScript.showFormatted(g, mWebViewG);
                                    JavaScript.showFormatted(b, mWebViewB);
                                    JavaScript.showFormatted(c, mWebViewC);
                                    JavaScript.showFormatted(f, mWebViewF);
                                }
                                y = 1;
                            }
                            if (x == 0 && y == 1) {
                                System.out.println("&&&3 ");
                                a = policzA(b);
                                a_val.setText(a);
                                JavaScript.showFormatted(a, mWebViewA);
                            }
                            if (x == 1 && y == 0) {
                                System.out.println("&&&4 ");
                                b = policzB(a);
                                b_val.setText(b);
                                JavaScript.showFormatted(b, mWebViewB);
                            }
                            //za malo danych
                            if (isEmpty(a_val) && isEmpty(b_val) && isEmpty(c_val) && isEmpty(d_val) && isEmpty(e_val) && isEmpty(f_val) && isEmpty(g_val) && isEmpty(h_val)) {
                                System.out.println("&&&5 ");
                                x = 1;
                                test = true;
                                Toast.makeText(Katy.this, getString(R.string.notEnough),
                                        Toast.LENGTH_LONG).show();
                                z = 1;
                            }
                            //wszystko policzone, koniec petli
                            if (!a_val.getText().toString().equals("") &&
                                    !b_val.getText().toString().equals("") &&
                                    !c_val.getText().toString().equals("") &&
                                    !d_val.getText().toString().equals("") &&
                                    !e_val.getText().toString().equals("") &&
                                    !f_val.getText().toString().equals("") &&
                                    !g_val.getText().toString().equals("") &&
                                    !h_val.getText().toString().equals("")
                                    ) {
                                System.out.println("&&&6 ");
                                x = 1;
                                figura.setImageResource(R.drawable.katy);
                                licz.setEnabled(false);
                                btnSolution.setEnabled(true);
                                imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);
                                Toast.makeText(Katy.this, getString(R.string.premium),
                                        Toast.LENGTH_LONG).show();
                                test = true;
                            }
                        }
                        new ProgressBar(view);
                    } catch (Exception e) {
                        System.out.println("eMessage " + e.getMessage());
                        Toast.makeText(Katy.this, getString(R.string.ups),
                                Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Katy.this, getString(R.string.bracket),
                            Toast.LENGTH_LONG).show();
                }
                JavaScript JS = new JavaScript(tekst);
                mWebView.loadDataWithBaseURL("", "" + JS.getTekst(), "text/html", "UTF-8", "");

                if(z == 0) {
                    Global.WebViewHide(false, mWebView, mWebViewA, mWebViewB, mWebViewC, mWebViewD, mWebViewE, mWebViewF, mWebViewG, mWebViewH);
                    Global.EditTextHide(true, a_val, b_val, c_val, d_val, e_val, f_val, g_val, h_val);
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
                Global.setEmpty(a_val, b_val, c_val, d_val, e_val, f_val, g_val, h_val);
                tekst = "";
                Global.EditTextHide(false, a_val, b_val, c_val, d_val, e_val, f_val, g_val, h_val);
                Global.WebViewHide(true, mWebViewA, mWebViewB, mWebViewC, mWebViewD, mWebViewE, mWebViewF, mWebViewG, mWebViewH);
                licz.setEnabled(true);
                btnSolution.setEnabled(false);
                figura.setImageResource(R.drawable.katy);
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");

                Toast.makeText(Katy.this, getString(R.string.deleted),
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
                lastFocused.getText().insert(lastFocused.getSelectionStart(), "()^()");
                int s = lastFocused.getSelectionStart();
                int a = s - 4;
                lastFocused.setSelection(a);
            }
        });
    }

    public Boolean isEmpty(EditText x) {
        if (x.getText().toString().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    private String policzA(String b) {
        String jeden = Wartosc.policz("180", b, "-");
        String solucja1 = "<center><b>"+getString(R.string.katypoliczAzB)+"</b></center><br>" +
                "$$a={180-b}$$<br>" +
                "$$a={180-{"+Wartosc.formatuj(b)+"}$$<br>" +
                "$$a={"+Wartosc.formatuj(jeden)+"}$$<br>" +
        "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzB(String a) {
        String jeden = Wartosc.policz("180", a, "-");
        String solucja1 = "<center><b>"+getString(R.string.katypoliczBzA)+"</b></center><br>" +
                "$$b={180-a}$$<br>" +
                "$$b={180-{"+Wartosc.formatuj(a)+"}$$<br>" +
                "$$b={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private void policzJeden(String a, String d, String e, String h) {
        String solucja1 = "<center><b>a = d = e = h</b></center><br>" +
                "$$a={"+Wartosc.formatuj(a)+"}$$<br>" +
                "$$d={"+Wartosc.formatuj(d)+"}$$<br>" +
                "$$e={"+Wartosc.formatuj(e)+"}$$<br>" +
                "$$h={"+Wartosc.formatuj(h)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
    }

    private void policzDwa(String b, String c, String f, String g) {
        String solucja1 = "<center><b>b = c = f = g</b></center><br>" +
                "$$b={"+Wartosc.formatuj(b)+"}$$<br>" +
                "$$c={"+Wartosc.formatuj(c)+"}$$<br>" +
                "$$f={"+Wartosc.formatuj(f)+"}$$<br>" +
                "$$g={"+Wartosc.formatuj(g)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
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
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            lastFocused = (EditText) v;
        }
    }
}
