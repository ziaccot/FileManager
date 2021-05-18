package actions;

import gui.DataPanel;
import gui.DataTable;
import properties.DefaultProperties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BtnMkDirClickAction implements ActionListener {
    private DataPanel leftPanel, rightPanel;

    public BtnMkDirClickAction(DataPanel leftPanel, DataPanel rightPanel){
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DataTable table=null;
        Path path = null;
        if (leftPanel.dataTable.isFocusOwner()){
            table = leftPanel.dataTable;
            path = Path.of(leftPanel.panelHeader.pathSource.getText()).toAbsolutePath();
        }else if (rightPanel.dataTable.isFocusOwner()){
            table = rightPanel.dataTable;
            path = Path.of(rightPanel.panelHeader.pathSource.getText()).toAbsolutePath();
        }

        if (table != null){
            String dir = JOptionPane.showInputDialog(table, DefaultProperties.FolderName);
            if (dir == null || dir.isEmpty()){
                JOptionPane.showMessageDialog(table, DefaultProperties.EmptyFolderName);
            }else{
                Path path1 = Path.of(path.toString(), dir).toAbsolutePath();
                try {
                    Files.createDirectory(path1);
                    table.updateData(path);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
