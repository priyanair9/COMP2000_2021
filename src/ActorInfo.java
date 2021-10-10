import java.awt.Graphics;
import java.awt.Point;

public class ActorInfo extends InfoPanel {
  Stage stage;

  public ActorInfo(Stage stage) {
    this.stage = stage;
  }

  @Override
  public void paint(Graphics g, int yloc, Point mouseLoc) {
    final int labelIndent = margin + hTab;
    final int valueIndent = margin + 3 * blockVtab;
    yloc = yloc + 2 * blockVtab;
    for (int i = 0; i < stage.actors.size(); i++) {
      Actor a = stage.actors.get(i);
      yloc = yloc + 2 * blockVtab;
      g.drawString(a.getClass().toString(), margin, yloc);
      g.drawString("location:", labelIndent, yloc + vTab);
      String coordinate = Character.toString(a.loc.col) + Integer.toString(a.loc.row);
      g.drawString(coordinate, valueIndent, yloc + vTab);
      g.drawString("redness:", labelIndent, yloc + 2 * vTab);
      g.drawString(Float.toString(a.redness), valueIndent, yloc + 2 * vTab);
    }
  }
}
