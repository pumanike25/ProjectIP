public class GameManager {
    private static GameManager instance;
    private int score;
    private int currentLevel;

    private GameManager() {
        score = 0;
        currentLevel = 1;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void nextLevel() {
        if (currentLevel < 3) {
            currentLevel++;
        }
    }

    public void reset() {
        score = 0;
        currentLevel = 1;
    }
}
