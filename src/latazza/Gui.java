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

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlLatazza = new Shell();
		shlLatazza.setSize(512, 330);
		shlLatazza.setText(" LaTazza");
		
		Button btnNewButton = new Button(shlLatazza, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("ciao");
			}
		});
		btnNewButton.setBounds(211, 45, 79, 22);
		btnNewButton.setText("Calculate");
		
		Combo combo = new Combo(shlLatazza, SWT.NONE);
		combo.setBounds(33, 33, 153, 34);
		String[] items = {"caffè","caffè arabica","thè","thè al limone","cioccolata","camomilla"};
		//TODO: modificare items, con nomi delle variabili.
		combo.setItems(items);
		combo.setText("tipo cialda");

		shlLatazza.open();
		shlLatazza.layout();
		while (!shlLatazza.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
