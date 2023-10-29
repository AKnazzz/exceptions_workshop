package task_3;

public class SimpsonsGrade {
    private SimpsonsCourse course; // экземпляр класса SimpsonsCourse, к которому относится оценка
    private SimpsonsCharacter character; // экземпляр класса SimpsonsCharacter, которому присвоена оценка.
    private int gradeValue; // числовое значение оценки (например, от 1 до 5)

    public SimpsonsGrade(SimpsonsCourse course, SimpsonsCharacter character, int gradeValue) {
        this.course = course;
        this.character = character;
        this.gradeValue = gradeValue;
    }

    public SimpsonsCourse getCourse() {
        return course;
    }

    public void setCourse(SimpsonsCourse course) {
        this.course = course;
    }

    public SimpsonsCharacter getCharacter() {
        return character;
    }

    public void setCharacter(SimpsonsCharacter character) {
        this.character = character;
    }

    public int getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(int gradeValue) {
        this.gradeValue = gradeValue;
    }
}
