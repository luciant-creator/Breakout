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

    public void init(){
        setSize(WIDTH, HEIGHT);
        setBackground(new Color(20, 25, 40));
        addKeyListeners();
    }

    public void run(){
    }


    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT){leftPressed = true;}
        if(key == KeyEvent.VK_RIGHT){rightPressed = true;}
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
