package cars;

public abstract class optiondecorator extends Cars {
    int amount = 0;
    public Cars car;
    public optiondecorator(Cars car,int amount) {
        this.amount =amount;
        this.car = car;
        category = car.getcategory();
        license = car.getLicense();
    }
    public abstract String getDescription();
    }

