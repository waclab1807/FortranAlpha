package pl.wlabuda.fortranalpha;

import pl.wlabuda.fortranalpha.R.*;

import android.app.Activity;
import android.app.ProgressDialog;
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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.view.View.OnFocusChangeListener;
import android.widget.Toast;
import android.os.Handler;

public class GraniastoslupPrawidlowyTrojkatny extends Activity implements OnFocusChangeListener {

    private Button licz;
    private Button clear;
    private Button solutionbtn;
    private Button sqrtbtn;
    private Button powbtn;
    private EditText pp_val;
    private EditText obj_val;
    private EditText pc_val;
    private EditText pb_val;
    private EditText a_val;
    private EditText h_val;
    private EditText H_val;
    private EditText d_val;
    private EditText D_val;
    private EditText obwp_val;
    private EditText obwb_val;
    private EditText triangle_val;
    private ImageView figura;
    private EditText lastFocused;
    private String tekst = "";
    private WebView mWebView;
    private WebView mWebViewA;
    private WebView mWebViewH;
    private WebView mWebViewD;
    private WebView mWebViewh;
    private WebView mWebViewd;
    private WebView mWebViewPp;
    private WebView mWebViewPb;
    private WebView mWebViewPc;
    private WebView mWebViewObj;
    private WebView mWebViewObwp;
    private WebView mWebViewObwb;
    private WebView mWebViewPtw;
    private ScrollView scrollView;
    private Button btnReview;
    private Button btnData;
    private Button btnSolution;
    private LinearLayout buttons;

    String a;
    String pp;
    String H;
    String h;
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
        setContentView(layout.graniastoslup_prawidlowy_trojkatny);

        Global.mContext = this.getBaseContext();

        mWebView = (WebView) findViewById(id.webSolution);
        mWebView.setBackgroundColor(0xff0);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        pp_val = (EditText) findViewById(R.id.pp);
        obj_val = (EditText) findViewById(R.id.obj);
        pb_val = (EditText) findViewById(R.id.pb);
        pc_val = (EditText) findViewById(R.id.pc);
        a_val = (EditText) findViewById(id.a);
        h_val = (EditText) findViewById(id.h);
        H_val = (EditText) findViewById(R.id.H);
        d_val = (EditText) findViewById(R.id.d);
        D_val = (EditText) findViewById(R.id.D);
        obwp_val = (EditText) findViewById(R.id.obwp);
        obwb_val = (EditText) findViewById(R.id.obwb);
        triangle_val = (EditText) findViewById(id.ptw);
        licz = (Button) findViewById(id.magic);
        clear = (Button) findViewById(id.clear);
        sqrtbtn = (Button) findViewById(id.sqrtbtn);
        powbtn = (Button) findViewById(id.powbtn);
        solutionbtn = (Button) findViewById(id.solutionbtn);
        figura = (ImageView) findViewById(id.imageView);
        btnReview = (Button)findViewById(R.id.btnReview);
        btnData = (Button)findViewById(R.id.btnData);
        btnSolution = (Button)findViewById(R.id.btnSolution);
        scrollView = (ScrollView)findViewById(R.id.dwa);
        buttons = (LinearLayout) findViewById(id.buttons);

