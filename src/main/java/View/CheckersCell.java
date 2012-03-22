package View;

import Model.Model;

import javax.swing.*;
import java.awt.*;

public class CheckersCell extends JPanel {
    private int row, column;
    private Model model;
    public CheckersCell(int row, int column, Model model) {
        this.row = row;
        this.column = column;
        this.model = model;
        setName(row + "" + column);
        setPreferredSize(new Dimension(60, 60));
        setBorder(null);
        if ((row + column) % 2 == 0) {
            setBackground(this.model.DARK);
        } else {
            setBackground(this.model.LIGHT);
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        /*if (Data.getData().getBoardValue(row, column) == 1) {
            Ellipse2D figure = new Ellipse2D.Double(5, 5, 49, 49);
            g2d.setColor(new Color(211, 211, 211));
            g2d.draw(figure);
            g2d.fill(figure);
            g2d.dispose();
        } else if (Data.getData().getBoardValue(row, column) == 2) {
            Ellipse2D figure = new Ellipse2D.Double(5, 5, 49, 49);
            g2d.setColor(Color.black);
            g2d.draw(figure);
            g2d.fill(figure);
            g2d.dispose();
        }*/
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
}
