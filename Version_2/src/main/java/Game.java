/**
 * @autror Igor Belyavskiy
 * Gane Life version 2
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    //переменные для замера выполнения программы
    private long timeStart;
    private long timeFinish;

    public long getTimeStart() {
        return timeStart;
    }
    public long getTimeFinish() {
        return timeFinish;
    }

    //считаем соседей
    int neighbors(int[][]board, int a, int b){
        int size = board.length;
        int count = 0;
        int[][] surrounding = {{a -1 < 0 ? size -1 : a -1, b },
                {a -1 < 0 ? size -1 : a -1, b  +1 == size ? 0 : b + 1},
                {a  , b + 1 == size ? 0 : b + 1},
                {a  + 1 == size ? 0 : a + 1 , b + 1 == size ? 0 : b + 1},
                {a  + 1 == size ? 0 : a +1   , b},
                {a  + 1 == size ? 0 : a + 1 ,  b - 1 < 0 ? size -1 : b - 1},
                {a   , b - 1 < 0 ? size -1 : b-1},
                {a -1 < 0 ? size -1 : a -1, b - 1 < 0 ? size-1 : b-1}};

        for (int i [] : surrounding) {

                if(board[i[0]][i[1]] == 1){
                    count++;
            }
        }
        return count;
    }
    //печатаем жизнь и записываем в фаил результат
     public void printLife(int[][] board, String args) {
        try (FileWriter writer = new FileWriter(args, false)) {
            for (int[] i : board) {
                for (int j : i) {
                    if (j == 1) {
                        writer.write("0");
                       // System.out.print("0"); //снять коментарий если хотим выводить в консоль
                    } else {
                        writer.write(".");
                        //System.out.print("."); //снять коментарий если хотим выводить в консоль
                    }
                }
                writer.write("\n");
               // System.out.println(); //снять коментарий если хотим выводить в консоль
            }
            writer.write("\n");
            System.out.println();
        } catch (IOException e) {
            //System.out.println(e.getMessage()); //снять коментарий если хотим выводить в консоль
        }
    }
    int[][] field;
    int[][] nextField;
    //метод подсчета времени выполнения
    public void fixStartTime(){
        timeStart =  System.currentTimeMillis();
    }
    //метод с иходными данными.
    public void initialData(String[] args) throws IOException, InterruptedException {
        fileRedaer(args[0]);
        timeStart =  System.currentTimeMillis();
        for(int gen = 0; gen < Integer.parseInt(args[2]); gen++){
            for(int i = 0; i < nextField.length; i++){
                for (int j = 0; j < nextField[i].length;j++){
                    field[i][j] = nextField[i][j];
                }
            }
            printLife(field, args[1]);
            int size = field.length;
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(field[i][j] == 1 && !(neighbors(field, i, j) == 2 || neighbors(field, i, j) == 3)){
                        nextField[i][j] = 0;
                    }
                    else if (field[i][j] == 0 && neighbors(field, i, j) == 3){
                        nextField[i][j] = 1;
                    }
                }
            }
        }
    }
    //метод отсчета времени исполнения
    public void fixFinishTime(){
        timeFinish=  System.currentTimeMillis();
    }
    protected void fileRedaer(String arg) throws IOException {
        FileReader in = new FileReader(arg);
        BufferedReader br = new BufferedReader(in);
        List<String[]> list = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            list.add(line.split(" "));
        }
        field = new int[list.size()][list.get(0).length];
        nextField = new int[list.size()][list.get(0).length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                nextField[i][j] = Integer.parseInt(list.get(i)[j]);
            }
        }
    }
}
