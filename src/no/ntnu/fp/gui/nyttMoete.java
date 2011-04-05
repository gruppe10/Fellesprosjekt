package no.ntnu.fp.gui;

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
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
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
public class nyttMoete extends javax.swing.JFrame implements ActionListener{

	private JLabel nyttMoeteLabel;
	private JLabel datoLabel;
	private JTextField headerTextField;
	private JLabel leggTilDeltakerLabel;
	private JLabel overlappingMessage;
	private JLabel inValidDateMessage;
	private JButton visdelkalButton1;
	private JList leggetildeltList1;
	private JLabel sluttidLabel;
	private JComboBox sluttid;
	private JComboBox starttid;
	private JMenuItem jMenuItem1;
	private JComboBox Moeterom;
	private JButton avbrytButton;
	private JButton lagreButton;
	private JLabel beskrivelseLabel;
	private JLabel moeteromLabel;
	private JLabel starttidLabel;
	private JLabel deltakereLabel;
	private JLabel headerLabel;
	private JButton fjenDeltakerButton;
	private JList deltakereList;
	private JTextArea beskrivelseTextArea;
	private JTextField datoField;
	private Rom noRom;

	private int defaultStartTime, defaultDato, defaultMonth, defaultYear;
	private int timeIndexDiff=6;
	private kal mainKal;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				nyttMoete inst = new nyttMoete(null, 6, 31, 3, 2011);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public nyttMoete(kal kal, int dStartTime, int dDato, int dMonth, int dYear) {
		super();

		mainKal=kal;
		defaultStartTime = dStartTime;
		defaultDato = dDato;
		defaultMonth = dMonth;
		defaultYear = dYear;

		initGUI();
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				nyttMoeteLabel = new JLabel();
				nyttMoeteLabel.setText("Nytt moete");
				nyttMoeteLabel.setFont(new java.awt.Font("Tahoma",1,16));
			}
			{
				datoLabel = new JLabel();
				datoLabel.setText("Dato:");
				datoLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				beskrivelseTextArea = new JTextArea();
				beskrivelseTextArea.setText("Beskrivelse av moete");
				beskrivelseTextArea.setFont(new java.awt.Font("Tahoma",2,11));
				beskrivelseTextArea.getText();
			}
			{
				fjenDeltakerButton = new JButton();
				fjenDeltakerButton.setText("Fjern deltaker");
				fjenDeltakerButton.setFont(new java.awt.Font("Tahoma",0,12));
				fjenDeltakerButton.addActionListener(this);
			}
			{
				overlappingMessage = new JLabel();
				overlappingMessage.setText("");
				overlappingMessage.setFont(new java.awt.Font("Tahoma",2,12));
			}
			{
				inValidDateMessage = new JLabel();
				inValidDateMessage.setText("");
				inValidDateMessage.setFont(new java.awt.Font("Tahoma",2,12));
			}
			{
				visdelkalButton1 = new JButton();
				visdelkalButton1.setText("Vis deltakeres kalendere");
				visdelkalButton1.setFont(new java.awt.Font("Tahoma",0,12));
				visdelkalButton1.addActionListener(this);
			}
			{
				ListModel leggetildeltList1Model = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				leggetildeltList1 = new JList();
				leggetildeltList1.setModel(leggetildeltList1Model);
				//legge inn alle deltaker i databasen
			}
			{
				ComboBoxModel stComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00" });
				starttid = new JComboBox();
				starttid.setModel(stComboBox1Model);
				starttid.getSelectedItem();
			}
			{
				ComboBoxModel sutComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" });
				sluttid = new JComboBox();
				sluttid.setModel(sutComboBox1Model);
				sluttid.getSelectedItem();
			}
			{
				sluttidLabel = new JLabel();
				sluttidLabel.setText("Sluttid:");
				sluttidLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				ListModel deltakereListModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				deltakereList = new JList();
				deltakereList.setModel(deltakereListModel);
				deltakereList.setFont(new java.awt.Font("Tahoma",2,11));
				//skal fylles inn med de deltaker som blir valgt til dette moete
			}
			{
				
					//test test
					Rom rom1 = new Rom("a1");
					Rom rom2 = new Rom("a2");
					Rom rom3 = new Rom("a3");
			
				noRom = new Rom("None");
				ComboBoxModel MoeteromModel = 
					new DefaultComboBoxModel(
							new Rom[] { noRom, rom1, rom2, rom3});
				Moeterom = new JComboBox();
				Moeterom.setModel(MoeteromModel);
				Moeterom.setFont(new java.awt.Font("Tahoma",2,11));
				Moeterom.setToolTipText("moeterom");
				//liste over alle tilgjengelige moeterom i det gitte tidspunktet
				{
					jMenuItem1 = new JMenuItem();
					Moeterom.add(jMenuItem1);
					jMenuItem1.setText("jMenuItem1");
				}
			}
			{
				headerLabel = new JLabel();
				headerLabel.setText("Tittel:");
				headerLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				deltakereLabel = new JLabel();
				deltakereLabel.setText("Deltakere:");
				deltakereLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				starttidLabel = new JLabel();
				starttidLabel.setText("Starttid:");
				starttidLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				moeteromLabel = new JLabel();
				moeteromLabel.setText("Moeterom:");
				moeteromLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				beskrivelseLabel = new JLabel();
				beskrivelseLabel.setText("Beskrivelse:");
				beskrivelseLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				leggTilDeltakerLabel = new JLabel();
				leggTilDeltakerLabel.setText("Legg til deltaker:");
				leggTilDeltakerLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				lagreButton = new JButton();
				lagreButton.setText("Send innkallelse og lagre");
				lagreButton.setFont(new java.awt.Font("Tahoma",0,12));
				lagreButton.addActionListener(this);
			}
			{
				avbrytButton = new JButton();
				avbrytButton.setText("Avbryt");
				avbrytButton.setFont(new java.awt.Font("Tahoma",0,12));
				avbrytButton.addActionListener(this);
			}
			{
				datoField = new JTextField();
				if (defaultDato<10 && defaultMonth<10){
				datoField.setText("0"+defaultDato+".0"+defaultMonth+"."+defaultYear);
				}
				else if (defaultDato<10){
					datoField.setText("0"+defaultDato+"."+defaultMonth+"."+defaultYear);
				}
				else if (defaultMonth<10){
					datoField.setText(defaultDato+".0"+defaultMonth+"."+defaultYear);
				}
				else {
					datoField.setText(defaultDato+"."+defaultMonth+"."+defaultYear);
				}
				datoField.setFont(new java.awt.Font("Tahoma",2,11));
			}
			{
				headerTextField = new JTextField();
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(nyttMoeteLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(leggetildeltList1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(17)
				        .addComponent(leggTilDeltakerLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(deltakereLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(17))
				    .addComponent(deltakereList, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				    .addComponent(visdelkalButton1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(fjenDeltakerButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(datoField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(datoLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(10)
				        .addComponent(inValidDateMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(11)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(headerTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(headerLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(starttid, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(starttidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(0, 13, Short.MAX_VALUE)
				        .addComponent(overlappingMessage, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(sluttid, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(sluttidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(Moeterom, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(moeteromLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(beskrivelseTextArea, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(0, 11, GroupLayout.PREFERRED_SIZE)
				        .addComponent(beskrivelseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(18)))
				.addGap(0, 17, GroupLayout.PREFERRED_SIZE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(lagreButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(avbrytButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(29, 29));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(lagreButton, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
				        .addGap(9)
				        .addComponent(overlappingMessage, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 13, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(deltakereLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(moeteromLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(sluttidLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				                .addGap(30))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(starttidLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				                .addGap(30))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(headerLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
				                .addGap(38))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(datoLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				                .addGap(51)))
				        .addComponent(fjenDeltakerButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(inValidDateMessage, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 13, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addPreferredGap(inValidDateMessage, avbrytButton, LayoutStyle.ComponentPlacement.INDENT)
				                .addComponent(avbrytButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				                .addComponent(visdelkalButton1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(nyttMoeteLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(beskrivelseLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
				                .addGap(27))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(leggTilDeltakerLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				                .addGap(18)))
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(beskrivelseTextArea, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(Moeterom, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 77, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(sluttid, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 94, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(starttid, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 94, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(headerTextField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 75, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(datoField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 75, Short.MAX_VALUE))
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(deltakereList, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(leggetildeltList1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE)))
				        .addGap(196)))
				.addContainerGap(28, 28));
			pack();
			this.setSize(504, 453);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == fjenDeltakerButton){
			//			Kalle på this.slettDeltaker(deltaker)
			//fjerne deltaker
		}
		else if(evt.getSource() == visdelkalButton1){
			deltkal deltkal = new deltkal();
			deltkal.show();
			dispose();
			//vis deltakerens kalendere i din egen
		}
		else if(evt.getSource() == lagreButton){

			if (!isValidDate(datoField.getText())) {
				inValidDateMessage.setText("invalid date");
				overlappingMessage.setText("");
			}
			else if (overlapping()){
				inValidDateMessage.setText("");
				overlappingMessage.setText("overlappende avtale");
			}
			else {
				addMote();
				dispose();
			}
			String tittel = headerTextField.getText();
			String dato = datoField.getText();
			String starttid = starttid.getSelectedItem();
			String sluttid = sluttid.getSelectedItem();
			String rom = (String) Moeterom.getSelectedItem();
			String beskrivelse = beskrivelseTextArea.getText();
			
			String moeteInfo = tittel+","+dato+","+starttid+","+sluttid+","+rom+","+beskrivelse;
			
			Envelope toSend = new Envelope(Action.SELECT, moeteInfo);
			Object bruker = KlientOS.sendObjectAndGetResponse(toSend);
			
			//hvordan hente ut deltakere og sende innkallelse til de ?


		}
		else if(evt.getSource() == avbrytButton){
			kal kal = new kal();
			kal.show();
			dispose();
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
		return false;
	}
	
private void addMote() {
		
		String[] a = datoField.getText().split("\\.");
		
		int inDato = Integer.valueOf(a[0]);
		int inMnd = Integer.valueOf(a[1]);
		int inAar = Integer.valueOf(a[2]);
		
		int startTime = starttid.getSelectedIndex()+timeIndexDiff;
		int sluttTime = sluttid.getSelectedIndex()+timeIndexDiff+1;
		
		
		Person person= mainKal.getConnectedPerson();
		ArrayList<Avtale> avtaler = person.getAvtaler();
		
		
		if ((Rom)Moeterom.getSelectedItem()==noRom) {
			Mote newAvtale= new Mote(headerTextField.getText(),beskrivelseTextArea.getText(), person, startTime, sluttTime, inDato, inMnd, inAar, null, null);
			mainKal.getConnectedPerson().addAvtale(newAvtale);
			
			mainKal.setConnectedPerson(person);
			
			mainKal.getKalenderPanelModel().addAvtaleToPanel(newAvtale);
		}
		else {
			Mote newAvtale= new Mote(headerTextField.getText(),beskrivelseTextArea.getText(), person, startTime, sluttTime, inDato, inMnd, inAar, (Rom)Moeterom.getSelectedItem(), null);
			mainKal.getConnectedPerson().addAvtale(newAvtale);
			
			mainKal.setConnectedPerson(person);
			
			mainKal.getKalenderPanelModel().addAvtaleToPanel(newAvtale);
		}
		
		
		
		
		
	}

}
