package no.ntnu.fp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

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
public class meldAvbud extends javax.swing.JFrame implements ActionListener{
	private JPanel jPanel1;
	private JButton avbrytButton;
	private JButton SlettButton;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				meldAvbud inst = new meldAvbud();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public meldAvbud() {
		super();
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
					jLabel1 = new JLabel();
					jLabel1.setText("Er du sikker ?");
					jLabel1.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					SlettButton = new JButton();
					SlettButton.setText("Meld avbud");
					SlettButton.setFont(new java.awt.Font("Tahoma",0,12));
					SlettButton.addActionListener(this);
				}
				{
					avbrytButton = new JButton();
					avbrytButton.setText("Avbryt");
					avbrytButton.setFont(new java.awt.Font("Tahoma",0,12));
					avbrytButton.addActionListener(this);
				}
					jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addGap(6)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(SlettButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					        .addGap(7)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(avbrytButton, 0, 78, Short.MAX_VALUE)
					.addContainerGap());
					jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(avbrytButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					    .addComponent(SlettButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addContainerGap());
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(24, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(19, Short.MAX_VALUE));
			pack();
			this.setSize(246, 153);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == SlettButton){
			kal kal = new kal();
			kal.show();
			hide();
		// gi beskjed til møteleder
		}
		else if(evt.getSource() == avbrytButton){
			hide();
		}
	}

}
