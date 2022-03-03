package geekbrains.jmaxim1906.Java2.homework2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super("Unreal data "+ message);
    }
}
