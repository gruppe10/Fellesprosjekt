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
	private JScrollPane jScrollPane1;
	private JLabel leggTilDeltakerLabel;
	private JToggleButton deltakerButton;
	private JMenuItem jMenuItem1;
	private JComboBox Møterom;
	private JButton avbrytButton;
	private JButton lagreButton;
	private JLabel beskrivelseLabel;
	private JLabel moeteromLabel;
	private JLabel tidLabel;
	private JLabel deltakereLabel;
	private JLabel headerLabel;
	private JButton fjenDeltakerButton;
	private JTextField deltakerTextField;
	private JList deltakereList;
	private JTextArea beskrivelseTextArea;
	private JTextField tidTextField;
	private JTextField datoField;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				nyttMoete inst = new nyttMoete();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public nyttMoete() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				nyttMoeteLabel = new JLabel();
				nyttMoeteLabel.setText("Nytt møte");
				nyttMoeteLabel.setFont(new java.awt.Font("Tahoma",1,16));
			}
			{
				jScrollPane1 = new JScrollPane();
				{
					tidTextField = new JTextField();
					jScrollPane1.setViewportView(tidTextField);
					tidTextField.setText("Velg tid");
					tidTextField.setFont(new java.awt.Font("Tahoma",2,11));
					tidTextField.getText();
				}
			}
			{
				datoLabel = new JLabel();
				datoLabel.setText("Dato:");
				datoLabel.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				beskrivelseTextArea = new JTextArea();
				beskrivelseTextArea.setText("Beskrivelse av møte");
				beskrivelseTextArea.setFont(new java.awt.Font("Tahoma",2,11));
			}
			{
				deltakerTextField = new JTextField();
				deltakerTextField.setText("Deltaker");
				deltakerTextField.setFont(new java.awt.Font("Tahoma",2,11));
			}
			{
				fjenDeltakerButton = new JButton();
				fjenDeltakerButton.setText("Fjern deltaker");
				fjenDeltakerButton.setFont(new java.awt.Font("Tahoma",0,12));
				fjenDeltakerButton.addActionListener(this);
			}
			{
				ListModel deltakereListModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				deltakereList = new JList();
				deltakereList.setModel(deltakereListModel);
				deltakereList.setFont(new java.awt.Font("Tahoma",2,11));
			}
			{
				deltakerButton = new JToggleButton();
				deltakerButton.setText("Vis deltakeres kalendere");
				deltakerButton.setFont(new java.awt.Font("Tahoma",0,12));
				deltakerButton.addActionListener(this);
			}
			{
				ComboBoxModel MøteromModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				Møterom = new JComboBox();
				Møterom.setModel(MøteromModel);
				Møterom.setFont(new java.awt.Font("Tahoma",2,11));
				Møterom.setToolTipText("møterom");
				{
					jMenuItem1 = new JMenuItem();
					Møterom.add(jMenuItem1);
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
				tidLabel = new JLabel();
				tidLabel.setText("Tid:");
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
				datoField.setText("dd.mm.aaaa");
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
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(deltakerTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(leggTilDeltakerLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(deltakereList, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(16)
				        .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(deltakerButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
				            .addComponent(deltakereLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(fjenDeltakerButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(datoField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(datoLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(headerTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(headerLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(tidLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(Møterom, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(moeteromLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(beskrivelseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(29))
				    .addComponent(beskrivelseTextArea, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(lagreButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(avbrytButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(lagreButton, GroupLayout.Alignment.LEADING, 0, 169, Short.MAX_VALUE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(nyttMoeteLabel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 54, Short.MAX_VALUE)))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(avbrytButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				        .addGap(122))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(deltakereLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(moeteromLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(tidLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				                .addGap(51))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(headerLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
				                .addGap(38))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(datoLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				                .addGap(51)))
				        .addComponent(fjenDeltakerButton, 0, 107, Short.MAX_VALUE)
				        .addComponent(deltakerButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(leggTilDeltakerLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(beskrivelseLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
				                .addGap(9)))
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(beskrivelseTextArea, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(Møterom, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 40, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 36, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(headerTextField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 38, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(datoField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 38, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(deltakerTextField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 38, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(deltakereList, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 56, Short.MAX_VALUE)))
				        .addGap(167)))
				.addContainerGap());
			pack();
			this.setSize(400, 378);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == fjenDeltakerButton){
			//fjerne deltaker
		}
		else if(evt.getSource() == deltakerButton){
			kal kal = new kal();
			kal.show();
			hide();
			//vis deltakrens kalendere i din egen
		}
		else if(evt.getSource() == lagreButton){
			kal kal = new kal();
			kal.show();
			hide();
			//legg til i kalenderen
			//send møteinnkallelse
		}
		else if(evt.getSource() == avbrytButton){
			kal kal = new kal();
			kal.show();
			hide();
		}
		
	}

}
