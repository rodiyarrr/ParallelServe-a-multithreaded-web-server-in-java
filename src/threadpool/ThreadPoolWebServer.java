package threadpool;

import helper.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolWebServer {
    private final ExecutorService threadPool;

    public ThreadPoolWebServer(int poolSize) {
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    public void serverStart(int port){
        try{
            ServerSocket serverSocket=new ServerSocket(port);

            System.out.println("Thread pool web server started on port : "+port);
            System.out.println("Server listening on port : "+port);

            while (true){
                Socket clientSocket=serverSocket.accept();
                System.out.println("Client connected: "+ clientSocket.getInetAddress());

                ClientHandler handler=new ClientHandler(clientSocket);

                threadPool.execute(handler);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 8010;
        int poolSize = 10; // Adjust the pool size as needed
        ThreadPoolWebServer server = new ThreadPoolWebServer(poolSize);

        server.serverStart(port);

    }
}
