package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by waclab1807 on 31.03.15.
 */

public class Kwadrat extends Activity implements OnFocusChangeListener{

//    wszystkie obiekty na jakich będziemy operować w tej aplikacji, buttony, pola tekstowe itd
    private Button licz;
    private Button clear;
    private Button sqrtbtn;
    private Button powbtn;
    private Button btnReview;
    private Button btnData;
    private Button btnSolution;
    private EditText pp_val;
    private EditText a_val;
    private EditText D_val;
    private EditText obwp_val;
    private EditText lastFocused;
    private String tekst;
    private WebView mWebView;
    private WebView mWebViewPp;
    private WebView mWebViewA;
    private WebView mWebViewD;
    private WebView mWebViewObw;
    private ImageView figura;
    private ScrollView scrollView;
    private LinearLayout buttons;
    private boolean doubleBackToExitPressedOnce = false;




//git ty chuju zacznij działać





//    wartości jakie będziemy liczyć
    String a;
    String pp;
    String D;
    String obwp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        podpięcie layoutu do aplikacji
        setContentView(R.layout.kwadrat);

//        zapisanie 'kontekstu' do Global, żeby można było wyświetlać toasty
        Global.mContext = this.getBaseContext();

//      podpiecie stworzonych na początku obiektów do elementów layoutu
        pp_val = (EditText) findViewById(R.id.pp);
        a_val = (EditText) findViewById(R.id.a);
        D_val = (EditText) findViewById(R.id.d);
        obwp_val = (EditText) findViewById(R.id.obw);
        licz = (Button) findViewById(R.id.magic);
        clear = (Button) findViewById(R.id.clear);
        sqrtbtn = (Button) findViewById(R.id.sqrtbtn);
        powbtn = (Button) findViewById(R.id.powbtn);
        figura = (ImageView) findViewById(R.id.imageView);
        btnReview = (Button)findViewById(R.id.btnReview);
        btnData = (Button)findViewById(R.id.btnData);
        btnSolution = (Button)findViewById(R.id.btnSolution);
        scrollView = (ScrollView)findViewById(R.id.dwa);
        buttons = (LinearLayout) findViewById(R.id.buttons);

//      wykrycie czy apka ma się pokazać w trybie portrait czy landscape
        if (btnData.getVisibility() == View.VISIBLE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

//      przypięcie obiektów webview do layoutu, czyli elementów, które pojawiają się
//      na polach tekstowych po kliknięciu policz. Są to pewnego rodzaju strony
//      internetowe, które dzięki specjalnej bibliotece zamieniają String ze specjalnymi
//      znacznikami na ładnie sformatowane równania, pierwiastki, ułamki itp.
        mWebView = (WebView) findViewById(R.id.webSolution);
        WebSettings webSettings = mWebView.getSettings();
        mWebView.setBackgroundColor(0xff0);
        webSettings.setJavaScriptEnabled(true);

        mWebViewPp = (WebView) findViewById(R.id.webPp);
        WebSettings webSettings1 = mWebViewPp.getSettings();
        mWebViewPp.setBackgroundColor(0xff0);
        webSettings1.setJavaScriptEnabled(true);

        mWebViewA = (WebView) findViewById(R.id.weba);
        WebSettings webSettings2 = mWebViewA.getSettings();
        mWebViewA.setBackgroundColor(0xff0);
        webSettings2.setJavaScriptEnabled(true);

        mWebViewD = (WebView) findViewById(R.id.webd);
        WebSettings webSettings3 = mWebViewD.getSettings();
        mWebViewD.setBackgroundColor(0xff0);
        webSettings3.setJavaScriptEnabled(true);

        mWebViewObw = (WebView) findViewById(R.id.webObwp);
        WebSettings webSettings4 = mWebViewObw.getSettings();
        mWebViewObw.setBackgroundColor(0xff0);
        webSettings4.setJavaScriptEnabled(true);

//        na 99% jest to  ustawienie listenerów focusa dla pól tekstowych, czyli po prostu w tych polach tekstowych może być złapany focus i wprowadzone dane
        a_val.setOnFocusChangeListener(this);
        D_val.setOnFocusChangeListener(this);
        pp_val.setOnFocusChangeListener(this);
        obwp_val.setOnFocusChangeListener(this);

//      podpięcie grafik figury do pól tekstowych, czyli jak klikniesz na pole
//      tekstowe 'Obwód' to podmieni się grafika na taką z zaznaczonym obwodem
        Global.TouchListener(figura, R.drawable.kwadratpp, pp_val);
        Global.TouchListener(figura, R.drawable.kwadrata, a_val);
        Global.TouchListener(figura,R.drawable.kwadratd,D_val);
        Global.TouchListener(figura,R.drawable.kwadratobw,obwp_val);

//      jak się nie mylę to jest to po to żeby na wstepie się klawiatura nie pojawiała
        final InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

//      TabListener odpowiada za przełączanie zakładek 'podgląd/dane/rozwiązanie',
//      ponieważ są to nałozone na siebie elementy, którym zmienia się tylko visibility
        new TabListener(buttons,imm,btnReview,btnData,btnSolution,figura,scrollView,mWebView);

//      włączenie domyślnej grafiki z figurą, tej która ładuje się na starcie apki
        figura.setImageResource(R.drawable.kwadrat);

//      wyłączenie przycisku 'Rozwiązanie'
        btnSolution.setEnabled(false);

//      powiększenie i pogrubienie czcionki oraz ustawienie przezroczystości na zakładce 'Podgląd'
        btnReview.setTypeface(null, Typeface.BOLD);
        btnReview.setTextSize(30);
        btnReview.setBackgroundColor(Color.TRANSPARENT);

//      obsługa przycisku Policz
        licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                flagi oznaczające czy dana wartość jest już policzona czy nie, żeby jej nie liczyć dwa razy
                boolean bD = false;
                boolean bpp = false;
                boolean bobwp = false;

//                tekst to String z rozwiązaniem, który pojawi się w zakładce 'Rozwiązanie'
                tekst = "";

//                zmiana pogrubienia czcionki w zakładkach. Jest to po to żeby aktywna zakładka zawsze miała większą i pogrubioną czcionkę
                licz.setTypeface(null, Typeface.NORMAL);
                clear.setTypeface(null, Typeface.BOLD);

//                kolejne flagi, ułatwiają zakończenie pętli liczenia
                int x = 0; //koniec petli, wszystko policzone
                int y = 0; //za mało danych aby policzyć

//                sprawdzenie czy liczba nawiasów otwierających i zamykających się zgadza, bez tego nie policzy
                if(Wartosc.nawiasy(a_val.getText().toString()) &&
                        Wartosc.nawiasy(pp_val.getText().toString()) &&
                        Wartosc.nawiasy(D_val.getText().toString()) &&
                        Wartosc.nawiasy(obwp_val.getText().toString())) {
                    try {
                        while (x == 0) {
                            //obliczanie a lub pp lub obwp
                            //sprawdza czy jest podane a
                            if (!isEmpty(a_val)) {
                                System.out.println("^^^^^^^^1");
//                                pobranie wartości z pola tekstowego do zmiennej 'a'
                                a = a_val.getText().toString();
                                //sprawdza czy jest podane pp i czy nie zostało już policzone
                                if (isEmpty(pp_val) && !bpp) {
                                    System.out.println("^^^^^^^^1.1");
                                    //przejście do funkcji liczacej pole podstawy mając a
                                    String s = policzPp(a);
                                    //wpisanie wyniku do pola tekstowego
                                    pp_val.setText(s);
                                    // sformatowanie tekstu w polu tekstowym przez bibliotekę zewnętrzną
                                    JavaScript.showFormatted(s,mWebViewPp);
                                    //zmiana flagi, wartość została policzona
                                    bpp = true;
                                }
                                //powielenie tego co jest wyżej, tzn zasada jest taka sama
                                if (isEmpty(obwp_val) && !bobwp) {
                                    String s = policzObwp(a);
                                    obwp_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewObw);
                                    bobwp = true;
                                    System.out.println("^^^^^^^^1.2");
                                }
                                if (isEmpty(D_val) && !bD) {
                                    String s = policzD(a);
                                    D_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewD);
                                    bD = true;
                                    System.out.println("^^^^^^^^1.3");
                                }
                                JavaScript.showFormatted(a,mWebViewA);
                            } else { //a nie było podane, sprawdza kolejne
                                if (!isEmpty(pp_val)) {
                                    System.out.println("^^^^^^^^2");
                                    pp = pp_val.getText().toString();
                                    JavaScript.showFormatted(pp,mWebViewPp);
                                    bpp = true;
                                    String s = policzAzPp(pp);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewA);
                                }
                                if (!isEmpty(D_val)) {
                                    System.out.println("^^^^^^^^7");
                                    D = D_val.getText().toString();
                                    JavaScript.showFormatted(D,mWebViewD);
                                    bD = true;
                                    String s = policzAzD(D);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewA);
                                }
                                if (!isEmpty(obwp_val)) {
                                    System.out.println("^^^^^^^^0");
                                    obwp = obwp_val.getText().toString();
                                    JavaScript.showFormatted(obwp,mWebViewObw);
                                    bobwp = true;
                                    String s = policzAzObwp(obwp);
                                    a_val.setText(s);
                                    JavaScript.showFormatted(s,mWebViewA);
                                }
                            }
                            //obsługa przypadku gdzie wszystko jest policzone, koniec petli
//                            sprawdza czy nie zostały żadne puste pola do policzenia
                            if (!a_val.getText().toString().equals("") &&
                                    !pp_val.getText().toString().equals("") &&
                                    !obwp_val.getText().toString().equals("") &&
                                    !D_val.getText().toString().equals("")
                                    ) {
//                                ustawia flagę na 1, żeby dać znać że już koniec pętli
                                x = 1;
//                                przywraca domyślną grafikę figury
                                figura.setImageResource(R.drawable.kwadrat);
                                //wyłącza button 'Policz'
                                licz.setEnabled(false);
//                                włącza button 'Rozwiązanie'
                                btnSolution.setEnabled(true);
                                //chowa klawiaaturę
                                imm.hideSoftInputFromWindow(lastFocused.getWindowToken(), 0);
//                              wyświetla kominikat że wszystko policzone i żeby kupić premium, treść oczywiście do edycji będzie potem
                                Toast.makeText(Kwadrat.this, getString(R.string.premium),
                                        Toast.LENGTH_LONG).show();
                            } //obsługa przypadku kiedy jest za malo danych
//                            wyświetli toast i ustawi odpowiednie flagi
                            if(isEmpty(a_val) && isEmpty(pp_val) && isEmpty(obwp_val) && isEmpty(D_val)){
                                Toast.makeText(Kwadrat.this, getString(R.string.notEnough),
                                        Toast.LENGTH_LONG).show();
                                x = 1;
                                y = 1;
                            }
                        }
