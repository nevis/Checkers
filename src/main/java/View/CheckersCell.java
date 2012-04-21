package View;

import Model.*;

import javax.swing.*;
import java.awt.*;

public class CheckersCell extends JPanel {
    private int row, column;
    private Model model;

    public CheckersCell(int row, int column, Model model) {
        this.row = row;
        this.column = column;
        this.model = model;
        setPreferredSize(new Dimension(Constant.CHECKERS_CELL_SIZE,  Constant.CHECKERS_CELL_SIZE));
        setBorder(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (model.getCheckers().getCheckersBoardValueAt(row, column) == 1) {
            g2d.drawImage(Constant.white1, 0, 0, this);
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == 2) {
            g2d.drawImage(Constant.black1, 0, 0, this);
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == 11) {
            g2d.drawImage(Constant.white2, 0, 0, this);
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == 21) {
            g2d.drawImage(Constant.black2, 0, 0, this);
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == 0) {
            g2d.drawImage(Constant.blackCell, 0, 0, this);
        } else if (model.getCheckers().getCheckersBoardValueAt(row, column) == -1) {
            g2d.drawImage(Constant.whiteCell, 0, 0, this);
        }
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
}
