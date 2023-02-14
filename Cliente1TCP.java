package ejercicios.ejercicio1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente1TCP {
	public static void main (String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			String host = "localhost";
			int puerto = 1234;
			
			Socket c1 = new Socket(host,puerto);
			
			System.out.println("Escriba el numero que desea convertir a factorial: ");
			int num = sc.nextInt();
			
			DataOutputStream dos = new DataOutputStream(c1.getOutputStream());
			
			dos.writeInt(num);
			
			DataInputStream dis = new DataInputStream(c1.getInputStream());
			
			int factorial = dis.readInt();
			System.out.println("El factorial del numero es: "+factorial);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
