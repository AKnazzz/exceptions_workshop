package task_1;

public class TimeTraveler {
    private String name; // имя путешественника.
    private int birthYear; // год рождения путешественника.
    private int deathYear; // год смерти путешественника в будущем.

    public TimeTraveler(String name, int birthYear, int deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }
}
