public class Ball {
    private double x;
    private double y;
    private double vx;
    private double vy;
    private final double ballSize = 16;
    private final double startingSpeed = 6;



    public void reset(Paddle paddle){
        x = paddle.getX() + 42;
        y = 529;

        vx = 0;
        vy = 0;
    }

    public void ballStart(){
        vx = 1;
        vy = -Math.sqrt(startingSpeed * startingSpeed - vx * vx);
    }

    public void move(){
        x += vx;
        y += vy;
    }

    public void reverseX(){
        vx = -vx;
    }

    public void reverseY(){
        vy = -vy;
    }


    public void bounceOffPaddle(Paddle paddle) {
        double paddleCenter = paddle.getX() + paddle.getWidth() / 2.0;
        double ballCenter = x + ballSize / 2.0;
        double deltaX = ballCenter - paddleCenter;
        double halfWidth = paddle.getWidth() / 2.0;

        double offset = deltaX / halfWidth;
        offset = Math.max(-1.0, Math.min(1.0, offset));

        double angle = offset * Math.toRadians(60.0);
        double speed = Math.hypot(vx, vy);
        vx = speed * Math.sin(angle);
        vy = -Math.abs(speed * Math.cos(angle));

    }



    public double getX(){return x;}
    public double getY(){return y;}
    public double getVx(){return vx;}
    public double getVy(){return vy;}
    public double getSize(){return ballSize;}
    public void setX(double x){this.x = x;}
    public void setY(double y){this.y = y;}


}
