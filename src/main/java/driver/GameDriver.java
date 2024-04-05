package driver;

import exception.GameValidationFailedException;
import exception.InvalidOccupantException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.math.NumberUtils;

import model.Board;
import model.Player;
import model.cellOccupant.CellOccupant;


import model.dice.Dice;
import factory.DiceFactory;
import constants.DiceType;
import utils.MoveValidator;

import java.util.*;

/**
 * Driver class to initialise and launch game
 */
@RequiredArgsConstructor
public class GameDriver {

    @NonNull
    DiceFactory diceFactory;

    Board board;
    Queue<Player> players;
    int size;
    Dice dice;

    /**
     * Initialises all the variables associated with game
     * @param dimensionOfTheBoard : Dimensions of the board
     * @param diceType : Type of Dice
     */
    public void initGame(final int dimensionOfTheBoard, @NonNull final DiceType diceType) throws InvalidOccupantException {
        this.size = dimensionOfTheBoard * dimensionOfTheBoard;
        board = new Board(dimensionOfTheBoard);
        players = new LinkedList<>();
        dice = diceFactory.getDice(diceType);
        this.board.printBoard();
    }

    /**
     * Launches Game. Player play their turn sequentially.
     */
    public void launchGame() throws GameValidationFailedException {
        validateGameStart();
        System.out.println();
        System.out.println("************************* Game Started *************************");
        while (players.size() > NumberUtils.INTEGER_ONE) {
            final Player currentPlayer = players.poll();
            System.out.printf("%n******** %s's turn. Current Cell %d. Rolling Dice.********%n", currentPlayer.getPlayerName(), currentPlayer.getPosition());
            makeMove(currentPlayer);
            if (currentPlayer.getPosition() == size) {
                System.out.printf("%n%n******** Congratulations %s, You Won !! ******** %n%n", currentPlayer.getPlayerName());
                players = new LinkedList<>();
            } else {
                players.add(currentPlayer);
            }
        }
    }

    /**
     * Adds player to the game.
     * @param playerName : Name of the player
     */
    public void addPlayer(@NonNull final String playerName) {
        players.add(new Player(NumberUtils.INTEGER_ZERO, playerName));
    }

    private void validateGameStart() throws GameValidationFailedException {
        if (players.size() < NumberUtils.INTEGER_ONE) {
            throw new GameValidationFailedException("Game cannot be started without any player");
        }
    }

    private void makeMove(final Player currentPlayer) {
        int currenPosition = currentPlayer.getPosition();
        int numberRolled = dice.roll();
        System.out.printf("%s got : %d%n", currentPlayer.getPlayerName(), numberRolled);
        int finalPosition = currenPosition + numberRolled;
        if (MoveValidator.isValidMove(finalPosition, size)) {
            final CellOccupant cellOccupant = board.getCells().get(finalPosition);
            if (cellOccupant.getEncounterMessage(finalPosition).isPresent()) {
                System.out.println(cellOccupant.getEncounterMessage(finalPosition).get());
            }
            finalPosition = cellOccupant.getEndPosition();
            System.out.printf("Taking %s to: %d%n", currentPlayer.getPlayerName(), finalPosition);
        } else {
            System.out.printf("Sorry. You cannot jump by %d places when you are at %d. Try again in next turn !%n", numberRolled, currenPosition);
            finalPosition = currenPosition;
        }
        currentPlayer.setPosition(finalPosition);
    }

}
