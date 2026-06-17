interface Shape {
    void draw();
}

class Circle implements Shape {

    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {

    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class ShapeFactory {

    public Shape getShape(String type) {

        if(type.equalsIgnoreCase("circle")) {
            return new Circle();
        }

        else if(type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }

        return null;
    }
}

public class FactoryMethodPattern {

    public static void main(String[] args) {

        ShapeFactory factory = new ShapeFactory();

        Shape s1 = factory.getShape("circle");
        s1.draw();

        Shape s2 = factory.getShape("rectangle");
        s2.draw();
    }
}