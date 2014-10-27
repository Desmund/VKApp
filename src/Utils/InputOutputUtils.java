package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Denis on 26.10.2014.
 */
public class InputOutputUtils {
    public static String readStreamToString(InputStream in,String encoding)throws IOException {
        StringBuffer b = new StringBuffer();
        InputStreamReader r = new InputStreamReader(in,encoding);
        int c;
        while((c=r.read())!=-1){
            b.append((char) c);
        }
        return b.toString();
    }

    public static String readString(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
