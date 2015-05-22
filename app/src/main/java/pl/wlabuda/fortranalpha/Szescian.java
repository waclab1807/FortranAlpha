package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.view.View.OnFocusChangeListener;
import android.widget.Toast;

/**
 * Created by waclab1807 on 31.03.15.
 */

public class Szescian extends Activity implements OnFocusChangeListener {

    private Button licz;
    private Button clear;
    private Button sqrtbtn;
    private Button powbtn;
    private EditText pp_val;
    private EditText obj_val;
    private EditText pc_val;
    private EditText pb_val;
    private EditText a_val;
    private EditText d_val;
    private EditText D_val;
    private EditText obwp_val;
    private EditText obwb_val;
    private EditText triangle_val;
    private EditText lastFocused;
    public static String tekst = "";
    private Button btnReview;
    private Button btnData;
    private Button btnSolution;
    private WebView mWebView;
    private WebView mWebViewPp;
    private WebView mWebViewA;
    private WebView mWebViewObj;
    private WebView mWebViewObwp;
    private WebView mWebViewPb;
    private WebView mWebViewPc;
    private WebView mWebViewPtw;
    private WebView mWebViewObwb;
    private WebView mWebViewD;
    private WebView mWebViewd;
    private ImageView figura;
    private ScrollView scrollView;

