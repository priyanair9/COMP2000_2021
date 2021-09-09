import java.awt.Color;

class Boat extends Actor {
  public Boat(Cell inLoc, float inRedness) {
    loc = inLoc;
    redness = inRedness;
    color = Color.ORANGE;
  }
}
