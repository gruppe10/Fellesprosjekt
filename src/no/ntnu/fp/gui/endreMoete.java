package no.ntnu.fp.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Klient.Action;
import Klient.Envelope;
import Klient.KlientOS;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Rom;
import no.ntnu.fp.model.Status;
import no.ntnu.fp.model.record.ActiveRom;


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
public class endreMoete extends javax.swing.JFrame implements ActionListener{

	private JButton fjernDeltakerButton;
	private JButton leggTilDeltakerButton;
	private JTextField datoField;
	private JTextField headerTextField;
	private JMenuItem jMenuItem1;
	private JComboBox Moeterom;
	private JLabel jLabel1;
	private JScrollPane muligeDeltakereScroll;
	private JList muligeDeltakereList;
	private DefaultListModel deljList1Model;
	private JLabel slutttidLabel;
	private JComboBox sluttidCombo;
	private JComboBox starttidCombo;
	private JButton avlysButton;
	private JLabel leggTilDeltakerLabel;
	private JButton lagreButton;
	private JButton avbrytButton;
	private JLabel deltakereLabel;
	private JLabel jLabel2;
	private JLabel beskrivelseLabel;
	private JLabel moeteromLabel;
	private JLabel starttidLabel;
	private JLabel headerLabel;
	private JLabel datoLabel;
	private JLabel nyttMoeteLabel;
	private JList deltakereList;
	private DefaultListModel deltakereListModel;
	private JScrollPane valgteDeltakere;
	private JTextArea beskrivelseTextArea;
	private Rom noRom;
	private JLabel overlappingMessage;
	private JLabel inValidDateMessage;
	private DefaultComboBoxModel moeteromModel;
	
	private int defaultStartTime, defaultDato, defaultMonth, defaultYear;
	private int timeIndexDiff=6;
	private kal mainKal;
	private Mote mote;
	int startTime;
	int sluttTime;
	private Person bruker;
	
