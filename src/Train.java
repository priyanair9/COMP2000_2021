import java.awt.*;

public class Train extends Actor {
    public Train(Cell inLoc) {
        loc = inLoc;
        color = Color.RED;

int sides=20;
int angle;
double circleX;
double circleY;
Polygon rearWheel = new Polygon();
Polygon midWheel = new Polygon();
Polygon frontWheel = new Polygon();
angle = 360/sides;
for(int s=0; s<=sides; s++) {
  circleX = (3.0*Math.sin(Math.toRadians(s*angle)));
  circleY = (3.0*Math.cos(Math.toRadians(s*angle)));
  rearWheel.addPoint(loc.x + 9 + (int) circleX, loc.y + 25 + (int) circleY);
  midWheel.addPoint(loc.x + 17 + (int) circleX, loc.y + 25 + (int) circleY);
  frontWheel.addPoint(loc.x + 23 + (int) circleX, loc.y + 25 + (int) circleY);
}
Polygon cab = new Polygon();
cab.addPoint(loc.x + 6, loc.y + 7);
cab.addPoint(loc.x + 11, loc.y + 7);
cab.addPoint(loc.x + 11, loc.y + 20);
cab.addPoint(loc.x + 6, loc.y + 20);
Polygon body = new Polygon();
body.addPoint(loc.x + 11, loc.y + 14);
body.addPoint(loc.x + 24, loc.y + 14);
body.addPoint(loc.x + 29, loc.y + 20);
body.addPoint(loc.x + 11, loc.y + 20);

    polygons.add(rearWheel);
    polygons.add(midWheel);
    polygons.add(frontWheel);
    polygons.add(cab);
    polygons.add(body);
    }

}