//                        wyświetlenie fake-owego progress bara, że niby liczy, zwykła gra na zwłokę, żeby program zdążył wszystko policzyć. Działa asynchronicznie
                        new ProgressBar(view);
                    } catch (Exception e) {
//                        wyświetlenie komunikatu że coś poszło nie tak, czyli jak user wprowadzi jakieś złe dane czy cokolwiek poszło źle to to się pojawi
                        System.out.println("emessage " + e.getMessage());
                        Toast.makeText(Kwadrat.this, getString(R.string.ups),
                                Toast.LENGTH_LONG).show();
                    }
                }else{
//                    wyświetlenie komunikatu że trzeba poprawić nawiasy
                    Toast.makeText(Kwadrat.this, getString(R.string.bracket),
                            Toast.LENGTH_LONG).show();
                }
//                sformatowanie i wyświetlenie tekstu rozwiązania przez zewnętrzną bibliotekę
                JavaScript JS = new JavaScript(tekst);
                mWebView.loadDataWithBaseURL("", "" + JS.getTekst(), "text/html", "UTF-8", "");
//              jak było za mało danych żeby policzyć to nie chowa pól tekstowych i nie pokazuje na ich miejscu elementów webview
                if(y == 0) {
                    Global.WebViewHide(false, mWebView, mWebViewA, mWebViewObw, mWebViewD, mWebViewPp);
                    Global.EditTextHide(true, pp_val, a_val, D_val, obwp_val);
                }
