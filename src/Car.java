import java.awt.Color;
import java.awt.Graphics;

public class Car implements Actor{
    
        Cell position;

    public Car(Cell position) {
        this.position = position;
    }

    public void paint(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(position.x, position.y, position.width, position.height);
    }
    }
