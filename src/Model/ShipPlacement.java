package Model;

public class ShipPlacement extends Space{

    final static String HORIZONTAL = "horizontal";
    final static String VERTICAL = "vertical";
    private String direction;

    public ShipPlacement(int row, int col, String direction) {
        super(row, col);
        this.direction = direction;
    }

    public ShipPlacement(Space space, String direction) {
        super(space.getRow(), space.getCol(), space.getState());
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public Space getSpace() {
        return new Space(getRow(), getCol(), getState());
    }
}
