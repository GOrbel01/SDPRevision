package patterns.abstractfactory;

public final class FactoryProducer {

    private static FactoryProducer instance = new FactoryProducer();

    public FactoryProducer() {

    }

    public static FactoryProducer getInstance() {
        return instance;
    }

    public AbstractFactory createFactory(String type) {
        if (type.equals("Fruit")) {
            return new FruitFactory();
        }
        else {
            return new ColorFactory();
        }
    }
}
