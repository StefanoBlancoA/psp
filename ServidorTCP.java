package ejercicios.ejercicio1;

import java.net.*;
import java.io.*;

public class ServidorTCP {
	
	public static void main (String [] args) {
		try {
			
			ServerSocket servidor = new ServerSocket(1234);
			
			System.out.println("Esperando clientes...");
			Socket cliente1 = servidor.accept();
			Socket cliente2 = servidor.accept();
			
			//Para leer de los clientes
			DataInputStream entradac1 = new DataInputStream(cliente1.getInputStream());
			DataInputStream entradac2 = new DataInputStream(cliente2.getInputStream());
			
			//Para enviar a los clientes
			DataOutputStream salidac1 = new DataOutputStream(cliente1.getOutputStream());
			DataOutputStream salidac2 = new DataOutputStream(cliente2.getOutputStream());
			
			int num = entradac1.readInt();
			salidac2.writeInt(num);
			
			int factorial = entradac2.readInt();
			salidac1.writeInt(factorial);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
