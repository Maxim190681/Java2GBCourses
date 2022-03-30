package geekbrains.jmaxim1906.Java2.homework8;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Main {
    private final static String WeatherURL =  "http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212";
    // URL для запроса погоды на 5 дней в СПБ.
    private final static String API_KEY = "?apikey=4uT3CCtP3oRbsLmC8Uvz4WZF5hmcaCun";
    // API ключ для запроса. См. гайд, как его получить и вставить.
    private final static String IS_METRIC = "&metric=true"; // F -> C

    public static void main(String[] args) {
        String forecastJson = load5DayForecastOrNull();

        if (forecastJson != null) {
            StringReader forecastJsonReader = new StringReader(forecastJson); //считывание JSON 1st String->Json reader
            JsonReader jsonReader = Json.createReader(forecastJsonReader);
            JsonObject weatherResponseJson = jsonReader.readObject(); // для считывания JS объекта-метод readObject()
            WeatherResponse weatherResponse = new WeatherResponse(weatherResponseJson); //создаем класс
            System.out.println(weatherResponse);

            // создание таблицы  БД
            RepositoryService.createTable();

            for (DailyForecast dailyForecast : weatherResponse.getDailyForecasts()) {
                RepositoryService.putWeatherIntoDb(dailyForecast);
            }

            List<DailyForecast> dailyForecasts = RepositoryService.loadDailyForecasts();
            System.out.println(dailyForecasts);



        } else {
            System.out.println("Не удалось прочитать данные с сервера.");
        }
    }
    // метод  получения результата запроса погоды
    public static String load5DayForecastOrNull() {
        // в методе load5DayForecastOrNull используем код 6HW (возврат строки в виде ответа сервера
        try {
            // слепленные строки 10 и 12
            URL weatherUrl = new URL(WeatherURL+API_KEY + IS_METRIC);
            //обращаемся к серверу через метод OpenConnection
            // метод ссылки 10й строки и является гетером
            HttpURLConnection urlConnection = (HttpURLConnection) weatherUrl.openConnection();
            // getResponseCode отправляет запрос к серверу по указанному нами URL, который по факту является GET запросом.
            if (urlConnection.getResponseCode() == 200) {  // ответ сервера  -  ОК(положительный)
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                    // для считывания JSON у urlConnection - открыть стрим, создать ридер (буфер для
                    // экономии памяти
                    StringBuilder responseContent = new StringBuilder(); // внесение данных в JSON строку
                    String line = "";
                    // Тут мы используем для работы с сетью BufferedReader.
                    while ((line = reader.readLine()) != null) { //считываем данные файла сервера, как только
                        // возвращается null цикл надо прекратить
                        responseContent.append(line);
                        // вернет null.
                    }
                    return responseContent.toString();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
