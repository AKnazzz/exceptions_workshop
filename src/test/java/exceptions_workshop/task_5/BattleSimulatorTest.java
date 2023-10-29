package exceptions_workshop.task_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task_5.BattleSimulator;
import task_5.Hero;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleSimulatorTest {

    private final BattleSimulator battleSimulator = new BattleSimulator();
    private final Hero hero = new Hero("Phoenix", 10000);

    @Test
    void simulateBattle() {

        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> battleSimulator.simulateBattle(null, 1));

        Exception ex2 = Assertions.assertThrows(IllegalArgumentException.class,
                () -> battleSimulator.simulateBattle(hero, 0));

        assertEquals("Null hero was sent", ex.getMessage());
        assertEquals("Allowed 1 turn atleast", ex2.getMessage());

    }
}
