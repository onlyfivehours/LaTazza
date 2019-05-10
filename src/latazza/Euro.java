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
	
	public void somma(Euro e) {
		this.valore = this.valore + e.getValore();
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

	
	public String getStringValore(){
		return (double)valore/100 +"€";
	}
}