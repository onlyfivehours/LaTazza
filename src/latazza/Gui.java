package latazza;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

public class Gui {
	private static Text txtQuantitascatole;
	private static Magazzino magazzino;
	private static Cassa cassa;
	
	
	
	
	public static void initialize() {
		cassa = new Cassa();
		magazzino = new Magazzino();
	}
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		initialize();
		
		Display display = Display.getDefault();
		Shell shlLatazza = new Shell();
		shlLatazza.setSize(512, 330);
		shlLatazza.setText(" LaTazza");
		
	
		Combo combo = new Combo(shlLatazza, SWT.NONE);
		combo.setBounds(329, 10, 153, 34);
		String[] items = {"caffè","caffè arabica","thè","thè al limone","cioccolata","camomilla"};
		//TODO: modificare items, con nomi delle variabili.
		combo.setItems(items);
		combo.setText("tipo cialda");

		
		Button btnNewButton = new Button(shlLatazza, SWT.NONE);
		btnNewButton.setBounds(378, 125, 79, 22);
		btnNewButton.setText("Calculate");
		
		txtQuantitascatole = new Text(shlLatazza, SWT.BORDER);
		txtQuantitascatole.setText("quantita (scatole)");
		txtQuantitascatole.setBounds(344, 60, 138, 29);
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				switch(combo.getText()) {
					case "caffè":  if(cassa.getSaldo().getValore() < 2000 * Integer.parseInt(txtQuantitascatole.getText()))
					
					break;
					case "caffè arabica": break;
					case "thè": System.out.println("the");  break;
					case "thè al limone": System.out.println("the al limone"); break;
					case "cioccolata" : System.out.println("cioccolata"); break;
					case "camomilla":System.out.println("camomilla"); break;
					default: System.out.println("default");
				}
			}
		});
		
		
		
		
		
		
		
		
		shlLatazza.open();
		shlLatazza.layout();
		while (!shlLatazza.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}