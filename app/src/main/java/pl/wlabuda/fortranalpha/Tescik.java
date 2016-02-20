package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by waclab1807 on 28.12.15.
 */
public class Tescik extends Activity{

    private EditText poleWartoscA;
    private EditText poleOperator;
    private EditText poleWartoscB;
    private TextView poleWynik;
    private Button btnPolicz;
    private Button btnPierwiastek;
    private Button btnPotega;
    private Button btnPi;
//    private TextView pier3;
//    private TextView pier4;
//    private TextView pier5;
//    private TextView pier6;
//    private TextView pier7;
//    private TextView pier8;
//    private TextView pier9;
//    private TextView pier10;
//    private TextView pier11;
//    private TextView pier12;
//    private TextView pier13;
//    private TextView pier14;
//    private TextView pier15;
//    private TextView pier16;
//    private TextView pier17;
//    private TextView pier18;
//    private TextView pier19;
//    private TextView pier20;
//    private TextView pier21;
//    private TextView pier22;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tescik);

        poleWartoscA = (EditText) findViewById(R.id.poleWartoscA);
        poleOperator = (EditText) findViewById(R.id.poleOperator);
        poleWartoscB = (EditText) findViewById(R.id.poleWartoscB);
        poleWynik = (TextView) findViewById(R.id.poleWynik);
        btnPolicz = (Button) findViewById(R.id.btnPolicz1);
        btnPierwiastek = (Button) findViewById(R.id.pierw1);
        btnPotega = (Button) findViewById(R.id.potega1);
        btnPi = (Button) findViewById(R.id.pi1);

        btnPolicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poleWynik.setText(Wartosc.policz(poleWartoscA.getText().toString(),poleWartoscB.getText().toString(),poleOperator.getText().toString()));
            }
        });

        btnPierwiastek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poleWartoscA.append("()√()");
            }
        });

        btnPotega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poleWartoscA.append("()^()");
            }
        });

        btnPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poleWartoscA.append("()π");
            }
        });

//        pier1 = (TextView) findViewById(R.id.pier1);
//        pier2 = (TextView) findViewById(R.id.pier2);
//        pier3 = (TextView) findViewById(R.id.pier3);
//        pier4 = (TextView) findViewById(R.id.pier4);
//        pier5 = (TextView) findViewById(R.id.pier5);
//        pier6 = (TextView) findViewById(R.id.pier6);
//        pier7 = (TextView) findViewById(R.id.pier7);
//        pier8 = (TextView) findViewById(R.id.pier8);
//        pier9 = (TextView) findViewById(R.id.pier9);
//        pier10 = (TextView) findViewById(R.id.pier10);
//        pier11 = (TextView) findViewById(R.id.pier11);
//        pier12 = (TextView) findViewById(R.id.pier12);
//        pier13 = (TextView) findViewById(R.id.pier13);
//        pier14 = (TextView) findViewById(R.id.pier14);
//        pier15 = (TextView) findViewById(R.id.pier15);
//        pier16 = (TextView) findViewById(R.id.pier16);
//        pier17 = (TextView) findViewById(R.id.pier17);
//        pier18 = (TextView) findViewById(R.id.pier18);
//        pier19 = (TextView) findViewById(R.id.pier19);
//        pier20 = (TextView) findViewById(R.id.pier20);
//        pier21 = (TextView) findViewById(R.id.pier21);
//        pier22 = (TextView) findViewById(R.id.pier22);
//
//        pier1.setText(Wartosc.policz("3/4","π","/"));
//        pier2.setText(Wartosc.policz("3/4","2π","/"));
//        pier3.setText(Wartosc.policz("3/4","(1/2)π","/"));
//        pier4.setText(Wartosc.policz("√4","2π","/"));
//        pier5.setText(Wartosc.policz("3π","3/4","+"));
//        pier6.setText(Wartosc.policz("3π","8/4","+"));
//        pier7.setText(Wartosc.policz("3π","3/4","-"));
//        pier8.setText(Wartosc.policz("3π","8/4","-"));
//        pier9.setText(Wartosc.policz("3π","3/4","*"));
//        pier10.setText(Wartosc.policz("3π","8/4","*"));
//        pier11.setText(Wartosc.policz("3π","3/4","/"));
//        pier12.setText(Wartosc.policz("3π","8/4","/"));
//        pier13.setText(Wartosc.policz("3/4","-3π","/"));
//        pier14.setText(Wartosc.policz("8/4","-3π","/"));
//        pier15.setText(Wartosc.policz("-3","-2π","-"));
//        pier16.setText(Wartosc.policz("-3","-2π","+"));
//        pier17.setText(Wartosc.policz("3/4","π","+"));
//        pier18.setText(Wartosc.policz("3/4","2π","+"));
//        pier19.setText(Wartosc.policz("3/4","(1/2)π","+"));
//        pier20.setText(Wartosc.policz("3/4","π","-"));
//        pier21.setText(Wartosc.policz("3/4","2π","-"));
//        pier22.setText(Wartosc.policz("3/4","(1/2)π","-"));

        /**pierwiastek z pierwiastkiem**/
