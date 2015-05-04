import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import java.util.ArrayList;



public class ObjetConnect{
	
	protected DatagramSocket ds = null ;
	protected DatagramPacket dp = null;
	
	
	public ObjetConnect(DatagramSocket ds){
		this.ds = ds;
		
	}
	
	
	public static ArrayList<Integer> ScanPort(int portdeb, int portfin){
		boolean port = true;
		ArrayList<Integer> listport = new ArrayList<Integer>();
		DatagramSocket ds = null;
		for ( int i = portdeb; i<=portfin;i++){
			try{
				 ds = new DatagramSocket(i);
				}
				catch (SocketException ex) {
					port = false;
				}
			
			if(port){listport.add(i);
			ds.close();
			}
			port = true;
					
		}
		return listport;
		}

	 
	
		
		
	
	
	public void receive() throws IOException, UnsupportedEncodingException{
		byte[] data= new byte[100];
		this.dp = new DatagramPacket(data,100);
		this.ds.receive(this.dp);
		System.out.println(" Message de " + this.dp.getAddress()+ "," + this.dp.getPort() + "----->"
				+ new String(this.dp.getData(),"ascii"));
		
	}
}


	



