package com.company;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.util.Date;

/**
 Cette classe gere les interactions entre client et server
 */

public class ClientProcessor implements Runnable{

    private Socket socket;
    private Socket sock; // socket client
    private PrintWriter writer ; //envoie de données ver server
    private BufferedInputStream reader; //buffer pour lire les informations entrantes

    public ClientProcessor(Socket pSock){
        sock = pSock;
    }

    //run : traitement lancé dans un thread séparé
    public void run(){
        System.err.println("Lancement du traitement de la connexion cliente");

        boolean closeConnexion = false;
        //tant que la connexion est active, on traite les demandes
        while(!sock.isClosed()){

            try {


                writer = new PrintWriter(sock.getOutputStream());
                reader = new BufferedInputStream(sock.getInputStream());

                //On attend la demande du client
                String response = read();
                InetSocketAddress remote = (InetSocketAddress)sock.getRemoteSocketAddress();

                //On affiche quelques infos, pour le débuggage
                String debug = "";
                debug = "Thread : " + Thread.currentThread().getName() + ". ";
                debug += "Demande de l'adresse : " + remote.getAddress().getHostAddress() +".";
                debug += " Sur le port : " + remote.getPort() + ".\n";
                debug += "\t -> Commande reçue : " + response + "\n";
                System.err.println("\n" + debug);

                //On traite la demande du client en fonction de la commande envoyée
                String toSend = "";

                switch(response.toUpperCase()){
                    case "FULL":
                        toSend = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM).format(new Date());
                        break;
                    case "DATE":
                        toSend = DateFormat.getDateInstance(DateFormat.FULL).format(new Date());
                        break;
                    case "HOUR":
                        toSend = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(new Date());
                        break;
                    case "CLOSE":
                        toSend = "Communication terminée";
                        closeConnexion = true;
                        break;
                    default :
                        toSend = "Commande inconnu !";
                        break;
                }

                //On envoie la réponse au client
                writer.write(toSend);
                //Il FAUT IMPERATIVEMENT UTILISER flush()
                //Sinon les données ne seront pas transmises au client
                //et il attendra indéfiniment
                writer.flush();

                if(closeConnexion){
                    System.err.println("COMMANDE CLOSE DETECTEE ! ");
                    writer = null;
                    reader = null;
                    sock.close();
                    break;
                }
            }catch(SocketException e){
                System.err.println("LA CONNEXION A ETE INTERROMPUE ! ");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //La méthode que nous utilisons pour lire les réponses
    private String read() throws IOException{
        String response = "";
        int stream;
        byte[] b = new byte[4096];
        stream = reader.read(b);
        response = new String(b, 0, stream);
        return response;
    }

}