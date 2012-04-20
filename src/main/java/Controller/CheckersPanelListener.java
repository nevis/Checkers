package Controller;

import View.CheckersCell;
import View.WinView;
import Model.Model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckersPanelListener implements MouseListener {
    private WinView view;
    private Model model;
    CheckersPanelListener(WinView view, Model model) {
        this.view = view;
        this.model = model;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (model.getCheckers().getTurn()) {
            CheckersCell cc = (CheckersCell) view.getCheckersPanel().getComponentAt(e.getPoint());
            model.getCheckers().clientTurn(cc.getRow(), cc.getColumn());
            view.getCheckersPanel().repaint();
            if (!model.getCheckers().getTurn()) view.getInfoPanel().setInfo("Enemy turn");
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
}
