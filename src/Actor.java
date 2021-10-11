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
        animate(g);
        for(Polygon p: display) {
            g.setColor(new Color(redness, 0f, 1f-redness, AnimationBeat.getInstance().phaseCompletion()/100f));
            g.fillPolygon(p);
            g.setColor(Color.GRAY);
            g.drawPolygon(p);
        }
    }

    private void animate(Graphics g) {
        AnimationBeat instance = AnimationBeat.getInstance();
        char phase = instance.inPhase(); // phase the actor is in
        long completion = instance.phaseCompletion(); //the % completed
        int backup_x = loc.x;
        int backup_y = loc.y;
        switch (phase) {
            case 'a': loc.y += offset(completion);
                break;
            case 'b': loc.x -= offset(completion);
                break;
            case 'c': loc.x += offset(completion);
        }
        setPoly();
        loc.x = backup_x;
        loc.y = backup_y;
    }
    private long offset(long p) {
        if (p < 50) {
            return p / 2;
        }
        return 50 - p / 2;
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

