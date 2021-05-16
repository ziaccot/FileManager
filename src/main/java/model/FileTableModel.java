package model;

import entity.FileInfo;
import properties.TableProperties;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class FileTableModel extends AbstractTableModel {
    private final String[] columns = TableProperties.COLUMNS;
    private final List<FileInfo> data = new ArrayList<>();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FileInfo info = data.get(rowIndex);

        switch (columnIndex){
            case 0: return info.getFileName();
            case 1: return info.getFileSize();
            case 2: return info.getLastModified();
            default: throw new IllegalArgumentException("column index "+columnIndex);
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public void addRow(FileInfo info){
        if (data.add(info)){
            var row = data.size()-1;
            fireTableRowsInserted(row, row);
        }
    }
}
