package cars;

public class childseat extends optiondecorator {

    public childseat(Cars car, int amount) {
        super(car, amount);
    }

    public String getDescription(){         //getDescription is already implemented for us
        return car.getDescription()+"  +"+amount+"Child car seat";
    }
    public double cost(int nightnum){
        return car.cost(nightnum)+10*amount;
    }
}
