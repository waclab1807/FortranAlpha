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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnFocusChangeListener;
import android.widget.Toast;

/**
 * Created by waclab1807 on 31.03.15.
 */

public class Szescian extends Activity implements OnFocusChangeListener {

    private Button licz;
    private Button clear;
    private Button sqrtbtn;
    private Button powbtn;
    private EditText pp_val;
    private EditText obj_val;
    private EditText pc_val;
    private EditText pb_val;
    private EditText a_val;
    private EditText d_val;
    private EditText D_val;
    private EditText obwp_val;
    private EditText obwb_val;
    private EditText triangle_val;
    private EditText lastFocused;
    public static String tekst = "";

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
        setContentView(R.layout.szescian);
        Global.mContext = this.getBaseContext();

        pp_val = (EditText) findViewById(R.id.pp);
        obj_val = (EditText) findViewById(R.id.obj);
        pb_val = (EditText) findViewById(R.id.pb);
        pc_val = (EditText) findViewById(R.id.pc);
        a_val = (EditText) findViewById(R.id.a);
        d_val = (EditText) findViewById(R.id.d);
        D_val = (EditText) findViewById(R.id.D);
        obwp_val = (EditText) findViewById(R.id.obwp);
        obwb_val = (EditText) findViewById(R.id.obwb);
        triangle_val = (EditText) findViewById(R.id.ptw);
        licz = (Button) findViewById(R.id.magic);
        clear = (Button) findViewById(R.id.clear);
        sqrtbtn = (Button) findViewById(R.id.sqrtbtn);
        powbtn = (Button) findViewById(R.id.powbtn);

        a_val.setOnFocusChangeListener(this);
        d_val.setOnFocusChangeListener(this);
        D_val.setOnFocusChangeListener(this);
        pp_val.setOnFocusChangeListener(this);
        pb_val.setOnFocusChangeListener(this);
        pc_val.setOnFocusChangeListener(this);
        obj_val.setOnFocusChangeListener(this);
        obwb_val.setOnFocusChangeListener(this);
        obwp_val.setOnFocusChangeListener(this);
        triangle_val.setOnFocusChangeListener(this);

        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean ba = false;
                boolean bd = false;
                boolean bD = false;
                boolean bobj = false;
                boolean bpp = false;
                boolean bpb = false;
                boolean bpc = false;
                boolean bobwp = false;
                boolean bobwb = false;
                boolean btriangle = false;

                tekst = "";

                int x = 0; //koniec petli, wszystko policzone

