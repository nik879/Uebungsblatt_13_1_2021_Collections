package Beispiel_2;

import java.util.ArrayList;
import java.util.HashMap;

public class DemoWasserstandsmanager {
    public static void main(String[] args) {
        Wasserstand rötz = new Wasserstand(1001, 40000, "Reingewässer", 80, 170);
        Wasserstand sternhaussiedlung = new Wasserstand(1234, 30000, "Reingewässer", 130, 200);
        Wasserstand baumschulweg = new Wasserstand(000, 6000, "Baumschulweg", 670, 300);
        Wassserstandsmanager wm = new Wassserstandsmanager();
        wm.add(rötz);
        wm.add(sternhaussiedlung);
        wm.add(baumschulweg);
        System.out.println("findbyID = " + wm.findByid(1001));
        System.out.println("findAllbyGewässer = " + wm.findAllbyGewässer("Reingewässer"));
        System.out.println(
        wm.findNewestWasserstandforGewässer("Reingewässer"));
        System.out.println(wm.findOldestWasserstandforGewässer("Reingewässer"));
        System.out.println(wm.findForAlarmierung());
        System.out.println(wm.findByZeitspanne(10, 30000, "Reingewässer"));
        System.out.println("-------------------------------------------");

        HashMap<String, ArrayList<Wasserstand>> test = wm.getAllWasserstaenderPerGewaesser();
        System.out.println(test);
        System.out.println("--------------------------");


        HashMap<Integer, ArrayList<Wasserstand>> test2 = wm.getAllWasserstaendePerZeitpunkt();
        System.out.println(test2);
        System.out.println("--------------------------");

        HashMap<String, Integer> test3 = wm.getNumberOfAlarmsPerGewaesser();
        System.out.println(test3);
        System.out.println("----------------------------");

        HashMap<String,Double> test4 = wm.getAvgMesswertPerGewaesser();
        System.out.println(test4);
    }
}
