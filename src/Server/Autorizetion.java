package Server;

import Constants.AutoConst;
import java.io.UnsupportedEncodingException;

/**
 * Created by Denis on 26.10.2014.
 */
public class Autorizetion {
    public static void auto(){
        QueryString q = null;
        try{
            q = new QueryString()
                .add("client_id", AutoConst.clientId)
                .add("scope", AutoConst.scope)
                .add("redirect_uri", AutoConst.redirectUri)
                .add("display", AutoConst.display)
                .add("v", AutoConst.v)
                .add("response_type", AutoConst.responseType);
        }catch(UnsupportedEncodingException e){
            System.out.print("Error!");
        }
        new AutoFrame(AutoConst.url+"?"+q);
    }

    public static void finishAutorizetion(String str){
        System.out.println("Авторизация прошла успешно!");
        System.out.println("Access token = "+str.substring(str.indexOf("access_token=")+"access_token=".length(),str.indexOf("&")));
        System.out.println("User id = "+str.substring(str.indexOf("user_id=")+"user_id=".length()));
        System.exit(0);
    }
}