    String a;
    String pp;
    String D;
    String d;
    String obj;
    String pb;
    String pc;
    String obwp;
    String obwb;
    String triangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.szescian);
        Global.mContext = this.getBaseContext();

        pp_val = (EditText) findViewById(R.id.pp);
        obj_val = (EditText) findViewById(R.id.obj);
        pb_val = (EditText) findViewById(R.id.pb);
        pc_val = (EditText) findViewById(R.id.pc);
        a_val = (EditText) findViewById(R.id.a);
        d_val = (EditText) findViewById(R.id.d);
        D_val = (EditText) findViewById(R.id.D);
        obwp_val = (EditText) findViewById(R.id.obwp);
        obwb_val = (EditText) findViewById(R.id.obwb);
        triangle_val = (EditText) findViewById(R.id.ptw);
        licz = (Button) findViewById(R.id.magic);
        clear = (Button) findViewById(R.id.clear);
        sqrtbtn = (Button) findViewById(R.id.sqrtbtn);
        powbtn = (Button) findViewById(R.id.powbtn);
        figura = (ImageView) findViewById(R.id.imageView);
        btnReview = (Button) findViewById(R.id.btnReview);
        btnData = (Button) findViewById(R.id.btnData);
        btnSolution = (Button) findViewById(R.id.btnSolution);
        scrollView = (ScrollView) findViewById(R.id.dwa);

        a_val.setOnFocusChangeListener(this);
        d_val.setOnFocusChangeListener(this);
        D_val.setOnFocusChangeListener(this);
        pp_val.setOnFocusChangeListener(this);
        pb_val.setOnFocusChangeListener(this);
        pc_val.setOnFocusChangeListener(this);
        obj_val.setOnFocusChangeListener(this);
        obwb_val.setOnFocusChangeListener(this);
        obwp_val.setOnFocusChangeListener(this);
        triangle_val.setOnFocusChangeListener(this);

        if (btnData.getVisibility() == View.VISIBLE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        mWebView = (WebView) findViewById(R.id.webSolution);
        WebSettings webSettings = mWebView.getSettings();
        mWebView.setBackgroundColor(0xff0);
        webSettings.setJavaScriptEnabled(true);

        mWebViewPp = (WebView) findViewById(R.id.webpp);
        WebSettings webSettings1 = mWebViewPp.getSettings();
        mWebViewPp.setBackgroundColor(0xff0);
        webSettings1.setJavaScriptEnabled(true);

        mWebViewA = (WebView) findViewById(R.id.webA);
        WebSettings webSettings2 = mWebViewA.getSettings();
        mWebViewA.setBackgroundColor(0xff0);
        webSettings2.setJavaScriptEnabled(true);

        mWebViewD = (WebView) findViewById(R.id.webD);
        WebSettings webSettings3 = mWebViewD.getSettings();
        mWebViewD.setBackgroundColor(0xff0);
        webSettings3.setJavaScriptEnabled(true);

        mWebViewObwp = (WebView) findViewById(R.id.webobwp);
        WebSettings webSettings4 = mWebViewObwp.getSettings();
        mWebViewObwp.setBackgroundColor(0xff0);
        webSettings4.setJavaScriptEnabled(true);

        mWebViewObj = (WebView) findViewById(R.id.webobj);
        WebSettings webSettings5 = mWebViewObj.getSettings();
        mWebViewObj.setBackgroundColor(0xff0);
        webSettings5.setJavaScriptEnabled(true);

        mWebViewPb = (WebView) findViewById(R.id.webpb);
        WebSettings webSettings6 = mWebViewPb.getSettings();
        mWebViewPb.setBackgroundColor(0xff0);
        webSettings6.setJavaScriptEnabled(true);

        mWebViewObwb = (WebView) findViewById(R.id.webobwb);
        WebSettings webSettings7 = mWebViewObwb.getSettings();
        mWebViewObwb.setBackgroundColor(0xff0);
        webSettings7.setJavaScriptEnabled(true);

        mWebViewPc = (WebView) findViewById(R.id.webpc);
        WebSettings webSettings8 = mWebViewPc.getSettings();
        mWebViewPc.setBackgroundColor(0xff0);
        webSettings8.setJavaScriptEnabled(true);

        mWebViewPtw = (WebView) findViewById(R.id.webptw);
        WebSettings webSettings9 = mWebViewPtw.getSettings();
        mWebViewPtw.setBackgroundColor(0xff0);
        webSettings9.setJavaScriptEnabled(true);

        mWebViewd = (WebView) findViewById(R.id.webd);
        WebSettings webSettings0 = mWebViewd.getSettings();
        mWebViewd.setBackgroundColor(0xff0);
        webSettings0.setJavaScriptEnabled(true);

        a_val.setOnFocusChangeListener(this);
        D_val.setOnFocusChangeListener(this);
        pp_val.setOnFocusChangeListener(this);
        obwp_val.setOnFocusChangeListener(this);
        d_val.setOnFocusChangeListener(this);
        triangle_val.setOnFocusChangeListener(this);
        obwb_val.setOnFocusChangeListener(this);
        pc_val.setOnFocusChangeListener(this);
        obj_val.setOnFocusChangeListener(this);
        pb_val.setOnFocusChangeListener(this);

        new TouchListener(figura, R.drawable.szescianpp, pp_val);
        new TouchListener(figura, R.drawable.szesciana, a_val);
        new TouchListener(figura, R.drawable.szesciand, d_val);
        new TouchListener(figura, R.drawable.szescianobwp, obwp_val);
        new TouchListener(figura, R.drawable.szescianpb, pb_val);
        new TouchListener(figura, R.drawable.szescianpc, pc_val);
        new TouchListener(figura, R.drawable.szesciandd, D_val);
        new TouchListener(figura, R.drawable.szescianobwb, obwb_val);
        new TouchListener(figura, R.drawable.szescianobj, obj_val);
        new TouchListener(figura, R.drawable.szescianptw, triangle_val);

        final InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        new TabListener(imm,btnReview, btnData, btnSolution, figura, scrollView, mWebView);
        figura.setImageResource(R.drawable.szescian);
        btnSolution.setEnabled(false);

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean ba = false;
                boolean bd = false;
                boolean bD = false;
                boolean bobj = false;
                boolean bpp = false;
                boolean bpb = false;
                boolean bpc = false;
                boolean bobwp = false;
                boolean bobwb = false;
                boolean btriangle = false;

                tekst = "";

                int x = 0; //koniec petli, wszystko policzone
                int y = 0; //za malo danych

                if (Wartosc.nawiasy(a_val.getText().toString()) &&
                        Wartosc.nawiasy(pp_val.getText().toString()) &&
                        Wartosc.nawiasy(D_val.getText().toString()) &&
                        Wartosc.nawiasy(obwp_val.getText().toString())&&
                        Wartosc.nawiasy(obwb_val.getText().toString())&&
                        Wartosc.nawiasy(pb_val.getText().toString())&&
                        Wartosc.nawiasy(pc_val.getText().toString())&&
                        Wartosc.nawiasy(d_val.getText().toString())&&
                        Wartosc.nawiasy(obj_val.getText().toString())&&
                        Wartosc.nawiasy(triangle_val.getText().toString())) {
                    try {
                        while (x == 0) {
                            //obliczanie a lub pp lub obwp
                            //czy jest a
                            if (!isEmpty(a_val)) {
                                System.out.println("^^^^^^^^1");
                                a = a_val.getText().toString();
                                ba = true;
                                if (isEmpty(pp_val) && !bpp) {
                                    String s = policzPp(a);
                                    pp_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewPp);
                                    bpp = true;
                                }
                                if (isEmpty(obwp_val) && !bobwp) {
                                    String s = policzObwp(a);
                                    obwp_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewObwp);
                                    bobwp = true;
                                }
                                if (isEmpty(obwb_val) && !bobwb) {
                                    String s = policzObwb(a);
                                    obwb_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewObwb);
                                    bobwb = true;
                                }
                                if (isEmpty(obj_val) && !bobj) {
                                    String s = policzObj(a);
                                    obj_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewObj);
                                    bobj = true;
                                }
                                if (isEmpty(pc_val) && !bpc) {
                                    String s = policzPc(a);
                                    pc_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewPc);
                                    bpc = true;
                                }
                                if (isEmpty(pb_val) && !bpb) {
                                    String s = policzPb(a);
                                    pb_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewPb);
                                    bpb = true;
                                }
                                if (isEmpty(triangle_val) && !btriangle) {
                                    String s = policzTriangle(a);
                                    triangle_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewPtw);
                                    btriangle = true;
                                }
                                if (isEmpty(d_val) && !bd) {
                                    String s = policzd(a);
                                    d_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewd);
                                    bd = true;
                                }
                                if (isEmpty(D_val) && !bD) {
                                    String s = policzD(a);
                                    D_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewD);
                                    bD = true;
                                }
                            } else {
                                if (!isEmpty(pp_val)) {
                                    System.out.println("^^^^^^^^2");
                                    pp = pp_val.getText().toString();
                                    JavaScript.showFormatted(pp, mWebViewPp);
                                    bpp = true;
                                    String s = policzAzPp(pp);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                                if (!isEmpty(obj_val)) {
                                    System.out.println("^^^^^^^^3");
                                    obj = obj_val.getText().toString();
                                    JavaScript.showFormatted(obj, mWebViewObj);
                                    bobj = true;
                                    String s = policzAzObj(obj);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                                if (!isEmpty(pc_val)) {
                                    System.out.println("^^^^^^^^4");
                                    pc = pc_val.getText().toString();
                                    JavaScript.showFormatted(pc, mWebViewPc);
                                    bpc = true;
                                    String s = policzAzPc(pc);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                                if (!isEmpty(pb_val)) {
                                    System.out.println("^^^^^^^^5");
                                    pb = pb_val.getText().toString();
                                    JavaScript.showFormatted(pb, mWebViewPb);
                                    bpb = true;
                                    String s = policzAzPb(pb);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                                if (!isEmpty(d_val)) {
                                    System.out.println("^^^^^^^^6");
                                    d = d_val.getText().toString();
                                    JavaScript.showFormatted(d, mWebViewd);
                                    bd = true;
                                    String s = policzAzd(d);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                                if (!isEmpty(D_val)) {
                                    System.out.println("^^^^^^^^7");
                                    D = D_val.getText().toString();
                                    JavaScript.showFormatted(D, mWebViewD);
                                    bD = true;
                                    String s = policzAzD(D);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                                if (!isEmpty(triangle_val)) {
                                    System.out.println("^^^^^^^^8");
                                    triangle = triangle_val.getText().toString();
                                    JavaScript.showFormatted(triangle, mWebViewPtw);
                                    btriangle = true;
                                    String s = policzAzTriangle(triangle);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                                if (!isEmpty(obwb_val)) {
                                    System.out.println("^^^^^^^^9");
                                    obwb = obwb_val.getText().toString();
                                    JavaScript.showFormatted(obwb, mWebViewObwb);
                                    bobwb = true;
                                    String s = policzAzObwb(obwb);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                                if (!isEmpty(obwp_val)) {
                                    System.out.println("^^^^^^^^0");
                                    obwp = obwp_val.getText().toString();
                                    JavaScript.showFormatted(obwp, mWebViewObwp);
                                    bobwp = true;
                                    String s = policzAzObwp(obwp);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                            }
                            //za malo danych
                            if(isEmpty(pp_val) && isEmpty(pb_val) && isEmpty(pc_val) && isEmpty(obwp_val) && isEmpty(obwb_val) && isEmpty(triangle_val) && isEmpty(a_val) && isEmpty(d_val) && isEmpty(D_val) && isEmpty(obj_val)){
                                Toast.makeText(Szescian.this, getString(R.string.notEnough),
                                        Toast.LENGTH_LONG).show();
                                x = 1;
                                y = 1;
                            }
                            //wszystko policzone, koniec petli
                            if (!a_val.getText().toString().equals("") &&
                                    !pp_val.getText().toString().equals("") &&
                                    !obwp_val.getText().toString().equals("") &&
                                    !obj_val.getText().toString().equals("") &&
                                    !pb_val.getText().toString().equals("") &&
                                    !pc_val.getText().toString().equals("") &&
                                    !triangle_val.getText().toString().equals("") &&
                                    !D_val.getText().toString().equals("") &&
                                    !d_val.getText().toString().equals("") &&
                                    !obwb_val.getText().toString().equals("")
                                    ) {
                                x = 1;
                                figura.setImageResource(R.drawable.szescian);
                                licz.setEnabled(false);
                                btnSolution.setEnabled(true);
                                imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);
                                Toast.makeText(Szescian.this, getString(R.string.premium),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                        new ProgressBar(view);
                    } catch (Exception e) {
                        System.out.println("emessage " + e.getMessage());
                        Toast.makeText(Szescian.this, getString(R.string.ups),
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Szescian.this, getString(R.string.bracket),
                            Toast.LENGTH_LONG).show();
                }
                JavaScript JS = new JavaScript(tekst);
                mWebView.loadDataWithBaseURL("", "" + JS.getTekst(), "text/html", "UTF-8", "");

                if(y == 0) {
                    new WebViewHide(false, mWebView, mWebViewA, mWebViewObwp, mWebViewD, mWebViewPp, mWebViewPc, mWebViewObwb, mWebViewd, mWebViewPb, mWebViewObj, mWebViewPtw);
                    new EditTextHide(true, pp_val, a_val, D_val, obwp_val, pc_val, d_val, obj_val, obwb_val, triangle_val, pb_val);
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
                Global.setEmpty(pp_val, a_val, D_val, obwp_val, pc_val, d_val, obj_val, obwb_val, triangle_val, pb_val);
                tekst = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");
                new EditTextHide(false,pp_val, a_val, D_val, obwp_val, pc_val, d_val, obj_val, obwb_val, triangle_val, pb_val);
                new WebViewHide(true, mWebViewA, mWebViewObwp, mWebViewD, mWebViewPp, mWebViewPc, mWebViewObwb, mWebViewd, mWebViewPb, mWebViewObj, mWebViewPtw);
                licz.setEnabled(true);
                btnSolution.setEnabled(false);
                figura.setImageResource(R.drawable.szescian);
                Toast.makeText(Szescian.this, getString(R.string.deleted),
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

    private String policzPp(String a) {
        String jeden = Wartosc.policz(a, a, "*");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczPp)+"</b></center><br>" +
                "$$Pp={a^2}$$<br>" +
                "$$Pp={{" + Wartosc.formatuj(a) + "}^2$$<br>" +
                "$$Pp={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzAzObj(String Obj) {
        double a = 1.0;
        double b = 3.0;
        double y = a/b;
        String jeden = ""+(int)Math.pow(Double.parseDouble(Obj),y);
        String solucja = "<center><b>"+getString(R.string.szescianpoliczAzObj)+"</b></center><br>" +
                "$$Obj={Pp * a}$$<br>" +
                "$$Pp={a * a}$$<br>" +
                "$$Obj={a^3}$$<br>" +
                "$$a={\u221b{Obj}}$$<br>" +
                "$$a={\u221b{"+Wartosc.formatuj(Obj)+"}}$$<br>" +
                "$$a={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzAzPc(String Pc) {
        String jeden = Wartosc.policz("6", Pc, "*");
        String dwa = Wartosc.policz("()\u221a(" + jeden + ")", "1", "*");
        String trzy = Wartosc.policz(dwa, "6", "/");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczAzPc)+"</b></center><br>" +
                "$$a={√{Pc / 6}}$$<br>" +
                "$$a={√Pc / √6}$$<br>" +
                "$$a={{√Pc * √6}}/{6}$$<br>" +
                "$$a={√{Pc*6}}/{6}$$<br>" +
                "$$a={√{" + Wartosc.formatuj(Pc) + "*6}}/{6}$$<br>" +
                "$$a={√" + Wartosc.formatuj(jeden) + "}/{6}$$<br>" +
                "$$a={" + Wartosc.formatuj(dwa) + "}/{6}$$<br>" +
                "$$a={" + Wartosc.formatuj(trzy) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return trzy;
    }

    private String policzAzPb(String Pb) {
        String jeden = Wartosc.policz("()\u221a(" + Pb + ")", "1", "*");
        String dwa = Wartosc.policz(jeden, "2", "/");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczAzPb)+"</b></center><br>" +
                "$$a={√{Pc / 4}}$$<br>" +
                "$$a={√Pc / 2}$$<br>" +
                "$$a={√" + Wartosc.formatuj(Pb) + "}/{2}$$<br>" +
                "$$a={" + Wartosc.formatuj(jeden) + "}/{2}$$<br>" +
                "$$a={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzAzd(String d) {
        String jeden = Wartosc.policz("()\u221a(3)", d, "*");
        String dwa = Wartosc.policz(jeden, "3", "/");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczAzd)+"</b></center><br>" +
                "$$d={a * √3}$$<br>" +
                "$$a={d / √3}$$<br>" +
                "$$a={{d * √3}}/{3}$$<br>" +
                "$$a={" + Wartosc.formatuj(d) + "*√3}/{3}$$<br>" +
                "$$a={" + Wartosc.formatuj(jeden) + "}/{3}$$<br>" +
                "$$a={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzAzD(String D) {
        String jeden = Wartosc.policz("()\u221a(2)", D, "*");
        String dwa = Wartosc.policz(jeden, "2", "/");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczAzD)+"</b></center><br>" +
                "$$D={a * √2}$$<br>" +
                "$$a={D / √2}$$<br>" +
                "$$a={{D * √2}}/{2}$$<br>" +
                "$$a={" + Wartosc.formatuj(D) + "*√3}/{3}$$<br>" +
                "$$a={" + Wartosc.formatuj(jeden) + "}/{3}$$<br>" +
                "$$a={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzAzTriangle(String Triangle) {
        String jeden = Wartosc.policz("2", Triangle, "*");
        String dwa = Wartosc.policz(jeden, "()\u221a(2)", "/");
        String trzy = Wartosc.policz("()\u221a(" + dwa + ")", "1", "*");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczAzTriangle)+"</b></center><br>" +
                "$$Ptw={{1/2} * D * a}$$<br>" +
                "$$D={a * √2}$$<br>" +
                "$$Ptw={{1/2} * a * √2 * a}$$<br>" +
                "$$Ptw={{{a^2} * √2}/2}$$<br>" +
                "$${2*Ptw}={{a^2} * √2}$$<br>" +
                "$${{2*Ptw}/√2}={a^2}$$<br>" +
                "$$a=√{{2*Ptw}/√2}$$<br>" +
                "$$a=√{{2*"+Wartosc.formatuj(Triangle)+"}/√2}$$<br>" +
                "$$a=√{{"+Wartosc.formatuj(jeden)+"}/√2}$$<br>" +
                "$$a=√{"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "$$a={" + Wartosc.formatuj(trzy) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return trzy;
    }

    private String policzD(String a) {
        String jeden = Wartosc.policz(a, "()\u221a(2)", "*");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczD)+"</b></center><br>" +
                "$$D={a*√2}$$<br>" +
                "$$D={{" + Wartosc.formatuj(a) + "}*√2$$<br>" +
                "$$D={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzd(String a) {
        String jeden = Wartosc.policz(a, "()\u221a(3)", "*");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczd)+"</b></center><br>" +
                "$$d={a*√3}$$<br>" +
                "$$d={{" + Wartosc.formatuj(a) + "}*√3$$<br>" +
                "$$d={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzPb(String a) {
        String jeden = Wartosc.policz(a, a, "*");
        String dwa = Wartosc.policz("4", jeden, "*");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczPb)+"</b></center><br>" +
                "$$Pb={4*{a^2}}$$<br>" +
                "$$Pb={4*{{" + Wartosc.formatuj(a) + "}^2}}$$<br>" +
                "$$Pb={4*{" + Wartosc.formatuj(jeden) + "}}$$<br>" +
                "$$Pb={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzPc(String a) {
        String jeden = Wartosc.policz(a, a, "*");
        String dwa = Wartosc.policz(jeden, "6", "*");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczPc)+"</b></center><br>" +
                "$$Pc={6*{a^2}}$$<br>" +
                "$$Pc={6*{{" + Wartosc.formatuj(a) + "}^2}}$$<br>" +
                "$$Pc={6*{" + Wartosc.formatuj(jeden) + "}}$$<br>" +
                "$$Pc={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzObwb(String a) {
        String jeden = Wartosc.policz("12", a, "*");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczObwb)+"</b></center><br>" +
                "$$ObwB={12*a}$$<br>" +
                "$$ObwB={12*{" + Wartosc.formatuj(a) + "}}$$<br>" +
                "$$ObwB={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzTriangle(String a) {
        String jeden = Wartosc.policz(a, a, "*");
        String dwa = Wartosc.policz(jeden, "()\u221a(2)", "*");
        String trzy = Wartosc.policz(dwa, "2", "/");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczTriangle)+"</b></center><br>" +
                "$$Ptw={1/2}*D*a$$<br>" +
                "$$D={a*√2}$$<br>" +
                "$$Ptw={1/2}*a*√2*a$$<br>" +
                "$$Ptw={{a^2}*√2}/2$$<br>" +
                "$$a={{{" + Wartosc.formatuj(a) + "}^2}*√2}/2$$<br>" +
                "$$a={{" + Wartosc.formatuj(jeden) + "}*√2}/2$$<br>" +
                "$$a={" + Wartosc.formatuj(dwa) + "}/2$$<br>" +
                "$$a={" + Wartosc.formatuj(trzy) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return trzy;
    }

    private String policzObj(String a) {
        String jeden = Wartosc.policz(a, a, "*");
        String dwa = Wartosc.policz(jeden, a, "*");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczObj)+"</b></center><br>" +
                "$$Obj={a^3}$$<br>" +
                "$$Obj={" + Wartosc.formatuj(a) + "}^3$$<br>" +
                "$$Obj={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzObwp(String a) {
        String jeden = Wartosc.policz("4", a, "*");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczObwp)+"</b></center><br>" +
                "$$ObwP={4*a}$$<br>" +
                "$$ObwP={4*{" + Wartosc.formatuj(a) + "}}$$<br>" +
                "$$ObwP={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzAzPp(String Pp) {
        String jeden = Wartosc.policz("()\u221a(" + Pp + ")", "1", "*");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczAzPp)+"</b></center><br>" +
                "$$Pp={a^2}$$<br>" +
                "$$a={√Pp}$$<br>" +
                "$$a={√{" + Wartosc.formatuj(Pp) + "}}$$<br>" +
                "$$a={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzAzObwb(String Obwb) {
        String jeden = Wartosc.policz(Obwb, "12", "/");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczAzObwb)+"</b></center><br>" +
                "$$ObwB={12*a}$$<br>" +
                "$$a={ObwB/12}$$<br>" +
                "$$a={{" + Wartosc.formatuj(Obwb) + "}/12}$$<br>" +
                "$$a={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzAzObwp(String Obwp) {
        String jeden = Wartosc.policz(Obwp, "4", "/");
        String solucja = "<center><b>"+getString(R.string.szescianpoliczAzObwp)+"</b></center><br>" +
                "$$ObwP={4*a}$$<br>" +
                "$$a={ObwB/4}$$<br>" +
                "$$a={{" + Wartosc.formatuj(Obwp) + "}/4}$$<br>" +
                "$$a={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
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
