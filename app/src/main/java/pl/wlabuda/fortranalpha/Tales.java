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

public class Tales extends Activity implements OnFocusChangeListener {

    private Button licz;
    private Button clear;
    private Button sqrtbtn;
    private Button powbtn;
    private EditText a_val;
    private EditText c_val;
    private EditText b_val;
    private EditText d_val;
    private EditText e_val;
    private EditText f_val;
    private EditText ac_val;
    private EditText bd_val;
    private ImageView figura;
    private EditText lastFocused;
    public static String tekst = "";
    private WebView mWebView;
    private WebView mWebViewA;
    private WebView mWebViewB;
    private WebView mWebViewC;
    private WebView mWebViewD;
    private WebView mWebViewE;
    private WebView mWebViewF;
    private WebView mWebViewAC;
    private WebView mWebViewBD;
    private ScrollView scrollView;
    private Button btnReview;
    private Button btnData;
    private Button btnSolution;

    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String AC;
    String BD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.tales);

        Global.mContext = this.getBaseContext();

        a_val = (EditText) findViewById(id.a);
        b_val = (EditText) findViewById(id.b);
        c_val = (EditText) findViewById(id.c);
        d_val = (EditText) findViewById(id.d);
        e_val = (EditText) findViewById(id.e);
        f_val = (EditText) findViewById(id.f);
        ac_val = (EditText) findViewById(id.AC);
        bd_val = (EditText) findViewById(id.BD);
        licz = (Button) findViewById(id.magic);
        clear = (Button) findViewById(id.clear);
        sqrtbtn = (Button) findViewById(id.sqrtbtn);
        powbtn = (Button) findViewById(id.powbtn);
        btnReview = (Button)findViewById(R.id.btnReview);
        btnData = (Button)findViewById(R.id.btnData);
        btnSolution = (Button)findViewById(R.id.btnSolution);
        scrollView = (ScrollView)findViewById(R.id.dwa);
        figura = (ImageView) findViewById(id.imageView);

        if (btnData.getVisibility() == View.VISIBLE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        mWebView = (WebView) findViewById(id.webSolution);
        mWebView.setBackgroundColor(0xff0);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebViewA = (WebView) findViewById(id.weba);
        WebSettings webSettingsA = mWebViewA.getSettings();
        mWebViewA.setBackgroundColor(0xff0);
        webSettingsA.setJavaScriptEnabled(true);

        mWebViewB = (WebView) findViewById(R.id.webb);
        WebSettings webSettingsB = mWebViewB.getSettings();
        mWebViewB.setBackgroundColor(0xff0);
        webSettingsB.setJavaScriptEnabled(true);

        mWebViewC = (WebView) findViewById(R.id.webc);
        WebSettings webSettingsC = mWebViewC.getSettings();
        mWebViewC.setBackgroundColor(0xff0);
        webSettingsC.setJavaScriptEnabled(true);

        mWebViewD = (WebView) findViewById(R.id.webd);
        WebSettings webSettings3 = mWebViewD.getSettings();
        mWebViewD.setBackgroundColor(0xff0);
        webSettings3.setJavaScriptEnabled(true);

        mWebViewE = (WebView) findViewById(R.id.webe);
        WebSettings webSettingsE = mWebViewE.getSettings();
        mWebViewE.setBackgroundColor(0xff0);
        webSettingsE.setJavaScriptEnabled(true);

        mWebViewF = (WebView) findViewById(R.id.webf);
        WebSettings webSettingsF = mWebViewF.getSettings();
        mWebViewF.setBackgroundColor(0xff0);
        webSettingsF.setJavaScriptEnabled(true);

        mWebViewAC = (WebView) findViewById(id.webAC);
        WebSettings webSettingsAC = mWebViewAC.getSettings();
        mWebViewAC.setBackgroundColor(0xff0);
        webSettingsAC.setJavaScriptEnabled(true);

        mWebViewBD = (WebView) findViewById(R.id.webBD);
        WebSettings webSettingsBD = mWebViewBD.getSettings();
        mWebViewBD.setBackgroundColor(0xff0);
        webSettingsBD.setJavaScriptEnabled(true);

        a_val.setOnFocusChangeListener(this);
        b_val.setOnFocusChangeListener(this);
        c_val.setOnFocusChangeListener(this);
        d_val.setOnFocusChangeListener(this);
        e_val.setOnFocusChangeListener(this);
        f_val.setOnFocusChangeListener(this);
        ac_val.setOnFocusChangeListener(this);
        bd_val.setOnFocusChangeListener(this);

        Global.TouchListener(figura,R.drawable.talesa,a_val);
        Global.TouchListener(figura,R.drawable.talesb,b_val);
        Global.TouchListener(figura,R.drawable.talesc,c_val);
        Global.TouchListener(figura,R.drawable.talesd,d_val);
        Global.TouchListener(figura,R.drawable.talese,e_val);
        Global.TouchListener(figura,R.drawable.talesf,f_val);
        Global.TouchListener(figura,R.drawable.talesac,ac_val);
        Global.TouchListener(figura,R.drawable.talesbd,bd_val);

        final InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        new TabListener(imm,btnReview,btnData,btnSolution,figura,scrollView,mWebView);

        figura.setImageResource(drawable.tales);

        btnSolution.setEnabled(false);

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tekst = "";
                figura.setImageResource(drawable.tales);

                int x = 0; //koniec petli, wszystko policzone
                int y = 0; //za mało danych aby policzyć

                if(Wartosc.nawiasy(a_val.getText().toString()) &&
                        Wartosc.nawiasy(b_val.getText().toString()) &&
                        Wartosc.nawiasy(c_val.getText().toString()) &&
                        Wartosc.nawiasy(d_val.getText().toString())&&
                        Wartosc.nawiasy(e_val.getText().toString())&&
                        Wartosc.nawiasy(f_val.getText().toString())&&
                        Wartosc.nawiasy(ac_val.getText().toString())&&
                        Wartosc.nawiasy(bd_val.getText().toString())) {
                    try {
                        while (x == 0) {
                            if (!isEmpty(a_val) && !isEmpty(c_val) && isEmpty(ac_val)) {
                                System.out.println("^^^^^^^^1");
                                a = a_val.getText().toString();
                                c = c_val.getText().toString();
                                String s = policzAC(a, c);
                                ac_val.setText(s);
                                JavaScript.showFormatted(a, mWebViewA);
                                JavaScript.showFormatted(c, mWebViewC);
                                JavaScript.showFormatted(s, mWebViewAC);
                            } else if (!isEmpty(b_val) && !isEmpty(d_val) && isEmpty(bd_val)) {
                                System.out.println("^^^^^^^^2");
                                b = b_val.getText().toString();
                                d = d_val.getText().toString();
                                String s = policzBD(b, d);
                                bd_val.setText(s);
                                JavaScript.showFormatted(b, mWebViewB);
                                JavaScript.showFormatted(d, mWebViewD);
                                JavaScript.showFormatted(s, mWebViewBD);
                            } else if (!isEmpty(a_val) && !isEmpty(b_val) && !isEmpty(c_val) && isEmpty(d_val)) {
                                System.out.println("^^^^^^^^3");
                                a = a_val.getText().toString();
                                b = b_val.getText().toString();
                                c = c_val.getText().toString();
                                String s = policzDzABC(a, b, c);
                                d_val.setText(s);
                                JavaScript.showFormatted(a, mWebViewA);
                                JavaScript.showFormatted(c, mWebViewC);
                                JavaScript.showFormatted(b, mWebViewB);
                                JavaScript.showFormatted(s, mWebViewD);
                            } else if (!isEmpty(a_val) && !isEmpty(b_val) && !isEmpty(d_val) && isEmpty(c_val)) {
                                System.out.println("^^^^^^^^4");
                                a = a_val.getText().toString();
                                b = b_val.getText().toString();
                                d = d_val.getText().toString();
                                String s = policzCzABD(a, b, d);
                                c_val.setText(s);
                                JavaScript.showFormatted(a, mWebViewA);
                                JavaScript.showFormatted(d, mWebViewD);
                                JavaScript.showFormatted(b, mWebViewB);
                                JavaScript.showFormatted(s, mWebViewC);
                            } else if (!isEmpty(a_val) && !isEmpty(c_val) && !isEmpty(d_val) && isEmpty(b_val)) {
                                System.out.println("^^^^^^^^5");
                                a = a_val.getText().toString();
                                c = c_val.getText().toString();
                                d = d_val.getText().toString();
                                String s = policzBzACD(a, c, d);
                                b_val.setText(s);
                                JavaScript.showFormatted(a, mWebViewA);
                                JavaScript.showFormatted(c, mWebViewC);
                                JavaScript.showFormatted(d, mWebViewD);
                                JavaScript.showFormatted(s, mWebViewB);
                            } else if (!isEmpty(b_val) && !isEmpty(c_val) && !isEmpty(d_val) && isEmpty(a_val)) {
                                System.out.println("^^^^^^^^6");
                                b = b_val.getText().toString();
                                c = c_val.getText().toString();
                                d = d_val.getText().toString();
                                String s = policzAzBCD(b, c, d);
                                a_val.setText(s);
                                JavaScript.showFormatted(d, mWebViewD);
                                JavaScript.showFormatted(c, mWebViewC);
                                JavaScript.showFormatted(b, mWebViewB);
                                JavaScript.showFormatted(s, mWebViewA);
                            } else if (!isEmpty(ac_val) && !isEmpty(a_val) && isEmpty(c_val)) {
                                System.out.println("^^^^^^^^7");
                                a = a_val.getText().toString();
                                AC = ac_val.getText().toString();
                                String s = policzC(AC, a);
                                c_val.setText(s);
                                JavaScript.showFormatted(a, mWebViewA);
                                JavaScript.showFormatted(AC, mWebViewAC);
                                JavaScript.showFormatted(s, mWebViewC);
                            } else if (!isEmpty(ac_val) && !isEmpty(c_val) && isEmpty(a_val)) {
                                System.out.println("^^^^^^^^7");
                                c = c_val.getText().toString();
                                AC = ac_val.getText().toString();
                                String s = policzA(AC, c);
                                a_val.setText(s);
                                JavaScript.showFormatted(c, mWebViewC);
                                JavaScript.showFormatted(AC, mWebViewAC);
                                JavaScript.showFormatted(s, mWebViewA);
                            } else if (!isEmpty(bd_val) && !isEmpty(b_val) && isEmpty(d_val)) {
                                System.out.println("^^^^^^^^8");
                                b = b_val.getText().toString();
                                BD = bd_val.getText().toString();
                                String s = policzD(BD, b);
                                d_val.setText(s);
                                JavaScript.showFormatted(BD, mWebViewBD);
                                JavaScript.showFormatted(b, mWebViewB);
                                JavaScript.showFormatted(s, mWebViewD);
                            } else if (!isEmpty(bd_val) && !isEmpty(d_val) && isEmpty(b_val)) {
                                System.out.println("^^^^^^^^9");
                                d = d_val.getText().toString();
                                BD = bd_val.getText().toString();
                                String s = policzB(BD, d);
                                b_val.setText(s);
                                JavaScript.showFormatted(BD, mWebViewBD);
                                JavaScript.showFormatted(d, mWebViewD);
                                JavaScript.showFormatted(s, mWebViewB);
                            } else if (!isEmpty(bd_val) && !isEmpty(a_val) && !isEmpty(ac_val) && isEmpty(b_val)) {
                                System.out.println("^^^^^^^14");
                                BD = bd_val.getText().toString();
                                AC = ac_val.getText().toString();
                                a = a_val.getText().toString();
                                String s = policzBzACBDA(AC, BD, a);
                                b_val.setText(s);
                                JavaScript.showFormatted(a, mWebViewA);
                                JavaScript.showFormatted(AC, mWebViewAC);
                                JavaScript.showFormatted(BD, mWebViewBD);
                                JavaScript.showFormatted(s, mWebViewB);
                            } else if (!isEmpty(bd_val) && !isEmpty(b_val) && !isEmpty(ac_val) && isEmpty(a_val)) {
                                System.out.println("^^^^^^^15");
                                BD = bd_val.getText().toString();
                                AC = ac_val.getText().toString();
                                b = b_val.getText().toString();
                                String s = policzAzACBDB(AC, BD, b);
                                a_val.setText(s);
                                JavaScript.showFormatted(BD, mWebViewBD);
                                JavaScript.showFormatted(AC, mWebViewAC);
                                JavaScript.showFormatted(b, mWebViewB);
                                JavaScript.showFormatted(s, mWebViewA);
                            } else if (!isEmpty(a_val) && !isEmpty(e_val) && !isEmpty(f_val) && isEmpty(ac_val)) {
                                System.out.println("^^^^^^^16");
                                a = a_val.getText().toString();
                                e = e_val.getText().toString();
                                f = f_val.getText().toString();
                                String s = policzACzAEF(a, e, f);
                                c_val.setText(s);
                                JavaScript.showFormatted(a, mWebViewA);
                                JavaScript.showFormatted(e, mWebViewE);
                                JavaScript.showFormatted(f, mWebViewF);
                                JavaScript.showFormatted(s, mWebViewC);
                            } else if (!isEmpty(b_val) && !isEmpty(e_val) && !isEmpty(f_val) && isEmpty(bd_val)) {
                                System.out.println("^^^^^^^17");
                                b = b_val.getText().toString();
                                e = e_val.getText().toString();
                                f = f_val.getText().toString();
                                String s = policzBDzBEF(b, e, f);
                                d_val.setText(s);
                                JavaScript.showFormatted(b, mWebViewB);
                                JavaScript.showFormatted(e, mWebViewE);
                                JavaScript.showFormatted(f, mWebViewF);
                                JavaScript.showFormatted(s, mWebViewD);
                            } else if (!isEmpty(ac_val) && !isEmpty(e_val) && !isEmpty(f_val) && isEmpty(a_val)) {
                                System.out.println("^^^^^^^20");
                                AC = ac_val.getText().toString();
                                e = e_val.getText().toString();
                                f = f_val.getText().toString();
                                String s = policzAzACEF(AC, e, f);
                                a_val.setText(s);
                                JavaScript.showFormatted(AC, mWebViewAC);
                                JavaScript.showFormatted(e, mWebViewE);
                                JavaScript.showFormatted(f, mWebViewF);
                                JavaScript.showFormatted(s, mWebViewA);
                            } else if (!isEmpty(bd_val) && !isEmpty(e_val) && !isEmpty(f_val) && isEmpty(b_val)) {
                                System.out.println("^^^^^^^21");
                                BD = bd_val.getText().toString();
                                e = e_val.getText().toString();
                                f = f_val.getText().toString();
                                String s = policzBzBDEF(BD, e, f);
                                b_val.setText(s);
                                JavaScript.showFormatted(BD, mWebViewBD);
                                JavaScript.showFormatted(e, mWebViewE);
                                JavaScript.showFormatted(f, mWebViewF);
                                JavaScript.showFormatted(s, mWebViewB);
                            } else if (!isEmpty(bd_val) && !isEmpty(e_val) && !isEmpty(b_val) && isEmpty(f_val)) {
                                System.out.println("^^^^^^^22");
                                BD = bd_val.getText().toString();
                                e = e_val.getText().toString();
                                b = b_val.getText().toString();
                                String s = policzFzBD(BD, b, e);
                                f_val.setText(s);
                                JavaScript.showFormatted(BD, mWebViewBD);
                                JavaScript.showFormatted(e, mWebViewE);
                                JavaScript.showFormatted(b, mWebViewB);
                                JavaScript.showFormatted(s, mWebViewF);
                            } else if (!isEmpty(bd_val) && !isEmpty(f_val) && !isEmpty(b_val) && isEmpty(e_val)) {
                                System.out.println("^^^^^^^23");
                                BD = bd_val.getText().toString();
                                f = f_val.getText().toString();
                                b = b_val.getText().toString();
                                String s = policzEzBD(BD, b, f);
                                e_val.setText(s);
                                JavaScript.showFormatted(BD, mWebViewBD);
                                JavaScript.showFormatted(b, mWebViewB);
                                JavaScript.showFormatted(f, mWebViewF);
                                JavaScript.showFormatted(s, mWebViewE);
                            } else if (!isEmpty(ac_val) && !isEmpty(e_val) && !isEmpty(a_val) && isEmpty(f_val)) {
                                System.out.println("^^^^^^^24");
                                AC = ac_val.getText().toString();
                                e = e_val.getText().toString();
                                a = a_val.getText().toString();
                                String s = policzFzAC(AC, a, e);
                                f_val.setText(s);
                                JavaScript.showFormatted(AC, mWebViewAC);
                                JavaScript.showFormatted(e, mWebViewE);
                                JavaScript.showFormatted(a, mWebViewA);
                                JavaScript.showFormatted(s, mWebViewF);
                            } else if (!isEmpty(ac_val) && !isEmpty(f_val) && !isEmpty(a_val) && isEmpty(e_val)) {
                                System.out.println("^^^^^^^24");
                                AC = ac_val.getText().toString();
                                f = f_val.getText().toString();
                                a = a_val.getText().toString();
                                String s = policzEzAC(AC, a, f);
                                e_val.setText(s);
                                JavaScript.showFormatted(AC, mWebViewAC);
                                JavaScript.showFormatted(f, mWebViewF);
                                JavaScript.showFormatted(a, mWebViewA);
                                JavaScript.showFormatted(s, mWebViewE);
                            } else {      //za malo danych
                                y = 1;
                                x = 1;
                                btnSolution.setEnabled(true);
                                Global.WebViewHide(false, mWebView, mWebViewA, mWebViewB, mWebViewC, mWebViewD, mWebViewE, mWebViewF, mWebViewAC, mWebViewBD);
                                Global.EditTextHide(true, a_val, b_val, c_val, d_val, e_val, f_val, ac_val, bd_val);
                                imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);
                                Toast.makeText(Tales.this, getString(R.string.notEnough),
                                        Toast.LENGTH_LONG).show();
                            }
                            //wszystko policzone, koniec petli
                            if (!a_val.getText().toString().equals("") &&
                                    !a_val.getText().toString().equals("") &&
                                    !b_val.getText().toString().equals("") &&
                                    !c_val.getText().toString().equals("") &&
                                    !d_val.getText().toString().equals("") &&
                                    !e_val.getText().toString().equals("") &&
                                    !f_val.getText().toString().equals("") &&
                                    !ac_val.getText().toString().equals("") &&
                                    !bd_val.getText().toString().equals("")
                                    ) {
                                x = 1;
                                Toast.makeText(Tales.this, getString(R.string.premium),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                        new ProgressBar(view);
                    } catch (Exception e) {
                        System.out.println("eMessage " + e.getMessage());
                        Toast.makeText(Tales.this, getString(R.string.ups),
                                Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Tales.this, getString(R.string.bracket),
                            Toast.LENGTH_LONG).show();
                }
                JavaScript JS = new JavaScript(tekst);
                mWebView.loadDataWithBaseURL("", "" + JS.getTekst(), "text/html", "UTF-8", "");

                licz.setEnabled(false);
                figura.setImageResource(drawable.tales);

                TabListener refresh = new TabListener();
                if (btnData.getVisibility() == View.VISIBLE) {
                    refresh.refresh(figura, scrollView, mWebView);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.setEmpty(a_val,b_val,c_val,d_val,e_val,f_val,ac_val,bd_val);
                tekst = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");
                Global.EditTextHide(false, a_val, b_val, c_val, d_val, e_val, f_val, ac_val, bd_val);
                Global.WebViewHide(true, mWebViewA, mWebViewB, mWebViewC, mWebViewD, mWebViewE, mWebViewF, mWebViewAC, mWebViewBD);
                licz.setEnabled(true);
                btnSolution.setEnabled(false);
                figura.setImageResource(R.drawable.tales);
                Toast.makeText(Tales.this, getString(R.string.deleted),
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
        return x.getText().toString().equals("");
    }

    private String policzAC(String a, String c) {
        String jeden = Wartosc.policz(a, c, "+");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczAC)+"</b></center><br>" +
                "$$AC={a + c}$$<br>" +
                "$$AC={{" + Wartosc.formatuj(a) + "} + {" + Wartosc.formatuj(c) + "}}$$<br>" +
                "$$AC={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzBD(String b, String d) {
        String jeden = Wartosc.policz(b, d, "+");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczBD)+"</b></center><br>" +
                "$$BD={b + d}$$<br>" +
                "$$BD={{" + Wartosc.formatuj(b) + "} + {" + Wartosc.formatuj(d) + "}}$$<br>" +
                "$$BD={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzDzABC(String a, String b, String c) {
        String jeden = Wartosc.policz(b, c, "*");
        String dwa = Wartosc.policz(jeden, a, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczDzABC)+"</b></center><br>" +
                "$${a}/{b}={c}/{d}$$<br>" +
                "$$d={b*c}/{a}$$<br>" +
                "$$d={{" + Wartosc.formatuj(b) + "}*{" + Wartosc.formatuj(c) + "}}/{" + Wartosc.formatuj(a) + "}$$<br>" +
                "$$d={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(a) + "}$$<br>" +
                "$$d={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzCzABD(String a, String b, String d) {
        String jeden = Wartosc.policz(d, a, "*");
        String dwa = Wartosc.policz(jeden, b, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczCzABD)+"</b></center><br>" +
                "$${a}/{c}={b}/{d}$$<br>" +
                "$$c={d*a}/{b}$$<br>" +
                "$$c={{" + Wartosc.formatuj(d) + "}*{" + Wartosc.formatuj(a) + "}}/{" + Wartosc.formatuj(b) + "}$$<br>" +
                "$$c={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(b) + "}$$<br>" +
                "$$c={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzBzACD(String a, String c, String d) {
        String jeden = Wartosc.policz(d, a, "*");
        String dwa = Wartosc.policz(jeden, c, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczBzACD)+"</b></center><br>" +
                "$${a}/{c}={b}/{d}$$<br>" +
                "$$b={d*a}/{c}$$<br>" +
                "$$b={{" + Wartosc.formatuj(d) + "}*{" + Wartosc.formatuj(a) + "}}/{" + Wartosc.formatuj(c) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(c) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzAzBCD(String b, String c, String d) {
        String jeden = Wartosc.policz(b, c, "*");
        String dwa = Wartosc.policz(jeden, d, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczAzBCD)+"</b></center><br>" +
                "$${a}/{c}={b}/{d}$$<br>" +
                "$$b={d*a}/{c}$$<br>" +
                "$$b={{" + Wartosc.formatuj(b) + "}*{" + Wartosc.formatuj(c) + "}}/{" + Wartosc.formatuj(d) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(d) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzC(String ac, String a) {
        String jeden = Wartosc.policz(ac, a, "-");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczC)+"</b></center><br>" +
                "$${AC}={a + c}$$<br>" +
                "$$c={AC - a}$$<br>" +
                "$$c={" + Wartosc.formatuj(ac) + "}-{" + Wartosc.formatuj(a) + "}$$<br>" +
                "$$c={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzA(String ac, String c) {
        String jeden = Wartosc.policz(ac, c, "-");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczA)+"</b></center><br>" +
                "$${AC}={a + c}$$<br>" +
                "$$a={AC - c}$$<br>" +
                "$$c={" + Wartosc.formatuj(ac) + "}-{" + Wartosc.formatuj(c) + "}$$<br>" +
                "$$c={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzD(String bd, String b) {
        String jeden = Wartosc.policz(bd, b, "-");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczD)+"</b></center><br>" +
                "$${BD}={b + d}$$<br>" +
                "$$d={BD - b}$$<br>" +
                "$$d={" + Wartosc.formatuj(bd) + "}-{" + Wartosc.formatuj(b) + "}$$<br>" +
                "$$d={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzB(String bd, String d) {
        String jeden = Wartosc.policz(bd, d, "-");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczB)+"</b></center><br>" +
                "$${BD}={b + d}$$<br>" +
                "$$b={BD - d}$$<br>" +
                "$$b={" + Wartosc.formatuj(bd) + "}-{" + Wartosc.formatuj(d) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzBzACBDA(String ac, String bd, String a) {
        String jeden = Wartosc.policz(a, bd, "*");
        String dwa = Wartosc.policz(jeden, ac, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczBzACBDA)+"</b></center><br>" +
                "$${a}/{AC}={b}/{BD}$$<br>" +
                "$$b={a*BD}/{AC}$$<br>" +
                "$$b={{" + Wartosc.formatuj(a) + "}*{" + Wartosc.formatuj(bd) + "}}/{" + Wartosc.formatuj(ac) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(ac) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzAzACBDB(String ac, String bd, String b) {
        String jeden = Wartosc.policz(ac, b, "*");
        String dwa = Wartosc.policz(jeden, bd, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczAzACBDB)+"</b></center><br>" +
                "$${a}/{AC}={b}/{BD}$$<br>" +
                "$$a={AC*b}/{BD}$$<br>" +
                "$$a={{" + Wartosc.formatuj(ac) + "}*{" + Wartosc.formatuj(b) + "}}/{" + Wartosc.formatuj(bd) + "}$$<br>" +
                "$$a={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(ac) + "}$$<br>" +
                "$$a={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzACzAEF(String a, String e, String f) {
        String jeden = Wartosc.policz(a, f, "*");
        String dwa = Wartosc.policz(jeden, e, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczACzAEF)+"</b></center><br>" +
                "$${a}/{e}={AC}/{f}$$<br>" +
                "$$AC={a*f}/{e}$$<br>" +
                "$$AC={{" + Wartosc.formatuj(a) + "}*{" + Wartosc.formatuj(f) + "}}/{" + Wartosc.formatuj(e) + "}$$<br>" +
                "$$AC={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(e) + "}$$<br>" +
                "$$AC={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzBDzBEF(String b, String e, String f) {
        String jeden = Wartosc.policz(b, f, "*");
        String dwa = Wartosc.policz(jeden, e, "/");
        String solucja1 = "<center><b>"+getString(R.string.talestalespoliczBDzBEF)+"</b></center><br>" +
                "$${b}/{e}={BD}/{f}$$<br>" +
                "$$BD={b*f}/{e}$$<br>" +
                "$$BD={{" + Wartosc.formatuj(b) + "}*{" + Wartosc.formatuj(f) + "}}/{" + Wartosc.formatuj(e) + "}$$<br>" +
                "$$BD={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(e) + "}$$<br>" +
                "$$BD={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzAzACEF(String ac, String e, String f) {
        String jeden = Wartosc.policz(ac, e, "*");
        String dwa = Wartosc.policz(jeden, f, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczAzACEF)+"</b></center><br>" +
                "$${a}/{e}={AC}/{f}$$<br>" +
                "$$a={AC*e}/{f}$$<br>" +
                "$$a={{" + Wartosc.formatuj(ac) + "}*{" + Wartosc.formatuj(e) + "}}/{" + Wartosc.formatuj(f) + "}$$<br>" +
                "$$a={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(f) + "}$$<br>" +
                "$$a={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzBzBDEF(String bd, String e, String f) {
        String jeden = Wartosc.policz(bd, e, "*");
        String dwa = Wartosc.policz(jeden, f, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczBzBDEF)+"</b></center><br>" +
                "$${b}/{e}={BD}/{f}$$<br>" +
                "$$b={BD*e}/{f}$$<br>" +
                "$$b={{" + Wartosc.formatuj(bd) + "}*{" + Wartosc.formatuj(e) + "}}/{" + Wartosc.formatuj(f) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(f) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzFzBD(String bd, String b, String e) {
        String jeden = Wartosc.policz(bd, e, "*");
        String dwa = Wartosc.policz(jeden, b, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczFzBD)+"</b></center><br>" +
                "$${b}/{e}={BD}/{f}$$<br>" +
                "$$f={BD*e}/{b}$$<br>" +
                "$$f={{" + Wartosc.formatuj(bd) + "}*{" + Wartosc.formatuj(e) + "}}/{" + Wartosc.formatuj(b) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(b) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzEzBD(String bd, String b, String f) {
        String jeden = Wartosc.policz(f, b, "*");
        String dwa = Wartosc.policz(jeden, bd, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczEzBD)+"</b></center><br>" +
                "$${b}/{e}={BD}/{f}$$<br>" +
                "$$e={f*b}/{BD}$$<br>" +
                "$$f={{" + Wartosc.formatuj(f) + "}*{" + Wartosc.formatuj(b) + "}}/{" + Wartosc.formatuj(bd) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(bd) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzFzAC(String ac, String a, String e) {
        String jeden = Wartosc.policz(ac, e, "*");
        String dwa = Wartosc.policz(jeden, a, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczFzAC)+"</b></center><br>" +
                "$${a}/{e}={AC}/{f}$$<br>" +
                "$$f={AC*e}/{a}$$<br>" +
                "$$f={{" + Wartosc.formatuj(ac) + "}*{" + Wartosc.formatuj(e) + "}}/{" + Wartosc.formatuj(a) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(a) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzEzAC(String ac, String a, String f) {
        String jeden = Wartosc.policz(a, f, "*");
        String dwa = Wartosc.policz(jeden, ac, "/");
        String solucja1 = "<center><b>"+getString(R.string.talespoliczEzAC)+"</b></center><br>" +
                "$${a}/{e}={AC}/{f}$$<br>" +
                "$$e={a*f}/{ac}$$<br>" +
                "$$e={{" + Wartosc.formatuj(a) + "}*{" + Wartosc.formatuj(f) + "}}/{" + Wartosc.formatuj(ac) + "}$$<br>" +
                "$$e={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(ac) + "}$$<br>" +
                "$$e={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
