package task_3;

import lombok.extern.slf4j.Slf4j;
import task_3.exceptions.CoursesNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class SimpsonsSchool {

    private List<SimpsonsCharacter> characters = new ArrayList<>();
    private List<SimpsonsCourse> courses = new ArrayList<>();
    private List<SimpsonsGrade> grades = new ArrayList<>();

    public void enrollCharacter(SimpsonsCharacter character, List<SimpsonsCourse> courses){ //для записи персонажа на выбранные предметы.
        if (character == null || courses == null || courses.isEmpty()) {
            throw new IllegalArgumentException("Arguments can't be null or empty");
        }

        log.info("Attempt to enroll {}'s character", character.getName());

        if (courses.stream().anyMatch(course -> course == null)) {
            throw new IllegalArgumentException("Courses can't contain null elements");
        }

        character.getEnrolledCourses().addAll(courses);
        log.info("{}'s character was enrolled successful", character.getName());
    }

    public void addGrade(SimpsonsCharacter character, SimpsonsCourse course, int gradeValue){ // для добавления оценки персонажу по предмету.
        if (gradeValue < 1 || gradeValue > 5) {
            throw new IllegalArgumentException("Grade value must be from 1 to 5");
        }

        if (character == null || course == null) {
            throw new IllegalArgumentException("Null args was got");
        }

        log.info("Attempt to add grade {} of {}'s  course: {}", gradeValue, character.getName(),
                course.getCourseName());

        if (!character.getEnrolledCourses().contains(course)) {
            throw new CoursesNotFoundException(
                    character.getName() + " not enrolled on " + course.getCourseName() + " yet");
        }

        character.getGrades().add(new SimpsonsGrade(course, character, gradeValue));
        log.info("Adding grade {} of {}'s  course: {}, successful", gradeValue, character.getName(),
                course.getCourseName());
    }

    public List<String> getCharacterTranscript(SimpsonsCharacter character){ //для получения академической справки (списка всех предметов и оценок) персонажа.
        if (character == null) {
            throw new IllegalArgumentException("Null args was got");
        }

        log.info("Try to get {}'s transcript", character.getName());

        if (character.getEnrolledCourses().isEmpty()) {
            throw new CoursesNotFoundException("Not found any " + character.getName() + "'s courses");
        }

        log.info("{}'s transcript was got successful", character.getName());

        return character.getGrades().stream()
                .map(grade -> String.format("%s : %d", grade.getCourse().getCourseName(), grade.getGradeValue()))
                .collect(Collectors.toList());
    }

}
