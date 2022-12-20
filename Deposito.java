package productorconsumidor;

//Clase Deposito
public class Deposito {
	
	private double litrosdeposito;
	private boolean disponiblecamion=false; //Variable que dice si el deposito esta disponible para que un camion lo vacie
	//false -> camion no puede recoger porque estan llenando u otro camion esta cargando y espera
	//true -> camion puede recoger y no espera
	
	//método realiza llenado depósito del camión
	public synchronized double llenarDepositoCamion()
	{
		while(disponiblecamion == false) { //Mientras que el deposito no este disponible para camiones (alomejor hay alguien haciendo)
			try {
				wait(); //Espera
			} catch (InterruptedException e) {}
		}
		//Si esta disponible
		double resultado = litrosdeposito;
		litrosdeposito = 0;
		disponiblecamion=false; //Deja de estar disponible para camion. El productor debe llenar el deposito
		notify(); //Notifica de que se puede hacer otra operacion
		return resultado;
	}
	//método productor llena el depósito
	public synchronized void prodLlenaDep(double litros)
	{
		while(disponiblecamion == true) { //Mientras que el deposito este disponible para camiones (ya esta lleno y hay que esperar a que termine el camion)
			try {
				wait(); //Espera
			} catch (InterruptedException e) {}
		}
		//Si no esta disponible para camiones, se puede llenar
		litrosdeposito += litros;
		disponiblecamion=true; //Ahora esta disponible para camion
		notify(); //Notifica de que se puede hacer otra operacion
	}
}
