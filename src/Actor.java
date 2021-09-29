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
        animate(g);
        for(Polygon p: display) {
            g.setColor(new Color(redness, 0f, 1f-redness));
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

