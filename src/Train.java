import java.awt.Color;

class Train extends Actor {
  public Train(Cell inLoc, float inRedness) {
    loc = inLoc;
    redness = inRedness;
    color = Color.RED;
  }
}
