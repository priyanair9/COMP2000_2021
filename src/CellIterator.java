import java.util.Iterator;

public class CellIterator implements Iterator<Cell>{
    Cell[] cells;
    int idx;
    boolean noMoreCells;

    CellIterator(Cell[] cells) {
        this.cells = cells;
        this.idx = 0;
        this.noMoreCells = false;
    }

    @Override
    public boolean hasNext() {
        return !noMoreCells;
    }

    @Override
    public Cell next() {
        Cell c = cells[idx];
        idx++;
        
        if(idx >= cells.length) {
            noMoreCells = true;
        }
        return c;
    }
}
