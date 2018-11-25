/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CarlosFernandes
 */
public class GerenciadorDeClientes extends Thread {

    private Socket cliente;
    private String sms;

    public GerenciadorDeClientes(Socket cliente) {
        this.cliente = cliente;
        start();
    }

    public void run() {
        try {
            BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
            String msg = leitor.readLine();
            this.sms = msg;
            escritor.println("" + this.sms);
            while (true) {
                System.out.println(msg);
                msg = leitor.readLine();
                escritor.println("Solução : Verifica o conector do cabo de rede");

            }

        } catch (IOException ex) {
            System.out.println("O Cliente Fechou a conexao");
            ex.printStackTrace();
        }
    }

}
