public class ZooKeeper {
    Animal[] animals;
    public ZooKeeper(Animal[] animals){
        this.animals = animals;
    }

    public void wakeup() {
        System.out.println("ZooKeeper wake up the animals: ");
        for (int i = 0; i < animals.length; i++) {
            animals[i].r2wakeup();
        }
    }
    public void rollcall() {
        System.out.println("ZooKeeper roll call the animals: ");
        for (int i = 0; i < animals.length; i++) {
            animals[i].r2call();
        }
    }
    public void feed() {
        System.out.println("ZooKeeper feed the animals: ");
        for (int i = 0; i < animals.length; i++) {
            animals[i].r2feed();
        }
    }
    public void exercise() {
        System.out.println("ZooKeeper exercise the animals: ");
        for (int i = 0; i < animals.length; i++) {
            animals[i].r2exercise();
        }
    }
    public void shutdown() {
        System.out.println("ZooKeeper shutdown the zoo: ");
        for (int i = 0; i < animals.length; i++) {
            animals[i].r2shutdown();
        }
    }



}
