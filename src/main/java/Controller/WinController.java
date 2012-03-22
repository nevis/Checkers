package Controller;

import Model.Model;
import View.WinView;

public class WinController {
    //private WinView view = null;
    //private Model model = null;

    public WinController(WinView view, Model model) {
        //this.view = view;
        //this.model = model;
        view.getAuthorizationPanel().addConnectListener(new ConnectListener(view, model));
        view.getAuthorizationPanel().addExitListener(new ExitListener(view));
        view.getPlayerListPanel().addInviteListener(new InviteListener(model));
        view.getPlayerListPanel().addPlayerListSelectionListener(new PlayerListSelectionListener(view, model));
        view.getCheckersPanel().addCheckersListener(new CheckersPanelListener(view));
    }

}
