package no.ntnu.fp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import Klient.Action;
import Klient.Envelope;
import Klient.KlientOS;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Status;
import no.ntnu.fp.model.Notis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


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
public class kal extends javax.swing.JFrame implements ActionListener {
	private JLabel minKalenderLAbel;
	private JLabel datoLabel1;
	private JLabel mndLabel1;
	private JLabel aarLabel;
	private JLabel mndLabel;
	private JLabel ukeLabel;
	private JButton hoeyreButton;
	private JButton vensteButton;
	private KalenderPanel kalenderPanel1;
	private KalenderPanelModel kalPanModel;
	private JScrollPane meldinger;
	private JList notiser;
	private JButton nyAvtaleButton;
	private JLabel ulestLAbel;
	private JPanel jPanel1;
	private JButton nyttMoeteButton;

	private Person person;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane1;
	private JList alleDeltakereList;
	private JButton leggtilButton1;
	private JList deltakerList;
	private JLabel deltakereLabel1;
	private JButton visDeltakereButton;
	private DefaultListModel leggetilDeltModel;
	private JLabel jLabel1;
	private JLabel ukLabel1;
	private JButton fjernButton;
	private JButton deltHendButton;
	private DefaultListModel deltakereModel;
	private DefaultListModel meldingerModel;
	
	private ArrayList<Person> mDeltakere;
	

	private Calendar mainDate;

	private ArrayList<Avtale> avtaler;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		 

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				kal inst = new kal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public kal() {
		super();
		mainDate=Calendar.getInstance();

		//test test
		person= new Person();
		ArrayList<Avtale> avtaler = new ArrayList<Avtale>();
		Avtale avtale1 = new Avtale();
		avtale1.setStarttid(10);
		avtale1.setSluttid(12);
		avtale1.setNavn("Lunsj");
		avtale1.setBeskrivelse("Lunsj");
		avtale1.setDato(13, 4, 2011);
		avtaler.add(avtale1);
		Avtale avtale2 = new Mote();
		avtale2.setStarttid(13);
		avtale2.setSluttid(16);
		avtale2.setNavn("Brunsj");
		avtale2.setBeskrivelse("Brunsj");
		avtale2.setDato(30, 3, 2011);
		avtaler.add(avtale2);
		person.setAvtaler(avtaler);

		initGUI();
	}

