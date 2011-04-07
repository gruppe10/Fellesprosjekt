package no.ntnu.fp.gui;

import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Notis;
import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Status;



public class KalPanInfoBoks extends JPanel implements ActionListener{
	
	private JLabel avtaleNavn, avtaleBeskrivelse, avtaleRom;
	private JButton endre, slett, avbud;
	private Avtale a;
	private kal kal;
	private JList deltakerList, statusList;
	private  JScrollPane deltakerPane, statusPane;
	private DefaultListModel deltakerListModel, statusListModel;
	public KalPanInfoBoks(kal kal){
		super();
		this.kal=kal;
		
		avtaleNavn=new JLabel(" ");
		add(avtaleNavn);
		
		avtaleBeskrivelse=new JLabel(" ");
		add(avtaleBeskrivelse);
		
		avtaleRom=new JLabel(" ");
		add(avtaleRom);
		
		
		endre=new JButton("Endre");
		endre.addActionListener(this);
		endre.hide();
		add(endre);
		
		avbud=new JButton("Meld avbud");
		avbud.addActionListener(this);
		avbud.hide();
		add(avbud);
		 
		slett=new JButton("Avlys");
		slett.addActionListener(this);
		slett.hide();
		add(slett);
		
		deltakerPane = new JScrollPane();
		deltakerListModel = new DefaultListModel();
		deltakerList = new JList();
		deltakerPane.setViewportView(deltakerList);
		deltakerList.setModel(deltakerListModel);
		//deltakerList.setEnabled(false);
		deltakerPane.setVisible(false);
		add(deltakerPane);
		
		statusPane = new JScrollPane();
		statusListModel = new DefaultListModel();
		statusList = new JList();
		statusPane.setViewportView(statusList);
		statusList.setModel(statusListModel);
		//statusList.setEnabled(false);
		statusPane.setVisible(false);
		add(statusPane);
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Frame");
        
        frame.getContentPane().add(new KalPanInfoBoks(null));
        frame.pack();
        frame.setVisible(true);  
	}
	
	public void displayAvtale(Avtale a) {
		
		this.clear();
		
		if (a instanceof KalPanMoteFiller) {
			this.a=((KalPanMoteFiller)a).getAvtale();
		}
		else if (a instanceof KalPanAvtaleFiller) {	
			this.a=((KalPanAvtaleFiller)a).getAvtale();
		}
		
		this.a=a;
		
		if (a.getMoterom()!=null) {
			avtaleRom.setText("| Rom: "+a.getMoterom().toString());
		}
		avtaleNavn.setText(a.getNavn()+":  ");
		avtaleBeskrivelse.setText(a.getBeskrivelse());
		endre.setVisible(true);
		slett.setVisible(true);
		statusPane.setVisible(false);
		deltakerPane.setVisible(false);
		
		
		if (a instanceof Mote) {

			Map<Person, Status> deltakereMedStatus = ((Mote)a).getDeltakere();
			
			Iterator it	= deltakereMedStatus.entrySet().iterator();
			deltakerListModel.clear();
			statusListModel.clear();
			
			while (it.hasNext()) {
				statusPane.setVisible(true);
				deltakerPane.setVisible(true);
				
				Map.Entry pairs = (Map.Entry)it.next();
				Person key =(Person) pairs.getKey();  
			    Status value = deltakereMedStatus.get(key); 
			    
			    deltakerListModel.addElement(key);
			    statusListModel.addElement(value);
			}  
			
			
			if (kal.getConnectedPerson()==a.getInitiativtaker()) {
				avbud.setVisible(false);
				slett.setVisible(true);
				}
			else {
				avbud.setVisible(true);
				slett.setVisible(false);
			}
		}
	}
	
	public void clear() {
		avtaleNavn.setText(" ");
		avtaleBeskrivelse.setText(" ");
		avtaleRom.setText(" ");
		slett.setVisible(false);
		endre.setVisible(false);
		avbud.setVisible(false);
		statusPane.setVisible(false);
		deltakerPane.setVisible(false);
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == endre){
			if (a instanceof Mote) {
				endreMoete endreMoete = new endreMoete(kal, (Mote)a);
				endreMoete.show();
			}
			else {
				endreAvtale endreAvtale = new endreAvtale(kal, a);
				endreAvtale.show();
			}
		}
		
		else if (evt.getSource() == slett){
			slett slett = new slett(kal, a);
			slett.show();
			
		}
	}

}
