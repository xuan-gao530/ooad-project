package cars;

public class gps extends optiondecorator {

    public gps(Cars car, int amount) {
        super(car, amount);
    }

    public String getDescription(){         //getDescription is already implemented for us
        return car.getDescription()+"  +"+ amount+"GPS module";
    }
    public double cost(int nightnum){
        return car.cost(nightnum)+15.0*amount;
    }
}
