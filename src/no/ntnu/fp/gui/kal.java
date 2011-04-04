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
	private JButton endreMoeteButton;
	private JLabel datoLabel1;
	private JLabel mndLabel1;
	private JLabel aarLabel;
	private JLabel mndLabel;
	private JLabel ukeLabel;
	private JButton hoeyreButton;
	private JButton vensteButton;
	private KalenderPanel kalenderPanel1;
	private KalenderPanelModel kalPanModel;
	private JScrollPane jScrollPane1;
	private JList jList1;
	private JButton nyAvtaleButton;
	private JLabel ulestLAbel;
	private JPanel jPanel1;
	private JButton avlysMoeteButton;
	private JButton nyttMoeteButton;
	private JButton sletteAvtaleButton;
	private JButton endreAvtaleButton;
	
	private Person person;
	
	private Calendar mainDate;
	
	private ArrayList<Avtale> avtaler;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		
		System.out.println("ss");
		
		
		
		
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
			
		System.out.println("ss");
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
				kalPanModel= new KalenderPanelModel(person, mainDate);
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
					endreMoeteButton = new JButton();
					endreMoeteButton.setText("Endre møte");
					endreMoeteButton.setFont(new java.awt.Font("Tahoma",0,12));
					endreMoeteButton.addActionListener(this);
				}
				{
					avlysMoeteButton = new JButton();
					avlysMoeteButton.setText("Avlys møte");
					avlysMoeteButton.setFont(new java.awt.Font("Tahoma",0,12));
					avlysMoeteButton.addActionListener(this);
				}
				{
					endreAvtaleButton = new JButton();
					endreAvtaleButton.setText("Endre avtale");
					endreAvtaleButton.setFont(new java.awt.Font("Tahoma",0,12));
					endreAvtaleButton.addActionListener(this);
				}
				{
					sletteAvtaleButton = new JButton();
					sletteAvtaleButton.setText("Slette avtale");
					sletteAvtaleButton.setFont(new java.awt.Font("Tahoma",0,12));
					sletteAvtaleButton.addActionListener(this);
				}
				{
					nyAvtaleButton = new JButton();
					nyAvtaleButton.setText("Ny avtale");
					nyAvtaleButton.setFont(new java.awt.Font("Tahoma",0,12));
					nyAvtaleButton.addActionListener(this);
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(sletteAvtaleButton, GroupLayout.Alignment.LEADING, 0, 110, Short.MAX_VALUE)
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup()
					        .addComponent(endreAvtaleButton, GroupLayout.Alignment.LEADING, 0, 101, Short.MAX_VALUE)
					        .addComponent(nyAvtaleButton, GroupLayout.Alignment.LEADING, 0, 101, Short.MAX_VALUE)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(nyttMoeteButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					    .addComponent(endreMoeteButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					    .addComponent(avlysMoeteButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)));
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(nyAvtaleButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					    .addComponent(nyttMoeteButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(endreMoeteButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(endreAvtaleButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(avlysMoeteButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(sletteAvtaleButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(56, 56));
			}
			{
				ulestLAbel = new JLabel();
				ulestLAbel.setText("Uleste meldinger:");
				ulestLAbel.setFont(new java.awt.Font("Tahoma",0,14));
			}
			{
				jScrollPane1 = new JScrollPane();
				{
					ListModel jList1Model = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
					jList1 = new JList();
					jScrollPane1.setViewportView(jList1);
					jList1.setModel(jList1Model);
					jList1.setPreferredSize(new java.awt.Dimension(155, 91));
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
				        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				        .addGap(37))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(vensteButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(ukeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(6))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(mndLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(6))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(aarLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(6))
				            .addComponent(hoeyreButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(mndLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(6))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(datoLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(kalenderPanel1, 0, 289, Short.MAX_VALUE)))
				.addContainerGap(32, 32));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jPanel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
				    .addGroup(thisLayout.createSequentialGroup()
				        .addPreferredGap(jPanel1, ulestLAbel, LayoutStyle.ComponentPlacement.INDENT)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(ulestLAbel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				                .addGap(65))
				            .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				        .addGap(32)))
				.addGap(37)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(kalenderPanel1, GroupLayout.Alignment.LEADING, 0, 680, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addPreferredGap(kalenderPanel1, datoLabel1, LayoutStyle.ComponentPlacement.INDENT)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(datoLabel1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				                .addGap(55)
				                .addComponent(mndLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
				                .addGap(36)
				                .addComponent(aarLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				                .addGap(94))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(21)
				                .addComponent(minKalenderLAbel, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
				        .addGap(36)
				        .addComponent(vensteButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				        .addGap(27)
				        .addComponent(ukeLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
				        .addGap(36)
				        .addComponent(mndLabel1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 36, Short.MAX_VALUE)
				        .addComponent(hoeyreButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				        .addGap(29)))
				.addContainerGap(37, 37));
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
		else if(evt.getSource() == endreAvtaleButton){
			endreAvtale endreAvtale = new endreAvtale(new Avtale());
			endreAvtale.show();
		}
		else if(evt.getSource() == endreMoeteButton){
			endreMoete endreMoete = new endreMoete();
			endreMoete.show();
		}
		else if(evt.getSource() == sletteAvtaleButton){
			slett slett = new slett();
			slett.show();
		}
		else if(evt.getSource() == avlysMoeteButton){
			avlysMoete avlysMoete = new avlysMoete();
			avlysMoete.show();
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
        	System.out.println("Test");
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

	
}
