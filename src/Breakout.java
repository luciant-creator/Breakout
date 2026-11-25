import acm.program.GraphicsProgram;
import acm.graphics.GRect;
import java.awt.Color;
import acm.graphics.GLabel;


public class Breakout extends GraphicsProgram{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public void init(){
        setSize(WIDTH, HEIGHT);
        setBackground(new Color(20, 25, 40));
    }

    public void run(){
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
