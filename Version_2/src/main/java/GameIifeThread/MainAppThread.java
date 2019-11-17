package GameIifeThread; /**
 * @author Igor Belyavskiy
 * Game Life. Thread. Main class
 */

import java.io.IOException;

public class MainAppThread {
    public static void main(String[] args) throws IOException, InterruptedException {
        GameThread game = new GameThread();
        game.initialData(args);
        game.printLife(game.field, args[1]);
        System.out.println("начало отсчета " + game.timeStart);
        System.out.println("конец отсчета " + game.timeFinish);


    }
}
