import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;

public abstract class Actor {
    protected Cell loc;
    protected List<Polygon> display;
    protected float redness;
    protected int turns;
    protected int moves;
    protected MoveStrategy strat;

    public void paint(Graphics g) {
        for(Polygon p: display) {
            g.setColor(new Color(redness, 0f, 1f-redness, AnimationBeat.getInstance().phaseCompletion()/100f));
            g.fillPolygon(p);
            g.setColor(Color.GRAY);
            g.drawPolygon(p);
        }
    }

    protected abstract void setPoly();

    public boolean isTeamRed() {
        return getRedness() >= 0.5;
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

    public Cell location() {
      return loc;
    }

    public MoveStrategy strategy() {
      return strat;
    }

    public float getRedness() {
      return redness;
    }

    public int turnsLeft() {
      return turns;
    }

    public void setTurns(int initialTurns) {
      turns = initialTurns;
    }

    public void turnTaken() {
      turns--;
    }

    public int getMoves() {
      return moves;
    }
}
