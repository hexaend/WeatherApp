package org.example;

import java.io.IOException;
import java.util.Scanner;

import static org.example.api.ApiMain.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.printf("Добро пожаловать в консольное приложение - Погода на завтра%nВведите город: ");
        String city = new Scanner(System.in).next();
        System.out.println(getWeatherOnTomorrow(city));
    }
}