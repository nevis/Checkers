package View;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class PlayerListPanel extends JPanel {
    private DefaultListModel listModel = new DefaultListModel();
    private JList list = new JList(listModel);
    private JButton invite = new JButton("Invite");
    
    PlayerListPanel() {
        int width = 160;
        int height = 300;
        setPreferredSize(new Dimension(width + 30, height + 90));
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(width, height));
        add(scroll);
        add(invite);
    }
    public DefaultListModel getListModel() {
        return listModel;
    }
    public JList getList() {
        return list;
    }
    public void addPlayerListSelectionListener(ListSelectionListener lsl) {
        list.addListSelectionListener(lsl);
    }
    public void addInviteListener(ActionListener al) {
        invite.addActionListener(al);
    }
    public JButton getInvite() {
        return invite;
    }
}