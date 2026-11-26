public class Brick {
    private final double x;
    private final double y;
    private final double width = 85;
    private final double height = 25;
    private boolean destroyed = false;


    public Brick(int row, int col){
        x = 39 + col * 91;
        y = 60 + row * 31;
    }

    public boolean hit(){
        if (destroyed){
            return false;
        }
        destroyed = true;
        return true;
    }


    public double getX(){return x;}
    public double getY(){return y;}
    public double getWidth(){return width;}
    public double getHeight(){return height;}
    public boolean isDestroyed(){return destroyed;}

}
