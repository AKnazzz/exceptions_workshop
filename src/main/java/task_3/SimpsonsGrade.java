package task_3;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Getter
@Setter
@Slf4j
public class SimpsonsGrade {
    private SimpsonsCourse course; // экземпляр класса SimpsonsCourse, к которому относится оценка
    private SimpsonsCharacter character; // экземпляр класса SimpsonsCharacter, которому присвоена оценка.
    private int gradeValue; // числовое значение оценки (например, от 1 до 5)

    public SimpsonsGrade(SimpsonsCourse course, SimpsonsCharacter character, int gradeValue) {
        this.course = course;
        this.character = character;
        this.gradeValue = gradeValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, course, gradeValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SimpsonsGrade other = (SimpsonsGrade) obj;
        return Objects.equals(character, other.character) && Objects.equals(course, other.course)
                && gradeValue == other.gradeValue;
    }
}
