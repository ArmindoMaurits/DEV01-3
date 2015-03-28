package opdracht1;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Armindo on 20-2-2015.
 */
public class Driver {

    private Telefoonboek telefoonboek;
    private Scanner scanner;
	private String csvPath = "data/telefoonboek.csv"

    public static void main(String[] args) {
        new Driver();
    }

    public Driver() {
        scanner = new Scanner(System.in);
        telefoonboek = new Telefoonboek();
        fillTelefoonboek();
        while(true){
            System.out.println("Wil je iemand zoeken? Y/N");
            String antwoord = scanner.next();
            if(antwoord.toUpperCase().equals("Y")) {

                int state = askQuestion();
                switch (state) {
                    case 1:
                        findPersoon(Persoon.VOORNAAM);
                        break;
                    case 2:
                        findPersoon(Persoon.ACHTERNAAM);
                        break;
                    case 3:
                        findPersoon(Persoon.TELEFOONNUMMER);
                        break;
                    case 4:
                        telefoonboek.printAll();
                    default:
                        System.out.println("Verkeerde input je hebt " + state + " ingevoerd");
                        break;
                }
            }else{
                break;
            }
        }

    }
    public void findPersoon(String key){
        System.out.println("Wie wil je vinden?");
        String value = scanner.next();
        telefoonboek.printPersonen(key,value);
    }

    public int askQuestion(){
        System.out.println("Waarop wil je iemand zoeken?");
        System.out.println("1 voor voornaam - 2 voor achternaam - 3 voor telefoonnummer - 4 om iedereen te zien4");
        int selectie = scanner.nextInt();
        return selectie;
    }
    public void fillTelefoonboek() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvPath));
            String persoon = reader.readLine();
            while(persoon != null){
                String[] attributen = persoon.split(",");
                telefoonboek.addPersoon(new Persoon(attributen[0],attributen[1],attributen[2]));
                persoon = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
