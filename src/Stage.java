import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Stage {
  Grid grid;
  List<Actor> actors;
  List<Cell> cellOverlay;
  List<MenuItem> menuOverlay;
  Optional<Actor> actorInAction;

  GameState currentState;
  InfoPanel sidePanel;

  Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    cellOverlay = new ArrayList<Cell>();
    menuOverlay = new ArrayList<MenuItem>();
    actorInAction = Optional.empty();
    currentState = new ChoosingActor();

    sidePanel = new SidePanel();
    sidePanel.add(new StageInfo(this));
    sidePanel.add(new ActorInfo(this));
  }

  void paint(Graphics g, Point mouseLoc) {
    // do we have AI moves to make
    currentState.paint(g, this);

    grid.paint(g, mouseLoc);
    grid.paintOverlay(g, cellOverlay, new Color(0f, 0f, 1f, 0.5f));

    for (Actor a : actors) {
      a.paint(g);
    }

    int yloc = 20;
    sidePanel.paint(g, yloc, mouseLoc);

    // menu overlay (on top of everything else)
    for (MenuItem mi: menuOverlay) {
      mi.paint(g);
    }
  }

  List<Cell> getClearRadius(Cell from, int size, boolean considerElevation) {
    List<Cell> init = grid.getRadius(from, size, considerElevation);
    for (Actor a : actors) {
      init.remove(a.loc);
    }
    return init;
  }

  void mouseClicked(int x, int y) {
    currentState.mouseClick(x, y, this);
  }

  Optional<Actor> actorAt(Cell c) {
    for (Actor a : actors) {
      if (a.loc == c) {
        return Optional.of(a);
      }
    }
    return Optional.empty();
  }
}
