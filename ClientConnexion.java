package com.company;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 Cette classe gère la connexion du client au server

 */
public class ClientConnexion implements Runnable {

    private Socket connexion; //socket du client
    private BufferedInputStream reader; //Buffer pour lire les infos entrantes
    private static int count = 0;
    private String name = "Client-";

    public ClientConnexion(Socket socket, String nomClient) {
        //numéro client attribué
        name += ++count;
        connexion = socket;
        name += nomClient;

    }
        public void run () {

            while (true) { //On autorise continuelement la connexion du client
                try {
                    reader = new BufferedInputStream(connexion.getInputStream());
                    //On envoie la commande au serveur
                    //TOUJOURS UTILISER flush() POUR ENVOYER RÉELLEMENT DES INFOS AU SERVEUR
                    //On attend la réponse
                    String response = read();
                    System.out.println("[CLIENT CONNEXION " + name + "] : Réponse reçue " + response);

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        //Méthode pour lire les réponses du serveur
        private String read () throws IOException {
            String response = "";
            int stream;
            byte[] b = new byte[4096];
            stream = reader.read(b);
            response = new String(b, 0, stream);
            return response;
        }

}