package pl.wlabuda.fortranalpha;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by waclab1807 on 31.03.15.
 */

public class Kwadrat extends Activity implements OnFocusChangeListener, TabListener{

    private Button licz;
    private Button clear;
    private Button solutionbtn;
    private Button sqrtbtn;
    private Button powbtn;
    private EditText pp_val;
    private EditText a_val;
    private EditText D_val;
    private EditText obwp_val;
    private TextView solution;
    private EditText lastFocused;
    public static String tekst = "";
    public static String tekst1 = "";
    private WebView mWebView;
    private WebView mWebView1;
    private ImageView figura;

    String a;
    String pp;
    String D;
    String obwp;

    List<Fragment> fragList = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        float x_screen = getResources().getDisplayMetrics().density;;
        int y_screen = getWindowManager().getDefaultDisplay().getWidth();

        boolean layout = true;
        if(layout) {

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            ActionBar bar = getActionBar();
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            Tab tab0 = bar.newTab();
            tab0.setText("Podgląd");
            tab0.setTabListener(this);
            bar.addTab(tab0);
            Tab tab1 = bar.newTab();
            tab1.setText("Dane");
            tab1.setTabListener(this);
            bar.addTab(tab1);
            Tab tab2 = bar.newTab();
            tab2.setText("Rozwiązanie");
            tab2.setTabListener(this);
            bar.addTab(tab2);
            setContentView(R.layout.kwadrat);
        }else{
            setContentView(R.layout.kwadrat);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        Global.mContext = this.getBaseContext();
        //Global global = new Global(getBaseContext());
/*
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

*/      /*mWebView1 = (WebView) findViewById(R.id.webView1);
        mWebView1.setVisibility(View.GONE);
        mWebView1.setBackgroundColor(0xff0);
        WebSettings webSettings1 = mWebView1.getSettings();
        webSettings1.setJavaScriptEnabled(true);

        mWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = mWebView.getSettings();
        mWebView.setBackgroundColor(0xff0);
        webSettings.setJavaScriptEnabled(true);*/


        pp_val = (EditText) findViewById(R.id.pp);
        a_val = (EditText) findViewById(R.id.a);
        D_val = (EditText) findViewById(R.id.D);
        obwp_val = (EditText) findViewById(R.id.obwp);
        licz = (Button) findViewById(R.id.licz);
        clear = (Button) findViewById(R.id.clear);
        sqrtbtn = (Button) findViewById(R.id.btnsqrt);
        powbtn = (Button) findViewById(R.id.btnpow);
        solutionbtn = (Button) findViewById(R.id.solutionbtn);
        solution = (TextView) findViewById(R.id.solution);
        figura = (ImageView) findViewById(R.id.imageView);

        /*a_val.setOnFocusChangeListener(this);
        D_val.setOnFocusChangeListener(this);
        pp_val.setOnFocusChangeListener(this);
        obwp_val.setOnFocusChangeListener(this);

        pp_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(R.drawable.kwadratp);
                return false;
            }
        });
        a_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(R.drawable.kwadrata);
                return false;
            }
        });
        D_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(R.drawable.kwadratd);
                return false;
            }
        });
        obwp_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(R.drawable.kwadratobw);
                return false;
            }
        });*/

        //a_val.setText(""+x_screen);
        //pp_val.setText(y_screen);

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean bD = false;
                boolean bpp = false;
                boolean bobwp = false;

                solution.setText("");
                tekst = "";
                tekst1 = "";

                //todo "1-2√3+4*2+2+2√3-4√2+2" pole 5+1
                //System.out.println("%%%%%%%%% " + Wartosc.obliczWyrazenie("4"));

                int x = 0; //koniec petli, wszystko policzone

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
                                    String s = policzPp(a);
                                    pp_val.setText(s);
                                    s = s.replace("(","{");
                                    s = s.replace(")","}");
                                    s = "$$"+s+"$$";
                                    JavaScript JS = new JavaScript(s);
                                    mWebView1.loadDataWithBaseURL("", ""+JS.getTekst(), "text/html", "UTF-8", "");
                                    pp_val.setVisibility(View.GONE);
                                    mWebView1.setVisibility(View.VISIBLE);
                                    bpp = true;
                                }
                                if (isEmpty(obwp_val) && !bobwp) {
                                    String s = policzObwp(a);
                                    obwp_val.setVisibility(View.GONE);
                                    bobwp = true;
                                }
                                if (isEmpty(D_val) && !bD) {
                                    D_val.setText(policzD(a));
                                    bD = true;
                                }
                            } else {
                                if (!isEmpty(pp_val)) {
                                    System.out.println("^^^^^^^^2");
                                    pp = pp_val.getText().toString();
                                    bpp = true;
                                    a_val.setText(policzAzPp(pp));
                                }
                                if (!isEmpty(D_val)) {
                                    System.out.println("^^^^^^^^7");
                                    D = D_val.getText().toString();
                                    bD = true;
                                    a_val.setText(policzAzD(D));
                                }
                                if (!isEmpty(obwp_val)) {
                                    System.out.println("^^^^^^^^0");
                                    obwp = obwp_val.getText().toString();
                                    bobwp = true;
                                    a_val.setText(policzAzObwp(obwp));
                                }
                            }
                            //wszystko policzone, koniec petli
                            if (!a_val.getText().toString().equals("") &&
                                    !pp_val.getText().toString().equals("") &&
                                    !obwp_val.getText().toString().equals("") &&
                                    !D_val.getText().toString().equals("")
                                    ) {
                                x = 1;
                                Toast.makeText(Kwadrat.this, "Wszystko jest już policzone :)\nSkorzystaj z konta premium aby zobaczyć rozwiązanie",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("emessage " + e.getMessage());
                        Toast.makeText(Kwadrat.this, getString(R.string.ups),
                                Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Kwadrat.this, getString(R.string.bracket),
                            Toast.LENGTH_LONG).show();
                }
                System.out.println("$$$$$$$$$ " + tekst1);
                if(tekst1.equals("")){
                    tekst1 = "<center>"+getString(R.string.notEnough)+"</center>";
                }
                JavaScript JS = new JavaScript(tekst1);
                mWebView.loadDataWithBaseURL("", ""+ JS.getTekst(), "text/html", "UTF-8", "");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a_val.setText("");
                D_val.setText("");
                pp_val.setText("");
                obwp_val.setText("");
                solution.setText("");
                tekst = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");
                mWebView1.setVisibility(View.GONE);
                pp_val.setVisibility(View.VISIBLE);
                Toast.makeText(Kwadrat.this, getString(R.string.deleted),
                        Toast.LENGTH_LONG).show();
            }
        });
        sqrtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lastFocused.setText("()\u221a()");
                //lastFocused.setText(lastFocused.getText() + "()\u221a()");
                String wacek = "()\u221a()";
                System.out.println("lastFocused" + lastFocused.getSelectionStart());
                lastFocused.append(wacek);
                lastFocused.setSelection(5);
            }
        });
        powbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastFocused.setText("()^()");
                lastFocused.setSelection(1);
            }
        });
        solutionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //solution
                solution.setMovementMethod(new ScrollingMovementMethod());
                if(solution.getText()!=""){
                    solution.setText("");
                }
                solution.setText(tekst);
                mWebView.setVisibility(View.VISIBLE);
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
                "$$P={({"+Wartosc.formatuj(a)+"})^2}$$<br>" +
                "$$P={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        if(!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        if(!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        if(!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        if(!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return trzy;
    }

    private String policzAzObwp(String Obwp){
        String jeden = Wartosc.policz(Obwp,"4","/");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczAzObwp)+"</b></center><br>" +
                "$$ObwP={4*a}$$<br>" +
                "$$a={ObwP/4}$$<br>" +
                "$$a={{"+Wartosc.formatuj(Obwp)+"}/4}$$<br>" +
                "$$a={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        //String ktoryElement = "";
        switch (item.getItemId()) {
            case R.id.item1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder
                        .setTitle("O autorze:")
                        .setMessage("Wacław Łabuda \ne-mail: waclab1807@gmail.com \nPolska/Nowy Sącz")
                        .setIcon(R.drawable.logo)
                        .setPositiveButton("OK", null)
                        .show();
                break;
            case R.id.item2:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2
                        .setTitle("Plany na przyszłość:")
                        .setMessage("Kąty alfa, beta itd. \n" +
                                "Dynamiczne oznaczenia pól, które można policzyć, \n" +
                                "Wbudowany kalkulator, \n" +
                                "Wiele, wiele innych...")
                        .setIcon(R.drawable.logo)
                        .setPositiveButton("OK", null)
                        .show();
                break;
            case R.id.item3:
                Toast.makeText(Kwadrat.this, "W budowie...",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.item4:
                //finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                //System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus)  {
        if(hasFocus){
            lastFocused = (EditText)v;
        }
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        Fragment f = null;
        TabFragment tf = null;

        if (fragList.size() > tab.getPosition())
            fragList.get(tab.getPosition());

        if (f == null) {
            tf = new TabFragment();
            Bundle data = new Bundle();
            data.putInt("idx",  tab.getPosition());
            tf.setArguments(data);
            fragList.add(tf);
        }
        else
            tf = (TabFragment) f;

        ft.replace(android.R.id.content, tf);
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        if (fragList.size() > tab.getPosition()) {
            ft.remove(fragList.get(tab.getPosition()));
        }
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }
}
