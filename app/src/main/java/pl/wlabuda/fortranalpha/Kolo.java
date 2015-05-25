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

public class Kolo extends Activity implements OnFocusChangeListener{

    private Button licz;
    private Button clear;
    private Button sqrtbtn;
    private Button powbtn;
    private Button btnReview;
    private Button btnData;
    private Button btnSolution;
    private EditText pp_val;
    private EditText r_val;
    private EditText s_val;
    private EditText obwp_val;
    private EditText lastFocused;
    private String tekst;
    private WebView mWebView;
    private WebView mWebViewPp;
    private WebView mWebViewR;
    private WebView mWebViewS;
    private WebView mWebViewObw;
    private ImageView figura;
    private ScrollView scrollView;
    private LinearLayout buttons;

    private String r;
    private String pp;
    private String S;
    private String obwp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kolo);
        Global.mContext = this.getBaseContext();

        pp_val = (EditText) findViewById(R.id.pp);
        r_val = (EditText) findViewById(R.id.r);
        s_val = (EditText) findViewById(R.id.S);
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

        mWebViewPp = (WebView) findViewById(R.id.webPp);
        WebSettings webSettings1 = mWebViewPp.getSettings();
        mWebViewPp.setBackgroundColor(0xff0);
        webSettings1.setJavaScriptEnabled(true);

        mWebViewR = (WebView) findViewById(R.id.webR);
        WebSettings webSettings2 = mWebViewR.getSettings();
        mWebViewR.setBackgroundColor(0xff0);
        webSettings2.setJavaScriptEnabled(true);

        mWebViewS = (WebView) findViewById(R.id.webS);
        WebSettings webSettings3 = mWebViewS.getSettings();
        mWebViewS.setBackgroundColor(0xff0);
        webSettings3.setJavaScriptEnabled(true);

        mWebViewObw = (WebView) findViewById(R.id.webObwp);
        WebSettings webSettings4 = mWebViewObw.getSettings();
        mWebViewObw.setBackgroundColor(0xff0);
        webSettings4.setJavaScriptEnabled(true);

        r_val.setOnFocusChangeListener(this);
        s_val.setOnFocusChangeListener(this);
        pp_val.setOnFocusChangeListener(this);
        obwp_val.setOnFocusChangeListener(this);

        Global.TouchListener(figura, R.drawable.kolop, pp_val);
        Global.TouchListener(figura, R.drawable.kolor, r_val);
        Global.TouchListener(figura,R.drawable.kolos, s_val);
        Global.TouchListener(figura,R.drawable.koloobw,obwp_val);

        final InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        new TabListener(buttons,imm,btnReview,btnData,btnSolution,figura,scrollView,mWebView);

        figura.setImageResource(R.drawable.kolo);

        btnSolution.setEnabled(false);

        btnReview.setTypeface(null, Typeface.BOLD);
        btnReview.setTextSize(30);
        btnReview.setBackgroundColor(Color.TRANSPARENT);

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean bR = false;
                boolean bS = false;
                boolean bpp = false;
                boolean bobwp = false;

                tekst = "";
                licz.setTypeface(null, Typeface.NORMAL);
                clear.setTypeface(null, Typeface.BOLD);

                int x = 0; //koniec petli, wszystko policzone
                int y = 0; //za mało danych aby policzyć

                if(Wartosc.nawiasy(r_val.getText().toString()) &&
                        Wartosc.nawiasy(pp_val.getText().toString()) &&
                        Wartosc.nawiasy(s_val.getText().toString()) &&
                        Wartosc.nawiasy(obwp_val.getText().toString())) {
                    try {
                        while (x == 0) {
                            //obliczanie r lub pp lub obwp
                            //czy jest r
                            if (!isEmpty(r_val)) {
                                System.out.println("^^^^^^^^1");
                                r = r_val.getText().toString();
                                bR = true;
                                if (isEmpty(pp_val) && !bpp) {
                                    System.out.println("^^^^^^^^1.1");
                                    String s = policzPp(r);
                                    pp_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewPp);
                                    bpp = true;
                                }
                                if (isEmpty(obwp_val) && !bobwp) {
                                    String s = policzObwp(r);
                                    obwp_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewObw);
                                    bobwp = true;
                                    System.out.println("^^^^^^^^1.2");
                                }
                                if (isEmpty(s_val) && !bS) {
                                    String s = policzS(r);
                                    s_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewS);
                                    bR = true;
                                    System.out.println("^^^^^^^^1.3");
                                }
                                JavaScript.showFormatted(r, mWebViewR);
                            } else  if(!isEmpty(s_val)){
                                System.out.println("^^^^^^^^1");
                                S = s_val.getText().toString();
                                bS = true;
                                if (isEmpty(pp_val) && !bpp) {
                                    System.out.println("^^^^^^^^1.1");
                                    String s = policzPpzS(S);
                                    pp_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewPp);
                                    bpp = true;
                                }
                                if (isEmpty(obwp_val) && !bobwp) {
                                    String s = policzObwpzS(S);
                                    obwp_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewObw);
                                    bobwp = true;
                                    System.out.println("^^^^^^^^1.2");
                                }
                                if (isEmpty(r_val) && !bR) {
                                    String s = policzR(S);
                                    r_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewR);
                                    bR = true;
                                    System.out.println("^^^^^^^^1.3");
                                }
                                JavaScript.showFormatted(S, mWebViewS);
                            }else if(!isEmpty(obwp_val)){
                                System.out.println("^^^^^^^^1");
                                obwp = obwp_val.getText().toString();
                                bobwp = true;
                                if (isEmpty(pp_val) && !bpp) {
                                    System.out.println("^^^^^^^^1.1");
                                    String s = policzPpzObw(obwp);
                                    pp_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewPp);
                                    bpp = true;
                                }
                                if (isEmpty(s_val) && !bS) {
                                    String s = policzSzObw(obwp);
                                    s_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewS);
                                    bS = true;
                                    System.out.println("^^^^^^^^1.2");
                                }
                                if (isEmpty(r_val) && !bR) {
                                    String s = policzRzObw(obwp);
                                    r_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewR);
                                    bR = true;
                                    System.out.println("^^^^^^^^1.3");
                                }
                                JavaScript.showFormatted(obwp, mWebViewObw);
                            }else if(!isEmpty(pp_val)){
                                System.out.println("^^^^^^^^1");
                                pp = pp_val.getText().toString();
                                bpp = true;
                                if (isEmpty(s_val) && !bS) {
                                    System.out.println("^^^^^^^^1.1");
                                    String s = policzSzPp(pp);
                                    s_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewS);
                                    bS = true;
                                }
                                if (isEmpty(obwp_val) && !bobwp) {
                                    String s = policzObwpzPp(pp);
                                    obwp_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewObw);
                                    bobwp = true;
                                    System.out.println("^^^^^^^^1.2");
                                }
                                if (isEmpty(r_val) && !bR) {
                                    String s = policzRzPp(pp);
                                    r_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewR);
                                    bR = true;
                                    System.out.println("^^^^^^^^1.3");
                                }
                                JavaScript.showFormatted(pp, mWebViewPp);
                            }
                            //wszystko policzone, koniec petli
                            if (!r_val.getText().toString().equals("") &&
                                    !pp_val.getText().toString().equals("") &&
                                    !obwp_val.getText().toString().equals("") &&
                                    !s_val.getText().toString().equals("")
                                    ) {
                                x = 1;
                                figura.setImageResource(R.drawable.kolo);
                                licz.setEnabled(false);
                                btnSolution.setEnabled(true);
                                imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);

                                Toast.makeText(Kolo.this, getString(R.string.premium),
                                        Toast.LENGTH_LONG).show();
                            } //za malo danych
                            if(isEmpty(r_val) && isEmpty(pp_val) && isEmpty(obwp_val) && isEmpty(s_val)){
                                Toast.makeText(Kolo.this, getString(R.string.notEnough),
                                        Toast.LENGTH_LONG).show();
                                x = 1;
                                y = 1;
                            }
                        }
                        new ProgressBar(view);
                    } catch (Exception e) {
                        System.out.println("emessage " + e.getMessage());
                        Toast.makeText(Kolo.this, getString(R.string.ups),
                                Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Kolo.this, getString(R.string.bracket),
                            Toast.LENGTH_LONG).show();
                }
                JavaScript JS = new JavaScript(tekst);
                mWebView.loadDataWithBaseURL("", "" + JS.getTekst(), "text/html", "UTF-8", "");

                if(y == 0) {
                    Global.WebViewHide(false, mWebView, mWebViewR, mWebViewObw, mWebViewS, mWebViewPp);
                    Global.EditTextHide(true, pp_val, r_val, s_val, obwp_val);
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
                Global.setEmpty(r_val, s_val, pp_val, obwp_val);
                tekst = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");
                Global.EditTextHide(false, r_val, s_val, pp_val, obwp_val);
                Global.WebViewHide(true, mWebViewR, mWebViewS, mWebViewObw, mWebViewPp);
                licz.setEnabled(true);
                btnSolution.setEnabled(false);
                figura.setImageResource(R.drawable.kolo);
                clear.setTypeface(null, Typeface.NORMAL);
                licz.setTypeface(null, Typeface.BOLD);
                Toast.makeText(Kolo.this, getString(R.string.deleted),
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
    }   // Pi = 3,14159

    private String policzPp(String r) {
        String jeden = Wartosc.policz(r,r,"*");
        String dwa = Wartosc.policz(jeden,"3.14159","*");
        System.out.println("policzPp "+r);
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzPp)+"</b></center><br>" +
                "$$P={π * {r^2}}$$<br>" +
                "$$P={π * {{"+Wartosc.formatuj(r)+"}^2}}$$<br>" +
                "$$P={π * {"+Wartosc.formatuj(jeden)+"}}$$<br>" +
                "$$P={"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzS(String r) {
        String jeden = Wartosc.policz("2",r,"*");
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzS)+"</b></center><br>" +
                "$$S={2 * r}$$<br>" +
                "$$S={2 * {"+Wartosc.formatuj(r)+"}}$$<br>" +
                "$$S={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzR(String S) {
        String jeden = Wartosc.policz(S,"2","/");
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzR)+"</b></center><br>" +
                "$$S={2*r}$$<br>" +
                "$$r={S/2}$$<br>" +
                "$$r={{"+Wartosc.formatuj(S)+"}/2}$$<br>" +
                "$$r={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzObwp(String r) {
        String jeden = Wartosc.policz("2",r,"*");
        String dwa = Wartosc.policz("3.14159",r,"*");
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzObwp)+"</b></center><br>" +
                "$$Obw={2*π*r}$$<br>" +
                "$$Obw={2*π*{"+Wartosc.formatuj(r)+"}}$$<br>" +
                "$$Obw={π*{"+Wartosc.formatuj(jeden)+"}}$$<br>" +
                "$$Obw={"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzRzPp(String Pp) {
        String jeden = Wartosc.policz("()\u221a("+Pp+")","1","*");
        String dwa = Wartosc.policz("()\u221a(3.14159)",jeden,"*");
        String trzy = Wartosc.policz(dwa,"3.14159","/");
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzRzPp)+"</b></center><br>" +
                "$$P={π*{r^2}}$$<br>" +
                "$${P/π}={r^2}$$<br>" +
                "$$r={√{P/π}}$$<br>" +
                "$$r={{√{P}}/{√{π}}}$$<br>" +
                "$$r={{{√{P}}*{√{π}}}/{π}}$$<br>" +
                "$$r={{{√{"+Wartosc.formatuj(Pp)+"}}*{√{π}}}/{π}}$$<br>" +
                "$$r={{{"+Wartosc.formatuj(jeden)+"}*{√{π}}}/{π}}$$<br>" +
                "$$r={{"+Wartosc.formatuj(dwa)+"}/{π}}$$<br>" +
                "$$r={"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return trzy;
    }

    private String policzRzObw(String Obwp){
        String jeden = Wartosc.policz(Obwp,"2","/");
        String dwa = Wartosc.policz(jeden,"3.14159","/");
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzRzObw)+"</b></center><br>" +
                "$$Obw={2*π*r}$$<br>" +
                "$$r={{Obw}/{2*π}}$$<br>" +
                "$$r={{"+Wartosc.formatuj(Obwp)+"}/{2*π}}$$<br>" +
                "$$r={{"+Wartosc.formatuj(jeden)+"}/{π}}$$<br>" +
                "$$r={"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return dwa;
    }

    private String policzSzObw(String Obwp){
        String jeden = Wartosc.policz(Obwp,"3.14159","/");
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzSzObw)+"</b></center><br>" +
                "$$Obw={2*π*r}$$<br>" +
                "$$S={2*r}$$<br>" +
                "$$Obw={S*π}$$<br>" +
                "$$S={{Obw}/π}$$<br>" +
                "$$S={{"+Wartosc.formatuj(Obwp)+"}/π}$$<br>" +
                "$$S={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzSzPp(String pp){
        String jeden = Wartosc.policz("()\u221a("+pp+")","1","*");
        String dwa = Wartosc.policz("()\u221a(3.14159)",jeden,"*");
        String trzy = Wartosc.policz(dwa,"3.14159","/");
        String cztery = Wartosc.policz(trzy,"2","*");
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzSzPp)+"</b></center><br>" +
                "$$S={2*r}$$<br>" +
                "$$P={π*{r^2}}$$<br>" +
                "$${P/π}={r^2}$$<br>" +
                "$$r={√{P/π}}$$<br>" +
                "$$r={{√{P}}/{√{π}}}$$<br>" +
                "$$r={{{√{P}}*{√{π}}}/{π}}$$<br>" +
                "$$S={2*{{{√{P}}*{√{π}}}/{π}}}$$<br>" +
                "$$S={2*{{{√{"+Wartosc.formatuj(pp)+"}}*{√{π}}}/{π}}}$$<br>" +
                "$$S={2*{{{"+Wartosc.formatuj(jeden)+"}*{√{π}}}/{π}}}$$<br>" +
                "$$S={2*{{"+Wartosc.formatuj(dwa)+"}/{π}}}$$<br>" +
                "$$S={2*{"+Wartosc.formatuj(trzy)+"}}$$<br>" +
                "$$S={"+Wartosc.formatuj(cztery)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return cztery;
    }

    private String policzObwpzS(String S){
        String jeden = Wartosc.policz(S,"3.14159","*");
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzObwpzS)+"</b></center><br>" +
                "$$Obw={2*π*r}$$<br>" +
                "$$S={2*r}$$<br>" +
                "$$Obw={S*π}$$<br>" +
                "$$Obw={{"+Wartosc.formatuj(S)+"}*π}$$<br>" +
                "$$Obw={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzObwpzPp(String Pp){
        String jeden = Wartosc.policz("()\u221a("+Pp+")","1","*");
        String dwa = Wartosc.policz("()\u221a(3.14159)",jeden,"*");
        String trzy = Wartosc.policz("2",dwa,"*");
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzObwzPp)+"</b></center><br>" +
                "$$Obw={2*π*r}$$<br>" +
                "$$P={π*{r^2}}$$<br>" +
                "$${P/π}={r^2}$$<br>" +
                "$$r={√{P/π}}$$<br>" +
                "$$r={{√{P}}/{√{π}}}$$<br>" +
                "$$r={{{√{P}}*{√{π}}}/{π}}$$<br>" +
                "$$Obw={2*π*{{{√{P}}*{√{π}}}/{π}}}$$<br>" +
                "$$Obw={2*{{{√{P}}*{√{π}}}}}$$<br>" +
                "$$Obw={2*{{{√{"+Wartosc.formatuj(Pp)+"}}*{√{π}}}}}$$<br>" +
                "$$Obw={2*{{{"+Wartosc.formatuj(jeden)+"}*{√{π}}}}}$$<br>" +
                "$$Obw={2*{"+Wartosc.formatuj(dwa)+"}}$$<br>" +
                "$$Obw={"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return trzy;
    }

    private String policzPpzS(String S){
        String jeden = Wartosc.policz(S,S,"*");
        String dwa = Wartosc.policz(jeden,"4","/");
        String trzy = Wartosc.policz(dwa,"3.14159","*");
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzPpzS)+"</b></center><br>" +
                "$$P={π*{r^2}}$$<br>" +
                "$$S={2*r}$$<br>" +
                "$$r={S/2}$$<br>" +
                "$$P={π*{{S/2}^2}}$$<br>" +
                "$$P={{π*{S^2}}/4}$$<br>" +
                "$$P={{π*{"+Wartosc.formatuj(S)+"^2}}/4}$$<br>" +
                "$$P={{π*{"+Wartosc.formatuj(jeden)+"}}/4}$$<br>" +
                "$$P={π*{"+Wartosc.formatuj(dwa)+"}}$$<br>" +
                "$$P={"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return trzy;
    }

    private String policzPpzObw(String Obwp){
        String jeden = Wartosc.policz(Obwp,Obwp,"*");
        String dwa = Wartosc.policz(jeden,"4","/");
        String trzy = Wartosc.policz(dwa,"3.14159","/");
        String solucja1 = "<center><b>"+getString(R.string.kolo_policzPpzObw)+"</b></center><br>" +
                "$$Obw={2*π*r}$$<br>" +
                "$$r={{Obw}/{2*π}}$$<br>" +
                "$$P={π * {r^2}}$$<br>" +
                "$$P={π * {{{Obw}/{2*π}}^2}}$$<br>" +
                "$$P={{{Obw}^2}/{4*π}}$$<br>" +
                "$$P={{{"+Wartosc.formatuj(Obwp)+"}^2}/{4*π}}$$<br>" +
                "$$P={{"+Wartosc.formatuj(jeden)+"}/{4*π}}$$<br>" +
                "$$P={{"+Wartosc.formatuj(dwa)+"}/{π}}$$<br>" +
                "$$P={"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify r parent activity in AndroidManifest.xml.
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
