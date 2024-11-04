package View;

import javax.swing.*;

public class StatusDisplay extends JPanel{

    private JTextField misses;
    private JTextField strikes;
    private JTextField totalMisses;
    private JTextField totalHits;

    public StatusDisplay() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        misses = new JTextField("Misses: 0");
        strikes = new JTextField("Strikes: 0");
        totalMisses = new JTextField("Total Misses: 0");
        totalHits = new JTextField("Total Hits: 0");

        misses.setEditable(false);
        strikes.setEditable(false);
        totalMisses.setEditable(false);
        totalHits.setEditable(false);

        add(misses);
        add(strikes);
        add(totalMisses);
        add(totalHits);
    }

    public void updateStatus(int misses, int strikes, int totalMisses, int totalHits) {
        updateMisses(misses);
        updateStrikes(strikes);
        updateTotalMisses(totalMisses);
        updateTotalHits(totalHits);
    }

    private void updateMisses(int misses) {
        this.misses.setText("Misses: " + misses);
    }

    private void updateStrikes(int strikes) {
        this.strikes.setText("Strikes: " + strikes);
    }

    private void updateTotalMisses(int totalMisses) {
        this.totalMisses.setText("Total Misses: " + totalMisses);
    }

    private void updateTotalHits(int totalHits) {
        this.totalHits.setText("Total Hits: " + totalHits);
    }


}
