import java.util.*;

public class PhoneBook {
    // Храним фамилии и номера телефонов в HashMap
    private Map<String, List<String>> phoneBook = new HashMap<>();

    // Метод для добавления записи в справочник
    public void add(String lastName, String phoneNumber) {
        // Если фамилия уже есть в справочнике, добавляем новый номер
        phoneBook.putIfAbsent(lastName, new ArrayList<>());
        phoneBook.get(lastName).add(phoneNumber);
    }

    // Метод для получения всех номеров по фамилии
    public List<String> get(String lastName) {
        // Возвращаем список номеров по фамилии или сообщение, если фамилия не найдена
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }

    public static void main(String[] args) {
        // Создаем объект телефонного справочника
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи
        phoneBook.add("Ivanov", "123-456-789");
        phoneBook.add("Petrov", "987-654-321");
        phoneBook.add("Ivanov", "111-222-333");
        phoneBook.add("Sidorov", "555-666-777");

        // Ищем номера по фамилии
        System.out.println("Ivanov: " + phoneBook.get("Ivanov")); // [123-456-789, 111-222-333]
        System.out.println("Petrov: " + phoneBook.get("Petrov")); // [987-654-321]
        System.out.println("Sidorov: " + phoneBook.get("Sidorov")); // [555-666-777]
        System.out.println("Kozlov: " + phoneBook.get("Kozlov")); // []
    }
}
