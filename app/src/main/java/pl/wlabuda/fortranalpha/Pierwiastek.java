package pl.wlabuda.fortranalpha;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Wacław on 09.07.14.
 */
public class Pierwiastek {
    public String first;
    public String inside;

    public Pierwiastek(String pierwiastek) {

        if(!pierwiastek.contains("(") && !pierwiastek.contains(")")){
            pierwiastek = "(" + pierwiastek.replace("\u221a", ")\u221a(") + ")";
        }

        if(pierwiastek.startsWith("()√")) {
            pierwiastek = pierwiastek.replace("()\u221a", "(1)\u221a");
        }

        if(pierwiastek.startsWith("√")) {
            pierwiastek = pierwiastek.replace("\u221a", "(1)\u221a");
        }

        if(!pierwiastek.contains(")√")) {
            System.out.println("aaaaaaa");
            pierwiastek = pierwiastek.replace("\u221a", ")\u221a");
            pierwiastek = pierwiastek.substring(0,pierwiastek.length()-1);
        }

        String[] tmp = pierwiastek.split("\u221a");
        String a, b;
        if (tmp.length > 2) {         //pierwiastek z pierwiastka
            a = pierwiastek.substring(0, pierwiastek.indexOf("\u221a") + 1);
            b = pierwiastek.substring(pierwiastek.indexOf("\u221a") + 1, pierwiastek.length());
            b = b.replace("\u221a", "|");
            pierwiastek = a + b;
        }
        String[] t = pierwiastek.split("\u221a");

        if(t[0].startsWith("(") && t[0].endsWith(")")) {
            String x = t[0].substring(1, t[0].length() - 1);       //jak first albo inside jest dzialaniem to zamienia nawiasy na kwadratowe
            System.out.println("pierwKonstrx " + t[0] + " & " + x);
            x = x.replace("(", "[");
            x = x.replace(")", "]");
            System.out.println("pierwKonstrPox " + x);
            t[0] = x;
        }

        if(t[1].contains("(") && t[1].contains(")")) {
            String y = t[1].substring(1, t[1].length() - 1);
            System.out.println("pierwKonstry " + t[1] + " & " + y);
            y = y.replace("(", "[");
            y = y.replace(")", "]");
            System.out.println("pierwKonstrPoy " + y);
            t[1] = y;
        }

        if (String.valueOf(pierwiastek.charAt(1)).equals(")") || String.valueOf(pierwiastek.charAt(0)).equals("\u221a")) { // ()p(x)
            first = "1";
        } else {
            t[0] = t[0].replace("(", "");
            t[0] = t[0].replace(")", "");
            t[0] = t[0].replace("[", "(");
            t[0] = t[0].replace("]", ")");
            first = t[0];
        }

        t[1] = t[1].replace("(", "");
        t[1] = t[1].replace(")", "");
        t[1] = t[1].replace("[", "(");
        t[1] = t[1].replace("]", ")");
        t[1] = t[1].replace("|", "\u221a");
        inside = t[1];
        System.out.println("aaaaaaa" + inside);
    }

    public void setFirst(String f) {
        first = f;
    }

    public String getFirst() {
        return this.first;
    }

    public String getInside() {
        return this.inside;
    }

