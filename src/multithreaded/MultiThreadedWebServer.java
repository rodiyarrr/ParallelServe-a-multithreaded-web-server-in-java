package multithreaded;

import helper.ClientHandler;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedWebServer {
    public static void main(String[] args){
        int port=8010;

        try{
            ServerSocket serverSocket=new ServerSocket(port);
            System.out.println("Server listening on port : "+port);
            while (true){
                Socket clientSocket =serverSocket.accept();

                ClientHandler clientHandler = new ClientHandler(clientSocket);

                Thread thread=new Thread(clientHandler);
                thread.start();

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
