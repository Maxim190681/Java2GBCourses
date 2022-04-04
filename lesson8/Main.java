package geekbrains.jmaxim1906.Java2.lesson8;

import java.sql.*;
import java.util.Scanner;

// JDBC(Java Data Base Connectivity)  Базы данных

/*
        Любой запрос к  базе - это предлжение (ключевое слово  и параметризованное  значение)
1.	Предложение SELECT – SELECT {columns} FROM {table_name}  выбрать (выгрузить)
2.	Предложение INSERT – INSERT INTO {table_name}({table_columns}) VALUES({values}) внести
3.	Предложение UPDATE – UPDATE {table_name} SET {column_name} = {value} WHERE {column_name} = {value}  обновить
4.	Предложение DELETE – DELETE FROM {table_name} WHERE {condition}  удалить запись из таблицы
 */

public class Main {
    // это statement                                    создать табл если не создана     целое число  первичный ключ колонка лог не пустая
    public static String sqlCreateUsersTable = "CREATE TABLE IF NOT EXISTS users (id integer PRIMARY KEY, login text NOT NULL);";
    //                                                       куда положить   наимен-е    что записать
    public static String sqlInsertUserInTable = "INSERT INTO users(login) VALUES(\"newLogin\");"; //  \" экранирование
    public static String sqlSelectUsersFromTable = "SELECT login FROM users;";
    public static String sqlUpdateUser = "UPDATE users SET login = \"newest login\" WHERE id = 1";
    public static String sqlDeleteUser = "DELETE FROM users WHERE id = 1";
    // это PreparedStatement  есть знак вопроса ?
    public static String sqlInsertQueryWithParameter = "INSERT INTO users(login) VALUES(?);";

    public static void main(String[] args) {
        // ОСНОВНЫЕ КЛАССЫ JDBC:
        // Connection - соединение с БД. Взаимодействуем с базой
        // Statement - позволяет отправлять запрос к БД  общение с базой при помощи SQL
        // PreparedStatement - позволяет отправлять параметризованные запросы к БД( запрос с подставляемым пераметром)
//----------------------------------------------------------------------------------------------------------//
        // jdbc:sqlite:sqlite_database_file_path  - строка для подключения к БД
        // по сути API  Driver    путь к БД
        // DriverManager парсит строку 35
        String url = "jdbc:sqlite:D:\\Java\\Java2\\src\\main\\java\\geekbrains\\jmaxim1906\\Java2\\lesson8\\test.db";
                // 38 строка - подключение, надо обязательно  закрывать
        String[] logins = {
                "hello",
                "bye",
                "login1",
                "jojo"
        };

        try (Connection sqLiteConnection = DriverManager.getConnection(url);
             //Statement statement = sqLiteConnection.createStatement()
             PreparedStatement preparedStatement = sqLiteConnection.prepareStatement(sqlInsertQueryWithParameter)
        ) {
             //System.out.println("Connection done");

            //statement.execute(sqlCreateUsersTable);
            //statement.execute(sqlInsertUserInTable);

            // считываем данные из БД
            /*ResultSet userResultSet = statement.executeQuery(sqlSelectUsersFromTable);
            while (userResultSet.next()) {
               String login = userResultSet.getString("login");
                System.out.println(login);
            } */
            // проапдейтили логин с ID1
            // statement.execute(sqlUpdateUser);

            // удаление
            //statement.execute(sqlDeleteUser);
            for (String login : logins) {
                preparedStatement.setString(1, login);  // нумерация с  единицы
                preparedStatement.execute();
            }

        } catch (Exception ex) {  // в продакте так делать нельзя ex,  ловим свои исключения
            System.out.println(ex.getMessage());
        }
    }
}


// зависимость БД dependency JDBC SqLite
// <groupId>org.xerial</groupId>
// <artifactId>sqlite-jdbc</artifactId>
// <version>3.36.0.3</version>