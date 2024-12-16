package Frontend;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MyFrame extends JFrame {
    private CardLayout cardLayout;
    JPanel mainPanel;
    MyFrame(){
        this.setTitle("Chillies");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        cardLayout=new CardLayout();
        mainPanel=new JPanel(cardLayout);
        this.setSize(new Dimension(610,500));
        mainPanel.setSize(new Dimension(610,500));
        mainPanel.setBackground(Color.RED);
        LoginPanel loginPanel=new LoginPanel(this);
        mainPanel.add(loginPanel,"LoginPanel");
        mainPanel.add(RegisterPanel,"RegisterPanel");
        this.add(mainPanel,"mainPanel");
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void switchToPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }
}
