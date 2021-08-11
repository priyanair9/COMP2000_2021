import java.awt.*;

class Cell extends Rectangle { 
    // fields
    //DELETE FIELDS
    // int x;
    // int y;
    static int size = 35;

    //constructors
    public Cell(int x, int y){
        super(x,y,size,size);
        //DELETE FIELDS
        // this.x = x;
        // this.y = y;
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

    public boolean contains(Point p){
        if (p != null){
            return super.contains(p);
            // return (x < p.x && x+size > p.x && y < p.y && y+size > p.y);
        } else {
            return false;
        }
    }
}