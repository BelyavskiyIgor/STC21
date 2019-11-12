import java.util.ArrayList;
import java.util.List;

/***
 *@author Igor Belyavskiyi
 * Homework №10 Memory leak
 */
public class MemoryLeak {

    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("147");
        list.add("258");
        list.add("123");
        list = force(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> force(ArrayList<String> list) {
        for (int i=0; i<(list.size()-1); i++){
            if (list.get(i).contains("1") && list.get(i).contains("2")) //если есть цифра 1  и 2 нечего не делаем
                continue;
            if (list.get(i).contains("1")) //удаляем из списка все 1
                list.remove(i);
            if (list.get(i).contains("2")) // удваиваем цифру 2
            {String s = list.get(i);
                list.add((i+1), s);
            }
        }

        return list;
    }

}
