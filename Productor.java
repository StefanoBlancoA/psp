package productorconsumidor;

//Clase Productor
public class Productor extends Thread {
	
	private Deposito dep;
	
	//Constructor clase productor
	public Productor(Deposito dep)
	{
		this.dep = dep;
	}
	public void run()
	{
		for(int i=1; i<=15; i++) {
			double litros = Math.random()*1000;
			dep.prodLlenaDep(litros);
			System.out.println("Productor llena el depósito "+litros+" litros.");
			try {
				sleep(500);
			}catch(Exception e) {}
		}
	}
}
