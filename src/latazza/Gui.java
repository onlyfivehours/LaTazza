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
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Group;


public class Gui {
	private static Text txtQuantitascatole;
	private static Magazzino magazzino;
	private static Cassa cassa;
	private static Text txtNomeDipendente;
	private static Personale personale;
	private static Text txtNomeVisitatore;
	private static Text txtQuantitcialde;
	private static Text txtImportoPagamentoDebito;
	
	public static double strConvertDouble(String str) {
		
		try
	    {
	      return Double.parseDouble(str.trim());
	    }
	    catch (NumberFormatException nfe)
	    {
	    	return -1;
	    }
	}
	

	
	public static void main(String[] args) {
		cassa = new Cassa(50);
		magazzino = new Magazzino();
		personale = new Personale();
	
		Display display = new Display();
		
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
		
		TabItem tabGestioneGenerale = new TabItem(tabFolder, SWT.NONE | SWT.CLOSE);
        tabGestioneGenerale.setText("Gestione Generale");
       
        TabItem tabGestionePersonale = new TabItem(tabFolder, SWT.NONE);
        tabGestionePersonale.setText("Gestione Personale");
	
        
        
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
	  	   lblInformazioniMagazzino.setText(magazzino.getInformazioniMagazzino());
			
	  	   Label lblInformazioniCassa = new Label(tabFolderDati,SWT.NONE);
	  	   tabItemCassa.setControl(lblInformazioniCassa);
	  	   lblInformazioniCassa.setText(cassa.getStringSaldo());
			
	  	   Label lblInformazioniDebiti = new Label(tabFolderDati,SWT.NONE);
	  	   tabItemDebiti.setControl(lblInformazioniDebiti);
	  	   lblInformazioniDebiti.setText(personale.getStringPersonaleConDebiti());
			
	  	   

//////////////////////////////////////////////////////FINE DATI GENERALI////////////////////////////////////////////////////////////////////////////////
		
	
	  	   
	  	   
	  	   
	  	   
	  	   
///////////////////////////////////////////////////////GESTIONE DEBITI//////////////////////////////////////////////////////////////////////////////////
	  	   
	  	   
	  	   
	  	   	Combo combo_SelezionaDebito = new Combo(GestioneDebiti, SWT.NONE);
			combo_SelezionaDebito.setBounds(89, 10, 149, 34);
			combo_SelezionaDebito.setItems(personale.getArrayStringPersonaleConDebiti()); //IMPORTANTE PER DIAGRAMMA
			combo_SelezionaDebito.setText("Seleziona Dipendente");
			
			txtImportoPagamentoDebito = new Text(GestioneDebiti, SWT.BORDER);
			txtImportoPagamentoDebito.setBounds(103, 66, 119, 22);
			txtImportoPagamentoDebito.setText("Importo");
			
			Button RegistraPagamento = new Button(GestioneDebiti, SWT.NONE);
			RegistraPagamento.setBounds(21, 113, 128, 22);
			RegistraPagamento.setText("Registra Pagamento");
			
			Button CancellaPagamento = new Button(GestioneDebiti, SWT.NONE);
			CancellaPagamento.setBounds(192, 113, 79, 22);
			CancellaPagamento.setText("Cancella");
			
			Label lblMessaggioDebito = new Label(GestioneDebiti, SWT.NONE);
			lblMessaggioDebito.setBounds(10, 162, 296, 60);
	  	   
	  	   
			CancellaPagamento.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					combo_SelezionaDebito.setText("Seleziona Dipendente");
					txtImportoPagamentoDebito.setText("");
					lblMessaggioDebito.setText("");
				}
			});
	  	   
			RegistraPagamento.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					if(combo_SelezionaDebito.getText().equals("Seleziona Dipendente") 
							|| txtImportoPagamentoDebito.getText().equals("Importo") || txtImportoPagamentoDebito.getText().equals("")) {
						lblMessaggioDebito.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
						lblMessaggioDebito.setText("Riempire tutti i campi prima di procedere");
						return;
					}
					
					int input = (int)(strConvertDouble(txtImportoPagamentoDebito.getText())*100);
					if(input <= 0) {
						lblMessaggioDebito.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
						lblMessaggioDebito.setText("inserire un importo numerico > 0 \n(usare il punto per i decimali)");
						return;
					}
					else {
						Euro debitoSaldato = new Euro(0,input);
						String[] NomeCognome = combo_SelezionaDebito.getText().split(" ");
						if(!personale.DecrementaDebitoDipendente(NomeCognome[0], NomeCognome[1],debitoSaldato)) {
							lblMessaggioDebito.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
							lblMessaggioDebito.setText("il debito di "+combo_SelezionaDebito.getText()+
									" è inferiore all'importo indicato");
						  	tabFolderDati.setSelection(2);
						}
						else {
							cassa.aggiungiSaldo(debitoSaldato);
							lblMessaggioDebito.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
							lblMessaggioDebito.setText("Pagamento registrato di "+combo_SelezionaDebito.getText()+ 
									"\nper "+txtImportoPagamentoDebito.getText()+"€ "+" debito residuo: "+
									(double)personale.getDebitoDipendente(NomeCognome[0], NomeCognome[1])/100+"€");
						  	tabFolderDati.setSelection(2);
						  	lblInformazioniDebiti.setText(personale.getStringPersonaleConDebiti());
						  	lblInformazioniCassa.setText(cassa.getStringSaldo());
						  	
						  	if( personale.getDebitoDipendente(NomeCognome[0],NomeCognome[1]) == 0) {
						  		combo_SelezionaDebito.setItems(personale.getArrayStringPersonaleConDebiti()); //aggiorna il combo
								combo_SelezionaDebito.setText("Seleziona Dipendente");
						  	}
						}
					}
					
					
				}
			});
	  	   
		
