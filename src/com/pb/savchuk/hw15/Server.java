package com.pb.savchuk.hw15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static class Serv implements Runnable {
        private final Socket socket;

        public Serv(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {
            try (PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String str;
                while ((str = br.readLine()) != null) {

                        System.out.println("Сообщение от клиента: " + str);
                        Date dateTime = new Date();
                        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
                        String stringTime = time.format(dateTime);
                        str = "(" + stringTime + ") Server messege: " + " - " + str;
                        pw.println(str);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Сервер запущен");
        int port = 1234;

        try {
            while (true) {
                System.out.println("Сервер ждет подключения на порту номер: " + port);
                ServerSocket servSocket = new ServerSocket(port);
                ExecutorService threadPool = Executors.newFixedThreadPool(10);
                while (true) {
                    Socket clientSocket = servSocket.accept();
                    threadPool.submit(new Serv(clientSocket));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
