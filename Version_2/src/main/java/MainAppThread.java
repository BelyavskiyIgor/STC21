/**
 * @author Igor Belyavskiy
 * Game Life. Thread. Main class
 */

import java.io.IOException;

public class MainAppThread {
    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = new GameThread();
        game.fixStartTime();
        game.initialData(args);
        game.printLife(game.field, args[1]);
        game.fixFinishTime();
        System.out.println("Время выполнения игры в многопоточном вапианте: " + (game.getTimeFinish() - game.getTimeStart()));
    }
}
