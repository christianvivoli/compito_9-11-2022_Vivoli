package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ClientHandler extends Thread {
    private Socket s;
    private PrintWriter pr = null;
    private BufferedReader br = null;
    public static int x;
    private boolean condizione=true;
    private String output;
    //int firstSpace;
    //private List<ClientHandler> clients;

    public ClientHandler(Socket s,int y/*,List<ClientHandler> clients*/) {
        x=y;
        this.s = s;
        //this.clients = clients;
        try {
            // per parlare
            pr = new PrintWriter(s.getOutputStream(), true);
            // per ascoltare
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        try {
            System.out.println(br.readLine());

            while(condizione){
                pr.println("che comando vuoi inserire?");

                String comando=br.readLine();
                
                if(comando.equals("D") || comando.equals("d")){
                    if(x==0){

                        //sendToAll("@");
                        pr.println("biglietti esauriti");

                    }else{
                        pr.println("Disponibili "+x+" biglietti");
                    }

                }else if(comando.equals("A") || comando.equals("a")){
                    if(x==0){
                        pr.println("biglietti esauriti");
                    }else{
                        pr.println("Biglietto acquistato");
                        x--;
                    }                    

                }else if(comando.equals("Q") || comando.equals("q")){
                    break;
                }
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        
    }
/*
    private void sendToAll(String msg) {
        for (ClientHandler client : clients) {
            client.pr.println(msg);
        }
    }
*/
}
