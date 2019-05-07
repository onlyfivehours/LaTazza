package latazza;
import java.util.ArrayList;

public class Personale {

	private ArrayList<Dipendente> listaPersonale;
	
	public Personale() {
		listaPersonale = new ArrayList<Dipendente>(); 
	}
	
	public int CercaDipendente(String nome, String cognome) {
		int index = 0;
		for(Dipendente d: listaPersonale) {
			if(d.isEqualDipendente(nome, cognome))
				return index;
			index++;
		}
		return -1;
	}
	

	public boolean aggiungiPersonale(String nome, String cognome) {
		if(CercaDipendente(nome,cognome) != -1)
			return false;
		listaPersonale.add(new Dipendente(nome,cognome));
		return true;
	}

	public boolean eliminaPersonale(String nome,String cognome) {
		int index = CercaDipendente(nome,cognome);
		if(index == -1) return false;
		listaPersonale.remove(index);
		return true;
	}
	
	
	public int size() {
		return listaPersonale.size();
	}
	
	public ArrayList<Dipendente> getPersonale() {
		return listaPersonale;
	}
	
	public String[] getStringPersonale() {
		String [] aux = new String[listaPersonale.size()];
		int i = 0;
		for(Dipendente element:listaPersonale) {
			aux[i] = element.getNome() + " " + element.getCognome();
			i++;
		}
		return aux;
	}
	
	public boolean IncrementaDebitoDipendente(String nome, String cognome,int euro, double centesimi) {
		int index = CercaDipendente(nome,cognome);
		if(index < 0) return false;
		listaPersonale.get(index).incrementaDebito(new Euro((long)euro,(long)centesimi));
		return true;
	}
	
	public boolean DecrementaDebitoDipendente(String nome, String cognome,int euro, double centesimi) {
		int index = CercaDipendente(nome,cognome);
		if(index < 0) return false;
		listaPersonale.get(index).decrementaDebito(new Euro((long)euro,(long)centesimi));
		return true;
	}
	
	
	
	public String[] getStringPersonaleConDebiti() {
		String [] aux = new String[listaPersonale.size()];
		int i = 0;
		for(Dipendente element:listaPersonale) {
			if(element.getDebito().getValore() > 0)
				aux[i] = element.getNome() + " " + element.getCognome();
			i++;
		}
		return aux;
	}

	
	public long getDebitoDipendente(String nome, String cognome) {
		int index = CercaDipendente(nome,cognome);
		if(index < 0)
			return (long)index;
		return listaPersonale.get(index).getDebito().getValore();
		
	}
	
	public String printDebitiPersonale() {
		String dati="\n\n";
		for(Dipendente d : listaPersonale){
			if(d.getDebito().getValore() > 0)
				dati += d.getNome() + " " + d.getCognome() + "debito:" + d.getDebito().stampa()+"\n";
		}
		if(dati.equals("\n\n")) dati += "nessun debito registrato";
		return dati;
	}
}
