package geekbrains.jmaxim1906.Java2.homework8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryService {
    public static final String DB_URL = "jdbc:sqlite:D:\\Java\\Java2\\src\\main\\java\\geekbrains\\jmaxim1906\\Java2\\homework8\\weather.db";
        // создаем таблицу
    public static void createTable() {
        try (Connection connection = DriverManager.getConnection(DB_URL); // создали объект, указывает на подкл к БД
             Statement statement = connection.createStatement() // обращаемся к БД  (запрос)
        ){
            String query =
                    "CREATE TABLE IF NOT EXISTS weather " +    // таблица с именем  погода, далее поля
                            "(id integer PRIMARY KEY, " +
                            "localDate text NOT NULL, " +
                            "dayText text NOT NULL, " +
                            "nightText text NOT NULL, " +
                            "minTemperature double NOT NULL, " +
                            "maxTemperature double NOT NULL);";
//---------------------------------------------------------------------------------------------------------------//
            statement.execute(query);  // выполяем запрос создания таблицы
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
// вносим данные в таблицу
    public static void putWeatherIntoDb(DailyForecast forecast) {
        final String query =
                "INSERT INTO weather(localDate, dayText, nightText, minTemperature, maxTemperature)" +
                        " VALUES(?,?,?,?,?);"; // ? - 1 ? - 2 и  тд тк исп-м prepareStatement

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(query)
             // используем скомпилированный  запрос
        ) {
            preparedStatement.setString(1, forecast.getDate());
            preparedStatement.setString(2, forecast.getDayTextDescription());
            preparedStatement.setString(3, forecast.getNightTextDescription());
            preparedStatement.setDouble(4, forecast.getMinimumTemperature());
            preparedStatement.setDouble(5, forecast.getMaximumTemperature());
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
// читаем данные из БД в  консоли
    public static List<DailyForecast> loadDailyForecasts() {
        final String query = "SELECT * FROM weather";  // забираем ВСЕ данные  таблицы БД(все колонки)
        List<DailyForecast> dailyForecasts = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query); // метод набора  записей в  БД
                                                                 // далее  while пока есть что считывать
            while(resultSet.next()) {
                DailyForecast dailyForecast =
                        new DailyForecast(
                                resultSet.getString("localDate"),
                                resultSet.getDouble("minTemperature"),
                                resultSet.getDouble("maxTemperature"),
                                resultSet.getString("dayText"),
                                resultSet.getString("nightText"));
                dailyForecasts.add(dailyForecast);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dailyForecasts; // тк может вернуться NULL
    }
}
