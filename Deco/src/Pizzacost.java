
public class Pizzacost {
    public static void main(String[] args) {
        // chicken- 2000, veg-1800, peppo-2400
        // cheese-500, coke -200, jalapeno-300

        // to get final cost of a cheese chicken pizza with jalapeno and coke
        ChickenPizza chickenPizza = new ChickenPizza();
        Pizza mypizza = new addCheese(new addCoke(new addJalapeno(chickenPizza)));
        System.out.println(mypizza.getPrice());// 3000

        Pizza myypizza = new addCheese(new addCoke(new addJalapeno(new VegPizza())));
        System.out.println(myypizza.getPrice());// 2800
    }
}

interface Pizza {
    double getPrice();
}

class ChickenPizza implements Pizza {

    @Override
    public double getPrice() {
        return 2000;
    }

}

class VegPizza implements Pizza {

    @Override
    public double getPrice() {
        return 1800;
    }

}

class PepPizza implements Pizza {

    @Override
    public double getPrice() {
        return 2400;
    }

}

abstract class PizzaAdditions implements Pizza {
    Pizza bakedPizza;

    // final Pizza bakedPizza;

    PizzaAdditions(Pizza bakedPizza) {
        this.bakedPizza = bakedPizza;
    }

    // @Override
    // public double getPrice(){
    // bakedPizza.getPrice();
    // }
}

class addCheese extends PizzaAdditions {

    addCheese(Pizza bakedPizza) {
        super(bakedPizza);
    }

    @Override
    public double getPrice() {
        // double price = bakedPizza.getPrice();
        // double add = addCheesecost(bakedPizza);
        // double finalprice = price + add;
        // return finalprice;
        return bakedPizza.getPrice() + 500;
    }

    // private double addCheesecost(Pizza bakedPizzae) {
    // return 500;
    // }
}

class addCoke extends PizzaAdditions {

    addCoke(Pizza bakedPizza) {
        super(bakedPizza); // a must to address superclass
    }

    @Override
    public double getPrice() {
        return bakedPizza.getPrice() + 200;
    }
}

class addJalapeno extends PizzaAdditions {

    addJalapeno(Pizza bakedPizza) {
        super(bakedPizza);
    }

    @Override
    public double getPrice() {
        return bakedPizza.getPrice() + 300;
    }
}
