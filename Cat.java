public class Cat extends Animal {
    private static int count = 0;
    private boolean isFull;
    private static int foodInBowl;

    public Cat() {
        count++;
        isFull = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Cat ran " + distance + " meters.");
        } else {
            System.out.println("Cat can't run more than 200 meters.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cat can't swim.");
    }

    public void eat(int portion) {
        if (portion <= foodInBowl) {
            foodInBowl -= portion;
            isFull = true;
            System.out.println("Cat ate.");
        } else {
            System.out.println("Not enough food in the bowl.");
        }
    }

    public static void addFood(int amount) {
        foodInBowl += amount;
        System.out.println(amount + " food added to the bowl.");
    }

    public static int getCount() {
        return count;
    }

    public boolean isFull() {
        return isFull;
    }
}
