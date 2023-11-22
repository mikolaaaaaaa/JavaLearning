package com.mikola.java_learn_api.client;

public class MockChatGptClient {
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String FEEDBACK = "1)Использование Магических Чисел:\n" +
            "В коде есть магическое число 100, которое используется при генерации случайных чисел. Желательно вынести его в отдельную константу с понятным именем.\n" +
            "\n" +
            "2) Вывод Результата в Отдельные Методы:\n" +
            "Можно выделить логику заполнения массива, нахождения минимального, максимального и среднего значений в отдельные методы. Это сделает код более читаемым и поддерживаемым.\n" +
            "\n" +
            "3) Использование Метода Arrays.stream:\n" +
            "Вместо циклов можно воспользоваться методами Arrays.stream для нахождения минимального, максимального и среднего значений.";

    public static String executeQuery(String prompt) {
       return FEEDBACK;
    }
}
