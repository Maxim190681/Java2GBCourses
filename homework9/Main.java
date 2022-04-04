package geekbrains.jmaxim1906.Java2.homework9;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Имеется следующая структура:
 *    class Student {
 *         String getName() {
 *                     ...
 *                 }
 *         List<Course> getAllCourses() {
 *                     ...
 *                 }
 *     }
 *     class Course {
 *             String name
 *         }
 * 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов,
 * на которые подписаны студенты.
 * 2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
 * (любознательность определяется количеством курсов).
 * 3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
 * которые посещают этот курс.
 */
public class Main {
    public static void main (String[] args) {
        List<Student> students = makeStudents(); // набор студентов для  проверки 1го, 2го  и 3го пункта ТЗ

        // ищем уникальные курсы
        System.out.println("Unique Courses");
        System.out.println(filterUniqueCoursesFrom(students));

        // ищем трех самых любознательных
        System.out.println("Most Inquisitive Students");
        System.out.println(getTopThreeInquisitiveStudents(students));

        // ищем студентов, которые посещают этот курс
        System.out.println("Who goes to the course");
        System.out.println(findStudentsByCourse(students, new Course("TMM")));
    }

    public static List<Student> makeStudents() {
        List<Student> students = Arrays.asList(
                new Student(
                        "Ivan",
                        Arrays.asList(
                                new Course("Mathematica"),
                                new Course("Informatica"),
                                new Course("Physics"),
                                new Course("TMM")
                        )
                ),
                new Student(
                        "Anna",
                        Arrays.asList(
                                new Course("Mathematica"),
                                new Course("Network"),
                                new Course("Geography"),
                                new Course("High Mathematics"),
                                new Course("TMM")
                        )
                ),
                new Student(
                        "Elena",
                        Arrays.asList(
                                new Course("Chemistry"),
                                new Course("High Mathematics"),
                                new Course("Biology"),
                                new Course("Network"),
                                new Course("History"),
                                new Course("Analytics")
                        )
                ),
                new Student(
                        "Nikolay",
                        Arrays.asList(
                                new Course("TMM"),
                                new Course("High Mathematics"),
                                new Course("Analytics"),
                                new Course("Network"),
                                new Course("English"),
                                new Course("Physics"),
                                new Course("Geometry")
                        )
                )
        );
      return students;
    }
//--------------------------------------1--------------------------------//
    public static List<Course> filterUniqueCoursesFrom(List<Student> students) {
 // используем FLAT MAP (разворачивает вложенные структуры) все курсы студентов  преобразуем в общий список
        List<Course> courses = students.stream().flatMap(elment -> elment.getAllCourses().stream()).collect(Collectors.toList());
// используем FILTER для нахождения уникальных курсов ( встречаются менее  2х раз)
        return courses.stream().filter(course -> Collections.frequency(courses, course) < 2).collect(Collectors.toList());
    }
//--------------------------------------2--------------------------------//
    public static List<Student> getTopThreeInquisitiveStudents(List<Student> from) {
        // SORTED - позволяет сортироват значение
        return from.stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAllCourses().size() > o2.getAllCourses().size()) {// проведение сравнения.
                    return -1;
                } else if (o1.getAllCourses().size() < o2.getAllCourses().size()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        })
                .limit(3) // ограничиваемся 3 топовыми студентами   LIMIT - антоним SKIP
                .collect(Collectors.toList());
    }
//--------------------------------------3--------------------------------//
    public static List<Student> findStudentsByCourse(List<Student> from, Course course) {
                           // оператор FILTER
        return from.stream().filter(student -> student.getAllCourses().contains(course)).collect(Collectors.toList());
    }
}
