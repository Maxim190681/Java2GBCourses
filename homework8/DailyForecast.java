package geekbrains.jmaxim1906.Java2.homework8;

import javax.json.JsonObject;

public class DailyForecast {
    // класс содержащий в себе данные из JS массива
    private final String date;
    private final double minimumTemperature;
    private final double maximumTemperature;
    private final String dayTextDescription;
    private final String nightTextDescription;

    public DailyForecast(JsonObject jsonObject) {
        date = jsonObject.getString("Date");

        minimumTemperature = jsonObject // объект t - содержит вложенные объекты min и max
                .getJsonObject("Temperature")
                .getJsonObject("Minimum")
                .getJsonNumber("Value") // получить число
                .doubleValue(); // получаем t с плавающей запятой
        // аналогично обращаемся k max
        maximumTemperature = jsonObject
                .getJsonObject("Temperature")
                .getJsonObject("Maximum")
                .getJsonNumber("Value")
                .doubleValue();
        // ночная и дневная  погода -  из объекта day вытаскиваем строку IconPhrase
        dayTextDescription = jsonObject
                .getJsonObject("Day")
                .getString("IconPhrase");

        nightTextDescription = jsonObject
                .getJsonObject("Night")
                .getString("IconPhrase");
    }

    public DailyForecast(
            String date,
            double minimumTemperature,
            double maximumTemperature,
            String dayTextDescription,
            String nightTextDescription) {
        this.date = date;
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
        this.dayTextDescription = dayTextDescription;
        this.nightTextDescription = nightTextDescription;
    }
// геттеры отправляют данные  по  полям для RepSer
    public String getDate() {
        return date;
    }

    public double getMinimumTemperature() {
        return minimumTemperature;
    }

    public double getMaximumTemperature() {
        return maximumTemperature;
    }

    public String getDayTextDescription() {
        return dayTextDescription;
    }

    public String getNightTextDescription() {
        return nightTextDescription;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("В городе СПБ ");
        stringBuilder.append("на дату " + date + "\n");
        stringBuilder.append("ОЖИДАЕТСЯ: \n");
        stringBuilder.append("днём: " + dayTextDescription + "\n");
        stringBuilder.append("ночью: " + nightTextDescription + "\n");
        stringBuilder.append("ТЕМПЕРАТУРА: \n");
        stringBuilder.append("минимальная: " + minimumTemperature + " C\n");
        stringBuilder.append("максимальная: " + maximumTemperature + " C\n");

        return stringBuilder.toString();
    }
}
