package geekbrains.jmaxim1906.Java2.homework4.part2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Phonebook {
   private Map<Integer, String> phonebook;
    Phonebook() {
        phonebook = new HashMap<>();
    }
    public void add(int number, String surname) {
        phonebook.put(number, surname);
    }
    public void get(String surname){
        if(phonebook.containsValue(surname)) {
            Set<Map.Entry<Integer, String>> set = phonebook.entrySet();
            for (Map.Entry<Integer, String> temp : set) {
                if(temp.getValue().equals(surname)) {
                    System.out.println(temp.getValue() + " : " + temp.getKey());
                }
            }
        } else {
            System.out.println("Such name not found.");
        }
    }

        /*private final HashMap<String,String> phoneToName; // словарь как телефон фамилия. Номер уникален, поэтому
                                                          // поэтому выступает роли ключа
        public Phonebook() {
            phoneToName = new HashMap<>();
        }
        // метод put() -  можно добавлять записи
        public void appendNewPhoneToName(String phone, String name) {
            phoneToName.put(phone, name);
        }
        // метод get() - ищем номер  по фамилии
        public ArrayList<String> getPhonesBy(String name) {
            ArrayList<String> result = new ArrayList<>();

            for (Map.Entry<String, String> phoneEntry : phoneToName.entrySet()) {
                if (phoneEntry.getValue().equals(name)) {
                    result.add(phoneEntry.getKey());
                }
            }
            return result;*/
        }

