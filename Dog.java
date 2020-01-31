import java.util.Random;

public class Dog extends Canine {
    String[] r2shutdown = {"sleep", "run", "hiss"};
    Random random = new Random();
    public Dog(String name, String type) {
        super(name, type);
    }
    public void r2shutdown() {
        int r2shutdownCounter = random.nextInt(3);
        String item = this.r2shutdown[r2shutdownCounter];
        System.out.println(this.name+"  "+this.type +" "+ item);
    }

}
