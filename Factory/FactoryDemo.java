public class FactoryDemo {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();

        Pizza pizza1 = pizzaFactory.orderPizza("chicken");
        pizza1.makePizza();

        Pizza pizza2 = pizzaFactory.orderPizza("veg");
        pizza2.makePizza();

        Pizza pizza3 = pizzaFactory.orderPizza("pep");
        pizza3.makePizza();
    }
}

interface Pizza {
    void makePizza();
}

class Chicken implements Pizza {

    @Override
    public void makePizza() {
        System.out.println("chicken pizza made");
    }

}

class Veg implements Pizza {

    @Override
    public void makePizza() {
        System.out.println("veg pizza made");
    }

}

class Pep implements Pizza {

    @Override
    public void makePizza() {
        System.out.println("pep pizza made");
    }

}

class PizzaFactory {
    public Pizza orderPizza(String pizzaType) {
        if (pizzaType == null) {
            System.out.println("Enter the pizza type");
            return null;
        }
        if (pizzaType.equals("chicken")) {
            return new Chicken();
        } else if (pizzaType.equals("veg")) {
            return new Veg();
        } else if (pizzaType.equals("pep")) {
            return new Pep();
        }
        return null;
    }
}