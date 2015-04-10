package opdracht1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Armindo on 20-2-2015.
 */
public class Telefoonboek {
    List<Persoon> personen;
    public Telefoonboek(){
        personen = new ArrayList();
    }

    public void addPersoon(Persoon persoon){
        if(persoon != null){
            personen.add(persoon);
        }
    }

    public void removePersoon(Persoon persoon){
        if(persoon != null){
            personen.remove(persoon);
        }
    }

    public void printPersonen(String key, String value){
        System.out.println(Arrays.toString(findPeople(key, value).toArray()));
    }

    public void printAll(){
        for(Persoon persoon : personen){
            System.out.println(persoon);
        }
    }

    public List<Persoon> findPeople(String key, String value){
        List<Persoon> tempPersonen = new ArrayList();
        for(Persoon persoon : personen){
            if(persoon.getAttribuut(key).toUpperCase().equals(value.toUpperCase())){
                tempPersonen.add(persoon);
            }
        }
        return tempPersonen;
    }

}
