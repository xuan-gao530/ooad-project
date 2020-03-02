package cars;

public class Luxury extends Cars {
        public Luxury(String license) {
            category = "Luxury";
            this.license =license;
        }
        public double cost(int nightnum) {
            return 90*nightnum;
        }
    }
