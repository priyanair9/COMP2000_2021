import java.awt.Graphics;
import java.awt.Point;

public class Stage {

    Grid grid;

    Actor train;
    Actor boat;
    Actor car;
    
    public Stage() {
        grid = new Grid();
        train = new Train(grid.cells[5][5]);
        boat = new Boat(grid.cells[15][15]);
        car = new Car(grid.cells[9][2]);
    }

    public void paint(Graphics g, Point mousePosition) {
        grid.paint(g, mousePosition);
        train.paint(g);
        boat.paint(g);
        car.paint(g);
    }

}
