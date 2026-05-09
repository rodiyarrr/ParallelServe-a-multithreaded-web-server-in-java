package singlethreaded;

import helper.ClientHandler;

import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedWebServer {
    public void run() {

        int port = 8010;

        try {

            ServerSocket serverSocket =
                    new ServerSocket(port);

            System.out.println(
                    "Single Threaded Server listening on port: "
                            + port);

            while(true){

                Socket clientSocket =
                        serverSocket.accept();

                System.out.println(
                        "Client connected: "
                                + clientSocket.getInetAddress());

                // NO NEW THREAD
                ClientHandler handler = new ClientHandler(clientSocket);

                // Directly execute
                handler.run();
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SingleThreadedWebServer server =
                new SingleThreadedWebServer();

        server.run();
    }
}