//                odświeżanie widoku, jest to po to, że po kliknięciu policz przełączało automatycznie na złą zakładkę, to naprawia ten problem, jestem na 99% pewny że tak było.
                TabListener refresh = new TabListener();
                if (btnData.getVisibility() == View.VISIBLE) {
                    refresh.refresh(figura, scrollView, mWebView);
                }

            }
        });

//        obsługa przycisku wyczyść
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                czyści wszystkie pola tekstowe
                Global.setEmpty(a_val, D_val, pp_val, obwp_val);
//                zeruje zmienną tekst, czyli String z rozwiązaniem
                tekst = "";
//                zeruje webView
                mWebView.loadDataWithBaseURL("", "", "text/html", "UTF-8", "");
//                pokazuje spowrotem pola tekstowe do wprowadzania danych
                Global.EditTextHide(false, a_val, D_val, pp_val, obwp_val);
//                ukrywa webview z wynikami
                Global.WebViewHide(true, mWebViewA, mWebViewD, mWebViewObw, mWebViewPp);
//                włącza button Policz
                licz.setEnabled(true);
//                wyłącza buton Rozwiązanie
                btnSolution.setEnabled(false);
//                ustawia domyślną grafikę w podglądzie
                figura.setImageResource(R.drawable.kwadrat);
