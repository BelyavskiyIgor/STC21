import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @autor Igor Belyavskiy
 * HttpServer
 */

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerOperation serverOperation = new ServerOperation();
        //Создали сервер socket на порту 8080
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true){
            Socket socket = serverSocket.accept();//Ждем ответа от клиента
            System.out.println("Делаем запрос");
            serverOperation.readInput(socket);
        }

    }

}
