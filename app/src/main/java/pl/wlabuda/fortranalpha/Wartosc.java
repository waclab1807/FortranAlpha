package pl.wlabuda.fortranalpha;

import android.widget.Toast;

/**
 * Created by Wacław & SkylinR on 11.07.14.
 */
public class Wartosc {
    public String licznik;
    public String mianownik;
    public static String operator; //przechowuje operator z (x + y) ale tylko jesli sa dwie liczby w srodku

    public Wartosc(String a) { //konstruktor zamienia liczbe na ulamek
        if (a.contains("/")) {
            String[] t = a.split("/");
            if(t[0].startsWith("((") && t[0].endsWith("))")){
                t[0] = t[0].substring(1,t[0].length()-1);
            }
            if(t[1].startsWith("((") && t[1].endsWith("))")){
                t[1] = t[1].substring(1,t[1].length()-1);
            }
            if (t[0].startsWith("√") || t[0].contains("√")){
                t[0] = "("+t[0]+")";
            }
            if (t[1].startsWith("√") || t[1].contains("√")){
                t[1] = "("+t[1]+")";
            }
            if (t[0].contains("^")){
                t[0] = "("+t[0]+")";
            }
            if (t[1].contains("^")){
                t[1] = "("+t[1]+")";
            }
            t[0] = t[0].replaceAll("-√","-1√");
            t[1] = t[1].replaceAll("-√","-1√");
            if(t[0].contains("(") && t[0].contains(")")) {
                String x = t[0].substring(1, t[0].length() - 1);       //jak licznik albo mianownik jest dzialaniem to zamienia nawiasy na kwadratowe
                System.out.println("wartKonstrx " + t[0] + " & " + x);
                x = x.replace("(", "[");
                x = x.replace(")", "]");
                System.out.println("wartKonstrPox " + x);
                t[0] = x;
            }
            if(t[0].contains("(") && !t[0].contains(")")) {
                t[0] = t[0].replace("(","");
            }
            if(t[1].contains("(") && t[1].contains(")")) {
                String y = t[1].substring(1, t[1].length() - 1);
                System.out.println("wartKonstry " + t[1] + " & " + y);
                y = y.replace("(", "[");
                y = y.replace(")", "]");
                System.out.println("wartKonstrPoy " + y);
                t[1] = y;
            }
            if(!t[1].contains("(") && t[1].contains(")")) {
                t[1] = t[1].replace(")", "");
            }

            t[0] = t[0].replace("(", "");
            t[0] = t[0].replace(")", "");
            t[0] = t[0].replace("[", "(");
            t[0] = t[0].replace("]", ")");
            licznik = t[0];
            t[1] = t[1].replace("(", "");
            t[1] = t[1].replace(")", "");
            t[1] = t[1].replace("[", "(");
            t[1] = t[1].replace("]", ")");
            mianownik = t[1];
        } else {
            a = a.replace("(", "");
            a = a.replace(")", "");
            licznik = a;
            mianownik = "1";
        }
    }

    public String getLicznik() {
        return this.licznik;
    }

    public String getMianownik() {
        return this.mianownik;
    }

    public static String czyJestCalkowita(String a) {
        if (Double.parseDouble(a) - (int) Double.parseDouble(a) == 0) {
            return (int) Double.parseDouble(a) + "";
        } else {
            return Double.parseDouble(a) + "";
        }
    }

    public static String jakieToWyrazenie(String wyrazenie){
        System.out.println("jakie to wyrazenie? "+ wyrazenie);
        int k=0;
        boolean test=true;
        boolean first=true;
        String temp="";
        String wynik = "";
        if(wyrazenie.contains("/√")){
            wyrazenie = wyrazenie.replaceAll("/√","/()√");
        }
        if(!wyrazenie.contains("(") && !wyrazenie.contains(")")){
            return wyrazenie;
        }
        for (int i=0;wyrazenie.length()>i;i++){
            if ((wyrazenie.charAt(i)!='(')&(first)){temp+=wyrazenie.charAt(i);}
            else if(wyrazenie.charAt(i)=='('){k++; test=true;first=false;}
            else if (wyrazenie.charAt(i)==')'){k--;
                if(k==0){test=false;}}
            if (!test){
                if (wyrazenie.length()>(i+1))
                {
                    wynik+="()"+wyrazenie.charAt(i+1);
                }
                else{
                    wynik+="()";
                }
                test=true;
            }
        }
        if(wynik.replace("()","").equals("")){
            wyrazenie = wyrazenie.replace("(","");
            wyrazenie = wyrazenie.replace(")","");
            return wyrazenie;
        }
        String tmp = temp+wynik;
        if (tmp.contains("√()/") || tmp.contains("^()/") || tmp.contains("/()√") || tmp.contains("/()^")){
            System.out.println(wyrazenie + " jakie to wyrazenie? /");
            return "/";
        } else {
            System.out.println(wyrazenie + " jakie to wyrazenie? "+temp + wynik.replace("()", ""));
            return temp + wynik.replace("()", "");
        }
    }

    public static String operatorOperacji(String a) {
        if (a.contains("+")) {
            operator = "+";
        } else if (a.contains("-")) {
            operator = "-";
        } else if (a.contains("/")) {
            operator = "/";
        } else if (a.contains("*")) {
            operator = "*";
        }
        return operator;
    }//wyciaga operator

    public String podzielUlamki(Wartosc a) {
        System.out.println("podzielUlamki");
        Wartosc x = this;
        Wartosc y = a;
        String licznik = policz(x.getLicznik(), y.getMianownik(), "*");
        String mianownik = policz(x.getMianownik(), y.getLicznik(), "*");
        return policz(licznik, mianownik, "/"); // (a/b) / (c/d) zwroci a*d/b*c (wyrazenie/wyrazenie)
    }

    public String pomnozUlamki(Wartosc a) {
        System.out.println("pomnozUlamki");
        Wartosc x = this;
        Wartosc y = a;
        String licznik = policz(x.getLicznik(), y.getLicznik(), "*");
        String mianownik = policz(x.getMianownik(), y.getMianownik(), "*");
        return policz(licznik, mianownik, "/");// (a/b) * (c/d) zwroci a*c/b*d (wyrazenie/wyrazenie)
    }

    public String dodajUlamki(Wartosc a) {
        System.out.println("dodajUlamki");
        Wartosc x = this;
        Wartosc y = a;
        String licznikx = null;
        String mianownikx = null;
        String liczniky = null;
        String licznik;
        String mianownik;
        if (!x.getMianownik().equals(y.getMianownik())) { //jesli mianowniki sa rozne to sprowadz do wspolnego
            licznikx = policz(x.getLicznik(), y.getMianownik(), "*");
            mianownikx = policz(x.getMianownik(), y.getMianownik(), "*");
            liczniky = policz(y.getLicznik(), x.getMianownik(), "*");
            licznik = policz(licznikx, liczniky, "+");
        } else {                                                 // jeli sa takie same to tylko dodaj liczniki
            licznik = policz(x.getLicznik(), y.getLicznik(), "+");
            mianownikx = x.getMianownik();
        }
        mianownik = mianownikx;
        return policz(licznik, mianownik, "/");
    }

    public String odejmijUlamki(Wartosc a) {
        System.out.println("odejmijUlamki");
        Wartosc x = this;
        Wartosc y = a;
        String licznikx = null;
        String mianownikx = null;
        String liczniky = null;
        String licznik;
        String mianownik;
        if (!x.getMianownik().equals(y.getMianownik())) { // sprawdzenie czy mianowniki sa takie same
            licznikx = policz(x.getLicznik(), y.getMianownik(), "*");
            mianownikx = policz(x.getMianownik(), y.getMianownik(), "*");
            liczniky = policz(y.getLicznik(), x.getMianownik(), "*");
            licznik = policz(licznikx, liczniky, "-");
        } else {
            licznik = policz(x.getLicznik(), y.getLicznik(), "-");
            mianownikx = x.getMianownik();
        }
        mianownik = mianownikx;
        return skrocUlamek("(" + licznik + ")/(" + mianownik + ")"); //zwraca wyrazenie/wyrazenie
    }

    public String uwymiernijUlamek() {
        System.out.println("uwymiernijUlamek");
        Wartosc x = this;
        String licznik;
        String mianownik;
        if (x.getLicznik().contains("\u221a")) { //sprawdza czy licznik byl pierwiastkiem i mnozy dwa pierwiastki
            Pierwiastek l = new Pierwiastek(x.getLicznik());
            Pierwiastek m = new Pierwiastek(x.getMianownik());
            licznik = l.pomnozPierwiastki(m);
        } else if (x.getLicznik().contains("^")) { //jak byl potega to wyciaga wartosc i mnozy liczbe przez pierwiastek
            Potega p = new Potega(x.getLicznik());
            licznik = pomnozLiczbePrzezPierwiastek(String.valueOf(p.wartoscPotegi()), x.getMianownik());
        } else {
            licznik = pomnozLiczbePrzezPierwiastek(x.getLicznik(), x.getMianownik()); //ani pierwiastek ani potega, mnozy liczbe z pierwiastkiem
        }
        Pierwiastek p = new Pierwiastek(x.getMianownik());
        mianownik = p.pomnozPierwiastki(p); // mnozenie mianownika, pierwiastek z pierwiastkiem
        return "(" + licznik + ")/(" + mianownik + ")"; // uwymiernia ulamek, a/sqrt(b) wzroci a*sqrt(b)/b
    }