    public String wartoscPierwiastka() {
        System.out.println("WP: " + this.getFirst() + " \u221a " + this.getInside());
        String wynik = "";
        if (!Wartosc.czyJestWyrazeniem(this.getInside())) {          //inside nie jest wyrazeniem (nie ma +,-,*,/)
            if (!this.getInside().contains("-")) {
                if (Wartosc.jakieToWyrazenie(this.getInside()).contains("\u221a")) {                                          //pierwiastek z pierwiastka
                    System.out.println("pierwiastek z pierwiastka ");
                    if (this.getFirst().equals("")) {
                        this.setFirst("1");
                    }
                    Pierwiastek k = new Pierwiastek(this.getInside());
                    String kw = k.wartoscPierwiastka();
                    if (Wartosc.jakieToWyrazenie(kw).contains("\u221a")) {
                        Pierwiastek l = new Pierwiastek(kw);
                        String jeden = Wartosc.policz(this.getFirst(), "()\u221a(" + l.getFirst() + ")", "*");
                        Potega p = new Potega("(" + l.getInside() + ")^(1/4)");
                        String dwa = Wartosc.policz(jeden, p.wartoscPotegi(), "*");
                        wynik = dwa;
                    } else {
                        Pierwiastek l = new Pierwiastek("(" + this.getFirst() + ")\u221a(" + kw + ")");
                        wynik = l.wartoscPierwiastka();
                    }
                }
                if (Wartosc.jakieToWyrazenie(this.getInside()).contains("/")) {                                          //pierwiastek z ulamka
                    System.out.println("pierwiastek z ulamka " + this.getInside());
                    Wartosc x = new Wartosc(this.getInside());
                    String policz = Wartosc.policz(x.getLicznik(), x.getMianownik(), "/");
                    if (Wartosc.jakieToWyrazenie(policz).contains("/")) {
                        Wartosc x1 = new Wartosc(policz);
                        Pierwiastek l = new Pierwiastek("()\u221a(" + x1.getLicznik() + ")");
                        Pierwiastek m = new Pierwiastek("()\u221a(" + x1.getMianownik() + ")");
                        String tmp = Wartosc.policz(l.wartoscPierwiastka(), m.wartoscPierwiastka(), "/");
                        wynik = Wartosc.policz(this.getFirst(), tmp, "*");
                    } else {
                        Pierwiastek y = new Pierwiastek(this.getFirst() + "()\u221a(" + policz + ")");
                        wynik = y.wartoscPierwiastka();
                    }
                }
                if (Wartosc.jakieToWyrazenie(this.getInside()).contains("^")) {                                          //pierwiastek z potegi //todo odtad w dol sprawdzic jeszcze raz wszystko
                    System.out.println("pierwiastek z potegi ");
                    Potega p = new Potega(this.getInside());
                    String x = p.wartoscPotegi();
                    if (Wartosc.jakieToWyrazenie(x).contains("^")) {
                        wynik = "(" + this.getInside() + ")\u221a(" + x + ")";
                    } else {
                        Pierwiastek pierw = new Pierwiastek("(" + this.getFirst() + ")\u221a(" + x + ")");
                        wynik = pierw.wartoscPierwiastka();
                    }
                }
                if (Wartosc.jakieToWyrazenie(this.getInside()).contains("\u03C0")) {                                          //pierwiastek z pi
                    System.out.println("pierwiastek z pi ");
                    LiczbaPi tmp = new LiczbaPi(this.getInside());
                    Pierwiastek pierw = new Pierwiastek("(" + this.getFirst() + ")\u221a(" + tmp.getFirst() + ")");
                    if(pierw.wartoscPierwiastka().equals("1")){
                        wynik = "(1)\u221a(π)";
                    } else if(pierw.wartoscPierwiastka().contains("\u221a")) {
                        wynik = pierw.wartoscPierwiastka() + "*\u221a(π)";
                    } else {
                        wynik = "(" + pierw.wartoscPierwiastka() + ")\u221a(π)";
                    }

                }
                if (Wartosc.jakieToWyrazenie(this.getInside()).contains(".")) {                                          //pierwiastek z kropki
                    Pierwiastek tmp = new Pierwiastek(this.getFirst() + "\u221a(" + Wartosc.zamienKropke(this.getInside()) + ")");
                    wynik = tmp.wartoscPierwiastka();
                }
                if (!Wartosc.jakieToWyrazenie(this.getInside()).contains("\u221a") && !Wartosc.jakieToWyrazenie(this.getInside()).contains("/") && !Wartosc.jakieToWyrazenie(this.getInside()).contains("^") && !Wartosc.jakieToWyrazenie(this.getInside()).contains(".") && !Wartosc.jakieToWyrazenie(this.getInside()).contains("\u03C0")) { //pierwiastek z liczby
                    System.out.println("pierwiastek z liczby " + this.getFirst());
                    Pierwiastek tmp = new Pierwiastek("(" + this.getFirst() + ")\u221a(" + this.getInside() + ")");
                    wynik = tmp.skrocPierwiastek();
                }
            } else {
                Toast.makeText(Global.mContext, "Nie ma pierwiastka z liczby ujemnej!", Toast.LENGTH_SHORT).show();
                wynik = "";
            }
        } else {//todo przetestowac nowe funkcje
            System.out.println("wyrazenie w pierwiastku");
            String tmp = Wartosc.obliczWyrazenie(this.getInside());
            if (Wartosc.czyJestWyrazeniem(tmp)){
                System.out.println("niepoliczalne ");
                wynik = "(" + this.getFirst() + ")\u221a(" + tmp + ")";
            }else{
                System.out.println("policzalne ");
                Pierwiastek p = new Pierwiastek("(" + this.getFirst() + ")\u221a(" + tmp + ")");
                wynik = p.wartoscPierwiastka();
            }
        }
        System.out.println("wynik z wartoscPierw: " + wynik);
        if(wynik.contains("()\u221a")){
            wynik = wynik.replace("()\u221a","\u221a");
        }
        if(wynik.contains("(0)√")){
            return "0";
        }
        return wynik;
    }

