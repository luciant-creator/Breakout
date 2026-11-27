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

        GLabel scoreBar = new GLabel("Score: ", 20, 24);
        GLabel livesBar = new GLabel("Lives: ", 350, 24);
        GLabel highScoreBar = new GLabel("Best: ", 680, 24);
        add(scoreBar);
        add(livesBar);
        add(highScoreBar);
    }


    private void drawBricks(){

    }


    private void drawPaddle(){

    }


    private void drawBall(){

    }


    private void drawMessage(){

    }

    public static void main(String[] args){
        new Breakout().start(args);
    }
}
