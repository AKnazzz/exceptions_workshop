package task_3;

public class SimpsonsCourse {

    private String courseName; // название предмета (например, "Math", "History", "Bart's Pranks")
    private int courseId; // уникальный идентификатор предмета

    public SimpsonsCourse(String courseName, int courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
