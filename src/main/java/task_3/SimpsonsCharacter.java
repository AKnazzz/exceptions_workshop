package task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpsonsCharacter {
    private String name;
    private int age;
    private int characterId;
    private List<SimpsonsCourse> enrolledCourses = new ArrayList<>();
    private Map<SimpsonsCourse, Integer> grades = new HashMap<>();

    public SimpsonsCharacter(String name, int age, int characterId, List<SimpsonsCourse> enrolledCourses,
            Map<SimpsonsCourse, Integer> grades) {
        this.name = name;
        this.age = age;
        this.characterId = characterId;
        this.enrolledCourses = enrolledCourses;
        this.grades = grades;
    }

    public SimpsonsCharacter(String name, int age, int characterId) {
        this.name = name;
        this.age = age;
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public List<SimpsonsCourse> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<SimpsonsCourse> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Map<SimpsonsCourse, Integer> getGrades() {
        return grades;
    }

    public void setGrades(Map<SimpsonsCourse, Integer> grades) {
        this.grades = grades;
    }
}
