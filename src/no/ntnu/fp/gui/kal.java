package no.ntnu.fp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
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

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Person;


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
	

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				minKalenderLAbel = new JLabel();
				minKalenderLAbel.setText("Min kalender");
				minKalenderLAbel.setFont(new java.awt.Font("Tahoma",1,16));
			}
			{
				mndLabel1 = new JLabel();
				mndLabel1.setText(""+(mainDate.get(Calendar.MONTH)+1));
				mndLabel1.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				datoLabel1 = new JLabel();
				datoLabel1.setText(""+(mainDate.get(Calendar.DAY_OF_MONTH)));
				datoLabel1.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				ukeLabel = new JLabel();
				ukeLabel.setText(""+(mainDate.get(Calendar.WEEK_OF_YEAR)));
				ukeLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				mndLabel = new JLabel();
				mndLabel.setText(""+(mainDate.get(Calendar.MONTH)+1));
				mndLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				aarLabel = new JLabel();
				aarLabel.setText(""+mainDate.get(Calendar.YEAR));
				aarLabel.setFont(new java.awt.Font("Tahoma",0,12));
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
					nyttMoeteButton.setText("Nytt Møte");
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
					ListModel jList1Model = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
					notiser = new JList();
					meldinger.setViewportView(notiser);
					notiser.setModel(jList1Model);
					notiser.setPreferredSize(new java.awt.Dimension(155, 91));
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(minKalenderLAbel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(12)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(ulestLAbel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 39, Short.MAX_VALUE)
				        .addComponent(meldinger, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				        .addGap(37))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(vensteButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(datoLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(mndLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(aarLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(mndLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(ukeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				            .addComponent(hoeyreButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(kalenderPanel1, 0, 289, Short.MAX_VALUE)))
				.addContainerGap(32, 32));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
				        .addGap(56))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addPreferredGap(jPanel1, ulestLAbel, LayoutStyle.ComponentPlacement.INDENT)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(ulestLAbel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				                .addGap(65))
				            .addComponent(meldinger, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))))
				.addGap(22)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(datoLabel1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				        .addGap(40)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(mndLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
				                .addGap(39)
				                .addComponent(aarLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				                .addGap(104)
				                .addComponent(vensteButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
				            .addComponent(minKalenderLAbel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
				        .addGap(30)
				        .addComponent(ukeLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(mndLabel1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
				        .addComponent(hoeyreButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 214, Short.MAX_VALUE))
				    .addComponent(kalenderPanel1, GroupLayout.Alignment.LEADING, 0, 752, Short.MAX_VALUE))
				.addContainerGap());
			pack();
			this.setSize(981, 431);
			
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
			
			nyAvtale.show();
		}
		else if(evt.getSource() == nyttMoeteButton){
			nyttMoete nyttMoete = new nyttMoete(this, kalenderPanel1.getSelectedTime(), kalenderPanel1.getSelectedDato(), kalenderPanel1.getSelectedMonth(), kalenderPanel1.getSelectedYear());
			nyttMoete.show();
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
        	mainDate.add(Calendar.WEEK_OF_YEAR, -1); //wtf? well, if it works...
        	mndLabel1.setText(""+(mainDate.get(Calendar.MONTH)+1));
        	ukeLabel.setText(""+(mainDate.get(Calendar.WEEK_OF_YEAR)));
        	
        	kalPanModel.newDate(mainDate);
        	kalenderPanel1.getInfoBoks().clear();
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
