package customer;

public abstract class CustomerFactory {
    public abstract  Customer createCustomer(String type, String name);
}
