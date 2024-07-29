import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConcurrentChatApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            ChatServer server = new ChatServer();
            ChatClient client1 = new ChatClient("Client 1");
            ChatClient client2 = new ChatClient("Client 2");

            new Thread(server).start();
            new Thread(client1).start();
            new Thread(client2).start();
        });
    }
}

// make chat server to interact with clients
class ChatServer implements Runnable{
    private ServerSocket serverSocket;
    private Socket clientSocket1;
    private Socket clientSocket2;


    @Override
    public void run() {
        try{
            serverSocket = new ServerSocket(12345);
            System.out.println("Server is starting...");

            clientSocket1 = serverSocket.accept();
            System.out.println("Client 1 connected");

            clientSocket2 = serverSocket.accept();
            System.out.println("Client 2 connected");

            // make serverside printWriter and Bufferreader to read the messages
            PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
            PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);
            BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
            BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));

            // start the server side threads
            new Thread(() -> relayMessages(in1, out2)).start();
            new Thread(() -> relayMessages(in2, out1)).start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // Write the bufferReader {in} message to PrintWriter {out}
    private void relayMessages(BufferedReader in, PrintWriter out) {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ChatClient implements Runnable {
    private String clientName;
    private JTextArea chatArea;
    private JTextField inputField;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ChatClient(String clientName) {
        this.clientName = clientName;
        createUI();
    }

    private void createUI() {
        JFrame frame = new JFrame(clientName);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        inputField = new JTextField();
        frame.add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = clientName + ": " + inputField.getText();
                out.println(message);
                inputField.setText("");
            }
        });

        frame.setVisible(true);
    }

    @Override
    public void run() {
        try {
            socket = new Socket("localhost", 12345);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                chatArea.append(message + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}