package customer;

public class Business extends Customer {

    public Business(String type, String name) {
        super(type, name);
        this.carlimit =3;
    }

    public String getCustomerType() {
        return "Business";
    }
    public int RestrictCarNum(Customer c, int validcarnum) {
        return 3;
    }
    public int RestrictRentNight(Customer c) {
        return 7;
        }
    }

