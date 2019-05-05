package latazza;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;



public class Gui {
	private static Text txtQuantitascatole;
	private static Magazzino magazzino;
	private static Cassa cassa;
	private static Text txtNome;
	private static Personale personale;
	
	
	
	
	public static void initialize() {
		cassa = new Cassa();
		magazzino = new Magazzino();
		personale = new Personale();
	}
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		initialize();
		
		Display display = Display.getDefault();
		Shell shlLatazza = new Shell();
		shlLatazza.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		shlLatazza.setTouchEnabled(true);
		shlLatazza.setModified(true);
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
		
		Menu menu = new Menu(shlLatazza, SWT.BAR);
		shlLatazza.setMenuBar(menu);
		
		MenuItem mntmGestionePersonale = new MenuItem(menu, SWT.NONE);
		mntmGestionePersonale.setText("Gestione personale");
		
		MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("chiudi");
		
		Group grpAggiungiPersonale = new Group(shlLatazza, SWT.NONE);
		grpAggiungiPersonale.setText("Aggiungi Personale");
		grpAggiungiPersonale.setBounds(10, 10, 234, 123);
		
		txtNome = new Text(grpAggiungiPersonale, SWT.BORDER);
		txtNome.setText("Nome");
		txtNome.setBounds(35, 10, 125, 20);
		
		Button btnNewButton_2 = new Button(grpAggiungiPersonale, SWT.NONE);
		btnNewButton_2.setBounds(57, 68, 81, 27);
		btnNewButton_2.setText("Aggiungi");
		
		Label lblNewLabel_1 = new Label(grpAggiungiPersonale, SWT.NONE);
		lblNewLabel_1.setBounds(10, 36, 212, 17);
		
		Group grpRimuovi = new Group(shlLatazza, SWT.NONE);
		grpRimuovi.setText("Rimuovi Personale");
		grpRimuovi.setBounds(10, 149, 234, 118);
		
		Label lblNewLabel = new Label(grpRimuovi, SWT.NONE);
		lblNewLabel.setBounds(10, 43, 201, 17);
		
		Button btnNewButton_1 = new Button(grpRimuovi, SWT.NONE);
		btnNewButton_1.setBounds(52, 66, 81, 27);
		btnNewButton_1.setText("rimuovi");
		
		Combo combo_1 = new Combo(grpRimuovi, SWT.NONE);
		combo_1.setBounds(10, 10, 186, 27);
		combo_1.setItems(personale.getValori());
		combo_1.setText("Nome");
		


		
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(combo.getText() + " cialde");
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
		
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		
		mntmGestionePersonale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {				
				//boh non so ancora come gestire l'evento
			}
		});
		
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String [] persona = txtNome.getText().split(" ");
				Dipendente d = new Dipendente(persona[0], persona[1]);
				System.out.println("aggiunto "+ persona[0] + " " + persona[1]);

				
				if(personale.aggiungiPersonale(d) == true) {
					lblNewLabel_1.setText((txtNome.getText()+" aggiunto nel sistema"));
					lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				}else {
					lblNewLabel_1.setText(txtNome.getText()+" è già presente nel sistema");
					lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				}
				combo_1.setItems(personale.getValori());
				combo_1.setText("Nome");
			}
		});
		
		
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String str = combo_1.getText();
				if(str.equals("Nome")) return;
				
				String [] persona = str.split(" ");
				Dipendente d = new Dipendente(persona[0], persona[1]);
				System.out.println(persona[0] + " " + persona[1]);
				personale.eliminaPersonale(d);
				combo_1.setItems(personale.getValori());
				lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				lblNewLabel.setText(str + " rimosso dal sistema");
				combo_1.setText("Nome");
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