public class ShapeApp {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Red", "Black");
        Shape rectangle = new Rectangle(4, 6, "Blue", "Green");
        Shape triangle = new Triangle(3, 4, 5, "Yellow", "Brown");

        Shape[] shapes = { circle, rectangle, triangle };

        for (Shape shape : shapes) {
            shape.printInfo();
            System.out.println();
        }
    }
}