package opdracht2;

import java.io.*;
import java.util.HashMap;

public class ReadCSV {

    public static void main(String[] args) {
        String fileToParse = "D:\\Armindo\\Documenten\\GitHub\\DEV01-3\\src\\opdracht2\\pioneers.csv";
        BufferedReader fileReader = null;
        final String DELIMITER = ",";
        HashMap<String,String> map = new HashMap<String, String>();

        try
        {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileToParse));

            while ((line = fileReader.readLine()) != null)
            {
                String[] tokens = line.split(DELIMITER);
                for (int i = 0; i < tokens.length; i++) {
                    String string = tokens[i];
                    map.put(string,line);
                }
                for(String token : tokens) {
                    System.out.println(token);
                }
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
