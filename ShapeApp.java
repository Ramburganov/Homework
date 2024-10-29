// Интерфейс Фигура
interface Фигура {
    double периметр();
    double площадь();
    String цветЗаливки();
    String цветГраницы();
}

// Класс Круг
class Круг implements Фигура {
    private double радиус;
    private String цветЗаливки;
    private String цветГраницы;

    public Круг(double радиус, String цветЗаливки, String цветГраницы) {
        this.радиус = радиус;
        this.цветЗаливки = цветЗаливки;
        this.цветГраницы = цветГраницы;
    }

    @Override
    public double периметр() {
        return 2 * Math.PI * радиус;
    }

    @Override
    public double площадь() {
        return Math.PI * радиус * радиус;
    }

    @Override
    public String цветЗаливки() {
        return цветЗаливки;
    }

    @Override
    public String цветГраницы() {
        return цветГраницы;
    }
}

// Класс Прямоугольник
class Прямоугольник implements Фигура {
    private double ширина;
    private double высота;
    private String цветЗаливки;
    private String цветГраницы;

    public Прямоугольник(double ширина, double высота, String цветЗаливки, String цветГраницы) {
        this.ширина = ширина;
        this.высота = высота;
        this.цветЗаливки = цветЗаливки;
        this.цветГраницы = цветГраницы;
    }

    @Override
    public double периметр() {
        return 2 * (ширина + высота);
    }

    @Override
    public double площадь() {
        return ширина * высота;
    }

    @Override
    public String цветЗаливки() {
        return цветЗаливки;
    }

    @Override
    public String цветГраницы() {
        return цветГраницы;
    }
}

// Класс Треугольник
class Треугольник implements Фигура {
    private double a, b, c;
    private String цветЗаливки;
    private String цветГраницы;

    public Треугольник(double a, double b, double c, String цветЗаливки, String цветГраницы) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.цветЗаливки = цветЗаливки;
        this.цветГраницы = цветГраницы;
    }

    @Override
    public double периметр() {
        return a + b + c;
    }

    @Override
    public double площадь() {
        double s = периметр() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String цветЗаливки() {
        return цветЗаливки;
    }

    @Override
    public String цветГраницы() {
        return цветГраницы;
    }
}

// Основной класс для второго задания
public class ShapeApp {
    public static void main(String[] args) {
        Фигура круг = new Круг(5, "Красный", "Черный");
        Фигура прямоугольник = new Прямоугольник(4, 6, "Синий", "Зеленый");
        Фигура треугольник = new Треугольник(3, 4, 5, "Желтый", "Коричневый");

        Фигура[] фигуры = { круг, прямоугольник, треугольник };

        for (Фигура фигура : фигуры) {
            System.out.println("Фигура: " + фигура.getClass().getSimpleName());
            System.out.println("Периметр: " + фигура.периметр());
            System.out.println("Площадь: " + фигура.площадь());
            System.out.println("Цвет заливки: " + фигура.цветЗаливки());
            System.out.println("Цвет границы: " + фигура.цветГраницы());
            System.out.println();
        }
    }
}
