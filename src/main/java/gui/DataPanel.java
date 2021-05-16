package gui;

import actions.BtnUpClickAction;
import actions.ItemChangedAction;
import actions.TableMouseClickAction;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

public class DataPanel extends JPanel {
    public PanelHeader panelHeader;
    public DataTable dataTable;

    public DataPanel(Path path){
        panelHeader = new PanelHeader(path);
        dataTable = new DataTable();
        dataTable.updateData(path);

        this.setLayout(new BorderLayout());
        this.add(panelHeader, BorderLayout.NORTH);
        this.add(new JScrollPane(dataTable), BorderLayout.CENTER);

        this.addActions();
    }

    private void addActions() {
        dataTable.addMouseListener(new TableMouseClickAction(dataTable, panelHeader));
        panelHeader.btnUp.addActionListener(new BtnUpClickAction(dataTable, panelHeader));
        panelHeader.diskSource.addActionListener(new ItemChangedAction(dataTable, panelHeader));
    }
}
