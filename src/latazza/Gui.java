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
	private static Text txtNomeVisitatore;
	private static Text txtQuantitcialde;
	
	
	public static int strConvertInt(String str) {
		
		try
	    {
	      return Integer.parseInt(str.trim());
	    }
	    catch (NumberFormatException nfe)
	    {
	    	return -1;
	    }
	}
	
	public static void initialize() {
		cassa = new Cassa(50);
		magazzino = new Magazzino();
		personale = new Personale();
	}

	
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
  	   
        Group GestioneDebiti = new Group(grpGestioneGenerale, SWT.NONE);
		GestioneDebiti.setBounds(346, 10, 318, 254);
		GestioneDebiti.setText("Gestione Debiti");
		
		
		
		
		
//////////////////////////////////////////////////////DATI GENERALI/////////////////////////////////////////////////////////////////////////////////////
		
		

		   TabFolder tabFolderDati = new TabFolder(DatiGenerali, SWT.NONE);
	  	   tabFolderDati.setBounds(10, 20, 296, 202);
	  	   
	  	   TabItem tabItemMagazzino = new TabItem(tabFolderDati, SWT.NONE);
	  	   tabItemMagazzino.setText("Magazzino");
	  	 
	  	   TabItem tabItemCassa = new TabItem(tabFolderDati, SWT.NONE);
	  	   tabItemCassa.setText("Cassa");
	  	
	  	   TabItem tabItemDebiti = new TabItem(tabFolderDati, SWT.NONE);
	  	   tabItemDebiti.setText("Debiti");
	  
	  	
	  	   Label lblInformazioniMagazzino = new Label(tabFolderDati,SWT.NONE);
	  	   tabItemMagazzino.setControl(lblInformazioniMagazzino);
	  	   lblInformazioniMagazzino.setText(magazzino.stampaInformazioniMagazzino());
			
	  	   Label lblInformazioniCassa = new Label(tabFolderDati,SWT.NONE);
	  	   tabItemCassa.setControl(lblInformazioniCassa);
	  	   lblInformazioniCassa.setText(cassa.printSaldo());
			
	  	   Label lblInformazioniDebiti = new Label(tabFolderDati,SWT.NONE);
	  	   tabItemDebiti.setControl(lblInformazioniDebiti);
	  	   lblInformazioniDebiti.setText(personale.printDebitiPersonale());
			
	  	   

//////////////////////////////////////////////////////FINE DATI GENERALI////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
///////////////////////////////////////////////////////GESTIONE MAGAZZINO //////////////////////////////////////////////////////////////////////////
          
   
  	   
        
		Combo combo_SelezionaCialde = new Combo(GestioneMagazzino, SWT.NONE);
		combo_SelezionaCialde.setBounds(55, 29, 153, 34);
		String[] tipiDiCialde = {"caffè","caffè arabica","thè","thè al limone","cioccolata","camomilla"};
		combo_SelezionaCialde.setItems(tipiDiCialde);
		combo_SelezionaCialde.setText("tipo cialda");

		
		Button btnAggiungiCialde = new Button(GestioneMagazzino, SWT.NONE);
		btnAggiungiCialde.setBounds(10, 122, 145, 22);
		btnAggiungiCialde.setText("Registra Rifornimenti");
		
		Button btnCancellaMagazzino = new Button(GestioneMagazzino, SWT.NONE);
		btnCancellaMagazzino.setBounds(173, 122, 79, 22);
		btnCancellaMagazzino.setText("Cancella");
		
		txtQuantitascatole = new Text(GestioneMagazzino, SWT.BORDER);
		txtQuantitascatole.setText("quantita (scatole)");
		txtQuantitascatole.setBounds(70, 72, 138, 29);
		Label lblMessaggioErroreMagazzino = new Label(GestioneMagazzino, SWT.NONE);
		lblMessaggioErroreMagazzino.setBounds(10, 164, 275, 58);

		
		btnCancellaMagazzino.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				combo_SelezionaCialde.setText("tipo cialda");
				txtQuantitascatole.setText("quantita (scatole)");
			}
		});
		
		btnAggiungiCialde.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo_SelezionaCialde.getText().equals("tipo cialda") || txtQuantitascatole.getText().equals("quantita (scatole)")) {
					lblMessaggioErroreMagazzino.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					lblMessaggioErroreMagazzino.setText("Riempire tutti i campi prima di procedere");
					return;
				}
					
				int input = strConvertInt(txtQuantitascatole.getText());
				if(input <= 0) {
					lblMessaggioErroreMagazzino.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					lblMessaggioErroreMagazzino.setText("inserire una quantita numerica >= 1");
				}
				else if(!cassa.prelevaDenaro(new Euro(20 * input))) { 
					lblMessaggioErroreMagazzino.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					lblMessaggioErroreMagazzino.setText("Il rifornimento non può essere effettuato:"
							+ " \ncosto di "+input+" scatole di "+combo_SelezionaCialde.getText()+": "+(2000*input)/100+" euro\n"
									+cassa.printSaldo());
				  	tabFolderDati.setSelection(1);
				  	lblInformazioniCassa.setText(cassa.printSaldo());

				}
				else {
					switch(combo_SelezionaCialde.getText()) {
						case "caffè": magazzino.AggiungiCialdeCaffe(input); break;
						case "caffè arabica": magazzino.AggiungiCialdeCaffeArabica(input); break;
						case "thè": System.out.println("the"); magazzino.AggiungiCialdeThe(input); break;
						case "thè al limone": System.out.println("the al limone"); magazzino.AggiungiCialdeTheLimone(input); break;
						case "cioccolata" : System.out.println("cioccolata"); magazzino.AggiungiCialdeCioccolata(input); break;
						case "camomilla":System.out.println("camomilla"); magazzino.AggiungiCialdeCamomilla(input); break;
					}
					lblMessaggioErroreMagazzino.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					lblMessaggioErroreMagazzino.setText("Rifornimento registrato per \n"+ input+
							" scatole di "+combo_SelezionaCialde.getText()+" per un totale di "+input*20+"€");
				  	tabFolderDati.setSelection(0);
				  	lblInformazioniMagazzino.setText(magazzino.stampaInformazioniMagazzino());
				  	lblInformazioniCassa.setText(cassa.printSaldo());
				}
			}
		});
		
		
