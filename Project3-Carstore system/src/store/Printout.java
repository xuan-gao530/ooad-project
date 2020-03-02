package store;

import java.util.List;

public class Printout implements Observer {
    private Subject carsotre1;
    public Printout(Subject carsotre1){           //pass the weatherdata object
        this.carsotre1 = carsotre1;
        carsotre1.registerObserver(this);                     // use it to register the display as an observer
    }
    public void update(List<List<Object>>comrental, List<List<Object>> actrental,List<String> leftcarlist, int date,double dayincome)
    {
        System.out.println("*********************************************************************************");
        System.out.println("At the begining of the day: "+date);
        //1)print completed rentals record
        System.out.println("Completed rentals record:");
        System.out.println("Count: "+comrental.size());
        System.out.println("Cutomer name,rent day,lease,rental car information");
        for(List<Object> ct:comrental){
            System.out.println(ct);
        }
        System.out.println("" +
                "");

        //2) print all active rentals
        System.out.println("Active rentals record:");
        System.out.println("Count: "+actrental.size());
        System.out.println("Cutomer name:   rental car type& license");
        for(List<Object> at:actrental){
            System.out.println(at);
        }
        System.out.println("" +
                "");
        //3 print all cars left in the store and their license plates
        System.out.println("cars left in the store:");
        System.out.println("Count: "+leftcarlist.size());
        System.out.println("rental car type& license: "+leftcarlist);
        System.out.println("" +
                "");
        //4 print the daily income
        System.out.println("The income of the "+(date-1)+" day: "+dayincome);
        System.out.println("" +
                "" +
                "");
    }
}
