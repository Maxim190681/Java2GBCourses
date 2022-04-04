package geekbrains.jmaxim1906.Java2.homework9;

import java.util.Objects;

public class Course {
    public String name;

    public Course(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    // переопредляем для работы метода Collections.frequency.

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() !=o.getClass())
            return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    public int hashCode() {
        return Objects.hash(name);
    }
}
