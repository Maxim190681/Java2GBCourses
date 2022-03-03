package geekbrains.jmaxim1906.Java2.homework4.part1;

import java.lang.reflect.Array;
import java.util.*;

/**1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово.
 * */

public class MainP1 {

    public static void main(String[] args) {
       List<String> words = Arrays.asList("summer", "winter", "spring", "autumn", "spring",
                                            "spring", "summer", "summer", "summer", "summer");

        Set<String> unique = new HashSet<String>(words);

        System.out.println("Unique Words");
        System.out.println(unique.toString());
        System.out.println("<------------->");
        System.out.println("Often Appears Words");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
        System.out.println("<-----The End-------->");


       /* String[] myWords = {"summer", "winter", "spring", "autumn", "spring",
                "spring", "summer", "summer", "summer", "summer"};

        countUniqueWordsIn(myWords);

        }

        public static void countUniqueWordsIn(String[] array) {
        HashMap<String, Integer> wordsToCount = new HashMap<>();
        final int firstTimeSee = 1;

        for (String word : array) {
            if (wordsToCount.containsKey(word)) {
                int count = wordsToCount.get(word);
                wordsToCount.put(word, count + 1);
            } else {
                wordsToCount.put(word, firstTimeSee);
            }
        }
            System.out.println();
            System.out.println("Print unique words from my massive");
                for (Map.Entry<String, Integer> wordEntry : wordsToCount.entrySet()) {
                    if (wordEntry.getValue() == firstTimeSee ) {
                        System.out.println(wordEntry.getKey());
                    }
                }
                System.out.println("<------------------>");
                System.out.println("Often Appears Words");
                for (Map.Entry<String, Integer> wordEntry : wordsToCount.entrySet()) {
                    System.out.println(wordEntry.getKey() + " : " + wordEntry.getValue() );
                }
                System.out.println("<------END--------->");*/
        }
}
