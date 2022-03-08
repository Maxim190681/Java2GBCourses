package geekbrains.jmaxim1906.Java2.homework3.fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;          // Array List обобщенный класс с  параметром типа

    public Box(ArrayList<T> fruits) {     // конструкор
        this.fruits = fruits;
    }

    public float getWeight() {
        float result = 0;
        for (T fruit : fruits) {              // цикл for-each
            result += fruit.weight;
        }
        return result;
    }

    public void compare (Box<?> another) {  //сравниваем коробки T -> ? метасимвольная контсрукция
        float currentWeight = getWeight();
        float anotherWeight = another.getWeight();

        if (currentWeight > anotherWeight) {
            System.out.println("Эта коробка  тяжелей.");
        } else if (currentWeight < anotherWeight) {
            System.out.println("Другая коробка  тяжелей.");
        } else {
            System.out.println("Коробки весят одинаково.");
        }
    }

    public void append (T fruit) {  // добавляем фрукт
        fruits.add(fruit);
    }

    public void transferTo(Box<T> other) {
        other.fruits.addAll(fruits);
        fruits.clear();                       // коробка  должна стать  пустой по условию. Очистка  массива
    }
}





/*public class Box<T extends Fruit> {
    private ArrayList<T> items;

    public Box(T... items) {
        this.items = new ArrayList<T>(Arrays.asList(items));
    }

    public void add(T... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public void remove(T... items) {
        for (T item: items) this.items.remove(item);
    }

    public ArrayList<T> getItems() {
        return new ArrayList<T>(items);
    }

    public void clear() {
        items.clear();
    }

    public float getWeight() {
        if (items.size() == 0) return 0;
        float weight = 0;
        for (T item: items) weight += item.getWeight();
        return weight;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void transfer(Box<? super T> box) {
        box.items.addAll(this.items);
        clear();
    }
}*/
