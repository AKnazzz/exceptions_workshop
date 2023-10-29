package task_1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TimeMachine timeMachine = new TimeMachine(2023, false);

        TimeTraveler traveler1 = new TimeTraveler("FirstMan", 1900, 1985);
        TimeTraveler traveler2 = new TimeTraveler("SecondMan", 1800, 1843);
        TimeTraveler traveler3 = new TimeTraveler("ThirdMan", 1941, 1997);
        TimeTraveler traveler4 = new TimeTraveler("ForthMan", 1934, 2005);
        int year1 = 1901;
        int year2 = 1935;

        try {
            log.info("Try to launch {} in year {}", traveler1, year1);
            timeMachine.travelInTime(traveler1, year1);
            log.info("Success, {} now in year {}", traveler1, year1);
        } catch (TimeTravelException e) {
            log.error("Exception during invoking travelInTime(): {}", e.getMessage());
        }

        timeMachine.setWorking(true);

        try {
            log.info("Try to launch {} in year {}", traveler2, year1);
            timeMachine.travelInTime(traveler2, year1);
            log.info("Success, {} now in year {}", traveler2, year1);
        } catch (TimeTravelException e) {
            log.error("Exception during invoking travelInTime(): {}", e.getMessage());
        }

        try {
            log.info("Try to launch {} in year {}", traveler3, year1);
            timeMachine.travelInTime(traveler3, year1);
            log.info("Success, {} now in year {}", traveler3, year1);
        } catch (TimeTravelException e) {
            log.error("Exception during invoking travelInTime(): {}", e.getMessage());
        }

        try {
            log.info("Try to launch {} in year {}", traveler4, year2);
            timeMachine.travelInTime(traveler4, year2);
            log.info("Success, {} now in year {}", traveler4, year2);
        } catch (TimeTravelException e) {
            log.error("Exception during invoking travelInTime(): {}", e.getMessage());
        }
    }
}
