package gui;

import properties.DefaultProperties;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

public class MainPanel extends JPanel {
    public DataPanel leftPanel, rightPanel;
    public ButtonBar buttonBar;

    public MainPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        leftPanel = new DataPanel(Path.of(DefaultProperties.DefaultPath));
        rightPanel = new DataPanel(Path.of(DefaultProperties.DefaultPath));

        panel.add(leftPanel);
        panel.add(rightPanel);

        buttonBar = new ButtonBar();

        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
        this.add(buttonBar, BorderLayout.SOUTH);
    }
}
