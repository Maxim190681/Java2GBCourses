package geekbrains.jmaxim1906.Java2.lesson1;

public abstract class Animal { // если добавить implements  movement -  србатоает для всех наследников
    int age;  // protected видимость для наследников
    String name;
    String color;

    public Animal(int age, String name, String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }
    public void move() {
        System.out.println(name + " идет на  лапках");
    }

    public abstract void voice();
}
