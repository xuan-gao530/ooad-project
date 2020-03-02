package cars;

public class Economy extends Cars {
    public Economy(String license) {
        category = "Economy";
        this.license = license;
    }
    public double cost(int nightnum) {
        return 50*nightnum;
    }
}