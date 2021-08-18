import java.awt.*;

public class Boat extends Actor {
    public Boat(Cell inLoc) {
        loc = inLoc;
        color = Color.ORANGE;

        Polygon leftSail = new Polygon();
        leftSail.addPoint(loc.x + 16, loc.y + 11);
        leftSail.addPoint(loc.x + 11, loc.y + 24);
        leftSail.addPoint(loc.x + 16, loc.y + 24);
        Polygon rightSail = new Polygon();
        rightSail.addPoint(loc.x + 18, loc.y + 7);
        rightSail.addPoint(loc.x + 24, loc.y + 24);
        rightSail.addPoint(loc.x + 18, loc.y + 24);
        Polygon body = new Polygon();
        body.addPoint(loc.x + 6, loc.y + 24);
        body.addPoint(loc.x + 29, loc.y + 24);
        body.addPoint(loc.x + 24, loc.y + 29);
        body.addPoint(loc.x + 11, loc.y + 29);

    polygons.add(leftSail);
    polygons.add(rightSail);
    polygons.add(body);
    }
}
