package Controller;

import Model.Model;
import View.WinView;

public class WinController {
    public WinController(WinView view, Model model) {
        ClientCommand clientCommand = new ClientCommand(view, model);
        view.getAuthorizationPanel().addConnectListener(new ConnectListener(view, model, clientCommand));
        view.getAuthorizationPanel().addExitListener(new ExitListener(view));
        view.getPlayerListPanel().addInviteListener(new InviteListener(model, view));
        view.getPlayerListPanel().addPlayerListSelectionListener(new PlayerListSelectionListener(view, model));
        view.getCheckersPanel().addCheckersListener(new CheckersPanelListener(view, model));
    }
}
