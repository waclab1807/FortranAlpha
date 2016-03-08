package pl.wlabuda.fortranalpha;

/**
 * Created by Wacław on 11.07.14.
 */
public class Potega {
    public String down;
    public String up;

    public Potega(String potega) {
        String[] tmp = potega.split("\\^");
        String a, b;
        if (tmp.length > 2) {         //potega do potegi
            a = potega.substring(0, potega.indexOf("^") + 1);
            b = potega.substring(potega.indexOf("^") + 1, potega.length());
            b = b.replace("^", "|");
            potega = a + b;
        }
        String[] t = potega.split("\\^");
        if(t[0].contains("(") && t[0].contains(")")) {
            String x = t[0].substring(1, t[0].length() - 1);       //jak down albo up jest dzialaniem to zamienia nawiasy na kwadratowe
            System.out.println("poKonstrx " + t[0] + " & " + x);
            x = x.replace("(", "[");
            x = x.replace(")", "]");
            System.out.println("potKonstrPox " + x);
            t[0] = x;
        }
        if(t[1].contains("(") && t[1].contains(")")) {
            String y = t[1].substring(1, t[1].length() - 1);
            System.out.println("potKonstry " + t[1] + " & " + y);
            y = y.replace("(", "[");
            y = y.replace(")", "]");
            System.out.println("potKonstrPoy " + y);
            t[1] = y;
        }

        t[0] = t[0].replace("(", "");
        t[0] = t[0].replace(")", "");
        t[0] = t[0].replace("[", "(");
        t[0] = t[0].replace("]", ")");
        down = t[0];
        t[1] = t[1].replace("(", "");
        t[1] = t[1].replace(")", "");
        t[1] = t[1].replace("[", "(");
        t[1] = t[1].replace("]", ")");
        t[1] = t[1].replace("|", "^");
        up = t[1];
    }

    public String getDown() {
        return this.down;
    }

    public String getUp() {
        return this.up;
    }

    public static String czyJestCalkowita(String a) {
        if (Double.parseDouble(a) - (int) Double.parseDouble(a) == 0) {
            return (int) Double.parseDouble(a) + "";
        } else {
            return Double.parseDouble(a) + "";
        }
    }

