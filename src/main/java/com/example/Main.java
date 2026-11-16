package com.example;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3000);
            do {
                Socket s = ss.accept();
                System.out.println("Qualcuno si è collegato");
                SocketHandler sh = new SocketHandler(s);
                sh.start();            
            } while (true);

        } catch (Exception e) {
            
        }
        
    }
}