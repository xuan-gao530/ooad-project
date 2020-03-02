package customer;

public class CustomerFactoryCreator extends CustomerFactory {
    public Customer createCustomer(String type, String name) {
        switch (type) {
            case "Business":
                return new Business(type,name);
            case "Casual":
                return new Casual(type,name);
            case "Regular":
                return new Regular(type,name);
            default:
                System.out.println("Unknown Customer Type");
                return null;
        }
    }
}
