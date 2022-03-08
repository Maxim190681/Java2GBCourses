package geekbrains.jmaxim1906.Java2.homework3;

import geekbrains.jmaxim1906.Java2.homework3.fruit.Apple;
import geekbrains.jmaxim1906.Java2.homework3.fruit.Box;
import geekbrains.jmaxim1906.Java2.homework3.fruit.Orange;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку
 * нельзя сложить и яблоки, и апельсины;
 * Для хранения фруктов внутри коробки можно использовать ArrayList<T>
 * Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f,
 * апельсина – 1.5f (единицы измерения не важны);
 * Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
 * которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
 * Можно сравнивать коробки с яблоками и апельсинами;
 * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов
 * не остается, а в другую перекидываются объекты, которые были в первой;
 * Не забываем про метод добавления фрукта в коробку.
 * */

public class Main {         // abstract class Fruit условный  забор,  нельзя поместить апельсины и яблоки
    public static void main(String[] args) {
        // 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)
        // свой вариант кода

        Integer[] intArr = new Integer[2];
        intArr[0] = 1;
        intArr[1] = 2;

        System.out.println(Arrays.deepToString(intArr));
        swap(intArr, 0, 1);
        System.out.println(Arrays.deepToString(intArr));

        //2.  разбор с урока

        Box<Apple> appleBox = new Box<>(makeNewApples(1));
        Box<Orange> orangeBox = new Box<>(makeNewOranges(2));
        Box<Orange> secondOrangeBox = new Box<>(makeNewOranges(0));   // пустая коробка  для перекладывания

        appleBox.compare(orangeBox);
        appleBox.compare(secondOrangeBox);
        orangeBox.transferTo(secondOrangeBox);
        appleBox.compare(orangeBox);
        appleBox.compare(secondOrangeBox);

    }
    public static void swap(Object[] arr, int index1,int index2) {
        Object tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static ArrayList<Apple> makeNewApples(int count) {  // создаем яблоки
        ArrayList<Apple> fruits = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fruits.add(new Apple());
        }
        return fruits;
    }
    public static ArrayList<Orange> makeNewOranges(int count) {  // создаем апельсины
        ArrayList<Orange> fruits = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fruits.add(new Orange());
        }
        return fruits;
    }


}

//     Код  преподователя

/*    1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    public static <T>void changeArrayElements(T[] array, int firstIndex, int secondIndex) {
        if (firstIndex < 0 || array.length <= firstIndex || secondIndex < 0 || array.length <= secondIndex || array.length < 2) {
            System.out.println("Некорректные индексы");
            return;  обязателен  -   дальше метод выполняться  не должен
        }

        // Если if-а не будет  в  продуктиве лучше IF , try catch - вызывает прерывание процесса
        try {
            T arrayElement = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = arrayElement;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Некорректные индексы");
        }
    }*/