package serveurConcu;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import client.ObjetConnect;

public class ServeurConcurrent  extends ObjetConnect  {

	public ServeurConcurrent(DatagramSocket ds) {
		super(ds);
		
	}
	
	public void repondre(String msg) throws UnsupportedEncodingException {
		this.dp = new DatagramPacket(msg.getBytes("ascii"),msg.length(),this.dp.getAddress(),this.dp.getPort());
		try {
			this.ds.send(this.dp);
		} catch (IOException e) {
			System.out.println("Echec d'envoie trop grand");
		}
	}

	
	
	public void run(){
		ArrayList<Integer> ls; 
		
		while(true){
			try {
				receive();
			} catch (IOException e) {
				System.out.println("Erreur de format");
			}
			ls = ObjetConnect.ScanPort(1020, 2040);
			
			if (!ls.isEmpty()){
				DatagramSocket ds = null;
				try {
					ds = new DatagramSocket(ls.get(0));
				} catch (SocketException e) {
					System.out.println("Pas de port Dispo");
				}
				
				new Thread(new ServC(ds,this.dp.getAddress(), this.dp.getPort())).start();
				
			}
		}
	}
	
	
	
	

}
