package latazza;
import java.util.ArrayList;

public class Personale {

	private ArrayList<Dipendente> listaPersonale;
	
	public Personale() {
		listaPersonale = new ArrayList<Dipendente>(); 
	}
	
	public int searchD(Dipendente d) {
		int i = 0;
		for(Dipendente element:listaPersonale) {
			if(d.equals(element) == true)
				return i;
			i++;
		}
		return -1;
	}
	
	public boolean aggiungiPersonale(Dipendente d) {
		if(searchD(d) != -1)
			return false;
		listaPersonale.add(d);
		return true;
	}

	public boolean eliminaPersonale(Dipendente d) {
		int index = searchD(d);
		if(index == -1) return false;
		listaPersonale.remove(index);
		return true;
	}
	
	public ArrayList<Dipendente> getPersonale() {
		return listaPersonale;
	}
	
	public String[] getValori() {
		String [] aux = new String[listaPersonale.size()];
		int i = 0;
		for(Dipendente element:listaPersonale) {
			aux[i] = element.getNome() + " " + element.getCognome();
			i++;
		}
		return aux;
	}
	
	public int size() {
		return listaPersonale.size();
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
