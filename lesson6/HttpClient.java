package geekbrains.jmaxim1906.Java2.lesson6;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpClient {
    public static void main(String[] args) {
        // <сетевой протокол>://<имя_хоста>:<номер_порта>/<действительный_путь_к_файлу>

        try { // обработать исключение
            URL geekbrainsURL = new URL("https://geekbrains.ru/courses");

            System.out.println("Protocol: " + geekbrainsURL.getProtocol()); // инфо  о протоколе
            System.out.println("Port: " + geekbrainsURL.getPort());
            System.out.println("Host: " + geekbrainsURL.getHost()); //  имя хоста
            System.out.println("File: " + geekbrainsURL.getFile()); // действительный путь к файлу

            //geekbrainsURL.openConnection();   // подключиться чтобы что то  получить

            HttpURLConnection urlConnection = (HttpsURLConnection)geekbrainsURL.openConnection();
            System.out.println("Request method " + urlConnection.getRequestMethod());
            System.out.println("Answer code " + urlConnection.getResponseCode());
            System.out.println("Reply message " + urlConnection.getResponseMessage());

            Map<String, List<String>> headers = urlConnection.getHeaderFields();
                /*for (String k : headers.keySet()) {
                    System.out.println("Key: " + " value: " + headers.get(k));
                }*/

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
