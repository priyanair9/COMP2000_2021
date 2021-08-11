import java.awt.Color;
import java.awt.Graphics;

public class Boat implements Actor{

    Cell position;

    public Boat(Cell position) {
        this.position = position;
    }

    public void paint(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(position.x, position.y, position.width, position.height);
    }
}
