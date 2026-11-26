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


    public void makeBricks() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                bricks[i][j] = new Brick(i, j);
            }
        }
    }

    public void update(boolean left, boolean right) {
        if (state == GameState.GAME_OVER || state == GameState.VICTORY || state == GameState.PAUSED) {
            return;
        }

        if (left) {
            paddle.moveLeft();
        }
        if (right) {
            paddle.moveRight();
        }

        if (state == GameState.READY) {
            ball.reset(paddle);
            return;
        }

        ball.move();
        checkWallCollision();
        checkPaddleCollision();
        checkBrickCollision();

    }

    private void checkWallCollision() {
        if (ball.getX() <= 0) {
            ball.setX(0);
            ball.reverseX();
        }

        if (ball.getX() + ball.getSize() >= 800) {
            ball.setX(800 - ball.getSize());
            ball.reverseX();
        }

        if (ball.getY() <= 35) {
            ball.setY(35);
            ball.reverseY();
        }
    }

    private void checkPaddleCollision() {
        boolean hit = ball.getX() + ball.getSize() > paddle.getX()
                && ball.getX() < paddle.getX() + paddle.getWidth()
                && ball.getY() + ball.getSize() >= paddle.getHeight()
                && ball.getY() < paddle.getHeight();

        if (hit && ball.getVy() > 0) {
            ball.bounceOffPaddle(paddle);
        }
    }

    private void checkBrickCollision() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 8; col++) {
                Brick brick = bricks[row][col];
                if (brick.isDestroyed()) continue;

                double overlapX = Math.min(ball.getX() + ball.getSize(), brick.getX() + brick.getWidth())
                        - Math.max(ball.getX(), brick.getX());
                double overlapY = Math.min(ball.getY() + ball.getSize(), brick.getY() + brick.getHeight())
                        - Math.max(ball.getY(), brick.getY());

                if (overlapX > 0 && overlapY > 0){
                    brick.hit();
                    score += 100;

                    if (overlapX < overlapY){
                        ball.reverseX();
                    } else {
                        ball.reverseY();
                    }
                    return;
                }
            }
        }
    }

    private void checkLosingBall(){
        if (ball.getY() + ball.getSize() > 600){
            lives --;
            if (lives <= 0){
                state = GameState.GAME_OVER;
                saveScore();
            } else {
                state = GameState.READY;
                ball.reset(paddle);
            }
        }
    }

    private void saveScore(){
        storage.saveHighScore(score);
    }



}