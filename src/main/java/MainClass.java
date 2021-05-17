import gui.DataPanel;
import gui.MainPanel;
import properties.DefaultProperties;

import javax.swing.*;
import java.nio.file.Path;

public class MainClass {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new MainPanel());
        window.pack();
        window.show();
    }
}
