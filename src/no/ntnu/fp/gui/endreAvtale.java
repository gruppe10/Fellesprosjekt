package no.ntnu.fp.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Rom;
import no.ntnu.fp.model.record.ActiveRom;

import Klient.Action;
import Klient.Envelope;
import Klient.KlientOS;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class endreAvtale extends javax.swing.JFrame implements ActionListener{
	private JPanel jPanel1;
	private JTextField headerTextField;
	private JLabel romLabel3;
	private JComboBox romComboBox3;
	private JLabel overlappingMessage;
	private JLabel inValidDateMessage;
	private JComboBox sluttid;
	private JComboBox starttid;
	private JButton slettButton;
	private JPanel jPanel2;
	private JButton avbrytButton;
	private JLabel nyAvtaleLabel;
	private JLabel datoLabel;
	private JLabel headerLabel;
	private JLabel starttidLabel;
	private JLabel sluttidLabel;
	private JLabel beskrivelseLabel;
	private JButton lagreButton;
	private JTextArea beskrivelse;
	private JTextField datoField;
	private Rom noRom;
	private ArrayList<Rom> romList;
	private DefaultComboBoxModel romModel;
	

	private int defaultStartTime, defaultDato, defaultMonth, defaultYear;
	private int timeIndexDiff=6;
	private kal mainKal;
	private Avtale avtale;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				endreAvtale inst = new endreAvtale(null,null);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	public endreAvtale(kal kal, Avtale a) {
		super();
		
		
		
		mainKal=kal;
		
		if (a instanceof KalPanAvtaleFiller) {
			avtale=((KalPanAvtaleFiller) a).getAvtale();
		}
		else {
		avtale=a;
		}
		
		
		defaultDato = avtale.getDatoDag();
		defaultMonth = avtale.getDatoMnd();
		defaultYear = avtale.getDatoAar();
		
		KlientOS klient = KlientOS.getInstance();
		Envelope e = new Envelope(Action.SELECT, "getallrooms");
		romList=(ArrayList<Rom>)klient.sendObjectAndGetResponse(e);
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setSize(388, 355);
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(392, 301));
				{
					jPanel2 = new JPanel();
					GroupLayout jPanel2Layout = new GroupLayout((JComponent)jPanel2);
					jPanel2.setLayout(jPanel2Layout);
					{
						nyAvtaleLabel = new JLabel();
						nyAvtaleLabel.setText("Endre avtale");
						nyAvtaleLabel.setFont(new java.awt.Font("Tahoma",1,16));
					}
					{
						inValidDateMessage = new JLabel();
						inValidDateMessage.setText("");
						inValidDateMessage.setFont(new java.awt.Font("Tahoma",2,12));
					}
					{
						overlappingMessage = new JLabel();
						overlappingMessage.setText("");
						overlappingMessage.setFont(new java.awt.Font("Tahoma",2,12));
					}
					{
						

						noRom = new Rom("None");
						
						romModel = new DefaultComboBoxModel();
						fyllRomListe(false);
						
						romComboBox3 = new JComboBox();
						romComboBox3.setModel(romModel);
						romComboBox3.getSelectedItem();
					}
					{
						romLabel3 = new JLabel();
						romLabel3.setText("Rom:");
						romLabel3.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						datoLabel = new JLabel();
						datoLabel.setText("Dato:");
						datoLabel.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						datoField = new JTextField();
						if (defaultDato<10 && defaultMonth<10) {
							datoField.setText("0"+defaultDato+".0"+defaultMonth+"."+defaultYear);
							}
						else if (defaultDato<10) {
							datoField.setText("0"+defaultDato+"."+defaultMonth+"."+defaultYear);
							}
						else if (defaultMonth<10) {
						datoField.setText(defaultDato+".0"+defaultMonth+"."+defaultYear);
						}
						else {
							datoField.setText(defaultDato+"."+defaultMonth+"."+defaultYear);	
						}
						datoField.setFont(new java.awt.Font("Tahoma",2,11));
						datoField.addActionListener(this);
					}
					{
						headerTextField = new JTextField();
						headerTextField.setText(avtale.getNavn());
						headerTextField.getText();
					}
					{
						headerLabel = new JLabel();
						headerLabel.setText("Tittel:");
						headerLabel.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						starttidLabel = new JLabel();
						starttidLabel.setText("Starttid:");
						starttidLabel.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						sluttidLabel = new JLabel();
						sluttidLabel.setText("Sluttid:");
						sluttidLabel.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						beskrivelseLabel = new JLabel();
						beskrivelseLabel.setText("Beskrivelse:");
						beskrivelseLabel.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						beskrivelse = new JTextArea();
						beskrivelse.setText(avtale.getBeskrivelse());
						beskrivelse.setFont(new java.awt.Font("Tahoma",2,11));
						beskrivelse.getText();
					}
					{
						avbrytButton = new JButton();
						avbrytButton.setText("Avbryt");
						avbrytButton.setFont(new java.awt.Font("Tahoma",0,12));
						avbrytButton.addActionListener(this);
					}
					{
						lagreButton = new JButton();
						lagreButton.setText("Lagre");
						lagreButton.setFont(new java.awt.Font("Tahoma",0,12));
						lagreButton.addActionListener(this);
					}
					{
						ComboBoxModel jComboBox1Model = 
							new DefaultComboBoxModel(
									new String[] { "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00" });
						starttid = new JComboBox();
						starttid.setModel(jComboBox1Model);
						starttid.getSelectedItem();
						starttid.setSelectedIndex(avtale.getStarttid()-timeIndexDiff);
						starttid.addActionListener(this);
					}
					{
						ComboBoxModel jComboBox2Model = 
							new DefaultComboBoxModel(
									new String[] { "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" });
						sluttid = new JComboBox();
						sluttid.setModel(jComboBox2Model);
						sluttid.getSelectedItem();
						sluttid.setSelectedIndex(avtale.getSluttid()-timeIndexDiff-1);
						sluttid.addActionListener(this);
					}
					{
						slettButton = new JButton();
						slettButton.setText("Slett");
						slettButton.setFont(new java.awt.Font("Tahoma",0,12));
						slettButton.addActionListener(this);
					}
					jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup()
						.addGroup(jPanel2Layout.createSequentialGroup()
						    .addGroup(jPanel2Layout.createParallelGroup()
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(lagreButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						            .addGroup(jPanel2Layout.createParallelGroup()
						                .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						                    .addGroup(jPanel2Layout.createParallelGroup()
						                        .addComponent(starttid, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						                        .addComponent(sluttid, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						                    .addGap(7)
						                    .addComponent(overlappingMessage, 0, 174, Short.MAX_VALUE))
						                .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						                    .addComponent(beskrivelse, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						                    .addComponent(slettButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						                    .addGap(0, 63, Short.MAX_VALUE))
						                .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						                    .addGroup(jPanel2Layout.createParallelGroup()
						                        .addComponent(datoField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						                        .addComponent(headerTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						                        .addComponent(romComboBox3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						                    .addComponent(inValidDateMessage, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						                    .addGap(0, 0, Short.MAX_VALUE))))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(nyAvtaleLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						            .addGap(0, 208, Short.MAX_VALUE)))
						    .addContainerGap())
						.addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						    .addPreferredGap(lagreButton, starttidLabel, LayoutStyle.ComponentPlacement.INDENT)
						    .addGroup(jPanel2Layout.createParallelGroup()
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(starttidLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						            .addGap(8))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(headerLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						            .addGap(8))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(datoLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						            .addGap(17))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(romLabel3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						            .addGap(31))
						        .addComponent(beskrivelseLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						        .addComponent(sluttidLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						    .addGap(17)
						    .addComponent(avbrytButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						    .addContainerGap(152, Short.MAX_VALUE)));
					jPanel2Layout.setVerticalGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(nyAvtaleLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(19)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(datoField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(datoLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(inValidDateMessage, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(headerTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(headerLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						        .addComponent(starttid, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addComponent(starttidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						        .addGap(14)
						        .addComponent(overlappingMessage, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(sluttid, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(sluttidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(romComboBox3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(romLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup()
						    .addGroup(jPanel2Layout.createSequentialGroup()
						        .addComponent(beskrivelse, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 0, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						        .addGap(0, 29, Short.MAX_VALUE)
						        .addComponent(beskrivelseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(avbrytButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(slettButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lagreButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(20, 20));
				}
					jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap(47, 47)
					.addComponent(jPanel2, 0, 333, Short.MAX_VALUE)
					.addContainerGap());
					jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel2, 0, 280, Short.MAX_VALUE));
			}
			pack();
			this.setSize(400, 330);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == lagreButton){
			
			if (!isValidDate(datoField.getText())) {
				inValidDateMessage.setText("invalid date");
				overlappingMessage.setText("");
			}
			else if (overlapping()){
				inValidDateMessage.setText("");
				overlappingMessage.setText("overlappende avtale");
			}
			else {
				changeAvtale();
				dispose();
			}

		}
		else if(evt.getSource() == avbrytButton){
			dispose();
		}
		else if(evt.getSource() == slettButton){
			slett slett = new slett(mainKal, avtale);
			slett.show();
		}
		else if(evt.getSource() == starttid || evt.getSource() == sluttid || evt.getSource() == datoField){
			fyllRomListe(true);
		}
	}

	
	public boolean isValidDate(String inDate) {

	    if (inDate == null)
	      return false;

	    //set the format to use as a constructor argument
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	    
	    
	    if (inDate.trim().length() != dateFormat.toPattern().length())
	      return false;

	    dateFormat.setLenient(false);
	    
	    try {
	      //parse the inDate parameter
	      dateFormat.parse(inDate.trim());
	      
	    }
	    catch (ParseException pe) {
	      return false;
	    }
	    
	    return true;
	  }
	
private boolean overlapping() {
		
		String[] a = datoField.getText().split("\\.");
		
		int inDato = Integer.valueOf(a[0]);
		int inMnd = Integer.valueOf(a[1]);
		int inAar = Integer.valueOf(a[2]);
		
		int startTime = starttid.getSelectedIndex()+timeIndexDiff;
		int sluttTime = sluttid.getSelectedIndex()+timeIndexDiff+1;
		
		
		Person person= mainKal.getConnectedPerson();
		ArrayList<Avtale> avtaler = person.getAvtaler();
		
		for (int i = 0; i<avtaler.size(); i++) {
		 
			
			if (avtale==avtaler.get(i)) {}
			else {
				Avtale current = avtaler.get(i);
				
				if (current.getDatoAar()==inAar) {
					if (current.getDatoMnd()==inMnd) {
						if (current.getDatoDag()==inDato) {
							
							if ((startTime>=current.getStarttid() && startTime <= current.getSluttid()-1) || (sluttTime>=current.getStarttid()+1 && sluttTime <= current.getSluttid()) || (sluttTime>=current.getSluttid() && startTime <= current.getStarttid()))  {
								return true;
							}
						}
					}
				}
			}
			
		}
		return false;
	}

	private void changeAvtale() {
		
		mainKal.getKalenderPanelModel().removeAvtaleFromPanel(avtale);
		
		String[] a = datoField.getText().split("\\.");
		
		int inDato = Integer.valueOf(a[0]);
		int inMnd = Integer.valueOf(a[1]);
		int inAar = Integer.valueOf(a[2]);
		
		int startTime = starttid.getSelectedIndex()+timeIndexDiff;
		int sluttTime = sluttid.getSelectedIndex()+timeIndexDiff+1;
		
		Person person= mainKal.getConnectedPerson();
		ArrayList<Avtale> avtaler = person.getAvtaler();
		
		avtale.update(startTime, sluttTime, inDato, inMnd, inAar, headerTextField.getText(), beskrivelse.getText(), 
				romComboBox3.getSelectedItem()==noRom? null: (Rom)romComboBox3.getSelectedItem());
		
		mainKal.getKalenderPanelModel().addAvtaleToPanel(avtale);
		mainKal.getKalenderPanel().getInfoBoks().displayAvtale(avtale); 
		
	}
	
	private boolean erLedig(Rom rom, boolean datoSatt){
		int romID = rom.getRomId();
		
		int startTime = starttid.getSelectedIndex()+timeIndexDiff;
		int sluttTime = sluttid.getSelectedIndex()+timeIndexDiff+1;
		String month, day;
		
		if(defaultDato < 10 && defaultMonth < 10){
			month = "0"+defaultMonth;
			day = "0"+defaultDato;
		}else if(defaultDato<10){
			month = Integer.toString(defaultMonth);
			day = "0"+defaultDato;
		}else if(defaultMonth<10){
			month = "0"+defaultMonth;
			day = Integer.toString(defaultDato);
		}else{
			month = Integer.toString(defaultMonth);
			day = Integer.toString(defaultDato);
		}
	
		
		String date = defaultYear+"-"+month+"-"+day;
		
		if(datoSatt){
			String[] a = datoField.getText().split("\\.");
			date = a[2]+"-"+a[1]+"-"+a[0];
		}
		
		java.sql.Date dato = java.sql.Date.valueOf(date);
		
		boolean[] ledigeTider = ActiveRom.selectLedigeTider(romID, dato);
		boolean erLedig = true;
		
		for(int i=startTime; i<sluttTime; i++){
			if (ledigeTider[i] != true) erLedig = false;
		}
		
		return erLedig;
	}
	
	
	
	private void fyllRomListe(boolean datoSatt){
		romModel.removeAllElements();
		romModel.addElement(noRom);
		for(Rom rom: romList){
			if(erLedig(rom, datoSatt)) romModel.addElement(rom);
		}
	}
	

}
