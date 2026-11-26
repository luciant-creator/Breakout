public class GameEngine {
    private final Paddle paddle = new Paddle();
    private final Ball ball = new Ball();
    private final Brick[][] bricks = new Brick[5][8];
    private GameState state = GameState.READY;
    private final HighScoreStorage storage;

    private int score = 0;
    private int lives = 3;


    public GameEngine(HighScoreStorage st) {
        storage = st;
    }

}