package View;

import Model.Model;

import javax.swing.*;
import java.awt.*;

public class CheckersCell extends JPanel {
    private int row, column;
    private Model model;
    private int size= model.CHECKERS_CELL_SIZE;

    public CheckersCell(int row, int column, Model model) {
        this.row = row;
        this.column = column;
        this.model = model;
        setPreferredSize(new Dimension(size, size));
        setBorder(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (model.getCheckers().getCheckersBoardValueAt(row, column) == 1) {
            g2d.drawImage(model.white1, 0, 0, this);
            g2d.finalize();
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == 2) {
            g2d.drawImage(model.black1, 0, 0, this);
            g2d.finalize();
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == 11) {
            g2d.drawImage(model.white2, 0, 0, this);
            g2d.finalize();
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == 21) {
            g2d.drawImage(model.black2, 0, 0, this);
            g2d.finalize();
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == 0) {
            g2d.drawImage(model.blackCell, 0, 0, this);
            g2d.finalize();
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == -1) {
            g2d.drawImage(model.whiteCell, 0, 0, this);
            g2d.finalize();
        }
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
}
