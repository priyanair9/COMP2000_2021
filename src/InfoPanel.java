import java.awt.Graphics;
import java.awt.Point;

public abstract class InfoPanel {
  final int hTab = 10;
  final int vTab = 15;
  final int blockVtab = 35;
  final int margin = 21 * blockVtab;

  public void add(InfoPanel informationPanel) {
    throw new UnsupportedOperationException();
  }

  public void remove(InfoPanel informationPanel) {
    throw new UnsupportedOperationException();
  }

  public InfoPanel getChild(int i) {
    throw new UnsupportedOperationException();
  }

  public void paint(Graphics g, int yloc, Point mouseLoc) {
    throw new UnsupportedOperationException();
  }
}
