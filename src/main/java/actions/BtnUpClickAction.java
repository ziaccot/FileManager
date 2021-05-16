package actions;

import gui.DataTable;
import gui.PanelHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;

public class BtnUpClickAction implements ActionListener {
    private DataTable table;
    private PanelHeader panelHeader;

    public BtnUpClickAction(DataTable table, PanelHeader panelHeader){
        this.table = table;
        this.panelHeader = panelHeader;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Path root = Path.of(panelHeader.pathSource.getText()).toAbsolutePath();
        root = root.getParent();

        if (root!=null){
            panelHeader.pathSource.setText(root.normalize().toString());
            table.updateData(root);
        }
    }
}
