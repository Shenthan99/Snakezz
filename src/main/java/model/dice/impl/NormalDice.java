package model.dice.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import model.dice.Dice;

import java.util.Random;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Normal Dice implementation
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NormalDice implements Dice {

    static int MAX_DICE_NUM = 6;

    @Override
    public int roll() {
        final Random random = new Random();
        return NumberUtils.INTEGER_ONE + random.nextInt(MAX_DICE_NUM);
    }
}
