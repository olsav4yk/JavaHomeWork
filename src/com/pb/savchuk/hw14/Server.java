package com.pb.savchuk.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static class Handler implements Runnable {
        private final Socket socket;

        public Handler (Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String str;
                while ((str = br.readLine()) != null) {

                    if (str.equals("exit")) {
                        System.out.println("Клиент отключился от сервера");
                        break;
                    } else {
                        System.out.println("Сообщение от клиента: " + str);
                        str = "Ответ от сервера: " + LocalDateTime.now() + " - " + str;
                        pw.println(str);
                    }
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
                    threadPool.submit(new Handler(clientSocket));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
