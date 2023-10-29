package task_3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Setter
@Getter
@NoArgsConstructor
public class SimpsonsCharacter {
    private static AtomicInteger counter = new AtomicInteger(0);
    private String name; // имя персонажа
    private int age; // возраст персонажа
    private int characterId; // уникальный идентификатор персонажа
    private Set<SimpsonsCourse> enrolledCourses; // список предметов, на которые персонаж записан
    private List<SimpsonsGrade> grades; //  список оценок персонажа

    public SimpsonsCharacter(String name, int age) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Please provide correct name");
        }

        if (age < 1) {
            throw new IllegalArgumentException("Age must be above 0");
        }

        this.name = name;
        this.age = age;
        this.characterId = nextId();
        this.enrolledCourses = new HashSet<>();
        this.grades = new ArrayList<>();
    }

    private static int nextId() {
        return counter.incrementAndGet();
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, characterId, enrolledCourses, grades, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SimpsonsCharacter other = (SimpsonsCharacter) obj;
        return age == other.age && characterId == other.characterId
                && Objects.equals(enrolledCourses, other.enrolledCourses) && Objects.equals(grades, other.grades)
                && Objects.equals(name, other.name);
    }

}
