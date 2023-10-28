package task_1;

public class TimeMachine {
    private int currentYear; // текущий год временной машины.
    private boolean isWorking; // флаг, указывающий, работает ли машина времени.

    public TimeMachine(int currentYear, boolean isWorking) {
        this.currentYear = currentYear;
        this.isWorking = isWorking;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }


    public void travelInTime(TimeTraveler timeTraveler, int year) {
        if (!isWorking) {
            throw new TimeTravelException("Машина времени не работает!");
        }

        if (year < timeTraveler.getBirthYear()) {
            throw new TimeTravelException("Путешественник во времени ещё не родился в этот год!");
        } else if (year > timeTraveler.getDeathYear()){
            throw new TimeTravelException("Путешественник во времени уже умер!");
        }
    }


}
