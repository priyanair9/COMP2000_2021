import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StageReader {
    public static Stage readStage(String path) {
        Stage stage = new Stage();
        try {
            Properties props = (new Properties());
            props.load(new FileInputStream(path));
            for (String key : props.stringPropertyNames()) {
                String value = props.getProperty(key);
                Pattern cell = Pattern.compile("(.)(\\d+)");
                List<Cell> cellsInQuestion = new ArrayList<Cell>();
                Matcher cellMatcher = cell.matcher(key);
                if (cellMatcher.matches()) {
                    char col = cellMatcher.group(1).charAt(0);
                    int row = Integer.parseInt(cellMatcher.group(2));
                    stage.grid.cellAtColRow(col, row).ifPresent(cellsInQuestion::add);
                } else {
                    System.out.println("no match");
                }
                for (Cell c : cellsInQuestion) {
                    if (value.equals("train red")) {
                        stage.actors.add(new Train(c, 1.0f));
                    } else if (value.equals("train blue")) {
                        stage.actors.add(new Train(c, 0.0f));
                    } else if (value.equals("car red")) {
                        stage.actors.add(new Car(c, 1.0f));
                    } else if (value.equals("car blue")) {
                        stage.actors.add(new Car(c, 0.0f));
                    } else if (value.equals("boat red")) {
                        stage.actors.add(new Boat(c, 1.0f));
                    } else if (value.equals("boat blue")) {
                        stage.actors.add(new Boat(c, 0.0f));
                    // } else if (value.equals("horse red")) {
                    //     stage.actors.add(new Horse(c, 1.0f));
                    // } else if (value.equals("horse blue")) {
                    //     stage.actors.add(new Horse(c, 0.0f));
                    }
                }
            }
        } catch (IOException e) {
            // Start with an empty stage if we cannot open the stage file.
        }
        return stage;
    }
}