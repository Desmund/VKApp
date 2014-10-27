import Constants.AutoConst;
import Server.Autorizetion;
import Server.Queries;
import Server.QueryString;
import Utils.InputOutputUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Denis on 22.10.2014.
 */
public class Main {
    static String mail = null;
    static String pass = null;

    public static void main(String[] args) {
        System.out.println("Введите свой email:");
        do {
            mail = InputOutputUtils.readString();
        } while (mail==null);
        System.out.println("Введите пароль:");
        do {
            pass = InputOutputUtils.readString();
        } while (pass==null);
        Autorizetion.auto(new Autorizetion.IAuto() {
            @Override
            public void success(ArrayList<String> arl) {
                QueryString q = null;
                try {
                    q = new QueryString()
                        .add("act", AutoConst.act)
                        .add("soft", AutoConst.soft)
                        .add("q", AutoConst.q)
                        .add("from_host", AutoConst.fromHost)
                        .add("ip_h", arl.get(0))
                        .add("to", arl.get(1))
                        .add("expire", AutoConst.expire)
                        .add("email", mail)
                        .add("pass", pass);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                mail = null;
                pass = null;
                Queries.post(AutoConst.urlLogin,q,new Queries.IServerAnswer() {
                    @Override
                    public void success(String str) {
                        System.out.println(str);
                    }

                    @Override
                    public void error(String err) {
                        System.out.println("Ошибка авторизации!");
                    }
                });
            }

            @Override
            public void error(String err) {
                System.out.println("Авторизация прошла не успешно!");
            }
        });
    }
}
