public class GameFacade {
    private SortingGame sortingGame;
    private GameUI gameUI;
    private GameManager gameManager;

    public GameFacade(int level) {
        gameManager = GameManager.getInstance();
        sortingGame = new SortingGame(level);
        gameUI = sortingGame.getGameUI();
    }

    public void startGame() {
        sortingGame.startGame();
    }

    public void resetGame() {
        gameManager.reset();
        sortingGame.initializeGame(gameManager.getCurrentLevel());
    }

    public void nextLevel() {
        gameManager.nextLevel();
        sortingGame.initializeGame(gameManager.getCurrentLevel());
    }

    public int getScore() {
        return gameManager.getScore();
    }

    public void incrementScore() {
        gameManager.incrementScore();
    }

    public void closeGame() {
        System.exit(0);
    }
}
