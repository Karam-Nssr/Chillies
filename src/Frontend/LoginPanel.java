package Frontend;
import Backend.Employee;
import Database.EmployeesFile;
import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginPanel extends JPanel {
    private final MyFrame parentFrame;
    LoginPanel(MyFrame parentFrame){
        this.parentFrame=parentFrame;
        setSize(1000,500);
        setLayout(new BorderLayout());
        JPanel first=new JPanel();
        first.setSize(300,500);
        first.setBackground(Color.WHITE);
        first.setLayout(new GridBagLayout());

        GridBagConstraints gbc=new GridBagConstraints();
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        BufferedImage Mini_Logo= null;
        try {
            Mini_Logo= ImageIO.read(new File("MINI-LOGO.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel mini=new JLabel(new ImageIcon(Mini_Logo));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 300, 90);
        gbc.anchor = GridBagConstraints.EAST;
        first.add(mini,gbc);
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.BLACK);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(-400, 5, 0, 10);
        gbc.anchor = GridBagConstraints.EAST;
        first.add(userLabel, gbc);

        JTextField userText = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        first.add(userText, gbc);

        JLabel passwordLabel =new JLabel("Password:");
        passwordLabel.setForeground(Color.BLACK);
        gbc.insets = new Insets(-320, 5, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        first.add(passwordLabel, gbc);

        JPasswordField passText = new JPasswordField(20);
        gbc.gridx=1;
        gbc.anchor = GridBagConstraints.WEST;
        first.add(passText, gbc);


        JButton loginButton = new JButton("Login") ;
        //ButtonDesign loginButton = new ButtonDesign("Login") ;
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.RED);
        loginButton.setFocusable(false);
        gbc.insets = new Insets(-250, 80, 0, 0);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.anchor=GridBagConstraints.CENTER;
        first.add(loginButton,gbc);

        JButton registerButton = new JButton("Register");
        gbc.insets = new Insets(-250, 80, 0, 40);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(Color.RED);
        registerButton.setFocusable(false);
        gbc.gridx =1;
        first.add(registerButton, gbc);

        loginButton.addActionListener(e -> {
            String username=userText.getText().trim();
            String password=new String(passText.getPassword()).trim();
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Please Enter The Username and The Password","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Employee> employees=EmployeesFile.ReadEmployeesFile();
            boolean success = EmployeesFile.CheckForEmployee(employees,username, password);
            if (success) {
                parentFrame.switchToPanel("mainPanel");

            }
            else {
                JOptionPane.showMessageDialog(this,"Username or Password may be incorrect,please check them and try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerButton.addActionListener(e -> {
            parentFrame.switchToPanel("RegisterPanel");
        });

        BufferedImage LOGO= null;
        try {
            LOGO = ImageIO.read(new File("LOGO.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JLabel ImageLabel=new JLabel(new ImageIcon(LOGO));

        //setBackground(Color.DARK_GRAY);
        setBackground(Color.RED);
        add(ImageLabel);
        add(first,BorderLayout.EAST);
    }
}
