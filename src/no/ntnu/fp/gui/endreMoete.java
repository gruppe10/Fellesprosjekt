package no.ntnu.fp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
	
	private JButton fjenDeltakerButton;
	private JTextField datoField;
	private JTextField headerTextField;
	private JMenuItem jMenuItem1;
	private JComboBox Moeterom;
	private JToggleButton viskalenderButton;
	private JLabel jLabel1;
	private JList deljList1;
	private JLabel sutLabel1;
	private JComboBox sutjComboBox1;
	private JComboBox stjComboBox1;
	private JButton avlysButton;
	private JLabel leggTilDeltakerLabel;
	private JButton lagreButton;
	private JButton avbrytButton;
	private JLabel deltakereLabel;
	private JLabel jLabel2;
	private JLabel beskrivelseLabel;
	private JLabel moeteromLabel;
	private JLabel tidLabel;
	private JLabel headerLabel;
	private JLabel datoLabel;
	private JLabel nyttMoeteLabel;
	private JList deltakereList;
	private JScrollPane jScrollPane3;
	private JTextArea beskrivelseTextArea;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				endreMoete inst = new endreMoete();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public endreMoete() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				fjenDeltakerButton = new JButton();
				fjenDeltakerButton.setText("Fjern deltaker");
				fjenDeltakerButton.setFont(new java.awt.Font("Tahoma",0,12));
				fjenDeltakerButton.addActionListener(this);
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
				ListModel deljList1Model = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				deljList1 = new JList();
				deljList1.setModel(deljList1Model);
			}
			{
				ComboBoxModel stjComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00" });
				stjComboBox1 = new JComboBox();
				stjComboBox1.setModel(stjComboBox1Model);
				stjComboBox1.getSelectedItem();
			}
			{
				ComboBoxModel sutjComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" });
				sutjComboBox1 = new JComboBox();
				sutjComboBox1.setModel(sutjComboBox1Model);
				sutjComboBox1.getSelectedItem();
			}
			{
				sutLabel1 = new JLabel();
				sutLabel1.setText("Sluttid:");
				sutLabel1.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				ComboBoxModel MøteromModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				Moeterom = new JComboBox();
				Moeterom.setModel(MøteromModel);
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
				viskalenderButton = new JToggleButton();
				viskalenderButton.setText("Vis deltakeres kalendere");
				viskalenderButton.setFont(new java.awt.Font("Tahoma",0,12));
				viskalenderButton.addActionListener(this);
			}
			{
				avlysButton = new JButton();
				avlysButton.setText("Avlys");
				avlysButton.setFont(new java.awt.Font("Tahoma",0,12));
				avlysButton.addActionListener(this);
			}
			{
				datoField = new JTextField();
				datoField.setText("dd.mm.aaaa");
				datoField.setFont(new java.awt.Font("Tahoma",2,11));
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
				jScrollPane3 = new JScrollPane();
				{
					ListModel deltakereListModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
					deltakereList = new JList();
					jScrollPane3.setViewportView(deltakereList);
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
				tidLabel = new JLabel();
				tidLabel.setText("Starttid:");
				tidLabel.setFont(new java.awt.Font("Tahoma",0,12));
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
				.addGap(16)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(leggTilDeltakerLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(25))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(deljList1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				        .addGap(8))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(0, 0, Short.MAX_VALUE)
				        .addComponent(viskalenderButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(deltakereLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(19))
				    .addComponent(jScrollPane3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(fjenDeltakerButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
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
				        .addComponent(stjComboBox1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(tidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(0, 17, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(sutjComboBox1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
				    .addComponent(sutLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
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
				                .addComponent(viskalenderButton, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(17)
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
				                .addComponent(sutLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(71))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(tidLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
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
				                        .addComponent(sutjComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                        .addGap(19))
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(stjComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
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
				                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 255, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(deljList1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 255, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(fjenDeltakerButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 272, Short.MAX_VALUE)))
				        .addGap(7)))
				.addContainerGap(31, 31));
			pack();
			this.setSize(554, 427);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == fjenDeltakerButton){
			//fjern deltaker fra listen av deltakere
		}
		else if(evt.getSource() == viskalenderButton){
			deltkal deltkal = new deltkal();
			deltkal.show();
			hide();
			//vise når de andre deltakere ikke har tid
		}
		else if(evt.getSource() == lagreButton){
			kal kal = new kal();
			kal.show();
			hide();
			//legge til i kalenderer
			//sende beskjed om endring til deltakere
		}
		else if(evt.getSource() == avbrytButton){
			kal kal = new kal();
			kal.show();
			hide();
		}
		else if(evt.getSource() == avlysButton){
			avlys avlys = new avlys();
			avlys.show();
			//fjerne fra kalenderene
			//gi beskjed til deltakrne
		}
	}

}
