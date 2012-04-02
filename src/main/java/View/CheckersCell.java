package View;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CheckersCell extends JPanel {
    private int row, column;
    private Model model;
    private Ellipse2D figure;
    private int size= model.CHECKERS_CELL_SIZE;
    
    public CheckersCell(int row, int column, Model model) {
        this.row = row;
        this.column = column;
        this.model = model;
        //setName(row + "" + column);
        setPreferredSize(new Dimension(size, size));
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
        if (model.getCheckers().getCheckersBoardValueAt(row, column) == 1) {
            figure = new Ellipse2D.Double(5, 5, size - 11, size - 11);
            g2d.setColor(Color.white);
            g2d.draw(figure);
            g2d.fill(figure);
            g2d.dispose();
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == 2) {
            figure = new Ellipse2D.Double(5, 5, size - 11, size - 11);
            g2d.setColor(Color.black);
            g2d.draw(figure);
            g2d.fill(figure);
            g2d.dispose();
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == 11) {
            figure = new Ellipse2D.Double(10, 10, size - 21, size - 21);
            g2d.setColor(Color.white);
            g2d.draw(figure);
            g2d.fill(figure);
            g2d.dispose();
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == 21) {
            figure = new Ellipse2D.Double(10, 10, size - 21, size - 21);
            g2d.setColor(Color.black);
            g2d.draw(figure);
            g2d.fill(figure);
            g2d.dispose();
        }
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
}
