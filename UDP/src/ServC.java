import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ServC extends ServeurConcurrent implements Runnable {
	
	
	private InetAddress inet;
	private int port;
	
	
	public ServC(DatagramSocket ds, InetAddress inetAddress, int port) {
		super(ds);
		this.inet = inetAddress;
		this.port = port;
	}
	
	
	public void run() {
		String lst = new String();
		String compare = new String("stop");
		try {
			repondre("Message reçu", this.inet, this.port);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
			while(lst !="stop"){
				try {
					receive();						    
					lst = new String(this.dp.getData(), "ascii");
				    
					if (lst.compareTo(compare) == 0){
						repondre("deconnexion");
						return;
					}
					else{
					repondre("Message recu");}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		
	}
	

	public void repondre(String msg, InetAddress adr, int port) throws UnsupportedEncodingException
	{
		
		this.dp = new DatagramPacket(msg.getBytes("ascii"),msg.length(),adr,port);
		try {
			this.ds.send(this.dp);
		} catch (IOException e) {
			System.out.println("dtg trop grand");
		}
	}

		
	
	

}
