public class Cat extends Feline {
    public Cat(String name, String type) {
        super(name, type);
    }
    public void r2call() {
        System.out.println(this.name + "  " + this.type + " mewmew");
    }
}
