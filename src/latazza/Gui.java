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
		shlLatazza.setSize(680, 680);
		shlLatazza.setText(" LaTazza");
		
		TabFolder tabFolder = new TabFolder(shlLatazza, SWT.NONE);
		tabFolder.setBounds(286, 168, 171, 82);
		
        TabItem tabGestionePersonale = new TabItem(tabFolder, SWT.NONE);
        tabGestionePersonale.setText("Gestione Personale");
	
        TabItem tabGestioneGenerale = new TabItem(tabFolder, SWT.NONE | SWT.CLOSE);
        tabGestioneGenerale.setText("Gestione Generale");
       
        
        
          
		
///////////////////////////////////////////////////////GESTIONE MAGAZZINO //////////////////////////////////////////////////////////////////////////
          
        Group grpGestioneGenerale = new Group(tabFolder,SWT.NONE);
        tabGestioneGenerale.setControl(grpGestioneGenerale);
        grpGestioneGenerale.setBounds(10, 10, 234, 123);
        
       Group GestioneMagazzino = new Group(grpGestioneGenerale, SWT.NONE);
  	   GestioneMagazzino.setBounds(10, 304, 297, 254);
  	   GestioneMagazzino.setText("Gestione Magazzino");
  	  
  	   Group GestioneVendite = new Group(grpGestioneGenerale, SWT.NONE);
  	   GestioneVendite.setBounds(10, 10, 297, 254);
  	   GestioneVendite.setText("Gestione Vendite");
  	   
	   Group DatiGenerali = new Group(grpGestioneGenerale, SWT.NONE);
  	   DatiGenerali.setBounds(346, 304, 318, 254);
  	   DatiGenerali.setText("Dati Generali");
  	   
  	   
        
		Combo combo_SelezionaCialde = new Combo(GestioneMagazzino, SWT.NONE);
		combo_SelezionaCialde.setBounds(55, 29, 153, 34);
		String[] tipiDiCialde = {"caffè","caffè arabica","thè","thè al limone","cioccolata","camomilla"};
		combo_SelezionaCialde.setItems(tipiDiCialde);
		combo_SelezionaCialde.setText("tipo cialda");

		
		Button btnAggiungiCialde = new Button(GestioneMagazzino, SWT.NONE);
		btnAggiungiCialde.setBounds(96, 122, 79, 22);
		btnAggiungiCialde.setText("Compra");
		
		txtQuantitascatole = new Text(GestioneMagazzino, SWT.BORDER);
		txtQuantitascatole.setText("quantita (scatole)");
		txtQuantitascatole.setBounds(70, 72, 138, 29);
		
		Group GestioneDebiti = new Group(grpGestioneGenerale, SWT.NONE);
		GestioneDebiti.setBounds(346, 10, 318, 254);
		GestioneDebiti.setText("Gestione Debiti");
		
//////////////////////////////////////////////////////FINE GESTIONE MAGAZZINO ///////////////////////////////////////////////////////////////
		
		
          
//////////////////////////////////* GESTIONE PERSONALE *///////////////////////////////////////////////////////////////////////////////////////
        
        Group grpGestionePersonale = new Group(tabFolder,SWT.NONE);
        tabGestionePersonale.setControl(grpGestionePersonale);
        grpGestionePersonale.setBounds(10, 10, 234, 123);
        
        
    	  Group AggiungiPersonale = new Group(grpGestionePersonale, SWT.NONE);
    	  AggiungiPersonale.setBounds(10, 10, 297, 254);
    	  AggiungiPersonale.setText("Aggiungi Personale");
    	  
    	  Group EliminaPersonale = new Group(grpGestionePersonale, SWT.NONE);
    	  EliminaPersonale.setBounds(346, 10, 318, 254);
    	  EliminaPersonale.setText("Elimina Personale");
    	  

        txtNomeDipendente = new Text(AggiungiPersonale, SWT.BORDER);
        txtNomeDipendente.setText("Nome Cognome");
        txtNomeDipendente.setBounds(63, 65, 168, 34);
        
        Button btnButtonAggiungiPersonale = new Button(AggiungiPersonale, SWT.NONE);
        btnButtonAggiungiPersonale.setBounds(104, 115, 81, 27);
        btnButtonAggiungiPersonale.setText("Aggiungi");
        
        Label lblLabelAggiungiPersonale = new Label(AggiungiPersonale, SWT.NONE);
        lblLabelAggiungiPersonale.setBounds(10, 168, 275, 54);

        Label lblLabelRimuoviPersonale = new Label(EliminaPersonale, SWT.NONE);
        lblLabelRimuoviPersonale.setBounds(10, 168, 296, 54);
        
        Button btnButtonRimuoviPersonale = new Button(EliminaPersonale, SWT.NONE);
        btnButtonRimuoviPersonale.setBounds(125, 117, 81, 27);
        btnButtonRimuoviPersonale.setText("Rimuovi");
        
        Combo combo_SelezionaPersonale = new Combo(EliminaPersonale, SWT.NONE);
        combo_SelezionaPersonale.setBounds(83, 65, 186, 27);
        combo_SelezionaPersonale.setItems(personale.getStringPersonale());
        combo_SelezionaPersonale.setText("Nome Cognome");
        

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