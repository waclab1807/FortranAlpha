package pl.wlabuda.fortranalpha;

import android.widget.Toast;

/**
 * Created by waclab1807 on 29.12.15. & SkylinR on 18.02.16
 */
public class LiczbaPi {
    public String first;
    public String valpi;
//  Toast.makeText(Global.mContext, "Nie ma pierwiastka z liczby ujemnej!", Toast.LENGTH_SHORT).show();
    public LiczbaPi(String pi) {
        System.out.println("!!! LICZBA PI:"+ pi);

        if(pi.contains("π") && (((pi.length()==2) && (pi.contains("(π") || pi.contains(")π")) ) || pi.length() == 1 || ((pi.length()==3) && pi.contains("()")))){
            pi = pi.replace(pi,"(1)π");
            first = "1";
            valpi = "π";
        }
        if(pi.contains("-π")) { //-pi => -1pi
            pi = pi.replace("-π","-1π");
            first="-1";
            valpi="-π";
        }
        if(pi.contains("0π") && pi.length()==4){    //0π

            first="0";
            valpi="0";
        }
        if(pi.endsWith("π") && pi.length() != 1 &&      // 250π, 2π... liczba z pi
                !pi.substring(pi.length()-1,pi.length()).equals("/") &&
                !pi.substring(pi.length()-1,pi.length()).equals("^") &&
                !pi.substring(pi.length()-1,pi.length()).equals("√")) {
            first = pi.replace("π","");
            valpi = first + "π";
        }
        if(pi.contains("/π")) {         // 2/π      liczba / pi
            first = pi;
            valpi = "(" + pi + ")";
        }
        if(pi.endsWith("π") && pi.substring(0,pi.length()-1).equals("/") && !pi.contains("/π")) {       // (3/4)π
            first = pi.substring(0,pi.length()-1);
            valpi = "(" + first + ")π";
        }
        if(pi.contains("π/")) {         // π/2    pi / liczba   \u221a pierw    \u03C0 pi
            String[] tmp = pi.split("/");
            if(tmp[0].length()<2){
                tmp[0] = "1";
            } else {
                tmp[0] = tmp[0].replace("π","");
            }
            first = tmp[0] + "/" + tmp[1];
            valpi = first + "1π";
        }
//        if(pi.startsWith("√") && pi.endsWith("π")) && pi.lenght()>=2  {         // pierwiastek z liczby i pi ---> √2 π
//            first=pi.replace("π","");
//            valpi= first+"π";
//        }

        if(pi.contains("π") && !pi.substring(pi.indexOf('π'), pi.length()).contains("\u221a") && !pi.substring(pi.indexOf('π'), pi.length()).contains("^") && pi.length() > pi.indexOf('π')+1){ //Źle wprowadzone dane
            System.out.println("!!!ZLE WPROWADZONE DANE");
            Toast.makeText(Global.mContext, "Po liczbie PI nie powinno być żadnych wartości.", Toast.LENGTH_SHORT).show();
            first="";
            valpi="";

        }




    }

    public String getFirst() {
        return this.first;
    }

    public String getPi() {
        return this.valpi;
    }

//    wartoscPi()

}
