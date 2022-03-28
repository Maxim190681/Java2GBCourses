package geekbrains.jmaxim1906.Java2.homework7;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
        } else {
            System.out.println("Не удалось прочитать данные с сервера.");
        }
    }

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

// https://jsonformatter.org/ строка JSON в читаемый вид,  Daily_Forecast -  массив из массивов JSON
// под каждый элемент массива делать  класс,  разобрано как сделать проще
//  строка после  JSON formatter :

  /*"DailyForecasts": [
    {
      "Date": "2022-03-28T07:00:00+03:00",
      "EpochDate": 1648440000,
      "Temperature": {
        "Minimum": {
          "Value": -10.4,
          "Unit": "C",
          "UnitType": 17
        },
        "Maximum": {
          "Value": 4,
          "Unit": "C",
          "UnitType": 17
        }
      },
      "Day": {
        "Icon": 29,
        "IconPhrase": "Rain and snow",
        "HasPrecipitation": true,
        "PrecipitationType": "Mixed",
        "PrecipitationIntensity": "Light"
      },
      "Night": {
        "Icon": 19,
        "IconPhrase": "Flurries",
        "HasPrecipitation": true,
        "PrecipitationType": "Snow",
        "PrecipitationIntensity": "Light"
      },
      "Sources": [
        "AccuWeather"
      ],
      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c&lang=en-us",
      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c&lang=en-us"
    },
    {
      "Date": "2022-03-29T07:00:00+03:00",
      "EpochDate": 1648526400,
      "Temperature": {
        "Minimum": {
          "Value": -9.4,
          "Unit": "C",
          "UnitType": 17
        },
        "Maximum": {
          "Value": -1.9,
          "Unit": "C",
          "UnitType": 17
        }
      },
      "Day": {
        "Icon": 6,
        "IconPhrase": "Mostly cloudy",
        "HasPrecipitation": false
      },
      "Night": {
        "Icon": 36,
        "IconPhrase": "Intermittent clouds",
        "HasPrecipitation": false
      },
      "Sources": [
        "AccuWeather"
      ],
      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=2&unit=c&lang=en-us",
      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=2&unit=c&lang=en-us"
    },
    {
      "Date": "2022-03-30T07:00:00+03:00",
      "EpochDate": 1648612800,
      "Temperature": {
        "Minimum": {
          "Value": -8.7,
          "Unit": "C",
          "UnitType": 17
        },
        "Maximum": {
          "Value": -2.1,
          "Unit": "C",
          "UnitType": 17
        }
      },
      "Day": {
        "Icon": 2,
        "IconPhrase": "Mostly sunny",
        "HasPrecipitation": false
      },
      "Night": {
        "Icon": 38,
        "IconPhrase": "Mostly cloudy",
        "HasPrecipitation": false
      },
      "Sources": [
        "AccuWeather"
      ],
      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=3&unit=c&lang=en-us",
      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=3&unit=c&lang=en-us"
    },
    {
      "Date": "2022-03-31T07:00:00+03:00",
      "EpochDate": 1648699200,
      "Temperature": {
        "Minimum": {
          "Value": -7.9,
          "Unit": "C",
          "UnitType": 17
        },
        "Maximum": {
          "Value": 1.1,
          "Unit": "C",
          "UnitType": 17
        }
      },
      "Day": {
        "Icon": 3,
        "IconPhrase": "Partly sunny",
        "HasPrecipitation": false
      },
      "Night": {
        "Icon": 34,
        "IconPhrase": "Mostly clear",
        "HasPrecipitation": false
      },
      "Sources": [
        "AccuWeather"
      ],
      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=4&unit=c&lang=en-us",
      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=4&unit=c&lang=en-us"
    },
    {
      "Date": "2022-04-01T07:00:00+03:00",
      "EpochDate": 1648785600,
      "Temperature": {
        "Minimum": {
          "Value": -8.7,
          "Unit": "C",
          "UnitType": 17
        },
        "Maximum": {
          "Value": 2.1,
          "Unit": "C",
          "UnitType": 17
        }
      },
      "Day": {
        "Icon": 4,
        "IconPhrase": "Intermittent clouds",
        "HasPrecipitation": false
      },
      "Night": {
        "Icon": 7,
        "IconPhrase": "Cloudy",
        "HasPrecipitation": false
      },*/