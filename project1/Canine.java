public class Canine extends Animal {
    public Canine(String name, String type) {
        super(name, type);
    }
    //overwrite the r2call
    public void r2call() {
        System.out.println(this.name+"  " +this.type+" bark");
    }
}
