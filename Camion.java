package productorconsumidor;

//Clase Camion
public class Camion extends Thread {
	
	private int n;
	private Deposito dep;
	private double volumenRecogido;
	
	//Constructor clase camión: n -> número de camión
	public Camion (Deposito dep, int n)
	{
		this.dep = dep;
		this.n = n;
		volumenRecogido = 0;
	}
	public synchronized void run()
	{
		for(int i=1; i<=5; i++) {
			try {
				wait();
				double carga = dep.llenarDepositoCamion();
				volumenRecogido += carga;
				System.out.println("Camión "+n+" carga: "+carga+" litros.");
				notify();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Camión "+n+" => Volumen total recogido: "+volumenRecogido+" litros. Finalizado.");
	}
}