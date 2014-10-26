import Constants.AutoConst;
import Server.Autorizetion;
import Server.Queries;
import Server.QueryString;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Denis on 22.10.2014.
 */
public class Main {

    public static void main(String[] args) {
        Autorizetion.auto(new Autorizetion.IAuto() {
            @Override
            public void success(ArrayList<String> arl) {
                QueryString q = null;
                try {
                    q = new QueryString()
                        .add("act", AutoConst.act)
                        .add("soft", AutoConst.soft)
                        .add("utf8", AutoConst.utf8)
                        .add("ip_h", arl.get(0))
                        .add("from_host", AutoConst.fromHost)
                        .add("to", arl.get(1))
                        .add("expire", AutoConst.expire)
                            //todo ввод mail/pass
                        .add("email", "")
                        .add("pass", "");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                Queries.get(AutoConst.urlLogin,q,new Queries.IServerAnswer() {
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
