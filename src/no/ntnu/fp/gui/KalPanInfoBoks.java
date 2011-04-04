package no.ntnu.fp.gui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;



public class KalPanInfoBoks extends JPanel implements ActionListener{
	
	private JLabel avtaleNavn, avtaleBeskrivelse;
	private JButton endre, slett;
	private Avtale a;
	private kal kal;
	
	public KalPanInfoBoks(kal kal){
		super();
		this.kal=kal;
		
		avtaleNavn=new JLabel(" ");
		add(avtaleNavn);
		
		avtaleBeskrivelse=new JLabel(" ");
		add(avtaleBeskrivelse);
		
		endre=new JButton("Endre");
		endre.addActionListener(this);
		endre.hide();
		add(endre);
		
		slett=new JButton("Avlys");
		slett.addActionListener(this);
		slett.hide();
		add(slett);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Frame");
        
        frame.getContentPane().add(new KalPanInfoBoks(null));
        frame.pack();
        frame.setVisible(true);  
	}
	
	public void displayAvtale(Avtale a) {
		this.a=a;
		avtaleNavn.setText(a.getNavn()+":  ");
		avtaleBeskrivelse.setText(a.getBeskrivelse());
		endre.show();
		slett.show();
	}
	
	public void clear() {
		avtaleNavn.setText(" ");
		avtaleBeskrivelse.setText(" ");
		slett.hide();
		endre.hide();
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == endre){
			if (a instanceof Mote) {
				endreMoete endreMoete = new endreMoete();
				endreMoete.show();
			}
			else {
				endreAvtale endreAvtale = new endreAvtale(new Avtale());
				endreAvtale.show();
			}
		}
		
		else if (evt.getSource() == slett){
			
		}
	}

}
