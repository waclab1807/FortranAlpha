package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by waclab1807 on 28.12.15.
 */
public class Tescik extends Activity {

    private TextView pier1;
    private TextView pier2;
    private TextView pier3;
    private TextView pier4;
    private TextView pier5;
    private TextView pier6;
    private TextView pier7;
    private TextView pier8;
    private TextView pier9;
    private TextView pier10;
    private TextView pier11;
    private TextView pier12;
    private TextView pier13;
    private TextView pier14;
    private TextView pier15;
    private TextView pier16;
    private TextView pier17;
    private TextView pier18;
    private TextView pier19;
    private TextView pier20;
    private TextView pier21;
    private TextView pier22;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tescik);

        pier1 = (TextView) findViewById(R.id.pier1);
        pier2 = (TextView) findViewById(R.id.pier2);
        pier3 = (TextView) findViewById(R.id.pier3);
        pier4 = (TextView) findViewById(R.id.pier4);
        pier5 = (TextView) findViewById(R.id.pier5);
        pier6 = (TextView) findViewById(R.id.pier6);
        pier7 = (TextView) findViewById(R.id.pier7);
        pier8 = (TextView) findViewById(R.id.pier8);
        pier9 = (TextView) findViewById(R.id.pier9);
        pier10 = (TextView) findViewById(R.id.pier10);
        pier11 = (TextView) findViewById(R.id.pier11);
        pier12 = (TextView) findViewById(R.id.pier12);
        pier13 = (TextView) findViewById(R.id.pier13);
        pier14 = (TextView) findViewById(R.id.pier14);
        pier15 = (TextView) findViewById(R.id.pier15);
        pier16 = (TextView) findViewById(R.id.pier16);
        pier17 = (TextView) findViewById(R.id.pier17);
        pier18 = (TextView) findViewById(R.id.pier18);
        pier19 = (TextView) findViewById(R.id.pier19);
        pier20 = (TextView) findViewById(R.id.pier20);
        pier21 = (TextView) findViewById(R.id.pier21);
        pier22 = (TextView) findViewById(R.id.pier22);

//        pier1.setText(Wartosc.policz("", "", "+"));//
//        pier2.setText(Wartosc.policz("", "", "-"));//
//        pier3.setText(Wartosc.policz("", "", "*"));//
//        pier4.setText(Wartosc.policz("", "", "/"));//
//        pier5.setText(Wartosc.policz("", "", "/"));//
//        pier6.setText(Wartosc.policz("", "", "*"));//
//        pier7.setText(Wartosc.policz("", "", "*"));//
//        pier8.setText(Wartosc.policz("", "", "*"));//
//        pier9.setText(Wartosc.policz("", "", "*"));//
//        pier10.setText(Wartosc.policz("","","*"));//
//        pier11.setText(Wartosc.policz("","","*"));//
//        pier12.setText(Wartosc.policz("","","*"));//
//        pier13.setText(Wartosc.policz("","","*"));//
//        pier14.setText(Wartosc.policz("","","*"));//
//        pier15.setText(Wartosc.policz("","","+"));//
//        pier16.setText(Wartosc.policz("","","*"));//
//        pier17.setText(Wartosc.policz("","","*"));//
//        pier18.setText(Wartosc.policz("","","*"));//
//        pier19.setText(Wartosc.policz("","","*"));//
//        pier20.setText(Wartosc.policz("","","*"));//
//        pier21.setText(Wartosc.policz("","","*"));//
//        pier22.setText(Wartosc.policz("","","*"));//

        /**liczba z liczba**/
        pier1.setText(Wartosc.policz("2","3","+"));
        pier2.setText(Wartosc.policz("2","3","-"));
        pier3.setText(Wartosc.policz("2","3","*"));
        pier4.setText(Wartosc.policz("2","3","/"));
        pier5.setText(Wartosc.policz("3","2","-"));
        pier6.setText(Wartosc.policz("3","2","/"));
        pier7.setText(Wartosc.policz("2","6","/"));
        pier8.setText(Wartosc.policz("6","2","/"));
        pier9.setText(Wartosc.policz("3","0","*"));
        pier10.setText(Wartosc.policz("2","0","/"));
        pier11.setText(Wartosc.policz("0","2","/"));
        pier12.setText(Wartosc.policz("-2","3","-"));
        pier13.setText(Wartosc.policz("-2","-3","-"));
        pier14.setText(Wartosc.policz("-2","-3","+"));
        pier15.setText(Wartosc.policz("-2","3","+"));
        pier16.setText(Wartosc.policz("-2","3","*"));
        pier17.setText(Wartosc.policz("-2","3","/"));
