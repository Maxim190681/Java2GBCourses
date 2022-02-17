package geekbrains.jmaxim1906.Java2.lesson1;

public class Parrot extends Bird implements Moveable {
    public Parrot(String newName, String newColor, int newAge, int height) {
        super(newName,newColor,newAge, height);
    }
    public void speak() {
        System.out.println(name + " хороший!");
    }
}
