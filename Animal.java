public class Animal {
    String name ;
    String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void r2wakeup() {
        System.out.println(this.name+ "  " +this.type+" wakeup");
    }
    public void r2call() {
        System.out.println(this.name+"  " +this.type+" make noise");
    }
    public void r2feed() {
        System.out.println(this.name+"  " +this.type+" eat");
    }
    public void r2exercise() {
        System.out.println(this.name+"  "+this.type+" run");
    }
    public void r2shutdown() {
        System.out.println(this.name+"  " +this.type+" sleep");
    }
}
