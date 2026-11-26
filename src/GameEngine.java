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
        makeBricks();
    }


    public void makeBricks(){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 8; j++){
                bricks[i][j] = new Brick(i, j);
            }
        }
    }

    public void update(boolean left, boolean right){
        if (state == GameState.GAME_OVER || state == GameState.VICTORY || state == GameState.PAUSED){
            return;
        }

        if (left){paddle.moveLeft();}
        if (right){paddle.moveRight();}

        if (state == GameState.READY){
            ball.reset(paddle);
            return;
        }

        ball.move();
        checkWallCollision();

    }

    private void checkWallCollision(){
        if (ball.getX() <= 0){
            ball.setX(0);
            ball.reverseX();
        }

        if (ball.getX() + ball.getSize() >= 800){
            ball.setX(800 - ball.getSize());
            ball.reverseX();
        }

        if (ball.getY() <= 35){
            ball.setY(35);
            ball.reverseY();
        }
    }



}