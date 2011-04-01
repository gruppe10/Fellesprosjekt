package no.ntnu.fp.gui;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

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
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Person;

import java.text.SimpleDateFormat;
import java.text.ParseException;

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
public class nyAvtale extends javax.swing.JFrame implements ActionListener{
	private JLabel nyAvtaleLabel;
	private JLabel datoLabel;
	private JTextField headerTextField;
	private JLabel overlappingMessage;
	private JLabel inValidDateMessage;
	private JLabel romLabel1;
	private JComboBox romComboBox1;
	private JComboBox sluttid;
	private JComboBox starttid;
	private JButton avbrytButton;
	private JButton lagreButton;
	private JPanel jPanel1;
	private JTextArea jTextArea1;
	private JTextField datoField;
	private JLabel beskrivelseLabel;
	private JLabel sluttidLabel;
	private JLabel starttidLabel;
	private JLabel headerLabel;
	
	
	private int defaultStartTime, defaultDato, defaultMonth, defaultYear;
	private int timeIndexDiff=6;
	private kal mainKal;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				nyAvtale inst = new nyAvtale(null, 6, 31, 3, 2011);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public nyAvtale(kal kal, int dStartTime, int dDato, int dMonth, int dYear) {
		
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
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				{
					nyAvtaleLabel = new JLabel();
					nyAvtaleLabel.setText("Ny avtale");
					nyAvtaleLabel.setFont(new java.awt.Font("Tahoma",1,16));
				}
				{
					overlappingMessage = new JLabel();
					overlappingMessage.setText("b");
					overlappingMessage.setFont(new java.awt.Font("Tahoma",2,12));
				}
				{
					datoLabel = new JLabel();
					datoLabel.setText("Dato:");
					datoLabel.setFont(new java.awt.Font("Tahoma",0,12));
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
					inValidDateMessage = new JLabel();
					inValidDateMessage.setText("a");
					inValidDateMessage.setFont(new java.awt.Font("Tahoma",2,12));
				}
				{
					ComboBoxModel jComboBox1Model = 
						new DefaultComboBoxModel(
								new String[] { "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00" });
					
					starttid = new JComboBox();
					starttid.setModel(jComboBox1Model);
					starttid.getSelectedItem();
					starttid.setSelectedIndex((defaultStartTime-timeIndexDiff));
				}
				{
					ComboBoxModel jComboBox2Model = 
						new DefaultComboBoxModel(
								new String[] { "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" });

					
					sluttid = new JComboBox();
					sluttid.setModel(jComboBox2Model);
					sluttid.getSelectedItem();
					sluttid.setSelectedIndex((defaultStartTime-timeIndexDiff));
				}
				{
					jTextArea1 = new JTextArea();
					jTextArea1.setText("Skriv inn beskrivelse");
					jTextArea1.setFont(new java.awt.Font("Tahoma",2,11));
					jTextArea1.getText();
				}
				{
					headerTextField = new JTextField();
					headerTextField.getText();
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
					//do something
				}
				{
					lagreButton = new JButton();
					lagreButton.setText("Lagre");
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
					ComboBoxModel romComboBox1Model = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
					romComboBox1 = new JComboBox();
					romComboBox1.setModel(romComboBox1Model);
				}
				{
					romLabel1 = new JLabel();
					romLabel1.setText("Rom:");
					romLabel1.setFont(new java.awt.Font("Tahoma",0,12));
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup()
					.addGroup(jPanel1Layout.createSequentialGroup()
					    .addGroup(jPanel1Layout.createParallelGroup()
					        .addGroup(jPanel1Layout.createSequentialGroup()
					            .addGroup(jPanel1Layout.createParallelGroup()
					                .addComponent(sluttidLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					                .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                    .addComponent(datoLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					                    .addGap(17))
					                .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                    .addComponent(headerLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					                    .addGap(8))
					                .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                    .addComponent(starttidLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					                    .addGap(8))
					                .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                    .addComponent(romLabel1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					                    .addGap(31))
					                .addComponent(beskrivelseLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					            .addGroup(jPanel1Layout.createParallelGroup()
					                .addGroup(jPanel1Layout.createSequentialGroup()
					                    .addGroup(jPanel1Layout.createParallelGroup()
					                        .addComponent(starttid, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					                        .addComponent(sluttid, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					                    .addGroup(jPanel1Layout.createParallelGroup()
					                        .addGroup(jPanel1Layout.createSequentialGroup()
					                            .addComponent(avbrytButton, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					                            .addGap(0, 0, Short.MAX_VALUE))
					                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					                            .addComponent(overlappingMessage, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					                            .addGap(0, 34, Short.MAX_VALUE))))
					                .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                    .addGroup(jPanel1Layout.createParallelGroup()
					                        .addComponent(datoField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					                        .addComponent(romComboBox1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					                        .addComponent(headerTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					                    .addComponent(inValidDateMessage, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					                    .addGap(0, 8, Short.MAX_VALUE))
					                .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                    .addComponent(jTextArea1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					                    .addGap(0, 22, Short.MAX_VALUE))))
					        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					            .addComponent(nyAvtaleLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					            .addGap(0, 113, Short.MAX_VALUE)))
					    .addContainerGap(66, 66))
					.addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					    .addPreferredGap(datoLabel, lagreButton, LayoutStyle.ComponentPlacement.INDENT)
					    .addComponent(lagreButton, 0, 107, Short.MAX_VALUE)
					    .addContainerGap(149, 149)));
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addComponent(nyAvtaleLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(datoField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(inValidDateMessage, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(datoLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(headerTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(headerLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					        .addComponent(starttid, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addComponent(starttidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addGap(0, 13, Short.MAX_VALUE)
					        .addComponent(overlappingMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(sluttid, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(sluttidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(romComboBox1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(romLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(jTextArea1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(beskrivelseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(29)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(lagreButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(avbrytButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)));
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(20, 20)
				.addComponent(jPanel1, 0, 234, Short.MAX_VALUE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(25, 25)
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(99, Short.MAX_VALUE));
			pack();
			setSize(400, 300);
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
				addAvtale();
				hide();
			}
		}
		else if(evt.getSource() == avbrytButton){
			//kal kal = new kal();
			//kal.show();
			hide();
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
	
	private void addAvtale() {
		
		String[] a = datoField.getText().split("\\.");
		
		int inDato = Integer.valueOf(a[0]);
		int inMnd = Integer.valueOf(a[1]);
		int inAar = Integer.valueOf(a[2]);
		
		int startTime = starttid.getSelectedIndex()+timeIndexDiff;
		int sluttTime = sluttid.getSelectedIndex()+timeIndexDiff+1;
		
		
		Person person= mainKal.getConnectedPerson();
		ArrayList<Avtale> avtaler = person.getAvtaler();
		
		Avtale newAvtale= new Avtale(headerTextField.getText(),jTextArea1.getText(), person, startTime, sluttTime, inDato, inMnd, inAar);
		
		person.getAvtaler().add(newAvtale);
		
		mainKal.setConnectedPerson(person);
		
		mainKal.getKalenderPanelModel().addAvtaleToPanel(newAvtale);
		
		
		
		
	}




}
