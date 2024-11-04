package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Model {

    private Space[][] board;
    private int ROW = 10;
    private int COL = 10;
    private int SHIPS = 17;
    private boolean gameOver;
    private String gameOverMessage;
    private int misses;
    private int strikes;
    private int totalMisses;
    private int totalHits;

    public static final int MISS = 2;
    public static final int HIT = 3;
    public static final int DISABLED = 4;


    public Model() {
        SetupBoard();
        printBoard();

    }

    public int playMove(int row, int col) {
        int result = DISABLED;
        // if cell is hit or miss, do nothing, return disabled
        if (board[row][col].getState() == Space.HIT || board[row][col].getState() == Space.MISS) {
            return DISABLED;
        }

        // if cell is ship, set to hit, add one to total hit counter, miss counter set zero
        else if (board[row][col].getState() == Space.SHIP) {
            board[row][col].setState(Space.HIT);
            totalHits++;
            misses = 0;
            result = HIT;
        }

        // if cell is blank, set it to miss, add one to miss counter and total miss counter
        else if (board[row][col].getState() == Space.BLANK) {
            board[row][col].setState(Space.MISS);
            misses++;
            totalMisses++;
            result = MISS;
        }
        // check if miss counter is at 5, then add a strike and reset miss counter
        if (misses == 5) {
            strikes++;
            misses = 0;
        }

        // check for a gameEnd condition
        if (totalHits == SHIPS) {
            gameOver = true;
            gameOverMessage = "You found all the ships, you win!";
        }
        if (strikes == 3) {
            gameOver = true;
            gameOverMessage = "3 Strikes, you lose!";
        }


        // return the state of the cell
        return result;
    }


    public boolean isGameOver() {
        return gameOver;
    }

    public String getGameOverMessage() {
        return gameOverMessage;
    }

    public void SetupBoard() {
        ResetGame();
        PlaceShips();
    }

    public int getMisses() {
        return misses;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getTotalMisses() {
        return totalMisses;
    }

    public int getTotalHits() {
        return totalHits;
    }

    private void ResetGame() {
        board = new Space[ROW][COL];
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = new Space(row, col);
            }
        }
        gameOver = false;
        misses = 0;
        strikes = 0;
        totalMisses = 0;
        totalHits = 0;
    }

    private void PlaceShips() {
        placeShip(5);
        placeShip(4);
        placeShip(3);
        placeShip(3);
        placeShip(2);

    }

    private void placeShip(int length) {
        ArrayList<ShipPlacement> possiblePlacements = new ArrayList<ShipPlacement>();
        possiblePlacements.addAll(checkVerticalPlacements(length));
        possiblePlacements.addAll(checkHorizontalPlacements(length));

        int randomIndex = (int) (Math.random() * possiblePlacements.size());
        ShipPlacement placement = possiblePlacements.get(randomIndex);

        Space space = placement.getSpace();
        String direction = placement.getDirection();

        for (int i = 0; i < length; i++) {
            if (Objects.equals(direction, ShipPlacement.VERTICAL)) {
                board[space.getRow() + i][space.getCol()].setState(Space.SHIP);
            } else {
                board[space.getRow()][space.getCol() + i].setState(Space.SHIP);
            }
        }

    }

    private ArrayList<ShipPlacement> checkVerticalPlacements(int length) {
        ArrayList<ShipPlacement> possiblePlacements = new ArrayList<ShipPlacement>();

        for (int row = 0; row < ROW; row++) {
            for (Space space : board[row]) {
                if (checkVerticalPlacement(space, length)) {
                    possiblePlacements.add(new ShipPlacement(space, ShipPlacement.VERTICAL));
                }
            }
        }

        return possiblePlacements;
    }

    private boolean checkVerticalPlacement(Space space, int length) {
        if (space.getRow() + length >= ROW) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            Space checkSpace = board[space.getRow() + i][space.getCol()];
            if (space.getState() != Space.BLANK) {
                return false;
            }

        }
        return true;
    }

    private ArrayList<ShipPlacement> checkHorizontalPlacements(int length) {
        ArrayList<ShipPlacement> possiblePlacements = new ArrayList<ShipPlacement>();

        for (int row = 0; row < ROW; row++) {
            for (Space space : board[row]) {
                if (checkHorizontalPlacement(space, length)) {
                    possiblePlacements.add(new ShipPlacement(space, ShipPlacement.HORIZONTAL));
                }
            }
        }

        return possiblePlacements;
    }

    private boolean checkHorizontalPlacement(Space space, int length) {
        if (space.getCol() + length >= COL) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            Space checkSpace = board[space.getRow()][space.getCol() + i];
            if (space.getState() != Space.BLANK) {
                return false;
            }

        }
        return true;
    }

    private void printBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                System.out.print(board[row][col].getState() + " ");
            }
            System.out.println();
        }
    }

}
