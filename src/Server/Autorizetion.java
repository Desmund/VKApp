package Server;

import Constants.AutoConst;
import java.io.UnsupportedEncodingException;

/**
 * Created by Denis on 26.10.2014.
 */
public class Autorizetion {
    public interface IAuto{
        public void success(String arl);
        public void error(String err);
    }

    public static void auto(final IAuto iAuto){
        QueryString q = null;
        try{
            q = new QueryString()
                .add("client_id", AutoConst.clientId)
                .add("scope", AutoConst.scope)
                .add("redirect_uri", AutoConst.redirectUri)
                .add("response_type", AutoConst.responseType)
                .add("v", AutoConst.v);
        }catch(UnsupportedEncodingException e){
            System.out.print("Error!");
        }

        AutoFrame autoFrame = new AutoFrame(AutoConst.url+"?"+q);
        autoFrame.setVisible(true);

//        Queries.get(AutoConst.url,q, new Queries.IServerAnswer() {
//            @Override
//            public void success(String str) {
//                iAuto.success(str);
//            }
//
//            @Override
//            public void error(String err) {
//                iAuto.error(err);
//            }
//        });
    }
}
