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
    JFXPanel jfxPanel;
    WebView webView;

    public AutoFrame(final String url) {
        jfxPanel = new JFXPanel();
        viewFrame();
        viewWeb(url);
    }

    public void viewFrame(){
        this.add(jfxPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,600); //установка параметров окна
        this.setVisible(true);
    }

    public void viewWeb(final String url){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webView = new WebView();
                BorderPane borderPane = new BorderPane();
                webView.getEngine().load(url);
                borderPane.setCenter(webView);
                Scene screen = new Scene(borderPane,450,450);
                jfxPanel.setScene(screen);
            }
        });
    }
}
