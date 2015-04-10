package opdracht2;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import opdracht2.Persoon;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by Armindo on 29-Mar-15.
 */
public class Window{
    private Persoon[] personen;
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;
    private JList<opdracht2.Persoon> list;
    private JLabel imageLabel;

    public static void main(String[] args) {
        new Window().start();
    }

    public void start() {
        frame = new JFrame("Known pioneers");
        frame.setVisible(true);
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);
        panel.setSize(1500, 800);

        leesPersonenIn();
        list = new JList<opdracht2.Persoon>();
        list.setListData(personen);

        panel.add(list, BorderLayout.WEST);
        imageLabel = new JLabel();
        imageLabel.setSize(200,200);
        panel.add(imageLabel, BorderLayout.EAST);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateImage(list.getSelectedValue());
            }
        });

        frame.add(panel);
        frame.validate();
    }
    private void updateImage(Persoon persoon){
        try {
            Image img = ImageIO.read(new File("./data/pictures/" + persoon.getImgPath()));
            imageLabel.setIcon(new ImageIcon(img.getScaledInstance(500, 500,0)));
            imageLabel.updateUI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leesPersonenIn() {
        String fileToParse = "./data/pioneers.csv";
        BufferedReader fileReader = null;
        final String DELIMITER = ",";

        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileToParse));
            personen = new Persoon[1];
            while ((line = fileReader.readLine()) != null)
            {
                String[] tokens = line.split(DELIMITER);
                Persoon[] temp = personen;
                personen = new Persoon[personen.length+1];
                for(int i=0; i<temp.length;i++){
                    personen[i] = temp[i];
                }
                personen[personen.length-1] = new opdracht2.Persoon(tokens[0],tokens[1],tokens[2],tokens[0] + ".png");

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
