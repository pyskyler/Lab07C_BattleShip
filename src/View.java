import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    Board board;
    StatusDisplay statusDisplay;

    public View() {

        setTitle("Battleship");
        setSize(800, 600);

        JPanel mainPanel = new JPanel();
        setLayout(new BorderLayout());

        board = new Board();
        statusDisplay = new StatusDisplay();

        mainPanel.add(board, BorderLayout.CENTER);
        mainPanel.add(statusDisplay, BorderLayout.NORTH);

        add(mainPanel);

    }
}
