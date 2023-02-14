package ejercicios.ejercicio1;

import java.io.*;
import java.net.*;

public class Cliente2TCP {
	public static void main (String [] args) {
		try {
			
			String host = "localhost";
			int puerto = 1234;
			
			Socket c2 = new Socket(host,puerto);
			
			DataInputStream dis = new DataInputStream(c2.getInputStream());
			
			int num = dis.readInt();
			System.out.println("Numero leido: "+num);
			
			int factorial = calcularFactorial(num);
			System.out.println("Calculando factorial... ");
			
			DataOutputStream dos = new DataOutputStream(c2.getOutputStream());
			
			dos.writeInt(factorial);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int calcularFactorial(int numero) {
		int resultado = 1;
		for(int i=1; i<=numero; i++) {
			resultado = resultado*i;
		}
		return resultado;
	}
	
}
