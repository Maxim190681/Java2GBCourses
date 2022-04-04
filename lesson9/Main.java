package geekbrains.jmaxim1906.Java2.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// потоки stream API (функциональное программирование)
// функция отдельный объект
public class Main {
    public static void main( String[] args) {
        // ищем четные  элементы и суммируем их
          int result = 0;                               // простой способ
          for (Integer number : makeNewCollection()) {
              if (number % 2 == 0) {
                  result += number;
              }
          }
          System.out.println(result);

          List<Integer> integers = makeNewCollection();
          //Stream<Integer> stream = integers.stream();
                                                       // лямда (анонимная функция)
         // Stream<Integer> stream = integers.stream().filter(number -> number % 2 == 0); // функция фильтр в стрим апи

        //List<Integer> filtered = integers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        // REDUCE редукция  (накопление, суммирование)
        /*List<Integer> filtered*/ result = integers  // источник данных в данном случае коллекция
                .stream()                //
                .filter(number -> number % 2 == 0) // промежуточный оператор (возвращает стрим из  стрим апи, может быть много)
                .reduce((eachResult, nextElement) -> eachResult + nextElement)
                .orElse(0); // ofElse - проверка если будет возвращен null
        // заканчивается терминальным  оператором


        //System.out.println(integers);
        //System.out.println(filtered);
        System.out.println(result);

        // проммежуточные операторы  фильтр  был  ранее,
        // SKIPPED

        List<Integer> skipped = integers.stream().skip(50).collect(Collectors.toList()); //пропуск первых 50 элементов
        System.out.println(skipped);

        // DISTINCT
        List<Integer> duplicates = makeDuplicateCollection();
                                                 //возвращает стрим с уникальными значениями
        List<Integer> uniq = duplicates.stream().distinct().collect(Collectors.toList());
        System.out.println(duplicates);
        System.out.println(uniq);


        // MAP преобразует  элемент по  заанному  правилу и возвращает обновленную коллекцию
        List<Integer> mapped = integers.stream().map(element -> element * 10).collect(Collectors.toList());
       // System.out.println(mapped);

        // PEEK вовзращает стрим с применением функции к каждому элементу
        List<Integer> peeked = integers.stream().peek(element -> System.out.println(element)).collect(Collectors.toList());

        // LIMIT - антоним SKIP
        List<Integer> limited = integers.stream().limit(50).collect(Collectors.toList());
        System.out.println(limited);

        // SORTED - позволяет сортироват значение
        List<Integer> sorted = integers.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted); // сортирует по возрастанию

        // FLAT MAP разворачивает вложенные структуры
        List<List<String>> lists = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
        System.out.println(lists);

        List<String> flatMapped = lists.stream().flatMap(element -> element.stream()).collect(Collectors.toList());
        System.out.println(flatMapped);

    }
    //используется для работы с коллекциями
    public static List<Integer> makeNewCollection() {
        List<Integer> collection = new ArrayList<>();
        for (int i = 100; i > 0; i--) {
            collection.add(i);
        }
        return collection;
    }
    public static List<Integer> makeDuplicateCollection() {
        List<Integer> collection = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            collection.add(1);
        }
        return collection;
    }
}
