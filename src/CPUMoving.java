import java.awt.Graphics;
import java.util.List;

public class CPUMoving implements GameState {
  @Override
  public void mouseClick(int x, int y, Stage s) {}

  @Override
  public void paint(Graphics g, Stage s) {
    for (Actor a: s.actors) {
      if (! a.isTeamRed()) {
        List<Cell> possibleLocs = s.getClearRadius(a.location(), a.getMoves(), true);
        possibleLocs.removeIf(a.filter);
        Cell nextLoc = a.strategy().chooseNextLoc(a.location(), possibleLocs);
        a.setLocation(nextLoc);
      }
    }
    s.currentState = new ChoosingActor();
    for (Actor a: s.actors) {
      a.resetTurns();
    }
  }

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}
