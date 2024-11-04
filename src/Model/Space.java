package Model;

public class Space {
    private int row;
    private int col;
    private int state;
    public static final int BLANK = 0;
    public static final int SHIP = 1;
    public static final int MISS = 2;
    public static final int HIT = 3;

    public Space(int row, int col) {
        this.row = row;
        this.col = col;
        state = BLANK;
    }

    public Space(int row, int col, int state) {
        this.row = row;
        this.col = col;
        this.state = state;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