//                ustawia prawidłowe czcionki na zakładkach
                clear.setTypeface(null, Typeface.NORMAL);
                licz.setTypeface(null, Typeface.BOLD);
//                wyswietla komunikat że skasowano dane
                Toast.makeText(Kwadrat.this, getString(R.string.deleted),
                        Toast.LENGTH_SHORT).show();
            }
        });
//        obsługa przycisku Wstaw pierwiastek
        sqrtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                utworzenie stringa z pokolorowanym losowo znakiem pierwiastka
                String tmp = "<font color='" + Global.gencode() + "'>" + "()\u221a()" + "</font>";
//                wstawienie tego znaku do pola tekstowego gdzie jest złapany focus, czyli do tego, które jest aktualnie wybrane
                lastFocused.getText().insert(lastFocused.getSelectionStart(), Html.fromHtml(tmp));
//                ustawienie kursora wewnątrz pierwszego nawiasu przed znakiem pierwiastka
                int s = lastFocused.getSelectionStart();
                int a = s - 1;
                lastFocused.setSelection(a);
            }
        });
//        obsługa przycisku Wstaw potęgę
        powbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                utworzenie stringa z pokolorowanym losowo znakiem potegi
                String tmp = "<font color='" + Global.gencode() + "'>" + "()^()" + "</font>";
//                wstawienie tego znaku do pola tekstowego gdzie jest złapany focus, czyli do tego, które jest aktualnie wybrane
                lastFocused.getText().insert(lastFocused.getSelectionStart(), Html.fromHtml(tmp));
//                ustawienie kursora wewnątrz pierwszego nawiasu przed znakiem potęgi
                int s = lastFocused.getSelectionStart();
                int a = s - 4;
                lastFocused.setSelection(a);
            }
        });
    }

//    metoda do sprawdzania czy pole tekstowe jest puste, krócej tak sprawdzić niż pisać '.getText().toString().equals("");'. No i kod jest czytelniejszy
    public Boolean isEmpty(EditText x){
        return x.getText().toString().equals("");
    }

