package task_3;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@Slf4j
public class SimpsonsCourse {

    private String courseName; // название предмета (например, "Math", "History", "Bart's Pranks")
    private int courseId; // уникальный идентификатор предмета
    private static AtomicInteger counter = new AtomicInteger(0);

    public SimpsonsCourse(String courseName) {
        if (courseName == null || courseName.isBlank()) {
            throw new IllegalArgumentException("Please provide correct courseName");
        }

        this.courseName = courseName;
        this.courseId = nextId();
    }

    private static int nextId() {
        return counter.incrementAndGet();
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SimpsonsCourse other = (SimpsonsCourse) obj;
        return courseId == other.courseId && Objects.equals(courseName, other.courseName);
    }

    @Override
    public String toString() {
        return "courseId: " + courseId;
    }
}
