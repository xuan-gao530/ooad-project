package cars;

public class Standard extends Cars {
    public Standard(String license) {
        this.category = "Standard";
        this.license = license;
    }
    public double cost(int nightnum) {
        return 60*nightnum;
    }
}