package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try { 
            System.out.println( "Il client è partito" );
            Socket s = new Socket("localhost", 3000);

            Scanner sin = new Scanner(System.in);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            System.out.println( "Connessione effettuata" );

            int risposta = 0;

            do {
                System.out.println( "Inserisci il numero: " );
                String n = sin.nextLine();
                out.writeBytes(n+"\n");

                String confronto = in.readLine();
                risposta = Integer.parseInt(confronto);
                

                if(risposta == 1){
                    System.out.println( "Numero troppo piccolo" );
                }
                if(risposta == 2){
                    System.out.println( "Numero troppo grande" );
                }
                if(risposta == 3){
                    String c = in.readLine();
                    int r = Integer.parseInt(c);
                    System.out.println( "Numero indovinato in "+r+" tentativi" );
                }
            } while (risposta != 3);

            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}
