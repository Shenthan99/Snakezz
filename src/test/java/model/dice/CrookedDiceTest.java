package model.dice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.dice.impl.CrookedDice;

/**
 * Test class for CrookedDice
 */
public class CrookedDiceTest {

    CrookedDice crookedDice;

    @Before
    public void setup() {
        crookedDice = new CrookedDice();
    }

    @Test
    public void testRollCrookedDice_happyScenario_success() {
        int score = crookedDice.roll();
        Assert.assertEquals(0, score % 2);
    }
}
