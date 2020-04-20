package ProofOfConcept.Server;

import ProofOfConcept.Database.Model;
import sun.misc.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {

    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Socket socket;


    private Model model;

    private String author;

    public ServerSocketHandler(Socket socket, Model model){

        this.socket = socket;
        this.model = model;

        try{
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            while (true)
            {
                String author = (String) inputStream.readObject();
                if (author.equals(null)){
                    System.out.println("Client Disconnected..");
                }



            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }
}
