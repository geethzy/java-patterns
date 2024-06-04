interface Shape { // by definiton it is public
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }

}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }

}

abstract class ShapeDecorator implements Shape { // abstract class
    Shape decoratedShape; // either rectangle or a circle

    ShapeDecorator(Shape decoratedShape) { // constructor with parameters to initialize object
        this.decoratedShape = decoratedShape;
    }

    // * thibbath nethath weda *
    // public void draw() {
    // decoratedShape.draw();
    // }
}

class RedShapeDecorator extends ShapeDecorator {

    RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);// to call superclass methods, and to access the superclass constructor.
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border: Red");
    }
}

class BlueShapeDecorator extends ShapeDecorator {

    BlueShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);// to call superclass methods, and to access the superclass constructor.
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setBlueBorder(decoratedShape);
    }

    private void setBlueBorder(Shape decoratedShape) {
        System.out.println("Border: Blue");
    }
}

class DecoratorDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redcircle = new RedShapeDecorator(circle);
        ShapeDecorator bluecircle = new BlueShapeDecorator(circle);
        ShapeDecorator blueredcircle = new BlueShapeDecorator(redcircle); // as it has supertype shape
        redcircle.draw();
        bluecircle.draw();
        blueredcircle.draw();

        System.out.println("************In one line*************");
        Shape oneline = new BlueShapeDecorator(new RedShapeDecorator(new Circle()));
        oneline.draw();
    }
}
