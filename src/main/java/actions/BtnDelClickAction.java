package actions;

import gui.DataPanel;
import gui.DataTable;
import model.FileTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BtnDelClickAction implements ActionListener {
    private DataPanel leftPanel ,rightPanel;

    public BtnDelClickAction(DataPanel leftPanel, DataPanel rightPanel){
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DataTable table = null;
        String source = null;
        if (leftPanel.dataTable.isFocusOwner()){
            table = leftPanel.dataTable;
            source = leftPanel.panelHeader.pathSource.getText();
        }else if (rightPanel.dataTable.isFocusOwner()){
            table = rightPanel.dataTable;
            source = rightPanel.panelHeader.pathSource.getText();
        }
        var row = table.getSelectedRow();
        FileTableModel model = (FileTableModel) table.getModel();
        String filename = model.getValueAt(row, 0).toString();

        try {
            Files.delete(Path.of(source, filename));
            table.updateData(Path.of(source));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
