package geekbrains.jmaxim1906.Java2.lesson1;

//наследование инкапсуляция и полиморфизм  -  три кита JAVA

public class lesson1 {

    public static void main(String[] args) {
        Cat firstCat = new Cat("Мышкин","Белый",5); // new -  выделение места в памяти, вся  строчка - инициализация
        //firstCat.name = "Мышкин";
        //firstCat.color = "Белый";
        //firstCat.age = 5;

        //Cat secondCat = firstCat; ссылка,  не новый объект

        //Cat secondCat = new Cat("Дуся","Серый",3);
        //secondCat.name = "Дуся";
        //secondCat.color = "Серый";
        //secondCat.age = 3;

        Dog firstDog = new Dog("Шарик","Черный", 10);
        Bird firstBird = new Bird("Чижик", "Желтый",2, 15);
        Parrot firstParrot = new Parrot("Полли", "волнистый", 3,5);
        Snake firstSnake = new Snake(10, "Каа","зеленый");
        Car firstCar =  new Car();

        callMove(firstCar);  //реализация интерфейсов
        callMove(firstParrot);

        Fruits fruit = Fruits.orange;
        switch (fruit) {
            case apple:
                System.out.println("Яблоко");
                break;
            case cherry:
                System.out.println("Вишня");
                break;
        }

        System.out.println();

        System.out.println(firstCat.name + " " + firstCat.color + " " + firstCat.age + " ");
        //System.out.println(secondCat.name + " " + secondCat.color + " " + secondCat.age + " ");
        System.out.println(firstDog.name + " " + firstDog.color + " " + firstDog.age + " ");
        System.out.println(firstBird.name + " " + firstBird.color + " " + firstBird.age + " ");

        System.out.println();

        firstCat.voice();
        //secondCat.voice();
        firstCat.move();
        //secondCat.move();
        firstSnake.move();
        firstParrot.move();
        firstParrot.speak();

        System.out.println();

        callVoice(firstBird);
        callVoice(firstSnake);
        callVoice(firstParrot);
        callVoice(firstDog);
        callVoice(firstCat);


    }
    public static void callVoice(Animal animal) {
        animal.voice();
    }

    public static void callMove(Moveable moveable) {
        moveable.move();
    }
}
