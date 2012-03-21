package Controller;

import View.WinView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {
    private WinView view = null;
    ExitListener(WinView view) {
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        view.dispose();
    }
}
