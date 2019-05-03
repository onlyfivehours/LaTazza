package latazza;
import java.util.ArrayList;

public class Personale {

	private ArrayList<Dipendente> listaPersonale;
	
	public Personale() {
		listaPersonale = new ArrayList<Dipendente>(); 
	}
	
	public void aggiungiPersonale(Dipendente d) {
		listaPersonale.add(d);
	}

	public boolean eliminaPersonale(Dipendente d) {
		return listaPersonale.remove(d);
	}
	
	public ArrayList<Dipendente> getPersonale() {
		return listaPersonale;
	}
	
	
	//TODO ricordarsi di mettere un trigger che aggiorni la stampa dei debiti dopo che essi sono stati pagati o
	//sono diminuiti
	public String printDebitiPersonale() {
		String dati="";
		for(Dipendente d : listaPersonale){
			if(d.getDebito().getValore() > 0)
				dati += d.getNome() + " " + d.getCognome() + ":" + d.getDebito().stampa()+"\n";
		}
		return dati;
	}
}
