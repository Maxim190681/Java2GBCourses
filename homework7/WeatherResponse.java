package geekbrains.jmaxim1906.Java2.homework7;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class WeatherResponse {

    private final DailyForecast[] dailyForecasts;

    public WeatherResponse(JsonObject jsonObject) { // конструктор получающий на вход JS объект
        JsonArray jsonDailyForecastsArray = jsonObject.getJsonArray("DailyForecasts"); // указываем ключ для получения объекта
                                                                    // по ключу находится неск-о JS объектов
        dailyForecasts = new DailyForecast[jsonDailyForecastsArray.size()];

        // расшифровка строчки JS
        for (int forecast = 0; forecast < dailyForecasts.length; forecast++) {
            JsonObject jsonForecast = jsonDailyForecastsArray.getJsonObject(forecast);
            DailyForecast dailyForecast = new DailyForecast(jsonForecast);
            dailyForecasts[forecast] = dailyForecast;
        }
    }
        // вывод в консоль
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Погода на 5 дней в СПБ: \n");

        for (DailyForecast dailyForecast : dailyForecasts) {
            stringBuilder.append(dailyForecast.toString() + "\n");
        }

        return stringBuilder.toString();
    }

}
