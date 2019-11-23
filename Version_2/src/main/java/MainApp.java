/**
 * @author Igor Belyavskiy
 * Game Life. Main class
 */

import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = new Game();
        game.fixStartTime();
        game.initialData(args);
        game.printLife(game.field, args[1]);
        game.fixFinishTime();
        System.out.println("Время выполнения игры в однопоточном вапианте: " + (game.getTimeFinish() - game.getTimeStart()));
    }
}
