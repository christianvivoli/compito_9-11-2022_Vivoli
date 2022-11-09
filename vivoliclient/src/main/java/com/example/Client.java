package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Hello world!
 */
public final class Client {
    private Client() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3000);
        boolean condizione=true;
        //ServerConnection sc=new ServerConnection(s);

        // per parlare
        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);

        // per ascoltare
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // per la tastiera
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        pr.println("Eccomi");

        //new Thread(sc).start();

        while(condizione){

            System.out.println(br.readLine());//che comando vuoi inviare?
            String x=tastiera.readLine();
            pr.println(x); //? invio il comando 

                if(x.equals("q") || x.equals("Q")){
                     break;
                }
            
            System.out.println(br.readLine());
        }
        s.close();
    }
}
