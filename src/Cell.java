import java.awt.*;
class Cell extends Rectangle {
    // fields
    static int size = 35;

    //constructors
    public Cell(int x, int y){
        super(x, y, size, size);
    }

    //methods
    void paint(Graphics g, Point mousePos){
        if(contains(mousePos)){
            g.setColor(Color.GRAY);
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(x,y,size,size);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,size,size);
    }

    @Override
    public boolean contains(Point p){
        if (p != null){
            return(super.contains(p));
        } else {
            return false;
        }
    }
}