///////////////////////////////////////////////////////FINE GESTIONE DEBITI/////////////////////////////////////////////////////////////////////////////		
		
		
		
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
				txtQuantitascatole.setText("");
				lblMessaggioErroreMagazzino.setText("");
			}
		});
		
		btnAggiungiCialde.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo_SelezionaCialde.getText().equals("tipo cialda") 
						|| txtQuantitascatole.getText().equals("quantita (scatole)")|| txtQuantitascatole.getText().equals("")) {
					lblMessaggioErroreMagazzino.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					lblMessaggioErroreMagazzino.setText("Riempire tutti i campi prima di procedere");
					return;
				}
					
				int input = (int)strConvertDouble(txtQuantitascatole.getText());
				if(input <= 0) {
					lblMessaggioErroreMagazzino.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					lblMessaggioErroreMagazzino.setText("inserire una quantita numerica >= 1");
				}
				else if(!cassa.prelevaDenaro(new Euro(20 * input))) { 
					lblMessaggioErroreMagazzino.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					lblMessaggioErroreMagazzino.setText("Il rifornimento non può essere effettuato:"
							+ " \ncosto di "+input+" scatole di "+combo_SelezionaCialde.getText()+": "+(2000*input)/100+" euro\n"
									+cassa.getStringSaldo());
				  	tabFolderDati.setSelection(1);
				  	lblInformazioniCassa.setText(cassa.getStringSaldo());

				}
				else {
					magazzino.AggiungiCialda(combo_SelezionaCialde.getText(), input); 
					lblMessaggioErroreMagazzino.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					lblMessaggioErroreMagazzino.setText("Rifornimento registrato per \n"+ input+
							" scatole di "+combo_SelezionaCialde.getText()+" per un totale di "+input*20+"€");
				  	tabFolderDati.setSelection(0);
				  	lblInformazioniMagazzino.setText(magazzino.getInformazioniMagazzino());
				  	lblInformazioniCassa.setText(cassa.getStringSaldo());
				}
			}
		});
		
		
