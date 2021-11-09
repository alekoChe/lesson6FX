package com.example.lesson6fx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SomeServer {
    public static void main(String[] args) {
        Socket socket = null; // на каждого клиента - отдельный сокет!
        try (ServerSocket serverSocket = new ServerSocket(8189)) { // это конструкция try_with_resources для того
              // что бы закрыть то что должно закрываться, что бы прога не упала. Главное чтобы то что мы сюда помещаем
            // наследовалось от интерфейса Closeable!
            System.out.println("Ожидаем подключения клиента...");
            socket = serverSocket.accept(); // <-- ожидаем подключения клиента
            System.out.println("Клиент подключился");
            final DataInputStream in = new DataInputStream(socket.getInputStream());
            final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                final String message = in.readUTF();
                System.out.println("Сообщение от клиента: " + message);
                if (message.startsWith("/end")) {
                    out.writeUTF("/end");
                    break;
                }
                out.writeUTF("Эхо: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
