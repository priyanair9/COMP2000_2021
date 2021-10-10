import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;
import java.util.function.Predicate;

abstract class Actor {
  private Cell loc;
  private float redness;
  private int initialTurns;
  private int turns;
  private int moves;
  private int range;
  private MoveStrategy strat;
  protected List<Polygon> display;
  protected Predicate<Cell> filter;

  public Actor(Cell inLoc, float inRedness, int inTurns, int inMoves, int inRange) {
    setLocation(inLoc);
    redness = inRedness;
    initialTurns = inTurns;
    turns = initialTurns;
    moves = inMoves;
    range = inRange;
    strat = new RandomMove();
  }

  void paint(Graphics g) {
    for (Polygon p : display) {
      g.setColor(Color.getHSBColor((redness * 120.0f + 240.0f) / 360.0f, 1.0f, 1.0f));
      g.fillPolygon(p);
      g.setColor(Color.GRAY);
      g.drawPolygon(p);
    }
  }

  protected abstract void setPoly();

  boolean isTeamRed() {
    return redness >= 0.5;
  }

  void setLocation(Cell inLoc) {
    loc = inLoc;
    setPoly();
  }

  void makeRedder(float amt) {
    redness = redness + amt;
    if (redness > 1.0f) {
      redness = 1.0f;
    }
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

  public void resetTurns() {
    turns = initialTurns;
  }

  public void turnTaken() {
    turns--;
  }

  public int getMoves() {
    return moves;
  }

  public int getRange() {
    return range;
  }

  public String toString() {
    return this.getClass().getName().toString();
  }
}
