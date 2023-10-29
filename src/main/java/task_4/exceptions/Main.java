package task_4.exceptions;

import task_4.AvengersBase;
import task_4.Hero;

public class Main {
    public static void main(String[] args) {
        try {
            Hero name1 = new Hero("Укупник");
            Hero name2 = new Hero("Loki");
            AvengersBase avengersBase = new AvengersBase();

            avengersBase.enterBase(name1);
            avengersBase.enterBase(name2);
            System.out.println(avengersBase.getSecretDocuments(name1, " коды доступа "));
            System.out.println(avengersBase.getSecretDocuments(name2, " коды доступа "));
        } catch (SecurityBreachException exp) {
            System.out.println("Security Exception " + exp.getMessage());
        } catch (UnauthorizedAccessAttemptException exp) {
            System.out.println("Unauthorized Access Exception " + exp.getMessage());
        }
    }
}
