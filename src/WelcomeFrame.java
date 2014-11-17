import Server.Autorizetion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Denis on 17.11.2014.
 */
public class WelcomeFrame extends JFrame {
    private JButton okClick;
    private JButton cancelClick;
    private JLabel jLabel;
    private JPanel jPanel;
    private JPanel jMainPanel;

    public WelcomeFrame() throws HeadlessException {
        okClick = new JButton("Авторизироваться");
        okClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Autorizetion.auto();
                dispose();
            }
        });

        cancelClick = new JButton("Выход");
        cancelClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jPanel = new JPanel();
        jMainPanel = new JPanel();
        jMainPanel.setLayout(new BorderLayout());
        jLabel = new JLabel("Приложение для переписки!");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setForeground(Color.RED);
        jMainPanel.add(jLabel,BorderLayout.CENTER);
        jPanel.add(okClick);
        jPanel.add(cancelClick);
        jMainPanel.add(jPanel,BorderLayout.SOUTH);
        setTitle("Преветствую!");
        add(jMainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