    public static String formatuj(String a){
        a = a.replace("(","{");
        a = a.replace(")","}");
        System.out.println("formatuj "+a);
        return a;
    }

    public static double NWD_2(double pierwsza, double druga) {
        if (druga == 0) {
            return pierwsza;
        } else // rekurencyjne wywołanie funkcji, gdzie kolejność parametrów
        {   // została zamieniona, dodatkowo drugi parametr to operacja modulo
            return NWD_2(druga, pierwsza % druga);  // dwóch liczb.
        }
    }

    public static String generujZera(int i) {
        String zera = "";
        while (i > 0) {
            zera = zera + "0";
            i--;
        }
        return zera;
    }

    public static String skrocUlamek(String a) {
        System.out.println("skrocUlamek " + a);
        Wartosc w = new Wartosc(a);
        String licznik = w.getLicznik();
        String mianownik = w.getMianownik();
        if (w.getLicznik().startsWith("((") && w.getLicznik().endsWith("))")){
            licznik = w.getLicznik().replace("((","");
            licznik = licznik.replace("))", "");
        }
        if (w.getMianownik().startsWith("((") && w.getMianownik().endsWith("))")){
            mianownik = w.getMianownik().replace("((","");
            mianownik = mianownik.replace("))", "");
        }
        if(mianownik.equals("0") || mianownik.equals("0.0")){
            return "0";
        }
        if(licznik.contains("\u221a") || licznik.contains("^") || licznik.contains("/") || mianownik.contains("\u221a") || mianownik.contains("^") || mianownik.contains("/")){
            return policz(licznik,mianownik,"/");
        }else {
            double nwd = NWD_2(Double.parseDouble(licznik), Double.parseDouble(mianownik));
            double x = Double.parseDouble(licznik) / nwd;
            double y = Double.parseDouble(mianownik) / nwd;
            if (y == 1) {
                return czyJestCalkowita(String.valueOf(x));
            } else {
                return "(" + czyJestCalkowita(String.valueOf(x)) + "/" + czyJestCalkowita(String.valueOf(y)) + ")";
            }
        }
    }

    public static String zamienKropke(String czynnik) {
        int i = 0;
        String licz, mian;
        String[] t = czynnik.split("\\.");
        i = t[1].length();
        licz = t[0] + t[1];
        mian = "1" + generujZera(i);
        return licz + "/" + mian;
    }

    public static String podzielPierwiastekPrzezLiczbe(String pierwiastek, String liczba) {
        String wynik = "";
        Pierwiastek p = new Pierwiastek(pierwiastek);
        String ulamek = "(" + Integer.parseInt(p.getFirst()) + ")/" + liczba + ""; //zamienia licznik na liczbe naturalna, 2sqrt(3)/4 => 2/4
        ulamek = skrocUlamek(ulamek); // skraca jak normalny ulamek
        Wartosc w = new Wartosc(ulamek); // rozbija go na licznik i mianownik
        if (Double.parseDouble(w.getMianownik()) == 1) {
            if (!w.getLicznik().equals("1")) {
                wynik = "(" + (int) Double.parseDouble(w.getLicznik()) + ")\u221a(" + Integer.parseInt(p.getInside()) + ")";
                //todo sprawdzic to rozwiazanie
                //MainActivity.tekst = MainActivity.tekst + "\nObliczenia poboczne:\nSkracanie:\n" + "((" + Integer.parseInt(p.getFirst()) + ")\u221a(" + Integer.parseInt(p.getInside()) + "))/(" + liczba + ") = " +
                  //      "(" + (int) Double.parseDouble(w.getLicznik()) + ")\u221a(" + Integer.parseInt(p.getInside()) + ")\n";
            } else {
                wynik = "\u221a(" + Integer.parseInt(p.getInside()) + ")";
                //todo sprawdzic to rozwiazanie
                //MainActivity.tekst = MainActivity.tekst + "\nSkracanie:\n" + "((" + Integer.parseInt(p.getFirst()) + ")\u221a(" + Integer.parseInt(p.getInside()) + "))/(" + liczba + ") = " +
                  //      "(" + (int) Double.parseDouble(w.getLicznik()) + ")\u221a(" + Integer.parseInt(p.getInside()) + ")\n";
            }
        } else {
            if (!w.getLicznik().equals("1")) {
                wynik = "((" + (int) Double.parseDouble(w.getLicznik()) + ")\u221a(" + Integer.parseInt(p.getInside()) + "))/(" + (int) Double.parseDouble(w.getMianownik()) + ")"; // dokleja pierwiastek do licznika
                if (Double.parseDouble(p.getFirst()) != (int) Double.parseDouble(w.getLicznik())) {
                    //todo sprawdzic to rozwiazanie
                    //MainActivity.tekst = MainActivity.tekst + "\nSkracanie:\n" + "((" + Integer.parseInt(p.getFirst()) + ")\u221a(" + Integer.parseInt(p.getInside()) + "))/(" + liczba + ") = " +
                      //      "(\u221a(" + Integer.parseInt(p.getInside()) + "))/(" + (int) Double.parseDouble(w.getMianownik()) + ")\n";
                }
            } else {
                wynik = "\u221a(" + Integer.parseInt(p.getInside()) + ")/(" + (int) Double.parseDouble(w.getMianownik()) + ")"; // dokleja pierwiastek do licznika
                if (Double.parseDouble(p.getFirst()) != (int) Double.parseDouble(w.getLicznik())) {
                    //todo sprawdzic to rozwiazanie
                    //MainActivity.tekst = MainActivity.tekst + "\nSkracanie:\n" + "((" + Integer.parseInt(p.getFirst()) + ")\u221a(" + Integer.parseInt(p.getInside()) + "))/(" + liczba + ") = " +
                      //      "((" + (int) Double.parseDouble(w.getLicznik()) + ")\u221a(" + Integer.parseInt(p.getInside()) + "))/(" + (int) Double.parseDouble(w.getMianownik()) + ")\n";
                }
            }
        }
        return wynik;
    }

    public static String podzielLiczbePrzezPierwiastek(String liczba, String pierwiastek) {
        System.out.println("podzielLiczbePrzezPierwiastek " + pierwiastek);
        String ulamek = "(" + liczba + ")/(" + pierwiastek + ")"; // tworzy string z ulamkiem licz/pierw
        Wartosc w = new Wartosc(ulamek); //tworzy obiekt do wywolania metody uwymiernij
        Wartosc x = new Wartosc(w.uwymiernijUlamek()); //uwymiernia ulamek i wyciaga z niego licznik i mianownik
        String wynik = x.podzielPierwiastekPrzezLiczbe(x.getLicznik(), x.getMianownik()); //dzieli Pierwiastek przez Liczbe
        return wynik;
    }

    public static String pomnozLiczbePrzezPierwiastek(String liczba, String pierwiastek) {
        System.out.println("pomnozLiczbePrzezPierwiastek " + pierwiastek);
        if(liczba.equals("1")){
            return pierwiastek;
        }
        Pierwiastek p = new Pierwiastek(pierwiastek);
        if(p.getFirst().equals("")){
            p.setFirst("1");
        }
        String wynik = policz(liczba, p.getFirst(), "*");
        return "(" + wynik + ")\u221a(" + Integer.parseInt(p.getInside()) + ")";
    }

    public String xRazyWyrazenie(String a) { //wyrazenie x(y + x) = xy + xz, metoda rozwojowa do pozniejszych obliczen
        String poczatek = a.substring(0, a.indexOf("\\(")); //x
        String srodek = a.substring(a.indexOf("\\(") + 1, a.length() - 1); //(y+z)
        String[] t = srodek.split(operatorOperacji(srodek)); //rozbicie y i z
        return policz(policz(poczatek, t[0], "*"), policz(poczatek, t[1], "*"), operatorOperacji(srodek));
    }

    public static boolean sprawdzMinus(String tekst) {
        int count = tekst.length() - tekst.replaceAll("-", "").length();
        while (count != 0) {
            int t = tekst.indexOf("-");
            char x = tekst.charAt(t - 1);
            char y = tekst.charAt(t + 1);
            if (x == ')' && y == '(' || Character.isDigit(x) && Character.isDigit(y) || x == ')' && Character.isDigit(y) || Character.isDigit(x) && y == '(') {
                return true;
            } else {
                tekst = tekst.substring(t, tekst.length());
                count--;
            }
        }
        return false;
    }

