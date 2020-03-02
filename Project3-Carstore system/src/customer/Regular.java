package customer;

public class Regular extends Customer{

    public Regular(String type, String name) {
        super(type, name);
        this.carlimit = 3;
    }

    public String getCustomerType() {
        return "Regular";
    }

    public int RestrictCarNum(Customer c, int validcarnum) {
        return (int)(Math.random()*validcarnum+1);
        }
    public int RestrictRentNight(Customer c) {
        return (int)(3.0 * Math.random()) + 3;
    }
}

