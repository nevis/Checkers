package View;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private JLabel info = new JLabel("", JLabel.CENTER);
    public InfoPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        add(info);
    }
    public void setInfo(String in) {
        info.setText(in);
        this.repaint();
    }
}
