package patterns.abstractfactory;

import patterns.abstractfactory.objectcode.Color;
import patterns.abstractfactory.objectcode.Fruit;

/**
 * Created by Squall on 15/05/2015.
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        FactoryProducer prod = FactoryProducer.getInstance();

        AbstractFactory fruitFactory = prod.createFactory("Fruit");
        AbstractFactory colorFactory = prod.createFactory("Color");

        Fruit strawberry = fruitFactory.create("Strawberry");
        Fruit banana = fruitFactory.create("Banana");
        Color red = colorFactory.create("Red");
        Color yellow = colorFactory.create("Yellow");
        strawberry.rot();
        banana.rot();
        red.setColor();
        yellow.setColor();
    }
}