    public static Boolean czyJestWyrazeniem(String a) {
        System.out.println("czy " + a + " jest dzialaniem?");
        String[] d = a.split("\\+");
        String[] m = a.split("\\*");
        String[] dz = a.split("/");
        boolean ok = false;
        if (a.contains("-")) {
            if (a.indexOf("-") == 0) {
                a = a.substring(1, a.length());
            }
            ok = sprawdzMinus(a);
        }
        /*if(a.contains("/")){
            if(dz[0].contains("\u221a") || dz[0].contains("^") || dz[0].contains(".") || dz[1].contains("\u221a") || dz[1].contains("^") || dz[1].contains(".")){
                System.out.println("czy ulamek skomplikowany");
                String tmp = policz(dz[0],dz[1],"/");
                if(tmp.contains("/")){
                    String[] dz1 = tmp.split("/");
                    if(dz1[0].contains("\u221a") || dz1[0].contains("^") || dz1[0].contains(".") || dz1[1].contains("\u221a") || dz1[1].contains("^") || dz1[1].contains(".")){
                        return true;
                    }
                }
            }
        }*/
        if (jakieToWyrazenie(a).contains("\u221a") || jakieToWyrazenie(a).contains("^")){
            if (jakieToWyrazenie(a).contains("+") || jakieToWyrazenie(a).contains("-") || jakieToWyrazenie(a).contains("*")){   // ... || jakieToWyrazenie(a).contains("/")
                System.out.println("jest dzialaniem");
                return true;
            }else {
                System.out.println("nie jest dzialaniem");
                return false;
            }
        }
        if (d.length > 1 || m.length > 1 || dz.length > 2 || ok) {
            System.out.println("jest dzialaniem");
            return true;
        } else {
            System.out.println("nie jest dzialaniem");
            return false;
        }
    }

    public static Boolean nawiasy(String text){
        int counto = 0;
        int countz = 0;
        char no = '(';
        char nz = ')';
        for (int i=0; i < text.length(); i++)
        {
            if (text.charAt(i) == no)
            {
                counto++;
            }
            if (text.charAt(i) == nz)
            {
                countz++;
            }
        }
        if(counto == countz) {
            return true;
        }else{
            return false;
        }
    }

    public static String xZWyrazeniem(String x,String wyr, String operator){//glowny operator +8
        System.out.println("xZWyrazeniem " + x + " "+operator+" " + wyr);
        if(x.equals("1") && (operator.equals("*") || operator.equals("/"))){
            System.out.println("wyrazenie razy jeden ");
            return wyr;
        }
        String tmpop = jakieToWyrazenie(wyr);
        System.out.println("tmpop: " + tmpop);
        String op = "";
        if(tmpop.contains("+")){
            op = "+";
        }else if(tmpop.contains("-")){
            op = "-";
        }else if(tmpop.contains("/")){
            op = "/";
            wyr = wyr.replace(")/(",");(");
            wyr = wyr.replace(")/",");");
            wyr = wyr.replace("/(",";(");
            wyr = wyr.replace("/","|");
            wyr = wyr.replace(";","/");
        }else if(tmpop.contains("*")){
            op = "*";
        }
        if (operator.contains("/") && jakieToWyrazenie(x).contains("\u221a")){  //pierwiastek i ulamek
            String aa = xZWyrazeniem(x,wyr,"*");
            return xZWyrazeniem(policz(x,x,"*"),aa,"/");
        }
        System.out.println("op: " + op);
        String[] tmp;
        String a, b;
        switch (operator){
            case "+":
                System.out.println("case + " + wyr);
                tmp = wyr.split("\\"+op);
                for(int i=0;i<tmp.length;i++){
                    if(tmp[i].startsWith("((") && tmp[i].endsWith("))")){
                        tmp[i] = tmp[i].substring(1,tmp[i].length()-1);
                    }
                    tmp[i] = tmp[i].replace("|","/");
                }
                for(int i=0;i<tmp.length;i++) {
                    System.out.println("tmp[0]: " + tmp[i] + " tmp[1]: " + tmp[i+1]);
                    a = policz(x, tmp[i], operator);
                    if (op.equals("-")) {
                        b = policz(x, "-" + tmp[i+1], operator);
                    } else {
                        b = policz(x, tmp[i+1], operator);
                    }
                    System.out.println("a: " + a + " b: " + b);
                    if (czyJestWyrazeniem(a) && czyJestWyrazeniem(b)) {
                        return wyr + operator + x;
                    } else if (czyJestWyrazeniem(a) && !czyJestWyrazeniem(b)) {
                        return tmp[i] + op + b;
                    } else if (!czyJestWyrazeniem(a) && czyJestWyrazeniem(b)) {
                        return a + op + tmp[i+1];
                    } else {
                        return policz(a, b, operator);
                    }
                }
            case "-":
                System.out.println("case - ");
                tmp = wyr.split("\\"+op);
                for(int i=0;i<tmp.length;i++){
                    if(tmp[i].startsWith("((") && tmp[i].endsWith("))")){
                        tmp[i] = tmp[i].substring(1,tmp[i].length()-1);
                    }
                    tmp[i] = tmp[i].replace("|","/");
                }
                for(int i=0;i<tmp.length;i++) {
                    System.out.println("%%%%%%%%%tmp0: " + tmp[i] + " tmp1: " + tmp[i+1]);
                    a = policz(x, tmp[i], operator);
                    if (op.equals("-")) {
                        b = policz(x, "-" + tmp[i+1], operator);
                    } else {
                        b = policz(x, tmp[i+1], operator);
                    }
                    System.out.println("a: " + a + " b: " + b);
                    if (czyJestWyrazeniem(a) && czyJestWyrazeniem(b)) {
                        return wyr + operator + x;
                    } else if (czyJestWyrazeniem(a) && !czyJestWyrazeniem(b)) {
                        return tmp[i] + op + b;
                    } else if (!czyJestWyrazeniem(a) && czyJestWyrazeniem(b)) {
                        return a + op + tmp[i+1];
                    } else {
                        return policz(a, b, operator);
                    }
                }
            case "*":
                System.out.println("case * ");
                //wyr = wyr.replace("[","");
                //wyr = wyr.replace("]","");
                tmp = wyr.split("\\"+op);
                for(int i=0;i<tmp.length;i++){
                    if(tmp[i].startsWith("((") && tmp[i].endsWith("))")){
                        tmp[i] = tmp[i].substring(1,tmp[i].length()-1);
                    }
                    tmp[i] = tmp[i].replace("|","/");
                }
                for(int i=0;i<tmp.length;i++) {
                    System.out.println("case * for ");
                    if (op.equals("/")) {
                        String aa = xZWyrazeniem(x, tmp[i], operator);
                        return xZWyrazeniem(tmp[i+1], aa, "/");
                    }
                    a = policz(x, tmp[i], operator);
                    if (op.equals("-")) {
                        b = policz(x, "-" + tmp[i+1], operator);
                    } else {
                        b = policz(x, tmp[i+1], operator);
                    }
                    if (czyJestWyrazeniem(a) && czyJestWyrazeniem(b)) {
                        return wyr + operator + x;
                    } else if (czyJestWyrazeniem(a) && !czyJestWyrazeniem(b)) {
                        return tmp[i] + op + b;
                    } else if (!czyJestWyrazeniem(a) && czyJestWyrazeniem(b)) {
                        return a + op + tmp[i+1];
                    } else {
                        return policz(a, b, operator);
                    }
                }
                //todo zrobic skracanie np. (2+2√(2))/4 = (1+√(2))/2
            case "/":
                System.out.println("case / ");
                wyr = wyr.replace("|","/");
                if (!op.contains("/")){ //todo dzielenie zrobic
                    tmp = wyr.split("\\"+op);
                    for(int i=0;i<tmp.length;i++){
                        if(tmp[i].startsWith("((") && tmp[i].endsWith("))")){
                            tmp[i] = tmp[i].substring(1,tmp[i].length()-1);
                        }
                        tmp[i] = tmp[i].replace("|","/");
                    }
                    for(int i=0;i<tmp.length;i++) {
                        /*a = policz(tmp[i], x, operator);
                        if (op.equals("-")) {
                            b = policz("-" + tmp[i+1], x, operator);
                        } else {
                            b = policz(tmp[i+1], x, operator);
                        }*/
                        String tmpx = tmp[i]+operator+x;
                        String tmpy;
                        if (op.equals("-")) {
                            tmpy = "-"+tmp[i+1]+operator+x;
                        } else {
                            tmpy = tmp[i+1]+operator+x;
                        }
                        String skroconex = skrocUlamek(tmpx);
                        String skroconey = skrocUlamek(tmpy);
                        if (tmpx.equals(skroconex) && tmpy.equals(skroconey)){
                            return policz(skroconex,skroconey,op);
                        }else{
                            return "("+wyr+")/("+x+")";
                        }
                    }
                }else{
                    return "(" + wyr + ")/" + x;
                }
        }
        return "";
    }

