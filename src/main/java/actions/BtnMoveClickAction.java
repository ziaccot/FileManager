package actions;

import gui.DataPanel;
import gui.DataTable;
import model.FileTableModel;
import properties.ErrorProperties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BtnMoveClickAction implements ActionListener {
    private DataPanel leftPanel, rightPanel;

    public BtnMoveClickAction(DataPanel leftPanel, DataPanel rightPanel){
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DataTable sourceTable = null, destinationTable = null;
        String sourcePath = null, destinationPath = null;

        if (leftPanel.dataTable.isFocusOwner()){
            sourceTable = leftPanel.dataTable;
            destinationTable = rightPanel.dataTable;

            sourcePath = leftPanel.panelHeader.pathSource.getText();
            destinationPath = rightPanel.panelHeader.pathSource.getText();
        }

        if (rightPanel.dataTable.isFocusOwner()){
            sourceTable = rightPanel.dataTable;
            destinationTable = leftPanel.dataTable;

            sourcePath = rightPanel.panelHeader.pathSource.getText();
            destinationPath = leftPanel.panelHeader.pathSource.getText();
        }

        if (sourceTable != null && destinationTable != null){
            FileTableModel model = (FileTableModel) sourceTable.getModel();
            Path source = Path.of(sourcePath + "\\"+ model.getValueAt(sourceTable.getSelectedRow(), 0).toString());

            Path destination = Path.of(destinationPath + "\\"+model.getValueAt(sourceTable.getSelectedRow(),0).toString());

            try {
                Files.move(source, destination);
                destinationTable.updateData(Path.of(destinationPath).toAbsolutePath());
                sourceTable.updateData(Path.of(sourcePath).toAbsolutePath());
            }catch (FileAlreadyExistsException existsException){
                JOptionPane.showMessageDialog(sourceTable, ErrorProperties.FileExists);
            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }
}
