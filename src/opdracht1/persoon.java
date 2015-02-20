package opdracht1;

import java.util.HashMap;

/**
 * Created by Armindo on 20-2-2015.
 */
public class Persoon {
    public static final String VOORNAAM = "voornaam";
    public static final String ACHTERNAAM = "achternaam";
    public static final String TELEFOONNUMMER = "telefoonnummer";
    HashMap<String,String> attributen;

    public Persoon(String voornaam, String achternaam, String telefoonnummer) {
        attributen = new HashMap<String, String>();
        attributen.put(VOORNAAM, voornaam);
        attributen.put(ACHTERNAAM, achternaam);
        attributen.put(TELEFOONNUMMER, telefoonnummer);
    }
    public String getAttribuut(String key){
        return attributen.get(key);
    }

    @Override
    public String toString() {
        return  "Voornaam: " + attributen.get("voornaam") + "\n" +
                "Achternaam: " + attributen.get("achternaam")+ "\n" +
                "Telefoonnummer: " + attributen.get("telefoonnummer") + "\n"
                ;
    }
}
