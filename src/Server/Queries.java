package Server;

import Utils.InputOutputUtils;
import com.sun.deploy.net.HttpResponse;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Denis on 26.10.2014.
 */
public abstract class Queries {
    public interface IServerAnswer{
        public void success(String str);
        public void error(String err);
    }

    public static void get(final String url,final QueryString query,final IServerAnswer iServerAnswer) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URLConnection con = new URL(url + "?" + query).openConnection();
                    iServerAnswer.success(InputOutputUtils.readStreamToString(con.getInputStream(), "UTF-8"));
                } catch (IOException e) {
                    iServerAnswer.error(e.getMessage());
                }
            }
        }).start();
    }

    public static void post(final String url,final QueryString query,final IServerAnswer iServerAnswer) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URLConnection con = new URL(url).openConnection();
                    con.setDoOutput(true);
                    OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream(),"ASCII");
                    out.write(query.toString());
                    out.write("\r\n");
                    out.flush();
                    out.close();
                    iServerAnswer.success(InputOutputUtils.readStreamToString(con.getInputStream(), "UTF-8"));
                } catch (IOException e) {
                    iServerAnswer.error(e.getMessage());
                }
            }
        }).start();
    }
}
