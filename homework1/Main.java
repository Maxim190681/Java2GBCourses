package geekbrains.jmaxim1906.Java2.homework1;

import geekbrains.jmaxim1906.Java2.homework1.Obstacle.*;
import geekbrains.jmaxim1906.Java2.homework1.Participants.*;

/**
 * Create ZhegunovM 2022/02
 * 1. Разобраться с имеющимся кодом.
 * 2. Добавить класс Team, который будет содержать:
 * название команды;
 * массив из четырех участников — в конструкторе можно сразу всех участников указывать);
 * метод для вывода информации о членах команды, прошедших дистанцию;
 * метод вывода информации обо всех членах команды.
 * 3. Добавить класс Course (полоса препятствий), в котором будут находиться:
 * массив препятствий;
 * метод, который будет просить команду пройти всю полосу.
 * В итоге должно получиться похожее:
 * public static void main(String[] args) {
 * Course c = new Course(...); // Создаем полосу препятствий
 * Team team = new Team(...); // Создаем команду
 * c.doIt(team); // Просим команду пройти полосу
 * team.showResults(); // Показываем результаты
 * }
 */
public class Main {
    public static void main(String[] args) {

        Participants[] participants = {new Cat("Мурка"), new Dog("Шарик"),new Bird("Кеша"), new Rabbit("Роджер")};
        Obstacle[] obstacles = {new Run(5),new Jump(3),new Swim(1)};

        Team team =new Team("Спортивный  Зоопарк",participants);

        System.out.println("<-----создаем команду----->");
        System.out.println(team.getTeamName());
        System.out.println();
        System.out.println("<-----участники----->");
        team.showResults();
        System.out.println();

        Course course =new Course(obstacles);

        System.out.println("<-----команда стартует----->");
        course.doIt(team);
        System.out.println();

        System.out.println("<-----результат команды----->");
        team.showResults();
        System.out.println();

        System.out.println("<-----участники прошли----->");
        team.showParticipantFinishedCourse();
    }

}
