import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SortingGame {
    private List<Tube> tubes;
    private int maxTubes;
    private int maxSpheres;
    private GameUI gameUI;

    public SortingGame(int level) {
        tubes = new ArrayList<>();
        gameUI = new GameUI(this, tubes); // corectat constructorul
        initializeGame(level);
    }

    public void initializeGame(int level) {
        if (level == 3) {
            maxTubes = 5;
            maxSpheres = 8;
        } else if (level == 2) {
            maxTubes = 4;
            maxSpheres = 6;
        } else {
            maxTubes = 3;
            maxSpheres = 4;
        }
        initializeTubes();
    }

    private void initializeTubes() {
        tubes.clear();
        for (int i = 0; i < maxTubes; i++) {
            tubes.add(new Tube());
        }

        Random rand = new Random();
        String[] colors = {"red", "yellow"};
        for (int i = 0; i < maxSpheres; i++) {
            tubes.get(rand.nextInt(maxTubes)).addSphere(SphereFactory.createSphere(colors[i % 2]));
        }
    }

    public void startGame() {
        JFrame frame = new JFrame("Sorting Game");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(gameUI);
        frame.setVisible(true);
    }

    public GameUI getGameUI() {
        return gameUI;
    }

    // Verifică dacă toate bilele sunt sortate corect
    public boolean isGameWon() {
        for (Tube tube : tubes) {
            if (!tube.isSorted()) { // dacă măcar un tub nu este sortat corect
                return false;
            }
        }
        return true;
    }

    // Afișează mesajul de felicitare doar când jocul este câștigat
    public void showCongratulationsMessage() {
        if (isGameWon()) {
            JOptionPane.showMessageDialog(gameUI, "Felicitări! Ai sortat toate bilele corect!", "Succes", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
