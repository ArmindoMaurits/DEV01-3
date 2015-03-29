package opdracht2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Armindo on 29-Mar-15.
 */
public class Window extends JPanel{

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;

    public Window() {
        gui();
    }

    public void gui() {
        frame = new JFrame("Known pioneers");
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);

        button = new JButton("Test");
        label = new JLabel("test label");

        panel.add(button);
        panel.add(label);

        frame.add(panel);
    }


    public static void main(String[] args) {

        new Window();
    }
}