//        pier1.setText(Wartosc.policz("-2","3","+"));
//        pier2.setText(Wartosc.policz("-2","3","-"));
//        pier3.setText(Wartosc.policz("-2","3","*"));
//        pier4.setText(Wartosc.policz("-2","3","/"));
//        pier5.setText(Wartosc.policz("-3","2","-"));
//        pier6.setText(Wartosc.policz("-3","2","/"));
//        pier7.setText(Wartosc.policz("-2","6","/"));
//        pier8.setText(Wartosc.policz("-6","2","/"));
//        pier9.setText(Wartosc.policz("-3","0","*"));
//        pier10.setText(Wartosc.policz("-2","0","/"));
//        pier11.setText(Wartosc.policz("-0","2","/"));
//        pier1.setText(Wartosc.policz("2","-3","+"));
//        pier2.setText(Wartosc.policz("2","-3","-"));
//        pier3.setText(Wartosc.policz("2","-3","*"));
//        pier4.setText(Wartosc.policz("2","-3","/"));
//        pier5.setText(Wartosc.policz("3","-2","-"));
//        pier6.setText(Wartosc.policz("3","-2","/"));
//        pier7.setText(Wartosc.policz("2","-6","/"));
//        pier8.setText(Wartosc.policz("6","-2","/"));
//        pier9.setText(Wartosc.policz("3","-0","*"));
//        pier10.setText(Wartosc.policz("2","-0","/"));
//        pier11.setText(Wartosc.policz("0","-2","/"));
//        pier1.setText(Wartosc.policz("-2","-3","+"));
//        pier2.setText(Wartosc.policz("-2","-3","-"));
//        pier3.setText(Wartosc.policz("-2","-3","*"));
//        pier4.setText(Wartosc.policz("-2","-3","/"));
//        pier5.setText(Wartosc.policz("-3","-2","-"));
//        pier6.setText(Wartosc.policz("-3","-2","/"));
//        pier7.setText(Wartosc.policz("-2","-6","/"));
//        pier8.setText(Wartosc.policz("-6","-2","/"));
//        pier9.setText(Wartosc.policz("-3","-0","*"));
//        pier10.setText(Wartosc.policz("-2","-0","/"));
//        pier11.setText(Wartosc.policz("-0","-2","/"));
//        pier1.setText(Wartosc.policz("0","0","+"));
//        pier2.setText(Wartosc.policz("0","0","-"));
//        pier3.setText(Wartosc.policz("0","0","*"));
//        pier4.setText(Wartosc.policz("0","0","/"));

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
//        pier1.setText(Wartosc.policz("√4","√9","+"));
//        pier2.setText(Wartosc.policz("√4","√9","-"));
//        pier3.setText(Wartosc.policz("√4","√9","*"));
//        pier4.setText(Wartosc.policz("√4","√9","/"));
//        pier1.setText(Wartosc.policz("2√3","√3","/"));
//        pier2.setText(Wartosc.policz("6√3","2√3","/"));
//        pier3.setText(Wartosc.policz("√0","1","*"));
//        pier4.setText(Wartosc.policz("-√2","1","*"));
//        pier5.setText(Wartosc.policz("√-2","1","*")); //tu wywala
//        pier6.setText(Wartosc.policz("-√-2","1","*"));
//        pier1.setText(Wartosc.policz("-1√3","√2","+"));
//        pier2.setText(Wartosc.policz("-1√3","√2","-"));
//        pier3.setText(Wartosc.policz("-1√3","√2","*"));
//        pier4.setText(Wartosc.policz("-1√3","√2","/"));
//        pier5.setText(Wartosc.policz("-1√3","√3","+"));
//        pier6.setText(Wartosc.policz("-1√3","√3","-"));
//        pier7.setText(Wartosc.policz("-1√3","√3","*"));
//        pier8.setText(Wartosc.policz("-1√3","√3","/"));
//        pier9.setText(Wartosc.policz("-1√4","√3","+"));
//        pier10.setText(Wartosc.policz("-1√4","√3","-"));
//        pier11.setText(Wartosc.policz("-1√4","√3","*"));
//        pier12.setText(Wartosc.policz("-1√4","√3","/"));
//        pier13.setText(Wartosc.policz("-1√4","√9","+"));
//        pier14.setText(Wartosc.policz("-1√4","√9","-"));
//        pier15.setText(Wartosc.policz("-1√4","√9","*"));
//        pier16.setText(Wartosc.policz("-1√4","√9","/"));
//        pier17.setText(Wartosc.policz("-3√2","2√2","+"));
//        pier18.setText(Wartosc.policz("-3√2","2√2","-"));
//        pier19.setText(Wartosc.policz("-3√2","2√2","*"));
//        pier20.setText(Wartosc.policz("-3√2","2√2","/"));
//        pier21.setText(Wartosc.policz("-3√2","2√3","+"));
//        pier22.setText(Wartosc.policz("-3√2","2√3","-"));
//        pier17.setText(Wartosc.policz("-3√2","2√3","*"));
//        pier18.setText(Wartosc.policz("-3√2","2√3","/"));
//        pier19.setText(Wartosc.policz("-3√4","1","*"));
//        pier20.setText(Wartosc.policz("-2√3","√3","/"));
//        pier21.setText(Wartosc.policz("-6√3","2√3","/"));
//        pier22.setText(Wartosc.policz("-1√4","√16","/"));
//        pier1.setText(Wartosc.policz("√3","-1√2","+"));
//        pier2.setText(Wartosc.policz("√3","-1√2","-"));
//        pier3.setText(Wartosc.policz("√3","-1√2","*"));
//        pier4.setText(Wartosc.policz("√3","-1√2","/"));
//        pier5.setText(Wartosc.policz("√3","-1√3","+"));
//        pier6.setText(Wartosc.policz("√3","-1√3","-"));
//        pier7.setText(Wartosc.policz("√3","-1√3","*"));
//        pier8.setText(Wartosc.policz("√3","-1√3","/"));
//        pier9.setText(Wartosc.policz("√4","-1√3","+"));
//        pier10.setText(Wartosc.policz("√4","-1√3","-"));
//        pier11.setText(Wartosc.policz("√4","-1√3","*"));
//        pier12.setText(Wartosc.policz("√4","-1√3","/"));
//        pier13.setText(Wartosc.policz("√4","-1√9","+"));
//        pier14.setText(Wartosc.policz("√4","-1√9","-"));
//        pier15.setText(Wartosc.policz("√4","-1√9","*"));
//        pier16.setText(Wartosc.policz("√4","-1√9","/"));
//        pier17.setText(Wartosc.policz("3√2","-2√3","+"));
//        pier18.setText(Wartosc.policz("3√2","-2√3","-"));
//        pier19.setText(Wartosc.policz("3√2","-2√2","*"));
//        pier20.setText(Wartosc.policz("3√2","-2√2","/"));
//        pier21.setText(Wartosc.policz("3√2","-2√3","+"));
//        pier22.setText(Wartosc.policz("3√2","-2√3","-"));
//        pier1.setText(Wartosc.policz("3√2","-2√3","*"));
//        pier2.setText(Wartosc.policz("3√2","-2√3","/"));
//        pier3.setText(Wartosc.policz("3√4","-1","*"));
//        pier4.setText(Wartosc.policz("2√3","-1√3","/"));
//        pier5.setText(Wartosc.policz("6√3","-2√3","/"));
//        pier6.setText(Wartosc.policz("√4","-1√16","/"));
//        pier1.setText(Wartosc.policz("-1√3","-1√2","+"));//(-1)√3+(-1)√2
//        pier2.setText(Wartosc.policz("-1√3","-1√2","-"));//(-1)√3-(-1)√2
//        pier3.setText(Wartosc.policz("-1√3","-1√2","*"));//√6
//        pier4.setText(Wartosc.policz("-1√3","-1√2","/"));//√6/2
//        pier5.setText(Wartosc.policz("-1√3","-1√3","+"));//-2√3
//        pier6.setText(Wartosc.policz("-1√3","-1√3","-"));//0
//        pier7.setText(Wartosc.policz("-1√3","-1√3","*"));//3
//        pier8.setText(Wartosc.policz("-1√3","-1√3","/"));//1
//        pier9.setText(Wartosc.policz("-1√4","-1√3","+"));//(-1)√3+-2
//        pier10.setText(Wartosc.policz("-1√4","-1√3","*"));//2√3
//        pier11.setText(Wartosc.policz("-1√4","-1√3","/"));//(2√3)/3
//        pier13.setText(Wartosc.policz("-1√4","-1√9","+"));//-5
//        pier14.setText(Wartosc.policz("-1√4","-1√9","-"));//1
//        pier15.setText(Wartosc.policz("-1√4","-1√9","*"));//6
//        pier16.setText(Wartosc.policz("-1√4","-1√9","/"));//2/3
//        pier17.setText(Wartosc.policz("-3√2","-2√3","+"));//-3√2+-2√3
//        pier18.setText(Wartosc.policz("-3√2","-2√3","-"));//-3√2--2√3
//        pier19.setText(Wartosc.policz("-3√2","-2√2","*"));//12
//        pier20.setText(Wartosc.policz("-3√2","-2√2","/"));//3/2
//        pier21.setText(Wartosc.policz("-3√2","-2√3","+"));//-3√2+-2√3
//        pier22.setText(Wartosc.policz("-3√2","-2√3","-"));//-3√2--2√3
//        pier17.setText(Wartosc.policz("-3√2","-2√3","*"));//6√6
//        pier18.setText(Wartosc.policz("-3√2","-2√3","/"));//√6/2
//        pier19.setText(Wartosc.policz("-3√4","-1","*"));//6
//        pier20.setText(Wartosc.policz("-2√3","-1√3","/"));//2
//        pier21.setText(Wartosc.policz("-6√3","-2√3","/"));//3
//        pier22.setText(Wartosc.policz("-1√4","-1√16","/"));//1/2
    }

    /**ułamki**/

