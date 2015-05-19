package client;
import java.io.UnsupportedEncodingException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;


public class runClient {

	public static void main(String[] args) throws UnsupportedEncodingException  {
		// TODO Auto-generated method stub
		ArrayList<Integer> ls;
		ls = ObjetConnect.ScanPort(1020,2040);
		System.out.println(" Port utilié " + ls.get(0));
		
		if (!ls.isEmpty()){
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(ls.get(0));
		} catch (SocketException e) {
			System.out.println("Aucun port dispo");
		}
		Client c = new Client(ds);
		c.run();
		
	}
		else{
			System.out.println("Aucun port dispo");
	}
}
}

			
	


