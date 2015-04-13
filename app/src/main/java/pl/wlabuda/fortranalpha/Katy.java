package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pl.wlabuda.fortranalpha.R.drawable;
import pl.wlabuda.fortranalpha.R.id;
import pl.wlabuda.fortranalpha.R.layout;

public class Katy extends Activity implements OnFocusChangeListener {

    private Button licz;
    private Button clear;
    private Button solutionbtn;
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
    private TextView aclackable;
    private TextView bclackable;
    private TextView cclackable;
    private TextView dclackable;
    private TextView eclackable;
    private TextView fclackable;
    private TextView gclackable;
    private TextView hclackable;
    private ImageView figura;
    private EditText lastFocused;
    public static String tekst = "";
    public static String tekst1 = "";
    private WebView mWebView;

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

        //GraniastoslupPrawidlowyTrojkatny.context = getApplicationContext();
        Global.mContext = this.getBaseContext();
        //Global global1 = new Global(getBaseContext());

        mWebView = (WebView) findViewById(id.webView2);
        mWebView.setBackgroundColor(0xff0);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
/*
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
*/
        a_val = (EditText) findViewById(id.a_val);
        b_val = (EditText) findViewById(id.b_val);
        c_val = (EditText) findViewById(id.c_val);
        d_val = (EditText) findViewById(id.d_val);
        e_val = (EditText) findViewById(id.e_val);
        f_val = (EditText) findViewById(id.f_val);
        g_val = (EditText) findViewById(id.g_val);
        h_val = (EditText) findViewById(id.h_val);
        licz = (Button) findViewById(id.licz);
        clear = (Button) findViewById(id.clear);
        sqrtbtn = (Button) findViewById(id.btnsqrt);
        powbtn = (Button) findViewById(id.btnpow);
        solutionbtn = (Button) findViewById(id.solutionbtn);
        aclackable = (TextView) findViewById(id.a);
        bclackable = (TextView) findViewById(id.e_text);
        cclackable = (TextView) findViewById(id.d);
        dclackable = (TextView) findViewById(id.c_text);
        eclackable = (TextView) findViewById(id.c_text);
        fclackable = (TextView) findViewById(id.f);
        gclackable = (TextView) findViewById(id.g);
        hclackable = (TextView) findViewById(id.c_text);
        figura = (ImageView) findViewById(id.imageView);

        aclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.katya);
                a_val.requestFocus();
            }
        });
        bclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.katyb);
                b_val.requestFocus();
            }
        });
        cclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.katyc);
                c_val.requestFocus();
            }
        });
        dclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.katyd);
                d_val.requestFocus();
            }
        });
        eclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.katye);
                e_val.requestFocus();
            }
        });
        fclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.katyf);
                f_val.requestFocus();
            }
        });
        gclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.katyg);
                g_val.requestFocus();
            }
        });
        hclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.katyh);
                h_val.requestFocus();
            }
        });

        a_val.setOnFocusChangeListener(this);
        b_val.setOnFocusChangeListener(this);
        c_val.setOnFocusChangeListener(this);
        d_val.setOnFocusChangeListener(this);
        e_val.setOnFocusChangeListener(this);
        f_val.setOnFocusChangeListener(this);
        g_val.setOnFocusChangeListener(this);
        h_val.setOnFocusChangeListener(this);

        a_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.katya);
                return false;
            }
        });
        b_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.katyb);
                return false;
            }
        });
        c_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.katyc);
                return false;
            }
        });
        d_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.katyd);
                return false;
            }
        });
        e_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.katye);
                return false;
            }
        });
        f_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.katyf);
                return false;
            }
        });
        g_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.katyg);
                return false;
            }
        });
        h_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.katyh);
                return false;
            }
        });

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tekst1 = "";
                figura.setImageResource(drawable.katy);
                //todo schowac klawiature

                int x = 0; //koniec petli, wszystko policzone
                int y = 0;
                a = a_val.getText().toString();
                d = d_val.getText().toString();
                e = e_val.getText().toString();
                h = h_val.getText().toString();
                b = b_val.getText().toString();
                c = c_val.getText().toString();
                f = f_val.getText().toString();
                g = g_val.getText().toString();

                boolean test = false;
                try{
                    while (!test) {
                        System.out.println("&&&start " + x + " " + y);
                        if (!isEmpty(a_val) || !isEmpty(d_val) || !isEmpty(e_val) || !isEmpty(h_val)){
                            System.out.println("&&&1 ");
                            if(isEmpty(a_val)){
                                if(isEmpty(d_val)){
                                    if (isEmpty(e_val)){
                                        System.out.println("&&&1.1 ");
                                        a = h;
                                        a_val.setText(h);
                                        d = h;
                                        d_val.setText(h);
                                        e = h;
                                        e_val.setText(h);
                                        policzJeden(a,d,e,h);
                                    }else{
                                        System.out.println("&&&1.2 ");
                                        a = e;
                                        a_val.setText(e);
                                        d = e;
                                        d_val.setText(e);
                                        h = e;
                                        h_val.setText(e);
                                        policzJeden(a,d,e,h);
                                    }
                                }else{
                                    System.out.println("&&&1.3 ");
                                    a = d;
                                    a_val.setText(d);
                                    e = d;
                                    e_val.setText(d);
                                    h = d;
                                    h_val.setText(d);
                                    policzJeden(a,d,e,h);
                                }
                            }else {
                                System.out.println("&&&1.4 ");
                                d = a;
                                d_val.setText(a);
                                e = a;
                                e_val.setText(d);
                                h = a;
                                h_val.setText(a);
                                policzJeden(a,d,e,h);
                            }
                            x = 1;
                        }
                        if(!isEmpty(b_val) || !isEmpty(c_val) || !isEmpty(f_val) || !isEmpty(g_val)){
                            System.out.println("&&&2 ");
                            if(isEmpty(b_val)){
                                if(isEmpty(c_val)){
                                    if (isEmpty(f_val)){
                                        System.out.println("&&&2.1 ");
                                        b = g;
                                        b_val.setText(g);
                                        c = g;
                                        c_val.setText(g);
                                        f = g;
                                        f_val.setText(g);
                                        policzDwa(b,c,f,g);
                                    }else{
                                        System.out.println("&&&2.2 ");
                                        b = f;
                                        b_val.setText(f);
                                        c = f;
                                        c_val.setText(f);
                                        g = f;
                                        g_val.setText(f);
                                        policzDwa(b,c,f,g);
                                    }
                                }else{
                                    System.out.println("&&&2.3 ");
                                    b = c;
                                    b_val.setText(c);
                                    f = c;
                                    f_val.setText(c);
                                    h = c;
                                    h_val.setText(c);
                                    policzDwa(b,c,f,g);
                                }
                            }else {
                                System.out.println("&&&2.4 ");
                                c = b;
                                c_val.setText(b);
                                f = b;
                                f_val.setText(b);
                                g = b;
                                g_val.setText(b);
                                policzDwa(b,c,f,g);
                            }
                            y = 1;
                        }
                        if(x == 0 && y == 1){
                            System.out.println("&&&3 ");
                            a = policzA(b);
                            a_val.setText(a);
                        }
                        if(x == 1 && y == 0){
                            System.out.println("&&&4 ");
                            b = policzB(a);
                            b_val.setText(b);
                        }
                        //za malo danych
                        if (isEmpty(a_val) && isEmpty(b_val) && isEmpty(c_val) && isEmpty(d_val) && isEmpty(e_val) && isEmpty(f_val) && isEmpty(g_val) && isEmpty(h_val)) {
                            System.out.println("&&&5 ");
                            x = 1;
                            test = true;
                            Toast.makeText(Katy.this, getString(R.string.notEnough),
                                    Toast.LENGTH_LONG).show();
                        }
                        //wszystko policzone, koniec petli
                        if (!a_val.getText().toString().equals("") &&
                                !b_val.getText().toString().equals("") &&
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
                            test = true;
                            Toast.makeText(Katy.this, getString(R.string.premium),
                                    Toast.LENGTH_LONG).show();
                        }
                        System.out.println("&&&koniec " + x + " " + y);
                    }
                }catch (Exception e){
                    System.out.println("eMessage "+e.getMessage());
                    Toast.makeText(Katy.this, getString(R.string.ups),
                            Toast.LENGTH_LONG).show();
                }

                System.out.println("%%%%%%% "+tekst1);
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
                b_val.setText("");
                c_val.setText("");
                d_val.setText("");
                e_val.setText("");
                f_val.setText("");
                g_val.setText("");
                h_val.setText("");
                tekst = "";
                tekst1 = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");

                Toast.makeText(Katy.this, getString(R.string.deleted),
                        Toast.LENGTH_SHORT).show();
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
                lastFocused.setSelection(4);

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
                mWebView.setVisibility(View.VISIBLE);
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
        String solucja1 = "<center><b>Obliczanie a mając b</b></center><br>" +
                "$$a={180-b}$$<br>" +
                "$$a={180-{"+Wartosc.formatuj(b)+"}$$<br>" +
                "$$a={"+Wartosc.formatuj(jeden)+"}$$<br>" +
        "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return jeden;
    }

    private String policzB(String a) {
        String jeden = Wartosc.policz("180", a, "-");
        String solucja1 = "<center><b>Obliczanie b mając a</b></center><br>" +
                "$$b={180-a}$$<br>" +
                "$$b={180-{"+Wartosc.formatuj(a)+"}$$<br>" +
                "$$b={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
    }

    private void policzDwa(String b, String c, String f, String g) {
        String solucja1 = "<center><b>b = c = f = g</b></center><br>" +
                "$$b={"+Wartosc.formatuj(b)+"}$$<br>" +
                "$$c={"+Wartosc.formatuj(c)+"}$$<br>" +
                "$$f={"+Wartosc.formatuj(f)+"}$$<br>" +
                "$$g={"+Wartosc.formatuj(g)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
    }

    //zmieniony komentarz testowy

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
            case id.item1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder
                        .setTitle(getString(R.string.about))
                        .setMessage("Wacław Łabuda \ne-mail: waclab1807@gmail.com \nPolska/Nowy Sącz")
                        .setIcon(drawable.logo)
                        .setPositiveButton("OK", null)
                        .show();
                break;
            case id.item2:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2
                        .setTitle(getString(R.string.futurePlans))
                        .setMessage("Kąty alfa, beta itd. \n" +
                                "Dynamiczne oznaczenia pól, które można policzyć, \n" +
                                "Wbudowany kalkulator, \n" +
                                "Wiele, wiele innych...")
                        .setIcon(drawable.logo)
                        .setPositiveButton("OK", null)
                        .show();
                break;
            case id.item3:
                Toast.makeText(Katy.this, "W budowie...",
                        Toast.LENGTH_LONG).show();
                break;
            case id.item4:
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
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            lastFocused = (EditText) v;
        }
    }
}
