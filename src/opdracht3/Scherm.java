package opdracht3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class Scherm {
    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JLabel imageLabel;
    public JButton nextButton;
    public JButton prevButton;
    private Image img;

    public static void main(String[] args) {
        new Scherm().start();
    }

    public void start() {
        frame = new JFrame("Kleurenblindheidstest");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(700, 500);

        panelTop = new JPanel();
        panelTop.setBackground(Color.DARK_GRAY);
        panelTop.setPreferredSize(new Dimension(680,380));

        imageLabel = new JLabel();
        imageLabel.setSize(680, 380);

        try {
            Image img = ImageIO.read(new File("./data/kleurenblindheidstest/3.jpg"));
            imageLabel.setIcon(new ImageIcon(img.getScaledInstance(680, 315, 0)));
        }catch (IOException e) {
            e.printStackTrace();
        }

        panelTop.add(imageLabel);

        panelBottom = new JPanel();
        panelBottom.setBackground(Color.DARK_GRAY);

        prevButton = new JButton("Vorige");
        nextButton = new JButton("Volgende");

        imageLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("geklikt");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        panelBottom.add(prevButton, BorderLayout.WEST);
        panelBottom.add(nextButton, BorderLayout.EAST);

        frame.getContentPane().add(panelTop, BorderLayout.PAGE_START);
        frame.getContentPane().add(panelBottom, BorderLayout.CENTER);

        frame.validate();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
