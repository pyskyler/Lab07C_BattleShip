import javax.swing.*;

public class StatusDisplay extends JPanel{

    private JTextField misses;
    private JTextField hits;
    private JTextField totalMisses;
    private JTextField totalHits;

    public StatusDisplay() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        misses = new JTextField("Misses: 0");
        hits = new JTextField("Hits: 0");
        totalMisses = new JTextField("Total Misses: 0");
        totalHits = new JTextField("Total Hits: 0");

        misses.setEditable(false);
        hits.setEditable(false);
        totalMisses.setEditable(false);
        totalHits.setEditable(false);

        add(misses);
        add(hits);
        add(totalMisses);
        add(totalHits);
    }

    public void updateStatus(int misses, int hits, int totalMisses, int totalHits) {
        updateMisses(misses);
        updateHits(hits);
        updateTotalMisses(totalMisses);
        updateTotalHits(totalHits);
    }

    private void updateMisses(int misses) {
        this.misses.setText("Misses: " + misses);
    }

    private void updateHits(int hits) {
        this.hits.setText("Hits: " + hits);
    }

    private void updateTotalMisses(int totalMisses) {
        this.totalMisses.setText("Total Misses: " + totalMisses);
    }

    private void updateTotalHits(int totalHits) {
        this.totalHits.setText("Total Hits: " + totalHits);
    }


}
