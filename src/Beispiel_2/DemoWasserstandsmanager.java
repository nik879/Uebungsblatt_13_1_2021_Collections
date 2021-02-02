package Beispiel_2;

public class DemoWasserstandsmanager {
    public static void main(String[] args) {
        Wasserstand rötz = new Wasserstand(1001, 40000, "Reingewässer", 80, 170);
        Wasserstand sternhaussiedlung = new Wasserstand(1234, 30000, "Reingewässer", 200, 200);
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
    }
}
