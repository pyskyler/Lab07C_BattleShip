package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Board extends JPanel {

    private Space[][] board = new Space[10][10];
    private int ROW = 10;
    private int COL = 10;

    public Board() {
        super();

        setLayout(new GridLayout(10, 10));

        for (int row = 0; row<ROW; row++) {
            for (int col = 0; col<COL; col++) {
                Space space = new Space(row, col);
                space.setText("~");
                space.setForeground(Color.BLUE);
                board[row][col] = space;
                add(space);
            }
        }
    }

    public void setSpace(int row, int col, String text, Color color) {
        board[row][col].setText(text);
        board[row][col].setForeground(color);
    }

    public void resetBoard() {
        for (int row = 0; row<ROW; row++) {
            for (int col = 0; col<COL; col++) {
                board[row][col].setText("~");
                board[row][col].setForeground(Color.BLUE);
            }
        }
    }

    public void setOnClick(ActionListener e) {
        for (int row = 0; row<ROW; row++) {
            for (int col = 0; col<COL; col++) {
                board[row][col].addActionListener(e);
            }
        }
    }
}
