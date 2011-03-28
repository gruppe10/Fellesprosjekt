package no.ntnu.fp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
public class avlysMoete extends javax.swing.JFrame implements ActionListener{
	
	private JLabel avlysMoete;
	private JPanel jPanel1;
	private JButton avbrytButton;
	private JButton meldAvbudButton;
	private JTextArea grunnTextArea;
	private JLabel grunnLabel;
	private JTextField tittelField;
	private JLabel tittelLabel;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				avlysMoete inst = new avlysMoete();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public avlysMoete() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				avlysMoete = new JLabel();
				avlysMoete.setText("Meld avbud på møte");
				avlysMoete.setFont(new java.awt.Font("Tahoma",1,16));
			}
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				{
					tittelLabel = new JLabel();
					tittelLabel.setText("Tittel:");
					tittelLabel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					tittelField = new JTextField();
					tittelField.setText("Tittel");
				}
				{
					grunnTextArea = new JTextArea();
					grunnTextArea.setText("Din grunn");
					grunnTextArea.setFont(new java.awt.Font("Tahoma",2,12));
				}
				{
					grunnLabel = new JLabel();
					grunnLabel.setText("Grunn:");
					grunnLabel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					meldAvbudButton = new JButton();
					meldAvbudButton.setText("Meld avbud");
					meldAvbudButton.setFont(new java.awt.Font("Tahoma",0,12));
					meldAvbudButton.addActionListener(this);
				}
				{
					avbrytButton = new JButton();
					avbrytButton.setText("Avbryt");
					avbrytButton.setFont(new java.awt.Font("Tahoma",0,12));
					avbrytButton.addActionListener(this);
				}
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(tittelField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tittelLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(16)
								.addGroup(jPanel1Layout.createParallelGroup()
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(grunnTextArea, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(grunnLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
														.addGap(27)
														.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(meldAvbudButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
																.addComponent(avbrytButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup()
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup()
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(grunnLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addComponent(tittelLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
																.addGroup(jPanel1Layout.createParallelGroup()
																		.addGroup(jPanel1Layout.createSequentialGroup()
																				.addComponent(tittelField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
																				.addGroup(jPanel1Layout.createSequentialGroup()
																						.addComponent(avbrytButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
																						.addGroup(jPanel1Layout.createSequentialGroup()
																								.addComponent(grunnTextArea, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))))
																								.addGroup(jPanel1Layout.createSequentialGroup()
																										.addComponent(meldAvbudButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))));
			}
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(12, 12)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(avlysMoete, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(17)
				        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(203, 203));
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(12, 12)
				.addComponent(avlysMoete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(12)
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(86, 86));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == meldAvbudButton){
			kal kal = new kal();
			kal.show();
			hide();
			//gi beskjed til møteleder om at man ikke kan delta
		}
		else if(evt.getSource() == avbrytButton){
			kal kal = new kal();
			kal.show();
			hide();
		}
		
	}

}
