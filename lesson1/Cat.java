package geekbrains.jmaxim1906.Java2.lesson1;

public class Cat extends Animal {
    //public String name;
    //public String color;
    //public int age;

    public int appetite;

    public Cat(String name, String color, int age) {
        super(age, name, color);
        //this.name = name;
        //this.color = color;
        //this.age = age;
    }

    public void voice() {
        System.out.println(name + " мяу");
    }
    public void eat(Plate plate) {   //инкапсуляция - детали реализации скрыты внутри сущности
      //  plate.food -= appetite;  так неверно
        plate.decreaseFood(appetite);
    }

}
