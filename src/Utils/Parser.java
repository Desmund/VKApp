package Utils;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

/**
 * Created by Denis on 26.10.2014.
 */
public class Parser {
    public static ArrayList<String> parse(String s){
        ArrayList<String> arl = new ArrayList<String>();
        String ip_h = s.substring(s.indexOf("ip_h"));
        ip_h = ip_h.substring(ip_h.indexOf("=")+2);
        ip_h = ip_h.substring(0,ip_h.indexOf((char)34));
        arl.add(ip_h);
        String to = s.substring(s.indexOf((char) 34 + "to" + (char) 34));
        to = to.substring(to.indexOf("=")+2);
        to = to.substring(0,to.indexOf((char)34));
        arl.add(to);
        return arl;
    }
}
