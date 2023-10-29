package task_3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimpsonsSchool simpsonsSchool = new SimpsonsSchool();

        SimpsonsCharacter bart = new SimpsonsCharacter("Bart", 11, 1);
        SimpsonsCharacter lisa = new SimpsonsCharacter("Lisa", 9, 2);

        SimpsonsCourse math = new SimpsonsCourse("Math", 1);
        SimpsonsCourse english = new SimpsonsCourse("English", 2);
        SimpsonsCourse history = new SimpsonsCourse("History", 3);

        simpsonsSchool.enrollCharacter(bart, List.of(math, english));
        simpsonsSchool.enrollCharacter(lisa, List.of(math, history, english));

        try {
            simpsonsSchool.addGrade(bart, math, 4);
            simpsonsSchool.addGrade(bart, history, 3);
            simpsonsSchool.addGrade(bart,  english, 5);

            simpsonsSchool.addGrade(lisa, math, 5);
            simpsonsSchool.addGrade(lisa, history, 4);
            simpsonsSchool.addGrade(lisa, english, 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
