package cars;

public class Minivan extends Cars {
    public Minivan(String license) {
        category = "Minivan";
        this.license =license;
    }
    public double cost(int nightnum) {
        return 70*nightnum;
    }
}