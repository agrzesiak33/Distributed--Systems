import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable{
    public static boolean EndOfClient = false;
    private Socket mainSocket;
    public Client(Socket s)
    {
        mainSocket = s;
    }

    public static void main(String args[])
    {
        Socket socket;
        DataOutputStream out = null;
        DataInputStream in = null;

        try {
            socket = new Socket("localhost", 5589);
            out = new DataOutputStream(socket.getOutputStream());

            //in = new DataInputStream(socket.getInputStream());
            //BufferedReader buff = new BufferedReader( new InputStreamReader(in));

            //client always listen in the background
            Thread reader = new Thread(new Client(socket));
            reader.start();

            Scanner scanner = new Scanner(System.in);
            String userInput;
            int inChar;
            do
            {
                userInput = scanner.nextLine();
                out.writeBytes(userInput);
                //if is a must or the program never ends.
                if (userInput.equalsIgnoreCase("quit"))
                {
                    //EndOfClient = true;
                }
                else
                {
                    userInput = "";
                }
            }
            while(! userInput.equalsIgnoreCase("quit"));
            System.out.println("Scanner closed");
            scanner.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Socket readingSocket = mainSocket;
            DataInputStream in = new DataInputStream(readingSocket.getInputStream());
            BufferedReader buff = new BufferedReader( new InputStreamReader(in));
            int quit = 0;
            while (true)
            {
                char charIn = (char)buff.read();
                char lowerChar =  Character.toLowerCase(charIn);
                switch (quit)
                {
                    case 0:
                        if (lowerChar == 'q')
                            quit++;
                        else
                            quit=0;
                        break;
                    case 1:
                        if (lowerChar == 'u')
                            quit++;
                        else
                            quit=0;
                        break;
                    case 2:
                        if (lowerChar == 'i')
                            quit++;
                        else
                            quit=0;
                        break;
                    case 3:
                        if (lowerChar == 't')
                            quit++;
                        else
                            quit=0;
                        break;
                    default:
                        quit =0;
                        break;
                }

                System.out.print(charIn);
                if (EndOfClient || quit >= 4)
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}