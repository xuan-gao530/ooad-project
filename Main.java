import java.awt.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[18];
        //instantiate the objects
        Hippo Henry = new Hippo("Henry", "Hippo");
        animals[0] = Henry;
        Hippo Harry = new Hippo("Harry", "Hippo");
        animals[1] = Harry;
        Elephant Eaton = new Elephant("Eaton", "Elephant");
        animals[2] = Eaton;
        Elephant Edith = new Elephant("Edith", "Elephant");
        animals[3] = Edith;
        Rhino Ross = new Rhino("Ross", "Rhino");
        animals[4] = Ross;
        Rhino Rachel = new Rhino("Rachel", "Rhino");
        animals[5] = Rachel;
        Tiger Tom = new Tiger("Tom", "Tiger");
        animals[6] = Tom;
        Tiger Taylor = new Tiger("Taylor", "Tiger");
        animals[7] = Taylor;
        Lion Lora = new Lion("Lora", "Lion");
        animals[8] = Lora;
        Lion Leon = new Lion("Leon", "Lion");
        animals[9] = Leon;
        Cat Carl = new Cat("Carl", "Cat");
        animals[10] = Carl;
        Cat Chris = new Cat("Chris", "Cat");
        animals[11] = Chris;
        Wolf West = new Wolf("West", "Wolf");
        animals[12] = West;
        Wolf Wendy = new Wolf("Wendy", "Wolf");
        animals[13] = Wendy;
        Dog David = new Dog("David", "Dog");
        animals[14] = David;
        Dog Darcy = new Dog("Darcy", "Dog");
        animals[15] = Darcy;
        Dog Dolly = new Dog("Dolly", "Dog");
        animals[16] = Dolly;
        Dog Dove = new Dog("Dove", "Dog");
        animals[17] = Dove;
        //ZooKeeper: execute each of his responsibilities
        ZooKeeper z = new ZooKeeper(animals);   //attain the animals object
        FileOutputStream bos = null;            //output the result of println
        try {
            bos = new FileOutputStream("dayatthezoo.out");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(new PrintStream(bos));
        // execute responsibilities in order
        z.wakeup();                             //wake up the animals
        z.rollcall();                           //roll call the animals
        z.feed();                               //feed the animals
        z.exercise();                           //exercise the animals
        z.shutdown();                           //shut down the zoo

    }

}
