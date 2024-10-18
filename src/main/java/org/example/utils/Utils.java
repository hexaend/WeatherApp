package org.example.utils;

import java.util.HashMap;

public class Utils {
    HashMap<Integer, String> codeToWMO;

    public Utils() {
        codeToWMO = new HashMap<>();
        codeToWMO.put(0, "Чистое небо");
        codeToWMO.put(1, "Преимущественно ясно");
        codeToWMO.put(2, "Переменная облачность");
        codeToWMO.put(3, "Пасмурно");
        codeToWMO.put(45, "Туман");
        codeToWMO.put(48, "Изморозь отложение");
        codeToWMO.put(51, "Морось: Легкая интенсивность");
        codeToWMO.put(53, "Морось: Умеренная интенсивность");
        codeToWMO.put(55, "Морось: Сильная интенсивность");
        codeToWMO.put(56, "Замерзающая морось: Легкая интенсивность");
        codeToWMO.put(57, "Замерзающая морось: Сильная интенсивность");
        codeToWMO.put(61, "Дождь: Легкая интенсивность");
        codeToWMO.put(63, "Дождь: Умеренная интенсивность");
        codeToWMO.put(65, "Дождь: Сильная интенсивность");
        codeToWMO.put(66, "Замерзающий дождь: Легкая интенсивность");
        codeToWMO.put(67, "Замерзающий дождь: Сильная интенсивность");
        codeToWMO.put(71, "Снегопад: Слабая интенсивность");
        codeToWMO.put(73, "Снегопад: Умеренная интенсивность");
        codeToWMO.put(75, "Снегопад: Сильная интенсивность");
        codeToWMO.put(77, "Снежные зерна");
        codeToWMO.put(80, "Ливни: Слабая интенсивность");
        codeToWMO.put(81, "Ливни: Умеренная интенсивность");
        codeToWMO.put(82, "Ливни: Сильная интенсивность");
        codeToWMO.put(85, "Снегопады: Слабые");
        codeToWMO.put(86, "Снегопады: Сильные");
        codeToWMO.put(95, "Гроза: Слабая или умеренная");
        codeToWMO.put(96, "Гроза с градом: Слабая");
        codeToWMO.put(99, "Гроза с градом: Сильная");
    }

    public String getWMOWeatherByCode(int code) {
        return codeToWMO.get(code);
    }

}
