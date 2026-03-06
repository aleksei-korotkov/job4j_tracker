package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Arsentev P.");
        map.put("parsentev@yandex.ru", "Petr Arsentev");

        map.put("iivanov@yandex.ru", "Иванов И.И.");
        map.put("iivanov@yandex.ru", "Иванов Иван Иванович");

        map.put("ppetrov@yandex.ru", "Петрович");
        map.put("ppetrov@yandex.ru", "Петров Пётр");
        map.put("ppetrov@yandex.ru", "Петров Пётр Петрович");

        map.put("asidorov@yandex.ru", "Сидоров Александр");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}