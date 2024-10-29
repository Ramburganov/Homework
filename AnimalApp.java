// Базовый класс Животное
class Животное {
    private static int count = 0;

    public Животное() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
        System.out.println("Животное пробежало " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " м.");
    }
}

// Класс Собака
class Собака extends Животное {
    private static int count = 0;

    public Собака() {
        count++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака пробежала " + distance + " м.");
        } else {
            System.out.println("Собака не может пробежать больше 500 м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака проплыла " + distance + " м.");
        } else {
            System.out.println("Собака не может проплыть больше 10 м.");
        }
    }

    public static int getCount() {
        return count;
    }
}

// Класс Кот
class Кот extends Животное {
    private static int count = 0;
    private boolean сытость;
    private static int едаВМиске;

    public Кот() {
        count++;
        сытость = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " м.");
        } else {
            System.out.println("Кот не может пробежать больше 200 м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }

    public void поесть(int порция) {
        if (порция <= едаВМиске) {
            едаВМиске -= порция;
            сытость = true;
            System.out.println("Кот поел.");
        } else {
            System.out.println("Недостаточно еды в миске.");
        }
    }

    public static void добавитьЕду(int количество) {
        едаВМиске += количество;
        System.out.println("В миску добавлено " + количество + " еды.");
    }

    public static int getCount() {
        return count;
    }

    public boolean isСытость() {
        return сытость;
    }
}

// Основной класс для первого задания
public class AnimalApp {
    public static void main(String[] args) {
        Кот[] коты = { new Кот(), new Кот(), new Кот() };
        Собака собака = new Собака();

        Кот.добавитьЕду(30);
        for (Кот кот : коты) {
            кот.поесть(10);
        }

        for (Кот кот : коты) {
            System.out.println("Кот сытый: " + кот.isСытость());
        }

        System.out.println("Всего животных: " + Животное.getCount());
        System.out.println("Всего котов: " + Кот.getCount());
        System.out.println("Всего собак: " + Собака.getCount());
    }
}
