package src;
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
public class endreMoete extends javax.swing.JFrame {
	private JButton fjenDeltakerButton;
	private JTextField datoField;
	private JTextField headerTextField;
	private JScrollPane jScrollPane1;
	private JMenuItem jMenuItem1;
	private JComboBox Møterom;
	private JToggleButton viskalenderButton;
	private JButton avlysButton;
	private JLabel leggTilDeltakerLabel;
	private JButton lagreButton;
	private JButton avbrytButton;
	private JLabel deltakereLabel;
	private JLabel beskrivelseLabel;
	private JLabel moeteromLabel;
	private JLabel tidLabel;
	private JLabel headerLabel;
	private JLabel datoLabel;
	private JLabel nyttMoeteLabel;
	private JList deltakereList;
	private JScrollPane jScrollPane3;
	private JTextField deltakerTextField;
	private JTextArea beskrivelseTextArea;
	private JTextField tidTextField;

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
				viskalenderButton = new JToggleButton();
				viskalenderButton.setText("Vis deltakeres kalendere");
				viskalenderButton.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				avlysButton = new JButton();
				avlysButton.setText("Avlys");
				avlysButton.setFont(new java.awt.Font("Tahoma",0,12));
			}
			{
				datoField = new JTextField();
				datoField.setText("dd.mm.aaaa");
				datoField.setFont(new java.awt.Font("Tahoma",2,11));
			}
			{
				headerTextField = new JTextField();
			}
			{
				jScrollPane1 = new JScrollPane();
				{
					tidTextField = new JTextField();
					jScrollPane1.setViewportView(tidTextField);
					tidTextField.setText("Velg tid");
					tidTextField.setFont(new java.awt.Font("Tahoma",2,11));
				}
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
			}
			{
				lagreButton = new JButton();
				lagreButton.setText("Send ny innkallelse og lagre");
				lagreButton.setFont(new java.awt.Font("Tahoma",0,12));
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(nyttMoeteLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(deltakerTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(leggTilDeltakerLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(viskalenderButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				    .addGroup(thisLayout.createSequentialGroup()
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(deltakereLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(19))
				            .addComponent(jScrollPane3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
				.addComponent(fjenDeltakerButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(datoField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(datoLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(headerTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(headerLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(tidLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(6))
				    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(Møterom, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(moeteromLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(beskrivelseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(29))
				    .addComponent(beskrivelseTextArea, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
				.addGap(0, 27, GroupLayout.PREFERRED_SIZE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(lagreButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(avbrytButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(avlysButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(37, 37));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(22, 22)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(lagreButton, 0, 169, Short.MAX_VALUE)
				        .addGap(208))
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
				                .addComponent(tidLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				                .addGap(76))
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
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(beskrivelseTextArea, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(fjenDeltakerButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                        .addGap(9)))
				                .addComponent(viskalenderButton, 0, 159, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(headerTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(datoField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(jScrollPane3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(deltakerTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(Møterom, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				                .addComponent(avbrytButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 30, Short.MAX_VALUE)
				                .addComponent(avlysButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				                .addGap(57))))));
			pack();
			this.setSize(407, 392);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