//    metody liczace konkretne przypadki, np, policz pole podstawy mając a, itd.
    private String policzPp(String a) {
//        pojedyncze obliczenia
        String jeden = Wartosc.policz(a,a,"*");
        System.out.println("policzPp "+a);
//        zapisanie stringa z rozwiązaniem
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczPp)+"</b></center><br>" +
                "$$P={a^2}$$<br>" +
                "$$P={{"+Wartosc.formatuj(a)+"}^2}$$<br>" +
                "$$P={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
//        doklejenie tego stringa do zmiennej 'tekst' czyli rozwiązania wyświetlanego w trzeciej zakładce
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
//        zwraca końcową, policzoną wartość, żeby ja potem wpisać do pola tekstowego
        return jeden;
    }
//  to samo co wyżej
    private String policzAzD(String D) {
        String dwa = Wartosc.policz("()\u221a(2)",D,"*");
        String piec = Wartosc.policz(dwa,"2","/");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczAzD)+"</b></center><br>" +
                "$$d={a*√2}$$<br>" +
                "$$a={d/√2}$$<br>" +
                "$$a={{d*√2}/2}$$<br>" +
                "$$a={{{"+Wartosc.formatuj(D)+"}*√2}/2}$$<br>" +
                "$$a={{"+Wartosc.formatuj(dwa)+"}/2}$$<br>" +
                "$$a={"+Wartosc.formatuj(piec)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return piec;
    }

    private String policzD(String a) {
        String jeden = Wartosc.policz(a,"()\u221a(2)","*");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczD)+"</b></center><br>" +
                "$$d={a*√2}$$<br>" +
                "$$d={{"+Wartosc.formatuj(a)+"}*√2}$$<br>" +
                "$$d={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzObwp(String a) {
        String jeden = Wartosc.policz("4",a,"*");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczObwp)+"</b></center><br>" +
                "$$ObwP={a*4}$$<br>" +
                "$$ObwP={{"+Wartosc.formatuj(a)+"}*4}$$<br>" +
                "$$ObwP={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

    private String policzAzPp(String Pp) {
        String trzy = Wartosc.policz("()\u221a("+Pp+")","1","*");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczAzPp)+"</b></center><br>" +
                "$$P={a^2}$$<br>" +
                "$$a={√P}$$<br>" +
                "$$a={√{"+Wartosc.formatuj(Pp)+"}}$$<br>" +
                "$$a={"+Wartosc.formatuj(trzy)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return trzy;
    }

    private String policzAzObwp(String Obwp){
        String jeden = Wartosc.policz(Obwp,"4","/");
        String solucja1 = "<center><b>"+getString(R.string.kwadratpoliczAzObwp)+"</b></center><br>" +
                "$$ObwP={4*a}$$<br>" +
                "$$a={{ObwP}/4}$$<br>" +
                "$$a={{"+Wartosc.formatuj(Obwp)+"}/4}$$<br>" +
                "$$a={"+Wartosc.formatuj(jeden)+"}$$<br>" +
                "<center>*============================*</center>";
        if(!tekst.contains(solucja1)) {
            tekst = tekst + solucja1;
        }
        return jeden;
    }

//    wyświetlenie ostrzeżenia w razie wciśnięcia cofnij, wyświetla stosowny komunikat i czeka sekundę aż nacisniesz drugi raz, wtedy wychodzi
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getString(R.string.backButton), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 1000);
    }

//    obsługa menu z prawego górnego rogu, jest tam info o autorze, plany na przyszłość itp. Ogólnie wygląd tego menu, a w zasadzie rozwijanej listy
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
//  obsługa zdarzeń dla menu, czyli co się zdarzy np. po kliknięciu 'O autorze'
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        new DotsMenu(item, this);
        return super.onOptionsItemSelected(item);
    }

//    łapanie focusa na konkretnych polach tekstowych
    @Override
    public void onFocusChange(View v, boolean hasFocus)  {
        if(hasFocus){
            lastFocused = (EditText)v;
        }
    }
}
