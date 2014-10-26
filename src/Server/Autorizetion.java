package Server;

import Constants.AutoConst;
import Utils.Parser;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Denis on 26.10.2014.
 */
public class Autorizetion {
    public interface IAuto{
        public void success(ArrayList<String>arl);
        public void error(String err);
    }

    public static void auto(final IAuto iAuto){
        QueryString q = null;
        try{
            q = new QueryString()
                    .add("client_id", AutoConst.clientId)
                    .add("redirect_url", AutoConst.redirectUrl)
                    .add("display", AutoConst.display)
                    .add("scope", AutoConst.scope)
                    .add("response_type", AutoConst.responseType);
        }catch(UnsupportedEncodingException e){
            System.out.print("Error!");
        }
        Queries.get(AutoConst.url,q, new Queries.IServerAnswer() {
            @Override
            public void success(String str) {
               iAuto.success(Parser.parse(str));
            }

            @Override
            public void error(String err) {
                iAuto.error(err);
            }
        });
    }
}