import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;


public class RunConcu {

	public static void main(String[] args) {
		
		ArrayList<Integer> ls;
		ls = ObjetConnect.ScanPort(1020, 2040);
		
		if(!ls.isEmpty()){
			DatagramSocket ds = null ;
			
			try {
				ds = new DatagramSocket(ls.get(0));
				System.out.println("Serveur démarrer  : "+ls.get(0));
			} catch (SocketException e) {
				System.out.println("Aucun Port dispo");
			}
			
		ServeurConcurrent s = new ServeurConcurrent(ds);
		
		s.run();
		}
		else {
			System.out.println("Aucun port dispo");
		}
		

	}

}
