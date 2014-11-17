import Server.Autorizetion;
import java.util.ArrayList;


/**
 * Created by Denis on 22.10.2014.
 */
public class Main {

    public static void main(String[] args) {
        Autorizetion.auto(new Autorizetion.IAuto() {
            @Override
            public void success(String arl) {
                System.out.println("Авторизация прошла успешно!");
            }

            @Override
            public void error(String err) {
                System.out.println("Авторизация прошла не успешно!");
            }
        });
    }
}
