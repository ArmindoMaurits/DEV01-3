package opdracht2;


import opdracht2.personen.Persoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PersoonLader {
    public static ArrayList<Persoon> personen;
    public PersoonLader(){
        personen = new ArrayList<Persoon>();
        String fileToParse = "./data/pioneers.csv";
        BufferedReader fileReader = null;
        final String DELIMITER = ",";

        try
        {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileToParse));

            while ((line = fileReader.readLine()) != null)
            {
                String[] tokens = line.split(DELIMITER);
                personen.add(new Persoon(tokens[0],tokens[1],tokens[2],"hoi"));
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
    public static void main(String[] args) {
        new PersoonLader();
        System.out.println(PersoonLader.personen.toString());
    }

}
