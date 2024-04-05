package model;

import exception.InvalidOccupantException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for GameDriver
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardTest {

    Board board;

    @Before
    public void setup() throws InvalidOccupantException {
        board = new Board(10);
    }

    @Test
    public void testPrintBoard_noException() {
        board.printBoard();
    }
}
