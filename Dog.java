import java.util.Random;

public class Dog extends Canine {
    String[] r2shutdown = {"sleep", "run", "hiss"};   // three response to shutdown
    Random random = new Random();                     // create random object
    public Dog(String name, String type) {
        super(name, type);
    }   //constructor
    public void r2shutdown() {
        int r2shutdownCounter = random.nextInt(3);        // random 0,1,2
        String item = this.r2shutdown[r2shutdownCounter];
        System.out.println(this.name+"  "+this.type +" "+ item);   //alternative responses to animal actions
    }

}
