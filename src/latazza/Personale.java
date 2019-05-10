package latazza;
import java.util.ArrayList;

public class Personale {

	private ArrayList<Dipendente> listaPersonale;
	
	public Personale() {
		listaPersonale = new ArrayList<Dipendente>(); 
	}
	
	
	public ArrayList<Dipendente> getPersonale() {
		return listaPersonale;
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
	
	public void IncrementaDebitoDipendente(String nome, String cognome,Euro importo) {
		int index = CercaDipendente(nome,cognome);
		listaPersonale.get(index).incrementaDebito(importo);
	}
	
	public boolean DecrementaDebitoDipendente(String nome, String cognome,Euro importo) {
		int index = CercaDipendente(nome,cognome);
		return listaPersonale.get(index).decrementaDebito(importo);
		
	}
	
	
	public long getDebitoDipendente(String nome, String cognome) {
		int index = CercaDipendente(nome,cognome);
		return listaPersonale.get(index).getDebito().getValore();
		
	}
	
	
	public int size() {
		return listaPersonale.size();
	}
	

	
	//ritorna un array di stringhe contenente il nome ed il cognome di tutti i dipendenti aggiunti
	public String[] getStringPersonale() {
		String [] aux = new String[listaPersonale.size()];
		int i = 0;
		for(Dipendente element:listaPersonale) {
			aux[i] = element.getNome() + " " + element.getCognome();
			i++;
		}
		return aux;
	}
	


	//ritorna un array di stringhe contenente il nome ed il cognome dei soli dipendenti
	//aventi debito
	public String[] getArrayStringPersonaleConDebiti() {
		ArrayList<Dipendente> personaleConDebiti =  new ArrayList<Dipendente>();
		for(Dipendente element:listaPersonale)
			if(element.getDebito().getValore() > 0)
				personaleConDebiti.add(element);
		
		String [] debitori = new String[personaleConDebiti.size()];
		int i = 0;
		for(Dipendente element:personaleConDebiti) {
			debitori[i] = element.getNome() + " " + element.getCognome();
			i++;
		}
		return debitori;
	}
	
	//ritorna la stringa contenente i debiti di ogni dipendente. questa stringa andra stampata
	//sulla tab delle informazioni sui debitori
	public String getStringPersonaleConDebiti() {
		String dati="\n\n";
		for(Dipendente d : listaPersonale){
			if(d.getDebito().getValore() > 0)
				dati += d.getNome() + " " + d.getCognome() + " debito:" + d.getDebito().getStringValore()+"\n";
		}
		if(dati.equals("\n\n")) dati = "nessun debito registrato";
		return dati;
	}
}
