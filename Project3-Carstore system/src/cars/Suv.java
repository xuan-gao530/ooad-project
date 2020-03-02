package cars;

public class Suv extends Cars {
    public Suv(String license) {
            category = "Suv";
            this.license = license;
        }
        public double cost(int nightnum) {
            return 80*nightnum;
        }
    }