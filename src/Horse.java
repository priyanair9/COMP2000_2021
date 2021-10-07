import java.awt.Color;
import java.awt.Graphics;

public class Horse extends Actor {
  Motif image;

  public Horse(Cell inLoc, float inRedness) {
    setLocation(inLoc);
    redness = inRedness;
    turns = 1;
    moves = 1;
    image = new Motif("images/chess/Chess_tile_nl.png");
  }

  public void paint(Graphics g) {
    // Task 22 only needs the following draw method
    // image.draw(g, loc.x, loc.y, new Color(redness, 0.0f, 1.0f - redness));
    // However, if we want to include AnimationBeat we can change the saturation to the beat
    Float phase = AnimationBeat.getInstance().phaseCompletion() / 100.0f;
    image.draw(g, loc.x, loc.y, Color.getHSBColor((redness * 120.0f + 240.0f) / 360.0f, phase, 1.0f));
  }

  protected void setPoly() {}
}
