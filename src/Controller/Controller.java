package Controller;

import javax.swing.*;
import Model.Model;
import View.Space;

import java.awt.*;
import java.awt.event.ActionListener;

public class Controller {

    public Controller(Model model, View.MainFrame view) {

        ActionListener play = e -> {
            Space space = (Space) e.getSource();
            int row = space.getRow();
            int col = space.getCol();

            int result = model.playMove(row, col);

            if (result == Model.HIT) {
                view.getBoard().setSpace(row, col, "X", java.awt.Color.RED);
            } else if (result == Model.MISS) {
                view.getBoard().setSpace(row, col, "M", new Color(207, 188, 17));
            }

            if (model.isGameOver()) {
                view.showGameEndMessage(model.getGameOverMessage());
            }

            view.getStatusDisplay().updateStatus(model.getMisses(), model.getStrikes(), model.getTotalMisses(), model.getTotalHits());
        };

        view.getBoard().setOnClick(play);

        ActionListener playAgain = e -> {
            view.getBoard().resetBoard();
            model.SetupBoard();
            view.getStatusDisplay().updateStatus(model.getMisses(), model.getStrikes(), model.getTotalMisses(), model.getTotalHits());
        };

        view.playAgain(playAgain);

        ActionListener quit = e -> {
            System.exit(0);
        };

        view.quit(quit);
    }

}
