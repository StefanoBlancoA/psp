package ut3;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
public class ServidorMultiplesMaquinas {
	public static void main(String[] args) {
	    int puerto=5555;
	    
	    ArrayList<Socket> clientes = new ArrayList<Socket>();
	    
	    boolean activo = true;
	    
	    try 
	    {
	    	InetAddress ipServer= InetAddress.getByName("192.168.2.224"); //Obtenemos la ip de la máquina para usarla en el constructor de ServerSocket
			int numConexiones = 4; //Número de conexiones que se usarán. Pueden ser tantas como queramos
	    	
	    	ServerSocket Servidor = new ServerSocket(puerto,numConexiones,ipServer); 
			System.out.println("Servidor escuchando en "+ Servidor.getInetAddress().getHostAddress());
	    	while(activo) {
				Socket cliente1= Servidor.accept(); //Esperando conexión cliente
				if(cliente1!=null) {
					clientes.add(cliente1);
					System.out.println("Cliente "+clientes.size()+" conectado");
				}
	    	}
			Servidor.close();
	    	
	     }catch (IOException excepcion) {
	    	 excepcion.printStackTrace();  
	     }
	}

}

