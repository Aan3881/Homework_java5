// Написать простой класс Телефонный Справочник (с помощью HashMap), который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

package lesson5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Map<String, ArrayList<String>> phoneBook = new HashMap<>();
            while (true) {
                System.out.println("Выберите действие:");
                System.out.println("1. Добавить запись");
                System.out.println("2. Поиск записей по имени");
                System.out.println("3. Выход");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Введите имя: ");
                        String name = scanner.next();

                        System.out.print("Введите номер телефона: ");
                        String phoneNumber = scanner.next();

                        if (phoneBook.containsKey(name)) {

                            phoneBook.get(name).add(phoneNumber);
                        } else {

                            ArrayList<String> numbers = new ArrayList<>();
                            numbers.add(phoneNumber);
                            phoneBook.put(name, numbers);
                        }
                        System.out.println("Запись успешно добавлена");
                        break;
                    case 2:
                        System.out.print("Введите имя для поиска: ");
                        String searchName = scanner.next();

                        if (phoneBook.containsKey(searchName)) {
                            ArrayList<String> numbers = phoneBook.get(searchName);
                            System.out.println("Номера телефонов для " + searchName + ":");
                            for (String number : numbers) {
                                System.out.println(number);
                            }
                        } else {
                            System.out.println("Записи с именем " + searchName + " не найдены");
                        }
                        break;
                    case 3:
                        System.out.println("Выход");
                        System.exit(0);
                    default:
                        System.out.println("Неверный выбор");
                        break;
                }
            }
        }
    }

    public static ArrayList<String> searchRecords(String name, Map<String, ArrayList<String>> phoneBook) {
        ArrayList<String> records = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            if (key.contains(name)) {
                records.addAll(entry.getValue());
            }
        }
        return records;
    }

    @Override
    public String toString() {
        return "task1 []";
    }
}