    public String pomnozPierwiastki(Pierwiastek b) {
        System.out.println("pomnoz pierwiastki");
        Pierwiastek czynnik1 = this;
        Pierwiastek czynnik2 = b;
        String wPx = czynnik1.wartoscPierwiastka();
        String wPy = czynnik2.wartoscPierwiastka();
        if(wPx.contains("\u221a") && wPy.contains("\u221a")) {
            if (!Wartosc.czyJestWyrazeniem(wPx) && !Wartosc.czyJestWyrazeniem(wPy)) {
                Pierwiastek p = new Pierwiastek(wPx);
                Pierwiastek d = new Pierwiastek(wPy);
                double y;
                double x = Double.parseDouble(p.getFirst()) * Double.parseDouble(d.getFirst());
                if (czynnik1.getInside().equals(d.getInside())) {
                    y = Double.parseDouble(czynnik1.getInside());
                    return (int) (x * y) + "";
                } else {
                    y = Double.parseDouble(p.getInside()) * Double.parseDouble(d.getInside());
                    Pierwiastek tmp = new Pierwiastek("(" + (int) x + ")\u221a(" + (int) y + ")");
                    return tmp.wartoscPierwiastka();
                }
            } else {
                return "(" + wPx + ")*(" + wPy + ")";
            }
        }else{
            return Wartosc.policz(wPx,wPy,"*");
        }
    }

    public String podzielPierwiastki(Pierwiastek b) {
        System.out.println("podziel pierwiastki");
        String x = this.pomnozPierwiastki(b);
        String y = b.pomnozPierwiastki(b);
        return Wartosc.policz(x, y, "/");
    }

    public String dodajPierwiastki(Pierwiastek b) {
        System.out.println("dodaj pierwiastki");
        Pierwiastek czynnik1 = this;
        Pierwiastek czynnik2 = b;
        String x = czynnik1.wartoscPierwiastka();
        String y = czynnik2.wartoscPierwiastka();
        if(x.contains("\u221a") && y.contains("\u221a")) {
            if (!Wartosc.czyJestWyrazeniem(x) && !Wartosc.czyJestWyrazeniem(y)) {
                Pierwiastek p = new Pierwiastek(czynnik1.wartoscPierwiastka());
                Pierwiastek d = new Pierwiastek(czynnik2.wartoscPierwiastka());
                if (p.getInside().equals(d.getInside())) {
                    double suma = Double.parseDouble(p.getFirst()) + Double.parseDouble(d.getFirst());
                    if (suma == 0) {
                        return "0";
                    } else {
                        return (int) suma + "\u221a" + "(" + Integer.parseInt(p.getInside()) + ")";
                    }
                } else {
                    return "(" + Integer.parseInt(p.getFirst()) + ")" + "\u221a" + "(" + Integer.parseInt(p.getInside()) + ")" + "+" + "(" + Integer.parseInt(d.getFirst()) + ")" + "\u221a" + "(" + Integer.parseInt(d.getInside()) + ")";
                }
            } else {
                return "(" + czynnik1.wartoscPierwiastka() + ")+(" + czynnik2.wartoscPierwiastka() + ")";
            }
        }else{
            return Wartosc.policz(x,y,"*");
        }
    }

