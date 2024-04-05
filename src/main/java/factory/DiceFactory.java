package factory;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import model.dice.Dice;
import constants.DiceType;
import model.dice.impl.CrookedDice;
import model.dice.impl.NormalDice;

/**
 * Factory class to choose amongst the implementation of Dice
 */
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DiceFactory {

    @NonNull
    NormalDice normalDice;

    @NonNull
    CrookedDice crookedDice;

    /**
     * Function which determines which implementation of dice needs to be instantiated
     *
     * @param diceType : Type of Dice
     * @return Relevant implementation of dice
     * @throws IllegalStateException if handling for specified diceType is not defined
     */
    public Dice getDice(final DiceType diceType) {
        switch (diceType) {
            case NORMAL:
                return normalDice;
            case CROOKED:
                return crookedDice;
            default:
                throw new IllegalStateException(String.format("DiceType : %s has no implementation defined.", diceType));
        }
    }
}