//////////////////////////////////////////////////////FINE GESTIONE MAGAZZINO ///////////////////////////////////////////////////////////////
		
        
//////////////////////////////////////////////////////Registra Vendite Cialde///////////////////////////////////////////////////////////////////////

		Combo comboNomePersonale = new Combo(GestioneVendite, SWT.NONE);
		comboNomePersonale.setBounds(10, 10, 131, 20);
		comboNomePersonale.setItems(personale.getStringPersonale());
		comboNomePersonale.setText("Nome Dipendente");
		
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
		
		Label labelVenditaCialde = new Label(GestioneVendite, SWT.NONE);
		labelVenditaCialde.setBounds(10, 153, 275, 79);
		
		Label lblNewLabel = new Label(GestioneVendite, SWT.NONE);
		lblNewLabel.setBounds(155, 20, 20, 17);
		lblNewLabel.setText("O");
		
		Button ButtonRegistraVendita = new Button(GestioneVendite, SWT.NONE);
		ButtonRegistraVendita.setBounds(23, 129, 114, 18);
		ButtonRegistraVendita.setText("Registra Vendita");
		Button ButtonCancellaVendita = new Button(GestioneVendite, SWT.NONE);
		ButtonCancellaVendita.setText("Cancella");
		ButtonCancellaVendita.setBounds(184, 129, 75, 18);

		
		ButtonRegistraVendita.addSelectionListener(new SelectionAdapter() {
				
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(comboNomePersonale.getText().equals("Nome Dipendente") &&
						(txtNomeVisitatore.getText().equals("") || txtNomeVisitatore.getText().equals("Nome Visitatore"))){
					labelVenditaCialde.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelVenditaCialde.setText("selezionare al più un compratore");
					return;
				}
				if(comboTipoCialda.getText().equals("Tipo Cialda")) {
					labelVenditaCialde.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelVenditaCialde.setText("Selezionare un tipo di cialda");
					return;
				}
					
				int input = (int) strConvertDouble(txtQuantitcialde.getText());
				if(input <= 0) {
					labelVenditaCialde.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelVenditaCialde.setText("inserire una quantita numerica >= 1");
					return;
				}
				
				if(!(txtNomeVisitatore.getText().equals("") || txtNomeVisitatore.getText().equals("Nome Visitatore")) 
						&& !comboNomePersonale.getText().equals("Nome Dipendente")) {
					labelVenditaCialde.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelVenditaCialde.setText("Selezionare soltanto uno tra\n\"dipendente\" e \"visitatore\"");
					return;
				}
				
				int numeroCialde = magazzino.getQuantitaCialda(comboTipoCialda.getText());
				if(numeroCialde < input) {
					labelVenditaCialde.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelVenditaCialde.setText("Non sono disponibili "+input+" cialde (max "+numeroCialde+")");
					tabFolderDati.setSelection(0);
				  	lblInformazioniMagazzino.setText(magazzino.getInformazioniMagazzino());
				  	return;
				}
				else {
					if(RadioCredito.getSelection()) {
						if(!(txtNomeVisitatore.getText().equals("") || txtNomeVisitatore.getText().equals("Nome Visitatore"))) {
							labelVenditaCialde.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
							labelVenditaCialde.setText("Non è possibile vendere a credito ai visitatori");
							return;
						}	
						magazzino.EliminaCialda(comboTipoCialda.getText(), input);
						String[] NomeCognome = comboNomePersonale.getText().split(" ");
						personale.IncrementaDebitoDipendente(NomeCognome[0], NomeCognome[1], new Euro(0,(int)((0.5*input)*100)));
					  	lblInformazioniMagazzino.setText(magazzino.getInformazioniMagazzino());
					  	lblInformazioniDebiti.setText(personale.getStringPersonaleConDebiti());
				  		combo_SelezionaDebito.setItems(personale.getArrayStringPersonaleConDebiti()); //aggiorna il combo
						combo_SelezionaDebito.setText("Seleziona Dipendente");
					  	tabFolderDati.setSelection(2);
				  		labelVenditaCialde.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
				  		labelVenditaCialde.setText("Vendita registrata per "+input+" cialde di\n"+
								comboTipoCialda.getText()+" a "+comboNomePersonale.getText()+"\n"+
										"con pagamento a credito di "+(double)(0.5*input)+"€");
					}
					else {
						String NomeCognome = comboNomePersonale.getText().equals("Nome Dipendente") ? 
								txtNomeVisitatore.getText() : comboNomePersonale.getText();
						magazzino.EliminaCialda(comboTipoCialda.getText(), input);
						cassa.aggiungiSaldo(new Euro(0,(int)((0.5*input)*100)));
						lblInformazioniCassa.setText(cassa.getStringSaldo());
						lblInformazioniMagazzino.setText(magazzino.getInformazioniMagazzino());
					  	labelVenditaCialde.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
						labelVenditaCialde.setText("Vendita registrata per "+input+" cialde di\n"+
								comboTipoCialda.getText()+"a "+NomeCognome+"\n"+
									"con pagamento in contanti di "+0.5*input+"€");
					}	
				}	
			}		
		});
		
		ButtonCancellaVendita.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtQuantitcialde.setText("");
				txtNomeVisitatore.setText("");
				comboNomePersonale.setText("Nome Dipendente");
				comboTipoCialda.setText("Tipo Cialda");
				labelVenditaCialde.setText("");
				if(RadioCredito.getSelection()) {
					RadioContanti.setSelection(true);
					RadioCredito.setSelection(false);
				}
			}
		});
		
	
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
        
        
        
		btnButtonAggiungiPersonale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String NomeCognome = txtNomeDipendente.getText();
				if(NomeCognome.isEmpty() || NomeCognome.equals("Nome Cognome")) return;
				if(!NomeCognome.contains(" ")) {
					lblLabelAggiungiPersonale.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					lblLabelAggiungiPersonale.setText("inserire sia il nome che il cognome");
					return;
				}
					
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
				comboNomePersonale.setItems(personale.getStringPersonale());
				comboNomePersonale.setText("Nome Dipendente");

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
				comboNomePersonale.setItems(personale.getStringPersonale());
				comboNomePersonale.setText("Nome Dipendente");
				combo_SelezionaDebito.setItems(personale.getArrayStringPersonaleConDebiti()); //aggiorna il combo
				combo_SelezionaDebito.setText("Seleziona Dipendente");
				lblInformazioniDebiti.setText(personale.getStringPersonaleConDebiti());
			}
		});
		
		

////////////////////////////////////////////////// FINE GESTIONE PERSONALE //////////////////////////////////////////////////////////////////////////

		
		
		
		
	
		shlLatazza.open();
		shlLatazza.layout();
		while (!shlLatazza.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}