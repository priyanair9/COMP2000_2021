import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame{
    public static void main(String[] args) throws Exception {
        Main window = new Main();
        // window.run();
    }
    public class Canvas extends JPanel {
        Grid grid;
        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
            grid = new Grid();
        }
        @Override
        public void paint(Graphics g) {
            g.setColor(Color.BLACK);
            for(int i = 10; i < 710; i += 35) {
                for(int j = 10; j < 710; j += 35) {
                    g.setColor(Color.WHITE);
                    g.fillRect(i, j, 35, 35);
                    g.setColor(Color.BLACK);
                    g.drawRect(i, j, 35, 35);
                }
            }
            // g.setColor(Color.RED);
            // g.drawOval((int)getMousePosition().getX(), (int)getMousePosition().getY(), 5, 5);
            
        }
    }

    class Cell { //cell class
        //instance variables
        int xPos;
        int yPos;
        Color fillColor;
        Color strokeColor;

        public Cell() { // deafault constructor
            xPos = 0;
            yPos = 0;
            fillColor = Color.WHITE;
            strokeColor = Color.BLACK;
        }
        public Cell(int x, int y, Color f, Color b) { // paramatarised constructor
            this.xPos = x;
            this.yPos = y;
            this.fillColor = f;
            this.strokeColor = b;
        }
    }

    public class Grid { //Grid class
        Cell[][] cells = new Cell[20][20]; //a grid is an array of cells
        
        public void Grid(Cell[][] cells) {
            this.cells = cells;
            for(int i = 0; i < cells.length; i++) {
                for(int j = 0; j < cells[i].length; j++) {
                    cells[i][j] = new Cell(10+35*i, 10+35*j, Color.WHITE, Color.BLACK);
                }
            }
        }
    }

    public Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }
    public void run() {
        while(true) {
            this.repaint();
        }
    }

    
    
}