//        pier1.setText(Wartosc.policz("√3","√2","+"));
//        pier2.setText(Wartosc.policz("√3","√2","-"));
//        pier3.setText(Wartosc.policz("√3","√2","*"));
//        pier4.setText(Wartosc.policz("√3","√2","/"));
//        pier5.setText(Wartosc.policz("√3","√3","+"));
//        pier6.setText(Wartosc.policz("√3","√3","-"));
//        pier7.setText(Wartosc.policz("√3","√3","*"));
//        pier8.setText(Wartosc.policz("√3","√3","/"));
//        pier9.setText(Wartosc.policz("√4","√3","+"));
//        pier10.setText(Wartosc.policz("√4","√3","-"));
//        pier11.setText(Wartosc.policz("√4","√3","*"));
//        pier12.setText(Wartosc.policz("√4","√3","/"));
//        pier13.setText(Wartosc.policz("√4","√4","+"));
//        pier14.setText(Wartosc.policz("√4","√4","-"));
//        pier15.setText(Wartosc.policz("√4","√4","*"));
//        pier16.setText(Wartosc.policz("√4","√4","/"));
//        pier17.setText(Wartosc.policz("3√2","2√2","+"));
//        pier18.setText(Wartosc.policz("3√2","2√2","-"));
//        pier19.setText(Wartosc.policz("3√2","2√2","*"));
//        pier20.setText(Wartosc.policz("3√2","2√2","/"));
//        pier21.setText(Wartosc.policz("3√3","2√3","+"));
//        pier22.setText(Wartosc.policz("3√4","1","*"));


        /**pi**/
//        pier1.setText(Wartosc.policz("2π","3π","+"));
//        pier2.setText(Wartosc.policz("2π","3π","-"));
//        pier3.setText(Wartosc.policz("2π","3π","*"));
//        pier4.setText(Wartosc.policz("2π","3π","/"));
//        pier5.setText(Wartosc.policz("π","2π","+"));
//        pier6.setText(Wartosc.policz("2π","3","+"));
//        pier7.setText(Wartosc.policz("2π","3","-"));
//        pier8.setText(Wartosc.policz("2π","3","*"));
//        pier9.setText(Wartosc.policz("2π","3","/"));
//        pier10.setText(Wartosc.policz("2π","2","/"));
//        pier11.setText(Wartosc.policz("-2","2π","/"));
//        pier12.setText(Wartosc.policz("3","2π","/"));
//        pier13.setText(Wartosc.policz("√π","1","*"));
//        pier14.setText(Wartosc.policz("π^2","1","*"));
//        pier15.setText(Wartosc.policz("2^π","1","*"));
//        pier16.setText(Wartosc.policz("2π","2^3","+"));
//        pier17.setText(Wartosc.policz("2π","√(3)","+"));
//        pier18.setText(Wartosc.policz("2π","√(4)","+"));
//        pier19.setText(Wartosc.policz("2π","√(3)","-"));
//        pier20.setText(Wartosc.policz("2π","√(4)","-"));
//        pier21.setText(Wartosc.policz("2π","√3","*"));
//        pier22.setText(Wartosc.policz("2π","√4","*"));
//        pier1.setText(Wartosc.policz("2π","√3","/"));
//        pier2.setText(Wartosc.policz("2π","√4","/"));
//        pier3.setText(Wartosc.policz("√2","2π","/"));
//        pier4.setText(Wartosc.policz("√4","2π","/"));
//        pier5.setText(Wartosc.policz("3π","3/4","+"));
//        pier6.setText(Wartosc.policz("3π","8/4","+"));
//        pier7.setText(Wartosc.policz("3π","3/4","-"));
//        pier8.setText(Wartosc.policz("3π","8/4","-"));
//        pier9.setText(Wartosc.policz("3π","3/4","*"));
//        pier10.setText(Wartosc.policz("3π","8/4","*"));
//        pier11.setText(Wartosc.policz("3π","3/4","/"));
//        pier12.setText(Wartosc.policz("3π","8/4","/"));
//        pier13.setText(Wartosc.policz("3/4","-3π","/"));
//        pier14.setText(Wartosc.policz("8/4","-3π","/"));
//        pier15.setText(Wartosc.policz("-3","-2π","-"));
//        pier16.setText(Wartosc.policz("-3","-2π","+"));
//        pier17.setText(Wartosc.policz("3/4","π","+"));
//        pier18.setText(Wartosc.policz("3/4","2π","+"));
//        pier19.setText(Wartosc.policz("3/4","(1/2)π","+"));
//        pier20.setText(Wartosc.policz("3/4","π","-"));
//        pier21.setText(Wartosc.policz("3/4","2π","-"));
//        pier22.setText(Wartosc.policz("3/4","(1/2)π","-"));
    }

}
