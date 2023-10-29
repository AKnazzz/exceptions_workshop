package task_1;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class TimeTraveler {
    private String name; // имя путешественника.
    private int birthYear; // год рождения путешественника.
    private int deathYear; // год смерти путешественника в будущем.

    public TimeTraveler(String name, int birthYear, int deathYear) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank");
        }

        if (birthYear <= 0 || deathYear <= 0) {
            throw new IllegalArgumentException("Dates must be positive");
        }

        if (birthYear > deathYear) {
            throw new IllegalArgumentException("Traveler can't be dead before birthday");
        }

        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return "TimeTraveler: " + name + ", with birthYear: " + birthYear + ", deathYear: " + deathYear;
    }
}
