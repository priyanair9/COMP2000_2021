import java.awt.Color;
import java.awt.*;

public class Train implements Actor{
    Cell position;

    public Train(Cell position) {
        this.position = position;
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(position.x, position.y, position.width, position.height);
    }
}
