package Server;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javax.swing.*;

/**
 * Created by Denis on 17.11.2014.
 */
public class AutoFrame extends JFrame {
    private JFXPanel jfxPanel;
    private WebView webView;

    public AutoFrame(final String url) {
        jfxPanel = new JFXPanel();
        viewFrame();
        viewWeb(url);
    }

    private void viewFrame(){
        add(jfxPanel);
        setUndecorated(true);
        setSize(700,600); //установка параметров окна
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void viewWeb(final String url){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webView = new WebView();
                BorderPane borderPane = new BorderPane();
                webView.getEngine().load(url);
                borderPane.setCenter(webView);
                Scene screen = new Scene(borderPane,450,450);
                jfxPanel.setScene(screen);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            String str = webView.getEngine().getLocation();
                            if ( str.contains("access_token")){
                                Autorizetion.finishAutorizetion(str);

                            }
                            else
                            if(str.contains("access_denied")){
                                webView.getEngine().load(url);
                            }
                        }
                    }
                }).start();
            }
        });
    }
}
