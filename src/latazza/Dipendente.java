package latazza;

public class Dipendente {

	private String nome;
	private String cognome;
	private Euro debito;
	
	
	public Dipendente(String nome,String cognome, Euro debito) {
		this.nome = nome;
		this.cognome = cognome;
		this.debito = debito;
	}
	
	public Dipendente(String nome,String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		debito = new Euro(0);
	}
	
	
	public boolean isEqualDipendente(String nome,String cognome) {
		return (this.nome.equals(nome) && this.cognome.equals(cognome));
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	public void incrementaDebito(Euro importo) {
		debito.somma(importo);
	}
	
	public boolean decrementaDebito(Euro importo) {
		return debito.sottrai(importo);
	}
	
	public String stampaDebito() {
		return debito.stampa();
	}
	
	public Euro getDebito() {
		return debito;
	}
	
	
	
}
	
