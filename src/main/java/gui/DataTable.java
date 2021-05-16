package gui;

import entity.FileInfo;
import model.FileTableModel;
import properties.ErrorProperties;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataTable extends JTable {
    public DataTable(){
        this.setModel(new FileTableModel());
    }

    public void updateData(Path path){
        try {
            FileTableModel model = new FileTableModel();
            Files.list(path).map(FileInfo::new).forEach(e->model.addRow(e));
            this.setModel(model);
        } catch (IOException e) {
            throw new RuntimeException(ErrorProperties.FilePathError + e);
        }
    }
}
