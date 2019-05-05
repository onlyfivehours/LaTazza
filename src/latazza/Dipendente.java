package latazza;

public class Dipendente {

	private String nome;
	private String cognome;
	private Euro debito;
	
	public Dipendente(String nome,String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		debito = new Euro(0);
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
	
	public boolean equals(Object obj) {
		  if (this == obj) {
		    return true;
		  }
		  if (obj == null) {
		    return false;
		  }
		  if (getClass() != obj.getClass()) {
		    return false;
		  }
		  Dipendente other = (Dipendente) obj;
		  if (cognome == null) {
		    if (other.cognome != null) {
		      return false;
		    }
		  } else if (!cognome.equals(other.cognome)) {
		    return false;
		  }
		  if (nome == null) {
		    if (other.nome != null) {
		      return false;
		    }
		  } else if (!nome.equals(other.nome)) {
		    return false;
		  }
		  return true;
		}
}
