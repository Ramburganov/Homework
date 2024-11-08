import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        // Шаг 1: Создаем список слов
        List<String> words = Arrays.asList(
                "apple", "banana", "orange", "apple", "banana", "kiwi", "grape",
                "orange", "kiwi", "banana", "apple"
        );

        // Шаг 2: Используем HashMap для подсчета частоты каждого слова
        Map<String, Integer> wordCount = new HashMap<>();

        // Шаг 3: Подсчитываем количество каждого слова
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Шаг 4: Выводим уникальные слова и их количество
        System.out.println("Unique words and their counts:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
