import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client extends ObjetConnect{
	public Client(DatagramSocket ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}
public void send(String msg, String adr, int portS) throws UnknownHostException, UnsupportedEncodingException{ 
		
		InetAddress ad = InetAddress.getByName(adr);
		this.dp = new DatagramPacket(msg.getBytes("ascii"),msg.length(),ad,portS);
		try {
			this.ds.send(this.dp);
		} catch (IOException e) {
			System.out.println("Echec, taille incorrect");
		}		
}

public void send(String msg, InetAddress adr, int port) throws UnknownHostException, UnsupportedEncodingException
{
	this.dp = new DatagramPacket(msg.getBytes("ascii"),msg.length(),adr,port);
	
	try {
		this.ds.send(this.dp);
	} catch (IOException e) {
		System.out.println("Echec de l'envoi du Datagramme : Taille supérieur");
	}
} 
		






public boolean connexionserveur(){
	System.out.println("Demande de connexion au serveur");
	Scanner sp = new Scanner(System.in);
	System.out.println("Veuillez saisir l'adresse ip  : ");
	String ip = sp.nextLine(); 
    System.out.println("Veuillez saisir le port :");
	int port = sp.nextInt();
	
	try {
		this.send("Connexion",ip,port);
	} catch (UnknownHostException e) {
		System.out.println("Aucun port dispo");
	} catch (UnsupportedEncodingException e) {
		System.out.println("Message trop long");
	}
	
	try {
		this.receive();
	} catch (IOException e) {
		System.out.println("Message trop long");
	}
	return true;
}
public void run(){
	if ( connexionserveur())
	{
		while(true){
			Scanner sc = new Scanner(System.in);			
			System.out.println("Veuillez saisir votre message ");
			String msg = sc.nextLine();
			
			try {
				send(msg,this.dp.getAddress(), this.dp.getPort());
			} catch (UnknownHostException | UnsupportedEncodingException e) {
				System.out.println("Erreur format");
			}
			
			try {
				receive();
			} catch (IOException e) {
				System.out.println("Erreur format");
			}
			
			
			
		
		}
	}
}
}

	
	