	private ArrayList<Person> mDeltakere;
	private ArrayList<Rom> romList;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				endreMoete inst = new endreMoete(null, null);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public endreMoete(kal kal, Mote m) {
		super();
		
		mainKal=kal;
		
		if (m instanceof KalPanMoteFiller) {
			mote=((KalPanMoteFiller)m).getAvtale();
		}
		else {
		mote=m;
		}
		
		
		defaultDato = mote.getDatoDag();
		defaultMonth = mote.getDatoMnd();
		defaultYear = mote.getDatoAar();
		startTime = mote.getStarttid()-timeIndexDiff;
		sluttTime = mote.getSluttid()-timeIndexDiff-1;
		bruker = mote.getInitiativtaker();

		KlientOS klient = KlientOS.getInstance();
		Envelope e = new Envelope(Action.SELECT, "getallpersons");
		mDeltakere=(ArrayList<Person>)klient.sendObjectAndGetResponse(e);
		KlientOS klient2 =KlientOS.getInstance();
		Envelope e2 = new Envelope(Action.SELECT, "getallrooms");
		romList = (ArrayList<Rom>)klient2.sendObjectAndGetResponse(e2);

		initGUI();
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				fjernDeltakerButton = new JButton();
				fjernDeltakerButton.setText("Fjern deltaker");
				fjernDeltakerButton.setFont(new java.awt.Font("Tahoma",0,12));
				fjernDeltakerButton.addActionListener(this);
			}
			{
				leggTilDeltakerButton = new JButton();
				leggTilDeltakerButton.setText("Legg til deltaker");
				leggTilDeltakerButton.setFont(new java.awt.Font("Tahoma",0,12));
				leggTilDeltakerButton.addActionListener(this);
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("");
				jLabel2.setFont(new java.awt.Font("Tahoma",2,12));
			}
			{
				jLabel1 = new JLabel();
				jLabel1.setText("");
				jLabel1.setFont(new java.awt.Font("Tahoma",2,12));
			}
			{

				muligeDeltakereScroll = new JScrollPane();
				{
					deljList1Model = 
						new DefaultListModel();
					muligeDeltakereList = new JList();
					for(Person p : mDeltakere){
						if(!p.getBrukerNavn().equalsIgnoreCase(bruker.getBrukerNavn())) deljList1Model.addElement(p);
					}

					muligeDeltakereScroll.setViewportView(muligeDeltakereList);
					muligeDeltakereList.setModel(deljList1Model);
					muligeDeltakereList.setFont(new java.awt.Font("Tahoma",2,11));
					
				}
				
				
			}
			{
				ComboBoxModel stjComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00" });
				starttidCombo = new JComboBox();
				starttidCombo.setModel(stjComboBox1Model);
				starttidCombo.getSelectedItem();
				starttidCombo.setSelectedIndex(mote.getStarttid()-timeIndexDiff);
				starttidCombo.addActionListener(this);
			}
			{
				ComboBoxModel sutjComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" });
				sluttidCombo = new JComboBox();
				sluttidCombo.setModel(sutjComboBox1Model);
				sluttidCombo.getSelectedItem();
				sluttidCombo.setSelectedIndex(mote.getStarttid()-timeIndexDiff-1);
				sluttidCombo.addActionListener(this);
			}
			{
				slutttidLabel = new JLabel();
				slutttidLabel.setText("Sluttid:");
				slutttidLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{


				noRom = new Rom("None");
				moeteromModel = new DefaultComboBoxModel();
				
				fyllRomListe(false);
				
				Moeterom = new JComboBox();
				Moeterom.setModel(moeteromModel);
				Moeterom.setFont(new java.awt.Font("Tahoma",2,11));
				Moeterom.setToolTipText("møterom");
				Moeterom.getSelectedItem();
				{
					jMenuItem1 = new JMenuItem();
					Moeterom.add(jMenuItem1);
					jMenuItem1.setText("jMenuItem1");
				}
			}
			{
				avlysButton = new JButton();
				avlysButton.setText("Avlys");
				avlysButton.setFont(new java.awt.Font("Tahoma",0,12));
				avlysButton.addActionListener(this);
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
				headerTextField = new JTextField();
				headerTextField.getText();
			}
			{
				beskrivelseTextArea = new JTextArea();
				beskrivelseTextArea.setText("Beskrivelse av møte");
				beskrivelseTextArea.setFont(new java.awt.Font("Tahoma",2,11));
				beskrivelseTextArea.getText();
			}
			{
//				
				
				valgteDeltakere = new JScrollPane();
				{
					deltakereListModel = 
						new DefaultListModel();
					deltakereList = new JList();
					
					
					valgteDeltakere.setViewportView(deltakereList);
					deltakereList.setModel(deltakereListModel);
					deltakereList.setFont(new java.awt.Font("Tahoma",2,11));
					
				}
			}
			{
				nyttMoeteLabel = new JLabel();
				nyttMoeteLabel.setText("Endre møte");
				nyttMoeteLabel.setFont(new java.awt.Font("Tahoma",1,16));
			}
			{
				datoLabel = new JLabel();
				datoLabel.setText("Dato:");
				datoLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				headerLabel = new JLabel();
				headerLabel.setText("Header:");
				headerLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				starttidLabel = new JLabel();
				starttidLabel.setText("Starttid:");
				starttidLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				moeteromLabel = new JLabel();
				moeteromLabel.setText("Møterom:");
				moeteromLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				beskrivelseLabel = new JLabel();
				beskrivelseLabel.setText("Beskrivelse:");
				beskrivelseLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				deltakereLabel = new JLabel();
				deltakereLabel.setText("Deltakere:");
				deltakereLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				leggTilDeltakerLabel = new JLabel();
				leggTilDeltakerLabel.setText("Legg til deltaker:");
				leggTilDeltakerLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				avbrytButton = new JButton();
				avbrytButton.setText("Avbryt");
				avbrytButton.setFont(new java.awt.Font("Tahoma",0,12));
				avbrytButton.addActionListener(this);
			}
			{
				lagreButton = new JButton();
				lagreButton.setText("Send ny innkallelse og lagre");
				lagreButton.setFont(new java.awt.Font("Tahoma",0,12));
				lagreButton.addActionListener(this);
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(nyttMoeteLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(thisLayout.createParallelGroup()
						.addComponent(muligeDeltakereScroll, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(leggTilDeltakerLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(thisLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
							.addComponent(deltakereLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(17))
						.addComponent(valgteDeltakere, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(fjernDeltakerButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(leggTilDeltakerButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(20))
					.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(datoField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(datoLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
					.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(headerTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(headerLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(thisLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(starttidCombo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(starttidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
							.addGap(0, 17, GroupLayout.PREFERRED_SIZE)
							.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(sluttidCombo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(slutttidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
					.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(Moeterom, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(moeteromLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(thisLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
							.addComponent(beskrivelseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29))
						.addComponent(beskrivelseTextArea, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(0, 23, GroupLayout.PREFERRED_SIZE)
					.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lagreButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(avbrytButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(avlysButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, 16));
			
			
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(thisLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
							.addComponent(lagreButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(avbrytButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGroup(thisLayout.createParallelGroup()
								.addGroup(thisLayout.createSequentialGroup()
										
									.addComponent(avlysButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 128, Short.MAX_VALUE))))
						.addGroup(thisLayout.createSequentialGroup()
							.addGroup(thisLayout.createParallelGroup()
								.addComponent(nyttMoeteLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(beskrivelseLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addGap(34))
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(moeteromLabel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(41))
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(slutttidLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(71))
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(starttidLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(63))
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(headerLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(63))
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(datoLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addGap(76))
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(deltakereLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(37))
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(leggTilDeltakerLabel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addGap(12)))
							.addGroup(thisLayout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(beskrivelseTextArea, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 244, Short.MAX_VALUE))
								.addGroup(thisLayout.createSequentialGroup()
									.addGroup(thisLayout.createParallelGroup()
										.addComponent(headerTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(Moeterom, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
											.addComponent(sluttidCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(19))
										.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
											.addComponent(starttidCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(19))
										.addComponent(datoField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
									.addGroup(thisLayout.createParallelGroup()
										.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
											.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
											.addGap(0, 13, Short.MAX_VALUE))
										.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
											.addPreferredGap(jLabel2, jLabel1, LayoutStyle.ComponentPlacement.INDENT)
											.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
											.addGap(0, 0, Short.MAX_VALUE))))
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(valgteDeltakere, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 255, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(muligeDeltakereScroll, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 255, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
									.addComponent(fjernDeltakerButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addComponent(leggTilDeltakerButton,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 272, Short.MAX_VALUE)))
							.addGap(7)))
					.addContainerGap(31, 31));
			
			pack();
			this.setSize(500, 670);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == fjernDeltakerButton){
			if(deltakereListModel.contains(deltakereList.getSelectedValue())){
				deltakereListModel.removeElement(deltakereList.getSelectedValue());
				
			}
		}
		else if(evt.getSource() == leggTilDeltakerButton){
		
			if(!deltakereListModel.contains(muligeDeltakereList.getSelectedValue())){
				
				deltakereListModel.addElement(muligeDeltakereList.getSelectedValue());
			}	
		}
		
		else if(evt.getSource() == lagreButton){
			
			if(!isValidDate(datoField.getText())){
				inValidDateMessage.setText("invalid date");
				overlappingMessage.setText("");
			}
			else if(overlapping()){
				inValidDateMessage.setText("");
				overlappingMessage.setText("overlappende møte");
			}
			else{
				changeMoete();
				dispose();
			}
			
		}
		else if(evt.getSource() == avbrytButton){
			dispose();
		}
		else if(evt.getSource() == avlysButton){
			slett slett = new slett(mainKal, mote);
			slett.setVisible(true);
		}
		else if(evt.getSource() == starttidCombo || evt.getSource() == sluttidCombo || evt.getSource() == datoField){
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

		int startTime = starttidCombo.getSelectedIndex()+timeIndexDiff;
		int sluttTime = sluttidCombo.getSelectedIndex()+timeIndexDiff+1;


		ArrayList<Avtale> avtaler = bruker.getAvtaler();

		for (int i = 0; i<avtaler.size(); i++) {


			if (mote==avtaler.get(i)) {}
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

	private void changeMoete() {

		mainKal.getKalenderPanelModel().removeAvtaleFromPanel(mote);

		String[] a = datoField.getText().split("\\.");

		int inDato = Integer.valueOf(a[0]);
		int inMnd = Integer.valueOf(a[1]);
		int inAar = Integer.valueOf(a[2]);

		int startTime = starttidCombo.getSelectedIndex()+timeIndexDiff;
		int sluttTime = sluttidCombo.getSelectedIndex()+timeIndexDiff+1;

		ArrayList<Avtale> avtaler = bruker.getAvtaler();
		
		Map<Person, Status> deltakere = new HashMap<Person, Status>();
		
		for (int i=0; i<deltakereListModel.size(); i++) {
			deltakere.put((Person)deltakereListModel.get(i), Status.IKKE_MOTTATT);
			
		}

	mote.update(startTime, sluttTime, inDato, inMnd, inAar, headerTextField.getText(), beskrivelseTextArea.getText(), 
			Moeterom.getSelectedItem()==noRom? null: (Rom)Moeterom.getSelectedItem(), deltakere);

		mainKal.getKalenderPanelModel().addAvtaleToPanel(mote);
		mainKal.getKalenderPanel().getInfoBoks().displayAvtale(mote); 

	}
	
	private boolean erLedig(Rom rom, boolean datoSatt){
		int romID = rom.getRomId();
		
		try{
			startTime = starttidCombo.getSelectedIndex()+timeIndexDiff;
			sluttTime = sluttidCombo.getSelectedIndex()+timeIndexDiff+1;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
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
		moeteromModel.removeAllElements();
		moeteromModel.addElement(noRom);
		for(Rom rom: romList){
			if(erLedig(rom, datoSatt)) moeteromModel.addElement(rom);
		}
	}
	

}
