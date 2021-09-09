import java.awt.Color;

class Car extends Actor {
  public Car(Cell inLoc, float inRedness) {
    loc = inLoc;
    redness = inRedness;
    color = new Color(148, 33, 146);
  }
}
