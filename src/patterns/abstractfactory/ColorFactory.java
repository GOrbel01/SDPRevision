package patterns.abstractfactory;

import patterns.abstractfactory.objectcode.Color;
import patterns.abstractfactory.objectcode.Green;
import patterns.abstractfactory.objectcode.Red;
import patterns.abstractfactory.objectcode.Yellow;

/**
 * Created by Squall on 15/05/2015.
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color create(String color) {
        if (color.equalsIgnoreCase("Red")) {
            return new Red();
        }
        else if (color.equalsIgnoreCase("Green")) {
            return new Green();
        }
        else if (color.equalsIgnoreCase("Yellow")) {
            return new Yellow();
        }
        else {
            System.out.println("Object does not exist");
            return null;
        }
    }
}