//    pier1.setText(Wartosc.policz("3/4","2/3","+"));//17/12
//    pier2.setText(Wartosc.policz("3/4","2/3","-"));//1/12
//    pier3.setText(Wartosc.policz("3/4","2/3","*"));//1/2
//    pier4.setText(Wartosc.policz("3/4","2/3","/"));//9/8
//    pier5.setText(Wartosc.policz("3/4","3/4","+"));//3/2
//    pier6.setText(Wartosc.policz("3/4","3/4","-"));//0
//    pier7.setText(Wartosc.policz("3/4","3/4","*"));//9/16
//    pier8.setText(Wartosc.policz("3/4","3/4","/"));//1
//    pier9.setText(Wartosc.policz("15/4","1","*"));//15/4
//    pier10.setText(Wartosc.policz("4/15","1","*"));//4/15
//    pier11.setText(Wartosc.policz("15/3","1","*"));//5
//    pier12.setText(Wartosc.policz("3/15","1","*"));//1/5
//    pier13.setText(Wartosc.policz("0/3","1","*"));//0
//    pier14.setText(Wartosc.policz("3/0","1","*"));//0
//    pier1.setText(Wartosc.policz("-3/4","2/3","+"));//-1/12
//    pier2.setText(Wartosc.policz("-3/4","2/3","-"));//-17/12
//    pier3.setText(Wartosc.policz("-3/4","2/3","*"));//-1/2
//    pier4.setText(Wartosc.policz("-3/4","2/3","/"));//-9/8
//    pier5.setText(Wartosc.policz("-3/4","3/4","+"));//0
//    pier6.setText(Wartosc.policz("-3/4","3/4","-"));//-3/2
//    pier7.setText(Wartosc.policz("-3/4","3/4","*"));//-9/16
//    pier8.setText(Wartosc.policz("-3/4","3/4","/"));//-1
//    pier9.setText(Wartosc.policz("-15/4","1","*"));//-15/4
//    pier10.setText(Wartosc.policz("-4/15","1","*"));//-4/15
//    pier11.setText(Wartosc.policz("-15/3","1","*"));//-5
//    pier12.setText(Wartosc.policz("-3/15","1","*"));//-1/5
//    pier13.setText(Wartosc.policz("-0/3","1","*"));//0
//    pier14.setText(Wartosc.policz("-3/0","1","*"));//0
//    pier1.setText(Wartosc.policz("-3/4","-2/3","+"));//-17/12
//    pier2.setText(Wartosc.policz("-3/4","-2/3","-"));//-1/12
//    pier3.setText(Wartosc.policz("-3/4","-2/3","*"));//1/2
//    pier4.setText(Wartosc.policz("-3/4","-2/3","/"));//9/8
//    pier5.setText(Wartosc.policz("-3/4","-3/4","+"));//-3/2
//    pier6.setText(Wartosc.policz("-3/4","-3/4","-"));//0
//    pier7.setText(Wartosc.policz("-3/4","-3/4","*"));//9/16
//    pier8.setText(Wartosc.policz("-3/4","-3/4","/"));//1
//    pier9.setText(Wartosc.policz("-15/4","-1","*"));//15/4
//    pier10.setText(Wartosc.policz("-4/15","-1","*"));//4/15
//    pier11.setText(Wartosc.policz("-15/3","-1","*"));//5
//    pier12.setText(Wartosc.policz("-3/15","-1","*"));//1/5
//    pier13.setText(Wartosc.policz("-0/3","-1","*"));//0
//    pier14.setText(Wartosc.policz("-3/0","-1","*"));//0

