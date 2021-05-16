package actions;

import gui.DataTable;
import gui.PanelHeader;
import properties.ErrorProperties;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;

public class ItemChangedAction implements ActionListener {
    private DataTable table;
    private PanelHeader panelHeader;

    public ItemChangedAction(DataTable table, PanelHeader panelHeader){
        this.table = table;
        this.panelHeader = panelHeader;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Path root = Path.of(panelHeader.diskSource.getSelectedItem().toString()).toAbsolutePath();
        try {
            panelHeader.pathSource.setText(root.normalize().toString());
            table.updateData(root);
        }catch (RuntimeException exception){
            JOptionPane.showMessageDialog(table, ErrorProperties.FilePathError + " " + root.normalize().toString());
        }
    }
}
