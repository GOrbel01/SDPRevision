package javatests;

/**
 * Created by Cloud on 12/05/2015.
 */
public class ATest {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal h = (Animal) a;
        h.eat();
    }
}
