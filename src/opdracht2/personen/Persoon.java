package opdracht2.personen;

/**
 * Created by Wouter on 3/28/2015.
 */
public class Persoon {
    String naam;
    String knownFor;
    String imgPath;
    String birthrange;

    public Persoon(String naam, String birthrange, String knownFor, String imgPath) {
        this.naam = naam;
        this.knownFor = knownFor;
        this.imgPath = imgPath;
        this.birthrange = birthrange;
    }

    public String getNaam() {
        return naam;
    }

    public String getKnownFor() {
        return knownFor;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getBirthrange() {
        return birthrange;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "naam='" + naam + '\'' +
                ", birthrange='" + birthrange + '\'' +
                ", knownFor='" + knownFor + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