        if (btnData.getVisibility() == View.VISIBLE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        mWebViewA = (WebView) findViewById(R.id.weba);
        WebSettings webSettingsA = mWebViewA.getSettings();
        mWebViewA.setBackgroundColor(0xff0);
        webSettingsA.setJavaScriptEnabled(true);

        mWebViewPp = (WebView) findViewById(R.id.webpp);
        WebSettings webSettingsPp = mWebViewPp.getSettings();
        mWebViewPp.setBackgroundColor(0xff0);
        webSettingsPp.setJavaScriptEnabled(true);

        mWebViewPtw = (WebView) findViewById(R.id.webptw);
        WebSettings webSettingsPtw = mWebViewPtw.getSettings();
        mWebViewPtw.setBackgroundColor(0xff0);
        webSettingsPtw.setJavaScriptEnabled(true);

        mWebViewH = (WebView) findViewById(R.id.webH);
        WebSettings webSettingsH = mWebViewH.getSettings();
        mWebViewH.setBackgroundColor(0xff0);
        webSettingsH.setJavaScriptEnabled(true);

        mWebViewD = (WebView) findViewById(R.id.webD);
        WebSettings webSettings3 = mWebViewD.getSettings();
        mWebViewD.setBackgroundColor(0xff0);
        webSettings3.setJavaScriptEnabled(true);

        mWebViewObwp = (WebView) findViewById(R.id.webobwp);
        WebSettings webSettings4 = mWebViewObwp.getSettings();
        mWebViewObwp.setBackgroundColor(0xff0);
        webSettings4.setJavaScriptEnabled(true);

        mWebViewObwb = (WebView) findViewById(R.id.webobwb);
        WebSettings webSettings6 = mWebViewObwb.getSettings();
        mWebViewObwb.setBackgroundColor(0xff0);
        webSettings6.setJavaScriptEnabled(true);

        mWebViewPb = (WebView) findViewById(R.id.webpb);
        WebSettings webSettingsPb = mWebViewPb.getSettings();
        mWebViewPb.setBackgroundColor(0xff0);
        webSettingsPb.setJavaScriptEnabled(true);

        mWebViewPc = (WebView) findViewById(R.id.webpc);
        WebSettings webSettingsPc = mWebViewPc.getSettings();
        mWebViewPc.setBackgroundColor(0xff0);
        webSettingsPc.setJavaScriptEnabled(true);

        mWebViewh = (WebView) findViewById(R.id.webh);
        WebSettings webSettingsh = mWebViewh.getSettings();
        mWebViewh.setBackgroundColor(0xff0);
        webSettingsh.setJavaScriptEnabled(true);

        mWebViewd = (WebView) findViewById(R.id.webd);
        WebSettings webSettingsd = mWebViewd.getSettings();
        mWebViewd.setBackgroundColor(0xff0);
        webSettingsd.setJavaScriptEnabled(true);

        mWebViewObj = (WebView) findViewById(R.id.webobj);
        WebSettings webSettings7 = mWebViewObj.getSettings();
        mWebViewObj.setBackgroundColor(0xff0);
        webSettings7.setJavaScriptEnabled(true);

        a_val.setOnFocusChangeListener(this);
        h_val.setOnFocusChangeListener(this);
        H_val.setOnFocusChangeListener(this);
        d_val.setOnFocusChangeListener(this);
        D_val.setOnFocusChangeListener(this);
        pp_val.setOnFocusChangeListener(this);
        pb_val.setOnFocusChangeListener(this);
        pc_val.setOnFocusChangeListener(this);
        obj_val.setOnFocusChangeListener(this);
        obwb_val.setOnFocusChangeListener(this);
        obwp_val.setOnFocusChangeListener(this);
        triangle_val.setOnFocusChangeListener(this);

        Global.TouchListener(figura, drawable.gran_pros_trojkatnypp, pp_val);
        Global.TouchListener(figura, drawable.gran_pros_trojkatnypb,pb_val);
        Global.TouchListener(figura, drawable.gran_pros_trojkatnypc,pc_val);
        Global.TouchListener(figura, drawable.gran_pros_trojkatnya,a_val);
        Global.TouchListener(figura, drawable.gran_pros_trojkatnydd,D_val);
        Global.TouchListener(figura, drawable.gran_pros_trojkatnyd,d_val);
        Global.TouchListener(figura, drawable.gran_pros_trojkatnyh,h_val);
        Global.TouchListener(figura, drawable.gran_pros_trojkatnyhh,H_val);
        Global.TouchListener(figura, drawable.gran_pros_trojkatnyobwp,obwp_val);
        Global.TouchListener(figura, drawable.gran_pros_trojkatnyobwb,obwb_val);
        Global.TouchListener(figura, drawable.gran_pros_trojkatnyobj,obj_val);
        Global.TouchListener(figura, drawable.gran_pros_trojkatnyptw,triangle_val);

        final InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        new TabListener(buttons,imm,btnReview,btnData,btnSolution,figura,scrollView,mWebView);

        figura.setImageResource(drawable.gran_pros_trojkatny);

        btnSolution.setEnabled(false);

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean bH = false;
                boolean ba = false;
                boolean bh = false;
                boolean bD = false;
                boolean bd = false;
                boolean bobj = false;
                boolean bpp = false;
                boolean bpb = false;
                boolean bpc = false;
                boolean bobwp = false;
                boolean bobwb = false;
                boolean btriangle = false;

                int x = 0; //koniec petli, wszystko policzone

                if(Wartosc.nawiasy(a_val.getText().toString()) &&
                        Wartosc.nawiasy(pp_val.getText().toString()) &&
                        Wartosc.nawiasy(D_val.getText().toString()) &&
                        Wartosc.nawiasy(obwp_val.getText().toString())&&
                        Wartosc.nawiasy(obwb_val.getText().toString())&&
                        Wartosc.nawiasy(obj_val.getText().toString())&&
                        Wartosc.nawiasy(d_val.getText().toString())&&
                        Wartosc.nawiasy(H_val.getText().toString())&&
                        Wartosc.nawiasy(h_val.getText().toString())&&
                        Wartosc.nawiasy(triangle_val.getText().toString())&&
                        Wartosc.nawiasy(pb_val.getText().toString())&&
                        Wartosc.nawiasy(pc_val.getText().toString())) {
                try{
                    while (x == 0) {
                        //obliczanie a lub h lub pp lub obwp
                        //czy jest a
                        if (!isEmpty(a_val)) {
                            System.out.println("^^^^^^^^1");
                            a = a_val.getText().toString();
                            JavaScript.showFormatted(a, mWebViewA);
                            ba = true;
                            if (isEmpty(pp_val) && !bpp) {
                                System.out.println("^^^^^^^^1.1");
                                String s = policzPp(a);
                                pp_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewPp);
                                bpp = true;
                            }
                            if (isEmpty(h_val) && !bh) {
                                System.out.println("^^^^^^^^1.2");
                                String s = policzhza(a);
                                h_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewh);
                                bh = true;
                            }
                            if (isEmpty(obwp_val) && !bobwp) {
                                System.out.println("^^^^^^^^1.3");
                                String s = policzObwp(a);
                                obwp_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewObwp);
                                bobwp = true;
                            }
                        }
                        //czy jest h
                        if (!isEmpty(h_val)) {
                            System.out.println("^^^^^^^^2");
                            h = h_val.getText().toString();
                            JavaScript.showFormatted(h, mWebViewh);
                            bh = true;
                            if (isEmpty(a_val) && !ba) {
                                System.out.println("^^^^^^^^2.1");
                                String s = policzAzh(h);
                                a_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewA);
                                ba = true;
                            }
                            if (isEmpty(pp_val) && !bpp) {
                                String s = policzPp(policzAzh(h));
                                pp_val.setText(s);
                                System.out.println("^^^^^^^^2.2");
                                JavaScript.showFormatted(s, mWebViewPp);
                                bpp = true;
                            }
                            if (isEmpty(obwp_val) && !bobwp) {
                                String s = policzObwp(policzAzh(h));
                                obwp_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewObwp);
                                System.out.println("^^^^^^^^2.3");
                                bobwp = true;
                            }
                        }
                        //czy jest pp
                        if (!isEmpty(pp_val)) {
                            System.out.println("^^^^^^^^3");
                            pp = pp_val.getText().toString();
                            JavaScript.showFormatted(pp, mWebViewPp);
                            bpp = true;
                            if (isEmpty(a_val) && !ba) {
                                String s = policzAzPp(pp);
                                System.out.println("^^^^^^^^3.1");
                                a_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewA);
                                ba = true;
                            }
                            if (h_val.getText().toString().equals("") && !bh) {
                                String s = policzhzPp(pp);
                                System.out.println("^^^^^^^^3.2");
                                h_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewh);
                                bh = true;
                            }
                            if (obwp_val.getText().toString().equals("") && !bobwp) {
                                String s = policzObwp(policzAzPp(pp));
                                System.out.println("^^^^^^^^3.3");
                                obwp_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewObwp);
                                bobwp = true;
                            }
                        }
                        //czy jest obwp
                        if (!isEmpty(obwp_val)) {
                            System.out.println("^^^^^^^^4");
                            obwp = obwp_val.getText().toString();
                            JavaScript.showFormatted(obwp, mWebViewObwp);
                            bobwp = true;
                            if (isEmpty(a_val) && !ba) {
                                System.out.println("^^^^^^^^4.1");
                                String s = policzAzObwp(obwp);
                                a_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewA);
                                ba = true;
                            }
                            if (isEmpty(pp_val) && !bpp) {
                                System.out.println("^^^^^^^^4.2");
                                String s = policzAzObwp(obwp);
                                pp_val.setText(policzPp(s));
                                JavaScript.showFormatted(s, mWebViewPp);
                                bpp = true;
                            }
                            if (isEmpty(h_val) && !bh) {
                                System.out.println("^^^^^^^^4.3");
                                String s = policzhza(policzAzObwp(obwp));
                                h_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewh);
                                bh = true;
                            }
                        }
                        //czy jest obj i H
                        if (!isEmpty(H_val)) {
                            System.out.println("^^^^^^^^5");
                            H = H_val.getText().toString();
                            JavaScript.showFormatted(H, mWebViewH);
                            bH = true;
                            if (!isEmpty(obj_val) && !bpp) {
                                System.out.println("^^^^^^^^5.1");
                                obj = obj_val.getText().toString();
                                JavaScript.showFormatted(obj, mWebViewObj);
                                bobj = true;
                                String s = policzPpZObjiH(obj, H);
                                pp_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewPp);
                                bpp = true;
                            } else if (!isEmpty(d_val) && !ba) {
                                System.out.println("^^^^^^^^5.2");
                                d = d_val.getText().toString();
                                JavaScript.showFormatted(d, mWebViewd);
                                bd = true;
                                String s = policzAzHid(H, d);
                                a_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewA);
                                ba = true;
                            } else if (!isEmpty(D_val) && !bh) {
                                System.out.println("^^^^^^^^5.3");
                                D = D_val.getText().toString();
                                JavaScript.showFormatted(D, mWebViewD);
                                bD = true;
                                String s = policzhzHiD(H, D);
                                h_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewh);
                                bh = true;
                            } else if (!isEmpty(obwb_val) && !ba) {
                                System.out.println("^^^^^^^^5.4");
                                obwb = obwb_val.getText().toString();
                                JavaScript.showFormatted(obwb, mWebViewObwb);
                                bobwb = true;
                                String s = policzAzHiObwb(H, obwb);
                                a_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewA);
                                ba = true;
                            } else if (!isEmpty(pb_val) && !ba) {
                                System.out.println("^^^^^^^^5.5");
                                pb = pb_val.getText().toString();
                                JavaScript.showFormatted(pb, mWebViewPb);
                                bpb = true;
                                String s = policzAzHiPb(H, pb);
                                a_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewA);
                                ba = true;
                            }
                        }
                        //obliczanie H
                        if (!isEmpty(a_val)) {
                            System.out.println("^^^^^^^^6");
                            a = a_val.getText().toString();
                            JavaScript.showFormatted(a, mWebViewA);
                            ba = true;
                            if (!isEmpty(obj_val) && !bH) {
                                System.out.println("^^^^^^^^6.1");
                                obj = obj_val.getText().toString();
                                JavaScript.showFormatted(obj, mWebViewObj);
                                bobj = true;
                                String s = policzHzObjiA(obj, a);
                                H_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewH);
                                bH = true;
                            } else if (!isEmpty(d_val) && !bH) {
                                System.out.println("^^^^^^^^6.2");
                                d = d_val.getText().toString();
                                JavaScript.showFormatted(d, mWebViewd);
                                bd = true;
                                String s = policzHzdiA(d, a);
                                H_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewH);
                                bH = true;
                            } else if (!isEmpty(D_val) && !bH) {
                                System.out.println("^^^^^^^^6.3");
                                D = D_val.getText().toString();
                                JavaScript.showFormatted(D, mWebViewD);
                                bD = true;
                                String s = policzHzDiA(D, a);
                                H_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewH);
                                bH = true;
                            } else if (!isEmpty(pc_val) && !bH) {
                                System.out.println("^^^^^^^^6.4");
                                pc = pc_val.getText().toString();
                                JavaScript.showFormatted(pc, mWebViewPc);
                                bpc = true;
                                String s = policzHzPciA(pc, a);
                                H_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewH);
                                bH = true;
                            } else if (!isEmpty(pb_val) && !bH) {
                                System.out.println("^^^^^^^^6.4.1");
                                pb = pb_val.getText().toString();
                                JavaScript.showFormatted(pb, mWebViewPb);
                                bpb = true;
                                String s = policzHzPbiA(pb, a);
                                H_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewH);
                                bH = true;
                            }else if (!isEmpty(obwb_val) && !bH) {
                                System.out.println("^^^^^^^^6.5");
                                obwb = obwb_val.getText().toString();
                                JavaScript.showFormatted(obwb, mWebViewObwb);
                                bobwb = true;
                                String s = policzHzObwbiA(obwb, a);
                                H_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewH);
                                bH = true;
                            } else if (!isEmpty(triangle_val) && !bH) {
                                System.out.println("^^^^^^^^6.6");
                                triangle = triangle_val.getText().toString();
                                JavaScript.showFormatted(triangle, mWebViewPtw);
                                btriangle = true;
                                String s = policzHzTriangleiA(triangle, a);
                                H_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewH);
                                bH = true;
                            } else if (isEmpty(obj_val) && isEmpty(d_val) && isEmpty(D_val) && isEmpty(pc_val) && isEmpty(obwb_val) && isEmpty(triangle_val)) {
                                System.out.println("^^^^^^^^6.7");
                                figura.setImageResource(drawable.gran_pros_trojkatny);
                                licz.setEnabled(false);
                                btnSolution.setEnabled(true);
                                imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);
                                x = 1;
                            }
                        }
                        //czy jest pc i pb
                        if (!isEmpty(pc_val)) {
                            System.out.println("^^^^^^^^7");
                            pc = pc_val.getText().toString();
                            JavaScript.showFormatted(pc, mWebViewPc);
                            bpc = true;
                            if (!isEmpty(pb_val) && !bpp) {
                                pb = pb_val.getText().toString();
                                JavaScript.showFormatted(pb, mWebViewPb);
                                bpb = true;
                                String s = policzPpzPciPb(pc, pb);
                                pp_val.setText(s);
                                JavaScript.showFormatted(s, mWebViewPp);
                                bpp = true;
                            }
                        }
                        //obliczanie pozostałych na podstawie a i H
                        //D
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bD) {
                            System.out.println("^^^^^^^^8");
                            a = a_val.getText().toString();
                            JavaScript.showFormatted(a, mWebViewA);
                            H = H_val.getText().toString();
                            JavaScript.showFormatted(H, mWebViewH);
                            String s = policzDzHiA(H, a);
                            D_val.setText(s);
                            JavaScript.showFormatted(s, mWebViewD);
                            bD = true;
                        }
                        //d
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bd) {
                            System.out.println("^^^^^^^^9");
                            a = a_val.getText().toString();
                            JavaScript.showFormatted(a, mWebViewA);
                            H = H_val.getText().toString();
                            JavaScript.showFormatted(H, mWebViewH);
                            String s = policzdzHiA(H, a);
                            d_val.setText(s);
                            JavaScript.showFormatted(s, mWebViewd);
                            bd = true;
                        }
                        //pb
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bpb) {
                            System.out.println("^^^^^^^^10");
                            a = a_val.getText().toString();
                            JavaScript.showFormatted(a, mWebViewA);
                            H = H_val.getText().toString();
                            JavaScript.showFormatted(H, mWebViewH);
                            String s = policzPbzAiH(a, H);
                            pb_val.setText(s);
                            JavaScript.showFormatted(s, mWebViewPb);
                            bpb = true;
                        }
                        //pc
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bpc) {
                            System.out.println("^^^^^^^^11");
                            a = a_val.getText().toString();
                            JavaScript.showFormatted(a, mWebViewA);
                            H = H_val.getText().toString();
                            JavaScript.showFormatted(H, mWebViewH);
                            String s = policzPczAiH(a, H);
                            pc_val.setText(s);
                            JavaScript.showFormatted(s, mWebViewPc);
                            bpc = true;
                        }
                        //obwb
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bobwb) {
                            System.out.println("^^^^^^^^12");
                            a = a_val.getText().toString();
                            JavaScript.showFormatted(a, mWebViewA);
                            H = H_val.getText().toString();
                            JavaScript.showFormatted(H, mWebViewH);
                            String s = policzObwbZAiH(a, H);
                            obwb_val.setText(s);
                            JavaScript.showFormatted(s, mWebViewObwb);
                            bobwb = true;
                        }
                        //triangle
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !btriangle) {
                            System.out.println("^^^^^^^^13");
                            a = a_val.getText().toString();
                            JavaScript.showFormatted(a, mWebViewA);
                            H = H_val.getText().toString();
                            JavaScript.showFormatted(H, mWebViewH);
                            String s = policzTriangleZaiH(a, H);
                            triangle_val.setText(s);
                            JavaScript.showFormatted(s, mWebViewPtw);
                            btriangle = true;
                        }
                        //obj
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bobj) {
                            System.out.println("^^^^^^^^14");
                            a = a_val.getText().toString();
                            JavaScript.showFormatted(a, mWebViewA);
                            H = H_val.getText().toString();
                            JavaScript.showFormatted(H, mWebViewH);
                            String s = policzObjZaiH(a, H);
                            obj_val.setText(s);
                            JavaScript.showFormatted(s, mWebViewObj);
                            bobj = true;
                        }
                        //za malo danych
                        if (isEmpty(a_val) && isEmpty(h_val) && isEmpty(pp_val) && isEmpty(obwp_val)) {
                            x = 1;
                            figura.setImageResource(drawable.gran_pros_trojkatny);
                            licz.setEnabled(false);
                            btnSolution.setEnabled(true);
                            imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);
                            Toast.makeText(GraniastoslupPrawidlowyTrojkatny.this, getString(R.string.notEnough),
                                    Toast.LENGTH_LONG).show();
                        }
                        //wszystko policzone, koniec petli
                        if (!a_val.getText().toString().equals("") &&
                                !h_val.getText().toString().equals("") &&
                                !pp_val.getText().toString().equals("") &&
                                !obwp_val.getText().toString().equals("") &&
                                !H_val.getText().toString().equals("") &&
                                !obj_val.getText().toString().equals("") &&
                                !pb_val.getText().toString().equals("") &&
                                !pc_val.getText().toString().equals("") &&
                                !triangle_val.getText().toString().equals("") &&
                                !d_val.getText().toString().equals("") &&
                                !D_val.getText().toString().equals("") &&
                                !obwb_val.getText().toString().equals("")
                                ) {
                            x = 1;
                            figura.setImageResource(drawable.gran_pros_trojkatny);
                            licz.setEnabled(false);
                            btnSolution.setEnabled(true);
                            imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);

                            Toast.makeText(GraniastoslupPrawidlowyTrojkatny.this, getString(R.string.premium),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                    new ProgressBar(view);
                }catch (Exception e){
                    System.out.println("eMessage "+e.getMessage());
                    Toast.makeText(GraniastoslupPrawidlowyTrojkatny.this, getString(R.string.ups),
                            Toast.LENGTH_LONG).show();
                }
                }else{
                    Toast.makeText(GraniastoslupPrawidlowyTrojkatny.this, getString(R.string.bracket),
                            Toast.LENGTH_LONG).show();
                }
                JavaScript JS = new JavaScript(tekst);
                mWebView.loadDataWithBaseURL("", "" + JS.getTekst(), "text/html", "UTF-8", "");
                Global.WebViewHide(false, mWebView, mWebViewA, mWebViewD, mWebViewObwp, mWebViewPp, mWebViewObwb, mWebViewObj, mWebViewd, mWebViewH, mWebViewh, mWebViewPtw, mWebViewPb, mWebViewPc);
                Global.EditTextHide(true, a_val, D_val, pp_val, obwp_val, obj_val, obwb_val, d_val, h_val, H_val, triangle_val, pb_val, pc_val);
                TabListener refresh = new TabListener();
                if (btnData.getVisibility() == View.VISIBLE) {
                    refresh.refresh(figura, scrollView, mWebView);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.setEmpty(a_val, D_val, pp_val, obwp_val, obj_val, obwb_val, d_val, h_val, H_val, triangle_val, pb_val, pc_val);
                Global.setEmptyWeb(mWebViewA,mWebViewD,mWebViewObwp,mWebViewPp,mWebViewObwb,mWebViewObj, mWebViewd,mWebViewH,mWebViewh,mWebViewPtw,mWebViewPb,mWebViewPc);
                tekst = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");
                Global.EditTextHide(false, a_val, D_val, pp_val, obwp_val, obj_val, obwb_val, d_val, h_val, H_val, triangle_val, pb_val, pc_val);
                Global.WebViewHide(true, mWebViewA, mWebViewD, mWebViewObwp, mWebViewPp, mWebViewObwb, mWebViewObj, mWebViewd, mWebViewH, mWebViewh, mWebViewPtw, mWebViewPb, mWebViewPc);
                licz.setEnabled(true);
                btnSolution.setEnabled(false);
                figura.setImageResource(drawable.gran_pros_trojkatny);
                Toast.makeText(GraniastoslupPrawidlowyTrojkatny.this, getString(R.string.deleted),
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

    public Boolean isEmpty(EditText x) {
        if (x.getText().toString().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    private String policzPp(String a) {
        String jeden = Wartosc.policz(a, a, "*");
        String dwa = Wartosc.policz(jeden, "()\u221a(3)", "*");
        String trzy = Wartosc.policz(dwa, "4", "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzhzPp)+"</b></center><br>" +
                "$$Pp={{a^2}*√3}/4$$<br>" +
                "$$Pp={{{"+Wartosc.formatuj(a)+"}^2}*√3}/4$$<br>" +
                "$$Pp={{"+Wartosc.formatuj(jeden)+"}*√3}/4$$<br>" +
                "$$Pp={"+Wartosc.formatuj(dwa)+"}/4$$<br>" +
                "$$Pp={"+Wartosc.formatuj(trzy)+"}$$<br>" +
        "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return trzy;
    }

    private String policzPpZObjiH(String Obj, String H) {
        String jeden = Wartosc.policz(Obj, H, "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzPpZObjiH)+"</b></center><br>" +
                "$$Pp={Obj}/{H}$$<br>" +
                "$$Pp={{"+Wartosc.formatuj(Obj)+"}/{"+Wartosc.formatuj(H)+"}}$$<br>" +
                "$$Pp={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzAzHid(String H, String d) {
        String jeden = Wartosc.policz(d, d, "*");
        String dwa = Wartosc.policz(H, H, "*");
        String trzy = Wartosc.policz(jeden, dwa, "-");
        String cztery = Wartosc.policz("()\u221a(" + trzy + ")", "1", "*");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzAzHid)+"</b></center><br>" +
                "$$a={√{{d^2}-{H^2}}}$$<br>" +
                "$$a = {√{{{" + Wartosc.formatuj(d) + "}^2}-{{" + Wartosc.formatuj(H) + "}^2}}}$$<br>" +
                "$$a = {√{{" + Wartosc.formatuj(jeden) + "}-{" + Wartosc.formatuj(dwa) + "}}}$$<br>" +
                "$$a = {√{{" + Wartosc.formatuj(trzy) + "}}}$$<br>" +
                "$$a = {" + Wartosc.formatuj(cztery) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return cztery;
    }

    private String policzhzHiD(String H, String D) {
        String jeden = Wartosc.policz(D, D, "*");
        String dwa = Wartosc.policz(H, H, "*");
        String trzy = Wartosc.policz(jeden, dwa, "-");
        String cztery = Wartosc.policz("()\u221a(" + trzy + ")", "1", "*");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzhzHiD)+"</b></center><br>" +
                "$$h = {√{{D^2} - {H^2}}}$$<br>" +
                "$$h = {√{{{"+Wartosc.formatuj(D)+"}^2} - {{"+Wartosc.formatuj(H)+"}^2}}}$$<br>" +
                "$$h = {√{{"+Wartosc.formatuj(jeden)+"} - {"+Wartosc.formatuj(dwa)+"}}}$$<br>" +
                "$$h = {√{"+Wartosc.formatuj(trzy)+"}}$$<br>" +
                "$$h = {"+Wartosc.formatuj(cztery)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return cztery;
    }

    private String policzHzObjiA(String Obj, String a) {
        String j = Wartosc.policz(a, a, "*");
        String d = Wartosc.policz(j, "()\u221a(3)", "*");
        String t = Wartosc.policz(d, "4", "/");
        String jeden = t;
        String dwa = Wartosc.policz(Obj, jeden, "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzHzObjiA)+"</b></center><br>" +
                "$$Pp = {{{a^2}*√3}/4}$$<br>" +
                "$$Pp = {"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "$$H = {{Obj}/{Pp}}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(Obj)+"}/{"+Wartosc.formatuj(jeden)+"}}$$<br>" +
                "$$H = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzHzdiA(String d, String a) {
        String jeden = Wartosc.policz(d, d, "*");
        String dwa = Wartosc.policz(a, a, "*");
        String trzy = Wartosc.policz(jeden, dwa, "-");
        String cztery = Wartosc.policz("()\u221a(" + trzy + ")", "1", "*");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzHzdiA)+"</b></center><br>" +
                "$$H = {√{{d^2} - {a^2}}}$$<br>" +
                "$$H = {√{{{"+Wartosc.formatuj(d)+"}^2} - {{"+Wartosc.formatuj(a)+"}^2}}}$$<br>" +
                "$$H = {√{{"+Wartosc.formatuj(jeden)+"} - {"+Wartosc.formatuj(dwa)+"}}}$$<br>" +
                "$$H = {√{"+Wartosc.formatuj(trzy)+"}}$$<br>" +
                "$$H = {"+Wartosc.formatuj(cztery)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return cztery;
    }

    private String policzHzDiA(String D, String a) {
        String jeden = Wartosc.policz(D, D, "*");
        String j = Wartosc.policz(a, "()\u221a(3)", "*");
        String d = Wartosc.policz(j, "2", "/");
        String dwa = d;
        String trzy = Wartosc.policz(dwa, dwa, "*");
        String cztery = Wartosc.policz(jeden, trzy, "-");
        String piec = Wartosc.policz("()\u221a(" + trzy + ")", "1", "*");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzHzDiA)+"</b></center><br>" +
                "$$h = {{a*√3}/2}$$<br>" +
                "$$h = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "$$H = {√{{D^2} - {h^2}}}$$<br>" +
                "$$H = {√{{{"+Wartosc.formatuj(D)+"}^2} - {{"+Wartosc.formatuj(dwa)+"}^2}}}$$<br>" +
                "$$H = {√{{"+Wartosc.formatuj(jeden)+"} - {"+Wartosc.formatuj(trzy)+"}}}$$<br>" +
                "$$H = {√{"+Wartosc.formatuj(cztery)+"}}$$<br>" +
                "$$H = {"+Wartosc.formatuj(piec)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return piec;
    }

    private String policzHzPciA(String Pc, String a) {
        String j = Wartosc.policz(a, a, "*");
        String d = Wartosc.policz(j, "()\u221a(3)", "*");
        String t = Wartosc.policz(d, "4", "/");
        String jeden = t;
        String dwa = Wartosc.policz("2", jeden, "*");
        String trzy = Wartosc.policz(Pc, dwa, "-");
        String cztery = Wartosc.policz("3", a, "*");
        String piec = Wartosc.policz(trzy, cztery, "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzHzPciA)+"</b></center><br>" +
                "$$Pp={{a^2}*√3}/4$$<br>" +
                "$$Pp = {"+Wartosc.formatuj(jeden)+"}$$<br>"+
                "$$H = {{{Pc} - {2 * Pp}} / {3 * a}}$$<br>" +
                "$$H = {{{"+Wartosc.formatuj(Pc)+"} - {2 * {"+Wartosc.formatuj(jeden)+"}}} / {3 * {"+Wartosc.formatuj(a)+"}}}$$<br>" +
                "$$H = {{{"+Wartosc.formatuj(Pc)+"} - {"+Wartosc.formatuj(dwa)+"}} / {"+Wartosc.formatuj(cztery)+"}}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(trzy)+"} / {"+Wartosc.formatuj(cztery)+"}}$$<br>" +
                "$$H = {"+Wartosc.formatuj(piec)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return piec;
    }

    private String policzHzPbiA(String Pb, String a) {
        String jeden = Wartosc.policz("3", a, "*");
        String dwa = Wartosc.policz(Pb, jeden, "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzHzPbiA)+"</b></center><br>" +
                "$$Pb={a*H*3}$$<br>" +
                "$${Pb}/{3} = {a*H}$$<br>"+
                "$$H = {Pb}/{3*a}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(Pb)+"}/{3*{"+Wartosc.formatuj(a)+"}}}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(Pb)+"}/{"+Wartosc.formatuj(jeden)+"}}$$<br>" +
                "$$H = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzHzObwbiA(String ObwB, String a) {
        String jeden = Wartosc.policz("6", a, "*");
        String dwa = Wartosc.policz(ObwB, jeden, "-");
        String trzy = Wartosc.policz(dwa, "3", "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzHzObwbiA)+"</b></center><br>" +
                "$$H = {{{ObwB} - {6 * a}} / 3}$$<br>" +
                "$$H = {{{"+Wartosc.formatuj(ObwB)+"} - {6 * {"+Wartosc.formatuj(a)+"}}} / 3}$$<br>" +
                "$$H = {{{"+Wartosc.formatuj(ObwB)+"} - {"+Wartosc.formatuj(jeden)+"}} / 3}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(dwa)+"} / 3}$$<br>" +
                "$$H = {"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return trzy;
    }

    private String policzHzTriangleiA(String Ptw,String a) {
        String j = Wartosc.policz(a, "()\u221a(3)", "*");
        String d = Wartosc.policz(j, "2", "/");
        String dwa = d;
        String trzy = Wartosc.policz(Ptw, "2", "*");
        String cztery = Wartosc.policz(trzy, dwa, "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzHzTriangleiA)+"</b></center><br>" +
                "$$Ptw = {{1/2}*h*H}$$<br>" +
                "$${2*Ptw} = {h*H}$$<br>" +
                "$$H = {{2*Ptw}/h}$$<br>" +
                "$$h = {{a * √3}/2}$$<br>" +
                "$$h = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "$$H = {{2*{"+Wartosc.formatuj(Ptw)+"}}/{"+Wartosc.formatuj(dwa)+"}}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(trzy)+"}/{"+Wartosc.formatuj(dwa)+"}}$$<br>" +
                "$$H = {"+Wartosc.formatuj(cztery)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return cztery;
    }

    private String policzPpzPciPb(String Pc, String Pb) {
        String jeden = Wartosc.policz(Pc, Pb, "-");
        String dwa = Wartosc.policz(jeden, "2", "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzPpzPciPb)+"</b></center><br>" +
                "$$Pp = {{Pc - Pb} / 2}$$<br>" +
                "$$Pp = {{{"+Wartosc.formatuj(Pc)+"} - {"+Wartosc.formatuj(Pb)+"}} / 2}$$<br>" +
                "$$Pp = {{"+Wartosc.formatuj(jeden)+"} / 2}$$<br>" +
                "$$Pp = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzDzHiA(String H, String a) {
        String j = Wartosc.policz(a, "()\u221a(3)", "*");
        String d = Wartosc.policz(j, "2", "/");
        String jeden = d;
        String dwa = Wartosc.policz(jeden, jeden, "*");
        String trzy = Wartosc.policz(H, H, "*");
        String cztery = Wartosc.policz(trzy, dwa, "+");
        String piec = Wartosc.policz("()\u221a(" + cztery + ")", "1", "*");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzDzHiA)+"</b></center><br>" +
                "$$h = {{a * √3}/2}$$<br>" +
                "$$h={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "$$D = {√{{H^2} + {h^2}}}$$<br>" +
                "$$D = {√{{{"+Wartosc.formatuj(H)+"}^2} + {{"+Wartosc.formatuj(jeden)+"}^2}}}$$<br>" +
                "$$D = {√{{"+Wartosc.formatuj(trzy)+"} + {"+Wartosc.formatuj(dwa)+"}}}$$<br>" +
                "$$D = {√{"+Wartosc.formatuj(cztery)+"}}$$<br>" +
                "$$D = {"+Wartosc.formatuj(piec)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return piec;
    }

    private String policzdzHiA(String H, String a) {
        String jeden = Wartosc.policz(H, H, "*");
        String dwa = Wartosc.policz(a, a, "*");
        String trzy = Wartosc.policz(jeden, dwa, "+");
        String cztery = Wartosc.policz("()\u221a(" + trzy + ")", "1", "*");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzdzHiA)+"</b></center><br>" +
                "$$d = {√{{H^2} + {a^2}}}$$<br>" +
                "$$d = {√{{{"+Wartosc.formatuj(H)+"}^2} + {{"+Wartosc.formatuj(a)+"}^2}}}$$<br>" +
                "$$d = {√{{"+Wartosc.formatuj(jeden)+"} + {"+Wartosc.formatuj(dwa)+"}}}$$<br>" +
                "$$d = {√{"+Wartosc.formatuj(trzy)+"}}$$<br>" +
                "$$d = {"+Wartosc.formatuj(cztery)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return cztery;
    }

    private String policzPbzAiH(String a, String H) {
        String jeden = Wartosc.policz("3", a, "*");
        String dwa = Wartosc.policz(jeden, H, "*");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzPbzAiH)+"</b></center><br>" +
                "$$Pb = {{3*a}*H}$$<br>" +
                "$$Pb = {{3*{"+Wartosc.formatuj(a)+"}}*{"+Wartosc.formatuj(H)+"}}$$<br>" +
                "$$Pb = {{"+Wartosc.formatuj(jeden)+"}*{"+Wartosc.formatuj(H)+"}}$$<br>" +
                "$$Pb = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzPczAiH(String a, String H) {
        String j = Wartosc.policz(a, a, "*");
        String d = Wartosc.policz(j, "()\u221a(3)", "*");
        String t = Wartosc.policz(d, "4", "/");
        String jeden = Wartosc.policz("3", a, "*");
        String dwa = Wartosc.policz(jeden, H, "*");
        String trzy = Wartosc.policz("2", t, "*");
        String cztery = Wartosc.policz(trzy, dwa, "+");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzPczAiH)+"</b></center><br>" +
                "$$Pp = {"+Wartosc.formatuj(t)+"}$$<br>" +
                "$$Pc = {{2 * Pp} + {{3 * a} * H}}$$<br>" +
                "$$Pc = {{2 * {"+Wartosc.formatuj(t)+"}} + {{3 * {"+Wartosc.formatuj(a)+"}} * {"+Wartosc.formatuj(H)+"}}}$$<br>" +
                "$$Pc = {{"+Wartosc.formatuj(trzy)+"} + {{"+Wartosc.formatuj(jeden)+"} * {"+Wartosc.formatuj(H)+"}}}$$<br>" +
                "$$Pc = {{"+Wartosc.formatuj(trzy)+"} + {"+Wartosc.formatuj(dwa)+"}}$$<br>" +
                "$$Pc = {"+Wartosc.formatuj(cztery)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return cztery;
    }

    private String policzObwbZAiH(String a, String H) {
        String jeden = Wartosc.policz("6", a, "*");
        String dwa = Wartosc.policz("3", H, "*");
        String trzy = Wartosc.policz(jeden, dwa, "+");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzObwbZAiH)+"</b></center><br>" +
                "$$ObwB = {{6 * a} + {3 * H}}$$<br>" +
                "$$ObwB = {{6 * {"+Wartosc.formatuj(a)+"}} + {3 * {"+Wartosc.formatuj(H)+"}}}$$<br>" +
                "$$ObwB = {{"+Wartosc.formatuj(jeden)+"} + {"+Wartosc.formatuj(dwa)+"}}$$<br>" +
                "$$ObwB = {"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return trzy;
    }

    private String policzTriangleZaiH(String a, String H) {
        String j = Wartosc.policz(a, "()\u221a(3)", "*");
        String d = Wartosc.policz(j, "2", "/");
        String zero = d;
        String jeden = Wartosc.policz(zero, zero, "*");
        String dwa = Wartosc.policz(H, H, "*");
        String trzy = Wartosc.policz(dwa, jeden, "+");
        String cztery = Wartosc.policz("()\u221a(" + trzy + ")","1", "*");
        String piec = Wartosc.policz(cztery, "2", "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzTriangleZaiH)+"</b></center><br>" +
                "$$h = {{a * √3}/2}$$<br>" +
                "$$h = {"+Wartosc.formatuj(zero)+"}$$<br>" +
                "$$Ptw = {√{{h^2} + {H^2}}/2}$$<br>" +
                "$$Ptw = {√{{{"+Wartosc.formatuj(zero)+"}^2} + {{"+Wartosc.formatuj(H)+"}^2}}/2}$$<br>" +
                "$$Ptw = {√{{"+Wartosc.formatuj(jeden)+"} + {"+Wartosc.formatuj(dwa)+"}}/2}$$<br>" +
                "$$Ptw = {√{{"+Wartosc.formatuj(trzy)+"}}/2}$$<br>" +
                "$$Ptw = {{"+Wartosc.formatuj(cztery)+"}/2}$$<br>" +
                "$$Ptw = {"+Wartosc.formatuj(piec)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return piec;
    }

    private String policzObjZaiH(String a, String H) {
        String j = Wartosc.policz(a, a, "*");
        String d = Wartosc.policz(j, "()\u221a(3)", "*");
        String t = Wartosc.policz(d, "4", "/");
        String jeden = t;
        String dwa = Wartosc.policz(jeden, H, "*");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzObjZaiH)+"</b></center><br>" +
                "$$Pp={{a^2}*√3}/4$$<br>" +
                "$$Pp = {"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "$$Obj = {Pp*H}$$<br>" +
                "$$Obj = {{"+Wartosc.formatuj(jeden)+"}*{"+Wartosc.formatuj(H)+"}}$$<br>" +
                "$$Obj = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzObwp(String a) {
        String jeden = Wartosc.policz("3", a, "*");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzObwp)+"</b></center><br>" +
                "$$ObwP={a*3}$$<br>" +
                "$$ObwP = {{" + Wartosc.formatuj(a) + "}*3}$$<br>" +
                "$$ObwP = {" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzAzh(String h) {
        String jeden = Wartosc.policz(h, "(2)\u221a(3)", "*");
        String dwa = Wartosc.policz(jeden, "3", "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzAzh)+"</b></center><br>" +
                "$$h = {{a * √3}/2}$$<br>" +
                "$${2*h} = {a * √3}$$<br>" +
                "$$a = {{2*h}/√3}$$<br>" +
                "$$a = {{2√3 * h}/3}$$<br>" +
                "$$a = {{2√3 * {"+Wartosc.formatuj(h)+"}}/3}$$<br>" +
                "$$a = {{"+Wartosc.formatuj(jeden)+"}/3}$$<br>" +
                "$$a = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzAzHiPb(String H, String Pb) {
        String jeden = Wartosc.policz(H, "3", "*");
        String dwa = Wartosc.policz(Pb, jeden, "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzAzHiPb)+"</b></center><br>" +
                "$$a = {{Pb}/{3*H}}$$<br>" +
                "$$a = {{"+Wartosc.formatuj(Pb)+"}/{3*{"+Wartosc.formatuj(H)+"}}}$$<br>" +
                "$$a = {{"+Wartosc.formatuj(Pb)+"}/{"+Wartosc.formatuj(jeden)+"}}$$<br>" +
                "$$a = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzAzPp(String Pp) {
        String jeden = Wartosc.policz(Pp, "4", "*");
        String dwa = Wartosc.policz(jeden, "()\u221a(3)", "/");
        String trzy = Wartosc.policz("()\u221a(" + dwa + ")", "1", "*");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzAzPp)+"</b></center><br>" +
                "$$Pp = {{{a^2} * √3} / 4}$$<br>" +
                "$${4 * Pp} = {{a^2} * √3} $$<br>" +
                "$${{4 * Pp} / √3} = {a^2} $$<br>" +
                "$$a = {√{{4 * Pp} / √3}} $$<br>" +
                "$$a = {√{{4 * {"+Wartosc.formatuj(Pp)+"}} / √3}} $$<br>" +
                "$$a = {√{{"+Wartosc.formatuj(jeden)+"} / √3}} $$<br>" +
                "$$a = {√{"+Wartosc.formatuj(dwa)+"}} $$<br>" +
                "$$a = {" + Wartosc.formatuj(trzy) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return trzy;
    }

    private String policzAzHiObwb(String H, String Obwb) {
        String jeden = Wartosc.policz(H, "3", "*");
        String dwa = Wartosc.policz(Obwb, jeden, "-");
        String trzy = Wartosc.policz(dwa, "6", "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzAzHiObwb)+"</b></center><br>" +
                "$$a = {{{Obwb}-{3*H}}/6}$$<br>" +
                "$$a = {{{"+Wartosc.formatuj(Obwb)+"}-{3*{"+Wartosc.formatuj(H)+"}}}/6}$$<br>" +
                "$$a = {{{"+Wartosc.formatuj(Obwb)+"}/{"+Wartosc.formatuj(jeden)+"}}/6}$$<br>" +
                "$$a = {{"+Wartosc.formatuj(dwa)+"}/6}$$<br>" +
                "$$a = {"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return trzy;
    }

    private String policzAzObwp(String Obwp) {
        String jeden = Wartosc.policz(Obwp, "3", "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzAzObwp)+"</b></center><br>" +
                "$$ObwP = {a * 3}$$<br>" +
                "$$a = {{ObwP} / 3}$$<br>" +
                "$$a = {{"+Wartosc.formatuj(Obwp)+"} / 3}$$<br>" +
                "$$a = {"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzhza(String a) {
        String jeden = Wartosc.policz(a, "()\u221a(3)", "*");
        String dwa = Wartosc.policz(jeden, "2", "/");
        String solucja1 = "<center><b>"+getString(string.granprostroj_policzhza)+"</b></center><br>" +
                "$$h = {{a * √3}/2}$$<br>" +
                "$$h = {{{"+Wartosc.formatuj(a)+"} * √3}/2}$$<br>" +
                "$$h = {{"+Wartosc.formatuj(jeden)+"}/2}$$<br>" +
                "$$h = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzhzPp(String Pp) {
        String jeden = Wartosc.policz("3", Pp, "*");
        String dwa = Wartosc.policz(jeden, "()\u221a(3)", "/");
        String trzy = Wartosc.policz("()\u221a(" + dwa + ")", "1", "*");
        String solucja = "<center><b>"+getString(string.granprostroj_policzhzPp)+"</b></center><br>" +
                "$$h = {{a * {√3}} / 2}$$<br>" +
                "$${2 * h} = {a * {√3}}$$<br>" +
                "$$a = {{2 * h} / {√3}}$$<br>" +
                "$$a = {{{2√3} * h} / 3}$$<br>" +
                "$$Pp = {{{a^2} * √3} / 4}$$<br>" +
                "$$Pp = {{{({{{2√3}*h}/3})^2} * √3} / 4}$$<br>" +
                "$$Pp = {{{{12 * {h^2}} / 9} * √3} / 4}$$<br>" +
                "$$Pp = {{{h^2} * √3} / 3}$$<br>" +
                "$${3 * Pp} = {{h^2} * √3}$$<br>" +
                "$${{3 * Pp}/√3} = {h^2}$$<br>" +
                "$$h = {√{{3 * Pp} / √3}}$$<br>" +
                "$$h = {√{{3 * {"+Wartosc.formatuj(Pp)+"}} / √3}}$$<br>" +
                "$$h = {√{{3 * {"+Wartosc.formatuj(Pp)+"}} / √3}}$$<br>" +
                "$$h = {√{{"+Wartosc.formatuj(jeden)+"} / √3}}$$<br>" +
                "$$h = {√{"+Wartosc.formatuj(dwa)+"}}$$<br>" +
                "$$h = {"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return trzy;
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