	public kal(Person bruker){
		super();
		mainDate=Calendar.getInstance();
		person=bruker;
		
		for(Avtale avtale: bruker.getAvtaler()){
			System.out.println(avtale.getNavn() + " "+ avtale.getDatoDag() +" "+ avtale.getDatoMnd()+" "+ avtale.getDatoAar());
		}
	
		updateInbox();
		
		avtaler = bruker.getAvtaler();
		
		KlientOS klient = KlientOS.getInstance();
		Envelope e = new Envelope(Action.SELECT, "getallpersons");
		mDeltakere=(ArrayList<Person>)klient.sendObjectAndGetResponse(e);
		
		initGUI();
	}


	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			GroupLayout thisLayout1 = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout1);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				minKalenderLAbel = new JLabel();
				minKalenderLAbel.setText("Min kalender");
				minKalenderLAbel.setFont(new java.awt.Font("Tahoma",1,16));
			}
			{
				visDeltakereButton = new JButton();
				visDeltakereButton.setText("Vis deltakeres hendelser");
				visDeltakereButton.setFont(new java.awt.Font("Tahoma",0,12));
				visDeltakereButton.setVisible(false);
				visDeltakereButton.addActionListener(this);
			}
			{
				deltakereLabel1 = new JLabel();
				deltakereLabel1.setText("Deltakere:");
				deltakereLabel1.setFont(new java.awt.Font("Tahoma",0,12));
				deltakereLabel1.setVisible(false);
			}
			{
				ukLabel1 = new JLabel();
				ukLabel1.setText("Uke: ");
			}
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Mnd:");
			}

			{
				jScrollPane1 = new JScrollPane();
				{
					deltakereModel = new DefaultListModel();
					deltakerList = new JList();
					jScrollPane1.setViewportView(deltakerList);
					deltakerList.setModel(deltakereModel);
					deltakerList.setFont(new java.awt.Font("Tahoma",2,11));
				}
				jScrollPane1.setVisible(false);
			}
			{
				leggtilButton1 = new JButton();
				leggtilButton1.setText("Legg til deltaker");
				leggtilButton1.setFont(new java.awt.Font("Tahoma",0,12));
				leggtilButton1.addActionListener(this);
				leggtilButton1.setVisible(false);
			}
			{
				fjernButton = new JButton();
				fjernButton.setText("Fjern deltaker");
				fjernButton.setFont(new java.awt.Font("Tahoma",0,12));
				fjernButton.setVisible(false);
				fjernButton.addActionListener(this);
			}
		
			
			
			{
				jScrollPane2 = new JScrollPane();
				{
					leggetilDeltModel = new DefaultListModel();
					alleDeltakereList = new JList();
					for (Person p : mDeltakere) {
						if(p != person) leggetilDeltModel.addElement(p); 
					}
					
					jScrollPane2.setViewportView(alleDeltakereList);
					alleDeltakereList.setModel(leggetilDeltModel);
					alleDeltakereList.setFont(new java.awt.Font("Tahoma",2,11));
		
				}
				jScrollPane2.setVisible(false);
			}
			{
				mndLabel1 = new JLabel();
				mndLabel1.setText("4");
				mndLabel1.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				datoLabel1 = new JLabel();
				datoLabel1.setText("Dag: "+(mainDate.get(Calendar.DAY_OF_MONTH)));
				datoLabel1.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				ukeLabel = new JLabel();
				ukeLabel.setText("14");
				ukeLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				mndLabel = new JLabel();
				mndLabel.setText("Mnd: "+(mainDate.get(Calendar.MONTH)+1));
				mndLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				aarLabel = new JLabel();
				aarLabel.setText("År: "+mainDate.get(Calendar.YEAR));
				aarLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				deltHendButton = new JButton();
				deltHendButton.setText("Andre deltakers hendelser");
				deltHendButton.setFont(new java.awt.Font("Tahoma",0,12));
				deltHendButton.addActionListener(this);
				deltHendButton.setVisible(true);
			}
			{
				vensteButton = new JButton();
				vensteButton.setText("<-");
			}
			{
				hoeyreButton = new JButton();
				hoeyreButton.setText("->");

			}
			//Test Test - Lager en ny person med avtaler


			{
				kalPanModel= new KalenderPanelModel(this, mainDate);
				kalenderPanel1 = new KalenderPanel(kalPanModel);
			}
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setVisible(true);
				{
					nyttMoeteButton = new JButton();
					nyttMoeteButton.setText("Nytt M\u00F8te");
					nyttMoeteButton.setFont(new java.awt.Font("Tahoma",0,12));
					nyttMoeteButton.addActionListener(this);
				}
				{
					nyAvtaleButton = new JButton();
					nyAvtaleButton.setText("Ny avtale");
					nyAvtaleButton.setFont(new java.awt.Font("Tahoma",0,12));
					nyAvtaleButton.addActionListener(this);
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
										.addComponent(nyttMoeteButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
										.addComponent(nyAvtaleButton, GroupLayout.Alignment.LEADING, 0, 113, Short.MAX_VALUE))
										.addGap(6));
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(nyAvtaleButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(nyttMoeteButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(83, Short.MAX_VALUE));
			}
			{
				ulestLAbel = new JLabel();
				ulestLAbel.setText("Uleste meldinger:");
				ulestLAbel.setFont(new java.awt.Font("Tahoma",0,14));
			}
			{
				meldinger = new JScrollPane();
				{
					meldingerModel = new DefaultListModel();
					notiser = new JList();
					notiser = new JList();
					meldinger.setViewportView(notiser);
					notiser.setModel(meldingerModel);
					notiser.setPreferredSize(new java.awt.Dimension(155, 91));
				}
			}
			thisLayout1.setVerticalGroup(thisLayout1.createSequentialGroup()
				.addGroup(thisLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(leggtilButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				    .addComponent(fjernButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				    .addComponent(visDeltakereButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				    .addComponent(deltakereLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
				.addGroup(thisLayout1.createParallelGroup()
				    .addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(minKalenderLAbel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout1.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout1.createSequentialGroup()
				        .addGroup(thisLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(vensteButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(aarLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(datoLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(mndLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(mndLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(ukeLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(hoeyreButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(ukLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(kalenderPanel1, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout1.createSequentialGroup()
				        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(ulestLAbel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(meldinger, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				        .addGap(85)))
				.addComponent(deltHendButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(142, Short.MAX_VALUE));
			thisLayout1.setHorizontalGroup(thisLayout1.createSequentialGroup()
				.addGroup(thisLayout1.createParallelGroup()
				    .addGroup(thisLayout1.createSequentialGroup()
				        .addGroup(thisLayout1.createParallelGroup()
				            .addComponent(leggtilButton1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				            .addComponent(fjernButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				            .addComponent(visDeltakereButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				            .addComponent(deltakereLabel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
				        .addGroup(thisLayout1.createParallelGroup()
				            .addComponent(deltHendButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout1.createSequentialGroup()
				                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
				                .addGap(45)))
				        .addGap(15))
				    .addGroup(thisLayout1.createSequentialGroup()
				        .addPreferredGap(deltHendButton, ulestLAbel, LayoutStyle.ComponentPlacement.INDENT)
				        .addGroup(thisLayout1.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout1.createSequentialGroup()
				                .addComponent(ulestLAbel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				                .addGap(69))
				            .addComponent(meldinger, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout1.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout1.createSequentialGroup()
				        .addComponent(datoLabel1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(thisLayout1.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout1.createSequentialGroup()
				                .addComponent(mndLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
				                .addGap(34)
				                .addComponent(aarLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addComponent(vensteButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				                .addGap(71))
				            .addComponent(minKalenderLAbel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
				        .addGap(0, 34, GroupLayout.PREFERRED_SIZE)
				        .addComponent(ukLabel1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				        .addComponent(ukeLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
				        .addComponent(mndLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(hoeyreButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
				        .addGap(238))
				    .addGroup(thisLayout1.createSequentialGroup()
				        .addComponent(kalenderPanel1, GroupLayout.PREFERRED_SIZE, 801, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap());
			pack();
			this.setSize(1030, 580);

			vensteButton.addActionListener(new venstreButtonAction());
			hoeyreButton.addActionListener(new hoeyreButtonAction());
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == nyAvtaleButton){
			nyAvtale nyAvtale = new nyAvtale(this, kalenderPanel1.getSelectedTime(), kalenderPanel1.getSelectedDato(), kalenderPanel1.getSelectedMonth(), kalenderPanel1.getSelectedYear());

			nyAvtale.setVisible(true);
		}
		else if(evt.getSource() == nyttMoeteButton){
			nyttMoete nyttMoete = new nyttMoete(this, kalenderPanel1.getSelectedTime(), kalenderPanel1.getSelectedDato(), kalenderPanel1.getSelectedMonth(), kalenderPanel1.getSelectedYear());
			nyttMoete.setVisible(true);
		}
		else if(evt.getSource() == deltHendButton){
			deltakereLabel1.setVisible(true);
			visDeltakereButton.setVisible(true);
			jScrollPane1.setVisible(true);
			leggtilButton1.setVisible(true);
			jScrollPane2.setVisible(true);
			fjernButton.setVisible(true);

		}
		else if(evt.getSource() == leggtilButton1){
			if(!deltakereModel.contains(alleDeltakereList.getSelectedValue())){
				deltakereModel.addElement(alleDeltakereList.getSelectedValue());
			}
		}
		else if (evt.getSource() == fjernButton){
			if(leggetilDeltModel.contains(deltakerList.getSelectedValue())){
				deltakereModel.removeElement(deltakerList.getSelectedValue());
			}
		}
		else if(evt.getSource() == visDeltakereButton){
			ArrayList<Person> fPersons = new ArrayList<Person>();
			for (int i = 0; i<deltakereModel.size(); i++) {
				fPersons.add((Person)deltakereModel.get(i));
				kalPanModel.morePersons(fPersons);
			}
		}
		


	}

	class venstreButtonAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainDate.add(Calendar.WEEK_OF_YEAR, -2);

			mndLabel1.setText(""+(mainDate.get(Calendar.MONTH)+1));
			ukeLabel.setText(""+(mainDate.get(Calendar.WEEK_OF_YEAR)));

			kalPanModel.newDate(mainDate);
			kalenderPanel1.getInfoBoks().clear();

		}
	}

	class hoeyreButtonAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainDate.add(Calendar.WEEK_OF_YEAR, 1);
			mainDate.add(Calendar.WEEK_OF_YEAR, -1); //wtf? well, if it works... <- Hahaha ^^,
			mndLabel1.setText(""+(mainDate.get(Calendar.MONTH)+1));
			ukeLabel.setText(""+(mainDate.get(Calendar.WEEK_OF_YEAR)));

			kalPanModel.newDate(mainDate);
			kalenderPanel1.getInfoBoks().clear();
		}
	}

	
	private void updateInbox() {
		ArrayList<Avtale> moter=person.getAvtaler();
		
		
		for (int i=0; i<moter.size(); i++) {
			Avtale a=moter.get(i);
			if (a instanceof Mote) {
				if (a.getInitiativtaker()!=person) {
					
					Mote current = (Mote)a;
					Status cStatus=current.getDeltakere().get(person);
					
					if (cStatus==Status.IKKE_MOTTATT) {
						Notis notis=new Notis(person, current, "invitasjon");
						meldingerModel.addElement(notis);
						
					}
				}
				else if (a.getInitiativtaker()==person) {
					Mote current = (Mote)a;
					
					ArrayList<Person> deltakere = new ArrayList<Person>();

					Map<Person, Status> deltakereMedStatus = current.getDeltakere();
					Iterator itEntry = deltakereMedStatus.entrySet().iterator();
					Iterator itKey = deltakereMedStatus.keySet().iterator();
					
					while (itEntry.hasNext()) {
						Status cStatus=(Status)itKey.next();
						Person deltaker = (Person)itEntry.next();
						
						if (cStatus==Status.AVSLATT) {
							Notis notis=new Notis(person, current, "meldtavbud", deltaker);
							meldingerModel.addElement(notis);
						}
					}
					
				}
		
			}
		}
		
	}
	
	public Person getConnectedPerson() {
		return person;
	}

	public void setConnectedPerson(Person p) {
		person=p;
	}

	public KalenderPanelModel getKalenderPanelModel() {
		return kalPanModel;
	}
	
	public KalenderPanel getKalenderPanel() {
		return kalenderPanel1;
	}



}
