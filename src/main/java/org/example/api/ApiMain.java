package org.example.api;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import org.example.utils.Utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ApiMain {
    @SuppressWarnings("unchecked")
    public static ArrayList<Double> getLatitudeLongitudeByCity(String city) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("https://geocoding-api.open-meteo.com/v1/search?name=%s&count=1&language=ru&format=json", city))).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        client.close();

        String responseText = response.body();
        ArrayList<Double> returnedList = new ArrayList<Double>();

        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(responseText, new TypeToken<Map<String, Object>>() {
        }.getType());

        List<Map<String, Object>> results = (List<Map<String, Object>>) map.get("results");

        if (results == null) {
            Collections.addAll(returnedList, -99., -99.);
            return returnedList;
        }
        returnedList.add((Double) results.getFirst().get("latitude"));
        returnedList.add((Double) results.getFirst().get("longitude"));


        return returnedList;
    }

    @SuppressWarnings("unchecked")
    public static String getWeatherOnTomorrow(Double latitude, Double longitude) throws IOException, InterruptedException {
        if (latitude == -99) {
            return "Ошибка, такого города не существует.";
        }

        String tomorrow = LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&daily=weather_code,temperature_2m_max,temperature_2m_min&start_date=%s&end_date=%s", latitude, longitude, tomorrow, tomorrow))).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        client.close();

        Utils utils = new Utils();

        String responseText = response.body();
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(responseText, new TypeToken<Map<String, Object>>() {
        }.getType());
        LinkedTreeMap<String, Object> daily = (LinkedTreeMap<String, Object>) map.get("daily");

        int wmoInt = (((ArrayList<Double>) daily.get("weather_code")).getFirst()).intValue();
        String wmo = utils.getWMOWeatherByCode(wmoInt);
        Object tempMin = ((ArrayList<String>) daily.get("temperature_2m_min")).getFirst();
        Object tempMax = ((ArrayList<String>) daily.get("temperature_2m_max")).getFirst();

        return String.format("Завтра %s:%nМаксимальная температура - %s°C%nМинимальная температура - %s°C%nОсадки: %s", tomorrow, tempMax, tempMin, wmo);
    }

    public static String getWeatherOnTomorrow(String city) throws IOException, InterruptedException {
        ArrayList<Double> arrayList = getLatitudeLongitudeByCity(city);
        return getWeatherOnTomorrow(arrayList.getFirst(), arrayList.getLast());
    }


}
