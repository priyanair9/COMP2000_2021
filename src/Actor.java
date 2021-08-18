import java.awt.*;
import java.util.ArrayList;

public abstract class Actor {
    Color color;
    Cell loc;
    ArrayList<Polygon> polygons = new ArrayList<Polygon>();

    public void paint(Graphics g) {
        g.setColor(color);

        for(Polygon p: polygons) {
           g.drawPolygon(p);
           g.fillPolygon(p);
        }
    }
}
