/**
 * @autror Igor Belyavskiy
 * Gane Life. Thread. version 2
 */

import java.io.IOException;


public class GameThread extends Game {
    //метод с иходными данными.
    public void initialData(String[] args) throws IOException, InterruptedException {
        fileRedaer(args[0]);
        for(int gen = 0; gen < Integer.parseInt(args[2]); gen++){
            for(int i = 0; i < nextField.length; i++){
                for (int j = 0; j < nextField[i].length;j++){
                    field[i][j] = nextField[i][j];
                }
            }
            printLife(field, args[1]);
            int size = field.length;
            Thread thread1 = new GameThread.MyThread(0, field.length /2, 0, field.length / 2);
            Thread thread2 = new GameThread.MyThread(field.length / 2, field.length, field.length / 2, field.length);
            Thread thread3 = new GameThread.MyThread(0, field.length / 2, field.length / 2, field.length);
            Thread thread4 = new GameThread.MyThread(field.length / 2, field.length, 0, field.length / 2 );
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }
    }
    public class MyThread extends Thread {
        GameThread gameThread = new GameThread();

        int fildThreadX;
        int fildThreadY;
        int fildThreadZ;
        int fildThreadW;

        public MyThread(int fildThreadX, int fildThreadY, int fildThreadZ, int fildThreadW) {
            this.fildThreadX = fildThreadX;
            this.fildThreadY = fildThreadY;
            this.fildThreadZ = fildThreadZ;
            this.fildThreadW = fildThreadW;
        }

    }
}
