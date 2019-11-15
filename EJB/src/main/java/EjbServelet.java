/**
 * @autor Igor Belyavskiy
 * EJB Servelet
 */

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

//указываем на какой страничке у нас будет выводиться результат
@WebServlet(urlPatterns = "/files")
public class EjbServelet extends HttpServlet {
    @EJB()
    Recursion recursion;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String baseDir = System.getProperty("user.dir");// в какую директроии смотрим
        File file = new File(baseDir);
        request.setAttribute("files", recursion.showFiles(file));// передаем параметр методу
        request.getRequestDispatcher("/files.jsp").include(request, response);//получам ответ
    }
}
