import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;
import java.util.Random;

class Grid {
  private Cell[][] cells = new Cell[20][20];
  private static Random rand = new Random();

  public Grid() {
    int elevation;
    int current;
    int grassCount = 0;
    int buildingCount = 0;
    int roadCount = 0;
    int mountainCount = 0;
    int waterCount = 0;
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[i].length; j++) {
        // altitude vary over the following range:
        // -500 <= elevation <= 6000
        // this means that there are 6501 possible
        // values including zero
        elevation = rand.nextInt(6501) - 500;
        // grab a random element from our list
        // use the element's value to determine
        // which cell type to instantiate
        // and then remove that element from the list
        // so that there are no repeats 
        current = rand.nextInt(100);
        //  Road: 10%
        int x = 10 + 35 * i;
        int y = 10 + 35 * j;
        if (current < 10) {
          roadCount++;
          cells[i][j] = new Road(colToLabel(i), j, x, y, elevation);
        }
        // Water: 20%
        if (current >= 10 && current < 30) {
          waterCount++;
          cells[i][j] = new Water(colToLabel(i), j, x, y, elevation);
        }
        // Grass: 40%
        if (current >= 30 && current < 70) {
          grassCount++;
          cells[i][j] = new Grass(colToLabel(i), j, x, y, elevation);
        }
        // Mountain: 25%
        if (current >= 70 && current < 95) {
          mountainCount++;
          cells[i][j] = new Mountain(colToLabel(i), j, x, y, elevation);
        }
        // Buildings: 5%
        if (current >= 95 && current < 100) {
          buildingCount++;
          cells[i][j] = new Building(colToLabel(i), j, x, y);
        }
      }
    }
    System.out.printf("Road: %d, expected %2.0f\n", roadCount, 20 * 20 * 0.10);
    System.out.printf("Water: %d, expected %2.0f\n", waterCount, 20 * 20 * 0.20);
    System.out.printf("Grass: %d, expected %2.0f\n", grassCount, 20 * 20 * 0.40);
    System.out.printf("Mountains: %d, expected %2.0f\n", mountainCount, 20 * 20 * 0.25);
    System.out.printf("Buildings: %d, expected %2.0f\n", buildingCount, 20 * 20 * 0.05);
  }

  public void paint(Graphics g, Point mousePos) {
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[i].length; j++) {
        cells[i][j].paint(g, mousePos);
      }
    }
  }

  private char colToLabel(int col) {
    return (char) (col + 65);
  }

  private int labelToCol(char col) {
    return (int) col - 65;
  }

  public Cell cellAtColRow(int c, int r) {
    return cells[c][r];
  }

  public Optional<Cell> cellAtPoint(Point p) {
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[i].length; j++) {
        if (cells[i][j].contains(p)) {
          return Optional.of(cells[i][j]);
        }
      }
    }
    return Optional.empty();
  }
}
