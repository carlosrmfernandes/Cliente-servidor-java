/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author CarlosFernandes
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket servidor = null;
        try {
            System.out.println("Startando o servidor");
            for (int i = 0; i <= 10; i++) {
                Thread.sleep(1000);
                System.out.print(i + "% ");
            }
            System.out.println("");
            servidor = new ServerSocket(12345);
            System.out.println("Servidor Startando com Sucesso");
            System.out.println("");
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Nova conexão com o cliente "
                        + cliente.getInetAddress().getHostAddress());
                new GerenciadorDeClientes(cliente);
            }
        } catch (Exception e) {
            try {
                servidor.close();
                if (servidor != null) {
                    servidor.close();
                }
            } catch (IOException el) {
            }
            System.err.println("aporta esta ocupada ou o servidor foi fechado");
            e.printStackTrace();
        }

    }

}
