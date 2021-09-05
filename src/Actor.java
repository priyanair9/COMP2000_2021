import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;

public abstract class Actor {
    Cell loc;
    List<Polygon> display;
    float redness;
    int turns;
    int moves;
    MoveStrategy strat;

    public void paint(Graphics g) {
        for(Polygon p: display) {
            g.setColor(new Color(redness, 0f, 1f-redness));
            g.fillPolygon(p);
            g.setColor(Color.GRAY);
            g.drawPolygon(p);
        }
    }

    protected abstract void setPoly();

    public boolean isTeamRed() {
        return redness >= 0.5;
    }

    public void setLocation(Cell inLoc) {
        loc = inLoc;
        if (loc.row % 2 == 0) {
            strat = new RandomMove();
        } else {
            strat = new LeftMostMove();
        }
        setPoly();
    }
}
