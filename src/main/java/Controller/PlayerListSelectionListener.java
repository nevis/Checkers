package Controller;

import Model.Model;
import View.WinView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PlayerListSelectionListener implements ListSelectionListener {
    private WinView view = null;
    private Model model = null;
    
    public PlayerListSelectionListener(WinView view, Model model) {
        this.view = view;
        this.model = model;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int opponentIndex = view.getPlayerListPanel().getList().getSelectedIndex();
        model.setOpponent(opponentIndex);
    }
}
