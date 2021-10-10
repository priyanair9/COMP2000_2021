import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class SidePanel extends InfoPanel {
  ArrayList<InfoPanel> InfoPanels = new ArrayList<InfoPanel>();

  @Override
  public void add(InfoPanel InfoPanel) {
    InfoPanels.add(InfoPanel);
  }

  @Override
  public void remove(InfoPanel InfoPanel) {
    InfoPanels.remove(InfoPanel);
  }

  @Override
  public InfoPanel getChild(int i) {
    return InfoPanels.get(i);
  }

  @Override
  public void paint(Graphics g, int yloc, Point mouseLoc) {
    for (InfoPanel panel : InfoPanels) {
      panel.paint(g, yloc, mouseLoc);
    }
  }
}
