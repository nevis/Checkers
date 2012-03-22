package Controller;

import View.CheckersCell;
import View.WinView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckersPanelListener implements MouseListener {
    private WinView view;
    CheckersPanelListener(WinView view) {
        this.view = view;        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        CheckersCell cc = (CheckersCell) view.getCheckersPanel().getComponentAt(e.getPoint());
        System.out.println(cc.getName());
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
