package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketHandler extends Thread{
    Socket s;


    public SocketHandler(Socket s){
        this.s=s;
    }

    public void run(){

        try (BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8), true);)
        {
            String richiesta = in.readLine();
            if (!(richiesta.equals(null))) {
                if (richiesta.trim().isEmpty()==false) {
                    String[] parti = richiesta.trim().split("\\s+");
                    if(parti.length==2){
                        if(parti[0].equals("LEGGI")){
                            
                        }else{
                            out.println("ERR UNKNOWNCMD");
                        }
                    }
                }else{
                    out.println("ERR SYNTAX");
                }
            }else{
                return;
            }


        } catch (Exception e) {
            System.out.println("ERRORE");
        }

    }

}
