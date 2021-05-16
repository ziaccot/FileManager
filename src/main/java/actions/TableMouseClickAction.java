package actions;

import entity.FileInfo;
import gui.DataTable;
import gui.PanelHeader;
import model.FileTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Files;
import java.nio.file.Path;

public class TableMouseClickAction extends MouseAdapter {
    private DataTable table;
    private PanelHeader panelHeader;

    public TableMouseClickAction(DataTable table, PanelHeader panelHeader){
        this.table = table;
        this.panelHeader = panelHeader;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (e.getClickCount()==2){
            int row = table.getSelectedRow();
            FileTableModel model = (FileTableModel) table.getModel();
            String fileName = model.getValueAt(row, 0).toString();
            Path root = Path.of(panelHeader.pathSource.getText()+"\\"+fileName).toAbsolutePath();
            if (Files.exists(root) && Files.isDirectory(root)){
                panelHeader.pathSource.setText(root.normalize().toString());
                table.updateData(root);
            }
        }
    }
}
