import java.awt.*;

public class Car extends Actor {
    public Car(Cell inLoc) {
        loc = inLoc;
        color = new Color(148, 33, 146); // or we could use Color.MAGENTA

    int sides=20;
    int angle;
    double circleX;
    double circleY;
    Polygon rearWheel = new Polygon();
    Polygon frontWheel = new Polygon();
    angle = 360/sides;
    for(int s=0; s<=sides; s++) {
    circleX = (4.0*Math.sin(Math.toRadians(s*angle)));
    circleY = (4.0*Math.cos(Math.toRadians(s*angle)));
    rearWheel.addPoint(loc.x + 11 + (int) circleX, loc.y + 25 + (int) circleY);
    frontWheel.addPoint(loc.x + 24 + (int) circleX, loc.y + 25 + (int) circleY);
    }
    Polygon body = new Polygon();
    body.addPoint(loc.x + 6, loc.y + 14);
    body.addPoint(loc.x + 29, loc.y + 14);
    body.addPoint(loc.x + 29, loc.y + 20);
    body.addPoint(loc.x + 6, loc.y + 20);
    Polygon top = new Polygon();
    top.addPoint(loc.x + 11, loc.y + 7);
    top.addPoint(loc.x + 20, loc.y + 7);
    top.addPoint(loc.x + 24, loc.y + 14);
    top.addPoint(loc.x + 11, loc.y + 14);

    polygons.add(rearWheel);
    polygons.add(frontWheel);
    polygons.add(body);
    polygons.add(top);
    }
    
}

