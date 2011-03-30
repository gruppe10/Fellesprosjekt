package no.ntnu.fp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;

import javax.swing.GroupLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorListener;

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
public class innlogging extends javax.swing.JFrame implements ActionListener{

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JTextField brukernavnField;
	private JPasswordField passordField;
	private JPanel jPanel1;
	private JLabel brukernavnLabel;
	private JLabel passordLabel;
	private JLabel kalendersystemLabel;
	private JButton loggInnButton;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				innlogging inst = new innlogging();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	

	public innlogging() {
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
					brukernavnField = new JTextField();
					brukernavnField.setText("Skriv inn brukernavn");
					brukernavnField.setFont(new java.awt.Font("Tahoma",2,11));
					brukernavnField.getText();
				}
				{
					passordField = new JPasswordField();
					passordField.setText("Passord");
					passordField.getText();
				}
				{
					loggInnButton = new JButton();
					loggInnButton.setText("Logg inn");
					loggInnButton.setFont(new java.awt.Font("Tahoma",0,12));
					loggInnButton.addActionListener(this);
				}
				{
					brukernavnLabel = new JLabel();
					brukernavnLabel.setText("Brukernavn:");
					brukernavnLabel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					passordLabel = new JLabel();
					passordLabel.setText("Passord:");
					passordLabel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap(20, 20)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(brukernavnLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					    .addComponent(passordLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(loggInnButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 22, Short.MAX_VALUE))
					    .addComponent(brukernavnField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					    .addComponent(passordField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)));
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(brukernavnField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					    .addComponent(brukernavnLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(passordField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					    .addComponent(passordLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(0, 16, Short.MAX_VALUE)
					.addComponent(loggInnButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE));
			}
			{
				kalendersystemLabel = new JLabel();
				kalendersystemLabel.setText("Kalendersystem");
				kalendersystemLabel.setFont(new java.awt.Font("Tahoma",1,16));
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(27, 27)
				.addComponent(kalendersystemLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
				.addGap(35)
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(101, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(43, 43)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 16, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(66)
				        .addComponent(kalendersystemLabel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap(132, 132));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == loggInnButton){
			kal kal = new kal();
			kal.show();
			dispose();
		}
		
	}
	
}
