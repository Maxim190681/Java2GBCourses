package geekbrains.jmaxim1906.Java2.lesson1;

public class Snake extends Animal {
    public Snake(int age, String name, String color) {
        super(age, name, color);
    }

    @Override
    public void move() {
        System.out.println(name + " ползет");
    }

    public void voice() {
        System.out.println(name + " шипит");
    }
}
