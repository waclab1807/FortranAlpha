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

public class Tales extends Activity implements OnFocusChangeListener {

    private Button licz;
    private Button clear;
    private Button solutionbtn;
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
    private TextView aclackable;
    private TextView bclackable;
    private TextView cclackable;
    private TextView dclackable;
    private TextView eclackable;
    private TextView fclackable;
    private TextView acclackable;
    private TextView bdclackable;
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
    String AC;
    String BD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.tales);

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
        a_val = (EditText) findViewById(id.a);
        b_val = (EditText) findViewById(id.b);
        c_val = (EditText) findViewById(id.c);
        d_val = (EditText) findViewById(id.d);
        e_val = (EditText) findViewById(id.e);
        f_val = (EditText) findViewById(id.f);
        ac_val = (EditText) findViewById(id.ac);
        bd_val = (EditText) findViewById(id.bd);
        licz = (Button) findViewById(id.licz);
        clear = (Button) findViewById(id.clear);
        sqrtbtn = (Button) findViewById(id.btnsqrt);
        powbtn = (Button) findViewById(id.btnpow);
        solutionbtn = (Button) findViewById(id.solutionbtn);

        aclackable = (TextView) findViewById(id.a_text);
        bclackable = (TextView) findViewById(id.b_text);
        cclackable = (TextView) findViewById(id.c_text);
        dclackable = (TextView) findViewById(id.d_text);
        eclackable = (TextView) findViewById(id.e_text);
        fclackable = (TextView) findViewById(id.f_text);
        acclackable = (TextView) findViewById(id.AC_text);
        bdclackable = (TextView) findViewById(id.BD_text);

        figura = (ImageView) findViewById(id.imageView);

        aclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.talesa);
                a_val.requestFocus();
            }
        });
        bclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.talesb);
                b_val.requestFocus();
            }
        });
        cclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.talesc);
                c_val.requestFocus();
            }
        });
        dclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.talesd);
                d_val.requestFocus();
            }
        });
        eclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.talese);
                e_val.requestFocus();
            }
        });
        fclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.talesf);
                f_val.requestFocus();
            }
        });
        acclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.talesac);
                ac_val.requestFocus();
            }
        });
        bdclackable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figura.setImageResource(drawable.talesbd);
                bd_val.requestFocus();
            }
        });

        a_val.setOnFocusChangeListener(this);
        b_val.setOnFocusChangeListener(this);
        c_val.setOnFocusChangeListener(this);
        d_val.setOnFocusChangeListener(this);
        e_val.setOnFocusChangeListener(this);
        f_val.setOnFocusChangeListener(this);
        ac_val.setOnFocusChangeListener(this);
        bd_val.setOnFocusChangeListener(this);

        a_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.talesa);
                return false;
            }
        });
        b_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.talesb);
                return false;
            }
        });
        c_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.talesc);
                return false;
            }
        });
        d_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.talesd);
                return false;
            }
        });
        e_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.talese);
                return false;
            }
        });
        f_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.talesf);
                return false;
            }
        });
        ac_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.talesac);
                return false;
            }
        });
        bd_val.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                figura.setImageResource(drawable.talesbd);
                return false;
            }
        });

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tekst1 = "";
                figura.setImageResource(drawable.tales);
                //todo schowac klawiature

                int x = 0; //koniec petli, wszystko policzone

                try {
                    while (x == 0) {
                        if (!isEmpty(a_val) && !isEmpty(c_val) && isEmpty(ac_val)) {
                            System.out.println("^^^^^^^^1");
                            a = a_val.getText().toString();
                            c = c_val.getText().toString();
                            ac_val.setText(policzAC(a, c));
                        } else if (!isEmpty(b_val) && !isEmpty(d_val) && isEmpty(bd_val)) {
                            System.out.println("^^^^^^^^2");
                            b = b_val.getText().toString();
                            d = d_val.getText().toString();
                            bd_val.setText(policzBD(b, d));
                        } else if (!isEmpty(a_val) && !isEmpty(b_val) && !isEmpty(c_val) && isEmpty(d_val)) {
                            System.out.println("^^^^^^^^3");
                            a = a_val.getText().toString();
                            b = b_val.getText().toString();
                            c = c_val.getText().toString();
                            d_val.setText(policzDzABC(a, b, c));
                        } else if (!isEmpty(a_val) && !isEmpty(b_val) && !isEmpty(d_val) && isEmpty(c_val)) {
                            System.out.println("^^^^^^^^4");
                            a = a_val.getText().toString();
                            b = b_val.getText().toString();
                            d = d_val.getText().toString();
                            c_val.setText(policzCzABD(a, b, d));
                        } else if (!isEmpty(a_val) && !isEmpty(c_val) && !isEmpty(d_val) && isEmpty(b_val)) {
                            System.out.println("^^^^^^^^5");
                            a = a_val.getText().toString();
                            c = c_val.getText().toString();
                            d = d_val.getText().toString();
                            b_val.setText(policzBzACD(a, c, d));
                        } else if (!isEmpty(b_val) && !isEmpty(c_val) && !isEmpty(d_val) && isEmpty(a_val)) {
                            System.out.println("^^^^^^^^6");
                            b = b_val.getText().toString();
                            c = c_val.getText().toString();
                            d = d_val.getText().toString();
                            a_val.setText(policzAzBCD(b, c, d));
                        } else if (!isEmpty(ac_val) && !isEmpty(a_val) && isEmpty(c_val)) {
                            System.out.println("^^^^^^^^7");
                            a = a_val.getText().toString();
                            AC = ac_val.getText().toString();
                            c_val.setText(policzC(AC, a));
                        } else if (!isEmpty(ac_val) && !isEmpty(c_val) && isEmpty(a_val)) {
                            System.out.println("^^^^^^^^7");
                            c = c_val.getText().toString();
                            AC = ac_val.getText().toString();
                            a_val.setText(policzA(AC, c));
                        } else if (!isEmpty(bd_val) && !isEmpty(b_val) && isEmpty(d_val)) {
                            System.out.println("^^^^^^^^8");
                            b = b_val.getText().toString();
                            BD = bd_val.getText().toString();
                            d_val.setText(policzD(BD, b));
                        } else if (!isEmpty(bd_val) && !isEmpty(d_val) && isEmpty(b_val)) {
                            System.out.println("^^^^^^^^9");
                            d = d_val.getText().toString();
                            BD = bd_val.getText().toString();
                            b_val.setText(policzB(BD, d));
                        } else if (!isEmpty(bd_val) && !isEmpty(a_val) && !isEmpty(ac_val) && isEmpty(b_val)) {
                            System.out.println("^^^^^^^14");
                            BD = bd_val.getText().toString();
                            AC = ac_val.getText().toString();
                            a = a_val.getText().toString();
                            b_val.setText(policzBzACBDA(AC, BD, a));
                        } else if (!isEmpty(bd_val) && !isEmpty(b_val) && !isEmpty(ac_val) && isEmpty(a_val)) {
                            System.out.println("^^^^^^^15");
                            BD = bd_val.getText().toString();
                            AC = ac_val.getText().toString();
                            b = b_val.getText().toString();
                            a_val.setText(policzAzACBDB(AC, BD, b));
                        } else if (!isEmpty(a_val) && !isEmpty(e_val) && !isEmpty(f_val) && isEmpty(ac_val)) {
                            System.out.println("^^^^^^^16");
                            a = a_val.getText().toString();
                            e = e_val.getText().toString();
                            f = f_val.getText().toString();
                            c_val.setText(policzACzAEF(a, e, f));
                        } else if (!isEmpty(b_val) && !isEmpty(e_val) && !isEmpty(f_val) && isEmpty(bd_val)) {
                            System.out.println("^^^^^^^17");
                            b = b_val.getText().toString();
                            e = e_val.getText().toString();
                            f = f_val.getText().toString();
                            d_val.setText(policzBDzBEF(b, e, f));
                        } else if (!isEmpty(ac_val) && !isEmpty(e_val) && !isEmpty(f_val) && isEmpty(a_val)) {
                            System.out.println("^^^^^^^20");
                            AC = ac_val.getText().toString();
                            e = e_val.getText().toString();
                            f = f_val.getText().toString();
                            a_val.setText(policzAzACEF(AC, e, f));
                        } else if (!isEmpty(bd_val) && !isEmpty(e_val) && !isEmpty(f_val) && isEmpty(b_val)) {
                            System.out.println("^^^^^^^21");
                            BD = bd_val.getText().toString();
                            e = e_val.getText().toString();
                            f = f_val.getText().toString();
                            b_val.setText(policzBzBDEF(BD, e, f));
                        } else if (!isEmpty(bd_val) && !isEmpty(e_val) && !isEmpty(b_val) && isEmpty(f_val)) {
                            System.out.println("^^^^^^^22");
                            BD = bd_val.getText().toString();
                            e = e_val.getText().toString();
                            b = b_val.getText().toString();
                            f_val.setText(policzFzBD(BD, b, e));
                        } else if (!isEmpty(bd_val) && !isEmpty(f_val) && !isEmpty(b_val) && isEmpty(e_val)) {
                            System.out.println("^^^^^^^23");
                            BD = bd_val.getText().toString();
                            f = f_val.getText().toString();
                            b = b_val.getText().toString();
                            e_val.setText(policzEzBD(BD, b, f));
                        } else if (!isEmpty(ac_val) && !isEmpty(e_val) && !isEmpty(a_val) && isEmpty(f_val)) {
                            System.out.println("^^^^^^^24");
                            AC = ac_val.getText().toString();
                            e = e_val.getText().toString();
                            a = a_val.getText().toString();
                            f_val.setText(policzFzAC(AC, a, e));
                        } else if (!isEmpty(ac_val) && !isEmpty(f_val) && !isEmpty(a_val) && isEmpty(e_val)) {
                            System.out.println("^^^^^^^24");
                            AC = ac_val.getText().toString();
                            f = f_val.getText().toString();
                            a = a_val.getText().toString();
                            e_val.setText(policzEzAC(AC, a, f));
                        } else {      //za malo danych
                            x = 1;
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
                } catch (Exception e) {
                    System.out.println("eMessage " + e.getMessage());
                    Toast.makeText(Tales.this, getString(R.string.ups),
                            Toast.LENGTH_LONG).show();
                }

                System.out.println("%%%%%%% " + tekst1);
                String js = "<html><head>"
                        + "<link rel='stylesheet' href='file:///android_asset/mathscribe/jqmath-0.4.0.css'>"
                        + "<script src = 'file:///android_asset/mathscribe/jquery-1.4.3.min.js'></script>"
                        + "<script src = 'file:///android_asset/mathscribe/jqmath-etc-0.4.2.min.js'></script>"
                        + "</head><body>"
                        + "<script>var s =   " +
                        "'" + tekst1 + "';" +
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
                ac_val.setText("");
                bd_val.setText("");
                //solution.setText("");
                tekst = "";
                tekst1 = "";
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");

                Toast.makeText(Tales.this, getString(R.string.deleted),
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
                /*solution.setMovementMethod(new ScrollingMovementMethod());
                if (!solution.equals("")) {
                    solution.setText("");
                }
                solution.setText(tekst);*/
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

    private String policzAC(String a, String c) {
        String jeden = Wartosc.policz(a, c, "+");
        String solucja1 = "<center><b>"+getString(R.string.policzAC)+"</b></center><br>" +
                "$$AC={a + c}$$<br>" +
                "$$AC={{" + Wartosc.formatuj(a) + "} + {" + Wartosc.formatuj(c) + "}}$$<br>" +
                "$$AC={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return jeden;
    }

    private String policzBD(String b, String d) {
        String jeden = Wartosc.policz(b, d, "+");
        String solucja1 = "<center><b>"+getString(R.string.policzBD)+"</b></center><br>" +
                "$$BD={b + d}$$<br>" +
                "$$BD={{" + Wartosc.formatuj(b) + "} + {" + Wartosc.formatuj(d) + "}}$$<br>" +
                "$$BD={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return jeden;
    }

    private String policzDzABC(String a, String b, String c) {
        String jeden = Wartosc.policz(b, c, "*");
        String dwa = Wartosc.policz(jeden, a, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzDzABC)+"</b></center><br>" +
                "$${a}/{b}={c}/{d}$$<br>" +
                "$$d={b*c}/{a}$$<br>" +
                "$$d={{" + Wartosc.formatuj(b) + "}*{" + Wartosc.formatuj(c) + "}}/{" + Wartosc.formatuj(a) + "}$$<br>" +
                "$$d={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(a) + "}$$<br>" +
                "$$d={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzCzABD(String a, String b, String d) {
        String jeden = Wartosc.policz(d, a, "*");
        String dwa = Wartosc.policz(jeden, b, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzCzABD)+"</b></center><br>" +
                "$${a}/{c}={b}/{d}$$<br>" +
                "$$c={d*a}/{b}$$<br>" +
                "$$c={{" + Wartosc.formatuj(d) + "}*{" + Wartosc.formatuj(a) + "}}/{" + Wartosc.formatuj(b) + "}$$<br>" +
                "$$c={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(b) + "}$$<br>" +
                "$$c={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzBzACD(String a, String c, String d) {
        String jeden = Wartosc.policz(d, a, "*");
        String dwa = Wartosc.policz(jeden, c, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzBzACD)+"</b></center><br>" +
                "$${a}/{c}={b}/{d}$$<br>" +
                "$$b={d*a}/{c}$$<br>" +
                "$$b={{" + Wartosc.formatuj(d) + "}*{" + Wartosc.formatuj(a) + "}}/{" + Wartosc.formatuj(c) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(c) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzAzBCD(String b, String c, String d) {
        String jeden = Wartosc.policz(b, c, "*");
        String dwa = Wartosc.policz(jeden, d, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzAzBCD)+"</b></center><br>" +
                "$${a}/{c}={b}/{d}$$<br>" +
                "$$b={d*a}/{c}$$<br>" +
                "$$b={{" + Wartosc.formatuj(b) + "}*{" + Wartosc.formatuj(c) + "}}/{" + Wartosc.formatuj(d) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(d) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzC(String ac, String a) {
        String jeden = Wartosc.policz(ac, a, "-");
        String solucja1 = "<center><b>"+getString(R.string.policzC)+"</b></center><br>" +
                "$${AC}={a + c}$$<br>" +
                "$$c={AC - a}$$<br>" +
                "$$c={" + Wartosc.formatuj(ac) + "}-{" + Wartosc.formatuj(a) + "}$$<br>" +
                "$$c={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return jeden;
    }

    private String policzA(String ac, String c) {
        String jeden = Wartosc.policz(ac, c, "-");
        String solucja1 = "<center><b>"+getString(R.string.policzA)+"</b></center><br>" +
                "$${AC}={a + c}$$<br>" +
                "$$a={AC - c}$$<br>" +
                "$$c={" + Wartosc.formatuj(ac) + "}-{" + Wartosc.formatuj(c) + "}$$<br>" +
                "$$c={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return jeden;
    }

    private String policzD(String bd, String b) {
        String jeden = Wartosc.policz(bd, b, "-");
        String solucja1 = "<center><b>"+getString(R.string.policzD)+"</b></center><br>" +
                "$${BD}={b + d}$$<br>" +
                "$$d={BD - b}$$<br>" +
                "$$d={" + Wartosc.formatuj(bd) + "}-{" + Wartosc.formatuj(b) + "}$$<br>" +
                "$$d={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return jeden;
    }

    private String policzB(String bd, String d) {
        String jeden = Wartosc.policz(bd, d, "-");
        String solucja1 = "<center><b>"+getString(R.string.policzB)+"</b></center><br>" +
                "$${BD}={b + d}$$<br>" +
                "$$b={BD - d}$$<br>" +
                "$$b={" + Wartosc.formatuj(bd) + "}-{" + Wartosc.formatuj(d) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(jeden) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return jeden;
    }

    private String policzBzACBDA(String ac, String bd, String a) {
        String jeden = Wartosc.policz(a, bd, "*");
        String dwa = Wartosc.policz(jeden, ac, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzBzACBDA)+"</b></center><br>" +
                "$${a}/{AC}={b}/{BD}$$<br>" +
                "$$b={a*BD}/{AC}$$<br>" +
                "$$b={{" + Wartosc.formatuj(a) + "}*{" + Wartosc.formatuj(bd) + "}}/{" + Wartosc.formatuj(ac) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(ac) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzAzACBDB(String ac, String bd, String b) {
        String jeden = Wartosc.policz(ac, b, "*");
        String dwa = Wartosc.policz(jeden, bd, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzAzACBDB)+"</b></center><br>" +
                "$${a}/{AC}={b}/{BD}$$<br>" +
                "$$a={AC*b}/{BD}$$<br>" +
                "$$a={{" + Wartosc.formatuj(ac) + "}*{" + Wartosc.formatuj(b) + "}}/{" + Wartosc.formatuj(bd) + "}$$<br>" +
                "$$a={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(ac) + "}$$<br>" +
                "$$a={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzACzAEF(String a, String e, String f) {
        String jeden = Wartosc.policz(a, f, "*");
        String dwa = Wartosc.policz(jeden, e, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzACzAEF)+"</b></center><br>" +
                "$${a}/{e}={AC}/{f}$$<br>" +
                "$$AC={a*f}/{e}$$<br>" +
                "$$AC={{" + Wartosc.formatuj(a) + "}*{" + Wartosc.formatuj(f) + "}}/{" + Wartosc.formatuj(e) + "}$$<br>" +
                "$$AC={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(e) + "}$$<br>" +
                "$$AC={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzBDzBEF(String b, String e, String f) {
        String jeden = Wartosc.policz(b, f, "*");
        String dwa = Wartosc.policz(jeden, e, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzBDzBEF)+"</b></center><br>" +
                "$${b}/{e}={BD}/{f}$$<br>" +
                "$$BD={b*f}/{e}$$<br>" +
                "$$BD={{" + Wartosc.formatuj(b) + "}*{" + Wartosc.formatuj(f) + "}}/{" + Wartosc.formatuj(e) + "}$$<br>" +
                "$$BD={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(e) + "}$$<br>" +
                "$$BD={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzAzACEF(String ac, String e, String f) {
        String jeden = Wartosc.policz(ac, e, "*");
        String dwa = Wartosc.policz(jeden, f, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzAzACEF)+"</b></center><br>" +
                "$${a}/{e}={AC}/{f}$$<br>" +
                "$$a={AC*e}/{f}$$<br>" +
                "$$a={{" + Wartosc.formatuj(ac) + "}*{" + Wartosc.formatuj(e) + "}}/{" + Wartosc.formatuj(f) + "}$$<br>" +
                "$$a={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(f) + "}$$<br>" +
                "$$a={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzBzBDEF(String bd, String e, String f) {
        String jeden = Wartosc.policz(bd, e, "*");
        String dwa = Wartosc.policz(jeden, f, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzBzBDEF)+"</b></center><br>" +
                "$${b}/{e}={BD}/{f}$$<br>" +
                "$$b={BD*e}/{f}$$<br>" +
                "$$b={{" + Wartosc.formatuj(bd) + "}*{" + Wartosc.formatuj(e) + "}}/{" + Wartosc.formatuj(f) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(f) + "}$$<br>" +
                "$$b={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzFzBD(String bd, String b, String e) {
        String jeden = Wartosc.policz(bd, e, "*");
        String dwa = Wartosc.policz(jeden, b, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzFzBD)+"</b></center><br>" +
                "$${b}/{e}={BD}/{f}$$<br>" +
                "$$f={BD*e}/{b}$$<br>" +
                "$$f={{" + Wartosc.formatuj(bd) + "}*{" + Wartosc.formatuj(e) + "}}/{" + Wartosc.formatuj(b) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(b) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzEzBD(String bd, String b, String f) {
        String jeden = Wartosc.policz(f, b, "*");
        String dwa = Wartosc.policz(jeden, bd, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzEzBD)+"</b></center><br>" +
                "$${b}/{e}={BD}/{f}$$<br>" +
                "$$e={f*b}/{BD}$$<br>" +
                "$$f={{" + Wartosc.formatuj(f) + "}*{" + Wartosc.formatuj(b) + "}}/{" + Wartosc.formatuj(bd) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(bd) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzFzAC(String ac, String a, String e) {
        String jeden = Wartosc.policz(ac, e, "*");
        String dwa = Wartosc.policz(jeden, a, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzFzAC)+"</b></center><br>" +
                "$${a}/{e}={AC}/{f}$$<br>" +
                "$$f={AC*e}/{a}$$<br>" +
                "$$f={{" + Wartosc.formatuj(ac) + "}*{" + Wartosc.formatuj(e) + "}}/{" + Wartosc.formatuj(a) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(a) + "}$$<br>" +
                "$$f={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
        }
        return dwa;
    }

    private String policzEzAC(String ac, String a, String f) {
        String jeden = Wartosc.policz(a, f, "*");
        String dwa = Wartosc.policz(jeden, ac, "/");
        String solucja1 = "<center><b>"+getString(R.string.policzEzAC)+"</b></center><br>" +
                "$${a}/{e}={AC}/{f}$$<br>" +
                "$$e={a*f}/{ac}$$<br>" +
                "$$e={{" + Wartosc.formatuj(a) + "}*{" + Wartosc.formatuj(f) + "}}/{" + Wartosc.formatuj(ac) + "}$$<br>" +
                "$$e={" + Wartosc.formatuj(jeden) + "}/{" + Wartosc.formatuj(ac) + "}$$<br>" +
                "$$e={" + Wartosc.formatuj(dwa) + "}$$<br>" +
                "<center>*============================*</center>";
        if (!tekst1.contains(solucja1)) {
            tekst1 = tekst1 + solucja1;
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
                Toast.makeText(Tales.this, "W budowie...",
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
