import java.util.list;

public interface MoveStrategy {
    public Cell chooseNextLoc(List<Cell> possibleLocs);
}
