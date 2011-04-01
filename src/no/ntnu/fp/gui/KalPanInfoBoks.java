package no.ntnu.fp.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import no.ntnu.fp.model.Avtale;


public class KalPanInfoBoks extends JPanel {
	
	private JLabel avtaleNavn, avtaleBeskrivelse;
	
	
	public KalPanInfoBoks(){
		super();
		
		avtaleNavn=new JLabel(" ");
		add(avtaleNavn);
		
		avtaleBeskrivelse=new JLabel(" ");
		add(avtaleBeskrivelse);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Frame");
        
        frame.getContentPane().add(new KalPanInfoBoks());
        frame.pack();
        frame.setVisible(true);  
	}
	
	public void displayAvtale(Avtale a) {
		avtaleNavn.setText(a.getNavn()+":  ");
		avtaleBeskrivelse.setText(a.getBeskrivelse());
	}
	
	public void clear() {
		avtaleNavn.setText(" ");
		avtaleBeskrivelse.setText(" ");
	}

}
