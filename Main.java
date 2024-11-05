// 1. Создаем исключение для неверного размера массива
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

// 2. Создаем исключение для неверных данных в ячейке массива
class MyArrayDataException extends Exception {
    private int row;
    private int col;

    public MyArrayDataException(String message, int row, int col) {
        super(message);
        this.row = row;
        this.col = col;
    }

    public String getDetails() {
        return "Ошибка в ячейке: [" + row + "][" + col + "]";
    }
}

public class Main {

    // 3. Метод для обработки массива
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверяем размер массива
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4.");
        }

        int sum = 0;

        // Проходим по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Преобразуем строку в число
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Если ошибка преобразования, выбрасываем исключение MyArrayDataException
                    throw new MyArrayDataException("Невозможно преобразовать данные в число.", i, j);
                }
            }
        }

        return sum;
    }

    // 4. Метод main для вызова метода обработки массива и обработки исключений
    public static void main(String[] args) {
        String[][] array = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(array);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage() + " " + e.getDetails());
        }
    }
}
