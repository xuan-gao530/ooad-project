package store;

public class Main {
    public static void main(String[] args) {
       carstore store = new carstore();
       Printout printout = new Printout(store);
       store.simcarstore();
    }
}