                while (x == 0) {
                    //obliczanie a lub pp lub obwp
                    //czy jest a
                    if (!isEmpty(a_val)) {
                        System.out.println("^^^^^^^^1");
                        a = a_val.getText().toString();
                        ba = true;
                        if (isEmpty(pp_val) && !bpp) {
                            pp_val.setText(policzPp(a));
                            bpp = true;
                        }
                        if (isEmpty(obwp_val) && !bobwp) {
                            obwp_val.setText(policzObwp(a));
                            bobwp = true;
                        }
                        if (isEmpty(obwb_val) && !bobwb) {
                            obwb_val.setText(policzObwb(a));
                            bobwb = true;
                        }
                        if (isEmpty(obj_val) && !bobj) {
                            obj_val.setText(policzObj(a));
                            bobj = true;
                        }
                        if (isEmpty(pc_val) && !bpc) {
                            pc_val.setText(policzPc(a));
                            bpc = true;
                        }
                        if (isEmpty(pb_val) && !bpb) {
                            pb_val.setText(policzPb(a));
                            bpb = true;
                        }
                        if (isEmpty(triangle_val) && !btriangle) {
                            triangle_val.setText(policzTriangle(a));
                            btriangle = true;
                        }
                        if (isEmpty(d_val) && !bd) {
                            d_val.setText(policzd(a));
                            bd = true;
                        }
                        if (isEmpty(D_val) && !bD) {
                            D_val.setText(policzD(a));
                            bD = true;
                        }
                    }else{
                        if (!isEmpty(pp_val)) {
                            System.out.println("^^^^^^^^2");
                            pp = pp_val.getText().toString();
                            bpp = true;
                            a_val.setText(policzAzPp(pp));
                        }
                        if (!isEmpty(obj_val)) {
                            System.out.println("^^^^^^^^3");
                            obj = obj_val.getText().toString();
                            bobj = true;
                            a_val.setText(policzAzObj(obj));
                        }
                        if (!isEmpty(pc_val)) {
                            System.out.println("^^^^^^^^4");
                            pc = pc_val.getText().toString();
                            bpc = true;
                            a_val.setText(policzAzPc(pc));
                        }
                        if (!isEmpty(pb_val)) {
                            System.out.println("^^^^^^^^5");
                            pb = pb_val.getText().toString();
                            bpb = true;
                            a_val.setText(policzAzPb(pb));
                        }
                        if (!isEmpty(d_val)) {
                            System.out.println("^^^^^^^^6");
                            d = d_val.getText().toString();
                            bd = true;
                            a_val.setText(policzAzd(d));
                        }
                        if (!isEmpty(D_val)) {
                            System.out.println("^^^^^^^^7");
                            D = D_val.getText().toString();
                            bD = true;
                            a_val.setText(policzAzD(D));
                        }
                        if (!isEmpty(triangle_val)) {
                            System.out.println("^^^^^^^^8");
                            triangle = triangle_val.getText().toString();
                            btriangle = true;
                            a_val.setText(policzAzTriangle(triangle));
                        }
                        if (!isEmpty(obwb_val)) {
                            System.out.println("^^^^^^^^9");
                            obwb = obwb_val.getText().toString();
                            bobwb = true;
                            a_val.setText(policzAzObwb(obwb));
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
                            !obj_val.getText().toString().equals("") &&
                            !pb_val.getText().toString().equals("") &&
                            !pc_val.getText().toString().equals("") &&
                            !triangle_val.getText().toString().equals("") &&
                            !D_val.getText().toString().equals("") &&
                            !d_val.getText().toString().equals("") &&
                            !obwb_val.getText().toString().equals("")
                            ) {
                        x = 1;
                        Toast.makeText(Szescian.this, "Skorzystaj z konta premium aby zobaczyć rozwiązanie",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a_val.setText("");
                d_val.setText("");
                D_val.setText("");
                pp_val.setText("");
                pb_val.setText("");
                pc_val.setText("");
                obj_val.setText("");
                obwp_val.setText("");
                obwb_val.setText("");
                triangle_val.setText("");
                tekst = "";

                Toast.makeText(Szescian.this, "Skasowane!",
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
        String solucja = "Obliczanie pola podstawy mając a \n\n" +
                "Pp = a^2 \n\n" +
                "Pp = " + a + "^2 \n\n" +
                "Pp = " + jeden + "\n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzAzObj(String Obj) {
        String jeden = Wartosc.policz(a,a,"*");
        String cztery = Wartosc.policz(Obj,jeden,"/");
        String solucja = "Obliczanie a mając objętość \n\n" +
                "Obj = Pp * a \n\n" +
                "a = Obj / Pp \n\n" +
                "Pp = a^2 \n\n" +
                "a = "+Obj+" / "+jeden+" \n\n" +
                "a = "+cztery+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return cztery;
    }

    private String policzAzPc(String Pc) {
        String piec = Wartosc.policz("6",Pc,"*");
        String dwa = Wartosc.policz("()\u221a("+piec+")","1","*");
        String trzy = Wartosc.policz(piec,"6","/");
        String solucja = "Obliczanie a mając pole całkowite \n\n" +
                "a = √(Pc / 6) \n\n" +
                "a = √(Pc) / √(6) \n\n" +
                "a = [√(Pc) * √(6)] / 6 \n\n" +
                "a = [√(Pc * 6)] / 6 \n\n" +
                "a = [√("+Pc+" * 6)] / 6 \n\n" +
                "a = [√("+piec+")] / 6 \n\n" +
                "a = ("+dwa+") / 6 \n\n" +
                "a = "+trzy+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return trzy;
    }

    private String policzAzPb(String Pb) {
        String dwa = Wartosc.policz("()\u221a("+Pb+")","1","*");
        String piec = Wartosc.policz(dwa,"2","/");
        String solucja = "Obliczanie a mając pole boczne \n\n" +
                "a = √(Pb / 4) \n\n" +
                "a = √(Pb) / 2 \n\n" +
                "a = √("+Pb+") / 2 \n\n" +
                "a = ("+dwa+") / 2 \n\n" +
                "a = "+piec+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return piec;
    }

    private String policzAzd(String d) {
        String dwa = Wartosc.policz("()\u221a(3)",d,"*");
        String piec = Wartosc.policz(dwa,"3","/");
        String solucja = "Obliczanie a mając przekątną bryły \n\n" +
                "d = a * √(3) \n\n" +
                "a = d / √(3) \n\n" +
                "a = [d * √(3)] / 3 \n\n" +
                "a = ["+d+" * √(3)] / 3 \n\n" +
                "a = ("+dwa+") / 3 \n\n" +
                "a = "+piec+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return piec;
    }

    private String policzAzD(String D) {
        String dwa = Wartosc.policz("()\u221a(2)",D,"*");
        String piec = Wartosc.policz(dwa,"2","/");
        String solucja = "Obliczanie a mając przekątną podstawy \n\n" +
                "D = a * √(2) \n\n" +
                "a = D / √(2) \n\n" +
                "a = [D * √(2)] / 2 \n\n" +
                "a = ["+D+" * √(2)] / 2 \n\n" +
                "a = ("+dwa+") / 2 \n\n" +
                "a = "+piec+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return piec;
    }

    private String policzAzTriangle(String Triangle) {
        String jeden = Wartosc.policz("2",Triangle,"*");
        String dwa = Wartosc.policz(jeden,"()\u221a(2)","/");
        String trzy = Wartosc.policz("()\u221a("+dwa+")","1","*");
        String solucja = "Obliczanie a mając pole trójkąta wewnętrznego \n\n" +
                "Ptw = (1 / 2) * D * a \n\n" +
                "D = a * √(2) \n\n" +
                "Ptw = (1 / 2) * a * √(2) * a \n\n" +
                "Ptw = [(a^2) * √(2)] / 2 \n\n" +
                "2 * Ptw = (a^2) * √(2) \n\n" +
                "(2 * Ptw) / √(2) = (a^2) \n\n" +
                "a = √[(2 * Ptw) / √(2)] \n\n" +
                "a = √[(2 * "+Triangle+") / √(2)] \n\n" +
                "a = √["+jeden+" / √(2)] \n\n" +
                "a = √["+dwa+"] \n\n" +
                "a = "+trzy+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return trzy;
    }

    private String policzD(String a) {
        String jeden = Wartosc.policz(a,"()\u221a(2)","*");
        String solucja = "Obliczanie przekątnej podstawy mając a \n\n" +
                "D = a * √(2) \n\n" +
                "D = "+a+" * √(2) \n\n" +
                "D = "+jeden+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzd(String a) {
        String jeden = Wartosc.policz(a,"()\u221a(3)","*");
        String solucja = "Obliczanie przekątnej bryły mając a \n\n" +
                "d = a * √(3) \n\n" +
                "d = "+a+" * √(3) \n\n" +
                "d = "+jeden+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzPb(String a) {
        String jeden = Wartosc.policz(a,a,"*");
        String dwa = Wartosc.policz("4",jeden,"*");
        String solucja = "Obliczanie pola bocznego mając a \n\n" +
                "Pb = 4 * (a^2) \n\n" +
                "Pb = 4 * ("+a+"^2)  \n\n" +
                "Pb = 4 * "+jeden+" \n\n" +
                "Pb = " + dwa + " \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzPc(String a) {
        String jeden = Wartosc.policz(a,a,"*");
        String dwa = Wartosc.policz(jeden,"6","*");
        String solucja = "Obliczanie pola całkowitego mając a \n\n" +
                "Pc = 6 * (a^2) \n\n" +
                "Pc = 6 * ("+a+"^2)  \n\n" +
                "Pc = 6 * "+jeden+" \n\n" +
                "Pc = " + dwa + " \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzObwb(String a) {
        String jeden = Wartosc.policz("12", a, "*");
        String solucja = "Obliczanie obwodu bryły mając a \n\n" +
                "ObwB = 12 * a \n\n" +
                "ObwB = 12 * "+a+" \n\n" +
                "ObwB = " + jeden + " \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzTriangle(String a) {
        String jeden = Wartosc.policz(a,a,"*");
        String dwa = Wartosc.policz(jeden,"()\u221a(2)","*");
        String trzy = Wartosc.policz(dwa,"2","/");
        String solucja = "Obliczanie pola trójkąta wewnętrznego mając a \n\n" +
                "Ptw = (1 / 2) * D * a \n\n" +
                "D = a * √(2) \n\n" +
                "Ptw = (1 / 2) * a * √(2) * a \n\n" +
                "Ptw = [(a^2) * √(2)] / 2 \n\n" +
                "Ptw = [("+a+"^2) * √(2)] / 2 \n\n" +
                "Ptw = ["+jeden+" * √(2)] / 2 \n\n" +
                "Ptw = ["+dwa+"] / 2 \n\n" +
                "Ptw = "+trzy+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return trzy;
    }

    private String policzObj(String a) {
        String jeden = Wartosc.policz(a,a,"*");
        String dwa = Wartosc.policz(jeden,a,"*");
        String solucja = "Obliczanie objętości mając a \n\n" +
                "Obj = a^3 \n\n" +
                "Obj = "+a+"^3 \n\n" +
                "Obj = "+dwa+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return dwa;
    }

    private String policzObwp(String a) {
        String jeden = Wartosc.policz("4",a,"*");
        String solucja = "Obliczanie obwodu podstawy mając a \n\n" +
                "ObwP = 4 * a \n\n" +
                "ObwP = 4 * "+a+" \n\n" +
                "ObwP = "+jeden+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return jeden;
    }

    private String policzAzPp(String Pp) {
        String trzy = Wartosc.policz("()\u221a("+Pp+")","1","*");
        String solucja = "Obliczanie a mając pole podstawy \n\n" +
                "Pp = a^2 \n\n" +
                "a = √(Pp) \n\n" +
                "a = √("+Pp+") \n\n" +
                "a = " + trzy + "\n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
        }
        return trzy;
    }

    private String policzAzObwb(String Obwb){
        String trzy = Wartosc.policz(Obwb,"12","/");
        String solucja = "Obliczanie a mając obwód bryły \n\n" +
                "ObwB = 12 * a \n\n" +
                "a = (ObwB / 12) \n\n" +
                "a = ("+Obwb +" / 12) \n\n" +
                "a = "+trzy+" \n\n" +
                "*===========================*\n\n";
        if(!tekst.contains(solucja)) {
            tekst = tekst + solucja;
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
                Toast.makeText(Szescian.this, "W budowie...",
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
