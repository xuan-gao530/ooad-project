package customer;

public class Casual extends Customer{


    public Casual(String type, String name) {
        super(type, name);
        this.carlimit =1;
    }

    public String getCustomerType() {
        return "Casual";
    }
    public int RestrictCarNum(Customer c, int validcarnum) {
        return 1;
    }
    public int RestrictRentNight(Customer c) {
        return (int)(3.0 * Math.random()) + 1;
    }
}
