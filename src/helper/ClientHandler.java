package helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {

            BufferedReader fromClient =
                    new BufferedReader(
                            new InputStreamReader(
                                    clientSocket.getInputStream()
                            )
                    );

            PrintWriter toClient =
                    new PrintWriter(
                            clientSocket.getOutputStream(),
                            true
                    );

            String requestLine =
                    fromClient.readLine();

            System.out.println(
                    "Request Received: "
                            + requestLine);

            RequestParser parser =
                    new RequestParser();

            String resource =
                    parser.parseRequest(requestLine);

            ResponseGenerator responseGenerator =
                    new ResponseGenerator();

            String response =
                    responseGenerator.generateResponse(resource);

            toClient.println(response);

            // VERY IMPORTANT
            toClient.flush();

            // Graceful termination
            clientSocket.shutdownOutput();

            fromClient.close();
            toClient.close();

            clientSocket.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
