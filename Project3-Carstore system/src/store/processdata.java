package store;
import cars.*;
import customer.*;

import java.util.*;

public class processdata {
    //1) initiate the carlist
        private CarFactory car = new CarFactoryCreator();
        private List<Cars> carlist = new ArrayList<>();
        public List<Cars> createcarl(){
            Cars eco1 = car.createCar("Economy", "Economy001");
            Cars eco2 = car.createCar("Economy", "Economy002");
            Cars eco3 = car.createCar("Economy", "Economy003");
            Cars eco4 = car.createCar("Economy", "Economy004");
            Cars eco5 = car.createCar("Economy", "Economy005");
            Cars eco6 = car.createCar("Economy", "Economy006");

            Cars std1 = car.createCar("Standard", "Standard001");
            Cars std2 = car.createCar("Standard", "Standard002");
            Cars std3 = car.createCar("Standard", "Standard003");
            Cars std4 = car.createCar("Standard", "Standard004");
            Cars std5 = car.createCar("Standard", "Standard005");
            Cars std6 = car.createCar("Standard", "Standard006");
            Cars std7 = car.createCar("Standard", "Standard007");
            Cars std8 = car.createCar("Standard", "Standard008");

            Cars lux1 = car.createCar("Luxury","Luxury001");
            Cars lux2 = car.createCar("Luxury","Luxury002");
            Cars lux3 = car.createCar("Luxury","Luxury003");

            Cars suv1 = car.createCar("Suv","SUV001");
            Cars suv2 = car.createCar("Suv","SUV002");
            Cars suv3 = car.createCar("Suv","SUV003");

            Cars mini1 = car.createCar("Minivan","Mini001");
            Cars mini2 = car.createCar("Minivan","Mini002");
            Cars mini3 = car.createCar("Minivan","Mini003");
            Cars mini4 = car.createCar("Minivan","Mini004");

            carlist.addAll(Arrays.asList(eco1,eco2,eco3,eco4,eco5,eco6,std1,std2,std3,std4,std5,std6,std7,std8,lux1,lux2,lux3,suv1,suv2,suv3,mini1,mini2,mini3,mini4));

       return carlist;
    }

    //2) initiate the customerList
       private CustomerFactory customer = new CustomerFactoryCreator();
       private List<Customer> customerlist = new ArrayList<>();
       public List<Customer> createcustomerl(){
           Customer bs1 = customer.createCustomer("Business","Business01");
           Customer bs2 = customer.createCustomer("Business","Business02");
           Customer bs3 = customer.createCustomer("Business","Business03");

           Customer rg1 = customer.createCustomer("Regular","Regular01");
           Customer rg2 = customer.createCustomer("Regular","Regular02");
           Customer rg3 = customer.createCustomer("Regular","Regular03");
           Customer rg4 = customer.createCustomer("Regular","Regular04");

           Customer cs1 = customer.createCustomer("Casual","Casual01");
           Customer cs2 = customer.createCustomer("Casual","Casual02");
           Customer cs3 = customer.createCustomer("Casual","Casual03");
           Customer cs4 = customer.createCustomer("Casual","Casual04");
           Customer cs5 = customer.createCustomer("Casual","Casual05");

           customerlist.addAll(Arrays.asList(bs1,bs2,bs3,rg1,rg2,rg3,rg4,cs1,cs2,cs3,cs4,cs5));
           return customerlist;
       }

   //3) deal with each customer's request of renting cars
       private List<Integer> rentalinfo;     //customer's rental information
       private List<Object> rentalrecord = new ArrayList<>();
       public List<Object> dwrentcar(Customer c,int date,List<Cars> carlist,int validcarnum){
           rentalrecord = new ArrayList<>();
           rentalinfo = c.rentCars(validcarnum);
           int carnum = rentalinfo.get(0);   //carnum
           int nightnum =rentalinfo.get(1);   //nightnum
           double cost=0;                     // cost for each customer
           List<Cars> tmplist=new ArrayList<>();  // store temp car list

           for(int i = 0;i< carnum;i++){
               int ind=(int)(carlist.size()*Math.random());   // random choose the car
               Cars car = carlist.get(ind);                   // get the car
               carlist.remove(car);                           //remove the car from the carlist
               car = new childseat(car,rentalinfo.get(2+3*i)); //add the child car seat 10
               car = new gps(car,rentalinfo.get(3+3*i));        // add the gps 15
               car = new radio(car,rentalinfo.get(4+3*i));     // add the radio 5
               cost = cost + car.cost(nightnum);               // compute the sum cost
               tmplist.add(car);                               // add the car to tmplist
           }
           rentalrecord.addAll(Arrays.asList(date,nightnum,c,carnum,cost));
           for(Cars ccc: tmplist){
               rentalrecord.add(ccc);
           }
           return rentalrecord;
       }

   //4) deal with return car for each rentalrecord
       private List<Cars> renewcarlist = new ArrayList<>();
       public List<Cars> dwrenewcar(List<Object> ar, int returncarnum) {
           renewcarlist = new ArrayList<>();
           for (int j = 0; j < returncarnum; j++) {
               Cars cc = (Cars) (ar.get(5 + j));
               cc = car.createCar(cc.getcategory(), cc.getLicense());
               renewcarlist.add(cc);
           }
           return renewcarlist;
       }
}


