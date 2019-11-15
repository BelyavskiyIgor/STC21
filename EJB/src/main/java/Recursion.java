/**
 * @author Igor Belyavskiy
 * EJB file
 *  class Recursion
 */
import javax.ejb.Stateless;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateless
//Класс нужен показывает что лежитит в корневом каталоге. В рекурсии
public class Recursion {
    public List<String> showFiles(File file)
    {
        List<String> stringList = new ArrayList<>();
        File[] showFolder = file.listFiles();
        System.out.println(Arrays.toString(showFolder));
        for (File entry : showFolder)
        {
            if (entry.isDirectory())
            {
               stringList.add(entry.toString());
                showFiles(entry); //рекурсия
                continue;
            }
            stringList.add(entry.toString());
        }
        return stringList;
    }

    }


