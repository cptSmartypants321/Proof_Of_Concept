package ProofOfConcept.Server;

import ProofOfConcept.Database.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Model model;

    public Server(Model model){
        this.model = model;
    }

    public void runServer() throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(2910);
        System.out.println("Server Started.....");

        while (true){

            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");

            ServerSocketHandler ssh = new ServerSocketHandler(socket, model);

            Thread t = new Thread(ssh);
            t.start();


        }
    }


    public static void main(String[] args) {
        DatabaseInterface m = new DatabaseCon();
        Model model = new ModelImpl(m);
        Server server = new Server(model);

        try{
            server.runServer();

        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