/**potęga**/
//    pier1.setText(Wartosc.policz("2^2","2^2","+"));//8
//    pier2.setText(Wartosc.policz("2^2","2^2","-"));//0
//    pier3.setText(Wartosc.policz("2^2","2^2","*"));//16
//    pier4.setText(Wartosc.policz("2^2","2^2","/"));//1
//    pier5.setText(Wartosc.policz("2^2","2^3","+"));//12
//    pier6.setText(Wartosc.policz("2^2","2^3","-"));//-4
//    pier7.setText(Wartosc.policz("2^2","2^3","*"));//32
//    pier8.setText(Wartosc.policz("2^2","2^3","/"));//1/2
//    pier9.setText(Wartosc.policz("2^2","3^2","+"));//13
//    pier10.setText(Wartosc.policz("2^2","3^2","-"));//-5
//    pier11.setText(Wartosc.policz("2^2","3^2","*"));//36
//    pier12.setText(Wartosc.policz("2^2","3^2","/"));//4/9
//    pier13.setText(Wartosc.policz("2^3","3^5","+"));//251
//    pier14.setText(Wartosc.policz("2^3","3^5","-"));//-235
//    pier15.setText(Wartosc.policz("2^3","3^5","*"));//1944
//    pier16.setText(Wartosc.policz("2^3","3^5","/"));//8/243
//    pier17.setText(Wartosc.policz("2^0","1","*"));//1
//    pier18.setText(Wartosc.policz("2^(-1)","1","*"));//2^-1    błąd
//    pier19.setText(Wartosc.policz("2^1","1","*"));//2
//    pier20.setText(Wartosc.policz("(2^2)^3","1","*"));//256    błąd
//    pier21.setText(Wartosc.policz("2^(2^3)","1","*"));//256
//    pier22.setText(Wartosc.policz("2^(-2)","1","*"));//2^-2    błąd
//    pier1.setText(Wartosc.policz("-2^2","2^2","+"));//0
//    pier2.setText(Wartosc.policz("-2^2","2^2","-"));//-8
//    pier3.setText(Wartosc.policz("-2^2","2^2","*"));//-16
//    pier4.setText(Wartosc.policz("-2^2","2^2","/"));//-1
//    pier5.setText(Wartosc.policz("-2^2","2^3","+"));//4
//    pier6.setText(Wartosc.policz("-2^2","2^3","-"));//-12
//    pier7.setText(Wartosc.policz("-2^2","2^3","*"));//-32
//    pier8.setText(Wartosc.policz("-2^2","2^3","/"));//-1/2
//    pier9.setText(Wartosc.policz("-2^2","3^2","+"));//5
//    pier10.setText(Wartosc.policz("-2^2","3^2","-"));//-13
//    pier11.setText(Wartosc.policz("-2^2","3^2","*"));//-36
//    pier12.setText(Wartosc.policz("-2^2","3^2","/"));//-4/9
////        pier13.setText(Wartosc.policz("-2^3","3^5","+"));//251    błąd
////        pier14.setText(Wartosc.policz("-2^3","3^5","-"));//-235   błąd
////        pier15.setText(Wartosc.policz("-2^3","3^5","*"));//1944   blad
////        pier16.setText(Wartosc.policz("-2^3","3^5","/"));//8/243  błąd
//    pier17.setText(Wartosc.policz("-2^0","1","*"));//1
//    pier18.setText(Wartosc.policz("-2^(-1)","1","*"));//-2^-1    błąd
//    pier19.setText(Wartosc.policz("-2^1","1","*"));//-2
//    pier20.setText(Wartosc.policz("-1(2^2)^3","1","*"));//-429981696    błąd
//    pier21.setText(Wartosc.policz("-2^(2^3)","1","*"));//-256            chyba też błąd
//    pier22.setText(Wartosc.policz("-2^(-2)","1","*"));//-2^-2    błąd
//    pier1.setText(Wartosc.policz("2^2","-2^2","+"));//0
//    pier2.setText(Wartosc.policz("2^2","-2^2","-"));//8
//    pier3.setText(Wartosc.policz("2^2","-2^2","*"));//-16
//    pier4.setText(Wartosc.policz("2^2","-2^2","/"));//-1
////        pier5.setText(Wartosc.policz("2^2","-2^3","+"));//4      błąd
////        pier6.setText(Wartosc.policz("2^2","-2^3","-"));//-12    błąd
////        pier7.setText(Wartosc.policz("2^2","-2^3","*"));//-32    błąd
////        pier8.setText(Wartosc.policz("2^2","-2^3","/"));//-1/2   błąd
//    pier9.setText(Wartosc.policz("2^2","-3^2","+"));//-5
//    pier10.setText(Wartosc.policz("2^2","-3^2","-"));//13
//    pier11.setText(Wartosc.policz("2^2","-3^2","*"));//-36
//    pier12.setText(Wartosc.policz("2^2","-3^2","/"));//-4/9
////        pier13.setText(Wartosc.policz("-2^3","3^5","+"));//251    błąd
////        pier14.setText(Wartosc.policz("-2^3","3^5","-"));//-235   błąd
////        pier15.setText(Wartosc.policz("-2^3","3^5","*"));//1944   blad
////        pier16.setText(Wartosc.policz("-2^3","3^5","/"));//8/243  błąd
//    pier17.setText(Wartosc.policz("2^0","-1","*"));//-1
////        pier18.setText(Wartosc.policz("2^(-1)","-1","*"));//-2^-1    błąd
//    pier19.setText(Wartosc.policz("2^1","-1","*"));//-2
////        pier20.setText(Wartosc.policz("1(2^2)^3","-1","*"));//-429981696    błąd
////        pier21.setText(Wartosc.policz("2^(2^3)","-1","*"));//-256            chyba też błąd
////        pier22.setText(Wartosc.policz("2^(-2)","-1","*"));//-2^-2    błąd
//    pier1.setText(Wartosc.policz("-2^2","-2^2","+"));//-8
//    pier2.setText(Wartosc.policz("-2^2","-2^2","-"));//0
//    pier3.setText(Wartosc.policz("-2^2","-2^2","*"));//16
//    pier4.setText(Wartosc.policz("-2^2","-2^2","/"));//1
////        pier5.setText(Wartosc.policz("2^2","-2^3","+"));//4      błąd
////        pier6.setText(Wartosc.policz("2^2","-2^3","-"));//-12    błąd
////        pier7.setText(Wartosc.policz("2^2","-2^3","*"));//-32    błąd
////        pier8.setText(Wartosc.policz("2^2","-2^3","/"));//-1/2   błąd
//    pier9.setText(Wartosc.policz("-2^2","-3^2","+"));//-13
//    pier10.setText(Wartosc.policz("-2^2","-3^2","-"));//5
//    pier11.setText(Wartosc.policz("-2^2","-3^2","*"));//36
//    pier12.setText(Wartosc.policz("-2^2","-3^2","/"));//4/9
////        pier13.setText(Wartosc.policz("-2^3","3^5","+"));//251    błąd
////        pier14.setText(Wartosc.policz("-2^3","3^5","-"));//-235   błąd
////        pier15.setText(Wartosc.policz("-2^3","3^5","*"));//1944   blad
////        pier16.setText(Wartosc.policz("-2^3","3^5","/"));//8/243  błąd
//    pier17.setText(Wartosc.policz("-2^0","-1","*"));//-1        błąd
////        pier18.setText(Wartosc.policz("2^(-1)","-1","*"));//-2^-1    błąd
//    pier19.setText(Wartosc.policz("-2^1","-1","*"));//2
////        pier20.setText(Wartosc.policz("1(2^2)^3","-1","*"));//-429981696    błąd
////        pier21.setText(Wartosc.policz("2^(2^3)","-1","*"));//-256            chyba też błąd
////        pier22.setText(Wartosc.policz("2^(-2)","-1","*"));//-2^-2    błąd

