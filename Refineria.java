package productorconsumidor;

public class Refineria {
	public static void main(String[] args) {
		Deposito dep = new Deposito();
		Camion [] camiones = {new Camion(dep,1), new Camion(dep,2), new Camion(dep,3)};
		Productor prod = new Productor(dep);
		
		prod.start();
		camiones[0].start();
		camiones[1].start();
		camiones[2].start();
	}
}
