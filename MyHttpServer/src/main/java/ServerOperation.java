import sun.plugin.viewer.IExplorerPluginObject;
/**
 * autor Igor Belyavskiy
 * HttpServer
 */
import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Date;

public class ServerOperation {
    // Метод запроса
    private static void writeResponse(Socket socket) throws IOException{
        //Запрашиваем что лежит в папке
        File file = new File(".");
        assert  file != null;
        String response = Arrays.toString(file.list());

        OutputStream os = socket.getOutputStream();
        os.write(response(response).getBytes());
        os.flush();//делаем запрос мимо буфера
    }
    //Метод отрабатывающий другие запросы кром GET
    private static void write404(Socket client) throws IOException{
        OutputStream os = client.getOutputStream();
        os.write("HTTP/1.1 404 Not Found\r\n\r\n".getBytes());
        os.write("Wrong method\r\n".getBytes());
        os.flush();
    }
    //Метод обрабатывающий запрос GET
    private static String response(String resp){
        Date date = new Date();
        String start = "HTTP/1.1 200 OK\r\n";
        String header = "Date: " + date.toString() + "\r\n";
        header += "Content-Type: text/html\r\n";
        header += "Content-length: " + resp.length() + "\r\n";
        header += "\r\n";
        return start + header + resp;
    }
    //Меод обрабатывающий какой запрос отправили
    public static void readInput(Socket client) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String s = reader.readLine();
        System.out.println(s);
        if(s.contains("GET")){
            writeResponse(client);
        }else{
            write404(client);
        }
    }
}
