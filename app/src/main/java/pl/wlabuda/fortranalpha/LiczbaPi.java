package pl.wlabuda.fortranalpha;

/**
 * Created by waclab1807 on 29.12.15.
 */
public class LiczbaPi {
    public String first;
    public String valpi;

    public LiczbaPi(String pi) {
        if(pi.contains("π") && pi.length() == 1){
            first = "1";
            valpi = "1π";
        }
        if(pi.endsWith("π") && pi.substring(pi.length()-1,pi.length()).endsWith("-")) { //-pi => -1pi
            pi = pi.substring(pi.length()-1,pi.length()) + "1π";
        }
        if(pi.endsWith("π") && !pi.substring(pi.length()-1,pi.length()).equals("/") && !pi.substring(pi.length()-1,pi.length()).equals("^") && !pi.substring(pi.length()-1,pi.length()).equals("√")) {
            first = pi.substring(pi.length()-1,pi.length());
            valpi = first + "π";
        }
        if(pi.endsWith("π") && pi.substring(pi.length()-1,pi.length()).equals("/")) {
            first = pi.substring(pi.length()-2,pi.length());
            valpi = first + "π";
        }
        if(pi.contains("π/")) {
            String[] tmp = pi.split("/");
            if(tmp[0].length()<2){
                tmp[0] = "1";
            } else {
                tmp[0] = tmp[0].replace("π","");
            }
            first = tmp[0] + "/" + tmp[1];
            valpi = first + "1π";
        }
    }

    public String getFirst() {
        return this.first;
    }

    public String getPi() {
        return this.valpi;
    }

}
