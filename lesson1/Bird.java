package geekbrains.jmaxim1906.Java2.lesson1;

public class Bird extends Animal {

    //public String name;
    //public String color;
    //public int age;
    int height;

    public Bird(String name, String color, int age, int height) {
        super(age, name, color);
        //this.name = name;
        //this.color = color;
        //this.age = age;
       // height = 10; усложним контруктор 10я  строка и переишем
        this.height =height;

    }
   public void voice() {
        System.out.println(name + " чирик");
    }
}
