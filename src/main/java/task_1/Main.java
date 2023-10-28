package task_1;

public class Main {
    public static void main(String[] args) {
        TimeMachine timeMachine = new TimeMachine(2023, true);

        TimeTraveler timeTraveler1 = new TimeTraveler("Emmett Brown", 1914, 2015);
        TimeTraveler timeTraveler2 = new TimeTraveler("Marty McFly", 1968, 2068);

        timeMachine.travelInTime(timeTraveler1,1999);
        timeMachine.travelInTime(timeTraveler2,2055);
        timeMachine.travelInTime(timeTraveler1,999);
        timeMachine.travelInTime(timeTraveler2,3000);
    }

}
