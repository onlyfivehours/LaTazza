package latazza;


public class Cassa {

	private Euro saldo;
	
	
	public Cassa() {
		saldo = new Euro(0);
	}
	
	public void aggiungiSaldo(Euro importo) {
		saldo.somma(importo);
	}
	
	public boolean prelevaDenaro(Euro importo) {
		return saldo.sottrai(importo);
		
	}
	
	public Euro getSaldo() {
		return this.saldo;
	}
	
	public String printSaldo() {
		return saldo.stampa();
	}
}
