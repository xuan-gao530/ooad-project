package customer;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
    String type;
    String name;
    int    carlimit;

    public Customer(String type,String name) {
        this.type =type;
        this.name = name;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerType() {
        return type;
    }
    public int getCustomercarlimit() {
        return carlimit;
    }

    public abstract int RestrictCarNum(Customer c, int validcarnum);

    public abstract int RestrictRentNight(Customer c);

    public List<Integer> rentCars(int validcarnum) {
        int carsNum = RestrictCarNum(this, validcarnum);
        int nightNum = RestrictRentNight(this);
        List<Integer> rentInfo = new ArrayList<>();
        rentInfo.add(carsNum);
        rentInfo.add(nightNum);

        for (int j = 0; j < carsNum; j++) {
            int childseatNum = (int) (Math.random()*5);    //random choose the number of child car seat{0,1,2,3,4}
            int gpsNum = (int) (Math.random()*2);          //random set the number of gps {0,1}
            int radioNum =(int)(Math.random()*2);          //random set the number of satellite radio package{0,1}
            rentInfo.add(childseatNum);
            rentInfo.add(gpsNum);
            rentInfo.add(radioNum);
        }
        return rentInfo;        //[carnumber,nightnum,eachcaroption]
    }
}






