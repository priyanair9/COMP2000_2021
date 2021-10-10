import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Optional;

public class SelectingNewLocation implements GameState {
  @Override
  public void mouseClick(int x, int y, Stage s) {
    Optional<Cell> clicked = Optional.empty();
    for (Cell c : s.cellOverlay) {
      if (c.contains(x, y)) {
        clicked = Optional.of(c);
      }
    }
    if (clicked.isPresent() && s.actorInAction.isPresent()) {
      s.cellOverlay = new ArrayList<Cell>();
      Actor theActor = s.actorInAction.get();
      theActor.setLocation(clicked.get());
      theActor.turnTaken();
      s.menuOverlay.add(new MenuItem("Fire", x, y, () -> {
        s.cellOverlay = s.grid.getRadius(theActor.location(), theActor.getRange(), false);
        s.cellOverlay.remove(theActor.location());
        s.currentState = new SelectingTarget();
      }));
      s.currentState = new SelectingMenuItem();
    }
  }

  @Override
  public void paint(Graphics g, Stage s) {}

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}
