package View;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class CheckersPanel extends JPanel {
    private Model model;
    CheckersPanel(Model model) {
        this.model = model;
        setLayout(new GridLayout(8, 8, 0, 0));
        createGameField();
    }
    private void createGameField() {
        for (int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                add(new CheckersCell(i, j, model));
            }
        }
    }
    public void addCheckersListener(MouseListener ml){
        addMouseListener(ml);
    }
}
