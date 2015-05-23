package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
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
import android.widget.TextView;
import android.widget.Toast;

import pl.wlabuda.fortranalpha.R.drawable;
import pl.wlabuda.fortranalpha.R.id;
import pl.wlabuda.fortranalpha.R.layout;

public class TrojkatPrawidlowy extends Activity implements OnFocusChangeListener {

    private Button licz;
    private Button clear;
    private Button solutionbtn;
    private Button sqrtbtn;
    private Button powbtn;
    private EditText pp_val;
    private EditText a_val;
    private EditText h_val;
    private EditText obwp_val;
    private EditText lastFocused;
    private String tekst = "";
    private ImageView figura;
    private ScrollView scrollView;
    private Button btnReview;
    private Button btnData;
    private Button btnSolution;
    private WebView mWebView;
    private WebView mWebViewPp;
    private WebView mWebViewObwp;
    private WebView mWebViewA;
    private WebView mWebViewH;
    private LinearLayout buttons;

    String a;
    String pp;
    String h;
    String obwp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.trojkat_prawidlowy);
        Global.mContext = this.getBaseContext();

        pp_val = (EditText) findViewById(id.pp);
        a_val = (EditText) findViewById(id.a);
        h_val = (EditText) findViewById(id.h);
        obwp_val = (EditText) findViewById(id.obw);
        licz = (Button) findViewById(id.magic);
        clear = (Button) findViewById(id.clear);
        sqrtbtn = (Button) findViewById(id.sqrtbtn);
        powbtn = (Button) findViewById(id.powbtn);
        solutionbtn = (Button) findViewById(id.solutionbtn);
        figura = (ImageView) findViewById(id.imageView);
        btnReview = (Button) findViewById(R.id.btnReview);
        btnData = (Button) findViewById(R.id.btnData);
        btnSolution = (Button) findViewById(R.id.btnSolution);
        scrollView = (ScrollView) findViewById(R.id.dwa);
        buttons = (LinearLayout) findViewById(id.buttons);

        if (btnData.getVisibility() == View.VISIBLE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        mWebView = (WebView) findViewById(id.webSolution);
        mWebView.setBackgroundColor(0xff0);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebViewA = (WebView) findViewById(R.id.weba);
        WebSettings webSettingsA = mWebViewA.getSettings();
        mWebViewA.setBackgroundColor(0xff0);
        webSettingsA.setJavaScriptEnabled(true);

        mWebViewPp = (WebView) findViewById(R.id.webPp);
        WebSettings webSettingsPp = mWebViewPp.getSettings();
        mWebViewPp.setBackgroundColor(0xff0);
        webSettingsPp.setJavaScriptEnabled(true);

        mWebViewObwp = (WebView) findViewById(R.id.webObwp);
        WebSettings webSettingsObwp = mWebViewObwp.getSettings();
        mWebViewObwp.setBackgroundColor(0xff0);
        webSettingsObwp.setJavaScriptEnabled(true);

        mWebViewH = (WebView) findViewById(R.id.webh);
        WebSettings webSettingsH = mWebViewH.getSettings();
        mWebViewH.setBackgroundColor(0xff0);
        webSettingsH.setJavaScriptEnabled(true);

        a_val.setOnFocusChangeListener(this);
        h_val.setOnFocusChangeListener(this);
        pp_val.setOnFocusChangeListener(this);
        obwp_val.setOnFocusChangeListener(this);

        Global.TouchListener(figura, drawable.trojkaprawidlowyp, pp_val);
        Global.TouchListener(figura, drawable.trojkaprawidlowyobw, obwp_val);
        Global.TouchListener(figura, drawable.trojkaprawidlowyh, h_val);
        Global.TouchListener(figura, drawable.trojkaprawidlowya, a_val); //todo grafiki zmienic

        final InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        new TabListener(buttons,imm, btnReview, btnData, btnSolution, figura, scrollView, mWebView);

        figura.setImageResource(drawable.trojkaprawidlowy);

        btnSolution.setEnabled(false);

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean ba = false;
                boolean bh = false;
                boolean bpp = false;
                boolean bobwp = false;

                tekst = "";

                figura.setImageResource(drawable.trojkaprawidlowy);

                int x = 0; //koniec petli, wszystko policzone

                if (Wartosc.nawiasy(a_val.getText().toString()) &&
                        Wartosc.nawiasy(pp_val.getText().toString()) &&
                        Wartosc.nawiasy(obwp_val.getText().toString()) &&
                        Wartosc.nawiasy(h_val.getText().toString())) {
                    try {
                        while (x == 0) {
                            //obliczanie a lub h lub pp lub obwp
                            //czy jest a
                            if (!isEmpty(a_val)) {
                                System.out.println("^^^^^^^^1");
                                a = a_val.getText().toString();
                                JavaScript.showFormatted(a, mWebViewA);
                                ba = true;
                                if (isEmpty(pp_val) && !bpp) {
                                    String s = policzPp(a);
                                    pp_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewPp);
                                    bpp = true;
                                }
                                if (isEmpty(h_val) && !bh) {
                                    String s = policzhza(a);
                                    h_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewH);
                                    bh = true;
                                }
                                if (isEmpty(obwp_val) && !bobwp) {
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
                                JavaScript.showFormatted(h, mWebViewH);
                                bh = true;
                                if (isEmpty(a_val) && !ba) {
                                    String s = policzAzh(h);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                                if (isEmpty(pp_val) && !bpp) {
                                    String s = policzPp(policzAzh(h));
                                    pp_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewPp);
                                    bpp = true;
                                }
                                if (isEmpty(obwp_val) && !bobwp) {
                                    String s = policzObwp(policzAzh(h));
                                    obwp_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewObwp);
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
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                                if (h_val.getText().toString().equals("") && !bh) {
                                    String s = policzhzPp(pp);
                                    h_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewH);
                                    bh = true;
                                }
                                if (obwp_val.getText().toString().equals("") && !bobwp) {
                                    String s = policzObwp(policzAzPp(pp));
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
                                    String s = policzAzObwp(obwp);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewA);
                                    ba = true;
                                }
                                if (isEmpty(pp_val) && !bpp) {
                                    String s = policzPp(policzAzObwp(obwp));
                                    pp_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewPp);
                                    bpp = true;
                                }
                                if (isEmpty(h_val) && !bh) {
                                    String s = policzhza(policzAzObwp(obwp));
                                    h_val.setText(s);
                                    JavaScript.showFormatted(s, mWebViewH);
                                    bh = true;
                                }
                            }
                            //za malo danych
                            if (isEmpty(a_val) && isEmpty(h_val) && isEmpty(pp_val) && isEmpty(obwp_val)) {
                                x = 1;
                                figura.setImageResource(drawable.trojkaprawidlowy);
                                licz.setEnabled(false);
                                btnSolution.setEnabled(true);
                                imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);
                                Toast.makeText(TrojkatPrawidlowy.this, getString(R.string.notEnough),
                                        Toast.LENGTH_LONG).show();
                            }
                            //wszystko policzone, koniec petli
                            if (!a_val.getText().toString().equals("") &&
                                    !h_val.getText().toString().equals("") &&
                                    !pp_val.getText().toString().equals("") &&
                                    !obwp_val.getText().toString().equals("")
                                    ) {
                                x = 1;
                                figura.setImageResource(drawable.trojkaprawidlowy);
                                licz.setEnabled(false);
                                btnSolution.setEnabled(true);
                                imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);

                                Toast.makeText(TrojkatPrawidlowy.this, getString(R.string.premium),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                        new ProgressBar(view);
                    } catch (Exception e) {
                        System.out.println("emessage " + e.getMessage());
                        Toast.makeText(TrojkatPrawidlowy.this, getString(R.string.ups),
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(TrojkatPrawidlowy.this, getString(R.string.bracket),
                            Toast.LENGTH_LONG).show();
                }
                JavaScript JS = new JavaScript(tekst);
                mWebView.loadDataWithBaseURL("", "" + JS.getTekst(), "text/html", "UTF-8", "");
                Global.WebViewHide(false, mWebView, mWebViewA, mWebViewObwp, mWebViewPp, mWebViewH);
                Global.EditTextHide(true, a_val, pp_val, obwp_val, h_val);
                TabListener refresh = new TabListener();
                if (btnData.getVisibility() == View.VISIBLE) {
                    refresh.refresh(figura, scrollView, mWebView);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.setEmpty(a_val, pp_val, obwp_val, h_val);
                Global.setEmptyWeb(mWebViewA, mWebViewObwp, mWebViewPp, mWebViewH);
                tekst = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");
                Global.EditTextHide(false, a_val, pp_val, obwp_val, h_val);
                Global.WebViewHide(true, mWebViewA, mWebViewObwp, mWebViewPp, mWebViewH);
                licz.setEnabled(true);
                btnSolution.setEnabled(false);
                figura.setImageResource(drawable.trojkaprawidlowy);
                Toast.makeText(TrojkatPrawidlowy.this, getString(R.string.deleted),
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
        String dwa = Wartosc.policz(Wartosc.policz(Wartosc.policz(a, a, "*"), "()\u221a(3)", "*"), "4", "/");
        String solucja = "Obliczanie pola mając a \n\n" +
                "P = [(a^2) * √3] / 4 \n\n" +
                "P = [(" + a + "^2) * √(3)] / 4 \n\n" +
                "P = (" + jeden + ")√(3) / 4 \n\n" +
                "P = " + dwa + "\n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzObwp(String a) {
        String jeden = Wartosc.policz("3", a, "*");
        String solucja = "Obliczanie obwodu mając a \n\n" +
                "ObwP = a * 3 \n\n" +
                "ObwP = " + a + " * 3 \n\n" +
                "ObwP = " + jeden + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzAzh(String h) {
        String jeden = Wartosc.policz(h, "(2)\u221a(3)", "*");
        String dwa = Wartosc.policz(jeden, "3", "/");
        String solucja = "Obliczanie a mając h \n\n" +
                "h = [a * √(3)] / 2 \n\n" +
                "a = [(2)√(3) * h] / 3 \n\n" +
                "a = [(2)√(3) * " + h + "]/3 \n\n" +
                "a = [" + jeden + "] / 3 \n\n" +
                "a = " + dwa + "\n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzAzPp(String Pp) {
        String jeden = Wartosc.policz(Pp, "4", "*");
        String dwa = Wartosc.policz(jeden, "()\u221a(3)", "/");
        String trzy = Wartosc.policz("()\u221a(" + dwa + ")", "1", "*");
        String solucja = "Obliczanie a mając pole \n\n" +
                "P = [(a^2) * √(3)] / 4 \n\n" +
                "4 * P = [(a^2) * √(3)] \n\n" +
                "(4 * P) / √(3) = (a^2) \n\n" +
                "a = √[(4 * P) / √(3)] \n\n" +
                "a = √[(4 * " + Pp + ") / √(3)] \n\n" +
                "a = √[" + jeden + " / √(3)] \n\n" +
                "a = √[" + dwa + "] \n\n" +
                "a = " + trzy + "\n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return trzy;
    }

    private String policzAzObwp(String Obwp) {
        String jeden = Wartosc.policz(Obwp, "3", "/");
        String solucja = "Obliczanie a mając obwód \n\n" +
                "ObwP = a * 3 \n\n" +
                "a = ObwP / 3 \n\n" +
                "a = " + Obwp + " / 3 \n\n" +
                "a = " + jeden + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzhza(String a) {
        String jeden = Wartosc.policz(a, "()\u221a(3)", "*");
        String dwa = Wartosc.policz(jeden, "2", "/");
        String solucja = "Obliczanie h mając a \n\n" +
                "h = [a * √(3)] / 2 \n\n" +
                "h = [" + a + " * √(3)] / 2 \n\n" +
                "h = (" + jeden + ") / 2 \n\n" +
                "h = " + dwa + "\n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzhzPp(String Pp) {
        String jeden = Wartosc.policz("3", Pp, "*");
        String dwa = Wartosc.policz(jeden, "()\u221a(3)", "/");
        String trzy = Wartosc.policz("()\u221a(" + dwa + ")", "1", "*");
        String solucja = "Obliczanie h mając pole \n\n" +
                "h = [a * √(3)] / 2 \n\n" +
                "2 * h = a * √(3) \n\n" +
                "a = (2 * h) / √(3) \n\n" +
                "a = [(2)√(3) * h] / 3 \n\n" +
                "P = [(a^2) * √(3)] / 4 \n\n" +
                "P = {[(12 * (h^2)) / 9] * √(3)} / 4 \n\n" +
                "P = [(h^2) * √(3)] / 3 \n\n" +
                "3 * P = (h^2) * √(3) \n\n" +
                "(3 * P) / √(3) = (h^2) \n\n" +
                "h = √[(3 * P) / √(3)] \n\n" +
                "h = √[(" + jeden + ") / √(3)] \n\n" +
                "h = √(" + dwa + ") \n\n" +
                "h = " + trzy + "\n\n" +
                "*===========================*\n\n";
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
