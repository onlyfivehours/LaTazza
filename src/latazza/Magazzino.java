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
	
	
	public int getQuantitaCialda(String nome) {
		switch(nome) {
			case "caffè" : return caffe.getQuantità();
			case "caffè arabica" : return caffeArabica.getQuantità();
			case "thè" : return the.getQuantità();
			case "thè al limone" : return theLimone.getQuantità();
			case "camomilla" : return camomilla.getQuantità();
			case "cioccolata" : return cioccolata.getQuantità();
		}
		return -1;
		
	}
	
	public void AggiungiCialda(String nome,int numeroScatole) {
		switch(nome) {
			case "caffè" :  caffe.aggiungiCialda(numeroScatole); break;
			case "caffè arabica" :  caffeArabica.aggiungiCialda(numeroScatole); break;
			case "thè" :  the.aggiungiCialda(numeroScatole); break;
			case "thè al limone" :theLimone.aggiungiCialda(numeroScatole); break;
			case "camomilla" :  camomilla.aggiungiCialda(numeroScatole); break;
			case "cioccolata" :  cioccolata.aggiungiCialda(numeroScatole); break;
		}	
	}
	
	public boolean EliminaCialda(String nome,int  quantita) {
		switch(nome) {
			case "caffè" : return caffe.eliminaCialda(quantita);
			case "caffè arabica" : return caffeArabica.eliminaCialda(quantita);
			case "thè" : return the.eliminaCialda(quantita);
			case "thè al limone" : return theLimone.eliminaCialda(quantita);
			case "camomilla" : return camomilla.eliminaCialda(quantita);
			case "cioccolata" : return cioccolata.eliminaCialda(quantita);
		}
		return false;
		
	}
	
	
	
	public String stampaInformazioniMagazzino() {
		return "\n\ncialde caffe: "+caffe.getQuantità()+"\n"+
			   "cialde caffe arabica: "+caffeArabica.getQuantità()+"\n"+
			   "cialde the: "+the.getQuantità()+"\n"+
		       "cialde the limone: "+theLimone.getQuantità()+"\n"+
			   "cialde camomilla: "+camomilla.getQuantità()+"\n"+
		       "cialde cioccolato: "+cioccolata.getQuantità();   
	}
		
	
	
	
}
