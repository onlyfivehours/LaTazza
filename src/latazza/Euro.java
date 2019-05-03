package latazza;

public class Euro {
	private long valore;
	
	public Euro(long euro, long cent) {
		valore = euro*100 + cent;
	}

	public Euro(double d) {
		valore = (long)(d*100);
	}
	
	public long getValore() {
		return valore;
	}
	
	public Euro somma(Euro e) {
		this.valore = this.valore + e.getValore();
		return this;
	}
	
	public boolean sottrai(Euro e) {
		long temp = this.valore - e.getValore();
		if(temp < 0)
			return false;
		else {
			this.valore = temp;
			return true;
		}
	}
	
	public boolean ugualeA(Euro e){
		if (valore == e.getValore())
			return true;
		else return false;
	}
	
	public boolean minoreDi(Euro e){
		if (valore <= e.getValore())
			return true;
		else return false;
	}
	
	public String stampa(){
		return (double)valore/100 +"€";
	}
}
