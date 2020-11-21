import java.io.*;
import java.net.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class Server {

    public static final int PORT = 371;
    public static CopyOnWriteArrayList<ServerSomething> serverList = new CopyOnWriteArrayList<>(); // вы сказали, так хорошо. мы вам верим
    public static Story story;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        story = new Story();
        System.out.println("Server Started");
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerSomething(socket)); // коннектим новичков к серверу
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}