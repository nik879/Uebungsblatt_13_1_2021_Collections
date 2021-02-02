package Beispiel_2;

public class Wasserstand {
    private int id, zeitpunkt;
    private String gewässername;
    private double messwert, messwerfüralarmierung;

    public Wasserstand(int id, int zeitpunkt, String gewässername, double messwert, double messwerfüralarmierung) {
        this.id = id;
        this.zeitpunkt = zeitpunkt;
        this.gewässername = gewässername;
        this.messwert = messwert;
        this.messwerfüralarmierung = messwerfüralarmierung;
    }

    public int getId() {
        return id;
    }

    public int getZeitpunkt() {
        return zeitpunkt;
    }

    public String getGewässername() {
        return gewässername;
    }

    public double getMesswert() {
        return messwert;
    }

    public double getMesswerfüralarmierung() {
        return messwerfüralarmierung;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setZeitpunkt(int zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }

    public void setGewässername(String gewässername) {
        this.gewässername = gewässername;
    }

    public void setMesswert(double messwert) {
        this.messwert = messwert;
    }

    public void setMesswerfüralarmierung(double messwerfüralarmierung) {
        this.messwerfüralarmierung = messwerfüralarmierung;
    }


    public String toString() {
        return "Wasserstand{" +
                "id=" + id +
                ", zeitpunkt=" + zeitpunkt +
                ", gewässername='" + gewässername + '\'' +
                ", messwert=" + messwert +
                ", messwerfüralarmierung=" + messwerfüralarmierung +
                '}';
    }
}
