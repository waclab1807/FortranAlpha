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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by waclab1807 on 31.03.15.
 */

public class Trygonometria3 extends Activity implements OnFocusChangeListener {

    private Button licz;
    private Button clear;
    private Button sqrtbtn;
    private Button powbtn;
    private Button btnReview;
    private Button btnData;
    private Button btnSolution;
    private EditText lastFocused;
    private String tekst;
    private WebView mWebView;
    private WebView mWebViewSinA;
    private ImageView figura;
    private ScrollView scrollView;
    private LinearLayout buttons;
    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;

    private String wybor;
    private String wybor2;
    private String wybor3;
    private String wybor4;
    private String wybor5;
    private String wartosc;
    private String fun1 = "";
    private String fun2 = "";
    private String oper = "";
    private String wynik;

    private String Sin = "";
    private String Cos = "";
    private String Tg = "";
    private String Ctg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trygonometria3);
        Global.mContext = this.getBaseContext();

        licz = (Button) findViewById(R.id.magic);
        clear = (Button) findViewById(R.id.clear);
        sqrtbtn = (Button) findViewById(R.id.sqrtbtn);
        powbtn = (Button) findViewById(R.id.powbtn);
        figura = (ImageView) findViewById(R.id.imageView);
        btnReview = (Button) findViewById(R.id.btnReview);
        btnData = (Button) findViewById(R.id.btnData);
        btnSolution = (Button) findViewById(R.id.btnSolution);
        scrollView = (ScrollView) findViewById(R.id.dwa);
        buttons = (LinearLayout) findViewById(R.id.buttons);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);

        List<String> list = new ArrayList<String>();
        list.add("sin");
        list.add("cos");
        list.add("tg");
        list.add("ctg");
        List<String> list1 = new ArrayList<String>();
        list1.add("30");
        list1.add("45");
        list1.add("60");
        List<String> list2 = new ArrayList<String>();
        list2.add("+");
        list2.add("-");
        list2.add("*");
        list2.add("/");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);

        spinner.setAdapter(dataAdapter);
        spinner.setSelection(0);
        spinner2.setAdapter(dataAdapter1);
        spinner2.setSelection(0);
        spinner3.setAdapter(dataAdapter2);
        spinner3.setSelection(0);
        spinner4.setAdapter(dataAdapter);
        spinner4.setSelection(0);
        spinner5.setAdapter(dataAdapter1);
        spinner5.setSelection(0);

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        wybor = spinner.getSelectedItem().toString();
                        switch (wybor) {
                            case "sin":
                                figura.setImageResource(R.drawable.tryg_sin);
                                break;
                            case "cos":
                                figura.setImageResource(R.drawable.tryg_cos);
                                break;
                            case "tg":
                                figura.setImageResource(R.drawable.tryg_tg);
                                break;
                            case "ctg":
                                figura.setImageResource(R.drawable.tryg_ctg);
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                    }
                }
        );

        spinner2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        wybor2 = spinner2.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                    }
                }
        );
        spinner3.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        wybor3 = spinner3.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                    }
                }
        );
        spinner4.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        wybor4 = spinner4.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                    }
                }
        );
        spinner5.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        wybor5 = spinner5.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                    }
                }
        );

        if (btnData.getVisibility() == View.VISIBLE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
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

        final InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        new TabListener(buttons, imm, btnReview, btnData, btnSolution, figura, scrollView, mWebView);

        figura.setImageResource(R.drawable.troj_pros);
        btnSolution.setEnabled(false);
        btnReview.setTypeface(null, Typeface.BOLD);
        btnReview.setTextSize(30);
        btnReview.setBackgroundColor(Color.TRANSPARENT);

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tekst = "";
                //licz.setTypeface(null, Typeface.NORMAL);
                //clear.setTypeface(null, Typeface.BOLD);
                //spinner.setEnabled(false);

                try {
                    fun1 = wybor + wybor2;
                    fun2 = wybor4 + wybor5;
                    oper = wybor3;

                    switch (oper) {
                        case "+":
                            String a = "()√(3)";
                            System.out.println("$$$$$$1 " + Wartosc.policz(a, "(()√(2))/2", "+"));
//                            System.out.println("$$$$$$2 " + Wartosc.policz(a, "√(2)/2", "-"));
//                            System.out.println("$$$$$$3 " + Wartosc.policz(a, "√(2)/2", "*"));
//                            System.out.println("$$$$$$4 " + Wartosc.policz(a, "√(2)/2", "/"));

//                            System.out.println("$$$$$$5 " + Wartosc.policz(a, "√(3)/2", "+"));
//                            System.out.println("$$$$$$6 " + Wartosc.policz(a, "√(3)/2", "-"));
//                            System.out.println("$$$$$$7 " + Wartosc.policz(a, "√(3)/2", "*"));
//                            System.out.println("$$$$$$8 " + Wartosc.policz(a, "√(3)/2", "/"));

//                            System.out.println("$$$$$$1 " + Wartosc.policz(a, "√(3)/3", "+"));
//                            System.out.println("$$$$$$2 " + Wartosc.policz(a, "√(3)/3", "-"));
//                            System.out.println("$$$$$$3 " + Wartosc.policz(a, "√(3)/3", "*"));
//                            System.out.println("$$$$$$4 " + Wartosc.policz(a, "√(3)/3", "/"));
//
//                            System.out.println("$$$$$$5 " + Wartosc.policz(a, "1", "+"));
//                            System.out.println("$$$$$$6 " + Wartosc.policz(a, "1", "-"));
//                            System.out.println("$$$$$$7 " + Wartosc.policz(a, "1", "*"));
//                            System.out.println("$$$$$$8 " + Wartosc.policz(a, "1", "/"));

//                            System.out.println("$$$$$$1 " + Wartosc.policz(a, "√(3)", "+"));
//                            System.out.println("$$$$$$2 " + Wartosc.policz(a, "√(3)", "-"));
//                            System.out.println("$$$$$$3 " + Wartosc.policz(a, "√(3)", "*"));
//                            System.out.println("$$$$$$4 " + Wartosc.policz(a, "√(3)", "/"));

                            wynik = "8";
                            //wynik = Wartosc.policz(zamienFunkcje(fun1),zamienFunkcje(fun2),"+");
                            break;
                        case "-":
                            wynik = Wartosc.policz(zamienFunkcje(fun1),zamienFunkcje(fun2),"-");
                            break;
                        case "*":
                            wynik = Wartosc.policz(zamienFunkcje(fun1),zamienFunkcje(fun2),"*");
                            break;
                        case "/":
                            wynik = Wartosc.policz(zamienFunkcje(fun1),zamienFunkcje(fun2),"/");
                            break;
                    }
                    //new ProgressBar(view);
                } catch (Exception e) {
                    System.out.println("emessage " + e.getMessage());
                    Toast.makeText(Trygonometria3.this, getString(R.string.ups),
                            Toast.LENGTH_LONG).show();
                }

                figura.setImageResource(R.drawable.troj_pros);
                //licz.setEnabled(false);
                btnSolution.setEnabled(true);
                //imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);
                Toast.makeText(Trygonometria3.this, getString(R.string.premium),
                        Toast.LENGTH_LONG).show();

                JavaScript.showFormatted(wynik, mWebViewSinA);

                JavaScript JS = new JavaScript(tekst);
                mWebView.loadDataWithBaseURL("", "" + JS.getTekst(), "text/html", "UTF-8", "");
                mWebView.setVisibility(View.VISIBLE);

                TabListener refresh = new TabListener();
                if (btnData.getVisibility() == View.VISIBLE) {
                    refresh.refresh(figura, scrollView, mWebView);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.setEmptyWeb(mWebViewSinA);
                tekst = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");
                licz.setEnabled(true);
                btnSolution.setEnabled(false);
                spinner.setEnabled(true);
                figura.setImageResource(R.drawable.troj_pros);
                clear.setTypeface(null, Typeface.NORMAL);
                licz.setTypeface(null, Typeface.BOLD);
                Toast.makeText(Trygonometria3.this, getString(R.string.deleted),
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

    public String zamienFunkcje(String fun) {
        String wartosc="";
        switch (fun){
            case "sin30":
                wartosc = "1/2";
                break;
            case "sin45":
                wartosc = "()√(2)/2";
                break;
            case "sin60":
                wartosc = "()√(3)/2";
                break;
            case "cos30":
                wartosc = "()√(3)/2";
                break;
            case "cos45":
                wartosc = "()√(2)/2";
                break;
            case "cos60":
                wartosc = "1/2";
                break;
            case "tg30":
                wartosc = "√(3)/3";
                break;
            case "tg45":
                wartosc = "1";
                break;
            case "tg60":
                wartosc = "√(3)";
                break;
            case "ctg30":
                wartosc = "√(3)";
                break;
            case "ctg45":
                wartosc = "1";
                break;
            case "ctg60":
                wartosc = "√(3)/3";
                break;
        }
        return wartosc;
    }

    private void policzZsin(String sin) {
        Sin = sin;
        String jeden = Wartosc.policz(sin, sin, "*");
        String dwa = Wartosc.policz("1", jeden, "-");
        String trzy = Wartosc.policz("1", "()√(" + dwa + ")", "*");
        Cos = trzy;
        String cztery = Wartosc.policz(sin, trzy, "/");
        Tg = cztery;
        String piec = Wartosc.policz(trzy, sin, "/");
        Ctg = piec;
        String solucja1 = "<center>*============================*</center><br>" +
                "$${{sin}^2}+{{cos}^2} = 1$$<br>" +
                "$${{cos}^2} = 1 - {{sin}^2}$$<br>" +
                "$${cos} = {√{1 - {{sin}^2}}}$$<br>" +
                "$${cos} = {√{1 - {{" + Wartosc.formatuj(sin) + "}^2}}}$$<br>" +
                "$${cos} = {√{1 - {" + Wartosc.formatuj(jeden) + "}}}$$<br>" +
                "$${cos} = {√{" + Wartosc.formatuj(dwa) + "}}$$<br>" +
                "$${cos} = {" + Wartosc.formatuj(trzy) + "}$$<br>" +
                "<center>*============================*</center><br>" +
                "$${tg} = {sin}/{cos}$$<br>" +
                "$${tg} = {" + Wartosc.formatuj(sin) + "}/{" + Wartosc.formatuj(trzy) + "}$$<br>" +
                "$${tg} = {" + Wartosc.formatuj(cztery) + "}$$<br>" +
                "<center>*============================*</center><br>" +
                "$${ctg} = {cos}/{sin}$$<br>" +
                "$${ctg} = {" + Wartosc.formatuj(trzy) + "}/{" + Wartosc.formatuj(sin) + "}$$<br>" +
                "$${ctg} = {" + Wartosc.formatuj(piec) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
    }

    private void policzZcos(String cos) {
        Cos = cos;
        String jeden = Wartosc.policz(cos, cos, "*");
        String dwa = Wartosc.policz("1", jeden, "-");
        String trzy = Wartosc.policz("1", "()√(" + dwa + ")", "*");
        Sin = trzy;
        String cztery = Wartosc.policz(trzy, cos, "/");
        Tg = cztery;
        String piec = Wartosc.policz(cos, trzy, "/");
        Ctg = piec;
        String solucja1 = "<center>*============================*</center><br>" +
                "$${{sin}^2}+{{cos}^2} = 1$$<br>" +
                "$${{sin}^2} = 1 - {{cos}^2}$$<br>" +
                "$${sin} = {√{1 - {{cos}^2}}}$$<br>" +
                "$${sin} = {√{1 - {{" + Wartosc.formatuj(cos) + "}^2}}}$$<br>" +
                "$${sin} = {√{1 - {" + Wartosc.formatuj(jeden) + "}}}$$<br>" +
                "$${sin} = {√{" + Wartosc.formatuj(dwa) + "}}$$<br>" +
                "$${sin} = {" + Wartosc.formatuj(trzy) + "}$$<br>" +
                "<center>*============================*</center><br>" +
                "$${tg} = {sin}/{cos}$$<br>" +
                "$${tg} = {" + Wartosc.formatuj(trzy) + "}/{" + Wartosc.formatuj(cos) + "}$$<br>" +
                "$${tg} = {" + Wartosc.formatuj(cztery) + "}$$<br>" +
                "<center>*============================*</center><br>" +
                "$${ctg} = {cos}/{sin}$$<br>" +
                "$${ctg} = {" + Wartosc.formatuj(cos) + "}/{" + Wartosc.formatuj(trzy) + "}$$<br>" +
                "$${ctg} = {" + Wartosc.formatuj(piec) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
    }

    private void policzZtg(String tg) {
        Tg = tg;
        String jeden = Wartosc.policz("1", tg, "/");
        Ctg = jeden;
        String dwa = Wartosc.policz(tg, tg, "*");
        String trzy = Wartosc.policz(dwa, "1", "+");
        String cztery = Wartosc.policz("1", trzy, "/");
        String piec = Wartosc.policz("1", "()√(" + cztery + ")", "*");
        Cos = piec;
        String szesc = Wartosc.policz(tg, piec, "*");
        Sin = szesc;
        String solucja1 = "<center>*============================*</center><br>" +
                "$${ctg} = {1}/{tg}$$<br>" +
                "$${ctg} = {1}/{" + Wartosc.formatuj(tg) + "}$$<br>" +
                "$${ctg} = {" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center><br>" +

                "$${tg} = {sin}/{cos}$$<br>" +
                "$${sin} = {tg}*{cos}$$<br>" +
                "$${{sin}^2} = {{{tg}^2}*{{cos}^2}}$$<br>" +
                "$${{sin}^2}+{{cos}^2} = 1$$<br>" +
                "$${{{tg}^2}*{{cos}^2}}+{{cos}^2} = 1$$<br>" +
                "$${({{tg}^2}+1)*{{cos}^2}} = 1$$<br>" +
                "$${{cos}^2} = {1}/{({{tg}^2}+1)}$$<br>" +
                "$${cos} = {√{{1}/{({{tg}^2}+1)}}}$$<br>" +
                "$${cos} = {√{{1}/{({{" + Wartosc.formatuj(tg) + "}^2}+1)}}}$$<br>" +
                "$${cos} = {√{{1}/{({" + Wartosc.formatuj(dwa) + "}+1)}}}$$<br>" +
                "$${cos} = {√{{1}/{" + Wartosc.formatuj(trzy) + "}}}$$<br>" +
                "$${cos} = {√{" + Wartosc.formatuj(cztery) + "}}$$<br>" +
                "$${cos} = {" + Wartosc.formatuj(piec) + "}$$<br>" +
                "<center>*============================*</center><br>" +

                "$${tg} = {sin}/{cos}$$<br>" +
                "$${sin} = {tg}*{cos}$$<br>" +
                "$${sin} = {" + Wartosc.formatuj(tg) + "}*{" + Wartosc.formatuj(piec) + "}$$<br>" +
                "$${sin} = {" + Wartosc.formatuj(szesc) + "}$$<br>" +

                "<center>*============================*</center>";
        if (!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
    }

    private void policzZctg(String ctg) {
        Ctg = ctg;
        String jeden = Wartosc.policz("1", ctg, "/");
        Tg = jeden;
        String dwa = Wartosc.policz(ctg, ctg, "*");
        String trzy = Wartosc.policz(dwa, "1", "+");
        String cztery = Wartosc.policz("1", trzy, "/");
        String piec = Wartosc.policz("1", "()√(" + cztery + ")", "*");
        Sin = piec;
        String szesc = Wartosc.policz(ctg, piec, "*");
        Cos = szesc;
        String solucja1 = "<center>*============================*</center><br>" +
                "$${tg} = {1}/{ctg}$$<br>" +
                "$${tg} = {1}/{" + Wartosc.formatuj(ctg) + "}$$<br>" +
                "$${tg} = {" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center><br>" +

                "$${ctg} = {cos}/{sin}$$<br>" +
                "$${cos} = {ctg}*{sin}$$<br>" +
                "$${{cos}^2} = {{{ctg}^2}*{{sin}^2}}$$<br>" +
                "$${{sin}^2}+{{cos}^2} = 1$$<br>" +
                "$${{{ctg}^2}*{{sin}^2}}+{{sin}^2} = 1$$<br>" +
                "$${({{ctg}^2}+1)*{{sin}^2}} = 1$$<br>" +
                "$${{sin}^2} = {1}/{({{ctg}^2}+1)}$$<br>" +
                "$${sin} = {√{{1}/{({{ctg}^2}+1)}}}$$<br>" +
                "$${sin} = {√{{1}/{({{" + Wartosc.formatuj(ctg) + "}^2}+1)}}}$$<br>" +
                "$${sin} = {√{{1}/{({" + Wartosc.formatuj(dwa) + "}+1)}}}$$<br>" +
                "$${sin} = {√{{1}/{" + Wartosc.formatuj(trzy) + "}}}$$<br>" +
                "$${sin} = {√{" + Wartosc.formatuj(cztery) + "}}$$<br>" +
                "$${sin} = {" + Wartosc.formatuj(piec) + "}$$<br>" +
                "<center>*============================*</center><br>" +

                "$${tg} = {sin}/{cos}$$<br>" +
                "$${cos} = {ctg}*{sin}$$<br>" +
                "$${cos} = {" + Wartosc.formatuj(ctg) + "}*{" + Wartosc.formatuj(piec) + "}$$<br>" +
                "$${cos} = {" + Wartosc.formatuj(szesc) + "}$$<br>" +

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
