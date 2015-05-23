package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pl.wlabuda.fortranalpha.R.id;
import pl.wlabuda.fortranalpha.R.layout;

public class TrojkatProstokatny extends Activity implements OnFocusChangeListener{

    private Button licz;
    private Button clear;
    private Button solutionbtn;
    private Button sqrtbtn;
    private Button powbtn;
    private EditText pp_val;
    private EditText a_val;
    private EditText h_val;
    private EditText obwp_val;
    private TextView solution;
    private EditText lastFocused;
    public static String tekst = "";
    private static Context context;

    String a;
    String pp;
    String H;
    String h;
    String obwp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.graniastoslup_prawidlowy_trojkatny);

        TrojkatProstokatny.context = getApplicationContext();
/*
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
*/
        pp_val = (EditText) findViewById(id.pp);
        a_val = (EditText) findViewById(id.a);
        h_val = (EditText) findViewById(id.h);
        obwp_val = (EditText) findViewById(id.obj);
        licz = (Button) findViewById(id.magic);
        clear = (Button) findViewById(id.clear);
        sqrtbtn = (Button) findViewById(id.btnsqrt);
        powbtn = (Button) findViewById(id.btnpow);
        solutionbtn = (Button) findViewById(id.solutionbtn);
        solution = (TextView) findViewById(id.solution);

        a_val.setOnFocusChangeListener(this);
        h_val.setOnFocusChangeListener(this);
        pp_val.setOnFocusChangeListener(this);
        obwp_val.setOnFocusChangeListener(this);

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

                solution.setText("");
                tekst = "";

                int x = 0; //koniec petli, wszystko policzone

                while (x == 0) {
                    //obliczanie a lub h lub pp lub obwp
                    //czy jest a
                    if (!isEmpty(a_val)) {
                        System.out.println("^^^^^^^^1");
                        a = a_val.getText().toString();
                        ba = true;
                        if (isEmpty(pp_val) && !bpp) {
                            pp_val.setText(policzPp(a));
                            bpp = true;
                        }
                        if (isEmpty(h_val) && !bh) {
                            h_val.setText(policzhza(a));
                            bh = true;
                        }
                        if (isEmpty(obwp_val) && !bobwp) {
                            obwp_val.setText(policzObwp(a));
                            bobwp = true;
                        }
                    }
                    //czy jest h
                    if (!isEmpty(h_val)) {
                        System.out.println("^^^^^^^^2");
                        h = h_val.getText().toString();
                        bh = true;
                        if (isEmpty(a_val) && !ba) {
                            a_val.setText(policzAzh(h));
                            ba = true;
                        }
                        if (isEmpty(pp_val) && !bpp) {
                            pp_val.setText(policzPp(policzAzh(h)));
                            bpp = true;
                        }
                        if (isEmpty(obwp_val) && !bobwp) {
                            obwp_val.setText(policzObwp(policzAzh(h)));
                            bobwp = true;
                        }
                    }
                    //czy jest pp
                    if (!isEmpty(pp_val)) {
                        System.out.println("^^^^^^^^3");
                        pp = pp_val.getText().toString();
                        bpp = true;
                        if (isEmpty(a_val) && !ba) {
                            a_val.setText(policzAzP(pp));
                            ba = true;
                        }
                        if (h_val.getText().toString().equals("") && !bh) {
                            h_val.setText(policzhzP(pp));
                            bh = true;
                        }
                        if (obwp_val.getText().toString().equals("") && !bobwp) {
                            obwp_val.setText(policzObwp(policzAzP(pp)));
                            bobwp = true;
                        }
                    }
                    //czy jest obwp
                    if (!isEmpty(obwp_val)) {
                        System.out.println("^^^^^^^^4");
                        obwp = obwp_val.getText().toString();
                        bobwp = true;
                        if (isEmpty(a_val) && !ba) {
                            a_val.setText(policzAzObwp(obwp));
                            ba = true;
                        }
                        if (isEmpty(pp_val) && !bpp) {
                            pp_val.setText(policzPp(policzAzObwp(obwp)));
                            bpp = true;
                        }
                        if (isEmpty(h_val) && !bh) {
                            h_val.setText(policzhza(policzAzObwp(obwp)));
                            bh = true;
                        }
                    }
                    //za malo danych
                    if (isEmpty(a_val) && isEmpty(h_val) && isEmpty(pp_val) && isEmpty(obwp_val)) {
                        x = 1;
                        Toast.makeText(TrojkatProstokatny.this, "Za mało danych aby policzyć!",
                                Toast.LENGTH_LONG).show();
                    }
                    //wszystko policzone, koniec petli
                    if (!a_val.getText().toString().equals("") &&
                            !h_val.getText().toString().equals("") &&
                            !pp_val.getText().toString().equals("") &&
                            !obwp_val.getText().toString().equals("")
                            ) {
                        x = 1;
                        Toast.makeText(TrojkatProstokatny.this, "Skorzystaj z konta premium aby zobaczyć rozwiązanie",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a_val.setText("");
                h_val.setText("");
                pp_val.setText("");
                obwp_val.setText("");
                solution.setText("");
                tekst = "";

                Toast.makeText(TrojkatProstokatny.this, "Skasowane!",
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

    public static Context getAppContext() {
        return TrojkatProstokatny.context;
    }

    private String policzPp(String a) {
        String jeden = Wartosc.policz(a,a,"*");
        String dwa = Wartosc.policz(Wartosc.policz(Wartosc.policz(a,a,"*"),"()\u221a(3)","*"),"4","/");
        String solucja = "Obliczanie pola mając a \n\n" +
                "P = [(a^2) * √3] / 4 \n\n" +
                "P = [(" + a + "^2) * √(3)] / 4 \n\n" +
                "P = (" + jeden + ")√(3) / 4 \n\n" +
                "P = " + dwa + "\n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzObwp(String a) {
        String jeden = Wartosc.policz("3",a,"*");
        String solucja = "Obliczanie obwodu mając a \n\n" +
                "ObwP = a * 3 \n\n" +
                "ObwP = "+a+" * 3 \n\n" +
                "ObwP = "+jeden+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzAzh(String h) {
        String jeden = Wartosc.policz(h,"(2)\u221a(3)","*");
        String dwa = Wartosc.policz(jeden,"3","/");
        String solucja = "Obliczanie a mając h \n\n" +
                "h = [a * √(3)] / 2 \n\n" +
                "a = [(2)√(3) * h] / 3 \n\n" +
                "a = [(2)√(3) * " + h + "]/3 \n\n" +
                "a = [" + jeden + "] / 3 \n\n" +
                "a = " + dwa + "\n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return  dwa;
    }

    private String policzAzP(String Pp) {
        String jeden = Wartosc.policz(Pp,"4","*");
        String dwa = Wartosc.policz(jeden,"()\u221a(3)","/");
        String trzy = Wartosc.policz("()\u221a("+dwa+")","1","*");
        String solucja = "Obliczanie a mając pole \n\n" +
                "P = [(a^2) * √(3)] / 4 \n\n" +
                "4 * P = [(a^2) * √(3)] \n\n" +
                "(4 * P) / √(3) = (a^2) \n\n" +
                "a = √[(4 * P) / √(3)] \n\n" +
                "a = √[(4 * "+Pp+") / √(3)] \n\n" +
                "a = √[" +jeden +" / √(3)] \n\n" +
                "a = √["+dwa+"] \n\n" +
                "a = " + trzy + "\n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return trzy;
    }

    private String policzAzObwp(String Obwp){
        String jeden = Wartosc.policz(Obwp,"3","/");
        String solucja = "Obliczanie a mając obwód \n\n" +
                "ObwP = a * 3 \n\n" +
                "a = ObwP / 3 \n\n" +
                "a = "+Obwp+" / 3 \n\n" +
                "a = "+jeden+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzhza(String a) {
        String jeden = Wartosc.policz(a,"()\u221a(3)","*");
        String dwa = Wartosc.policz(jeden,"2","/");
        String solucja = "Obliczanie h mając a \n\n" +
                "h = [a * √(3)] / 2 \n\n" +
                "h = [" + a + " * √(3)] / 2 \n\n" +
                "h = (" + jeden + ") / 2 \n\n" +
                "h = " + dwa + "\n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzhzP(String Pp) {
        String jeden = Wartosc.policz("3",Pp,"*");
        String dwa = Wartosc.policz(jeden,"()\u221a(3)","/");
        String trzy = Wartosc.policz("()\u221a("+dwa+")","1","*");
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
                "h = √[("+jeden+") / √(3)] \n\n" +
                "h = √("+dwa+") \n\n" +
                "h = " + trzy + "\n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
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
        switch (item.getItemId()) {
            case id.item1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder
                        .setTitle("O autorze:")
                        .setMessage("Wacław Łabuda \ne-mail: waclab1807@gmail.com \nPolska/Nowy Sącz")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("OK", null)
                        .show();
                break;
            case id.item2:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2
                        .setTitle("Plany na przyszłość:")
                        .setMessage("Kąty alfa, beta itd. \n" +
                                "Dynamiczne oznaczenia pól, które można policzyć, \n" +
                                "Wbudowany kalkulator, \n" +
                                "Wiele, wiele innych...")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("OK", null)
                        .show();
                break;
            case id.item3:
                Toast.makeText(TrojkatProstokatny.this, "W budowie...",
                        Toast.LENGTH_LONG).show();
                break;
            case id.item4:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
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