    public String odejmijPierwiastki(Pierwiastek b) {
        Pierwiastek czynnik1 = this;
        Pierwiastek czynnik2 = b;
        String x = czynnik1.wartoscPierwiastka();
        String y = czynnik2.wartoscPierwiastka();
        String znak = "\u221a";
        if(x.contains("\u221a") && y.contains("\u221a")) {
            if (!Wartosc.czyJestWyrazeniem(x) && !Wartosc.czyJestWyrazeniem(y)) {
            double suma = Double.parseDouble(czynnik1.getFirst()) - Double.parseDouble(czynnik2.getFirst());
            if (czynnik1.getInside().equals(czynnik2.getInside())) {
                if (czynnik1.getFirst().equals(czynnik2.getFirst())) {
                    return "0";
                } else if (suma == 1) {
                    return znak + "(" + Integer.parseInt(czynnik1.getInside()) + ")";
                } else {
                    return (int) suma + znak + "(" + Integer.parseInt(czynnik1.getInside()) + ")";
                }
            } else {
                return "(" + Integer.parseInt(czynnik1.getFirst()) + ")" + znak + "(" + Integer.parseInt(czynnik1.getInside()) + ")" + "-" + "(" + Integer.parseInt(czynnik2.getFirst()) + ")" + znak + "(" + Integer.parseInt(czynnik2.getInside()) + ")";
            }
            } else {
                return czynnik1.wartoscPierwiastka() + "-" + czynnik2.wartoscPierwiastka();
            }
        }else{
            return Wartosc.policz(x,y,"*");
        }
    }

    public String skrocPierwiastek() {
        System.out.println("skrocPierwiastek ");
        Pierwiastek czynnik1 = this;
        double dzielnik = 1;
        boolean koniec = true;
        double policz1;
        String wynik = "";
        while (koniec) {
            policz1 = Math.sqrt(Double.parseDouble(czynnik1.inside) / dzielnik);
            if (policz1 - (int) policz1 == 0) {
                if (dzielnik == 1) {
                    wynik = (int) (Integer.parseInt(czynnik1.getFirst()) * policz1) + "";
                    koniec = false;
                } else {
                    wynik = "(" + (int) (Integer.parseInt(czynnik1.getFirst()) * policz1) + ")\u221a(" + (int) dzielnik + ")";
                    koniec = false;
                }
            } else {
                dzielnik++;
            }
            /*policz1 = Math.pow(Double.parseDouble(czynnik1.inside) / dzielnik, 0.5);
            policz2 = Math.sqrt(dzielnik);
            if (policz1 - (int) policz1 == 0) {
                if(dzielnik != 1)
                    wynik = (int) (Double.parseDouble(czynnik1.first) * policz1) + "\u221a(" + (int) dzielnik + ")";
                else
                    wynik = (int) (Double.parseDouble(czynnik1.first) * policz1) + "";
                koniec = false;
            } else if (policz2 - (int) policz2 == 0 && dzielnik != 1) {
                if(dzielnik != 1)
                    wynik = (int) (Double.parseDouble(czynnik1.first) * policz2) + " \u221a(" + (int) policz1 + ")";
                else
                    wynik = (int) (Double.parseDouble(czynnik1.first) * policz2) + "";
                koniec = false;
            } else if(policz1<=Double.parseDouble(czynnik1.inside)){
                dzielnik++;
            }*/
        }
        return wynik;
    }
}
