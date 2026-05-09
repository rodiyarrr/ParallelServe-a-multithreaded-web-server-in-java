package helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public Runnable getRunnable(){
        return new Runnable() {
            @Override
            public void run(){
                int port=8010;
                try{
                    InetAddress address=InetAddress.getLocalHost();

                    Socket socket=new Socket(address,port);
                    PrintWriter toServer=new PrintWriter(socket.getOutputStream(),true);

                    toServer.println("GET /index.html HTTP/1.1");
                    toServer.println("Host: localhost");
                    toServer.println("Connection: close");
                    toServer.println();

                    BufferedReader fromServer=new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String line;
                    while ((line=fromServer.readLine())!=null){
                        System.out.println(line);
                    }

                    toServer.close();
                    fromServer.close();
                    socket.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
    }
    public static void main(String[] args) {
        Client client=new Client();

        for(int i=0;i<20;i++){
            try{
                Thread thread=new Thread(client.getRunnable());
                thread.start();
            }
            catch(Exception e){
                return;
            }
        }
    }
}
