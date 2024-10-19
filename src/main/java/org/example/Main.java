package org.example;

import java.io.*;
import java.util.Objects;

import static org.example.api.ApiMain.getWeatherOnTomorrow;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.printf("Добро пожаловать в консольное приложение - Погода на завтра%n");
//        Scanner scanner = new Scanner(System.in);
        while (true) {
            Console console = System.console();
            System.out.print("Введите город: ");
            String city = console.readLine();
            if (Objects.equals(city, null) || city.trim().isEmpty() || Objects.equals(city, "exit")) {
                System.out.println("До свидания.");
                System.exit(0);
            }
            System.out.println(city);
            System.out.println(getWeatherOnTomorrow(city));


        }
    }

}