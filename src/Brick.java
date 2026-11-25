public class Brick {
    private final double x;
    private final double y;
    private final double width = 85;
    private final double height = 25;


    public Brick(int row, int col){
        x = 39 + col * 91;
        y = 60 + row * 31;
    }

    public boolean hit(){
        return true;
    }

}
