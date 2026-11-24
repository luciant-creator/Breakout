import acm.program.GraphicsProgram;
import acm.graphics.GRect;
import java.awt.Color;



public class Breakout extends GraphicsProgram{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public void run(){
        setSize(WIDTH, HEIGHT);

    }

    public static void main(String[] args){
        new Breakout().start(args);
    }
}
