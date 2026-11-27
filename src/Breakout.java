import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.graphics.GRect;
import java.awt.Color;
import acm.graphics.GLabel;
import java.awt.event.KeyEvent;



public class Breakout extends GraphicsProgram{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    public boolean leftPressed = false;
    public boolean rightPressed = false;
    private GameEngine game = new GameEngine(new InMemoryScoreStorage());
    private final double frame = (float)1000/60;

    public void init() {
        setSize(WIDTH, HEIGHT);
        setBackground(new Color(20, 25, 40));
        addKeyListeners();
    }

    public void run() {
        while (true) {
            game.update(leftPressed, rightPressed);
            drawGame();
            pause(frame);
        }

    }


    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT){leftPressed = true;}
        if(key == KeyEvent.VK_RIGHT){rightPressed = true;}

        if(key == KeyEvent.VK_SPACE) {game.startgame();}
        if(key == KeyEvent.VK_P) {game.pauseGame();}
        if(key == KeyEvent.VK_R) {game.reset();}
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT){leftPressed = false;}
        if(key == KeyEvent.VK_RIGHT){rightPressed = false;}
    }

    private void drawGame(){
        drawStatus();
        drawBall();
        drawBricks();
        drawMessage();
        drawPaddle();
    }

    private void drawStatus(){
        GRect bar = new GRect(0, 0, WIDTH, 35);
        bar.setFilled(true);
        bar.setFillColor(new Color(10, 40, 30));
        add(bar);

        GLabel scoreBar = new GLabel("Score: " + game.getScore(), 20, 24);
        GLabel livesBar = new GLabel("Lives: " + game.getLives(), 350, 24);
        GLabel highScoreBar = new GLabel("Best: " + game.getHighScore(), 680, 24);
        add(scoreBar);
        add(livesBar);
        add(highScoreBar);
    }


    private void drawBricks(){

        Brick[][] bricks = game.getBricks();
        for (int i = 0; i < 5; i ++){
            for (int j = 0; j < 8; j ++){
                Brick brick = bricks[i][j];
                if(!brick.isDestroyed()){
                    GRect rectan = new GRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
                    rectan.setFilled(true);
                    rectan.setFillColor(new Color(255, 255, 255));
                    add(rectan);
                }
            }
        }

    }


    private void drawPaddle(){
        Paddle paddle = game.getPaddle();
        GRect rectangle = new GRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
        rectangle.setFilled(true);
        rectangle.setFillColor(new Color(80, 205, 220));
        add(rectangle);

    }


    private void drawBall(){
        Ball ball = game.getBall();
        GOval circle = new GOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
        circle.setFilled(true);
        circle.setFillColor(new Color(255, 255, 255));
        add(circle);

    }


    private void drawMessage(){
        GameState state = game.getState();
        String message = null;

        if (state == GameState.READY) {message = "Press SPACE to start";}
        if (state == GameState.PAUSED) {message = "PAUSED - Press P to continue";}
        if (state == GameState.GAME_OVER) {message = "GAME OVER - Press R to restart";}
        if (state == GameState.VICTORY) {message = "VICTORY - Press R to paly again";}

        if (message != null) {
            GLabel label = new GLabel(message);
            label.setColor(new Color(255, 255, 255));
            double x = (WIDTH - label.getWidth()) / 2.0;
            add(label, x, 330);
        }

    }

    public static void main(String[] args){
        new Breakout().start(args);
    }
}
