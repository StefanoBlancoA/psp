package productorconsumidor;

//Clase Deposito
public class Deposito {
	
	private double litrosdeposito;
	
	//método realiza llenado depósito del camión
	public double llenarDepositoCamion()
	{
		double resultado = litrosdeposito;
		litrosdeposito = 0;
		return resultado;
	}
	//método productor llena el depósito
	public void prodLlenaDep(double litros)
	{
		litrosdeposito += litros;
	}
}