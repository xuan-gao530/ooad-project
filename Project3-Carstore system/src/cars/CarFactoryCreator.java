package cars;

public class CarFactoryCreator extends CarFactory{
    public Cars createCar(String category, String license) {
        if (category.equals("Economy")) {
            return new Economy(license);
        } else if (category.equals("Standard")) {
            return new Standard (license);
        } else if (category.equals("Luxury")) {
            return new Luxury(license);
        } else if (category.equals("Suv")) {
            return new Suv (license);
        } else if (category.equals("Minivan")) {
            return new Minivan (license);
        }
        return null;
    }
}