    public String wartoscPotegi() {
        System.out.println("WP: " + this.getDown() + " ^ " + this.getUp());
        String wynik = "";
        if (this.getDown().equals("1") || this.getDown().equals("-1") || this.getDown().equals("0") || this.getUp().equals("1") || this.getUp().equals("0")) {
            if (this.getDown().equals("1")) {                                     //1^2
                wynik = 1 + "";
            } else if (this.getDown().equals("-1")) {                              //-1^2
                wynik = "-" + 1;
            } else if (this.getDown().equals("0")) {                               //0^2
                wynik = 0 + "";
            } else if (this.getUp().equals("1")) {                                 //2^1
                wynik = this.getDown();
            } else if (this.getUp().equals("0") && !this.getDown().equals("0")) {  //2^0
                wynik = 1 + "";
            } else if (this.getUp().equals("0") && this.getDown().equals("0")) {   //0^0
                wynik = 0 + "";
            }
        } else if(!Wartosc.czyJestWyrazeniem(this.getDown()) && !Wartosc.czyJestWyrazeniem(this.getUp())){
            if (Wartosc.jakieToWyrazenie(this.getDown()).contains("\u221a")) {                                          //pierwiastek do potegi
                System.out.println("pierwiastek do potegi");
                if (!this.getUp().contains("-")) {
                    if (Wartosc.jakieToWyrazenie(this.getUp()).contains("\u221a")) {                                        //pierwiastek do potegi pierwiastek
                        System.out.println("pierwiastek do potegi pierwiastek");
                        Pierwiastek p = new Pierwiastek(this.getDown());
                        Pierwiastek d = new Pierwiastek(this.getUp());
                        String x = p.wartoscPierwiastka();
                        String y = d.wartoscPierwiastka();
                        if(!Wartosc.jakieToWyrazenie(x).contains("\u221a") || !Wartosc.jakieToWyrazenie(y).contains("\u221a")){
                            Potega tmp = new Potega("(" + x + ")^(" + y + ")");
                            wynik = tmp.wartoscPotegi();
                        }else{
                            Pierwiastek p1 = new Pierwiastek(x);
                            Potega P1 = new Potega("(" + p1.getFirst() + ")^(" + y +")");
                            String jeden = P1.wartoscPotegi();
                            String tmp = Wartosc.policz(y,"2","/");
                            Potega D1 = new Potega("(" + p1.getInside() + ")^(" + tmp +")");
                            String dwa = D1.wartoscPotegi();
                            String tmp2 = Wartosc.policz(jeden,dwa,"*");
                            wynik = tmp2;
                        }
                    }else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("^")) {                                        //pierwiastek do potegi potega
                        System.out.println("pierwiastek do potegi potega");
                        Pierwiastek p = new Pierwiastek(this.getDown());
                        if (p.getFirst().equals(p.getInside())) {
                            String pot = Wartosc.policz(this.getUp(), Wartosc.policz(this.getUp(), "2", "/"), "+");
                            Potega tmp = new Potega(p.getFirst() + "^" + pot);
                            wynik = tmp.wartoscPotegi();
                        } else {
                            Pierwiastek x = new Pierwiastek(this.getDown());
                            Potega x1 = new Potega(x.getFirst() + "^" + this.getUp());
                            String cz1 = x1.wartoscPotegi();
                            Potega x2 = new Potega(x.getInside() + "^" + Wartosc.policz(this.getUp(), "2", "/"));
                            String cz2 = x2.wartoscPotegi();
                            Potega cz11 = new Potega(cz1);
                            Potega cz22 = new Potega(cz2);
                            wynik = Wartosc.policz(cz11.getDown(), cz22.getDown(), "*");
                        }
                    }else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("/")) {                                             //pierwiastek do potegi ulamek
                        System.out.println("pierwiastek do potegi ulamek");
                        Pierwiastek p = new Pierwiastek(this.getDown());
                        if (!p.getFirst().equals(p.getInside())) {
                            Potega pr = new Potega(p.getFirst() + "^" + this.getUp());
                            Potega qr = new Potega(p.getInside() + "^" + Wartosc.policz("1/2", this.getUp(), "*"));
                            if (pr.wartoscPotegi().equals("1")) {
                                wynik = qr.wartoscPotegi();
                            } else {
                                wynik = pr.pomnozPotegi(qr);
                            }
                        } else {
                            Potega x = new Potega(p.getInside() + "^(" + Wartosc.policz(this.getUp(), Wartosc.policz("1/2", this.getUp(), "*"), "+") + ")");
                            wynik = x.wartoscPotegi();
                        }
                    } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("\u03C0")) {                                             //pierwiastek do potegi pi
                        System.out.println("pierwiastek do potegi pi");
                        LiczbaPi pi = new LiczbaPi(this.getUp());
                        Potega p = new Potega(this.getDown() + "^" + pi.getFirst());
                        wynik = p.wartoscPotegi() + "^" + this.getUp();
                    } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains(".")) {                                             //pierwiastek do potegi kropka
                        System.out.println("pierwiastek do potegi kropka");
                        Potega tmp = new Potega(this.getDown() + "^" + Wartosc.zamienKropke(this.getUp()));
                        wynik = tmp.wartoscPotegi();
                    } else {                                                                             //pierwiastek do potegi liczba
                        Pierwiastek p = new Pierwiastek(this.getDown());
                        if (p.getFirst().equals("")) {
                            p.setFirst("1");
                        }
                        if (p.wartoscPierwiastka().contains("\u221a")) {
                            String tmp = (int) Math.round(Math.pow(Double.parseDouble(p.getInside()), Double.parseDouble(this.getUp()))) + "";
                            Pierwiastek r = new Pierwiastek("(" + (int) Math.round(Math.pow(Double.parseDouble(p.getFirst()), Double.parseDouble(this.getUp()))) + ")\u221a(" + tmp + ")");
                            wynik = r.skrocPierwiastek();
                        } else {
                            wynik = (int) Math.pow(Double.parseDouble(p.wartoscPierwiastka()), Double.parseDouble(this.getUp())) + "";
                        }
                    }
                } else {                                                                                      //pierwiastek do ujemnej
                    Potega f = new Potega("(" + this.getDown() + ")^" + this.getUp().replace("-", ""));
                    wynik = "(1/" + f.wartoscPotegi() + ")";
                }
            } else if (Wartosc.jakieToWyrazenie(this.getDown()).contains("/")) {                                               //ulamek do potegi
                System.out.println("ulamek do potegi");
                if (!this.getUp().contains("-")) {
                    String x = Wartosc.skrocUlamek(this.getDown());
                    if (Wartosc.jakieToWyrazenie(x).contains("/")) {
                        if (this.getUp().contains("\u221a")) {                                              //ulamek do potegi pierwiastek
                            Pierwiastek p = new Pierwiastek(this.getUp());
                            if (p.getFirst().equals("")) {
                                p.setFirst("1");
                            }
                            Potega r = new Potega("(" + this.getDown() + ")^(" + p.getFirst());
                            wynik = "(" + r.wartoscPotegi() + ")^()\u221a(" + p.getInside() + ")";
                        } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("^")) {                                             //ulamek do potegi potega
                            Potega p = new Potega(this.getUp());
                            String tmp = p.wartoscPotegi();
                            if (tmp.contains("^")) {
                                wynik = this.getDown() + "^" + tmp;
                            } else {
                                Potega g = new Potega(this.getDown() + "^" + tmp);
                                wynik = g.wartoscPotegi();
                            }
                        } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("/")) {                                             //ulamek do potegi ulamek
                            Wartosc w = new Wartosc(this.getDown());
                            if (x.contains("/")) {
                                Potega p = new Potega(w.getLicznik() + "^" + this.getUp());
                                Potega d = new Potega(w.getMianownik() + "^" + this.getUp());
                                wynik = p.podzielPotegi(d);
                            } else {                                                                        //ulamek do potegi liczba
                                String y = Wartosc.skrocUlamek(this.getUp());
                                Potega tmp = new Potega(this.getDown() + "^" + y);
                                wynik = tmp.wartoscPotegi();
                            }
                        } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("\u03C0")) {                                             //ulamek do potegi pi
                            Wartosc w = new Wartosc(this.getDown());
                            Potega p = new Potega(w.getLicznik() + "^" + this.getUp());
                            Potega d = new Potega(w.getMianownik() + "^" + this.getUp());
                            wynik = Wartosc.policz(p.wartoscPotegi(),d.wartoscPotegi(),"/");
                        } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains(".")) {                                             //ulamek do potegi kropka
                            String up = Wartosc.skrocUlamek(Wartosc.zamienKropke(this.getUp()));
                            Potega p = new Potega(this.getDown() + "^" + up);
                            wynik = p.wartoscPotegi();
                        } else {                                                                           //ulamek do potegi liczba
                            Wartosc w = new Wartosc(this.getDown());
                            Potega p = new Potega(w.getLicznik() + "^" + this.getUp());
                            Potega d = new Potega(w.getMianownik() + "^" + this.getUp());
                            wynik = Wartosc.skrocUlamek(Wartosc.policz(p.wartoscPotegi(), d.wartoscPotegi(), "/"));
                        }
                    } else {                                                                                //liczba do potegi ulamek
                        Potega tmp = new Potega("(" + x + ")^(" + this.getUp() + ")");
                        wynik = tmp.wartoscPotegi();
                    }
                } else {
                    Wartosc t = new Wartosc(this.getDown());
                    Potega f = new Potega("(" + t.getMianownik() + "/" + t.getLicznik() + ")^" + this.getUp().replace("-", ""));
                    wynik = f.wartoscPotegi();
                }
            } else if (Wartosc.jakieToWyrazenie(this.getDown()).contains("\u03C0")) {                                          //pi do potegi
                System.out.println("pi do potegi");
                if (!this.getUp().contains("-")) {
                    LiczbaPi pi = new LiczbaPi(this.getDown());

                    if (Wartosc.jakieToWyrazenie(this.getUp()).contains("\u221a")) {                                        //pi do potegi pierwiastek
                        System.out.println("pi do potegi pierwiastek");
                        Pierwiastek d = new Pierwiastek(this.getUp());
                        wynik = pi.wartoscPi() + "^" + d.wartoscPierwiastka();                                                                          //TODO ZMIENIC FIRST * FIRST

                    }else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("^")) {                                        //pi do potegi potega  //TODO DO TESTOW

                        System.out.println("pi do potegi potega");
                        Potega p = new Potega(this.getUp());
                        Potega tmp = new Potega ("(" + pi.getFirst() + ")^(" + p.wartoscPotegi() + ")");
                        //wynik = pi.wartoscPi() + "^" + p.wartoscPotegi();
                        wynik = "((" + tmp.wartoscPotegi() + ")π^" + p.wartoscPotegi()+ ")";                                              //TODO ZMIENIC FIRST * FIRST

                    }else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("/")) {                                             //pi do potegi ulamek //TODO DO TESTOW
                        System.out.println("pi do potegi ulamek");
                        Potega tmp = new Potega("(" + pi.getFirst() + ")^(" + this.getUp() + ")");
                        wynik = "(("+tmp.wartoscPotegi() + ")π^" + Wartosc.skrocUlamek(this.getUp())+ ")";
                    } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("\u03C0")) {                                             //pi do potegi pi
                        System.out.println("pi do potegi pi");
                        LiczbaPi d = new LiczbaPi(this.getUp());
                        wynik = pi.wartoscPi() + "^" + d.wartoscPi();                                                                                      //TODO ZMIENIC FIRST * FIRST
                    } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains(".")) {                                             //pi do potegi kropka
                        System.out.println("pi do potegi kropka");
                        Potega tmp = new Potega(pi.wartoscPi() + "^" + Wartosc.zamienKropke(this.getUp()));
                        wynik = tmp.wartoscPotegi();
                    } else {                                                                             //pi do potegi liczba
                        if (pi.getFirst().equals("1")) {
                            wynik = "π^" + this.getUp();
                        } else if(pi.getFirst().equals("-1")) {
                            wynik = "-π^" + this.getUp();
                        } else {
                            wynik =Wartosc.policz(pi.getFirst(), pi.getFirst(), "*") + "*(π^" + this.getUp() + ")";
                        }
                    }
                } else {                                                                                      //pi do ujemnej
                    Potega f = new Potega("(" + this.getDown() + ")^" + this.getUp().replace("-", ""));
                    wynik = "(1/" + f.wartoscPotegi() + ")";
                }
            } else if (Wartosc.jakieToWyrazenie(this.getDown()).contains(".")) {                                                      //kropka do potegi
                System.out.println("kropka do potegi");
                Potega tmp = new Potega(Wartosc.zamienKropke(this.getDown()) + "^" + this.getUp());
                wynik = tmp.wartoscPotegi();
            } else if (!Wartosc.jakieToWyrazenie(this.getDown()).contains("/") && !Wartosc.jakieToWyrazenie(this.getDown()).contains("\u221a") && !Wartosc.jakieToWyrazenie(this.getDown()).contains("^") && !Wartosc.jakieToWyrazenie(this.getDown()).contains(".")) {//&& !this.getDown().contains("+") && !this.getDown().contains("-")) {        //liczba do potegi
                if (Wartosc.jakieToWyrazenie(this.getUp()).contains("\u221a")) {                                                  //liczba do potegi pierwiastek
                    System.out.println("liczba do potegi pierwiastek");
                    Pierwiastek p = new Pierwiastek(this.getUp());
                    String x = p.wartoscPierwiastka();
                    if(Wartosc.jakieToWyrazenie(x).contains("\u221a")) {
                        Pierwiastek pp = new Pierwiastek(x);
                        if (pp.getFirst().equals("")) {
                            pp.setFirst("1");
                        }
                        if (pp.getFirst().contains("-") && !this.getDown().contains("-")) {
                            wynik = "(-1/((" + czyJestCalkowita(String.valueOf(Math.round(Math.pow(Double.parseDouble(this.getDown()), Double.parseDouble(pp.getFirst().replace("-", "")))))) + ")^(()\u221a(" + pp.getInside() + "))))";
                        } else if (pp.getFirst().contains("-") && this.getDown().contains("-")) {
                            wynik = "(1/((" + czyJestCalkowita(String.valueOf(Math.round(Math.pow(Double.parseDouble(this.getDown()), Double.parseDouble(pp.getFirst().replace("-", "")))))) + ")^(()\u221a(" + pp.getInside() + "))))";
                        } else {
                            wynik = "(" + czyJestCalkowita(String.valueOf(Math.round(Math.pow(Double.parseDouble(this.getDown()), Double.parseDouble(pp.getFirst()))))) + ")^(()\u221a(" + pp.getInside() + "))";
                        }
                    }else{
                        Potega g = new Potega("(" + this.getDown() + ")^(" + x + ")");
                        wynik = g.wartoscPotegi();
                    }
                } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("/")) {                                             //liczba do potegi ulamek
                    System.out.println("liczba do potegi ulamek");
                    Wartosc w = new Wartosc(this.getUp());
                    String x = Wartosc.skrocUlamek(this.getUp());
                    if (!x.contains("/")) {                                                      //2^(3/3)=2^1->liczba ^ liczba
                        wynik = "" + Wartosc.czyJestCalkowita(Math.round(Math.pow(Double.parseDouble(this.getDown()), Double.parseDouble(x))) + "");
                    } else if (Wartosc.skrocUlamek(this.getUp()).equals("(1/-2)") || Wartosc.skrocUlamek(this.getUp()).equals("(-1/2)") && this.getDown().contains("-")) {      //-3^(-1/2)=(-1)sqrt(3)/3
                        wynik = "((-1)\u221a(" + this.getDown().replace("-", "") + "))/(" + this.getDown().replace("-", "") + ")";
                    } else if (Wartosc.skrocUlamek(this.getUp()).equals("(1/-2)")) {                                        //3^(-1/2)=sqrt(3)/3
                        wynik = "()\u221a(" + this.getDown() + ")/(" + this.getDown() + ")";
                    } else if (Wartosc.skrocUlamek(this.getUp()).equals("(1/2)") && this.getDown().contains("-")) {         //-3^(1/2)=(-1)sqrt(3)
                        wynik = "(-1)\u221a(" + this.getDown().replace("-", "") + ")";
                    } else if (Wartosc.skrocUlamek(this.getUp()).equals("(1/2)")) {                                         //3^(1/2)=sqrt(3)
                        wynik = "()\u221a(" + this.getDown() + ")";
                    } else if (this.getUp().contains("-")) {                              //2^(-3/4)=1/(2^(3/4))
                        wynik = "(1/(" + this.getDown() + "^" + Wartosc.policz(w.getLicznik(), w.getMianownik(), "/").replace("-", "") + "))";
                    } else {                                                        //3^(3/4)
                        String y = Wartosc.policz(w.getLicznik(), w.getMianownik(), "/");
                        wynik = "(" + this.getDown() + ")^" + y + "";
                    }
                } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("^")) {                                             //liczba do potegi potega
                    System.out.println("liczba do potegi potega " + this.getUp());
                    Potega p = new Potega(this.getUp());
                    Potega q = new Potega("(" + this.getDown() + ")^(" + p.wartoscPotegi() + ")");
                    wynik = q.wartoscPotegi();
                } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains("\u03C0")) {                                               //liczba do potegi pi
                    System.out.println("liczba do potegi pi ");
                    LiczbaPi pi = new LiczbaPi(this.getUp());
                    Potega p = new Potega("(" + this.getDown() + ")^" + pi.getFirst());
                    wynik = p.wartoscPotegi() + "^" + this.getUp();
                } else if (Wartosc.jakieToWyrazenie(this.getUp()).contains(".")) {                                               //liczba do potegi kropka
                    System.out.println("liczba do potegi kropka ");
                    Potega p = new Potega("(" + this.getDown() + ")^" + Wartosc.zamienKropke(this.getUp()));
                    wynik = p.wartoscPotegi();
                } else if (!Wartosc.jakieToWyrazenie(this.getUp()).contains("/") && !Wartosc.jakieToWyrazenie(this.getUp()).contains("\u221a") && !Wartosc.jakieToWyrazenie(this.getUp()).contains("^") && !Wartosc.jakieToWyrazenie(this.getUp()).contains(".") && !Wartosc.jakieToWyrazenie(this.getUp()).contains("\u03C0")) {             //liczba do potegi liczba
                    System.out.println("liczba do potegi liczba");
                    if (!this.getDown().contains("-") && this.getUp().contains("-")) {  //2^(-2)
                        String up = this.getUp().replace("-", "");
                        Potega tmp = new Potega(this.getDown() + "^" + up);
                        wynik = "(" + 1 + "/(" + tmp.wartoscPotegi() + "))";
                    } else if (this.getDown().contains("-") && this.getUp().contains("-")) {  //-2^(-2)
                        String up = this.getUp().replace("-", "");
                        String down = this.getDown().replace("-", "");
                        Potega tmp = new Potega(down + "^" + up);
                        wynik = "(-" + 1 + "/(" + tmp.wartoscPotegi() + "))";
                    } else if (this.getDown().contains("-") && !this.getUp().contains("-")) {  //-2^(2)
                        wynik = "-" + czyJestCalkowita(String.valueOf(Math.round(Math.pow(Double.parseDouble(this.getDown()), Double.parseDouble(this.getUp())))));
                    } else {
                        wynik = czyJestCalkowita(String.valueOf((int) Math.round(Math.pow(Double.parseDouble(this.getDown()), Double.parseDouble(this.getUp())))));
                    }
                }
            }
        }else{//todo sprawdzic wprowadzone zmiany
            String a = Wartosc.obliczWyrazenie(this.getDown());
            String b = Wartosc.obliczWyrazenie(this.getUp());
            if (Wartosc.czyJestWyrazeniem(a) && !Wartosc.czyJestWyrazeniem(b)){
                //todo wzory skroconego mnozenia, mnozenie wyrazen
                wynik = "(" + a + ")^("+ b + ")";
            }else if(!Wartosc.czyJestWyrazeniem(a) && Wartosc.czyJestWyrazeniem(b)){
                wynik = "(" + a + ")^("+ b + ")";
            }else if(!Wartosc.czyJestWyrazeniem(a) && !Wartosc.czyJestWyrazeniem(b)){
                Potega p = new Potega("("+a+")^("+b+")");
                wynik = p.wartoscPotegi();
            }
        }
        /*} else if (czyJestWyrazeniem(this.getDown()) && !czyJestWyrazeniem(this.getUp())) { //down jest wyrazeniem a up nie
            String[] t = this.getDown().split("\\" + Wartosc.operatorOperacji(this.getDown()));
            if (czyJestWyrazeniem(Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getDown())))) {      //jesli nie da sie policzyc down to zostaje np. (a+b)^up
                wynik = "(" + Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getDown())) + ")^(" + this.getUp() + ")";
            } else {
                Potega p = new Potega("(" + Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getDown())) + ")^(" + this.getUp() + ")"); //jak sie da policzyc down po znowu sprawdza wartosc potegi
                wynik = p.wartoscPotegi();
            }
        } else if (!czyJestWyrazeniem(this.getDown()) && czyJestWyrazeniem(this.getUp())) {  //down nie jest wyrazeniem a up jest
            System.out.println("down nie up tak ");
            String[] t = this.getUp().split("\\" + Wartosc.operatorOperacji(this.getUp()));
            if (czyJestWyrazeniem(Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getUp())))) {    //jesli nie da sie policzyc up to zwraca np. down^(a+b)
                wynik = "(" + this.getDown() + ")^(" + Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getUp())) + ")";
            } else {
                Potega p = new Potega("(" + this.getDown() + ")^(" + Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getUp())) + ")");   //jak sie da policzyc do znowu sprawdza wartosc potegi
                wynik = p.wartoscPotegi();
            }
        } else if (czyJestWyrazeniem(this.getDown()) && czyJestWyrazeniem(this.getUp())) {  //down jest wyrazeniem i up jest wyrazeniem
            String[] g = this.getDown().split("\\" + Wartosc.operatorOperacji(this.getDown()));
            String[] t = this.getUp().split("\\" + Wartosc.operatorOperacji(this.getUp()));
            if (czyJestWyrazeniem(Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getDown()))) && czyJestWyrazeniem(Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getUp())))) {    //jesli nie da sie policzyc down ani up
                wynik = "(" + Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getDown())) + ")^(" + Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getUp())) + ")";
            } else if (czyJestWyrazeniem(Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getDown()))) && !czyJestWyrazeniem(Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getUp())))) {    //jesli nie da sie policzyc down ale da sie up
                wynik = "(" + this.getDown() + ")^(" + Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getUp())) + ")";
            } else if (!czyJestWyrazeniem(Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getDown()))) && czyJestWyrazeniem(Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getUp())))) {    //jesli da sie policzyc down ale nie da sie up
                wynik = "(" + Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getDown())) + ")^(" + this.getUp() + ")";
            } else if (!czyJestWyrazeniem(Wartosc.policz(g[0], g[1], Wartosc.operatorOperacji(this.getDown()))) && !czyJestWyrazeniem(Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getUp())))) {    //jesli da sie policzyc down i da sie policzyc up
                Potega p = new Potega("(" + Wartosc.policz(g[0], g[1], Wartosc.operatorOperacji(this.getDown())) + ")^(" + Wartosc.policz(t[0], t[1], Wartosc.operatorOperacji(this.getUp())) + ")");
                wynik = p.wartoscPotegi();
            }
        }*/
        System.out.println("wynik z wartoscPotegi: " + wynik);
        return wynik;
    }

    public Boolean czyJestWyrazeniem(String a) {
        String[] d = a.split("\\+");
        String[] o = a.split("-");
        String[] m = a.split("\\*");
        String[] dz = a.split("/");
        if (d.length > 1 || o.length > 1 || m.length > 1 || dz.length > 2) {
            System.out.println("jestem wyrazeniem");
            return true;
        } else {
            return false;
        }
    }

    public String dodajPotegi(Potega potega) {
        String x = this.wartoscPotegi();
        String y = potega.wartoscPotegi();
        if (x.contains("^") && y.contains("^") && x.equals(y)) {
            return "2*(" + x + ")";
        } else if (x.contains("^") && y.contains("^")) {
            return  "(" + y + ")+(" + x + ")";
        } else {
            return Wartosc.policz(x, y, "+");
        }
    }

    public String odejmijPotegi(Potega potega) {
        String x = this.wartoscPotegi();
        String y = potega.wartoscPotegi();
        if (x.contains("^") && y.contains("^") && x.equals(y)) {
            return "0";
        } else if (x.contains("^") && y.contains("^")) {
            return  "(" + x + ")-(" + y + ")";
        } else {
            return Wartosc.policz(x, y, "-");
        }
    }

    public String pomnozPotegi(Potega potega) {
        String x = this.wartoscPotegi();
        String y = potega.wartoscPotegi();
        if(x.contains("^") && y.contains("^")) {
            if (potega.getDown().equals(this.getDown())) {
                Potega p = new Potega("(" + potega.getDown() + ")^(" + Wartosc.policz(potega.getUp(), this.getUp(), "+") + ")");
                return p.wartoscPotegi();
            } else if (potega.getUp().equals(this.getUp())) {
                Potega p = new Potega("(" + Wartosc.policz(potega.getDown(), this.getDown(), "*") + ")^(" + potega.getUp() + ")");
                return p.wartoscPotegi();
            } else {
                return "(" + x + ")*(" + y + ")";
            }
        }else{
            return Wartosc.policz(x,y,"*");
        }
    }

    public String podzielPotegi(Potega potega) {
        String x = this.wartoscPotegi();
        String y = potega.wartoscPotegi();
        if(x.contains("^") && y.contains("^")) {
            if (potega.getDown() == this.getDown()) {
                Potega p = new Potega("(" + potega.getDown() + ")^(" + Wartosc.policz(potega.getUp(), this.getUp(), "-") + ")");
                return p.wartoscPotegi();
            } else if (potega.getUp() == this.getUp()) {
                Potega p = new Potega("(" + Wartosc.policz(potega.getDown(), this.getDown(), "/") + ")^(" + potega.getUp() + ")");
                return p.wartoscPotegi();
            } else {
                return "(" + x + ")/(" + y + ")";
            }
        }else{
            return Wartosc.policz(x,y,"/");
        }
    }
}
