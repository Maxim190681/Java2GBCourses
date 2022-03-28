package geekbrains.jmaxim1906.Java2.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// echo server программа отсылает  обратно то что  прислано
public class Main {
    public static void main(String[] args) {
        // DataInputStream & DataOutputStream
        // localhost, 127.0.0.1  - адреса для подключения (к приложению) на одной машине
        // ServerSocket(класс)  - закрывать после использования

        try (ServerSocket serverSocket = new ServerSocket(8089)) {  //создание  объекта сервер-сокет(розетка)
            System.out.println("Server started!"); // уведомленние о запсуке сервера
            Socket client = serverSocket.accept();     // метод вышает сервер в режим прослушки
            System.out.println("Find new connection!");     // подключился  клиент

            DataInputStream dataInputStream = new DataInputStream(client.getInputStream()); // поток ввода от клиента
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());  // вывод

            while (true) {
                String echo = dataInputStream.readUTF(); // метод  забирает  данные  из  потока ввода.  Работает  до
                System.out.println(echo);                                         //  тех  пор  пока не будут получены какие  либо  данные
                if (echo.equals("/end")) {
                    dataOutputStream.writeUTF("Server Stop Work!!!");
                    break;
                }
                dataOutputStream.writeUTF(echo);
            }

        } catch(Exception ex) {    // try catch -  исключение в случае закрытого  порта
                System.out.println(ex.getMessage());
            }
        }
    }

