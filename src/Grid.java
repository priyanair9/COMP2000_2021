import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Grid {
  private Cell[][] cells = new Cell[20][20];
  private static Random rand = new Random();

  public Grid() {
    int elevation;
    // The grid is 20x20=400 cells
    // Create a list of integers numbered 0 through 399
    List<Integer> distribution = new ArrayList<Integer>();
    distribution = IntStream.rangeClosed(0, 20 * 20 - 1).boxed().collect(Collectors.toList());
    int current;
    int index;
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
        index = rand.nextInt(distribution.size());
        current = distribution.get(index);
        distribution.remove(index);
        //  Road: 10%
        char c = colToLabel(i);
        int x = 10 + 35 * i;
        int y = 10 + 35 * j;
        //  Road: 10% of 400 = 40
        if (current < 40) {
          roadCount++;
          cells[i][j] = new Road(c, j, x, y, elevation);
        }
        // Water: 20% of 400 = 80
        if (current >= 40 && current < 120) {
          waterCount++;
          cells[i][j] = new Water(c, j, x, y, elevation);
        }
        // Grass: 40% of 400 = 160
        if (current >= 120 && current < 280) {
          grassCount++;
          cells[i][j] = new Grass(c, j, x, y, elevation);
        }
        // Mountain: 25% of 400 = 100
        if (current >= 280 && current < 380) {
          mountainCount++;
          cells[i][j] = new Mountain(c, j, x, y, elevation);
        }
        // Buildings: 5% of 400 = 20
        if (current >= 380 && current < 400) {
          buildingCount++;
          cells[i][j] = new Building(c, j, x, y);
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

  private Optional<Cell> cellAtColRow(int c, int r) {
    if (c >= 0 && c < cells.length && r >= 0 && r < cells[c].length) {
      return Optional.of(cells[c][r]);
    } else {
      return Optional.empty();
    }
  }

  public Optional<Cell> cellAtColRow(char c, int r) {
    return cellAtColRow(labelToCol(c), r);
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

  public List<Cell> cellsInRange(char c1, int r1, char c2, int r2) {
    int c1i = labelToCol(c1);
    int c2i = labelToCol(c2);
    List<Cell> output = new ArrayList<Cell>();
    for (int i = c1i; i <= c2i; i++) {
      for (int j = r1; j <= r2; j++) {
        cellAtColRow(colToLabel(i), j).ifPresent(output::add);
      }
    }
    return output;
  }

  public void replaceCell(Cell old, Cell replacement) {
    cells[labelToCol(old.col)][old.row] = replacement;
  }
}
