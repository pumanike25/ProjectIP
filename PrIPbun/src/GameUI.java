import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

public class GameUI extends JPanel {
    private List<Tube> tubes;
    private Tube selectedTube = null;
    private Sphere selectedSphere = null;
    private SortingGame sortingGame;

    public GameUI(SortingGame sortingGame, List<Tube> tubes) {
        this.sortingGame = sortingGame;
        this.tubes = tubes;
        setPreferredSize(new Dimension(600, 400));
        setLayout(null);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleTubeClick(e.getX(), e.getY());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTubes(g);
    }

    private void drawTubes(Graphics g) {
        int xOffset = 50;
        for (int i = 0; i < tubes.size(); i++) {
            Tube tube = tubes.get(i);
            g.setColor(Color.BLACK);
            g.fillRect(xOffset, 50, 50, 200);
            int yOffset = 200;
            for (Sphere sphere : tube.getSpheres()) {
                g.setColor(sphere.getColor().equals("red") ? Color.RED : Color.YELLOW);
                g.fillOval(xOffset + 10, yOffset - 30, 30, 30);
                yOffset -= 40;
            }
            xOffset += 100;
        }
    }

    private void handleTubeClick(int x, int y) {
        int tubeIndex = (x - 50) / 100;
        if (tubeIndex >= 0 && tubeIndex < tubes.size()) {
            Tube clickedTube = tubes.get(tubeIndex);
            if (selectedSphere == null) {
                if (!clickedTube.isEmpty()) {
                    selectedSphere = clickedTube.removeSphere();
                }
            } else {
                if (clickedTube.isEmpty() || selectedSphere.getColor().equals(clickedTube.getTopColor())) {
                    clickedTube.addSphere(selectedSphere);
                    selectedSphere = null;
                    sortingGame.showCongratulationsMessage(); // Afișează mesajul dacă jocul este câștigat
                }
            }
        }
        repaint();
    }
}
