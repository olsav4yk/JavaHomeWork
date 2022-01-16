package com.pb.savchuk.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class ChatWindow extends JFrame {

    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private JTextField clientMess;
    private String clientName = "Client ";
    private JTextArea textArea;
    private Date dateTime;
    private String stringTime;
    private String stringTime1;
    private SimpleDateFormat time;


    public ChatWindow(String serverIp, int port) {
        try {
            socket = new Socket(serverIp, port);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        setBounds(700, 200, 400, 350);
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        textArea = new JTextArea("Chat with " + clientName + "\n");
        textArea.setEditable(false);
        JScrollPane jsp = new JScrollPane(textArea);
        add(jsp, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        clientMess = new JTextField("Введите сообщение: ");
        bottomPanel.add(clientMess, BorderLayout.CENTER);
        JButton sendMessage = new JButton("Отправить");
        bottomPanel.add(sendMessage, BorderLayout.EAST);


        sendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientMess.getText().trim().isEmpty()) {
                    dateTime = new Date();
                    time = new SimpleDateFormat("HH:mm:ss");
                    stringTime1 = time.format(dateTime);
                    sendMsg();
                    clientMess.grabFocus();
                }
            }
        });

        clientMess.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                clientMess.setText("");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (in.hasNext()) {
                            String inMes = in.nextLine();
                            textArea.append(inMes + "\n");
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    dateTime = new Date();
                    time = new SimpleDateFormat("HH:mm:ss");
                    stringTime = time.format(dateTime);
                    out.println("(" + stringTime + ") " + clientName + " [left the chat] ");
                    out.flush();
                    out.close();
                    in.close();
                    socket.close();
                } catch (IOException ex) {

                }
            }
        });

        setVisible(true);
    }

    public void sendMsg() {
        String message = clientMess.getText();
        out.println(message);
        out.flush();
        textArea.append("(" + stringTime1 + ") " + clientName + "messege: " + clientMess.getText() + "\n");
        clientMess.setText("");
    }
}
public class Client {
    public static String serverIp = "127.0.0.1";
    public static int port = 1234;

    public static void main(String[] args) {
        new ChatWindow(serverIp, port);
    }
}




