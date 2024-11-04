package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private Board board;
    private StatusDisplay statusDisplay;
    JButton playAgain = new JButton("Play Again");
    JButton quit = new JButton("Quit");

    public MainFrame() {

        setTitle("Battleship");
        setSize(800, 600);

        JPanel mainPanel = new JPanel();
        setLayout(new BorderLayout());

        board = new Board();
        statusDisplay = new StatusDisplay();

        mainPanel.add(board, BorderLayout.CENTER);
        mainPanel.add(statusDisplay, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(playAgain);
        buttonPanel.add(quit);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public Board getBoard() {
        return board;
    }

    public StatusDisplay getStatusDisplay() {
        return statusDisplay;
    }

    public void showGameEndMessage(String s) {
        JOptionPane.showMessageDialog(this, s);
    }

    public void quit (ActionListener e) {
        quit.addActionListener(e);
    }

    public void playAgain (ActionListener e) {
        playAgain.addActionListener(e);
    }
}
