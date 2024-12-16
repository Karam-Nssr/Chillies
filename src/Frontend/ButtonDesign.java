package Frontend;

import javax.swing.*;
import java.awt.*;

public class ButtonDesign extends JButton {
    ButtonDesign(String text){
        super(text);
        setContentAreaFilled(false);
        setOpaque(false);
        //setBorder(null);
        setPreferredSize(new Dimension(80, 35));
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(),20, 20);
        super.paintComponent(g2d);
        g2d.dispose();
    }
}