    //todo sprawdzic i poprawic
    public static String wyrazenieZWyrazeniem(String wyr1){
        System.out.println("wyrazenieZwyrazeniem");
        String wynik = "";
        String tmpop = jakieToWyrazenie(wyr1);
        String op = "";
        if(tmpop.contains("+")){
            op = "+";
        }else if(tmpop.contains("-")){
            op = "-";
        }else if(tmpop.contains("/")){
            op = "/";
            wyr1 = wyr1.replace(")/(",");(");
            wyr1 = wyr1.replace(")/",");");
            wyr1 = wyr1.replace("/(",";(");
            wyr1 = wyr1.replace("/","|");
            wyr1 = wyr1.replace(";","/");
        }else if(tmpop.contains("*")){
            op = "*";
        }
        String[] tmp;
        String a,b;
        switch (op){
            case "+":
                tmp = wyr1.split("\\+");
                a = policz(tmp[0], tmp[0], "*");
                b = policz(tmp[1],tmp[1],"*");
                wynik = policz(a,b,"+");
                break;
            case "-":
                tmp = wyr1.split("-");//todo uwzglednic liczby ujemne
                a = policz(tmp[0],tmp[0],"*");
                b = policz(tmp[1],tmp[1],"*");
                wynik = policz(a, b, "-");
                break;
            case "*":
                tmp = wyr1.split("\\*");
                a = policz(tmp[0],tmp[0],"*");
                b = policz(tmp[1],tmp[1],"*");
                wynik = policz(a, b, "*");
                break;
            case "/":
                wyr1 = wyr1.substring(1,wyr1.length()-1);
                tmp = wyr1.split("/");
                a = policz(tmp[0],tmp[0],"*");
                b = policz(tmp[1],tmp[1],"*");
                wynik = policz(a, b, "/");
                break;
        }
     /*
        String op1 = jakieToWyrazenie(wyr1);
        String op2 = jakieToWyrazenie(wyr2);
        String[] tmp1 = wyr1.split(op1);
        String[] tmp2 = wyr2.split(op2);
        String a = policz(tmp1[0],tmp2[0],operator);
        String b = policz(tmp1[1],tmp2[1],operator);
        return policz(a,b,op);*/
    return wynik;
    }

    public static String obliczWyrazenie(String a){
        System.out.println("obliczWyrazenie " + a);
        String[] m;
        String[] d;
        String[] o;
        String wynik = a;
        a = a.replace("*-","*|");
        a = a.replace("/-","/|");
        if(jakieToWyrazenie(a).contains("+")){
            a=a.replace("/|","/-");
            d = a.split("\\+");
            for(int i=0;i<d.length-1;i++){
                System.out.println("obliczWyrazenie + " + d[i]+" ; "+d[i+1]);
                if (czyJestWyrazeniem(d[i])){
                    d[i]=obliczWyrazenie(d[i]);
                }
                if (czyJestWyrazeniem(d[i+1])){
                    d[i+1]=obliczWyrazenie(d[i + 1]);
                }
                if(d[i].startsWith("((") && d[i].endsWith("))")){
                    d[i] = d[i].substring(1,d[i].length()-1);
                }
                if(d[i+1].startsWith("((") && d[i+1].endsWith("))")){
                    d[i+1] = d[i+1].substring(1,d[i+1].length()-1);
                }
                System.out.println("obliczWyrazenie + " + d[i]+" ; "+d[i+1]);
                d[i+1]=policz(d[i],d[i+1],"+");

            }
            return d[d.length-1];
        }
        if(jakieToWyrazenie(a).contains("-")){
            if (a.charAt(0)=='-'){
                a=a.substring(1,a.length());
                o = a.split("-");
                o[0]="-"+o[0];
            }else if(a.startsWith("(-")){
                a="("+a.substring(2,a.length());
                o = a.split("-");
                o[0]="-"+o[0];
            }else {
                o = a.split("-");
            }
            for(int i=0;i<o.length-1;i++){
                if (czyJestWyrazeniem(o[i])){
                    o[i]=obliczWyrazenie(o[i]);
                }
                if (czyJestWyrazeniem(o[i+1])){
                    o[i+1]=obliczWyrazenie(o[i + 1]);
                }
                if(o[i].startsWith("((") && o[i].endsWith("))")){
                    o[i] = o[i].substring(1,o[i].length()-1);
                }
                if(o[i+1].startsWith("((") && o[i+1].endsWith("))")){
                    o[i+1] = o[i+1].substring(1,o[i+1].length()-1);
                }
                System.out.println("obliczWyrazenie - " + o[i]+" ; "+o[i+1]);
                o[i+1]=policz(o[i],o[i+1],"-");
            }
            return o[o.length-1];
        }
        if(jakieToWyrazenie(a).contains("*")){
            a=a.replace("/|","/-");
            a=a.replace("*|","*-");
            m = a.split("\\*");
            for(int i=0;i<m.length-1;i++){
                System.out.println("obliczWyrazenie * " + m[i]+" ; "+m[i+1]);
                if (czyJestWyrazeniem(m[i])){
                    m[i]=obliczWyrazenie(m[i]);
                }
                if (czyJestWyrazeniem(m[i+1])){
                    m[i+1]=obliczWyrazenie(m[i + 1]);
                }
                if(m[i].startsWith("((") && m[i].endsWith("))")){
                    m[i] = m[i].substring(1,m[i].length()-1);
                }
                if(m[i+1].startsWith("((") && m[i+1].endsWith("))")){
                    m[i+1] = m[i+1].substring(1,m[i+1].length()-1);
                }
                m[i+1]=policz(m[i],m[i+1],"*");
            }
            return m[m.length-1];
        }
        if(jakieToWyrazenie(a).contains("/")){
            a=a.replace("/|","/-");
            wynik = policz(a,"1","*");
        }
        return wynik;
    }

