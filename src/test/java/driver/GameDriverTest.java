package driver;

import exception.GameValidationFailedException;
import exception.InvalidOccupantException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import factory.DiceFactory;
import constants.DiceType;
import model.dice.impl.NormalDice;

/**
 * Test class for GameDriver
 */
@RunWith(MockitoJUnitRunner.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameDriverTest {

    @Mock
    DiceFactory diceFactory;

    @Mock
    NormalDice normalDice;

    GameDriver gameDriver;

    @Before
    public void before() {
        gameDriver = new GameDriver(diceFactory);
        Mockito.when(diceFactory.getDice(DiceType.NORMAL)).thenReturn(normalDice);
        Mockito.when(normalDice.roll()).thenCallRealMethod();
    }

    @Test
    public void testGameE2E_3Players_noException() throws GameValidationFailedException, InvalidOccupantException {
        gameDriver.initGame(10, DiceType.NORMAL);
        gameDriver.addPlayer("Superman");
        gameDriver.addPlayer("Batman");
        gameDriver.addPlayer("Joker");
        gameDriver.launchGame();
    }

    @Test(expected = GameValidationFailedException.class)
    public void testGameE2E_0Players_noException() throws GameValidationFailedException, InvalidOccupantException {
        gameDriver.initGame(10, DiceType.NORMAL);
        gameDriver.launchGame();
    }
}
