public class Wolf extends Canine {
    public Wolf(String name, String type) {
        super(name, type);
    }
    public void r2shutdown() {
        System.out.println(this.name + "  " + this.type + " run");
    }
}
