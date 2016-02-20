package pl.wlabuda.fortranalpha;

/**
 * Created by waclab1807 on 29.12.15.
 */
public class LiczbaPi {
    public String first;

    public LiczbaPi(String pi) {
        if(pi.contains("π") && pi.length() == 1){ //π
            first = "1";
        } else
        if(pi.contains("-π")) { //-pi => -1pi
            first = "-1";
        } else
        if(pi.equals("()π")){ //()π
            first = "1";
        } else
        if(pi.contains("0π") && pi.length() == 2) { //0π
            first = "0";
        } else
        if(pi.contains("(0)π") || pi.contains("(0π)") && pi.length() == 4) { //(0)π || (0π)
            first = "0";
        } else
        if((pi.endsWith("π)") || pi.endsWith(")π")) && pi.length() > 3) { //(4π) || (4)π
            first = pi.substring(1,pi.length()-2);
        } else
        if(pi.endsWith("π") && pi.length() > 1) { //4π
            first = pi.substring(0,pi.length()-1);
        }
    }

    public String getFirst() {
        return this.first;
    }
    public String getPi() {
        return "(" + this.first + ")π";
    }

    public String wartoscPi() {
        System.out.println("WPi: " + this.getFirst() + " π ");
        String wynik;

        if (this.getFirst().equals("0")){
            wynik = "0";
        } else {
            wynik = this.getPi();
        }
        return wynik;
    }

}
