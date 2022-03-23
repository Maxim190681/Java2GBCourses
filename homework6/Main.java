package geekbrains.jmaxim1906.Java2.homework6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//dt9ClUcWrsCsAzcdGWvGhmpKThzReKTU ключ API, получен после регистриции
public class Main {
    private final static String WeatherURL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212";
    //код локейшна 294021 - Москва 295212 - Питер, URL с сайта AccuWeather
    private final static String API_KEY = "?apikey=dt9ClUcWrsCsAzcdGWvGhmpKThzReKTU";
    // гайд для получения ключа D/GB/JAVA2
    private final static String IS_METRIC = "&metric=true"; //параметр запроса F -> C

    public static void main(String[] args) {
        try {
            URL weatherUrl = new URL(WeatherURL + API_KEY + IS_METRIC); // запрос к серверу через класс URL через
            // слепленные строки 10 и 12
            HttpURLConnection urlConnection = (HttpURLConnection) weatherUrl.openConnection();
            //обращаемся к серверу через метод OpenConnection
            // метод ссылки 10й строки является гетером
            if (urlConnection.getResponseCode() == 200) {  // ответ сервера  -  ОК(положительный)
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                    // для считывания JSON у urlConnection - открыть стрим, создать ридер (буфер для
                    // экономии памяти
                    StringBuilder responseContent = new StringBuilder(); // внесение данных в JSON строку
                    String line = " ";
                    while ((line = reader.readLine()) != null) { //считываем данные файла сервера, как только
                        // возвращается null цикл надо прекратить
                        responseContent.append(line);
                    }
                    System.out.println(responseContent); // вывод в консоль JSON строки  ФИНАЛЬНЫЕ ДАННЫЕ
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

// https://jsonformatter.org/ строка JSON в читаемый вид