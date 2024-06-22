import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 9999;
    private static List<ObjectOutputStream> outputStreams = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado en el puerto " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado: " + socket);
                ClientHandler handler = new ClientHandler(socket);
                new Thread(handler).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private static class ClientHandler implements Runnable {
        private Socket socket;
        private ObjectOutputStream outputStream;
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            ObjectOutputStream out = null;
            ObjectInputStream in = null;
            try {
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                in = new ObjectInputStream(socket.getInputStream());
                synchronized (outputStreams) {
                    outputStreams.add(outputStream);
                }
                while (true) {
                    String message = (String) in.readObject();
                    System.out.println("Mensaje recibido: " + message);
                    synchronized (outputStreams) {
                        for (ObjectOutputStream clientOut : outputStreams) {
                            clientOut.writeObject(message);
                            clientOut.flush();
                        }
                    }
                }
            } catch (IOException ex) {
                System.err.println("Error de conexión con el cliente: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.err.println("Error de clase no encontrada: " + ex.getMessage());
            } finally {
                if (outputStream != null) {
                    synchronized (outputStreams) {
                        outputStreams.remove(outputStream);
                    }
                }
                try {
                    if (in != null) in.close();
                } catch (IOException ex) {
                    System.err.println("Error cerrando ObjectInputStream: " + ex.getMessage());
                }
                try {
                    if (outputStream != null) outputStream.close();
                } catch (IOException ex) {
                    System.err.println("Error cerrando ObjectOutputStream: " + ex.getMessage());
                }
                try {
                    if (socket != null) socket.close();
                } catch (IOException ex) {
                    System.err.println("Error cerrando socket: " + ex.getMessage());
                }
            }
        }
    }
}
