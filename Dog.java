public class Dog extends Animal {
    private static int count = 0;

    public Dog() {
        count++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Dog ran " + distance + " meters.");
        } else {
            System.out.println("Dog can't run more than 500 meters.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Dog swam " + distance + " meters.");
        } else {
            System.out.println("Dog can't swim more than 10 meters.");
        }
    }

    public static int getCount() {
        return count;
    }
}
