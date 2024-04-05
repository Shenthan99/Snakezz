package model.dice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.dice.impl.NormalDice;

/**
 * Test class for NormalDice
 */
public class NormalDiceTest {
    NormalDice normalDice;

    @Before
    public void setup() {
        normalDice = new NormalDice();
    }

    @Test
    public void testRollNormalDice_happyScenario_success() {
        int score = normalDice.roll();
        Assert.assertTrue(score <= 6);
        Assert.assertTrue(score >= 1);
    }
}
