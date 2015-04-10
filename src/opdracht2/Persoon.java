package opdracht2;

/**
 * Created by Wouter on 3/28/2015.
 */
public class Persoon {
    private String naam;
    private String knownFor;
    private String imgPath;
    private String birthrange;

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
        return naam;
    }
}
