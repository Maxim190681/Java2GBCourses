package geekbrains.jmaxim1906.Java2.lesson1;

public class Dog extends Animal {

    //public String name;
    //public String color;
    //public int age;


    public Dog (String name, String color, int age) {
        super(age, name, color);
        //this.name = name;
        //this.color = color;
        //this.age = age;
    }

    public void voice() {
        System.out.println(name + " гав");
    }
}
