package patterns.abstractfactory;

import patterns.abstractfactory.objectcode.Apple;
import patterns.abstractfactory.objectcode.Banana;
import patterns.abstractfactory.objectcode.Fruit;
import patterns.abstractfactory.objectcode.Strawberry;

/**
 * Created by Squall on 15/05/2015.
 */
public class FruitFactory extends AbstractFactory {
    @Override
    public Fruit create(String fruit) {
        if (fruit.equalsIgnoreCase("Banana")) {
            return new Banana();
        }
        else if (fruit.equalsIgnoreCase("Strawberry")) {
            return new Strawberry();
        }
        else if (fruit.equalsIgnoreCase("Apple")) {
            return new Apple();
        }
        else {
            System.out.println("Object does not exist");
            return null;
        }
    }
}
