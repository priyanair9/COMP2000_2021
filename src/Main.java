import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Main extends JFrame {
  class App extends JPanel {
    Stage stage;

    public App() {
      setPreferredSize(new Dimension(1024, 720));
      stage = new Stage();
    }

    @Override
    public void paint(Graphics g) {
      stage.paint(g, getMousePosition());
    }
  }

  public static void main(String[] args) throws Exception {
    Main window = new Main();
    window.run();
  }

  final App canvas;

  private Main() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    canvas = new App();
    this.setContentPane(canvas);
    this.pack();
    this.setVisible(true);
  }

  public void run() {
    // updates the window only when the mouse moves
    // fixing this was not part of the requirements
    // however, it places fewer demands on the computer
    this.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
            canvas.repaint();
        }
    });
  }
}
