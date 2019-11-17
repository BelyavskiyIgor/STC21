/**
 * @author Igor Belyavskiy
 * Game Life. Main class
 */

import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.initialData(args);
        game.printLife(game.field, args[1]);
        System.out.println("начало отсчета " + game.timeStart);
        System.out.println("конец отсчета " + game.timeFinish);
    }
}
