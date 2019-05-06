package latazza;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.custom.StyledText;

import java.awt.Color;

import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class Gui {
	private static Text txtQuantitascatole;
	private static Magazzino magazzino;
	private static Cassa cassa;
	private static Text txtNomeDipendente;
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
		Display display = new Display();
		//Display display = Display.getDefault();
		
		// SHELL BASE //
		Shell shlLatazza = new Shell(display);
		shlLatazza.setLayout(new FillLayout());
		shlLatazza.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		shlLatazza.setTouchEnabled(true);
		shlLatazza.setModified(true);
		shlLatazza.setSize(512, 330);
		shlLatazza.setText(" LaTazza");
		
		TabFolder tabFolder = new TabFolder(shlLatazza, SWT.NONE);
		tabFolder.setBounds(286, 168, 171, 82);
		
        TabItem tabGestionePersonale = new TabItem(tabFolder, SWT.NONE);
        tabGestionePersonale.setText("Gestione Personale");
	
        TabItem tabGestioneMagazzino = new TabItem(tabFolder, SWT.NONE | SWT.CLOSE);
        tabGestioneMagazzino.setText("Gestione Magazzino");
          
        Group grpGestioneMagazzino = new Group(tabFolder,SWT.NONE);
        tabGestioneMagazzino.setControl(grpGestioneMagazzino);
        grpGestioneMagazzino.setBounds(10, 10, 234, 123);
          
		
///////////////////////////////////////////////////////GESTIONE MAGAZZINO //////////////////////////////////////////////////////////////////////////
          
		Combo combo_SelezionaCialde = new Combo(grpGestioneMagazzino, SWT.NONE);
		combo_SelezionaCialde.setBounds(329, 10, 153, 34);
		String[] tipiDiCialde = {"caffè","caffè arabica","thè","thè al limone","cioccolata","camomilla"};
		combo_SelezionaCialde.setItems(tipiDiCialde);
		combo_SelezionaCialde.setText("tipo cialda");

		
		Button btnAggiungiCialde = new Button(grpGestioneMagazzino, SWT.NONE);
		btnAggiungiCialde.setBounds(378, 125, 79, 22);
		btnAggiungiCialde.setText("Compra");
		
		txtQuantitascatole = new Text(grpGestioneMagazzino, SWT.BORDER);
		txtQuantitascatole.setText("quantita (scatole)");
		txtQuantitascatole.setBounds(344, 60, 138, 29);
		
//////////////////////////////////////////////////////FINE GESTIONE MAGAZZINO ///////////////////////////////////////////////////////////////
		
		
          
//////////////////////////////////* GESTIONE PERSONALE *///////////////////////////////////////////////////////////////////////////////////////
	
          
          Group grpGestionePersonale = new Group(tabFolder,SWT.NONE);
          tabGestionePersonale.setControl(grpGestionePersonale);
          grpGestionePersonale.setBounds(10, 10, 234, 123);
          

          txtNomeDipendente = new Text(grpGestionePersonale, SWT.BORDER);
          txtNomeDipendente.setText("Nome Cognome");
          txtNomeDipendente.setBounds(276, 103, 168, 34);
          
          Button btnButtonAggiungiPersonale = new Button(grpGestionePersonale, SWT.NONE);
          btnButtonAggiungiPersonale.setBounds(325, 162, 81, 27);
          btnButtonAggiungiPersonale.setText("Aggiungi");
          
          Label lblLabelAggiungiPersonale = new Label(grpGestionePersonale, SWT.NONE);
          lblLabelAggiungiPersonale.setBounds(247, 195, 229, 54);

          Label lblLabelRimuoviPersonale = new Label(grpGestionePersonale, SWT.NONE);
          lblLabelRimuoviPersonale.setBounds(10, 195, 213, 54);
          
          Button btnButtonRimuoviPersonale = new Button(grpGestionePersonale, SWT.NONE);
          btnButtonRimuoviPersonale.setBounds(74, 162, 81, 27);
          btnButtonRimuoviPersonale.setText("Rimuovi");
          
          Combo combo_SelezionaPersonale = new Combo(grpGestionePersonale, SWT.NONE);
          combo_SelezionaPersonale.setBounds(37, 103, 186, 27);
          combo_SelezionaPersonale.setItems(personale.getStringPersonale());
          combo_SelezionaPersonale.setText("Nome Cognome");
          
          Label lblTitleRimuoviPersonale = new Label(grpGestionePersonale, SWT.NONE);
          lblTitleRimuoviPersonale.setBounds(56, 42, 122, 20);
          lblTitleRimuoviPersonale.setText("Rimuovi Personale");
          
          Label lblTitleAggiungiPersonale = new Label(grpGestionePersonale, SWT.NONE);
          lblTitleAggiungiPersonale.setBounds(302, 42, 121, 20);
          lblTitleAggiungiPersonale.setText("Aggiungi Personale");

////////////////////////////////////////////////// FINE GESTIONE PERSONALE //////////////////////////////////////////////////////////////////////////

		
		
		
		
		btnAggiungiCialde.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//System.out.println(combo.getText() + " cialde");
				switch(combo_SelezionaCialde.getText()) {
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
		
		
		btnButtonAggiungiPersonale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String NomeCognome = txtNomeDipendente.getText();
				if(NomeCognome.isEmpty() || NomeCognome.equals("Nome Cognome")) return;
				
				String [] NuovoDipendente = NomeCognome.split(" ");

				if(personale.aggiungiPersonale(NuovoDipendente[0],NuovoDipendente[1])) {
					lblLabelAggiungiPersonale.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					lblLabelAggiungiPersonale.setText((txtNomeDipendente.getText()+" aggiunto nel sistema"));
				}else {
					lblLabelAggiungiPersonale.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					lblLabelAggiungiPersonale.setText(txtNomeDipendente.getText()+" è già presente nel sistema");
				}
				combo_SelezionaPersonale.setItems(personale.getStringPersonale());
				combo_SelezionaPersonale.setText("Nome Cognome");
			}
		});
		
		
		btnButtonRimuoviPersonale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String NomeCognome = combo_SelezionaPersonale.getText();
				if(NomeCognome.equals("Nome Cognome")) return;
				
				String [] DipendenteEliminato = NomeCognome.split(" ");
				personale.eliminaPersonale(DipendenteEliminato[0],DipendenteEliminato[1]);
				combo_SelezionaPersonale.setItems(personale.getStringPersonale());
				lblLabelRimuoviPersonale.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				lblLabelRimuoviPersonale.setText(NomeCognome + " rimosso dal sistema");
				combo_SelezionaPersonale.setText("Nome Cognome");
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