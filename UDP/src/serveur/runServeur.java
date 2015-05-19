package serveur;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

import client.ObjetConnect;


public class runServeur {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		ArrayList<Integer> ls;
		ls = ObjetConnect.ScanPort(1020,2040);
		System.out.println(" Port utilisé " + ls.get(0));
		
		if (!ls.isEmpty()){
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(ls.get(0));
		} catch (SocketException e) {
			System.out.println("Aucun port dispo");
		}
		Serveur s = new Serveur(ds);
		s.run();
		}
		
		else{
			System.out.println("Aucun port dispo");
		}
	}

}
