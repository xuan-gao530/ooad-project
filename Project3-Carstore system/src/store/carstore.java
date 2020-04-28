package store;
import cars.*;
import customer.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class carstore implements Subject{
    Random rand = new Random();
    processdata pd = new processdata();
    List<Cars> carlist = pd.createcarl();
    ArrayList<String> carlistprint = new ArrayList<>();
    List<Customer> customerlist = pd.createcustomerl();
    List<Customer> activecustomer = new ArrayList<>();
    List<List<Object>> activerentals = new ArrayList<>();
    List<List<Object>> completerentals = new ArrayList<>();
    List<Integer> activecarPerCustomer = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    double dailyincome = 0;
    double totalincome = 0;
    int date;

    //Observer Subject setting
    private ArrayList observers;                    // add an arrayList to hold the observer

    private List<List<Object>>comrental =new ArrayList<>();
    private List<List<Object>> actrental =new ArrayList<>();
    private List<String> leftcarlist = new ArrayList<>();

    public carstore(){
        observers = new ArrayList();              // we create arraylist in the constructor,which has list funciton
    }

    public void registerObserver(Observer o){
        observers.add(o);                          // we add new observer to the end of list
    }
    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);                    //When an observer in the list want to un-register, take it off
        }
    }

    public void notifyObservers(){
        for(int i =0;i<observers.size();i++){              //tell all the observers about the state
            Observer observer = (Observer)observers.get(i);
            observer.update(comrental,actrental,leftcarlist,date,dailyincome);   //we know they all implement updata()
        }
    }
    public void simcarstore() {
        for (date = 1; date < 36; date++) {
            /* New day: return the car
             */
            List<Object> removelist = new ArrayList<>();
            for (List<Object> ar : activerentals) {
                int returnday = (int) ar.get(0) + (int) ar.get(1);
                int returncarnum = (int) ar.get(3);
                if (returnday == date) {
                    List<Cars> renewcarlist = pd.dwrenewcar(ar, returncarnum);
                    carlist.addAll(renewcarlist);
                    Customer newcus = (Customer) ar.get(2);
                    int cid = customerlist.indexOf(newcus);
                    int prerentcarnum = activecarPerCustomer.get(cid);
                    if ((newcus.getCustomercarlimit() == prerentcarnum) && !activecustomer.contains(newcus)) {     //customer limit == prerentcarnum,after return move the customer to adctivelist
                        activecustomer.add(newcus);
                    }
                    activecarPerCustomer.set(cid, prerentcarnum - returncarnum); //update the validlist
                    completerentals.add(ar);    // add complete record
                    removelist.add(ar);
                }
            }
            for (int p = 0; p < removelist.size(); p++) {
                activerentals.remove(removelist.get(p));
            }


            /*new day print things

             */
            //1) print the completerentals
            List<List<Object>> completerentalsprint = new ArrayList<>();
            for (List<Object> cp : completerentals) {
                int carnn = (int) cp.get(3);
                Customer cs = (Customer) cp.get(2);
                int days = (int) cp.get(1);
                double fee = (double) cp.get(4);
                List<Object> rentalinfo = new ArrayList<>();
                rentalinfo.add(cs.getCustomerName());
                rentalinfo.add(cp.get(0));
                rentalinfo.add(days);
                rentalinfo.add(fee);
                for (int j = 0; j < carnn; j++) {
                    Cars cc = (Cars) (cp.get(5 + j));
                    rentalinfo.add(cc.getDescription());
                }
                completerentalsprint.addAll(Arrays.asList(rentalinfo));
            }
            comrental = completerentalsprint;
            //2)print activerental list
            List<List<Object>> activerentalprint = new ArrayList<>();
            for (List<Object> cp : activerentals) {
                int carnn = (int) cp.get(3);
                Customer cs = (Customer) cp.get(2);
                List<Object> carinfo = new ArrayList<>();
                carinfo.add(cs.getCustomerName());
                for (int j = 0; j < carnn; j++) {
                    Cars cc = (Cars) (cp.get(5 + j));
                    carinfo.add(cc.getcategory());
                    carinfo.add(cc.getLicense());
                }
                activerentalprint.addAll(Arrays.asList(carinfo));
            }
            actrental = activerentalprint;
            //3) print the left car in the store
            List<String> carli = new ArrayList<>();
            for (Cars s : carlist) {
                carli.add(s.getDescription());
            }
            leftcarlist = carli;
            //observer output
            notifyObservers();
            //4) Compute  the total income
            totalincome += dailyincome;



            /* New day: rent the car
             */

            for (int k = 0; k < activecarPerCustomer.size(); k++) {
                Customer cc = customerlist.get(k);
                if ((activecarPerCustomer.get(k) < cc.getCustomercarlimit()) && !activecustomer.contains(cc)) {
                    activecustomer.add(cc);
                }
                if(cc.getCustomerType()=="Business"&& carlist.size()<3){
                    activecustomer.remove(cc);
                }
            }
            int customernum = rand.nextInt(activecustomer.size());
            dailyincome = 0;
            if(carlist.size()==0){
                System.out.println("There is no car to rent");
            }
            List<Integer> cidlist = new ArrayList<>(Arrays.asList(20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20));
            while (customernum != 0 && carlist.size() >0 ) {
                customernum = customernum - 1;
                int cid = (int) (activecustomer.size() * Math.random());
                while(cidlist.contains(cid)){
                    cid = (int) (activecustomer.size() * Math.random());
                }
                cidlist.set(cid,cid);
                Customer c = activecustomer.get(cid);
                if (c.getCustomercarlimit() > activecarPerCustomer.get(cid))    //the number of valid car still < limit
                {
                    int prerentcarnum = activecarPerCustomer.get(cid);
                    int validcarnum = c.getCustomercarlimit() - prerentcarnum;
                    List<Object> rentalrecords = pd.dwrentcar(c, date, carlist, validcarnum);
                    int carnum = (int) rentalrecords.get(3);
                    activecarPerCustomer.set(cid, carnum + prerentcarnum);
                    dailyincome += (double) rentalrecords.get(4);
                    activerentals.addAll(Arrays.asList(rentalrecords));
                    for (int j = 0; j < carnum; j++) {
                        Cars cc = (Cars) (rentalrecords.get(5 + j));
                    }
                }

            }
            for (int k = 0; k < activecarPerCustomer.size(); k++) {
                Customer cc = customerlist.get(k);
                if (activecarPerCustomer.get(k) == cc.getCustomercarlimit()) {
                    activecustomer.remove(cc);
                }
            }
        }
        int businessnum = 0;
        int regularnum = 0;
        int casualnum = 0;
        for (List<Object> cpo : completerentals) {
            Customer cn = (Customer) cpo.get(2);
            if (cn.getCustomerType() == "Business") {
                businessnum += 1;
            } else if (cn.getCustomerType() == "Regular") {
                regularnum += 1;
            } else if (cn.getCustomerType() == "Casual") {
                casualnum += 1;
            }
        }
        System.out.println("**************************************************************************");
        System.out.println("The total completed rentals is " + (businessnum + regularnum + casualnum));
        System.out.println("The completed rentals by type: Business " + businessnum);
        System.out.println("The completed rentals by type: Regular " + regularnum);
        System.out.println("The completed rentals by type: Casual " + casualnum);
        System.out.println("The total income is: " + totalincome);
    }
}


