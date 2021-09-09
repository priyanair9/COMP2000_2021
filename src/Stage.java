import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Stage {
  Grid grid;
  List<Actor> actors;


  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for (Actor a: actors) {
      a.paint(g);   
    }
    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if (underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.DARK_GRAY);
      g.drawString(String.valueOf(hoverCell.col) + String.valueOf(hoverCell.row), 720, 50);
      g.drawString(hoverCell.description, 820, 50);
      // The following code is inelegant.
      // We could have also done something like the following:
      // if (hoverCell.describe() != "Building") {
      // however, that would have been a very fragile solution.
      if (hoverCell instanceof Landscape) {
        Landscape land = (Landscape) hoverCell;
        g.drawString("elevation", 720, 65);
        g.drawString(String.valueOf(land.elevation()), 820, 65);
      }
    }
  }
}
