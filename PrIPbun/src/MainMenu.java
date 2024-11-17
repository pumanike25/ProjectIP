import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Meniu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Selectează un nivel pentru a începe jocul", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        JButton level1Button = new JButton("Nivel 1");
        JButton level2Button = new JButton("Nivel 2");
        JButton level3Button = new JButton("Nivel 3");

        panel.add(level1Button);
        panel.add(level2Button);
        panel.add(level3Button);
        add(panel, BorderLayout.CENTER);

        level1Button.addActionListener(e -> startGame(1));
        level2Button.addActionListener(e -> startGame(2));
        level3Button.addActionListener(e -> startGame(3));

        setVisible(true);
    }

    private void startGame(int level) {
        dispose();
        GameFacade gameFacade = new GameFacade(level);
        gameFacade.startGame();
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
