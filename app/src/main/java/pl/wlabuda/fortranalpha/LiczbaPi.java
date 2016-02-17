package pl.wlabuda.fortranalpha;

/**
<<<<<<< HEAD
 * Created by waclab1807 on 29.12.15. & SkylinR on 17.02.16
*/
=======
 * Created by waclab1807 on 29.12.15.
 */
>>>>>>> 47f0d348db7e6f2e8f30e218ee97f0a66b2af661
public class LiczbaPi {
    public String first;
    public String valpi;

    public LiczbaPi(String pi) {
        if(pi.contains("π") && pi.length() == 1){
            first = "1";
            valpi = "π";
        }
<<<<<<< HEAD

        if(pi.contains("-π")) { //-π => -1π
            //pi = pi.replace("-π","-1π");
            first = "-1";
            valpi="-π";
        }

        if(pi.contains("π")&& pi.charAt(0)=='0' && pi.length()==2) { // 0π
            first = "0";
            valpi= "0";
        }

=======
        if(pi.contains("-π")) { //-pi => -1pi
            pi = pi.replace("-π","-1π");
        }
>>>>>>> 47f0d348db7e6f2e8f30e218ee97f0a66b2af661
        if(pi.endsWith("π") && pi.length() != 1 && !pi.substring(pi.length()-1,pi.length()).equals("/") && !pi.substring(pi.length()-1,pi.length()).equals("^") && !pi.substring(pi.length()-1,pi.length()).equals("√")) {
            first = pi.replace("π","");
            valpi = first + "π";
        }
<<<<<<< HEAD

=======
>>>>>>> 47f0d348db7e6f2e8f30e218ee97f0a66b2af661
        if(pi.contains("/π")) {         //
            first = pi;
            valpi = "(" + pi + ")";
        }
<<<<<<< HEAD

=======
>>>>>>> 47f0d348db7e6f2e8f30e218ee97f0a66b2af661
        if(pi.endsWith("π") && pi.substring(0,pi.length()-1).equals("/") && !pi.contains("/π")) {       // (3/4)π
            first = pi.substring(0,pi.length()-1);
            valpi = "(" + first + ")π";
        }
<<<<<<< HEAD

=======
>>>>>>> 47f0d348db7e6f2e8f30e218ee97f0a66b2af661
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

//    wartoscPi()

}