//////////////////////////////////////////////////////FINE GESTIONE MAGAZZINO ///////////////////////////////////////////////////////////////
		
        
//////////////////////////////////////////////////////Registra Vendite Cialde///////////////////////////////////////////////////////////////////////

Combo comboNomePersonale = new Combo(GestioneVendite, SWT.NONE);
comboNomePersonale.setBounds(10, 10, 131, 20);
comboNomePersonale.setItems(personale.getStringPersonale());
comboNomePersonale.setText("Nome Personale");

Combo comboTipoCialda = new Combo(GestioneVendite, SWT.NONE);
comboTipoCialda.setBounds(10, 59, 131, 27);
comboTipoCialda.setItems(tipiDiCialde);
comboTipoCialda.setText("Tipo Cialda");

txtNomeVisitatore = new Text(GestioneVendite, SWT.BORDER);
txtNomeVisitatore.setText("Nome Visitatore");
txtNomeVisitatore.setBounds(184, 10, 101, 27);

txtQuantitcialde = new Text(GestioneVendite, SWT.BORDER);
txtQuantitcialde.setText("Quantità(cialde)");
txtQuantitcialde.setBounds(184, 59, 101, 27);

Button RadioContanti = new Button(GestioneVendite, SWT.RADIO);
RadioContanti.setBounds(60, 103, 81, 20);
RadioContanti.setSelection(true);
RadioContanti.setText("Contanti");

Button RadioCredito = new Button(GestioneVendite, SWT.RADIO);
RadioCredito.setBounds(184, 103, 93, 20);
RadioCredito.setText("A credito");

Label LabelVenditaCialde = new Label(GestioneVendite, SWT.NONE);
LabelVenditaCialde.setBounds(26, 129, 240, 34);

Label lblNewLabel = new Label(GestioneVendite, SWT.NONE);
lblNewLabel.setBounds(155, 20, 20, 17);
lblNewLabel.setText("O");

Button ButtonRegistraVendita = new Button(GestioneVendite, SWT.NONE);
ButtonRegistraVendita.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
if(comboNomePersonale.getText().equals("Nome Personale")) {
if(txtNomeVisitatore.getText().isEmpty() || txtNomeVisitatore.getText().equals("Nome Visitatore")) return;
if(txtQuantitcialde.getText().isEmpty() || txtQuantitcialde.getText().equals("Quantità(cialde)")) return;


}
if(txtQuantitcialde.getText().isEmpty() || txtQuantitcialde.getText().equals("Quantità(cialde)")) return;

Integer numeroCialde = strConvertInt(txtQuantitcialde.getText());
if(numeroCialde.equals(-1)) {
LabelVenditaCialde.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
LabelVenditaCialde.setText("importo non valido");
return;
}
Euro pagamento = new Euro(0, numeroCialde * 50);
cassa.aggiungiSaldo(pagamento);

switch(comboTipoCialda.getText()) {
	case "caffè":
	magazzino.EliminaCialdeCaffe(numeroCialde);
	break;
	case "caffè arabica":
	magazzino.EliminaCialdeCaffeArabica(numeroCialde);
	break;
	case "thè":
	magazzino.EliminaCialdeThe(numeroCialde);
	break;
	case "thè al limone":
	magazzino.EliminaCialdeTheLimone(numeroCialde);
	break;
	case "cioccolata" :
	magazzino.EliminaCialdeCioccolata(numeroCialde);
	break;
	case "camomilla":
	magazzino.EliminaCialdeCamomilla(numeroCialde);
	break;
	default: System.out.println("default");
}

LabelVenditaCialde.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
LabelVenditaCialde.setText("importo non valido");




if(RadioCredito.getSelection())
LabelVenditaCialde.setText(RadioCredito.getText() + " prova credito");
else if(RadioContanti.getSelection())
LabelVenditaCialde.setText(RadioContanti.getText() + " prova contanti");
else
LabelVenditaCialde.setText(" non dovrebbe farlo");

}
});
ButtonRegistraVendita.setBounds(26, 169, 114, 18);
ButtonRegistraVendita.setText("Registra Vendita");

Button ButtonCancellaVendita = new Button(GestioneVendite, SWT.NONE);
ButtonCancellaVendita.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
}
});
ButtonCancellaVendita.setBounds(191, 169, 75, 18);
ButtonCancellaVendita.setText("Cancella");


////////////////////////////////////////////fine vendita cialde//////////////////////////////////////////////////////////////////////////////////////

          
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
