public class Paddle {
    private double x;
    private final double y = 545;
    private final double width = 100;
    private final double height = 15;
    private final double speed = 8;

    public void moveLeft(){
        x -= speed;
        if (x < 0){x =0;}
    }

    public void moveRight(){
        x += speed;
        if (x > 700){x = 700;}
    }


    public void reset(){
        x = 350;
    }

    public double getX(){return x;}
    public double getY(){return y;}
}

