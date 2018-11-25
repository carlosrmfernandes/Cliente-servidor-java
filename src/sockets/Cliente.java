/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CarlosFernandes
 */
public class Cliente {

    public static void main(String[] args) throws IOException {

        try {
            Socket cliente = new Socket("10.0.0.12", 12345);
            new Thread() {
                @Override
                public void run() {
                    try {
                        BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

                        while (true) {
                            String msg = leitor.readLine();
                            System.out.println(msg);
                        }

                    } catch (IOException ex) {
                        System.out.println("Impossivel ler a menssagem do servidor ");
                        ex.printStackTrace();
                    }
                }

            }.start();
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(),true);
            BufferedReader leitorTerminar=new BufferedReader(new InputStreamReader(System.in));
            
            while (true) {                
                String mensageTerminar = leitorTerminar.readLine();
                escritor.println(mensageTerminar);
            }

        } catch (UnknownHostException e) {
            System.out.println("O endereço é invalido");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("O servidor pode Estar fora do ar");
            e.printStackTrace();
        }

    }

}
