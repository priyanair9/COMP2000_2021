import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class StackedActors extends Actor {
  List<Actor> stack;

  public StackedActors(Actor above, Actor below) {
    stack = new ArrayList<Actor>();
    stack.add(above);
    stack.add(below);
    setPoly();
  }

  void add(Actor a) {
    stack.add(a);
  }  

  @Override
  public void setPoly() {
    stack.get(0).setPoly();
  }

  @Override
  public Cell location() {
    return stack.get(0).location();
  }

  @Override
  public MoveStrategy strategy() {
    return stack.get(0).strategy();
  }

  @Override
  public float getRedness() {
    float tot = 0.0f;
    for(Actor a : stack) {
      tot = tot + a.getRedness();
    }
    return tot / stack.size();
  }

  @Override
  public int getMoves() {
    int curr = stack.get(0).getMoves();
    for(Actor a : stack) {
      if (a.getMoves() < curr) {
        curr = a.getMoves();
      }
    }
    return curr;
  }

  @Override
  public void paint(Graphics g) {
    stack.get(0).paint(g);
  }

  @Override
  public void setLocation(Cell inLoc) {
    for (Actor a : stack) {
      a.setLocation(inLoc);
    }
  }
}
