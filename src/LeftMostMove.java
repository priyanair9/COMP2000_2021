import java.util.List;

public class LeftMostMove implements MoveStrategy {
    
    @Override
    public Cell chooseNextLoc(List<Cell> possibleLocs) {
        Cell currLN = possibleLocs.get(0);
        for(Cell c: possibleLocs) {
            if(c.leftOfComparison(currLN) < 0) {
                currLN = c;
            }
        }
        return currLN;
    }
}