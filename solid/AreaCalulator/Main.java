package AreaCalulator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangular(4.0, 6.0);

        List<Shape> shapes = new java.util.ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        double totalArea = 0;

        for(Shape shape : shapes) {
            System.out.println("Area: " + shape.area());
            totalArea += shape.area();
        }
        System.out.println("Total Area: " + totalArea);
    }
}


