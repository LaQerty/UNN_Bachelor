
package client_server;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Random;


class ServerSetup extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    public ServerSetup(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    @Override
    public void run() {
        String word;
        int clientPoint = 0;
        int serverPoint = 0;
        Game newGame = new Game();
        try {
            try {
                send("Управление:" + "\n" + "Поле состоит из 25 ячеек(5х5), ход происходит путем выбора ячейки и ее грани"
                        + "(например верхний левый угол это 0,0, а правый нижний это 4,4).Вводятся все значения через запятую." + "\n"
                        + " Грани выбераются путем первой буквы английского значения:" +
                        "\n"+ "d-нижняя"+
                        "\n"+ "u-верхняя"+
                        "\n"+ "l-левая"+
                        "\n"+ "r-правая" + "\n" + "Для выхода из игры введите \"stop\"." + "\n" + "Ваш ход:");
                while (true) {
                    word = in.readLine();
                    if(word.equals("stop")) {
                        this.downService();
                        break; 
                    }
                    String result = newGame.move(word);
                    switch (result) {
                        case "win":
                            send("Уху! Честный +1" + "\n");
                            clientPoint++;
                            send("Теперь у тебя " + clientPoint + " очков" + "\n" + "Можешь сделать еще ход:");
                            break;
                        case "uncorrectly":
                            send("Введено некоректное значение!");
                            break;
                        case "busy":
                            send("Этот ход уже сделан, попробуйте другой.");
                            break;    
                        case "nice move":
                            while(true){
                                String serverMove = rand();
                                result = newGame.move(serverMove);
                                while(result == "win"){
                                    serverPoint++;
                                    send("Сервер сделал ход: " + serverMove + "И получил 1 очко" + "\n");
                                    serverMove = rand();
                                    result = newGame.move(serverMove);
                                }
                                if(result == "nice move"){
                                    send("Сервер сделал ход: " + serverMove + "\n");
                                    break;
                                }
                            } 
                            break;
                    }
                    if(newGame.complete == 25){
                        send("Игра закончена. Ваши очки: " + clientPoint + "\n" + 
                                "Очки сервера: " + serverPoint + "/n");
                        send("stop");
                        this.downService();
                        break;
                    }
                }
            } catch (NullPointerException ignored) {}
        } catch (IOException e) {
            this.downService();
        }
    }

    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {}

    }

    private String rand(){
        int a = (int) ( Math.random() * 5 );
        int b = (int) ( Math.random() * 5 );
        Random r = new Random();
        String abc = "udlr";
        char c = abc.charAt(r.nextInt(abc.length()));
        return String.valueOf(a) + "," + String.valueOf(b) + "," + c; 
    }

    private void downService() {
            try {
            if(!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }
}

public class Server {

    public static final int PORT = 8080;
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server Start" +  "\n" );
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                   new ServerSetup(socket);
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}