/**kombinacje**/
/**liczba i pierwiastek**/
//    pier1.setText(Wartosc.policz("3","2√3","+"));//2√3+3
//    pier2.setText(Wartosc.policz("3","2√3","-"));//3-2√3
//    pier3.setText(Wartosc.policz("3","2√3","*"));//6√3
//    pier4.setText(Wartosc.policz("3","2√3","/"));//√3/2
//    pier5.setText(Wartosc.policz("2","1√4","+"));//4
//    pier6.setText(Wartosc.policz("2","1√4","-"));//0
//    pier7.setText(Wartosc.policz("2","1√4","*"));//4
//    pier8.setText(Wartosc.policz("2","1√4","/"));//1
//    pier9.setText(Wartosc.policz("2√3","3","-"));//2√3-3
//    pier10.setText(Wartosc.policz("2√3","3","/"));//2√3/3
//    pier11.setText(Wartosc.policz("2√3","2","/"));//√3
//    pier12.setText(Wartosc.policz("2","2√3","/"));//√3/3
//    pier13.setText(Wartosc.policz("6√3","2","/"));//3√3
//    pier14.setText(Wartosc.policz("0","1√3","/"));//0√3      błąd
//    pier15.setText(Wartosc.policz("1√3","0","/"));//√3/0     błąd
//    pier16.setText(Wartosc.policz("0","1√2","-"));//0-√2     błąd
//    pier1.setText(Wartosc.policz("-3","2√3","+"));//-2√3+3
//    pier2.setText(Wartosc.policz("-3","2√3","-"));//-3-2√3
//    pier3.setText(Wartosc.policz("-3","2√3","*"));//-6√3
//    pier4.setText(Wartosc.policz("-3","2√3","/"));//-√3/2
//    pier5.setText(Wartosc.policz("-2","1√4","+"));//0
//    pier6.setText(Wartosc.policz("-2","1√4","-"));//-4
//    pier7.setText(Wartosc.policz("-2","1√4","*"));//-4
//    pier8.setText(Wartosc.policz("-2","1√4","/"));//-1
//    pier9.setText(Wartosc.policz("-2√3","3","-"));//-2√3-3
//    pier10.setText(Wartosc.policz("-2√3","3","/"));//-2√3/3
//    pier11.setText(Wartosc.policz("-2√3","2","/"));//-√3
//    pier12.setText(Wartosc.policz("-2","2√3","/"));//-√3/3
//    pier13.setText(Wartosc.policz("-6√3","2","/"));//-3√3
//    pier14.setText(Wartosc.policz("-0","1√3","/"));//-0√3      błąd
//    pier15.setText(Wartosc.policz("-1√3","0","/"));//-√3/0     błąd
//    pier16.setText(Wartosc.policz("-0","1√2","-"));//-√2
//    pier1.setText(Wartosc.policz("3","-2√3","+"));//-2√3+3
//    pier2.setText(Wartosc.policz("3","-2√3","-"));//3+2√3
//    pier3.setText(Wartosc.policz("3","-2√3","*"));//-6√3
//    pier4.setText(Wartosc.policz("3","-2√3","/"));//-√3/2
//    pier5.setText(Wartosc.policz("2","-1√4","+"));//0
//    pier6.setText(Wartosc.policz("2","-1√4","-"));//4
//    pier7.setText(Wartosc.policz("2","-1√4","*"));//-4
//    pier8.setText(Wartosc.policz("2","-1√4","/"));//-1
//    pier9.setText(Wartosc.policz("2√3","-3","-"));//2√3+3     błąd
//    pier10.setText(Wartosc.policz("2√3","-3","/"));//-2√3/3
//    pier11.setText(Wartosc.policz("2√3","-2","/"));//-√3
//    pier12.setText(Wartosc.policz("2","-2√3","/"));//-√3/3
//    pier13.setText(Wartosc.policz("6√3","-2","/"));//-3√3
//    pier14.setText(Wartosc.policz("0","-1√3","/"));//0√3      błąd
//    pier15.setText(Wartosc.policz("1√3","-0","/"));//√3/0     błąd
//    pier16.setText(Wartosc.policz("0","-1√2","-"));//√2
//    pier1.setText(Wartosc.policz("-3","-2√3","+"));//-2√3-3
//    pier2.setText(Wartosc.policz("-3","-2√3","-"));//-3+2√3
//    pier3.setText(Wartosc.policz("-3","-2√3","*"));//6√3
//    pier4.setText(Wartosc.policz("-3","-2√3","/"));//√3/2
//    pier5.setText(Wartosc.policz("-2","-1√4","+"));//-4
//    pier6.setText(Wartosc.policz("-2","-1√4","-"));//0
//    pier7.setText(Wartosc.policz("-2","-1√4","*"));//4
//    pier8.setText(Wartosc.policz("-2","-1√4","/"));//1
//    pier9.setText(Wartosc.policz("-2√3","-3","-"));//3-2√3
//    pier10.setText(Wartosc.policz("-2√3","-3","/"));//2√3/3
//    pier11.setText(Wartosc.policz("-2√3","-2","/"));//√3
//    pier12.setText(Wartosc.policz("-2","-2√3","/"));//√3/3
//    pier13.setText(Wartosc.policz("-6√3","-2","/"));//3√3
//    pier14.setText(Wartosc.policz("-0","-1√3","/"));//0      błąd
//    pier15.setText(Wartosc.policz("-1√3","-0","/"));//0     błąd
//    pier16.setText(Wartosc.policz("-0","-1√2","-"));//√2
/**liczba i ułamek**/
//    pier1.setText(Wartosc.policz("3","2/3","+"));//11/3
//    pier2.setText(Wartosc.policz("3","2/3","-"));//7/3
//    pier3.setText(Wartosc.policz("3","2/3","*"));//2
//    pier4.setText(Wartosc.policz("3","2/3","/"));//9/2
//    pier5.setText(Wartosc.policz("1","15/4","-"));//-11/4
//    pier6.setText(Wartosc.policz("17/3","5","-"));//2/3
//    pier7.setText(Wartosc.policz("17/3","8","-"));//-7/3
//    pier8.setText(Wartosc.policz("3","2/5","*"));//6/5
//    pier9.setText(Wartosc.policz("0","1/2","*"));//0
//    pier1.setText(Wartosc.policz("-3","2/3","+"));//-7/3
//    pier2.setText(Wartosc.policz("-3","2/3","-"));//-11/3
//    pier3.setText(Wartosc.policz("-3","2/3","*"));//-2
//    pier4.setText(Wartosc.policz("-3","2/3","/"));//-9/2
//    pier5.setText(Wartosc.policz("-1","15/4","-"));//-19/4
//    pier6.setText(Wartosc.policz("-17/3","5","-"));//-32/3
//    pier7.setText(Wartosc.policz("-17/3","8","-"));//-41/3
//    pier8.setText(Wartosc.policz("-3","2/5","*"));//-6/5
//    pier9.setText(Wartosc.policz("-0","1/2","*"));//0
//    pier1.setText(Wartosc.policz("3","-2/3","+"));//7/3
//    pier2.setText(Wartosc.policz("3","-2/3","-"));//11/3
//    pier3.setText(Wartosc.policz("3","-2/3","*"));//-2
//    pier4.setText(Wartosc.policz("3","-2/3","/"));//-9/2
//    pier5.setText(Wartosc.policz("1","-15/4","-"));//19/4
//    pier6.setText(Wartosc.policz("17/3","-5","-"));//32/3
//    pier7.setText(Wartosc.policz("17/3","-8","-"));//41/3
//    pier8.setText(Wartosc.policz("3","-2/5","*"));//-6/5
//    pier9.setText(Wartosc.policz("0","-1/2","*"));//0
//    pier1.setText(Wartosc.policz("-3","-2/3","+"));//-11/3
//    pier2.setText(Wartosc.policz("-3","-2/3","-"));//-7/3
//    pier3.setText(Wartosc.policz("-3","-2/3","*"));//2
//    pier4.setText(Wartosc.policz("-3","-2/3","/"));//9/2
//    pier5.setText(Wartosc.policz("-1","-15/4","-"));//11/4
//    pier6.setText(Wartosc.policz("-17/3","-5","-"));//-2/3
//    pier7.setText(Wartosc.policz("-17/3","-8","-"));//7/3
//    pier8.setText(Wartosc.policz("-3","-2/5","*"));//6/5
//    pier9.setText(Wartosc.policz("-0","-1/2","*"));//0
/**liczba i pierwiastek**/
//    pier1.setText(Wartosc.policz("3","2^3","+"));//11
//    pier2.setText(Wartosc.policz("3","2^3","-"));//-5
//    pier3.setText(Wartosc.policz("3","2^3","*"));//24
//    pier4.setText(Wartosc.policz("3","2^3","/"));//3/8
//    pier5.setText(Wartosc.policz("2^3","3","/"));//8/3
//    pier6.setText(Wartosc.policz("10","2^3","-"));//2
//    pier1.setText(Wartosc.policz("-3","2^3","+"));//5
//    pier2.setText(Wartosc.policz("-3","2^3","-"));//-11
//    pier3.setText(Wartosc.policz("-3","2^3","*"));//-24
//    pier4.setText(Wartosc.policz("-3","2^3","/"));//-3/8
////        pier5.setText(Wartosc.policz("-2^3","3","/"));//-8/3      błąd
//    pier6.setText(Wartosc.policz("-10","2^3","-"));//-18
//    pier1.setText(Wartosc.policz("3","-2^3","+"));//-5      błąd
//    pier2.setText(Wartosc.policz("3","-2^3","-"));//11      błąd
//    pier3.setText(Wartosc.policz("3","-2^3","*"));//-24     błąd
//    pier4.setText(Wartosc.policz("3","-2^3","/"));//-3/8    błąd
//    pier5.setText(Wartosc.policz("2^3","-3","/"));//-8/3      błąd
//    pier6.setText(Wartosc.policz("10","-2^3","-"));//18     błąd
//    pier1.setText(Wartosc.policz("-3","-2^3","+"));//-11      błąd
//    pier2.setText(Wartosc.policz("-3","-2^3","-"));//5        błąd
//    pier3.setText(Wartosc.policz("-3","-2^3","*"));//24       błąd
//    pier4.setText(Wartosc.policz("-3","-2^3","/"));//3/8      błąd
//    pier5.setText(Wartosc.policz("-2^3","-3","/"));//8/3      błąd
//    pier6.setText(Wartosc.policz("-10","-2^3","-"));//-2      błąd
/**potęga i ułamek**/
//    pier1.setText(Wartosc.policz("2^3/3^2","1","*"));//8/9
//    pier2.setText(Wartosc.policz("(2/3)^3","1","*"));//8/27
//    pier3.setText(Wartosc.policz("(2)^3/4","1","*"));//(2)^3/4
//    pier4.setText(Wartosc.policz("(2/5)^3/4","1","*"));//(2/5)^3/4
//    pier5.setText(Wartosc.policz("(3^2)/5","1","*"));//9/5
//    pier6.setText(Wartosc.policz("(3^2)/3","1","*"));//3
//    pier7.setText(Wartosc.policz("3/(3^2)","1","*"));//1/3
//    pier8.setText(Wartosc.policz("5/(3^2)","1","*"));//5/9
//    pier9.setText(Wartosc.policz("((2)^3/4)/((2)^1/2)","1","*"));//((2)^3/4)/((2)^1/2)
//    pier1.setText(Wartosc.policz("-(2^3)/(3^2)", "1", "*"));//8/9    błąd
//    pier2.setText(Wartosc.policz("-(2/3)^3", "1", "*"));//-8/27        błąd
//    pier3.setText(Wartosc.policz("-(2)^3/4", "1", "*"));//-(2)^3/4     błąd
//    pier4.setText(Wartosc.policz("-(2/5)^3/4", "1", "*"));//-(2/5)^3/4   BLAD
//    pier5.setText(Wartosc.policz("-(3^2)/5", "1", "*"));//-9/5
//    pier6.setText(Wartosc.policz("-(3^2)/3", "1", "*"));//-3
//    pier7.setText(Wartosc.policz("-3/(3^2)", "1", "*"));//-1/3
//    pier8.setText(Wartosc.policz("-5/(3^2)", "1", "*"));//-5/9
//    pier9.setText(Wartosc.policz("-((2)^3/4)/((2)^1/2)", "1", "*"));//-((2)^3/4)/((2)^1/2)
//    pier1.setText(Wartosc.policz("(2^3)/(3^2)", "-1", "*"));//-8/9
//    pier2.setText(Wartosc.policz("(2/3)^3", "-1", "*"));//-8/27
//    pier3.setText(Wartosc.policz("(2)^3/4", "-1", "*"));//-(2)^3/4     błąd
////        pier4.setText(Wartosc.policz("(2/5)^3/4", "-1", "*"));//-(2/5)^3/4   błąd
//    pier5.setText(Wartosc.policz("(3^2)/5", "-1", "*"));//-9/5
//    pier6.setText(Wartosc.policz("(3^2)/3", "-1", "*"));//-3
//    pier7.setText(Wartosc.policz("3/(3^2)", "-1", "*"));//-1/3
//    pier8.setText(Wartosc.policz("5/(3^2)", "-1", "*"));//-5/9
////        pier9.setText(Wartosc.policz("((2)^3/4)/((2)^1/2)", "-1", "*"));//-((2)^3/4)/((2)^1/2)   błąd
//        pier1.setText(Wartosc.policz("-(2^3)/(3^2)", "-1", "*"));//8/9    błąd
//    pier2.setText(Wartosc.policz("-(2/3)^3", "-1", "*"));//8/27       błąd
//    pier3.setText(Wartosc.policz("-(2)^3/4", "-1", "*"));//(2)^3/4     błąd
////        pier4.setText(Wartosc.policz("-(2/5)^3/4", "-1", "*"));//(2/5)^3/4   błąd
//    pier5.setText(Wartosc.policz("-(3^2)/5", "-1", "*"));//9/5
//    pier6.setText(Wartosc.policz("-(3^2)/3", "-1", "*"));//3
//    pier7.setText(Wartosc.policz("-3/(3^2)", "-1", "*"));//1/3
//    pier8.setText(Wartosc.policz("-5/(3^2)", "-1", "*"));//5/9
////        pier9.setText(Wartosc.policz("-((2)^3/4)/((2)^1/2)", "-1", "*"));//((2)^3/4)/((2)^1/2)   błąd
/**potęga i pierwiastek**/
//    pier1.setText(Wartosc.policz("1√2", "2^3", "+"));//8+√2
//    pier2.setText(Wartosc.policz("1√2", "2^3", "-"));//-8+√2
//    pier3.setText(Wartosc.policz("1√2", "2^3", "*"));//8√2
//    pier4.setText(Wartosc.policz("1√2", "2^3", "/"));//√2/8
//    pier5.setText(Wartosc.policz("2^3", "1√2", "/"));//4√2
//    pier6.setText(Wartosc.policz("(2)^√4", "1", "*"));//4
//    pier7.setText(Wartosc.policz("(2)^√2", "1", "*"));//2^√2
//    pier8.setText(Wartosc.policz("(√2)^3", "1", "*"));//2√2
//    pier9.setText(Wartosc.policz("(√4)^3", "1", "*"));//8
////        pier10.setText(Wartosc.policz("(√2)^√2","1","*"));//√2^√2      błąd
////        pier11.setText(Wartosc.policz("(√2)^√4","1","*"));//2           błąd
////        pier12.setText(Wartosc.policz("(√9)^√4","1","*"));//9            błąd
////        pier13.setText(Wartosc.policz("2^3","2√3","/"));//4√3              błąd
////        pier14.setText(Wartosc.policz("(2)^√3","1√8","/"));//2^√3/√8        błąd
////        pier15.setText(Wartosc.policz("(√2^√3)^3","1","*"));//√2^√3^3       błąd
////        pier16.setText(Wartosc.policz("((√2)^√3)^√3","1","*"));//√2^√3^√3  błąd
////        pier17.setText(Wartosc.policz("(2^√2)^√2","1","*"));//2^√2^√2       błąd
////        pier18.setText(Wartosc.policz("(2^√2)^√3","1","*"));//2^√2^√3       błąd
////        pier19.setText(Wartosc.policz("((√2)^2)^3","1","*"));//8       błąd
////        pier20.setText(Wartosc.policz("(2^3)^√2","1","*"));//2^3^√2         błąd
////        pier21.setText(Wartosc.policz("((√4)^√4)^√9","1","*"));//256      błąd
////        pier22.setText(Wartosc.policz("((√4)^√9)^√2","1","*"));//√4^√9^√2   błąd
//    pier1.setText(Wartosc.policz("-1√2", "2^3", "+"));//-8+√2
//    pier2.setText(Wartosc.policz("-1√2", "2^3", "-"));//8+√2
//    pier3.setText(Wartosc.policz("-1√2", "2^3", "*"));//-8√2
//    pier4.setText(Wartosc.policz("-1√2", "2^3", "/"));//-√2/8
////        pier5.setText(Wartosc.policz("-2^3", "1√2", "/"));//4√2     błąd
////        pier6.setText(Wartosc.policz("-(2)^√4", "1", "*"));//4       błąd
////        pier7.setText(Wartosc.policz("-(2)^√2", "1", "*"));//2^√2  błąd
////        pier8.setText(Wartosc.policz("-(√2)^3", "1", "*"));//2√2       błąd
////        pier9.setText(Wartosc.policz("-(√4)^3", "1", "*"));//8         błąd
////        pier10.setText(Wartosc.policz("-(√2)^√2","1","*"));//√2^√2      błąd
////        pier11.setText(Wartosc.policz("-(√2)^√4","1","*"));//2           błąd
////        pier12.setText(Wartosc.policz("-(√9)^√4","1","*"));//9            błąd
////        pier13.setText(Wartosc.policz("-2^3","2√3","/"));//4√3              błąd
////        pier14.setText(Wartosc.policz("-(2)^√3","1√8","/"));//2^√3/√8        błąd
////        pier15.setText(Wartosc.policz("-(√2^√3)^3","1","*"));//√2^√3^3       błąd
////        pier16.setText(Wartosc.policz("-((√2)^√3)^√3","1","*"));//√2^√3^√3  błąd
////        pier17.setText(Wartosc.policz("-(2^√2)^√2","1","*"));//2^√2^√2       błąd
////        pier18.setText(Wartosc.policz("-(2^√2)^√3","1","*"));//2^√2^√3       błąd
////        pier19.setText(Wartosc.policz("-((√2)^2)^3","1","*"));//8       błąd
////        pier20.setText(Wartosc.policz("-(2^3)^√2","1","*"));//2^3^√2         błąd
////        pier21.setText(Wartosc.policz("-((√4)^√4)^√9","1","*"));//256      błąd
////        pier22.setText(Wartosc.policz("-((√4)^√9)^√2","1","*"));//√4^√9^√2   błąd
//    pier1.setText(Wartosc.policz("1√2", "-2^3", "+"));//    błąd
//        pier2.setText(Wartosc.policz("1√2", "-2^3", "-"));//     błąd
//        pier3.setText(Wartosc.policz("1√2", "-2^3", "*"));// błąd
//        pier4.setText(Wartosc.policz("1√2", "-2^3", "/"));//   błąd
//        pier5.setText(Wartosc.policz("2^3", "-1√2", "/"));//     błąd
//        pier6.setText(Wartosc.policz("(2)^√4", "-1", "*"));//       błąd
//        pier7.setText(Wartosc.policz("(2)^√2", "-1", "*"));//  błąd
//        pier8.setText(Wartosc.policz("(√2)^3", "-1", "*"));//      błąd
//        pier9.setText(Wartosc.policz("(√4)^3", "-1", "*"));//        błąd
//        pier10.setText(Wartosc.policz("(√2)^√2","-1","*"));//      błąd
//        pier11.setText(Wartosc.policz("(√2)^√4","-1","*"));//         błąd
//        pier12.setText(Wartosc.policz("(√9)^√4","-1","*"));//          błąd
//        pier13.setText(Wartosc.policz("2^3","-2√3","/"));//        błąd
//        pier14.setText(Wartosc.policz("(2)^√3","-1√8","/"));//     błąd
//        pier15.setText(Wartosc.policz("(√2^√3)^3","-1","*"));//     błąd
//        pier16.setText(Wartosc.policz("((√2)^√3)^√3","-1","*"));//  błąd
//        pier17.setText(Wartosc.policz("(2^√2)^√2","-1","*"));//   błąd
//        pier18.setText(Wartosc.policz("(2^√2)^√3","-1","*"));//     błąd
//        pier19.setText(Wartosc.policz("((√2)^2)^3","-1","*"));//    błąd
//        pier20.setText(Wartosc.policz("(2^3)^√2","-1","*"));//        błąd
//        pier21.setText(Wartosc.policz("((√4)^√4)^√9","-1","*"));//    błąd
//        pier22.setText(Wartosc.policz("((√4)^√9)^√2","-1","*"));//  błąd
//    pier1.setText(Wartosc.policz("-1√2", "-2^3", "+"));//    błąd
////        pier2.setText(Wartosc.policz("-√2", "-2^3", "-"));//     błąd
////        pier3.setText(Wartosc.policz("-1√2", "-2^3", "*"));// błąd
////        pier4.setText(Wartosc.policz("-1√2", "-2^3", "/"));//   błąd
////        pier5.setText(Wartosc.policz("-2^3", "-1√2", "/"));//     błąd
////        pier6.setText(Wartosc.policz("-(2)^√4", "-1", "*"));//       błąd
////        pier7.setText(Wartosc.policz("-(2)^√2", "-1", "*"));//  błąd
////        pier8.setText(Wartosc.policz("-(√2)^3", "-1", "*"));//      błąd
////        pier9.setText(Wartosc.policz("-(√4)^3", "-1", "*"));//        błąd
////        pier10.setText(Wartosc.policz("-(√2)^√2","-1","*"));//      błąd
////        pier11.setText(Wartosc.policz("-(√2)^√4","-1","*"));//         błąd
////        pier12.setText(Wartosc.policz("-(√9)^√4","-1","*"));//          błąd
////        pier13.setText(Wartosc.policz("-2^3","-2√3","/"));//        błąd
////        pier14.setText(Wartosc.policz("-(2)^√3","-1√8","/"));//     błąd
////        pier15.setText(Wartosc.policz("-(√2^√3)^3","-1","*"));//     błąd
////        pier16.setText(Wartosc.policz("-((√2)^√3)^√3","-1","*"));//  błąd
////        pier17.setText(Wartosc.policz("-(2^√2)^√2","-1","*"));//   błąd
////        pier18.setText(Wartosc.policz("-(2^√2)^√3","-1","*"));//     błąd
////        pier19.setText(Wartosc.policz("-((√2)^2)^3","-1","*"));//    błąd
////        pier20.setText(Wartosc.policz("-(2^3)^√2","-1","*"));//        błąd
////        pier21.setText(Wartosc.policz("-((√4)^√4)^√9","-1","*"));//    błąd
////        pier22.setText(Wartosc.policz("-((√4)^√9)^√2","-1","*"));//  błąd
//    pier1.setText(Wartosc.policz("(√2^3)", "1", "*"));//2√2
////        pier2.setText(Wartosc.policz("(√3^2)^3", "1", "*"));// błąd
////        pier3.setText(Wartosc.policz("(√2^3)^0", "1", "*"));// błąd
////        pier4.setText(Wartosc.policz("(3^2)^0", "1", "*"));//  błąd
//        pier1.setText(Wartosc.policz("-(√2^3)", "1", "*"));// błąd
//        pier2.setText(Wartosc.policz("-(√3^2)^3", "1", "*"));// błąd
//        pier3.setText(Wartosc.policz("-(√2^3)^0", "1", "*"));// błąd
//        pier4.setText(Wartosc.policz("-(3^2)^0", "1", "*"));//  błąd
//    pier1.setText(Wartosc.policz("(√2^3)", "-1", "*"));// błąd
//    pier2.setText(Wartosc.policz("(√3^2)^3", "-1", "*"));// błąd
//    pier3.setText(Wartosc.policz("(√2^3)^0", "-1", "*"));// błąd
//    pier4.setText(Wartosc.policz("(3^2)^0", "-1", "*"));//  błąd
//    pier1.setText(Wartosc.policz("-(√2^3)", "-1", "*"));// błąd
//    pier2.setText(Wartosc.policz("-(√3^2)^3", "-1", "*"));// błąd
//    pier3.setText(Wartosc.policz("-(√2^3)^0", "-1", "*"));// błąd
//    pier4.setText(Wartosc.policz("-(3^2)^0", "-1", "*"));//  błąd







}