public class AnimalApp {
    public static void main(String[] args) {
        Cat[] cats = { new Cat(), new Cat(), new Cat() };
        Dog dog = new Dog();

        Cat.addFood(30);
        for (Cat cat : cats) {
            cat.eat(10);
        }

        for (Cat cat : cats) {
            System.out.println("Cat full: " + cat.isFull());
        }

        System.out.println("Total animals: " + Animal.getCount());
        System.out.println("Total cats: " + Cat.getCount());
        System.out.println("Total dogs: " + Dog.getCount());
    }
}
