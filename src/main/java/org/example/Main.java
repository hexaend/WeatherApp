package org.example;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

import static org.example.api.ApiMain.getWeatherOnTomorrow;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.printf("Добро пожаловать в консольное приложение - Погода на завтра%n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите город: ");
            try {
                String city = scanner.next();
                if (Objects.equals(city, "exit")) {
                    System.out.println("До свидания.");
                    System.exit(0);
                }
                System.out.println(getWeatherOnTomorrow(city));
            } catch (NoSuchElementException elementException) {
                System.out.println("До свидания.");
                break;
            }


        }
    }
}