import java.util.Iterator;

public class CellIterator implements Iterator<Cell>{
    Cell[][] cells;
    int idx1;
    int idx2;
    boolean noMoreCells;

    CellIterator(Cell[][] cells) {
        this.cells = cells;
        this.idx1 = 0;
        this.idx2 = 0;
        this.noMoreCells = false;
    }

    @Override
    public boolean hasNext() {
        return !noMoreCells;
    }

    @Override
    public Cell next() {
        Cell nextCell = cells[idx1][idx2];
        idx2++;

        if(idx2 >= cells[idx1].length && idx1 < cells.length) {
            idx1++;
            idx2 = 0;
        }

        if(idx1 >= cells.length && idx2 >= cells[idx1].length) {
            noMoreCells = true;
        }
        return nextCell;
    }
}
