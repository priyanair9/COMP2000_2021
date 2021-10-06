import java.awt.Color;
import java.awt.Graphics;

public class Horse extends Actor { 
  public Motif icon;

  public Horse(Cell inLoc, float inRedness) {
    setLocation(inLoc);
        redness = inRedness;
        turns = 1;
        moves = 1;
        setPoly();
  }

  protected void setPoly() {
    icon = new Motif("images/chess/Chess_tile_nl.png");
  }

  @Override
  public void paint(Graphics g) {
    icon.draw(g, loc.x, loc.y, Color.PINK);
  }
}