    public static String policz(String czynnik1, String czynnik2, String operator) {
        System.out.println("policz: " + czynnik1 + " " + operator + " " + czynnik2);
        String wynik = "";
        if (czyJestWyrazeniem(czynnik1) || czyJestWyrazeniem(czynnik2)) {
            if (czynnik1.equals(czynnik2)) {        //wyrazenie z wyrazeniem
                System.out.println("takie same wyrazenia");
                String x = obliczWyrazenie(czynnik1);
                if (czyJestWyrazeniem(x)) {
                    switch (operator.charAt(0)) {                           //oba wyrazenia takie same
                        case '+':
                            wynik = "2(" + czynnik1 + ")";
                            break;
                        case '-':
                            wynik = "0";
                            break;
                        case '*':
                            wynik = wyrazenieZWyrazeniem(czynnik1);
                            //wynik = "" + czynnik1 + "*" + czynnik2 + "";
                            break;
                        case '/':
                            wynik = "1";
                            break;
                    }
                }else{
                    wynik = policz(x,x,operator.charAt(0)+"");
                }
            } else if(czyJestWyrazeniem(czynnik1) && !czyJestWyrazeniem(czynnik2)){                                                        //rozne wyrazenia
                System.out.println("wyrazenie z X " + czynnik1 + " ; " + czynnik2);
                if(!czynnik2.equals("1")) {
                    String x = obliczWyrazenie(czynnik1);
                    switch (operator.charAt(0)) {
                        case '+':
                            if (czyJestWyrazeniem(x)) {
                                wynik = xZWyrazeniem(czynnik2, x, "+");
                                //wynik = "" + czynnik1 + "+" + czynnik2 + "";
                                break;
                            } else {
                                wynik = policz(x, czynnik2, "+");
                                break;
                            }
                        case '-':
                            if (czyJestWyrazeniem(x)) {
                                wynik = xZWyrazeniem(czynnik2, x, "-");
                                //wynik = "" + czynnik1 + "-" + czynnik2 + "";
                                break;
                            } else {
                                wynik = policz(x, czynnik2, "-");
                                break;
                            }
                        case '*':
                            if (czyJestWyrazeniem(x)) {
                                wynik = xZWyrazeniem(czynnik2, x, "*");
                                break;
                            } else {
                                wynik = policz(x, czynnik2, "*");
                                break;
                            }
                        case '/':
                            if (czyJestWyrazeniem(x)) {
                                wynik = xZWyrazeniem(czynnik2, x, "/");
                                break;
                            } else {
                                wynik = policz(x, czynnik2, "/");
                                break;
                            }
                    }
                }else{
                    wynik = czynnik1;
                }
            }else if (!czyJestWyrazeniem(czynnik1) && czyJestWyrazeniem(czynnik2)){
                System.out.println("X z wyrazeniem " + czynnik1 + " ; " + czynnik2);
                if(!czynnik1.equals("1")) {
                    String x = obliczWyrazenie(czynnik2);
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = xZWyrazeniem(czynnik1, x, "+");
                            //wynik = "" + czynnik1 + "+" + czynnik2 + "";
                            break;
                        case '-':
                            wynik = xZWyrazeniem(czynnik1, x, "-");
                            //wynik = "" + czynnik1 + "-" + czynnik2 + "";
                            break;
                        case '*':
                            if (czyJestWyrazeniem(x)) {
                                wynik = xZWyrazeniem(czynnik1, x, "*");
                                break;
                            } else {
                                wynik = policz(x, czynnik1, "*");
                                break;
                            }
                        case '/':
                            if (czyJestWyrazeniem(x)) {
                                wynik = xZWyrazeniem(czynnik1, x, "/");
                                break;
                            } else {
                                wynik = policz(czynnik1, x, "/");
                                break;
                            }
                    }
                }else{
                    wynik = czynnik2;
                }
            }else {
                System.out.println("wyrazenie z wyrazeniem " + czynnik1 + " ; " + czynnik2);
                String x = obliczWyrazenie(czynnik1);
                String y = obliczWyrazenie(czynnik2);
                switch (operator.charAt(0)) {
                    case '+':
                        wynik = "" + x + "+" + y + "";
                        break;
                    case '-':
                        wynik = "" + x + "-" + y + "";
                        break;
                    case '*':
                        wynik = "" + x + "*" + y + "";
                        break;
                    case '/':
                        wynik = "" + x + "/" + y + "";
                        break;
                }
            }
        } else {
            if (jakieToWyrazenie(czynnik1).contains("/")) {
                if (jakieToWyrazenie(czynnik2).contains("\u221a")) { // ulamek i pierwiastek
                    System.out.println("ulamek i pierwiastek");
                    Wartosc war = new Wartosc(czynnik1);
                    Pierwiastek p = new Pierwiastek(czynnik2);
                    String x = p.wartoscPierwiastka();
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(policz(war.getLicznik(), policz(x,war.getMianownik(),"*"), "+"), war.getMianownik(), "/");
                            break;
                        case '-':
                            wynik = policz(policz(war.getLicznik(), policz(x,war.getMianownik(),"*"), "-"), war.getMianownik(), "/");
                            break;
                        case '*':
                            wynik = policz(policz(war.getLicznik(), x, "*"), war.getMianownik(), "/");
                            break;
                        case '/':
                            wynik = policz(policz(war.getLicznik(), war.getMianownik(), "/"), "1/" + x, "*");
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("^")) { // ulamek i potega
                    System.out.println("ulamek i potega");
                    Wartosc war = new Wartosc(czynnik1);
                    Potega pot = new Potega(czynnik2);
                    String x = pot.wartoscPotegi();
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(policz(policz(x, war.getMianownik(), "*"), war.getLicznik(), "+"), war.getMianownik(), "/");
                            break;
                        case '-':
                            wynik = policz(policz(war.getLicznik(), policz(x, war.getMianownik(), "*"), "-"), war.getMianownik(), "/");
                            break;
                        case '*':
                            wynik = policz(policz(war.getLicznik(), x, "*"), war.getMianownik(), "/");
                            break;
                        case '/':
                            wynik = policz(policz(war.getLicznik(), war.getMianownik(), "/"),"1/"+x,"*");
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("/")) { // ulamek i ulamek
                    System.out.println("ulamek i ulamek");
                    Wartosc war1 = new Wartosc(czynnik1);
                    Wartosc war2 = new Wartosc(czynnik2);
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = war1.dodajUlamki(war2);
                            break;
                        case '-':
                            wynik = war1.odejmijUlamki(war2);
                            break;
                        case '*':
                            wynik = war1.pomnozUlamki(war2);
                            break;
                        case '/':
                            wynik = war1.podzielUlamki(war2);
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains(".")) { // ulamek i liczba z kropka
                    System.out.println("ulamek i kropka");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "+");
                            break;
                        case '-':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "-");
                            break;
                        case '*':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "*");
                            break;
                        case '/':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "/");
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("\u03C0")) { // ulamek i pi
                    System.out.println("ulamek i pi");
                    Wartosc war = new Wartosc(czynnik1);
                    LiczbaPi pi = new LiczbaPi(czynnik2);
                    String valPi = pi.wartoscPi();
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(czynnik2, czynnik1, "+");            //przeniesienie do pi i ulamek
                            break;
                        case '-':
                            if(valPi.equals("0")){
                                wynik = policz(war.getLicznik(),war.getMianownik(),"/");
                                break;
                            } else {
                                wynik = "(" + policz(war.getLicznik(),war.getMianownik(),"/") + ")-" + pi.wartoscPi();
                                break;
                            }
                        case '*':
                            wynik = policz(czynnik2, czynnik1, "*");          //przeniesienie do pi i ulamek
                            break;
                        case '/':
                            if(valPi.equals("0")){
                                wynik = "0";
                            } else {
                                wynik = policz(czynnik1,"1/"+valPi,"*");
                            }
                            break;
                    }
                } else if (!jakieToWyrazenie(czynnik2).contains("\u221a") && !jakieToWyrazenie(czynnik2).contains("^") && !jakieToWyrazenie(czynnik2).contains("/") && !jakieToWyrazenie(czynnik2).contains(".")) { // ulamek i liczba
                    Wartosc w = new Wartosc(czynnik1);
                    Wartosc k = new Wartosc(czynnik2);
                    System.out.println("ulamek i liczba");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = w.dodajUlamki(k);
                            break;
                        case '-':
                            wynik = w.odejmijUlamki(k);
                            break;
                        case '*':
                            wynik = policz(czynnik1, czynnik2 + "/1", "*");
                            break;
                        case '/':
                            wynik = policz(czynnik1, "1/" + czynnik2, "*");
                            break;
                    }
                }
            } else if (jakieToWyrazenie(czynnik1).contains("^")) {
                if (jakieToWyrazenie(czynnik2).contains("\u221a")) { // potega i pierwiastek
                    System.out.println("potega i pierwiastek");
                    Potega pot = new Potega(czynnik1);
                    Pierwiastek pier = new Pierwiastek(czynnik2);
                    String y = pot.wartoscPotegi();
                    String x = pier.wartoscPierwiastka();
                    switch (operator.charAt(0)) {
                        case '+':
                            if (x.contains("\u221a") && y.contains("^")) {
                                wynik = "" + y + "+" + x + "";
                                break;
                            } else {
                                wynik = policz(x, y, "+");
                                break;
                            }
                        case '-':
                            if (x.contains("\u221a") && y.contains("^")) {
                                wynik = "" + y + "-" + x + "";
                                break;
                            } else {
                                wynik = policz(y, x, "-");
                                break;
                            }
                        case '*':
                            if (x.contains("\u221a") && y.contains("^")) {
                                wynik = "" + y + "*" + x + "";
                                break;
                            } else {
                                wynik = policz(x, y, "*");
                                break;
                            }
                        case '/':
                            if (x.contains("\u221a") && y.contains("^")) {
                                wynik = "" + y + "/" + x + "";
                                break;
                            } else {
                                wynik = policz(y, x, "/");
                                break;
                            }
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("^")) { // potega i potega
                    System.out.println("potega i potega");
                    Potega pot = new Potega(czynnik1);
                    Potega pot1 = new Potega(czynnik2);
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = pot.dodajPotegi(pot1);
                            break;
                        case '-':
                            wynik = pot.odejmijPotegi(pot1);
                            break;
                        case '*':
                            wynik = pot.pomnozPotegi(pot1);
                            break;
                        case '/':
                            wynik = pot.podzielPotegi(pot1);
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("/")) { // potega i ulamek
                    System.out.println("potega i ulamek");
                    Potega pot = new Potega(czynnik1);
                    Wartosc war = new Wartosc(czynnik2);
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(policz(policz(pot.wartoscPotegi(), war.getMianownik(), "*"), war.getLicznik(), "+"), war.getMianownik(), "/");
                            break;
                        case '-':
                            wynik = policz(policz(policz(pot.wartoscPotegi(), war.getMianownik(), "*"), war.getLicznik(), "-"), war.getMianownik(), "/");
                            break;
                        case '*':
                            wynik = policz(policz(pot.wartoscPotegi(), war.getLicznik(), "*"), war.getMianownik(), "/");
                            break;
                        case '/':
                            wynik = policz(policz(pot.wartoscPotegi(), war.getMianownik(), "*"), war.getLicznik(), "/");
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains(".")) { // potega i liczba z kropka
                    System.out.println("potega i kropka");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(czynnik1,zamienKropke(czynnik2),"+");
                            break;
                        case '-':
                            wynik = policz(czynnik1,zamienKropke(czynnik2),"-");
                            break;
                        case '*':
                            wynik = policz(czynnik1,zamienKropke(czynnik2),"*");
                            break;
                        case '/':
                            wynik = policz(czynnik1,zamienKropke(czynnik2),"/");
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains(".")) { // potega i pi
                    System.out.println("potega i pi");
                    LiczbaPi pi = new LiczbaPi(czynnik2);
                    String valPi = pi.wartoscPi();
                    Potega pot = new Potega(czynnik1);
                    String valPot = pot.wartoscPotegi();
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(czynnik2, czynnik1, "+");        //przeniesienie do pi i potęga
                            break;
                        case '-':
                            if(valPot.contains("^") && valPi.contains("π")) {
                                wynik = valPot + "-" + valPi;
                                break;
                            }
                            else if(valPi.contains("0")){
                                wynik=valPot;
                                break;
                            }
                            else{
                                wynik = policz(valPot, valPi, "-");
                                break;
                            }
                        case '*':
                            wynik = policz(czynnik2, czynnik1, "*");        //przeniesienie do pi i potęga
                            break;
                        case '/':
                            if(valPot.contains("^") && valPi.contains("π")) {
                                wynik = valPot + "/" + valPi;
                            }
                            else if(valPi.contains("0")){
                                wynik = "0";
                            }
                            else{
                                wynik = policz(valPot, valPi, "/");
                            }
                            break;
                    }
                } else if (!jakieToWyrazenie(czynnik2).contains("\u221a") && !jakieToWyrazenie(czynnik2).contains("^") && !jakieToWyrazenie(czynnik2).contains("/") && !jakieToWyrazenie(czynnik2).contains(".")) { // potega i liczba
                    System.out.println("potega i liczba");
                    Potega p = new Potega(czynnik1);
                    String x = p.wartoscPotegi();
                    switch (operator.charAt(0)) {
                        case '+':
                            if(jakieToWyrazenie(x).contains("^")) {
                                wynik = "" + x + "+" + czynnik2;
                                break;
                            }else {
                                wynik = policz(x, czynnik2, "+");
                                break;
                            }
                        case '-':
                            if(jakieToWyrazenie(x).contains("^")) {
                                wynik = "" + x + "-" + czynnik2;
                                break;
                            }else {
                                wynik = policz(x, czynnik2, "-");
                                break;
                            }
                        case '*':
                            if(jakieToWyrazenie(x).contains("^")) {
                                if(czynnik2.equals("1")){
                                    wynik = x;
                                    break;
                                }else {
                                    wynik = "" + x + "*" + czynnik2;
                                    break;
                                }
                            }else {
                                wynik = policz(x, czynnik2, "*");
                                break;
                            }
                        case '/':
                            if(jakieToWyrazenie(x).contains("^")) {
                                wynik = "" + x + "/" + czynnik2;
                                break;
                            }else {
                                wynik = policz(x, czynnik2, "/");
                                break;
                            }
                    }
                }
            } else if (jakieToWyrazenie(czynnik1).contains("\u221a")) {
                if (jakieToWyrazenie(czynnik2).contains("\u221a")) { // pierwiastek i pierwiastek
                    System.out.println("pierwiastek i pierwiastek");
                    Pierwiastek p = new Pierwiastek(czynnik1);
                    Pierwiastek d = new Pierwiastek(czynnik2);
                    String x = p.wartoscPierwiastka();
                    String y = d.wartoscPierwiastka();
                    switch (operator.charAt(0)) {
                        case '+':
                            if (jakieToWyrazenie(x).contains("\u221a") && jakieToWyrazenie(y).contains("\u221a")) {
                                wynik = p.dodajPierwiastki(d);
                                break;
                            } else {
                                wynik = policz(x, y, "+");
                                break;
                            }
                        case '-':
                            if (jakieToWyrazenie(x).contains("\u221a") && jakieToWyrazenie(y).contains("\u221a")) {
                                wynik = p.odejmijPierwiastki(d);
                                break;
                            } else {
                                wynik = policz(x, y, "-");
                                break;
                            }
                        case '*':
                            if (jakieToWyrazenie(x).contains("\u221a") && jakieToWyrazenie(y).contains("\u221a")) {
                                wynik = p.pomnozPierwiastki(d);
                                break;
                            } else {
                                wynik = policz(x, y, "*");
                                break;
                            }
                        case '/':
                            if (jakieToWyrazenie(x).contains("\u221a") && jakieToWyrazenie(y).contains("\u221a")) {
                                wynik = p.podzielPierwiastki(d);
                                break;
                            } else {
                                wynik = policz(x, y, "/");
                                break;
                            }
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("^")) { // pierwiastek i potega
                    System.out.println("pierwiastek i potega");
                    Pierwiastek pier = new Pierwiastek(czynnik1);
                    Potega pot = new Potega(czynnik2);
                    String x = pier.wartoscPierwiastka();
                    String y = pot.wartoscPotegi();
                    switch (operator.charAt(0)) {
                        case '+':
                            if (jakieToWyrazenie(x).contains("\u221a") && jakieToWyrazenie(y).contains("^")) {
                                wynik = "" + x + "+" + y + "";
                                break;
                            } else {
                                wynik = policz(x, y, "+");
                                break;
                            }
                        case '-':
                            if (jakieToWyrazenie(x).contains("\u221a") && jakieToWyrazenie(y).contains("^")) {
                                wynik = "" + x + "-" + y + "";
                                break;
                            } else {
                                wynik = policz(x, y, "-");
                                break;
                            }
                        case '*':
                            if (jakieToWyrazenie(x).contains("\u221a") && jakieToWyrazenie(y).contains("^")) {
                                wynik = "" + x + "*" + y + "";
                                break;
                            } else {
                                wynik = policz(x, y, "*");
                                break;
                            }
                        case '/':
                            if (jakieToWyrazenie(x).contains("\u221a") && jakieToWyrazenie(y).contains("^")) {
                                wynik = "" + x + "/" + y + "";
                                break;
                            } else {
                                wynik = policz(x, y, "/");
                                break;
                            }
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("/")) { // pierwiastek i ulamek
                    System.out.println("pierwiastek i ulamek");
                    Wartosc war = new Wartosc(czynnik2);
                    Pierwiastek p = new Pierwiastek(czynnik1);
                    String x = p.wartoscPierwiastka();
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(policz(policz(x,war.getMianownik(),"*"), war.getLicznik(), "+"), war.getMianownik(), "/");
                            break;
                        case '-':
                            wynik = policz(policz(policz(x,war.getMianownik(),"*"), war.getLicznik(), "-"), war.getMianownik(), "/");
                            break;
                        case '*':
                            wynik = policz(policz(x, war.getLicznik(), "*"), war.getMianownik(), "/");
                            break;
                        case '/':
                            wynik = policz(policz(x, war.getMianownik(), "*"), war.getLicznik(), "/");
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("\u03C0")) { // pierwiastek i pi
                    System.out.println("pierwiastek i pi");
                    LiczbaPi pi = new LiczbaPi(czynnik2);
                    String valPi = pi.wartoscPi();
                    Pierwiastek pier = new Pierwiastek(czynnik1);
                    String valPierw = pier.wartoscPierwiastka();
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(czynnik2, czynnik1, "+");        //przeniesienie do pi i pierwiastek
                            break;
                        case '-':
                            if(valPierw.contains("√") && valPi.contains("π")) {
                                wynik = valPierw + "-" + valPi;
                                break;
                            }
                            else if (valPi.contains("0")){
                                wynik=valPierw;
                                break;
                            }
                            else{
                                wynik = policz(valPierw, valPi, "-");
                                break;
                            }
                        case '*':
                            wynik = policz(czynnik2, czynnik1, "*");        //przeniesienie do pi i pierwiastek
                            break;
                        case '/':
                            if(valPierw.contains("√") && valPi.contains("π")) {
                                wynik = valPierw + "/" + valPi;
                            }
                            else if(valPi.contains("0")){
                                wynik="0";
                            }
                            else {
                                wynik = policz(valPierw, valPi, "/");
                            }
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains(".")) { // pierwiastek i liczba z kropka
                    System.out.println("pierwiastek i kropka");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "+");
                            break;
                        case '-':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "-");
                            break;
                        case '*':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "*");
                            break;
                        case '/':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "/");
                            break;
                    }
                } else if (!jakieToWyrazenie(czynnik2).contains("\u221a") && !jakieToWyrazenie(czynnik2).contains("^") && !jakieToWyrazenie(czynnik2).contains("/") && !jakieToWyrazenie(czynnik2).contains(".")) { // pierwiastek i liczba
                    System.out.println("pierwiastek i liczba ");
                    Pierwiastek p = new Pierwiastek(czynnik1);
                    String x = p.wartoscPierwiastka();
                    Pierwiastek tmp = null;
                    if (x.contains("\u221a")) {
                        tmp = new Pierwiastek(x);
                    }
                    if (x.contains("\u221a") && !czyJestWyrazeniem(tmp.getInside()) && tmp.getInside().contains("-")) {// && p.getInside().contains("-")) {
                        Toast.makeText(Global.mContext, "Nie ma pierwiastka z liczby ujemnej!", Toast.LENGTH_SHORT).show();
                        wynik = "";
                    } else {
                        switch (operator.charAt(0)) {
                            case '+':
                                if (jakieToWyrazenie(x).contains("\u221a")) {
                                    wynik = "" + x + "+" + czynnik2 + "";
                                    break;
                                } else {
                                    wynik = policz(x, czynnik2, "+");
                                    break;
                                }
                            case '-':
                                if (jakieToWyrazenie(x).contains("\u221a")) {
                                    wynik = "" + x + "-" + czynnik2 + "";
                                    break;
                                } else {
                                    wynik = policz(x, czynnik2, "-");
                                    break;
                                }
                            case '*':
                                if (jakieToWyrazenie(x).contains("\u221a")) {
                                    wynik = pomnozLiczbePrzezPierwiastek(czynnik2, x);
                                    break;
                                } else {
                                    wynik = policz(x, czynnik2, "*");
                                    break;
                                }
                            case '/':
                                if (jakieToWyrazenie(x).contains("\u221a")) {
                                    wynik = podzielPierwiastekPrzezLiczbe(x, czynnik2);
                                    break;
                                } else {
                                    wynik = policz(x, czynnik2, "/");
                                    break;
                                }
                        }
                    }
                }
            } else if (jakieToWyrazenie(czynnik1).contains(".")) {
                if (czynnik2.contains("\u221a")) { // kropka i pierwiastek
                    System.out.println("kropka i pierwiastek");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "+");
                            break;
                        case '-':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "-");
                            break;
                        case '*':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "*");
                            break;
                        case '/':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "/");
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("^")) { // kropka i potega
                    System.out.println("kropka i potega");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "+");
                            break;
                        case '-':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "-");
                            break;
                        case '*':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "*");
                            break;
                        case '/':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "/");
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("/")) { // kropka i ulamek
                    System.out.println("kropka i ulamek");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "+");
                            break;
                        case '-':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "-");
                            break;
                        case '*':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "*");
                            break;
                        case '/':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "/");
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("/")) { // kropka i pi
                    System.out.println("kropka i pi");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "+");
                            break;
                        case '-':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "-");
                            break;
                        case '*':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "*");
                            break;
                        case '/':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "/");
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains(".")) { // kropka i kropka
                    System.out.println("kropka i kropka");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(zamienKropke(czynnik1), zamienKropke(czynnik2), "+");
                            break;
                        case '-':
                            wynik = policz(zamienKropke(czynnik1), zamienKropke(czynnik2), "-");
                            break;
                        case '*':
                            wynik = policz(zamienKropke(czynnik1), zamienKropke(czynnik2), "*");
                            break;
                        case '/':
                            wynik = policz(zamienKropke(czynnik1), zamienKropke(czynnik2), "/");
                            break;
                    }
                } else if (!jakieToWyrazenie(czynnik2).contains("\u221a") && !jakieToWyrazenie(czynnik2).contains("^") && !jakieToWyrazenie(czynnik2).contains("/") && !jakieToWyrazenie(czynnik2).contains(".")) { // kropka i liczba
                    System.out.println("kropka i liczba");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "+");
                            break;
                        case '-':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "-");
                            break;
                        case '*':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "*");
                            break;
                        case '/':
                            wynik = policz(zamienKropke(czynnik1), czynnik2, "/");
                            break;
                    }
                }
            } else if (jakieToWyrazenie(czynnik1).contains("\u03C0")) {
                LiczbaPi pi = new LiczbaPi(czynnik1);
                String y = pi.wartoscPi();
                System.out.println(y);
                if (czynnik2.contains("\u221a")) { // pi i pierwiastek
                    System.out.println("pi i pierwiastek");
                    Pierwiastek p = new Pierwiastek(czynnik2);
                    String x = p.wartoscPierwiastka();
                    switch (operator.charAt(0)) {
                        case '+':
                            if (y.contains("π") && !x.equals("0")){
                                wynik = x + "+" + y;
                                break;
                            }
                            else{
                                wynik = x;
                                break;
                            }
                        case '-': //todo uwzglednić valPi
                            if (jakieToWyrazenie(x).contains("\u221a")) {
                                wynik = y + "-" + x;
                                break;
                            } else {
                                wynik = policz(y, x, "-");
                                break;
                            }
                        case '*':
                            System.out.println(x);
                            if (y.contains("π")){
                                String tmp = policz(x,pi.getFirst(),"*");
                                wynik = tmp + "π";      //w razie czego dodać nawiasy
                            } else {
                                wynik = "0";
                            }
                            break;
                        case '/': //todo uwzglednić valPi
                            String tmp2 = policz(y, x, "/");
                            if (czyJestWyrazeniem(tmp2)) {
                                wynik = y + "/" + x;
                                break;
                            } else {
                                if (tmp2.equals("1")){
                                    wynik = "π";
                                    break;
                                } else if (tmp2.equals("-1")){
                                    wynik = tmp2 + "-π";
                                    break;
                                } else {
                                    wynik = tmp2 + "π";
                                    break;
                                }

                            }
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("^")) { // pi i potega
                    System.out.println("pi i potega");
                    Potega p = new Potega(czynnik2);
                    String x = p.wartoscPotegi();
                    switch (operator.charAt(0)) {
                        case '+':
                            if (jakieToWyrazenie(x).contains("^")) {
                                wynik = x + "+" + y;
                                break;
                            } else {
                                wynik = policz(x, y, "+");
                                break;
                            }
                        case '-':
                            if (jakieToWyrazenie(x).contains("^")) {
                                if(y.contains("π")) {
                                    wynik = y + "-" + x;
                                    break;
                                }
                                else{
                                    wynik = x;
                                    break;
                                }
                            } else {
                                wynik = policz(y, x, "-");
                                break;
                            }
                        case '*':
                            if (jakieToWyrazenie(x).contains("^")) {
                                wynik = y + "*" + x;
                                break;
                            } else {
                                wynik = policz(pi.getFirst(), x, "*") + "π";
                                break;
                            }
                        case '/':
                            if (jakieToWyrazenie(x).contains("^")) {
                                if(y.contains("π")) {
                                    wynik = y + "/" + x;
                                    break;
                                }
                                else{
                                    wynik = "0";
                                    break;
                                }
                            } else {
                                wynik = policz(pi.getFirst(), x, "/") + "π";
                                break;
                            }
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("/")) { // PI i UŁAMEK *******************************************
                    System.out.println("pi i ulamek");
                    Wartosc w = new Wartosc(czynnik2);
                    String x = policz(w.getLicznik(), w.getMianownik(), "/");
                    switch (operator.charAt(0)) {
                        case '+':
                            if (jakieToWyrazenie(x).contains("/")) {
                                if(y.contains("π")) {
                                    wynik = y + "+" + x;
                                    break;
                                }
                                else{
                                    wynik=x;
                                    break;
                                }
                            } else {
                                wynik = policz(x, y, "+");
                                break;
                            }
                        case '-':
                            if (jakieToWyrazenie(x).contains("/")) {
                                wynik = y + "-" + x;
                                break;
                            } else {
                                wynik = policz(y, x, "-");
                                break;
                            }
                        case '*':
                            if (jakieToWyrazenie(x).contains("/") && y.contains("π")) {
                                //Wartosc tmp = new Wartosc(x);
                                //todo CZY tutaj w ogóle śa potrzebne  else ???
                                wynik = policz( pi.getFirst(), x, "*") + "π";
                                //wynik = policz( policz(pi.getFirst(), tmp.getMianownik(), "/")   ,tmp.getLicznik(),"*") + "π";
                                break;
                            } else {
                                if(y.equals("0")) {
                                    wynik = "0";
                                    break;
                                }
                                else {
                                    wynik = policz(pi.getFirst(), x, "*") + "π";
                                    break;
                                }
                            }
                        case '/':
                            if (jakieToWyrazenie(x).contains("/") && y.contains("π")) {
                                Wartosc tmp = new Wartosc(x);
                                //TODO Sprawdzic czy dobrze
                                //wynik = policz(policz(pi.getFirst(), tmp.getLicznik(), "/"),tmp.getMianownik(),"*") + "π";
                                wynik = policz(tmp.getLicznik(),policz(pi.getFirst(),tmp.getMianownik(),"*"),"/")+"π";
                                break;
                            } else {
                                if (y.equals("0")) {
                                    wynik = "0";
                                    break;
                                } else {
                                    wynik = policz(pi.getFirst(), x, "/") + "π";
                                    break;
                                }
                            }
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("\u03C0")) { // PI i PI **********************************************************
                    System.out.println("pi i pi");
                    LiczbaPi pi2 = new LiczbaPi(czynnik2);
                    String x;   // zmienna tymczasowa do działan na First liczby PI1 i liczby PI2
                    switch (operator.charAt(0)) {
                        case '+':
                            x = policz(pi.getFirst(), pi2.getFirst(), "+");
                            if(czyJestWyrazeniem(x)){
                                wynik = "(" + x + ")*π";
                                break;
                            } else {
                                if(x.equals("0")) {
                                    wynik = "0";
                                    break;
                                } else if(x.equals("1")) {
                                    wynik = "π";
                                    break;
                                } else if(x.equals("-1")) {
                                    wynik = "-π";
                                    break;
                                } else {
                                    wynik = x + "π";
                                    break;
                                }
                            }
                        case '-':
                            x = policz(pi.getFirst(), pi2.getFirst(), "-");
                            if(czyJestWyrazeniem(x)){
                                wynik = "(" + x + ")*π";
                                break;
                            } else {
                                if(x.equals("0")) {
                                    wynik = "0";
                                    break;
                                } else if(x.equals("1")) {
                                    wynik = "π";
                                    break;
                                } else if(x.equals("-1")) {
                                    wynik = "-π";
                                    break;
                                } else {
                                    wynik = x + "π";
                                    break;
                                }
                            }
                        case '*':
                            x = policz(pi.getFirst(), pi2.getFirst(), "*");
                            if(czyJestWyrazeniem(x)){
                                wynik = "(" + x + ")*π^2";
                                break;
                            } else {
                                if(x.equals("0")) {
                                    wynik = "0";
                                    break;
                                } else if(x.equals("1")) {
                                    wynik = "π^2";
                                    break;
                                } else if(x.equals("-1")) {
                                    wynik = "-(π^2)"; // BO -3.14 * 3.14 = -6.... a bez nawiasu byłoby 6...
                                    break;
                                } else {
                                    wynik = x + "π^2";
                                    break;
                                }
                            }
                        case '/':
                            //TODO DZIELENIE PI przez PI^2
                            x = policz(pi.getFirst(), pi2.getFirst(), "/");
                            wynik = x;
                            break;
                    }
                } else if (!jakieToWyrazenie(czynnik2).contains("\u221a") && !jakieToWyrazenie(czynnik2).contains("^") && !jakieToWyrazenie(czynnik2).contains("/") && !jakieToWyrazenie(czynnik2).contains(".")) { // kropka i liczba
                    System.out.println("pi i liczba");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = czynnik1 + "+" + czynnik2;
                            break;
                        case '-':
                            wynik = czynnik1 + "-" + czynnik2;
                            break;
                        case '*':
                            String a = policz(pi.getFirst(), czynnik2, "*");
                            if(czyJestWyrazeniem(a)){
                                wynik = "(" + a + ")*π";
                                break;
                            } else {
                                wynik = policz(pi.getFirst(), czynnik2, "*") + "π";
                                break;
                            }
                        case '/':
                            System.out.println(pi.getFirst());
                            String b = policz(pi.getFirst(), czynnik2, "/");
                            System.out.println(b);
                            if(czyJestWyrazeniem(b)){
                                wynik = "(" + b + ")*π";
                                break;
                            } else {
                                if(b.equals("1")){
                                    wynik = "π";
                                    break;
                                } else if (b.equals("-1")) {
                                    wynik = "-π";
                                    break;
                                } else {
                                    wynik = policz(pi.getFirst(), czynnik2, "/") + "π";
                                    break;
                                }
                            }
                    }
                }
            } else if (!jakieToWyrazenie(czynnik1).contains("\u221a") && !jakieToWyrazenie(czynnik1).contains("^") && !jakieToWyrazenie(czynnik1).contains("/") && !jakieToWyrazenie(czynnik1).contains(".") && !jakieToWyrazenie(czynnik1).contains("\u03C0")) {
                if (jakieToWyrazenie(czynnik2).contains("\u221a")) {                                                  // liczba i pierwiastek
                    System.out.println("liczba i pierwiastek");
                    Pierwiastek p = new Pierwiastek(czynnik2);
                    String x = p.wartoscPierwiastka();
                    switch (operator.charAt(0)) {
                        case '+':
                            if (jakieToWyrazenie(x).contains("\u221a")) {
                                wynik = "" + x + "+" + czynnik1 + "";
                                break;
                            } else {
                                wynik = policz(x, czynnik1, "+");
                                break;
                            }
                        case '-':
                            if (jakieToWyrazenie(x).contains("\u221a")) {
                                wynik = "" + czynnik1 + "-" + x + "";
                                break;
                            } else {
                                wynik = policz(czynnik1, x, "-");
                                break;
                            }
                        case '*':
                            if(jakieToWyrazenie(x).contains("\u221a")){
                                wynik = pomnozLiczbePrzezPierwiastek(czynnik1, x);
                                break;
                            }else {
                                wynik = policz(czynnik1,x,"*");
                                break;
                            }
                        case '/':
                            if (jakieToWyrazenie(x).contains("\u221a")) {
                                wynik = podzielLiczbePrzezPierwiastek(czynnik1, x);
                                break;
                            }else {
                                wynik = policz(czynnik1,x,"/");
                                break;
                            }
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("^")) { // liczba i potega
                    System.out.println("liczba i potega");
                    Potega p = new Potega(czynnik2);
                    String x = p.wartoscPotegi();
                    switch (operator.charAt(0)) {
                        case '+':
                            if(jakieToWyrazenie(x).contains("^")) {//todo dodac nawiasy do liczby przy potegach
                                wynik = czynnik1 + "+" + czynnik2 + "";
                                break;
                            }else {
                                wynik = policz(czynnik1, x, "+");
                                break;
                            }
                        case '-':
                            if(jakieToWyrazenie(x).contains("^")) {
                                wynik = czynnik1 + "-" + czynnik2 + "";
                                break;
                            }else {
                                wynik = policz(czynnik1, x, "-");
                                break;
                            }
                        case '*':
                            if(jakieToWyrazenie(x).contains("^")) {
                                wynik = czynnik1 + "*" + czynnik2 + "";
                                break;
                            }else {
                                wynik = policz(czynnik1, x, "*");
                                break;
                            }
                        case '/':
                            if(jakieToWyrazenie(x).contains("^")) {
                                wynik = czynnik1 + "/" + czynnik2 + "";
                                break;
                            }else {
                                wynik = policz(czynnik1, x, "/");
                                break;
                            }
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("/")) { // liczba i ulamek
                    System.out.println("liczba i ulamek");
                    Wartosc war1 = new Wartosc(czynnik1);
                    Wartosc war2 = new Wartosc(czynnik2);
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = war1.dodajUlamki(war2);
                            break;
                        case '-':
                            wynik = war1.odejmijUlamki(war2);
                            break;
                        case '*':
                            wynik = war1.pomnozUlamki(war2);
                            break;
                        case '/':
                            wynik = war1.podzielUlamki(war2);
                            break;
                    }
                } else if (jakieToWyrazenie(czynnik2).contains("\u03C0")) { // liczba i pi
                    System.out.println("liczba i pi");
                    LiczbaPi pi = new LiczbaPi(czynnik2);
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(czynnik2,czynnik1,"+");
                            break;
                        case '-':
                            wynik = czynnik1 + "-" + czynnik2;
                            break;
                        case '*':
                            wynik = policz(czynnik2, czynnik1, "*");
                            break;
                        case '/':
                            String tmp = policz(czynnik1, pi.getFirst(), "/");
                            if(tmp.contains("/")){
                                Wartosc w = new Wartosc(tmp);
                                wynik = "(" + w.getLicznik() + "/" + w.getMianownik() + "π)";
                                break;
                            } else {
                                wynik = tmp + "/π";
                                break;
                            }
                    }
                } else if (jakieToWyrazenie(czynnik2).contains(".")) { // liczba i liczba z kropka
                    System.out.println("liczba i kropka");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "+");
                            break;
                        case '-':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "-");
                            break;
                        case '*':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "*");
                            break;
                        case '/':
                            wynik = policz(czynnik1, zamienKropke(czynnik2), "/");
                            break;
                    }
                } else if (!jakieToWyrazenie(czynnik2).contains("\u221a") && !jakieToWyrazenie(czynnik2).contains("^") && !jakieToWyrazenie(czynnik2).contains("/") && !jakieToWyrazenie(czynnik2).contains(".")) { // liczba i liczba
                    System.out.println("liczba i liczba ");
                    czynnik1 = czynnik1.replace("(","");
                    czynnik1 = czynnik1.replace(")","");
                    czynnik2 = czynnik2.replace("(","");
                    czynnik2 = czynnik2.replace(")","");
                    switch (operator.charAt(0)) {
                        case '+':
                            wynik = czyJestCalkowita(String.valueOf(Double.parseDouble(czynnik1) + Double.parseDouble(czynnik2))) + "";
                            break;
                        case '-':
                            wynik = czyJestCalkowita(String.valueOf(Double.parseDouble(czynnik1) - Double.parseDouble(czynnik2))) + "";
                            break;
                        case '*':
                            wynik = czyJestCalkowita(String.valueOf(Double.parseDouble(czynnik1) * Double.parseDouble(czynnik2))) + "";
                            break;
                        case '/':
                            wynik = skrocUlamek(Double.parseDouble(czynnik1) + "/" + Double.parseDouble(czynnik2));
                            break;
                    }
                }
            }
        }
        if(wynik.contains("(1)\u221a")){
            wynik = wynik.replace("(1)\u221a","\u221a");
        }
        if(wynik.contains("()\u221a")){
            wynik = wynik.replace("()\u221a","\u221a");
        }
        if(wynik.contains("+0") || wynik.contains("-0")){
            wynik = wynik.replace("+0","");
            wynik = wynik.replace("-0","");
        }
        if (wynik.contains("--")) {
            wynik = wynik.replace("--","+");
        }
        if (wynik.contains("+-")) {
            wynik = wynik.replace("+-","-");
        }
        System.out.println("Wynik z policz: " + wynik);
        return wynik;
    }
}
