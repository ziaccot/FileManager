package gui;

import properties.ButtonProperties;

import javax.swing.*;
import java.awt.*;

public class ButtonBar extends JPanel {
    public JButton btnCopy;
    public JButton btnMove;
    public JButton btnMkDir;
    public JButton btnDelete;

    public ButtonBar(){
        btnCopy = new JButton(ButtonProperties.btnCopy);
        btnMove = new JButton(ButtonProperties.btnMove);
        btnMkDir = new JButton(ButtonProperties.btnMkDir);
        btnDelete = new JButton(ButtonProperties.btnDelete);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(btnCopy);
        this.add(btnMove);
        this.add(btnMkDir);
        this.add(btnDelete);
    }
}
