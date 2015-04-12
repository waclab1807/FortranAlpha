package pl.wlabuda.fortranalpha;

import pl.wlabuda.fortranalpha.R.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnFocusChangeListener;
import android.widget.Toast;

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
    private TextView solution;
    private TextView dclackable;
    private TextView Dclackable;
    private TextView aclackable;
    private TextView Hclackable;
    private TextView hclackable;
    private ImageView figura;
    private EditText lastFocused;
    public static String tekst = "";
    public static String tekst1 = "";
    private WebView mWebView;

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

        //GraniastoslupPrawidlowyTrojkatny.context = getApplicationContext();
        Global.mContext = this.getBaseContext();
        //Global global1 = new Global(getBaseContext());

        mWebView = (WebView) findViewById(R.id.webView2);
        mWebView.setBackgroundColor(0xff0);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
/*
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
*/
        pp_val = (EditText) findViewById(R.id.pp);
        obj_val = (EditText) findViewById(R.id.obj);
        pb_val = (EditText) findViewById(R.id.pb);
        pc_val = (EditText) findViewById(R.id.pc);
        a_val = (EditText) findViewById(id.a_val);
        h_val = (EditText) findViewById(id.h_val);
        H_val = (EditText) findViewById(R.id.H_val);
        d_val = (EditText) findViewById(R.id.d_val);
        D_val = (EditText) findViewById(R.id.D_val);
        obwp_val = (EditText) findViewById(R.id.obwp);
        obwb_val = (EditText) findViewById(R.id.obwb);
        triangle_val = (EditText) findViewById(id.triangle);
        licz = (Button) findViewById(R.id.licz);
        clear = (Button) findViewById(id.clear);
        sqrtbtn = (Button) findViewById(id.btnsqrt);
        powbtn = (Button) findViewById(id.btnpow);
        solutionbtn = (Button) findViewById(id.solutionbtn);
        solution = (TextView) findViewById(id.solution);
        dclackable = (TextView) findViewById(id.c_text);
        Dclackable = (TextView) findViewById(id.e_text);
        aclackable = (TextView) findViewById(id.a);
        Hclackable = (TextView) findViewById(id.d);
        hclackable = (TextView) findViewById(id.c_text);
        figura = (ImageView) findViewById(id.imageView);

        dclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.granprzekd);
                d_val.requestFocus();
            }
        });
        Dclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.granprzek);
                D_val.requestFocus();
            }
        });
        aclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.grana);
                a_val.requestFocus();
            }
        });
        Hclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.granwys);
                H_val.requestFocus();
            }
        });
        hclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.granh);
                h_val.requestFocus();
            }
        });

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

        pp_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.granpp);
                return false;
            }
        });
        obj_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.granpc);
                return false;
            }
        });
        triangle_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.granptw);
                return false;
            }
        });
        pb_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.granpb);
                return false;
            }
        });
        obwb_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.granobwb);
                return false;
            }
        });
        obwp_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.granobwp);
                return false;
            }
        });
        pc_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.granpc);
                return false;
            }
        });
        h_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.granh);
                return false;
            }
        });
        a_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.grana);
                return false;
            }
        });
        H_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.granwys);
                return false;
            }
        });
        D_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.granprzekd);
                return false;
            }
        });
        d_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.granprzek);
                return false;
            }
        });

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

                tekst1 = "";
                figura.setImageResource(drawable.gran_prosty);
                //todo schowac klawiature

                int x = 0; //koniec petli, wszystko policzone

                try{
                    while (x == 0) {
                        System.out.println("%%%%%%% "+tekst1);
                        //obliczanie a lub h lub pp lub obwp
                        //czy jest a
                        if (!isEmpty(a_val)) {
                            System.out.println("^^^^^^^^1");
                            a = a_val.getText().toString();
                            ba = true;
                            if (isEmpty(pp_val) && !bpp) {
                                System.out.println("^^^^^^^^1.1");
                                pp_val.setText(policzPp(a));
                                bpp = true;
                            }
                            if (isEmpty(h_val) && !bh) {
                                System.out.println("^^^^^^^^1.2");
                                h_val.setText(policzhza(a));
                                bh = true;
                            }
                            if (isEmpty(obwp_val) && !bobwp) {
                                System.out.println("^^^^^^^^1.3");
                                obwp_val.setText(policzObwp(a));
                                bobwp = true;
                            }
                        }
                        System.out.println("%%%%%%%1 "+tekst1);
                        //czy jest h
                        if (!isEmpty(h_val)) {
                            System.out.println("^^^^^^^^2");
                            h = h_val.getText().toString();
                            bh = true;
                            if (isEmpty(a_val) && !ba) {
                                System.out.println("^^^^^^^^2.1");
                                a_val.setText(policzAzh(h));
                                ba = true;
                            }
                            if (isEmpty(pp_val) && !bpp) {
                                pp_val.setText(policzPp(policzAzh(h)));
                                System.out.println("^^^^^^^^2.2");
                                bpp = true;
                            }
                            if (isEmpty(obwp_val) && !bobwp) {
                                obwp_val.setText(policzObwp(policzAzh(h)));
                                System.out.println("^^^^^^^^2.3");
                                bobwp = true;
                            }
                        }
                        System.out.println("%%%%%%%2 "+tekst1);
                        //czy jest pp
                        if (!isEmpty(pp_val)) {
                            System.out.println("^^^^^^^^3");
                            pp = pp_val.getText().toString();
                            bpp = true;
                            if (isEmpty(a_val) && !ba) {
                                System.out.println("^^^^^^^^3.1");
                                a_val.setText(policzAzPp(pp));
                                ba = true;
                            }
                            if (h_val.getText().toString().equals("") && !bh) {
                                System.out.println("^^^^^^^^3.2");
                                h_val.setText(policzhzPp(pp));
                                bh = true;
                            }
                            if (obwp_val.getText().toString().equals("") && !bobwp) {
                                System.out.println("^^^^^^^^3.3");
                                obwp_val.setText(policzObwp(policzAzPp(pp)));
                                bobwp = true;
                            }
                        }
                        System.out.println("%%%%%%%3 "+tekst1);
                        //czy jest obwp
                        if (!isEmpty(obwp_val)) {
                            System.out.println("^^^^^^^^4");
                            obwp = obwp_val.getText().toString();
                            bobwp = true;
                            if (isEmpty(a_val) && !ba) {
                                System.out.println("^^^^^^^^4.1");
                                a_val.setText(policzAzObwp(obwp));
                                ba = true;
                            }
                            if (isEmpty(pp_val) && !bpp) {
                                System.out.println("^^^^^^^^4.2");
                                pp_val.setText(policzPp(policzAzObwp(obwp)));
                                bpp = true;
                            }
                            if (isEmpty(h_val) && !bh) {
                                System.out.println("^^^^^^^^4.3");
                                h_val.setText(policzhza(policzAzObwp(obwp)));
                                bh = true;
                            }
                        }
                        System.out.println("%%%%%%%4 "+tekst1);
                        //czy jest obj i H
                        if (!isEmpty(H_val)) {
                            System.out.println("^^^^^^^^5");
                            H = H_val.getText().toString();
                            bH = true;
                            if (!isEmpty(obj_val) && !bpp) {
                                System.out.println("^^^^^^^^5.1");
                                obj = obj_val.getText().toString();
                                bobj = true;
                                pp_val.setText(policzPpZObjiH(obj, H));
                                bpp = true;
                            } else if (!isEmpty(d_val) && !ba) {
                                System.out.println("^^^^^^^^5.2");
                                d = d_val.getText().toString();
                                bd = true;
                                a_val.setText(policzAzHid(H, d));
                                ba = true;
                            } else if (!isEmpty(D_val) && !bh) {
                                System.out.println("^^^^^^^^5.3");
                                D = D_val.getText().toString();
                                bD = true;
                                h_val.setText(policzhzHiD(H, D));
                                bh = true;
                            } else if (!isEmpty(obwb_val) && !ba) {
                                System.out.println("^^^^^^^^5.4");
                                obwb = obwb_val.getText().toString();
                                bobwb = true;
                                a_val.setText(policzAzHiObwb(H, obwb));
                                ba = true;
                            } else if (!isEmpty(pb_val) && !ba) {
                                System.out.println("^^^^^^^^5.5");
                                pb = pb_val.getText().toString();
                                bpb = true;
                                a_val.setText(policzAzHiPb(H, pb));
                                ba = true;
                            }
                        }
                        System.out.println("%%%%%%%5 "+tekst1);
                        //obliczanie H
                        if (!isEmpty(a_val)) {
                            System.out.println("^^^^^^^^6");
                            a = a_val.getText().toString();
                            ba = true;
                            if (!isEmpty(obj_val) && !bH) {
                                System.out.println("^^^^^^^^6.1");
                                obj = obj_val.getText().toString();
                                bobj = true;
                                H_val.setText(policzHzObjiA(obj, a));
                                bH = true;
                            } else if (!isEmpty(d_val) && !bH) {
                                System.out.println("^^^^^^^^6.2");
                                d = d_val.getText().toString();
                                bd = true;
                                H_val.setText(policzHzdiA(d, a));
                                bH = true;
                            } else if (!isEmpty(D_val) && !bH) {
                                System.out.println("^^^^^^^^6.3");
                                D = D_val.getText().toString();
                                bD = true;
                                H_val.setText(policzHzDiA(D, a));
                                bH = true;
                            } else if (!isEmpty(pc_val) && !bH) {
                                System.out.println("^^^^^^^^6.4");
                                pc = pc_val.getText().toString();
                                bpc = true;
                                H_val.setText(policzHzPciA(pc, a));
                                bH = true;
                            } else if (!isEmpty(pb_val) && !bH) {//todo WAZNE!! obliczanie H majac a i pb dorobic
                                System.out.println("^^^^^^^^6.4.1");
                                pb = pb_val.getText().toString();
                                bpb = true;
                                H_val.setText(policzHzPbiA(pb, a));
                                bH = true;
                            }else if (!isEmpty(obwb_val) && !bH) {
                                System.out.println("^^^^^^^^6.5");
                                obwb = obwb_val.getText().toString();
                                bobwb = true;
                                H_val.setText(policzHzObwbiA(obwb, a));
                                bH = true;
                            } else if (!isEmpty(triangle_val) && !bH) {
                                System.out.println("^^^^^^^^6.6");
                                triangle = triangle_val.getText().toString();
                                btriangle = true;
                                H_val.setText(policzHzTriangleiA(triangle,a));//todo przerobic to
                                String tmp1 = "(((2Pp/a)*2Pp)/a)-(h^2)";
                                String tmp = Wartosc.policz(Wartosc.policz(Wartosc.policz(Wartosc.policz(Wartosc.policz("2", policzPp(a), "*"), a, "/"), Wartosc.policz("2", policzPp(a), "*"), "*"), a, "/"), Wartosc.policz(policzhza(a), policzhza(a), "*"), "-");
                                H_val.setText(Wartosc.policz("()\u221a(" + tmp + ")", "1", "*"));
                                bH = true;
                            } else if (isEmpty(obj_val) && isEmpty(d_val) && isEmpty(D_val) && isEmpty(pc_val) && isEmpty(obwb_val) && isEmpty(triangle_val)) {
                                System.out.println("^^^^^^^^6.7");
                                x = 1;
                                Toast.makeText(GraniastoslupPrawidlowyTrojkatny.this, "Za mało danych aby policzyć wszystko!",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                        System.out.println("%%%%%%%6 "+tekst1);
                        //czy jest pc i pb
                        if (!isEmpty(pc_val)) {
                            System.out.println("^^^^^^^^7");
                            pc = pc_val.getText().toString();
                            bpc = true;
                            if (!isEmpty(pb_val) && !bpp) {
                                pb = pb_val.getText().toString();
                                bpb = true;
                                pp_val.setText(policzPpzPciPb(pc, pb));
                                bpp = true;
                            }
                        }
                        System.out.println("%%%%%%%7 "+tekst1);
                        //obliczanie pozostałych na podstawie a i H
                        //D
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bD) {
                            System.out.println("^^^^^^^^8");
                            a = a_val.getText().toString();
                            H = H_val.getText().toString();
                            D_val.setText(policzDzHiA(H, a));
                            bD = true;
                        }
                        System.out.println("%%%%%%%8 "+tekst1);
                        //d
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bd) {
                            System.out.println("^^^^^^^^9");
                            a = a_val.getText().toString();
                            H = H_val.getText().toString();
                            d_val.setText(policzdzHiA(H, a));
                            bd = true;
                        }
                        System.out.println("%%%%%%%9 "+tekst1);
                        //pb
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bpb) {
                            System.out.println("^^^^^^^^10");
                            a = a_val.getText().toString();
                            H = H_val.getText().toString();
                            pb_val.setText(policzPbzAiH(a, H));
                            bpb = true;
                        }
                        System.out.println("%%%%%%%0 "+tekst1);
                        //pc
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bpc) {
                            System.out.println("^^^^^^^^11");
                            a = a_val.getText().toString();
                            H = H_val.getText().toString();
                            pc_val.setText(policzPczAiH(a, H));
                            bpc = true;
                        }
                        System.out.println("%%%%%%%1 "+tekst1);
                        //obwb
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bobwb) {
                            System.out.println("^^^^^^^^12");
                            a = a_val.getText().toString();
                            H = H_val.getText().toString();
                            obwb_val.setText(policzObwbZAiH(a, H));
                            bobwb = true;
                        }
                        System.out.println("%%%%%%%2 "+tekst1);
                        //triangle
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !btriangle) {
                            System.out.println("^^^^^^^^13");
                            a = a_val.getText().toString();
                            H = H_val.getText().toString();
                            triangle_val.setText(policzTriangleZaiH(a, H));
                            btriangle = true;
                        }
                        System.out.println("%%%%%%%3 "+tekst1);
                        //obj
                        if (!isEmpty(a_val) && !isEmpty(H_val) && !bobj) {
                            System.out.println("^^^^^^^^14");
                            a = a_val.getText().toString();
                            H = H_val.getText().toString();
                            obj_val.setText(policzObjZaiH(a, H));
                            bobj = true;
                        }
                        System.out.println("%%%%%%%4 "+tekst1);
                        //za malo danych
                        if (isEmpty(a_val) && isEmpty(h_val) && isEmpty(pp_val) && isEmpty(obwp_val)) {
                            x = 1;
                            Toast.makeText(GraniastoslupPrawidlowyTrojkatny.this, "Za mało danych aby policzyć!",
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
                            Toast.makeText(GraniastoslupPrawidlowyTrojkatny.this, "Skorzystaj z konta premium aby zobaczyć rozwiązanie",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }catch (Exception e){
                    System.out.println("eMessage "+e.getMessage());
                    Toast.makeText(GraniastoslupPrawidlowyTrojkatny.this, "Ups! Coś poszło nie tak :/ Sprawdź wprowadzone dane.",
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
                h_val.setText("");
                H_val.setText("");
                d_val.setText("");
                D_val.setText("");
                pp_val.setText("");
                pb_val.setText("");
                pc_val.setText("");
                obj_val.setText("");
                obwp_val.setText("");
                obwb_val.setText("");
                triangle_val.setText("");
                solution.setText("");
                tekst = "";
                tekst1 = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");

                Toast.makeText(GraniastoslupPrawidlowyTrojkatny.this, "Skasowane!",
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
                solution.setMovementMethod(new ScrollingMovementMethod());
                if (!solution.equals("")) {
                    solution.setText("");
                }
                solution.setText(tekst);
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

    private String policzPp(String a) {
        String jeden = Wartosc.policz(a, a, "*");
        String dwa = Wartosc.policz(jeden, "()\u221a(3)", "*");
        String trzy = Wartosc.policz(dwa, "4", "/");
        String solucja = "Obliczanie pola podstawy mając a \n\n" +
                "Pp = [(a^2) * √3] / 4 \n\n" +
                "Pp = [(" + a + "^2) * √(3)] / 4 \n\n" +
                "Pp = (" + jeden + ")√(3) / 4 \n\n" +
                "Pp = (" + dwa + ") / 4\n\n" +
                "Pp = " +trzy+" \n\n"+
                "*===========================*\n\n";
        String solucja1 = "<center><b>Obliczanie pola podstawy mając a</b></center><br>" +
                "$$Pp={{a^2}*√3}/4$$<br>" +
                "$$Pp={{"+Wartosc.formatuj(a)+"^2}*√3}/4$$<br>" +
                "$$Pp={{"+Wartosc.formatuj(jeden)+"}*√3}/4$$<br>" +
                "$$Pp={"+Wartosc.formatuj(dwa)+"}/4$$<br>" +
                "$$Pp={"+Wartosc.formatuj(trzy)+"}$$<br>" +
        "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return trzy;
    }

    private String policzPpZObjiH(String Obj, String H) {
        String jeden = Wartosc.policz(Obj, H, "/");
        String solucja = "Obliczanie pola podstawy mając objętość i H \n\n" +
                "Pp = Obj / H \n\n" +
                "Pp = " + Obj + " / " + H + " \n\n" +
                "a = " + jeden + " \n\n" +
                "*===========================*\n\n";
        String solucja1 = "<center><b>Obliczanie pola podstawy mając objętość i H</b></center><br>" +
                "$$Pp={Obj}/{H}$$<br>" +
                "$$Pp={{"+Wartosc.formatuj(Obj)+"}/{"+Wartosc.formatuj(H)+"}}$$<br>" +
                "$$Pp={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzAzHid(String H, String d) {
        String jeden = Wartosc.policz(d, d, "*");
        String dwa = Wartosc.policz(H, H, "*");
        String trzy = Wartosc.policz(jeden, dwa, "-");
        String cztery = Wartosc.policz("()\u221a(" + trzy + ")", "1", "*");
        String solucja = "Obliczanie a mając H i d \n\n" +
                "a = √[(d^2) - (H^2)] \n\n" +
                "a = √[(" + d + "^2) - (" + H + "^2)] \n\n" +
                "a = √[(" + jeden + ") - (" + dwa + ")] \n\n" +
                "a = √(" + trzy + ") \n\n" +
                "a = " + cztery + " \n\n" +
                "*===========================*\n\n";
        String solucja1 = "<center><b>Obliczanie a mając H i d</b></center><br>" +
                "$$a={√{{d^2}-{H^2}}}$$<br>" +
                "$$a = {√{{{" + Wartosc.formatuj(d) + "}^2}-{{" + Wartosc.formatuj(H) + "}^2}}}$$<br>" +
                "$$a = {√{{" + Wartosc.formatuj(jeden) + "}-{" + Wartosc.formatuj(dwa) + "}}}$$<br>" +
                "$$a = {√{{" + Wartosc.formatuj(trzy) + "}}}$$<br>" +
                "$$a = {" + Wartosc.formatuj(cztery) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return cztery;
    }

    private String policzhzHiD(String H, String D) {
        String jeden = Wartosc.policz(D, D, "*");
        String dwa = Wartosc.policz(H, H, "*");
        String trzy = Wartosc.policz(jeden, dwa, "-");
        String cztery = Wartosc.policz("()\u221a(" + trzy + ")", "1", "*");
        String solucja = "Obliczanie h mając H i D \n\n" +
                "h = √[(D^2) - (H^2)] \n\n" +
                "h = √[(" + D + "^2) - (" + H + "^2)] \n\n" +
                "h = √[(" + jeden + ") - (" + dwa + ")] \n\n" +
                "h = √(" + trzy + ") \n\n" +
                "h = " + cztery + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie h mając H i D</b></center><br>" +
                "$$h = {√{{D^2} - {H^2}}}$$<br>" +
                "$$h = {√{{{"+Wartosc.formatuj(D)+"}^2} - {{"+Wartosc.formatuj(H)+"}^2}}}$$<br>" +
                "$$h = {√{{"+Wartosc.formatuj(jeden)+"} - {"+Wartosc.formatuj(dwa)+"}}}$$<br>" +
                "$$h = {√{"+Wartosc.formatuj(trzy)+"}}$$<br>" +
                "$$h = {"+Wartosc.formatuj(cztery)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return cztery;
    }

    private String policzHzObjiA(String Obj, String a) {
        String j = Wartosc.policz(a, a, "*");
        String d = Wartosc.policz(j, "()\u221a(3)", "*");
        String t = Wartosc.policz(d, "4", "/");
        String jeden = t;
        String dwa = Wartosc.policz(Obj, jeden, "/");
        String solucja = "Obliczanie H mając objętość i a \n\n" +
                "Pp = [(a^2) * √3] / 4 \n\n" +
                "Pp = " + jeden + " \n\n" +
                "H = Obj / Pp \n\n" +
                "H = " + Obj + " / " + jeden + " \n\n" +
                "H = " + dwa + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie H mając objętość i a</b></center><br>" +
                "$$Pp = {{{a^2}*√3}/4}$$<br>" +
                "$$Pp = {"+jeden+"}$$<br>" +
                "$$H = {{Obj}/{Pp}}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(Obj)+"}/{"+jeden+"}}$$<br>" +
                "$$H = {"+dwa+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzHzdiA(String d, String a) {
        String jeden = Wartosc.policz(d, d, "*");
        String dwa = Wartosc.policz(a, a, "*");
        String trzy = Wartosc.policz(jeden, dwa, "-");
        String cztery = Wartosc.policz("()\u221a(" + trzy + ")", "1", "*");
        String solucja = "Obliczanie H mając d i a \n\n" +
                "H = √[(d^2) - (a^2)] \n\n" +
                "H = √[(" + d + "^2) - (" + a + "^2)] \n\n" +
                "H = √(" + jeden + " - " + dwa + ") \n\n" +
                "H = √(" + trzy + ") \n\n" +
                "H = " + cztery + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie H mając d i a</b></center><br>" +
                "$$H = {√{{d^2} - {a^2}}}$$<br>" +
                "$$H = {√{{{"+Wartosc.formatuj(d)+"}^2} - {{"+Wartosc.formatuj(a)+"}^2}}}$$<br>" +
                "$$H = {√{{"+Wartosc.formatuj(jeden)+"} - {"+Wartosc.formatuj(dwa)+"}}}$$<br>" +
                "$$H = {√{"+Wartosc.formatuj(trzy)+"}}$$<br>" +
                "$$H = {"+Wartosc.formatuj(cztery)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        String solucja = "Obliczanie H mając D i a \n\n" +
                "H = √[(D^2) - (h^2)] \n\n" +
                "h = [a * √(3)] / 2 " +
                "h = " + dwa + " \n\n" +
                "H = √[(" + D + "^2) - (" + dwa + "^2)] \n\n" +
                "H = √(" + jeden + " - " + trzy + ") \n\n" +
                "H = √(" + cztery + ") \n\n" +
                "H = " + piec + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie H mając D i a</b></center><br>" +
                "$$h = {{a*√3}/2}$$<br>" +
                "$$h = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "$$H = {√{{D^2} - {h^2}}}$$<br>" +
                "$$H = {√{{{"+Wartosc.formatuj(D)+"}^2} - {{"+Wartosc.formatuj(dwa)+"}^2}}}$$<br>" +
                "$$H = {√{{"+Wartosc.formatuj(jeden)+"} - {"+Wartosc.formatuj(trzy)+"}}}$$<br>" +
                "$$H = {√{"+Wartosc.formatuj(cztery)+"}}$$<br>" +
                "$$H = {"+Wartosc.formatuj(piec)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        String solucja = "Obliczanie H mając Pc i a \n\n" +
                "Pp = [(a^2) * √3] / 4 \n\n" +
                "Pp = " + jeden + " \n\n" +
                "H = {[Pc - (2 * Pp)] / (3 * a)} \n\n" +
                "H = {[" + Pc + " - (2 * " + jeden + ")] / (3 * " + a + ")} \n\n" +
                "H = (" + Pc + " - " + dwa + ") / (" + cztery + ") \n\n" +
                "H = (" + trzy + ") / (" + cztery + ") \n\n" +
                "H = " + piec + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie H mając Pc i a</b></center><br>" +
                "$$Pp={{a^2}*√3}/4$$<br>" +
                "$$Pp = {"+jeden+"}$$<br>"+
                "$$H = {{Pc - {2 * Pp}} / {3 * a}}$$<br>" +
                "$$H = {{{"+Wartosc.formatuj(Pc)+"} - {2 * {"+Wartosc.formatuj(jeden)+"}}} / {3 * {"+Wartosc.formatuj(a)+"}}}$$<br>" +
                "$$H = {{{"+Wartosc.formatuj(Pc)+"} - {"+Wartosc.formatuj(dwa)+"}} / {"+Wartosc.formatuj(cztery)+"}}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(trzy)+"} / {"+Wartosc.formatuj(cztery)+"}}$$<br>" +
                "$$H = {"+Wartosc.formatuj(piec)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return piec;
    }

    private String policzHzPbiA(String Pb, String a) {
        String jeden = Wartosc.policz("3", a, "*");
        String dwa = Wartosc.policz(Pb, jeden, "/");
        String solucja = "Obliczanie H mając Pb i a \n\n" +
                "Pp = 3 * a * H \n\n" +
                "3 * Pp = a * H \n\n" +
                "H = Pb / (3 * a) \n\n" +
                "H = "+Pb+" / (3 * "+a+") \n\n" +
                "H = "+Pb+" / "+jeden+" \n\n" +
                "H = " + dwa + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie H mając Pb i a</b></center><br>" +
                "$$Pb={a*H*3}$$<br>" +
                "$${Pb}/{3} = {a*H}$$<br>"+
                "$$H = {Pb}/{3*a}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(Pb)+"}/{3*{"+Wartosc.formatuj(a)+"}}}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(Pb)+"}/{"+Wartosc.formatuj(jeden)+"}}$$<br>" +
                "$$H = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzHzObwbiA(String ObwB, String a) {
        String jeden = Wartosc.policz("6", a, "*");
        String dwa = Wartosc.policz(ObwB, jeden, "-");
        String trzy = Wartosc.policz(dwa, "3", "/");
        String solucja = "Obliczanie H mając obwód bryły i a \n\n" +
                "H = [ObwB - (6 * a)] / 3 \n\n" +
                "H = [" + ObwB + " - (6 * " + a + ")] / 3 \n\n" +
                "H = (" + ObwB + " - " + jeden + ") / 3 \n\n" +
                "H = (" + dwa + ") / 3 \n\n" +
                "H = " + trzy + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie H mając obwód bryły i a</b></center><br>" +
                "$$H = {{ObwB - {6 * a}} / 3}$$<br>" +
                "$$H = {{{"+Wartosc.formatuj(ObwB)+"} - {6 * {"+Wartosc.formatuj(a)+"}}} / 3}$$<br>" +
                "$$H = {{{"+Wartosc.formatuj(ObwB)+"} - {"+Wartosc.formatuj(jeden)+"}} / 3}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(dwa)+"} / 3}$$<br>" +
                "$$H = {"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return trzy;
    }

    private String policzHzTriangleiA(String Ptw,String a) {
        String j = Wartosc.policz(a, "()\u221a(3)", "*");
        String d = Wartosc.policz(j, "2", "/");
        String dwa = d;
        String trzy = Wartosc.policz(Ptw, "2", "*");
        String cztery = Wartosc.policz(trzy, dwa, "/");
        String solucja = "Obliczanie H mając Ptw i a \n\n" +
                "Ptw = (1 / 2) * h * H \n\n" +
                "2 * Ptw = h * H \n\n" +
                "H = (2 * Ptw) / h" +
                "h = [a * √(3)] / 2 \n\n" +
                "h = " + dwa + " \n\n" +
                "H = (2 * " + Ptw + ") / (" + dwa + ") \n\n" +
                "H = (" + trzy + " / " + dwa + ") \n\n" +
                "H = (" + cztery + ") \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie H mając Ptw i a</b></center><br>" +
                "$$Ptw = {{1/2}*h*H}$$<br>" +
                "$${2*Ptw} = {h*H}$$<br>" +
                "$$H = {{2*Ptw}/h}$$<br>" +
                "$$h = {{a * √3}/2}$$<br>" +
                "$$h = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "$$H = {{2*{"+Wartosc.formatuj(Ptw)+"}}/{"+Wartosc.formatuj(dwa)+"}}$$<br>" +
                "$$H = {{"+Wartosc.formatuj(trzy)+"}/{"+Wartosc.formatuj(dwa)+"}}$$<br>" +
                "$$H = {"+Wartosc.formatuj(cztery)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return cztery;
    }

    private String policzPpzPciPb(String Pc, String Pb) {
        String jeden = Wartosc.policz(Pc, Pb, "-");
        String dwa = Wartosc.policz(jeden, "2", "/");
        String solucja = "Obliczanie pola podstawy mając Pc i Pb \n\n" +
                "Pp = (Pc - Pb) / 2 \n\n" +
                "Pp = (" + Pc + " - " + Pb + ") / 2 \n\n" +
                "Pp = (" + jeden + ") / 2 \n\n" +
                "Pp = " + dwa + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie pola podstawy mając Pc i Pb</b></center><br>" +
                "$$Pp = {{Pc - Pb} / 2}$$<br>" +
                "$$Pp = {{{"+Wartosc.formatuj(Pc)+"} - {"+Wartosc.formatuj(Pb)+"}} / 2}$$<br>" +
                "$$Pp = {{"+Wartosc.formatuj(jeden)+"} / 2}$$<br>" +
                "$$Pp = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        String solucja = "Obliczanie D mając H i a \n\n" +
                "h = [a * √(3)] / 2 \n\n" +
                "h = " + jeden + " \n\n" +
                "D = √[(H^2) + (h^2)] \n\n" +
                "D = √[(" + H + "^2) + (" + jeden + "^2)] \n\n" +
                "D = √[" + trzy + " + " + dwa + ") \n\n" +
                "D = √(" + cztery + ") \n\n" +
                "D = " + piec + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie D mając H i a</b></center><br>" +
                "$$h = {{a * √3}/2}$$<br>" +
                "$$h={"+jeden+"}$$<br>" +
                "$$D = {√{{H^2} + {h^2}}}$$<br>" +
                "$$D = {√{{{"+Wartosc.formatuj(H)+"}^2} + {{"+Wartosc.formatuj(jeden)+"}^2}}}$$<br>" +
                "$$D = {√{{"+Wartosc.formatuj(trzy)+"} + {"+Wartosc.formatuj(dwa)+"}}}$$<br>" +
                "$$D = {√{"+Wartosc.formatuj(cztery)+"}}$$<br>" +
                "$$D = {"+Wartosc.formatuj(piec)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return piec;
    }

    private String policzdzHiA(String H, String a) {
        String jeden = Wartosc.policz(H, H, "*");
        String dwa = Wartosc.policz(a, a, "*");
        String trzy = Wartosc.policz(jeden, dwa, "+");
        String cztery = Wartosc.policz("()\u221a(" + trzy + ")", "1", "*");
        String solucja = "Obliczanie d mając H i a \n\n" +
                "d = √[(H^2) + (a^2)] \n\n" +
                "d = √[(" + H + "^2) + (" + a + "^2)] \n\n" +
                "d = √[" + jeden + " + " + dwa + ") \n\n" +
                "d = √(" + trzy + ") \n\n" +
                "d = " + cztery + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie d mając H i a</b></center><br>" +
                "$$d = {√{{H^2} + {a^2}}}$$<br>" +
                "$$d = {√{{{"+Wartosc.formatuj(H)+"}^2} + {{"+Wartosc.formatuj(a)+"}^2}}}$$<br>" +
                "$$d = {√{{"+Wartosc.formatuj(jeden)+"} + {"+Wartosc.formatuj(dwa)+"}}}$$<br>" +
                "$$d = {√{"+Wartosc.formatuj(trzy)+"}}$$<br>" +
                "$$d = {"+Wartosc.formatuj(cztery)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return cztery;
    }

    private String policzPbzAiH(String a, String H) {
        String jeden = Wartosc.policz("3", a, "*");
        String dwa = Wartosc.policz(jeden, H, "*");
        String solucja = "Obliczanie pola bocznego mając a i H \n\n" +
                "Pb = (3 * a) * H \n\n" +
                "Pb = (3 * " + a + ") * " + H + " \n\n" +
                "Pb = " + jeden + " * " + H + " \n\n" +
                "Pb = " + dwa + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie pola bocznego mając a i H</b></center><br>" +
                "$$Pb = {{3*a}*H}$$<br>" +
                "$$Pb = {{3*{"+Wartosc.formatuj(a)+"}}*{"+Wartosc.formatuj(H)+"}}$$<br>" +
                "$$Pb = {{"+Wartosc.formatuj(jeden)+"}*{"+Wartosc.formatuj(H)+"}}$$<br>" +
                "$$Pb = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        String solucja = "Obliczanie pola całkowitego mając a i H \n\n" +
                "Pp = " + t + " \n\n" +
                "Pc = (2 * Pp) + [(3 * a) * H] \n\n" +
                "Pc = (2 * " + t + ") + [(3 * " + a + ") * " + H + "] \n\n" +
                "Pc = " + trzy + " + (" + jeden + " * " + H + ") \n\n" +
                "Pc = " + trzy + " + " + dwa + " \n\n" +
                "Pc = " + cztery + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie pola całkowitego mając a i H</b></center><br>" +
                "$$Pp = {"+t+"}$$<br>" +
                "$$Pc = {{2 * Pp} + {{3 * a} * H}}$$<br>" +
                "$$Pc = {{2 * {"+Wartosc.formatuj(t)+"}} + {{3 * {"+Wartosc.formatuj(a)+"}} * {"+Wartosc.formatuj(H)+"}}}$$<br>" +
                "$$Pc = {{"+Wartosc.formatuj(trzy)+"} + {{"+Wartosc.formatuj(jeden)+"} * {"+Wartosc.formatuj(H)+"}}}$$<br>" +
                "$$Pc = {{"+Wartosc.formatuj(trzy)+"} + {"+Wartosc.formatuj(dwa)+"}}$$<br>" +
                "$$Pc = {"+Wartosc.formatuj(cztery)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return cztery;
    }

    private String policzObwbZAiH(String a, String H) {
        String jeden = Wartosc.policz("6", a, "*");
        String dwa = Wartosc.policz("3", H, "*");
        String trzy = Wartosc.policz(jeden, dwa, "+");
        String solucja = "Obliczanie obwodu bryły mając a i H \n\n" +
                "ObwB = (6 * a) + (3 * H) \n\n" +
                "ObwB = (6 * " + a + ") + (3 * " + H + ") \n\n" +
                "ObwB = " + jeden + " + " + dwa + " \n\n" +
                "ObwB = " + trzy + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie obwodu bryły mając a i H</b></center><br>" +
                "$$ObwB = {{6 * a} + {3 * H}}$$<br>" +
                "$$ObwB = {{6 * {"+Wartosc.formatuj(a)+"}} + {3 * {"+Wartosc.formatuj(H)+"}}}$$<br>" +
                "$$ObwB = {{"+Wartosc.formatuj(jeden)+"} + {"+Wartosc.formatuj(dwa)+"}}$$<br>" +
                "$$ObwP = {"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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

        String solucja = "Obliczanie pola trójkąta wewnętrznego mając a i H \n\n" +
                "h = [a * √(3)] / 2 \n\n" +
                "h = " + zero + " \n\n" +
                "Ptw = √[(h^2) + (H^2)] / 2 \n\n" +
                "Ptw = √[(" + zero + "^2) + (" + H + "^2)] / 2 \n\n" +
                "Ptw = √[" + jeden + " + " + dwa + "] / 2 \n\n" +
                "Ptw = √(" + trzy + ") / 2 \n\n" +
                "Ptw = (" + cztery + ") / 2 \n\n" +
                "Ptw = " + piec + " \n\n" +
                "*===========================*\n\n";

        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie pola trójkąta wewnętrznego mając a i H</b></center><br>" +
                "$$h = {{a * √3}/2}$$<br>" +
                "$$h = {"+zero+"}$$<br>" +
                "$$Ptw = {√{{h^2} + {H^2}}/2}$$<br>" +
                "$$Ptw = {√{{{"+Wartosc.formatuj(zero)+"}^2} + {{"+Wartosc.formatuj(H)+"}^2}}/2}$$<br>" +
                "$$Ptw = {√{{"+Wartosc.formatuj(jeden)+"} + {"+Wartosc.formatuj(dwa)+"}}/2}$$<br>" +
                "$$Ptw = {√{"+Wartosc.formatuj(trzy)+"}/2}$$<br>" +
                "$$Ptw = {{"+Wartosc.formatuj(cztery)+"}/2}$$<br>" +
                "$$Ptw = {"+Wartosc.formatuj(piec)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return piec;
    }

    private String policzObjZaiH(String a, String H) {
        String j = Wartosc.policz(a, a, "*");
        String d = Wartosc.policz(j, "()\u221a(3)", "*");
        String t = Wartosc.policz(d, "4", "/");
        String jeden = t;
        String dwa = Wartosc.policz(jeden, H, "*");
        String solucja = "Obliczanie objętości mając a i H \n\n" +
                "Pp = [(a^2) * √3] / 4 \n\n" +
                "Pp = " + jeden + " \n\n" +
                "Obj = Pp * H \n\n" +
                "Obj = " + jeden + " * " + H + " \n\n" +
                "Obj = " + dwa + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie objętości mając a i H</b></center><br>" +
                "$$Pp={{a^2}*√3}/4$$<br>" +
                "$$Pp = {"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "$$Obj = {Pp*H}$$<br>" +
                "$$Obj = {{"+Wartosc.formatuj(jeden)+"}*{"+Wartosc.formatuj(H)+"}}$$<br>" +
                "$$Obj = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzObwp(String a) {
        String jeden = Wartosc.policz("3", a, "*");
        String solucja = "Obliczanie obwodu podstawy mając a \n\n" +
                "ObwP = a * 3 \n\n" +
                "ObwP = " + a + " * 3 \n\n" +
                "ObwP = " + jeden + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie obwodu podstawy mając a</b></center><br>" +
                "$$ObwP={a*3}$$<br>" +
                "$$ObwP = {{" + Wartosc.formatuj(a) + "}*3}$$<br>" +
                "$$ObwP = {" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        String solucja1 = "<center><b>Obliczanie a mając h</b></center><br>" +
                "$$h = {{a * √3}/2}$$<br>" +
                "$${2*h} = {a * √3}$$<br>" +
                "$$a = {{2*h}/√3}$$<br>" +
                "$$a = {{2√3 * h}/3}$$<br>" +
                "$$a = {{2√3 * {"+Wartosc.formatuj(h)+"}}/3}$$<br>" +
                "$$a = {{"+Wartosc.formatuj(jeden)+"}/3}$$<br>" +
                "$$a = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzAzHiPb(String H, String Pb) {
        String jeden = Wartosc.policz(H, "3", "*");
        String dwa = Wartosc.policz(Pb, jeden, "/");
        String solucja = "Obliczanie a mając H i pole boczne \n\n" +
                "a = Pb / (3 * H) \n\n" +
                "a = Pb / (" + jeden + ") \n\n" +
                "a = " + dwa + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie a mając H i pole boczne</b></center><br>" +
                "$$a = {Pb/{3*H}}$$<br>" +
                "$$a = {{"+Wartosc.formatuj(Pb)+"}/{3*{"+Wartosc.formatuj(H)+"}}}$$<br>" +
                "$$a = {{"+Wartosc.formatuj(Pb)+"}/{"+Wartosc.formatuj(jeden)+"}}$$<br>" +
                "$$a = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzAzPp(String Pp) {
        String jeden = Wartosc.policz(Pp, "4", "*");
        String dwa = Wartosc.policz(jeden, "()\u221a(3)", "/");
        String trzy = Wartosc.policz("()\u221a(" + dwa + ")", "1", "*");
        String solucja = "Obliczanie a mając pole podstawy \n\n" +
                "Pp = [(a^2) * √(3)] / 4 \n\n" +
                "4 * Pp = [(a^2) * √(3)] \n\n" +
                "(4 * Pp) / √(3) = (a^2) \n\n" +
                "a = √[(4 * Pp) / √(3)] \n\n" +
                "a = √[(4 * " + Pp + ") / √(3)] \n\n" +
                "a = √[" + jeden + " / √(3)] \n\n" +
                "a = √[" + dwa + "] \n\n" +
                "a = " + trzy + "\n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie a mając pole podstawy</b></center><br>" +
                "$$Pp = {{{a^2} * √3} / 4}$$<br>" +
                "$${4 * Pp} = {{a^2} * √3} $$<br>" +
                "$${{4 * Pp} / √3} = {a^2} $$<br>" +
                "$$a = {√{{4 * Pp} / √3}} $$<br>" +
                "$$a = {√{{4 * {"+Wartosc.formatuj(Pp)+"}} / √3}} $$<br>" +
                "$$a = {√{{"+Wartosc.formatuj(jeden)+"} / √3}} $$<br>" +
                "$$a = {√{"+Wartosc.formatuj(dwa)+"}} $$<br>" +
                "$$a = {" + Wartosc.formatuj(trzy) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return trzy;
    }

    private String policzAzHiObwb(String H, String Obwb) {
        String jeden = Wartosc.policz(H, "3", "*");
        String dwa = Wartosc.policz(Obwb, jeden, "-");
        String trzy = Wartosc.policz(dwa, "6", "/");
        String solucja = "Obliczanie a mając H i obwód bryły \n\n" +
                "a = [ObwB - (3 * H)] / 6 \n\n" +
                "a = [ObwB - (" + jeden + ")] / 6 \n\n" +
                "a = (" + dwa + ") / 6 \n\n" +
                "a = " + trzy + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie a mając H i obwód bryły</b></center><br>" +
                "$$a = {{Obwb-{3*H}}/6}$$<br>" +
                "$$a = {{{"+Wartosc.formatuj(Obwb)+"}-{3*{"+Wartosc.formatuj(H)+"}}}/6}$$<br>" +
                "$$a = {{{"+Wartosc.formatuj(Obwb)+"}/{"+Wartosc.formatuj(jeden)+"}}/6}$$<br>" +
                "$$a = {{"+Wartosc.formatuj(dwa)+"}/6}$$<br>" +
                "$$a = {"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return trzy;
    }

    private String policzAzObwp(String Obwp) {
        String jeden = Wartosc.policz(Obwp, "3", "/");
        String solucja = "Obliczanie a mając obwód podstawy \n\n" +
                "ObwP = a * 3 \n\n" +
                "a = ObwP / 3 \n\n" +
                "a = " + Obwp + " / 3 \n\n" +
                "a = " + jeden + " \n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie a mając obwód podstawy</b></center><br>" +
                "$$ObwP = {a * 3}$$<br>" +
                "$$a = {ObwP / 3}$$<br>" +
                "$$a = {{"+Wartosc.formatuj(Obwp)+"} / 3}$$<br>" +
                "$$a = {"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
        String solucja1 = "<center><b>Obliczanie h mając a</b></center><br>" +
                "$$h = {{a * √3}/2}$$<br>" +
                "$$h = {{{"+Wartosc.formatuj(a)+"} * √3}/2}$$<br>" +
                "$$h = {{"+Wartosc.formatuj(jeden)+"}/2}$$<br>" +
                "$$a = {"+Wartosc.formatuj(dwa)+"}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzhzPp(String Pp) {
        String jeden = Wartosc.policz("3", Pp, "*");
        String dwa = Wartosc.policz(jeden, "()\u221a(3)", "/");
        String trzy = Wartosc.policz("()\u221a(" + dwa + ")", "1", "*");
        String solucja = "Obliczanie h mając pole podstawy \n\n" +
                "h = [a * √(3)] / 2 \n\n" +
                "2 * h = a * √(3) \n\n" +
                "a = (2 * h) / √(3) \n\n" +
                "a = [(2)√(3) * h] / 3 \n\n" +
                "Pp = [(a^2) * √(3)] / 4 \n\n" +
                "Pp = {[(12 * (h^2)) / 9] * √(3)} / 4 \n\n" +
                "Pp = [(h^2) * √(3)] / 3 \n\n" +
                "3 * Pp = (h^2) * √(3) \n\n" +
                "(3 * Pp) / √(3) = (h^2) \n\n" +
                "h = √[(3 * Pp) / √(3)] \n\n" +
                "h = √[(" + jeden + ") / √(3)] \n\n" +
                "h = √(" + dwa + ") \n\n" +
                "h = " + trzy + "\n\n" +
                "*===========================*\n\n";
        if (!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        String solucja1 = "<center><b>Obliczanie h mając pole podstawy</b></center><br>" +
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
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return trzy;
        //return Wartosc.policz(Wartosc.policz(policzAzPp(Pp),"()\u221a(3)","*"),"2","/");
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
                        .setIcon(drawable.logo)
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
                        .setIcon(drawable.logo)
                        .setPositiveButton("OK", null)
                        .show();
                break;
            case R.id.item3:
                Toast.makeText(GraniastoslupPrawidlowyTrojkatny.this, "W budowie...",
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
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            lastFocused = (EditText) v;
        }
    }
}
