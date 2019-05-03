package latazza;

public class Cialda {
	private TipoCialda tipo;
	private int quantita = 0;
	
	public Cialda(TipoCialda tipo) {
		this.tipo = tipo;
		
	}
	
	public TipoCialda  getTipoCialda() {
		return tipo;
	}
	
	public int getQuantità() {
		return quantita;
	}
	//TODO non so se va bene cosi o se è necessario creare una classe "scatola"
	public void aggiungiCialda(int scatole){
		quantita += (scatole * 50);
	}
	
	public boolean eliminaCialda(int q) {
		if(q > quantita)
			return false;
		else {
			quantita -= q;
			return true;
		}
	}
	
}
