package geekbrains.jmaxim1906.Java2.homework4.part2;

     /**2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
          В этот телефонный справочник с помощью метода add() можно добавлять записи,
          а с помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть
          несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
          (Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие
          с пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки
          телефонного справочника)*/

public class MainP2 {
    public static void main(String[] Args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add(1112233, "Ivanov");
        phonebook.add(4567788, "Ivanov");
        phonebook.add(7891122, "Petrov");
        phonebook.add(1478989, "Sidorov");
        phonebook.add(2582356, "Sidorov");
        phonebook.add(3691245, "Sidorov");

        phonebook.get("Ivanov");
        phonebook.get("Petrov");
        phonebook.get("Sidorov");
        phonebook.get("Vasechkin");

        /*System.out.println("Работа с телефонной книгой");

        Phonebook phoneBook = new Phonebook();
        phoneBook.appendNewPhoneToName("8(999)999-99-99", "Малахов");
        phoneBook.appendNewPhoneToName("8(988)888-88-88", "Костин");
        phoneBook.appendNewPhoneToName("8(977)777-77-77", "Костин");
        phoneBook.appendNewPhoneToName("8(966)666-66-66", "Иванов");
        phoneBook.appendNewPhoneToName("8(955)555-55-55", "Михайлюк");
        phoneBook.appendNewPhoneToName("8(944)444-44-44", "Антропов");
        phoneBook.appendNewPhoneToName("8(933)333-33-33", "Михайлюк");
        phoneBook.appendNewPhoneToName("8(922)222-22-22", "Левицкий");
        phoneBook.appendNewPhoneToName("8(911)111-11-11", "Барышев");

        System.out.println(phoneBook.getPhonesBy("Малахов"));
        System.out.println(phoneBook.getPhonesBy("Костин"));
        System.out.println(phoneBook.getPhonesBy("Иванов"));
        System.out.println(phoneBook.getPhonesBy("Михайлюк"));
        System.out.println(phoneBook.getPhonesBy("Антропов"));
        System.out.println(phoneBook.getPhonesBy("Левицкий"));
        System.out.println(phoneBook.getPhonesBy("Барышев"));*/


    }
}
