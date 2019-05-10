package latazza;


public class Cassa {

	private Euro saldo;
	
	
	public Cassa(long euro) {
		saldo = new Euro(euro);
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
	
	public String getStringSaldo() {
		return "Saldo disponibile: "+saldo.getStringValore();
	}
}
