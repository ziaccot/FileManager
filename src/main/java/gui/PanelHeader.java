package gui;

import properties.ButtonProperties;

import javax.swing.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PanelHeader extends JPanel {
    public JComboBox<String> diskSource;
    public JTextField pathSource;
    public JButton btnUp;

    public PanelHeader(Path path){
        btnUp = new JButton(ButtonProperties.btnUp);

        pathSource = new JTextField(path.toAbsolutePath().normalize().toString());
        pathSource.setEditable(false);

        diskSource = new JComboBox<>();
        FileSystems.getDefault().getRootDirectories().forEach(e->diskSource.addItem(e.toString()));
        diskSource.setSelectedIndex(0);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.add(diskSource);
        this.add(pathSource);
        this.add(btnUp);
    }
}
