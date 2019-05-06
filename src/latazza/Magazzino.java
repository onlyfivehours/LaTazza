package latazza;

public class Magazzino {
	private Cialda caffe;
	private Cialda caffeArabica;
	private Cialda the;
	private Cialda theLimone;
	private Cialda camomilla;
	private Cialda cioccolata;
	
	
	public Magazzino() {
		caffe = new Cialda(TipoCialda.caffè);
		caffeArabica = new Cialda(TipoCialda.caffè_arabico);
		the = new Cialda(TipoCialda.thè);
		theLimone = new Cialda(TipoCialda.thè_limone);
		camomilla = new Cialda(TipoCialda.camomilla);
		cioccolata = new Cialda(TipoCialda.cioccolata);
	}
	
	public int getCialdeCaffe() {
		return caffe.getQuantità();
	}
	
	public int getCialdeCaffeArabica() {
		return caffeArabica.getQuantità();
	}
	
	public int getCialdeThe() {
		return the.getQuantità();
	}
	
	public int getCialdeTheLimone() {
		return theLimone.getQuantità();
	}
	
	public int getCialdeCamomilla() {
		return camomilla.getQuantità();
	}
	
	public int getCialdeCioccolata() {
		return cioccolata.getQuantità();
	}
	
	
	public void AggiungiCialdeCaffe(int numeroScatole) {
		caffe.aggiungiCialda(numeroScatole);
	}
	
	public void AggiungiCialdeCaffeArabica(int numeroScatole){
		caffeArabica.aggiungiCialda(numeroScatole);
	}
	
	public void AggiungiCialdeThe(int numeroScatole) {
		the.aggiungiCialda(numeroScatole);
	}
	
	public void AggiungiCialdeTheLimone(int numeroScatole) {
		theLimone.aggiungiCialda(numeroScatole);
	}
	
	public void  AggiungiCialdeCamomilla(int numeroScatole) {
		camomilla.aggiungiCialda(numeroScatole);
	}
	
	public void AggiungiCialdeCioccolata(int numeroScatole) {
		cioccolata.aggiungiCialda(numeroScatole);
	}
	
///////////////////////////////////////////////////////////
	
	public void EliminaCialdeCaffe(int numeroScatole) {
		caffe.eliminaCialda(numeroScatole);
	}
	
	public void EliminaCialdeCaffeArabica(int numeroScatole){
		caffeArabica.eliminaCialda(numeroScatole);
	}
	
	public void EliminaCialdeThe(int numeroScatole) {
		the.eliminaCialda(numeroScatole);
	}
	
	public void EliminaCialdeTheLimone(int numeroScatole) {
		theLimone.eliminaCialda(numeroScatole);
	}
	
	public void  EliminaCialdeCamomilla(int numeroScatole) {
		camomilla.eliminaCialda(numeroScatole);
	}
	
	public void EliminaCialdeCioccolata(int numeroScatole) {
		cioccolata.eliminaCialda(numeroScatole);
	}
	
	
	
	public String stampaInformazioniMagazzino() {
		return "cialde caffe: "+getCialdeCaffe()+"\n"+
			   "cialde caffe arabica: "+getCialdeCaffeArabica()+"\n"+
			   "cialde the: "+getCialdeThe()+"\n"+
		       "cialde the limone: "+getCialdeTheLimone()+"\n"+
			   "cialde camomilla: "+getCialdeCamomilla()+"\n"+
		       "cialde cioccolato: "+getCialdeCioccolata();   
	}
		
	
	
	
}
