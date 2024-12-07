import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MyFrame extends JFrame {
    MyFrame(){
        this.setTitle("Chillies");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.setSize(new Dimension(2000,2000));
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
