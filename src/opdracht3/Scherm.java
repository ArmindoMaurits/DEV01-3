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
    public JButton nextButton;
    public JButton prevButton;
    private Image img;
    private JLabel imageLabel;
    private int counter = 1;

    public static void main(String[] args) {
        new Scherm().start();
    }

    public void start() {
        JFrame frame = new JFrame("Kleurenblindheidstest");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(700, 500);

        JPanel panelTop = new JPanel();
        panelTop.setBackground(Color.DARK_GRAY);
        panelTop.setPreferredSize(new Dimension(680,380));

        imageLabel = new JLabel();
        imageLabel.setSize(680, 380);

        try {
            img = ImageIO.read(new File("./data/kleurenblindheidstest/"+ counter + ".jpg"));
            imageLabel.setIcon(new ImageIcon(img.getScaledInstance(680, 315, 0)));
        }catch (IOException e) {
            e.printStackTrace();
        }

        panelTop.add(imageLabel);

        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(Color.DARK_GRAY);

        prevButton = new JButton("Vorige");
        nextButton = new JButton("Volgende");

        imageLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    img = ImageIO.read(new File("./data/kleurenblindheidstest/"+ counter + "_oplossing.jpg"));
                    imageLabel.setIcon(new ImageIcon(img.getScaledInstance(680, 315, 0)));
                    imageLabel.updateUI();
                }catch (IOException f) {
                    f.printStackTrace();
                }
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
                try {
                    counter--;
                    System.out.println(counter);
                    img = ImageIO.read(new File("./data/kleurenblindheidstest/"+ counter + ".jpg"));
                    imageLabel.setIcon(new ImageIcon(img.getScaledInstance(680, 315, 0)));
                    imageLabel.updateUI();
                    enableButtons();
                }catch (IOException f) {
                    f.printStackTrace();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    counter++;
                    System.out.println(counter);
                    img = ImageIO.read(new File("./data/kleurenblindheidstest/"+ counter + ".jpg"));
                    imageLabel.setIcon(new ImageIcon(img.getScaledInstance(680, 315, 0)));
                    imageLabel.updateUI();
                    enableButtons();
                }catch (IOException f) {
                    f.printStackTrace();
                }
            }
        });

        enableButtons();

        panelBottom.add(prevButton, BorderLayout.WEST);
        panelBottom.add(nextButton, BorderLayout.EAST);

        frame.getContentPane().add(panelTop, BorderLayout.PAGE_START);
        frame.getContentPane().add(panelBottom, BorderLayout.CENTER);

        frame.validate();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void enableButtons(){
        if(counter == 1) {
            prevButton.setEnabled(false);
            nextButton.setEnabled(true);
        }else if(counter == 11) {
            nextButton.setEnabled(false);
            prevButton.setEnabled(true);
        } else {
            prevButton.setEnabled(true);
            nextButton.setEnabled(true);
        }
    }
}
