package cars;

public class radio extends optiondecorator {

    public radio(Cars car, int amount) {
        super(car, amount);
    }
    public String getDescription(){         //getDescription is already implemented for us
        return car.getDescription()+"  +"+amount+"satellite radio package";
    }
    public double cost(int nightnum){
        return car.cost(nightnum)+5.0*amount;
    }
}
