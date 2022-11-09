package com.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public final class Server {
    
    //private static List<ClientHandler> clients = new ArrayList<>();
    
    public static void main(String[] args) throws Exception { 

        int x=0; //?variabile contatore dei client
    
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server in ascolto sulla porta 3000");
        boolean running = true;

        while (running) {
          Socket s = ss.accept();
          System.out.println("Client connesso");
          //creazione del thread
          ClientHandler ch = new ClientHandler(s,x/*,clients*/);
          //clients.add(ch);
          ch.start();

        }

        ss.close();
      }
}
