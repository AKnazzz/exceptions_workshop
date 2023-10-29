package task_1;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import task_1.exceptions.TimeTravelException;

@Slf4j
@Getter
@Setter
public class TimeMachine {
    private int currentYear; // текущий год временной машины.
    private boolean isWorking; // флаг, указывающий, работает ли машина времени.

    public TimeMachine(int currentYear, boolean isWorking) {
        this.currentYear = currentYear;
        this.isWorking = isWorking;
    }


    public void travelInTime(TimeTraveler timeTraveler, int year) {
        if (!isWorking) {
            throw new TimeTravelException("Time machine is off");
        }

        if (year < timeTraveler.getBirthYear()) {
            throw new TimeTravelException("Too young");
        }

        if (year > timeTraveler.getDeathYear()) {
            throw new TimeTravelException("No live after death");
        }

        System.out.println("Back To Future! Welcome in " + year + " !!! ");
    }


}
