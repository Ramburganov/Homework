public abstract class Animal {
    private static int count = 0;

    public Animal() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
