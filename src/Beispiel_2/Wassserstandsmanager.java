package Beispiel_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public HashMap<String, ArrayList<Wasserstand>> getAllWasserstaenderPerGewaesser() {
        HashMap<String, ArrayList<Wasserstand>> Hash = new HashMap<>();
        for (Wasserstand w : wasserstände) {
            if (Hash.containsKey(w.getGewässername())) {
                ArrayList<Wasserstand> listewasserstände = Hash.get(w.getGewässername());
                listewasserstände.add(w);
                Hash.put(w.getGewässername(), listewasserstände);
            } else {
                ArrayList<Wasserstand> listewasserstände = new ArrayList<>();
                listewasserstände.add(w);
                Hash.put(w.getGewässername(), listewasserstände);
            }
        }
        return Hash;
    }

    public HashMap<Integer, ArrayList<Wasserstand>> getAllWasserstaendePerZeitpunkt() {
        HashMap<Integer, ArrayList<Wasserstand>> Hash = new HashMap<>();
        for (Wasserstand w : wasserstände) {
            if (Hash.containsKey(w.getZeitpunkt())) {
                ArrayList<Wasserstand> listewasserstände = Hash.get(w.getGewässername());
                listewasserstände.add(w);
                Hash.put(w.getZeitpunkt(), listewasserstände);
            } else {
                ArrayList<Wasserstand> listewasserstände = new ArrayList<>();
                listewasserstände.add(w);
                Hash.put(w.getZeitpunkt(), listewasserstände);
            }
        }
        return Hash;
    }

//    public HashMap<String, Integer> getNumberOfAlarmsPerGewaessser() {
//        HashMap<String, Integer> Hash = new HashMap<>();
//        int anzahl=0;
//        for (Wasserstand w :
//                wasserstände) {
//            if (Hash.containsKey(w.getGewässername())) {
//                if (w.getMesswert() >= w.getMesswerfüralarmierung()) {
//                    anzahl++;
//                    Hash.put(w.getGewässername(), anzahl);
//                }
//            } else {
//                Hash.put(w.getGewässername(), anzahl);
//            }
//        }
//        return Hash;
//    }

    public HashMap<String, Integer> getNumberOfAlarmsPerGewaesser() {
        HashMap<String, Integer> resultMap = new HashMap<>();
        for(Wasserstand w : wasserstände) {
            if(resultMap.containsKey(w.getGewässername())) {
                resultMap.put(
                        w.getGewässername(),
                        resultMap.get(w.getGewässername())+1
                );
            } else {
                resultMap.put(w.getGewässername(),1);
            }
        }
        return resultMap;
    }

    public HashMap<String, Double> getAvgMesswertPerGewaesser() {
        HashMap<String, ArrayList<Wasserstand>> tempMap = new HashMap<>();

        for(Wasserstand w : wasserstände) {
            ArrayList<Wasserstand> wasserstaende;
            if(tempMap.containsKey(w.getGewässername())) {
                wasserstaende = tempMap.get(w.getGewässername());
            } else {
                wasserstaende = new ArrayList<>();
            }
            wasserstaende.add(w);
            tempMap.put(w.getGewässername(),wasserstaende);
        }

        HashMap<String, Double> resultMap = new HashMap<>();
        for(Map.Entry<String,ArrayList<Wasserstand>> e : tempMap.entrySet()) {
            double sum = 0.0;
            for(Wasserstand w : e.getValue()) {
                sum += w.getMesswert();
            }
            resultMap.put(e.getKey(),sum/e.getValue().size());
        }
        return resultMap;

    }




}
