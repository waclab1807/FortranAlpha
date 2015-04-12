package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by waclab1807 on 31.03.15.
 */

public class Kwadrat extends Activity implements OnFocusChangeListener {

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
    private ImageView figura;

    String a;
    String pp;
    String D;
    String obwp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kwadrat);

        Global.mContext = this.getBaseContext();
        //Global global = new Global(getBaseContext());
/*
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
*/
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.setBackgroundColor(0xff0);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        pp_val = (EditText) findViewById(R.id.pp);;
        a_val = (EditText) findViewById(R.id.a_val);
        D_val = (EditText) findViewById(R.id.D_val);
        obwp_val = (EditText) findViewById(R.id.obwp);
        licz = (Button) findViewById(R.id.licz);
        clear = (Button) findViewById(R.id.clear);
        sqrtbtn = (Button) findViewById(R.id.btnsqrt);
        powbtn = (Button) findViewById(R.id.btnpow);
        solutionbtn = (Button) findViewById(R.id.solutionbtn);
        solution = (TextView) findViewById(R.id.solution);
        figura = (ImageView) findViewById(R.id.imageView);

        a_val.setOnFocusChangeListener(this);
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
        });

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
                                    /*String s = policzPp(a);
                                    pp_val.setText(Html.fromHtml("<html><head>"
                                            + "<link rel='stylesheet' href='file:///android_asset/mathscribe/jqmath-0.4.0.css'>"
                                            + "<script src = 'file:///android_asset/mathscribe/jquery-1.4.3.min.js'></script>"
                                            + "<script src = 'file:///android_asset/mathscribe/jqmath-etc-0.4.2.min.js'></script>"
                                            + "</head><body>"
                                            + "<script>var s =   " +
                                            "'"+s+"';" +
                                            "M.parseMath(s);document.body.style.fontSize = \"20pt\";document.write(s);</script> " +
                                            "</body>"));*/
                                    pp_val.setText(policzPp(a));
                                    bpp = true;
                                }
                                if (isEmpty(obwp_val) && !bobwp) {
                                    obwp_val.setText(policzObwp(a));
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
                        Toast.makeText(Kwadrat.this, "Ups! Coś poszło nie tak :/ Sprawdź wprowadzone dane. ",
                                Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Kwadrat.this, "Liczba nawiasów otwierających nie równa się \nliczbie nawiasów zamykających! Popraw to, prosze.",
                            Toast.LENGTH_LONG).show();
                }
                System.out.println("$$$$$$$$$ " + tekst1);
                if(tekst1.equals("")){
                    tekst1 = "<center>Nie ma nic do liczenia!</center>";
                }
                String js = "<html><head>"
                        + "<link rel='stylesheet' href='file:///android_asset/mathscribe/jqmath-0.4.0.css'>"
                        + "<script src = 'file:///android_asset/mathscribe/jquery-1.4.3.min.js'></script>"
                        + "<script src = 'file:///android_asset/mathscribe/jqmath-etc-0.4.2.min.js'></script>"
                        + "</head><body>"
                        + "<script>var s =   " +
                        "'"+tekst1+"';" +
                        "M.parseMath(s);document.body.style.fontSize = \"20pt\";document.write(s);</script> " +
                        "</body>";
                mWebView.loadDataWithBaseURL("", js, "text/html", "UTF-8", "");
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

                Toast.makeText(Kwadrat.this, "Skasowane!",
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
                if(!solution.equals("")){
                    solution.setText("");
                }
                solution.setText(tekst);
                mWebView.setVisibility(View.VISIBLE);
            }
        });



    }
    public Boolean isEmpty(EditText x){
        if(x.getText().toString().equals("")){
            return true;
        }else{
            return false;
        }
    }

    private String policzPp(String a) {
        String jeden = Wartosc.policz(a,a,"*");
        System.out.println("policzPp "+a);
        String solucja = "Obliczanie pola mając a \n\n" +
                "P = a^2 \n\n" +
                "P = " + a + "^2 \n\n" +
                "P = " + jeden + "\n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie pola mając a</b></center><br>" +
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
        String solucja = "Obliczanie a mając przekątną \n\n" +
                "d = a * √(2) \n\n" +
                "a = d / √(2) \n\n" +
                "a = [d * √(2)] / 2 \n\n" +
                "a = ["+D+" * √(2)] / 2 \n\n" +
                "a = ("+dwa+") / 2 \n\n" +
                "a = "+piec+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie a mając przekątną</b></center><br>" +
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
        String solucja = "Obliczanie przekątnej mając a \n\n" +
                "d = a * √(2) \n\n" +
                "d = "+a+" * √(2) \n\n" +
                "d = "+jeden+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie przekątnej mając a</b></center><br>" +
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
        String solucja = "Obliczanie obwodu mając a \n\n" +
                "ObwP = 4 * a \n\n" +
                "ObwP = 4 * "+a+" \n\n" +
                "ObwP = "+jeden+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie obwodu mając a</b></center><br>" +
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
        String solucja = "Obliczanie a mając pole \n\n" +
                "P = a^2 \n\n" +
                "a = √(P) \n\n" +
                "a = √("+Pp+") \n\n" +
                "a = " + trzy + "\n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie a mając pole</b></center><br>" +
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
        String solucja = "Obliczanie a mając obwód podstawy \n\n" +
                "ObwP = 4 * a \n\n" +
                "a = ObwP / 4 \n\n" +
                "a = "+Obwp+" / 4 \n\n" +
                "a = "+jeden+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie a mając obwód podstawy</b></center><br>" +
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
        String ktoryElement = "";
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
}
