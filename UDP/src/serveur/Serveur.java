package serveur;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import client.ObjetConnect;
public class Serveur extends ObjetConnect {

	public Serveur(DatagramSocket ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	
	
	public void repondre(String msg) throws UnsupportedEncodingException {
		this.dp = new DatagramPacket(msg.getBytes("ascii"),msg.length(),this.dp.getAddress(),this.dp.getPort());
		try {
			this.ds.send(this.dp);
		} catch (IOException e) {
			System.out.println("Echec d'envoie trop grand");
		}
	}

	
	public void run() throws IOException{
		while(true){
			try {
				receive();
				repondre("Message  reçu");}
				catch (UnsupportedEncodingException e) {
					System.out.println("Erreur de format");
				}
			}
		}
		
		
		
	}
	




