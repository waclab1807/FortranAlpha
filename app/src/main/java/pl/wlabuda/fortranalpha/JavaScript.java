package pl.wlabuda.fortranalpha;

/**
 * Created by waclab1807 on 14.04.15.
 */
public class JavaScript {


    private String js;
    public JavaScript(String tekst){
        js = "<html><head>"
                + "<link rel='stylesheet' href='file:///android_asset/mathscribe/jqmath-0.4.0.css'>"
                + "<script src = 'file:///android_asset/mathscribe/jquery-1.4.3.min.js'></script>"
                + "<script src = 'file:///android_asset/mathscribe/jqmath-etc-0.4.2.min.js'></script>"
                + "</head><body>"
                + "<script>var s =   " +
                "'"+tekst+"';" +
                "M.parseMath(s);document.body.style.fontSize = \"20pt\";document.write(s);</script> " +
                "</body>";
    }
    public String getTekst() {
        return js;
    }
}
