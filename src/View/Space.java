package View;

import javax.swing.*;

public class Space extends JButton {
    private int row;
    private int col;

    public Space(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        this.setPreferredSize(new java.awt.Dimension(50, 50));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
