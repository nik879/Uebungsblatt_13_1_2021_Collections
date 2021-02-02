package Beispiel_2;

import java.util.ArrayList;

public class Wassserstandsmanager {

    private ArrayList<Wasserstand> wasserstände = new ArrayList<>();

    public void add(Wasserstand wasserstand) {
        wasserstände.add(wasserstand);
    }

    public Wasserstand findByid(int id) {
        for (Wasserstand w :
                wasserstände) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public ArrayList<Wasserstand> findAllbyGewässer(String gewaesserName) {
        ArrayList<Wasserstand> found = new ArrayList<>();
        for (Wasserstand w :
                wasserstände) {
            if (w.getGewässername().equals(gewaesserName)) {
                found.add(w);
            }
        }
        return found;
    }

    public Wasserstand findNewestWasserstandforGewässer(String gewaesserName) {
        double neusterStand=0;
        Wasserstand neusterWasserstand=null;
        for (Wasserstand w :
                wasserstände) {
            if (w.getGewässername().equals(gewaesserName)) {
                if (w.getZeitpunkt() > neusterStand) {
                    neusterStand = w.getZeitpunkt();
                    neusterWasserstand=w;
                }
            }
        }
        return neusterWasserstand;
    }
    public Wasserstand findOldestWasserstandforGewässer(String gewaesserName) {
        double neusterStand=Double.MAX_VALUE;
        Wasserstand neusterWasserstand=null;
        for (Wasserstand w :
                wasserstände) {
            if (w.getGewässername().equals(gewaesserName)) {
                if (w.getZeitpunkt() < neusterStand) {
                    neusterStand = w.getZeitpunkt();
                    neusterWasserstand=w;
                }
            }
        }
        return neusterWasserstand;
    }

    public ArrayList<Wasserstand> findForAlarmierung() {
        ArrayList<Wasserstand> Alarm = new ArrayList<>();
        for (Wasserstand w :
                wasserstände) {
            if (w.getMesswert() >= w.getMesswerfüralarmierung()) {
                Alarm.add(w);
            }
        }
        return Alarm;
    }

    public ArrayList<Wasserstand> findByZeitspanne(int von, int bis, String gewaesserName) {
        ArrayList<Wasserstand> InZeitspanne = new ArrayList<>();
        for (Wasserstand w :
                wasserstände) {
            if (w.getZeitpunkt() >= von && w.getZeitpunkt() <= bis && w.getGewässername().equals(gewaesserName)) {
                InZeitspanne.add(w);
            }
        }
        return InZeitspanne;
    }



}
