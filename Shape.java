interface Shape {
    double perimeter();
    double area();
    String fillColor();
    String borderColor();

    // Default implementation
    default void printInfo() {
        System.out.println("Shape Information:");
        System.out.println("Perimeter: " + perimeter());
        System.out.println("Area: " + area());
        System.out.println("Fill Color: " + fillColor());
        System.out.println("Border Color: " + borderColor());
    }
}
