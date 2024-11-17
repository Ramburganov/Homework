public class ArrayProcessor {

    // Метод для обработки массива
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверяем размер массива
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен содержать 4 строки.");
        }

        // Проверяем, что каждая строка массива содержит 4 элемента
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Каждая строка массива должна содержать 4 элемента.");
            }
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
}
