import View.MainFrame;

import javax.swing.*;

public class BattleshipApp {

    public static void main(String[] args) {
        Model.Model model = new Model.Model();
        MainFrame mainFrame = new MainFrame();
        Controller.Controller controller = new Controller.Controller(model, mainFrame);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
